package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesHandler {
    private static Properties loadPropertiesFile(String filePath){
        Properties p = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(new File(filePath));
            p.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return p;
    }
     
    /**
     * 将property转换成Map
     * @param filePath
     * @return map of the properties
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String, String> getPropertyData(String filePath){
        try{
            return new HashMap<String, String>((Map)PropertiesHandler.loadPropertiesFile(filePath));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new HashMap<String, String>();
    }
     
}
