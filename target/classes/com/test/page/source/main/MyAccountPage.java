package com.test.page.source.main;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;
/**
 * 我的账户（个人中心）
 * @author wenxiang.zheng
 *
 */
public class MyAccountPage {

	Locator locator;
	public MyAccountPage(WebDriver driver) {
		this.locator= new Locator(driver, "locator/myAccount");
	}


	private ExtendWebElement bank_card_manage;

	private ExtendWebElement fixed_investment;

	/**
	 * @Description 我的银行卡
	 * @return
	 */
	public ExtendWebElement getBank_card_manage() {
		bank_card_manage = locator.getElement("bank_card_manage");
		return bank_card_manage;
	}

	/**
	 * @Description 我的定投
	 * @return
	 */
	public ExtendWebElement getFixed_investment() {
		fixed_investment = locator.getElement("fixed_investment");
		return fixed_investment;
	}
	
	
/*	
	public BankCardManagePage bankCardManage(){
		WebDriver driver =(WebDriver) DriverManager.MANAGER.get("driver");
		waitElementDisplay(driver, By.className("cover"),false);
		ElementAction.click(bank_card_manage);
		sleep(1);
		return new BankCardManagePage(driver);
	}
	
	public FixedInvestmentPage fixedInvestment(){
		ElementAction.click(fixed_investment);
		sleep(1);
		WebDriver driver =(WebDriver) DriverManager.MANAGER.get("driver");
		return new FixedInvestmentPage(driver);
	}
	
*/
}
