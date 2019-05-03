package com.csg.tau.prj.opensourcecms.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageResource {
/*
    private static final String CHARSET_ISO_8859_1="ISO-8859-1";
    private static final String UTF_8 = "UTF-8";
    private static ThreadLocal <ResourceBundle> resourceBundleHolder = new ThreadLocal<>();

    public static void loadMessageResource(Locale locale) {
//        File file = new File("test-classes" + file.seperator + "config" + file.seperator + "global");
        File file = new File("moduleSpecificTestConfig"+File.separator+"opensourcecms"+File.separator+"config"+File.separator+"Global");
        URL[]urls = null;
        try{
            urls = new URL[]{file.toURI().toURL()};
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        ClassLoader loader = new URLClassLoader(urls!=null?urls:new URL[0]);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config/global/message",locale,loader);
    }

    public static String getMessage(String key){
        try {
            String value = resourceBundleHolder.get().getString(key);
            return new String(value.getBytes(CHARSET_ISO_8859_1),(UTF_8));
        }catch (MissingResourceException ex){
            ex.printStackTrace();
            return '!'+ key + '!';
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return '!' + key + '!';
    }*/
}
