package com.test.page.source.myaccount;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class BankCardManagePage {

	private Locator locator;
	public BankCardManagePage(WebDriver driver) {
		this.locator=new Locator(driver, "locator/myAccount");
	}


	private ExtendWebElement bank_card_list;
	
	private ExtendWebElement add_bank_card;
	
	
	public ExtendWebElement getBank_card_list() {
		bank_card_list = locator.getElement("bank_card_list");
		return bank_card_list;
	}

	public ExtendWebElement getAdd_bank_card() {
		add_bank_card = locator.getElement("add_bank_card");
		return add_bank_card;
	}
	
	
	/*
	public AddCardPage_1 addBankCard(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		waitElementDispear(driver, By.className("cover"));
		ElementAction.click(add_bank_card);
		return new AddCardPage_1(driver);
	}
	*/
	
}
