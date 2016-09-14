package com.test.page.source.main;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class LoginPage {

	private Locator locator;
	
	public LoginPage(WebDriver driver) {
		this.locator= new Locator(driver, "locator/Login");
	}

	private ExtendWebElement user_id;
	
	private ExtendWebElement user_pwd;
	
	private ExtendWebElement login_button;
	
	private ExtendWebElement select_icon;
	
	private ExtendWebElement login_list;
	
	private ExtendWebElement select_list;
	
	private ExtendWebElement cover;
	
	public ExtendWebElement getUser_id() {
		user_id=locator.getElement("user_id");
		return user_id;
	}

	public ExtendWebElement getUser_pwd() {
		user_pwd=locator.getElement("user_pwd");
		return user_pwd;
	}

	public ExtendWebElement getLogin_button() {
		login_button=locator.getElement("login_button");
		return login_button;
	}

	public ExtendWebElement getSelect_icon() {
		select_icon=locator.getElement("select_icon");
		return select_icon;
	}

	public ExtendWebElement getLogin_list() {
		login_list=locator.getElement("login_list");
		return login_list;
	}

	public ExtendWebElement getSelect_list() {
		select_list = locator.getElement("select_list");
		return select_list;
	}

	public ExtendWebElement getCover() {
		cover = locator.getElement("cover");
		return cover;
	}
	
	
	
/*
	public IndexPage login(String id,String pwd){
		ElementAction.click(select_icon);
		sleep(1);
		ElementAction.selectByTag(login_list,"li","0");
		sleep(1);
		ElementAction.type(user_id, id);
		ElementAction.type(user_pwd, pwd);
		ElementAction.click(login_button);
		sleep(1);
		WebDriver driver =(WebDriver) DriverManager.MANAGER.get("driver");
		return new IndexPage(driver);
	}
*/

}
