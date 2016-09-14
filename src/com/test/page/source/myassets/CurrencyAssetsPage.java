package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class CurrencyAssetsPage {

	private Locator locator;
	public CurrencyAssetsPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAsset");
	}

	private ExtendWebElement tradeList_query;
	
	private ExtendWebElement currencyRedeem_btn;
	
	private ExtendWebElement currencyPurchase_btn;
	
	public ExtendWebElement getTradeList_query() {
		tradeList_query = locator.getElement("tradeList_query");
		return tradeList_query;
	}

	public ExtendWebElement getCurrencyRedeem_btn() {
		currencyRedeem_btn = locator.getElement("currencyPurchase_btn");
		return currencyRedeem_btn;
	}

	public ExtendWebElement getCurrencyPurchase_btn() {
		currencyPurchase_btn = locator.getElement("currencyPurchase_btn");
		return currencyPurchase_btn;
	}
	
	
/*	
	public TradeQueryPage tradeListQuery(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		ElementAction.click(tradeList_query);
		waitElementDisplay(driver, By.className("cover"), false);
		return new TradeQueryPage(driver);
	}
	
	public CurrencyRedeemPage currencyRedeem(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		ElementAction.click(currencyRedeem_btn);
		waitElementDisplay(driver, By.className("cover"), false);
		return new CurrencyRedeemPage(driver);
	}
	
	public CurrencyPurchasePage currencyPurchase(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		ElementAction.click(currencyPurchase_btn);
		waitElementDisplay(driver, By.className("cover"), false);
		return new CurrencyPurchasePage(driver);
	}
*/
}
