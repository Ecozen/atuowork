package com.test.page.source.main;

import org.openqa.selenium.WebDriver;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;
/**
 * 我的资产
 * @author zhengwenxiang
 *
 */
public class MyAssetPage {

	private Locator locator;
	public MyAssetPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAsset");
	}


	//现金宝部分
	private ExtendWebElement currency_assets;
	private ExtendWebElement currency_edeem;
	private ExtendWebElement currency_purchase;
	
	/**
	 * @Description 现金宝详情
	 * @return
	 */
	public ExtendWebElement getCurrency_assets() {
		currency_assets = locator.getElement("currency_assets");
		return currency_assets;
	}
	/**
	 * @Description 现金宝取现
	 * @return
	 */
	public ExtendWebElement getCurrency_redeem() {
		currency_edeem = locator.getElement("currency_edeem");
		return currency_edeem;
	}
	/**
	 * @Description 现金宝充值
	 * @return
	 */
	public ExtendWebElement getCurrency_purchase() {
		currency_purchase = locator.getElement("currency_purchase");
		return currency_purchase;
	}
	
	
	/*
	public CurrencyAssetsPage currencyAssets(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		waitElementDisplay(driver, By.className("cover"), false);
		ElementAction.click(currency_assets);
		waitElementDisplay(driver, By.className("cover"), false);
		return new CurrencyAssetsPage(driver);
	}
	
	public CurrencyRedeemPage currencyRedeem(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		waitElementDisplay(driver, By.className("cover"), false);
		ElementAction.click(currency_edeem);
		waitElementDisplay(driver, By.className("cover"), false);
		return new CurrencyRedeemPage(driver);
	}
	
	public CurrencyPurchasePage currencyPurchase(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		waitElementDisplay(driver, By.className("cover"), false);
		ElementAction.click(currency_purchase);
		waitElementDisplay(driver, By.className("cover"), false);
		return new CurrencyPurchasePage(driver);
	}
	 */
}
