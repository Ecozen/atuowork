package com.test.page.source.myassets;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;

@KeyObject
public class CurrencyRedeemPageHelper extends PageHelper{
	
	private CurrencyRedeemPage currencyRedeemPage;
	public CurrencyRedeemPageHelper(WebDriver driver) {
		this.currencyRedeemPage = new CurrencyRedeemPage(driver);
		setWebDriver(driver);
	}

	@KeyMethod("现金宝取现")
	public void redeem(Map<String,Object> params){
		sleep(5);
		System.out.println("-----------------开始现金宝取现-----------------");
		currencyRedeemPage.getFundAccount_select().click();
		sleep(1);
		currencyRedeemPage.getSelect_Account().getElement(By.tagName("li"), 0).click();;
		sleep(1);
		currencyRedeemPage.getRedeem_amount().clear();
		currencyRedeemPage.getRedeem_amount().type((String)params.get("amount"));
		sleep(1);
		currencyRedeemPage.getTrade_pwd().clear();
		currencyRedeemPage.getTrade_pwd().type((String)params.get("pwd"));
		sleep(1);
		currencyRedeemPage.getComfirm_btn().click();
	}
}
