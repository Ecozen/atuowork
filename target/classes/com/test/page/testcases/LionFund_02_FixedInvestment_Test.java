package com.test.page.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.keydriver.engine.DefaultExecutor;
import com.test.keydriver.engine.Executor;

public class LionFund_02_FixedInvestment_Test extends TestBase{

	public void addFixedTest(){
		Executor excutor = new DefaultExecutor("data/add_fixed.txt");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", "18061880762");
		params.put("pwd", "123123");
		params.put("fundCode", "001208");
		params.put("amount", "201");
		params.put("cycle", "每周");
		params.put("date", "周二");
		excutor.execute(params);
	}
	
	public void editFixedTest(){
		Executor excutor = new DefaultExecutor("data/edit_fixed.txt");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", "18061880762");
		params.put("pwd", "123123");
		params.put("fundCode", "320003");
		params.put("amount", "399");
		params.put("cycle", "每周");
		params.put("date", "周四");
		excutor.execute(params);
	}
	
	@Test
	public void pauseFixedTest(){
		Executor excutor = new DefaultExecutor("data/pause_fixed.txt");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", "18061880762");
		params.put("pwd", "123123");
		params.put("fundCode", "320003");
		params.put("amount", "399");
		params.put("cycle", "每周");
		params.put("date", "周四");
		excutor.execute(params);
	}
}
