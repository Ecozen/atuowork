package com.test.utils;

import java.util.Map;

public class Config {
    public static String DATA_SOURCE;
    private static Map<String, String> map;
    static{
        map = PropertiesHandler.getPropertyData("config/config.properties");
        DATA_SOURCE = map.get("DataSource");
    }

	public static String getConfig(String key) {
		return map.get(key);
	}
	
	public static String getConfig(String configPath,String key){
		Map<String, String> map = PropertiesHandler.getPropertyData(configPath);
		if(map.containsKey(key)){
			return map.get(key);
		}
		return null;
	}
}
