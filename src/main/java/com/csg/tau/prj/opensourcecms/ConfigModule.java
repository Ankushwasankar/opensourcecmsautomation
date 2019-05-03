package com.csg.tau.prj.opensourcecms;

/*import com.google.inject.AbstractModule;
import com.google.inject.Module;*/
/*import org.testng.ITestContext;
import org.testng.xml.XmlTest;*/

import java.util.List;
import java.util.Locale;
public class ConfigModule {}
/*public class ConfigModule extends AbstractModule {

    private AggregatedResourceBundle testngParams;
    private ConfigEnvironment env;
    private Class testClass;
    private ConfigProvider parent;
    private List<Module> guiceModules;

    public static final String ENVIRONMENT_NAME = "environment.name";
    public static final String ENVIRONMENT_DESCRIPTION = "environment.description";
    public static final String ENVIRONMENT_CODE = "environment.code";
    public static final String ENVIRONMENT_LOCALE = "environment.locale";

    public ConfigModule(ConfigEnvironment env,Class<?> testClass){
        this.env=env;
        this.testClass=testClass;
    }

    public ConfigModule(ConfigProvider parent,ConfigEnvironment env,Class<?>testClass,AggregatedResourceBundle params){
        this.env=env;
        this.testClass=testClass;
        testngParams=params;
        this.parent=parent;
    }

    public ConfigModule(ITestContext context,Class<?> testClass){
        XmlTest test = context.getCurrentXmlTest();
        String envName = test.getParameter(ENVIRONMENT_NAME);
        String envDesc = test.getParameter(ENVIRONMENT_DESCRIPTION);
        String envCode = test.getParameter(ENVIRONMENT_CODE);
        String envLocale = test.getParameter(ENVIRONMENT_LOCALE);
        Locale locale = null;
        if(envLocale != null){
            locale = Locale.forLanguageTag(envLocale);
        }
        if(envCode != null){
            env = new ConfigEnvironment(envName,envDesc,envCode,locale);
        }
        this.testClass=testClass;
        this.testngParams=new AggregatedResourceBundle();
        this.testngParams.mergeOverride(context.getCurrentXmlTest().getAllParameters());
    }

 protected void configure(){
        bind(ConfigProvider.class).toProvider(new ConfigModuleProvider(parent,env,testClass,testngParams)).setGuiceModules(guiceModules);
    }
}*/
