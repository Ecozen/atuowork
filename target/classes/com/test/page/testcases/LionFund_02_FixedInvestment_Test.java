package com.test.page.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.keydriver.engine.DefaultExecutor;
import com.test.keydriver.engine.Executor;


public class LionFund_02_FixedInvestment_Test extends TestBase{

	@Test(dataProvider="excelDataProvider")
	public void addFixedTest(Map<String, String> params){
		Executor excutor = new DefaultExecutor("data/add_fixed.txt");
		excutor.execute(params);
	}
	@Test(dependsOnMethods="addFixedTest",dataProvider="excelDataProvider")
	public void editFixedTest(Map<String, String> params){
		Executor excutor = new DefaultExecutor("data/edit_fixed.txt");
		excutor.execute(params);
	}
	
	@Test(dependsOnMethods="editFixedTest",dataProvider="excelDataProvider")
	public void pauseFixedTest(Map<String, String> params){
		Executor excutor = new DefaultExecutor("data/pause_fixed.txt");
		excutor.execute(params);
	}
}
