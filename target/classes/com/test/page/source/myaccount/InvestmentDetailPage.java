package com.test.page.source.myaccount;

import org.openqa.selenium.WebDriver;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class InvestmentDetailPage {

	private Locator locator;
	
	public InvestmentDetailPage(WebDriver driver){
		this.locator = new Locator(driver);
	}
	
	private ExtendWebElement box;
	private ExtendWebElement pause;
	private ExtendWebElement edit;
	
	private ExtendWebElement pause_pwd;
	private ExtendWebElement cancel_btn;
	private ExtendWebElement confirm_btn;
	
	
	
}
