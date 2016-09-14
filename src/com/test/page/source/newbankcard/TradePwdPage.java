package com.test.page.source.newbankcard;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class TradePwdPage {

	private Locator locator;
	public TradePwdPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAccount");
	}

	private ExtendWebElement trade_pwd;

	private ExtendWebElement confirm_btn;
	
	public ExtendWebElement getTrade_pwd() {
		trade_pwd = locator.getElement("trade_pwd");
		return trade_pwd;
	}

	public ExtendWebElement getConfirm_btn() {
		confirm_btn = locator.getElement("confirm_btn");
		return confirm_btn;
	}
	
	
	/*	
	public AddCardSuccessPage step3(String password){
	WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
	waitElementDisplay(driver, By.className("cover"), false);
	ElementAction.type(trade_pwd, password);
	sleep(1);
	ElementAction.click(confirm_btn);
	pwdFormatCheck(driver,password);
	waitElementDisplay(driver, By.className("cover"), false);
	return new AddCardSuccessPage(driver);
	}

	
	private void pwdFormatCheck(WebDriver driver,String password){
		if(password.length()!=6){
			String confirm_txt="请输入6-8位正确格式交易密码";
			By locator_content =By.className("dialog-content");
			if (elementIsVisible(driver, locator_content)) {
				WebElement dialog_content = driver.findElement(locator_content);
				String acctual_txt = dialog_content.findElement(By.className("dialog-detail-m")).getText();
				if(!confirm_txt.equals(acctual_txt)){
					System.out.println("判断异常:"+acctual_txt);
				}
				dialog_content.findElement(By.linkText("确定")).click();
				waitElementDisplay(driver, By.className("cover"), false);
			}
		}
	}
	*/		
}
