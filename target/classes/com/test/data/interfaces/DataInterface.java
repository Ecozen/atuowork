package com.test.data.interfaces;

import java.util.List;
import java.util.Map;

public interface DataInterface {
	public List<Map<String, String>> getTestMethodData();
	public List<Map<String, String>> getTestMethodData(String path);
}
