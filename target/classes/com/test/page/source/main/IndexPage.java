package com.test.page.source.main;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class IndexPage {

	private Locator locator;
	
	public IndexPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/index");
	}

	private ExtendWebElement footer;
	private ExtendWebElement my_account;
	private ExtendWebElement my_assert;
	private ExtendWebElement fund_list;

	public ExtendWebElement getFooter() {
		footer = locator.getElement("footer");
		return footer;
	}
	public ExtendWebElement getMy_account() {
		my_account = locator.getElement("my_account");
		return my_account;
	}
	public ExtendWebElement getMy_assert() {
		my_assert = locator.getElement("my_assert");
		return my_assert;
	}
	public ExtendWebElement getFund_list() {
		fund_list = locator.getElement("fund_list");
		return fund_list;
	}
	
	
}
