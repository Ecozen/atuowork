package com.test.page.source.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class FundListPage {

	private Locator locator;
	
	public FundListPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/fundList");
	}

	private ExtendWebElement select_all;
	private ExtendWebElement fund_list;

	/**
	 * @Description 全部基金
	 * @return
	 */
	public ExtendWebElement getSelect_all() {
		select_all = locator.getElement("select_all");
		return select_all;
	}
	/**
	 * @Description 全部基金列表
	 * @return
	 */
	public ExtendWebElement getFund_list() {
		fund_list = locator.getElement("fund_list");
		return fund_list;
	}
	/**
	 * 返回某只基金
	 * @param fundCode 基金代码
	 * @return
	 */
	public ExtendWebElement getFund(String fundCode){
		ExtendWebElement element = this.getFund_list().getElement(By.tagName("tr"), "fundcode", fundCode);
		return element;
	}
}
