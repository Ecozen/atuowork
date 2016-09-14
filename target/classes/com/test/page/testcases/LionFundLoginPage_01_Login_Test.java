package com.test.page.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.keydriver.engine.DefaultExecutor;
import com.test.keydriver.engine.Executor;
/**
 * 
 * @author wxiang.zheng
 *
 */
public class LionFundLoginPage_01_Login_Test extends TestBase {

	@Test(dataProvider="testMethodDataProvider")
	public void loginTest(Map<String,String> map){
		Executor excutor = new DefaultExecutor("");
		excutor.execute(map.get("id"),map.get("pwd"));
	}
	
}
