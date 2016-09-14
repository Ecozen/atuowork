package com.test.page.source.myassets;

import org.openqa.selenium.WebDriver;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class TradeQueryPage {

	Locator locator;
	public TradeQueryPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAsset");
	}

	//全部
	private ExtendWebElement details_all;
	//买入
	private ExtendWebElement details_pur;
	//卖出
	private ExtendWebElement details_redeem;
	//其他
	private ExtendWebElement details_other;
	//交易状态选择
	private ExtendWebElement state_select;
	//交易明细
	private ExtendWebElement trade_list;
	
	public ExtendWebElement getDetails_all() {
		details_all = locator.getElement("details_all");
		return details_all;
	}
	public ExtendWebElement getDetails_pur() {
		details_pur = locator.getElement("details_pur");
		return details_pur;
	}
	public ExtendWebElement getDetails_redeem() {
		details_redeem = locator.getElement("details_redeem");
		return details_redeem;
	}
	public ExtendWebElement getDetails_other() {
		details_other = locator.getElement("details_other");
		return details_other;
	}
	public ExtendWebElement getState_select() {
		state_select = locator.getElement("state_select");
		return state_select;
	}
	public ExtendWebElement getTrade_list() {
		trade_list = locator.getElement("state_select");
		return trade_list;
	}
	
	
	/*
	public TradeDetailPage queryTrade(String tradeType,String tradeState){
		WebDriver driver = (WebDriver) DriverManager.MANAGER.get("driver");
		String state = convertState(tradeState);
		switch (tradeType) {
		case "买入":
			tradeTab(driver, details_pur, state);
		case "卖出":
			tradeTab(driver, details_redeem, state);	
		case "其他":
			tradeTab(driver, details_other, state);
		default:
			tradeTab(driver, details_all, state);
		}
		return null;
	}
	
	private TradeDetailPage tradeTab(WebDriver driver,WebElement tab,String tradeState){
		ElementAction.click(tab);
		waitElementDisplay(driver, By.className("cover"), false);
		ElementAction.click(state_select);
		WebElement state_list = driver.findElement(By.className("select-state"));
		ElementAction.selectByTag(state_list,"li", tradeState);
		sleep(1);
		if (!trade_list.findElements(By.tagName("tr")).isEmpty()) {
			ElementAction.selectByIndex(trade_list,"tr", 0);
			return new TradeDetailPage(driver);
		}
		return null;	
	}
	
	private String convertState(String value){
		Set<Entry<String, String>> entrys =DriverManager.KEYWORD.entrySet();
		for (Entry<String, String> entry : entrys) {
			if(entry.getValue().equals(value)){
				return entry.getKey();
			}
		}
		throw new IllegalArgumentException("stateValue:"+value);
	}
	*/
}
