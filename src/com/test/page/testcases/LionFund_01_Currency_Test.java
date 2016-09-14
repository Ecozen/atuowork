package com.test.page.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.keydriver.engine.DefaultExecutor;
import com.test.keydriver.engine.Executor;

public class LionFund_01_Currency_Test extends TestBase{

	@Test
	public void currencyRedeemTest(){
		Executor excutor = new DefaultExecutor("data/currency_redeem.txt");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", "18061880762");
		params.put("pwd", "123123");
		params.put("amount", "1010");
		excutor.execute(params);
	}
	
	@Test(dependsOnMethods="currencyRedeemTest")
	public void currencyPurchaseTest(){
		Executor excutor = new DefaultExecutor("data/currency_purchase.txt");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("id", "13811111111");
		params.put("pwd", "123123");
		params.put("amount", "505");
		excutor.execute(params);
	}
}
