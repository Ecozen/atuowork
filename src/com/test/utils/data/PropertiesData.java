package com.test.utils.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.data.interfaces.DataInterface;
import com.test.utils.PropertiesHandler;

public class PropertiesData implements DataInterface{
	/**
	 * 
	 * @return List of data
	 */
    public List<Map<String, String>> getTestMethodData(){
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(PropertiesHandler.getPropertyData("file/data.properties"));
        return list;
    }
    
}
