package com.test.utils.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.test.data.interfaces.DataInterface;
import com.test.utils.TxtUtil;

public class TxtData implements DataInterface {

	@Override
	public List<Map<String, String>> getTestMethodData() {
        return getTestMethodData("file/data.txt");
	}

	@SuppressWarnings("serial")
	@Override
	public List<Map<String, String>> getTestMethodData(String path) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String data = TxtUtil.readTxtFile(path, "utf-8");
        Gson gson = new Gson();
        Map<String, String> dataMap = gson.fromJson(data, new TypeToken<Map<String, String>>(){}.getType());
        list.add(dataMap);
        return list;
	}

}
