package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class RedeemResultPage {

	private Locator locator;
	public RedeemResultPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAsset");
	}

	private ExtendWebElement redeem_title;
	private ExtendWebElement redeem_amount;
	private ExtendWebElement redeem_time;
	private ExtendWebElement result_account;
	private ExtendWebElement go_back;
	
	/**
	 * @Description 页面标题
	 * @return
	 */
	public ExtendWebElement getRedeem_title() {
		redeem_title = locator.getElement("redeem_title");
		return redeem_title;
	}
	
	/**
	 * @Description 取现金额
	 * @return
	 */
	public ExtendWebElement getRedeem_amount() {
		redeem_amount = locator.getElement("trade_amount");
		return redeem_amount;
	}
	
	/**
	 * @Description 交易时间
	 * @return
	 */
	public ExtendWebElement getRedeem_time() {
		redeem_time = locator.getElement("redeem_time");
		return redeem_time;
	}
	
	/**
	 * @Description 交易账户
	 * @return
	 */
	public ExtendWebElement getResult_account() {
		result_account = locator.getElement("result_account");
		return result_account;
	}

	/**
	 * @Description 返回
	 * @return
	 */
	public ExtendWebElement getGo_back() {
		go_back = locator.getElement("go_back"); 
		return go_back;
	}
	
	
}
