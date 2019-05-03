package com.csg.tau.prj.opensourcecms;

import java.util.*;
public class AggregatedResourceBundle {
//public class AggregatedResourceBundle extends ResourceBundle {
/*

    private final Map<String,Object> contents = new HashMap<String, Object>();

    public AggregatedResourceBundle(List<ResourceBundle> bundles){
        if(bundles !=null){
            for(ResourceBundle bundle : bundles){
                mergeOverride(bundle);
            }
        }
    }

    public AggregatedResourceBundle(){}

    public AggregatedResourceBundle(AggregatedResourceBundle toCopy){
        if(toCopy !=null && toCopy.contents!=null){
            this.contents.putAll(toCopy.contents);
        }
    }

    public Enumeration<String> getKeys(){return new IteratorEnumeration<String> (contents.keySet().iterator());}

    public synchronized void mergeOverride(ResourceBundle bundle){
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()){
            String onekey = keys.nextElement();
            contents.put(onekey,bundle.getObject(onekey));
        }
    }

    public boolean containsKey(String key){return contents.containsKey(key);}

    public Set<String> keySet(){return contents.keySet();}

    protected Object handleGetObject(String key){
        return contents.get(key);
    }

    public synchronized void mergeOverride(Map<String,String> params){contents.putAll(params);}

    public synchronized void mergeOverride(Properties props){
        for(String key: props.stringPropertyNames()){
            contents.put(key,props.getProperty(key));
        }
    }

    private static class IteratorEnumeration<T> implements Enumeration<T>{

        private final Iterator<T> source;

        public IteratorEnumeration(Iterator<T>source){
            if(source==null){
                throw new IllegalArgumentException("Source must not be null");
            }
            this.source=source;
        }

        public boolean hasMoreElements(){
            return source.hasNext();
        }

        public T nextElement(){
            return source.next();
        }
    }
*/

}
