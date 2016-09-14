package com.test.utils.data;

import java.util.List;
import java.util.Map;

import com.test.data.interfaces.DataInterface;
import com.test.utils.ExcelUtil;

public class ExcelData implements DataInterface{

	@Override
	public List<Map<String, String>> getTestMethodData() {
		List<Map<String, String>> list = new ExcelUtil("file/data.xlsx", "data").getMapData();
		return list;
	}

}
