package com.test.keydriver.annotation;

import java.lang.reflect.Method;
import java.util.Iterator;

import com.test.data.constance.KeywordReflect;
import com.test.data.constance.RegisterCenter;

public class AutoMethod {
    public void setMethodAnnotation(){
        Iterator<String> it = RegisterCenter.OBJ_POOLS.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            try {              
                Class<?> c = RegisterCenter.OBJ_POOLS.get(key).getClass();              
                Method[] methods = c.getDeclaredMethods();
                for (Method method : methods) {
                	method.setAccessible(true);
                    if(method.isAnnotationPresent(KeyMethod.class)){
                    	KeyMethod km = method.getAnnotation(KeyMethod.class);
                    	KeywordReflect.KEYWORD_POOLS.put(km.value(), KeywordReflect.methodInfo(c.getName(), method.getName()));
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }      
    }  
     
    public void setMethodAnnotation(Object o) {
        try {              
            Class<?> c = o.getClass();               
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
            	method.setAccessible(true);
                if(method.isAnnotationPresent(KeyMethod.class)){
                	KeyMethod km = method.getAnnotation(KeyMethod.class);
                	KeywordReflect.KEYWORD_POOLS.put(km.value(), KeywordReflect.methodInfo(c.getName(), method.getName()));
                }
            }  
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
