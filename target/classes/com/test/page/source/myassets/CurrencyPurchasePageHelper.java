package com.test.page.source.myassets;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;

@KeyObject
public class CurrencyPurchasePageHelper extends PageHelper {
	private CurrencyPurchasePage currencyPurchasePage;

	public CurrencyPurchasePageHelper(WebDriver driver) {
		currencyPurchasePage = new CurrencyPurchasePage(driver);
		setWebDriver(driver);
	}

	@KeyMethod("现金宝充值")
	public void currencyPurchase(Map<String,Object> params){
		sleep(5);
		currencyPurchasePage.getFound_source().click();//点击资金来源
		sleep(1);
		currencyPurchasePage.getAccount_list().getElement(By.className("transactionsAccount"), 1).click();//选择资金来源
		sleep(1);
		currencyPurchasePage.getApply_amount().clear();
		currencyPurchasePage.getApply_amount().type((String)params.get("amount"));
		sleep(1);
		currencyPurchasePage.getTradePwd().clear();
		currencyPurchasePage.getTradePwd().type((String)params.get("pwd"));
		sleep(1);
		currencyPurchasePage.getComfirm_btn().click();
	}
	
}
