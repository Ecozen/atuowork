package com.test.page.source.main;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;

@KeyObject
public class MyAccountPageHelper extends PageHelper{

	private WebDriver driver;
	private MyAccountPage myAccountPage;
	public MyAccountPageHelper(WebDriver driver) {
		this.driver = driver;
		myAccountPage = new MyAccountPage(driver);
		setWebDriver(driver);
	}
	
	@KeyMethod("点击我的银行卡")
	public void toMyBankCard(Map<String,Object> params){
		waitForPageLoading(20);
		myAccountPage.getBank_card_manage().click();
	}
	
	@KeyMethod("点击我的定投")
	public void toFixedInvestment(Map<String,Object> params){
		waitForPageLoading(20);
		myAccountPage.getFixed_investment().click();
	}
}
