package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class TradeDetailPage {

	Locator locator;
	public TradeDetailPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAsset");
	}

	ExtendWebElement trade_form;
	
	
	public ExtendWebElement getTrade_form() {
		trade_form = locator.getElement("trade_form");
		return trade_form;
	}


	public void checkDetail(){
		
	}
}
