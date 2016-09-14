package com.test.page.source.newbankcard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class AddCardPage_1{

	private Locator locator;
	public AddCardPage_1(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAccount");
	}

	private ExtendWebElement id_message;
	
	private ExtendWebElement list_message;
	
	private ExtendWebElement go_back;
	
	private ExtendWebElement get_verify_code;
	
	private ExtendWebElement go_step2;

	
	public ExtendWebElement getId_message() {
		id_message = locator.getElement("id_message");
		return id_message;
	}
	public ExtendWebElement getList_message() {
		list_message = locator.getElement("list_message");
		return list_message;
	}
	public ExtendWebElement getGo_back() {
		go_back = locator.getElement("go_back");
		return go_back;
	}
	public ExtendWebElement getGet_verify_code() {
		get_verify_code = locator.getElement("get_verify_code");
		return get_verify_code;
	}
	public ExtendWebElement getGo_step2() {
		go_step2 = locator.getElement("go_step2");
		return go_step2;
	}

	WebElement name;
	WebElement id;
	WebElement bank_name;
	WebElement bank_account;
	WebElement mobile_no;
	WebElement verify_code;
	WebElement bank_list;
	
	/*
	public TradePwdPage step2(String bankAccount,String phone_no){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		waitElementDisplay(driver, By.className("cover"),false);
		init();
		ElementAction.click(bank_name);
		bank_list=driver.findElement(By.id("bank_list"));
		ElementAction.selectByIndex(bank_list, "a", 0);
//		ElementAction.click(go_back);
		ElementAction.type(bank_account, bankAccount);
		ElementAction.type(mobile_no, phone_no);
		ElementAction.click(get_verify_code);
		waitElementDisplay(driver, By.className("cover"),false);
		sleep(30);
		ElementAction.click(go_step2);
		return new TradePwdPage(driver);
	}
	
	private void init(){
		name = id_message.findElement(By.cssSelector("li:nth-child(1) > div"));
		id = id_message.findElement(By.cssSelector("li:nth-child(2) > div"));
		bank_name=list_message.findElement(By.cssSelector("li:nth-child(1) > div"));
		bank_account=list_message.findElement(By.id("bankAccount"));
		mobile_no=list_message.findElement(By.id("mobileNo"));
		verify_code=list_message.findElement(By.cssSelector("li:nth-child(4) > div"));
	}
	*/
}
