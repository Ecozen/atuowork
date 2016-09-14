package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;

public class CurrencyAssetsPageHelper {
	private WebDriver driver;
	private CurrencyAssetsPage currencyAssetsPage;
	public CurrencyAssetsPageHelper(WebDriver driver) {
		this.driver = driver;
		this.currencyAssetsPage = new CurrencyAssetsPage(driver);
	}
	
	public void getCurrencyAssetsPage(){
		
	}
}
