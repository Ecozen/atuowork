package com.test.page.source.main;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;
@KeyObject
public class IndexPageHelper extends PageHelper{

	private WebDriver driver;
	private IndexPage indexPage;
	
	public IndexPageHelper(WebDriver driver) {
		this.driver = driver;
		this.indexPage = new IndexPage(driver);
		setWebDriver(driver);
	}
	/**
	 * @Description 跳转到个人中心
	 */
	@KeyMethod("跳转到个人中心")
	public void toMyAccountPage(Map<String, Object> params){
		waitForPageLoading(20);
		indexPage.getMy_account().click();
	}
	/**
	 * @Description 跳转到资产
	 */
	@KeyMethod("跳转到资产")
	public void toMyAssetPage(Map<String, Object> params){
		waitForPageLoading(20);
		indexPage.getMy_assert().click();
	}
	/**
	 * @Description 跳转到基金列表
	 */
	@KeyMethod("跳转到基金列表")
	public void toFundListPage(Map<String, Object> params){
		waitForPageLoading(20);
		indexPage.getFund_list().click();
	}
	
}
