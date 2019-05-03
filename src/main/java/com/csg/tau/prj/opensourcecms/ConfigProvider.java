package com.csg.tau.prj.opensourcecms;

/*import com.google.inject.Injector;
import com.google.inject.Module;*/
import org.apache.commons.exec.OS;
/*import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class ConfigProvider {
/*

    private static final Logger Log = LogManager.getLogger(ConfigProvider.class);

    private ConfigProvider parentConfig;
    private ConfigEnvironment environment;
    private String clazz;
    private List<Module> guiceModules;

    public static final String CONFIG_BASE_FOLDER = "config";
    public static final String CONFIG_GLOBAL_BASE_FOLDER = "global";
    public static final String CONFIG_CLASS_FOLDER = "class";
    public static final String CONFIG_OS_FOLDER = "os";

    public static final String CONFIG_BASE_FOLDER_SYSTEM_KEY = "configBaseDirectory";

    private AggregatedResourceBundle propsGlobal, prosEnv, prosEnvClass,prosGlobalClass,prosGlobal, prosTestNG, prosCusotomClass, prosOS;
    private Map<String, Object> obj;
    private Properties systemProperties;

    private propertyFileResolver PropertyFileResolver;

    private String configBaseFolder, configGlobalBaseFolder, configEnvironmentBaseFolder;

    public static FilenameFilter propertiesFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            if (
                    name.matches("^([a-zA-Z0-9.-]*\\.properties)$")
                    ) return true;
            else return false;
        }
    };

    public ConfigProvider(ConfigEnvironment environment,Class clazz){
        this(null,environment,clazz,null);
    };
    public ConfigProvider(ConfigProvider parent,ConfigEnvironment environment,Class clazz,AggregatedResourceBundle testngParams){
        this(parent,environment,clazz,testngParams,System.getProperties());
    }
    public ConfigProvider(ConfigProvider toCopy){
        this.guiceModules=toCopy.guiceModules;
        this.parentConfig=toCopy.parentConfig;
        this.environment=toCopy.environment;
        this.clazz=toCopy.clazz;
        this.prosTestNG=toCopy.prosTestNG!=null?new AggregatedResourceBundle(toCopy.prosTestNG):null;
        this.prosOS=toCopy.prosOS!=null?new AggregatedResourceBundle(toCopy.prosOS):null;
        this.prosCusotomClass=toCopy.prosCusotomClass!=null?new AggregatedResourceBundle(toCopy.prosCusotomClass):null;
        this.prosEnvClass=toCopy.prosEnvClass!=null?new AggregatedResourceBundle(toCopy.prosEnvClass):null;
        this.prosGlobalClass=toCopy.prosEnvClass!=null?new AggregatedResourceBundle(toCopy.prosGlobalClass):null;
        this.prosEnv=toCopy.prosEnvClass!=null?new AggregatedResourceBundle(toCopy.prosEnv):null;
        this.prosGlobal=toCopy.prosEnvClass!=null?new AggregatedResourceBundle(toCopy.prosGlobal):null;
        this.systemProperties=toCopy.systemProperties;
        this.propertyFileresolver=toCopy.propertyFileresolver;
        this.configBaseFolder=toCopy.configBaseFolder;
        this.configGlobalBaseFolder=toCopy.configGlobalBaseFolder;
        this.configEnvironmentBaseFolder=toCopy.configEnvironmentBaseFolder;
        this.obj=toCopy.obj;
    };
    public ConfigProvider(ConfigProvider parent,ConfigEnvironment environment,Class clazz,AggregatedResourceBundle testngParams,Properties systemProperties){
        this.systemProperties=systemProperties;
        this.parentConfig=parent;
        this.environment=environment;
        this.configBaseFolder=systemProperties.getProperty(CONFIG_BASE_FOLDER_SYSTEM_KEY,CONFIG_BASE_FOLDER);

        ClassConfig classConfig = (ClassConfig) clazz.getAnnotations(ClassConfig.class);
        if(classConfig!=null && classConfig.value().length!=0)
        {
            this.clazz=classConfig.value()[0].getSimpleName();
        }
        else if(classConfig != null && !classConfig.filename().contentEquals(""))
        {
            this.clazz=classConfig.filename().replace("properties","");
        }
        else this.clazz=clazz.getSimpleName();
        loadProperties();
        prosTestNG=testngParams;
    };
    private void loadProperties(){};
    private static void mergeOverride(String propertypath,ConfigEnvironment environment,AggregatedResourceBundle bundle){};

    private String getDetectedOS(){
        if(OS.isFamilyWindows()){return "windows";}
        else if(OS.isFamilyUnix()){return "Unix";}
        else if(OS.isFamilyMac()){return "Mac";}
        else {return null;}
    }

    public ConfigEnvironment getEnvironment() {
        return environment;
    }

    public String getClazz(){return clazz;}

    public String get(String key){return getRequired(key);}

    public String getOptional(String key){return get(key,null);}

    public String get(String key,String defaultValue){}

    public String getRequired(String key) throws noSuchElementException{
        if(contains(key))
            return get(key,null);
        else
            throw new noSuchElementException("Key ["+key+"] does not exit");
    }

    public boolean contains(String key){
        if(parentConfig!=null && parentConfig.contains(key)) return true;
        if(systemProperties!=null && systemProperties.containsKey(key)) return true;
        if(prosTestNG!=null && prosTestNG.containsKey(key)) return true;
        if(prosOS!=null && prosOS.containsKey(key)) return true;
        if(prosCusotomClass!=null && prosCusotomClass.containsKey(key)) return true;
        if(prosEnvClass!=null && prosEnvClass.containsKey(key)) return true;
        if(prosGlobalClass!=null && prosGlobalClass.containsKey(key)) return true;
        if(prosEnv!=null && prosEnv.containsKey(key)) return true;
        if(prosGlobal!=null && prosGlobal.containsKey(key)) return true;
        return false;
    }

    public void loadCustomClassproperties(Properties custom){
        if(prosCusotomClass==null) prosCusotomClass = new AggregatedResourceBundle();
        prosCusotomClass.mergeOverride(custom);
    }

    public void loadCustomClassproperties(String propertyFilename) {
        if (StingUtils.isBlank(propertyFilename)) {
            throw new IllegalArgumentException("Provided propertyFilename must not be balnk.");
        }
        propertyFilename = StringUtils.removeEnd(propertyFilename, ".properties");
        boolean found = false;

        //Load global class properties
        if (configGlobalBaseFolder != null && PropertyFileResolver.findAllBasePropertyFilenames(configGlobalBaseFolder + "/" + CONFIG_CLASS_FOLDER).contains(propertyFilename)){
            prosGlobalClass = prosGlobalClass == null ? new AggregatedResourceBundle() : prosGlobalClass;
        mergeOverride(configBaseFolder + "." + CONFIG_GLOBAL_BASE_FOLDER + "." + CONFIG_CLASS_FOLDER + "." + propertyFilename, environment, propsGlobal);
        found = true;
        }

        //Load environment class properties
        if (configEnvironmentBaseFolder != null && propertyFilename != null && PropertyFileResolver.findAllBasePropertyFilenames(configEnvironmentBaseFolder + "/" + CONFIG_CLASS_FOLDER).contains(propertyFilename)){
            prosEnvClass = prosEnvClass == null ? new AggregatedResourceBundle() : prosEnvClass;
        mergeOverride(configBaseFolder + "." + environment.getCode() + "." + CONFIG_CLASS_FOLDER + "." + propertyFilename, environment, prosEnvClass);
        found = true;
        }

        if(!found){
            throw new IllegalArgumentException("Provided named property file name has not found: "+propertyFilename);
        }
    }

    public void logAvailableProperties(){
        if(parentConfig!=null){
            Log.info("Parent property start.");
            parentConfig.logAvailableProperties();
            Log.info("Parent property end.");
        }
        logProperties("TestNG parameters",prosTestNG);
        logProperties("OS",prosOS);
        logProperties("Custom class",prosCusotomClass);
        if(environment!=null) logProperties("Environment class",prosEnvClass);
        logProperties("Global Class",prosGlobalClass);
        if(environment!=null) logProperties("Environment", prosEnv);
        logProperties("Global",prosGlobal);
        logProperties("System",systemProperties);
    }

    private void logProperties(String title,Properties props){
        if(props==null)return;
        Log.info("CM properties available from: "+title);
        for(String key : props.stringPropertyNames())
            Log.info("\tKey["+key+"], value ['"+props.getProperty(key)+"]");
    }

    private void logProperties(String title,AggregatedResourceBundle props){
        if(props==null)return;
        Log.info("CM properties available from: "+title);
        for(String key : props.keySet())
            Log.info("\tKey["+key+"], value ['"+props.getString(key)+"]");
    }

    public List<Module> getGuiceModules(){
        if(parentConfig==null){
            List<Module> modules = parentConfig.getGuiceModules();
            modules.addAll(guiceModules);
            return modules;
        }else if(guiceModules!= null) {
            return guiceModules;
        }else {
            return new ArrayList<Module>();
        }
    }

    public ConfigProvider addGuiceModule(Module... modules){
        if(guiceModules==null){
            guiceModules=new ArrayList<Module>(Arrays.asList(modules));
        }else {
            guiceModules.addAll(Arrays.asList(modules));
        }
        return this;
    }

    public ConfigProvider addGuiceModule(List<Module> modules){
        if(guiceModules==null){
            guiceModules=modules;
        }else {
            guiceModules.addAll(modules);
        }
        return this;
    }

    public ConfigProvider addUberGuiceModule(List<Module> modules){
        if(parentConfig == null){
            addGuiceModule(modules);
        }else{
            parentConfig.addUberGuiceModule(modules);
        }
        return this;
    }

    public void addObj(String key,Object o){
        if(obj == null) obj = new ConcurrentHashMap<String,Object>();
        obj.put(key, o);
    }

    public void addUberObj(String key,Object o){
        if(parentConfig != null) parentConfig.addUberObj(key,o);
        if(obj==null) obj = new ConcurrentHashMap<String,Object>();
        obj.put(key,o);
    }

    public Object getObj(String key){
        if(obj != null && obj.containsKey(key)) return obj.get(key);
        if(obj!=null)return parentConfig.getObj(key);
        return null;
    }

    public <T> T create(Class<T> type,Module... modules){
        List<Module> mList = new ArrayList<Module>(Arrays.asList(modules));
        mList.addAll(getGuiceModules());
        mList.add(new ConfigModule(this,environment,type,prosTestNG));
        Injector injector = com.google.inject.Guice.createInjector(mList);
        return injector.getInstance(type);
    }
*/

}
