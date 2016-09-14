package com.test.page.source.newbankcard;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class AddCardSuccessPage{

	private Locator locator;
	public AddCardSuccessPage(WebDriver driver) {
		this.locator =  new Locator(driver,"locator/myAccount");
	}

	private ExtendWebElement strade_btn;
	
	public ExtendWebElement getStrade_btn() {
		strade_btn = locator.getElement("strade_btn");
		return strade_btn;
	}
	
	
/*	
	public IndexPage step4(){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		ElementAction.click(strade_btn);
		return new IndexPage(driver);
	}
*/
}
