package com.test.page.source.main;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;
@KeyObject
public class MyAssetPageHelper extends PageHelper {
	private WebDriver driver;
	private MyAssetPage myAssetPage;
	public MyAssetPageHelper(WebDriver driver) {
		this.driver = driver;
		myAssetPage = new MyAssetPage(driver);
		setWebDriver(driver);
	}
	
	/**
	 * @Description 进入现金宝账户
	 */
	@KeyMethod("进入现金宝账户")
	public void toCurrencyAssetsPage(Map<String, Object> params){
		sleep(5);
		myAssetPage.getCurrency_assets().click();
	}
	/**
	 * @Description 立即充值
	 */
	@KeyMethod("点击立即充值")
	public void currencyPurchasePage(Map<String, Object> params){
		sleep(5);
		myAssetPage.getCurrency_purchase().click();
	}
	/**
	 * @Description 快速取现
	 */
	@KeyMethod("点击快速取现")
	public void currencyRedeemPage(Map<String, Object> params){
		sleep(5);
		myAssetPage.getCurrency_redeem().click();
	}
}
