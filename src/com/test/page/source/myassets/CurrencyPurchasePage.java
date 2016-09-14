package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class CurrencyPurchasePage {
	
	private Locator locator;
	public CurrencyPurchasePage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAsset");
	}

	private ExtendWebElement  found_source;
	
	private ExtendWebElement  apply_amount;
	
	private ExtendWebElement  tradePwd;
	
	private ExtendWebElement  comfirm_btn;
	
	private ExtendWebElement  account_list;
	
	/**
	 * @Description 资金来源
	 * @return
	 */
	public ExtendWebElement getFound_source() {
		found_source = locator.getElement("found_source");
		return found_source;
	}

	/**
	 * @Description 充值金额
	 * @return
	 */
	public ExtendWebElement getApply_amount() {
		apply_amount = locator.getElement("apply_amount");
		return apply_amount;
	}

	/**
	 * @Description 交易密码
	 * @return
	 */
	public ExtendWebElement getTradePwd() {
		tradePwd = locator.getElement("tradePwd");
		return tradePwd;
	}

	/**
	 * @Description 确认充值
	 * @return
	 */
	public ExtendWebElement getComfirm_btn() {
		comfirm_btn = locator.getElement("comfirm_pur_btn");
		return comfirm_btn;
	}

	/**
	 * @Description 选择资金来源
	 * @return
	 */
	public ExtendWebElement getAccount_list() {
		account_list = locator.getElement("account_list");
		return account_list;
	}
	
	
	/*
	public void purchase(String amount,String pwd){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		ElementAction.type(apply_amount, amount);
		ElementAction.type(tradePwd,pwd);
		ElementAction.click(comfirm_btn);
		waitElementDisplay(driver, By.className("cover"), false);
	}
	*/
}
