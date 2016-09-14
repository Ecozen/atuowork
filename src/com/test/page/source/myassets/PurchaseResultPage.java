package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class PurchaseResultPage {

	private Locator locator;
	
	public PurchaseResultPage(WebDriver driver){
		this.locator = new Locator(driver, "locator/myAsset");
	}
	
	private ExtendWebElement purchase_title;
	private ExtendWebElement purchase_reslut;
	private ExtendWebElement purchase_date;
	private ExtendWebElement go_back;

	/**
	 * @Description 页面结果标题
	 * @return
	 */
	public ExtendWebElement getPurchase_title() {
		purchase_title = locator.getElement("purchase_title");
		return purchase_title;
	}
	
	/**
	 * @Description 交易金额
	 * @return
	 */
	public ExtendWebElement getPurchase_reslut() {
		purchase_reslut = locator.getElement("purchase_reslut");
		return purchase_reslut;
	}
	
	/**
	 * @Description 交易时间
	 * @return
	 */
	public ExtendWebElement getPurchase_date() {
		purchase_date = locator.getElement("purchase_date");
		return purchase_date;
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
