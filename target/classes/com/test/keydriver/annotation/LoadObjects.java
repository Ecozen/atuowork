package com.test.keydriver.annotation;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.test.data.constance.RegisterCenter;

public class LoadObjects {
    public final String basePath = "com.test";
    
    private final String binPath = "target/test-classes";
     
    private List<String> allClass = new ArrayList<String>();   
     
    private WebDriver driver;  
     
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
 
    public void loadAllPage(){     
        this.listAllFiles(binPath+File.separator+basePath.replace(".","/"));
        this.getPageInstance();
    }
     
    private void listAllFiles(String path){
        path = path.replace("\\", "/");
        File file = new File(path);
        if(file.isFile() && file.getName().endsWith(".class")){
            String filePath = file.getPath().replace("\\", "/");           
            int startIndex = binPath.length()+1;
            int endIndex = filePath.lastIndexOf(".class");
            allClass.add(filePath.substring(startIndex, endIndex).replace("/", "."));              
        }else if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                this.listAllFiles(f.getPath());
            }
        }
    }
     
    private void getPageInstance(){
        for (String clazz : allClass) {
            try {              
                Class<?> c = Class.forName(clazz);               
                if(c.isAnnotationPresent(KeyObject.class)){
                    Constructor<?> cons = c.getConstructor(WebDriver.class);                 
                    RegisterCenter.OBJ_POOLS.put(c.getName(), cons.newInstance(driver));
                }
            } catch (ClassNotFoundException e) {               
                e.printStackTrace();
            } catch (InstantiationException e) {               
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }  

}
