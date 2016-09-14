package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class CurrencyRedeemPage {

	private Locator locator;
	public CurrencyRedeemPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAsset");
	}

	private ExtendWebElement fundAccount_select;
	
	private ExtendWebElement available_balance;
	
	private ExtendWebElement redeem_amount;
	
	private ExtendWebElement redeem_all;
	
	private ExtendWebElement trade_pwd;

	private ExtendWebElement comfirm_btn;
	
	private ExtendWebElement select_Account;
	/**
	 * @Description 取现到
	 * @return
	 */
	public ExtendWebElement getFundAccount_select() {
		fundAccount_select = locator.getElement("fundAccount_select");
		return fundAccount_select;
	}

	/**
	 * @Description 可用余额
	 * @return
	 */
	public ExtendWebElement getAvailable_balance() {
		available_balance = locator.getElement("available_balance");
		return available_balance;
	}

	/**
	 * @Description 取现金额
	 * @return
	 */
	public ExtendWebElement getRedeem_amount() {
		redeem_amount = locator.getElement("redeem_amount");
		return redeem_amount;
	}

	/**
	 * @Description 全部取现
	 * @return
	 */
	public ExtendWebElement getRedeem_all() {
		redeem_all = locator.getElement("redeem_all");
		return redeem_all;
	}

	/**
	 * @Description 交易密码
	 * @return
	 */
	public ExtendWebElement getTrade_pwd() {
		trade_pwd = locator.getElement("trade_pwd");
		return trade_pwd;
	}

	/**
	 * @Description 确认取现
	 * @return
	 */
	public ExtendWebElement getComfirm_btn() {
		comfirm_btn = locator.getElement("comfirm_btn");
		return comfirm_btn;
	}

	/**
	 * @Description 选择取现账户
	 * @return
	 */
	public ExtendWebElement getSelect_Account() {
		select_Account = locator.getElement("select_Account");
		return select_Account;
	}
	
	
	
	/*
	public RedeemResultPage redeem(String amount,String pwd){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		ElementAction.type(redeem_amount, amount);
		ElementAction.type(trade_pwd, pwd);
		ElementAction.click(comfirm_btn);
		waitElementDisplay(driver, By.className("cover"), false);
		return new RedeemResultPage(driver);
	}
	*/
}
