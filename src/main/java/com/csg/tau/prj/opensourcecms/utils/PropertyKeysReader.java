package com.csg.tau.prj.opensourcecms.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyKeysReader {

    public String value;
    //public String key = "open.source.cms.app.url";

    public PropertyKeysReader(String key) throws IOException {

        FileReader reader= null;

        try {
            reader = new FileReader("C:\\Users\\ankus\\Desktop\\src\\moduleSpecificTestConfig\\opensourcecms\\config\\Global\\TA-poc.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties p=new Properties();
        p.load(reader);
        value = p.getProperty(key);
    }
}
