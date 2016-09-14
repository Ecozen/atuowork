package com.test.page.source;

import org.openqa.selenium.WebDriver;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class IndexPage {

	protected ExtendWebElement baidu_input;
	
	protected ExtendWebElement baidu_button;
	Locator locator;
	public IndexPage(WebDriver driver){
		locator = new Locator(driver, "locator/demo");
	}

	public ExtendWebElement getBaidu_input() {
		baidu_input = locator.getElement("baidu_input");
		return baidu_input;
	}

	public ExtendWebElement getBaidu_button() {
		baidu_button = locator.getElement("baidu_button");
		return baidu_button;
	}
	
	
}
