package com.test.data.constance;

import java.util.HashMap;
import java.util.Map;

public class KeywordReflect {
	public static Map<String, Map<String, String>> KEYWORD_POOLS = new HashMap<String, Map<String, String>>();
    
    public static Map<String, String> methodInfo(String className, String methodName){
        Map<String, String> methodInfo = new HashMap<String, String>();
        methodInfo.put("class", className);
        methodInfo.put("method", methodName);
        return methodInfo;
    }
}
