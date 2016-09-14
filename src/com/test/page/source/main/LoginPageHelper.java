package com.test.page.source.main;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;
/**
 * 
 * @author wenxiang.zheng
 *
 */
@KeyObject
public class LoginPageHelper extends PageHelper{

	private LoginPage login;
	private WebDriver driver;
	public LoginPageHelper(WebDriver driver){
		this.driver = driver;
		this.login = new LoginPage(driver);
	}
	/**
	 * @author wenxiang.zheng
	 * @param id
	 * @param pwd
	 */
	@KeyMethod("循环登录测试")
	public void login(Map<String, Object> params){
		setWebDriver(driver);
		getPage("登录");
		login.getSelect_icon().click();
		login.getSelect_list().getElement(By.tagName("li"), "value", "0").click();
		sleep(1);
//		login.getSelect_list().waitElementDisappeared(driver);
		login.getUser_id().clear();
		login.getUser_id().type((String)params.get("id"));
		login.getUser_pwd().clear();
		login.getUser_pwd().type((String)params.get("pwd"));
		login.getLogin_button().click();
		sleep(10);
		try {
			if (isDispaly(By.className("cover"))) {
				driver.findElement(By.linkText("确定")).click();
			}
			sleep(10);
			isTextCorrect(driver.getTitle(), "诺安基金");
			
		} catch (Exception e) {
			get("http://192.168.0.108:8090/lion-trade/h/logout.action");
			sleep(5);
			return;
		}
			get("http://192.168.0.108:8090/lion-trade/h/logout.action");
			sleep(5);
		
	}
	
	/**
	 * @Description wap页面登录
	 * @param id
	 * @param pwd
	 */
	@KeyMethod("登录诺安基金")
	public void loginAccount(Map<String, Object> params){
		setWebDriver(driver);
		getPage("登录");
		login.getSelect_icon().click();
		login.getSelect_list().getElement(By.tagName("li"), "value", "0").click();
		sleep(1);
		login.getUser_id().clear();
		login.getUser_id().type((String)params.get("id"));
		login.getUser_pwd().clear();
		login.getUser_pwd().type((String)params.get("pwd"));
		login.getLogin_button().click();
		sleep(5);
		isTextCorrect(driver.getTitle(), "诺安基金");
	}
	
	private void getPage(String title){
		String expect = driver.getTitle();
		if(!expect.equals(title)){
			System.out.println("--------重新登录---------");
			get("http://192.168.0.108:8090/lion-trade/h/login.action");
		}
	}
}
