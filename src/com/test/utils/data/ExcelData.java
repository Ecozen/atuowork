package com.test.utils.data;

import java.util.List;
import java.util.Map;

import com.test.data.interfaces.DataInterface;
import com.test.utils.ExcelUtil;

public class ExcelData implements DataInterface{

	@Override
	public List<Map<String, String>> getTestMethodData() {
		return getTestMethodData("file/data.xlsx");
	}

	@Override
	public List<Map<String, String>> getTestMethodData(String path) {
		return getTestMethodData(path, "data");
	}
	
	public List<Map<String, String>> getTestMethodData(String path,String sheetName) {
		List<Map<String, String>> list = new ExcelUtil(path, sheetName).getMapData();
		return list;
	}

}
