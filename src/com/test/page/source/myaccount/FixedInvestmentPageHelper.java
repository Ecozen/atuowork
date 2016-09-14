package com.test.page.source.myaccount;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.element.ExtendWebElement;
import com.test.utils.page.PageHelper;

@KeyObject
public class FixedInvestmentPageHelper extends PageHelper{
	private WebDriver driver;
	private FixedInvestmentPage fixedInvestmentPage;
	
	public FixedInvestmentPageHelper(WebDriver driver){
		this.driver = driver;
		this.fixedInvestmentPage = new FixedInvestmentPage(driver);
		setWebDriver(driver);
	}
	
	@KeyMethod("添加定投-优选基金")
	public void addFixed(Map<String,Object> params){
		sleep(3);
		fixedInvestmentPage.getAdd_fixed().click();
		sleep(3);
		fixedInvestmentPage.getPerfer_fund().click();
		sleep(2);
		getFund((String) params.get("fundCode")).click();
		sleep(5);
		String amount = (String) params.get("amount");
		String cycle = (String) params.get("cycle");
		String date =  (String) params.get("date");
		String pwd =  (String) params.get("pwd");
		editFixed(amount, cycle, date, pwd);
		sleep(5);
		checkFixedResult(amount);
		sleep(3);
	}
	
	@KeyMethod("添加定投")
	public void addFixedAll(Map<String,Object> params){
		sleep(3);
		fixedInvestmentPage.getAdd_fixed().click();
		sleep(3);
		getFundAll((String) params.get("fundCode")).click();
		sleep(5);
		String amount = (String) params.get("amount");
		String cycle = (String) params.get("cycle");
		String date =  (String) params.get("date");
		String pwd =  (String) params.get("pwd");
		editFixed(amount, cycle, date, pwd);
		sleep(5);
		checkFixedResult(amount);
		sleep(3);
		fixedInvestmentPage.getStep5().getElement(By.cssSelector("#step5 > header > div.hl")).click();//返回
	}
	
	@KeyMethod("修改定投")
	public void editFixed(Map<String,Object> params){
		sleep(3);
		getAvaFixed((String) params.get("fundCode")).click();
		sleep(1);
		fixedInvestmentPage.getEdit_btn().click();//点击修改定投
		String amount = (String) params.get("amount");
		String cycle = (String) params.get("cycle");
		String date =  (String) params.get("date");
		String pwd =  (String) params.get("pwd");
		fixedInvestmentPage.getPay_cycle().click();//点击扣款周期
		sleep(1);
		fixedInvestmentPage.getCycle_list().getElement(selectDate(cycle)).selectByText(date);//选择扣款日期
		fixedInvestmentPage.getConfirm_cycle_btn().click();//确认修改日期
		sleep(1);
		fixedInvestmentPage.getFix_amount().clear();
		fixedInvestmentPage.getFix_amount().type(amount);
		fixedInvestmentPage.getPwd().type(pwd);
		fixedInvestmentPage.getSave_btn().click();//点击保存
		sleep(1);
		fixedInvestmentPage.getConfirm_btn_edit().click();//确认修改
		sleep(3);
		driver.switchTo().window(driver.getWindowHandles().iterator().next()).findElement(By.linkText("确定")).click();//确认完成修改
		sleep(5);
	}
	
	@KeyMethod("暂停定投")
	public void pauseFixed(Map<String,Object> params){
		sleep(3);
		getAvaFixed((String) params.get("fundCode")).click();
		sleep(1);
		fixedInvestmentPage.getPause_btn().click();//点击暂停定投
		sleep(1);
		fixedInvestmentPage.getPause_pwd().type((String) params.get("pwd"));
		fixedInvestmentPage.getConfirm_btn_holder().click();
		sleep(3);
		driver.switchTo().window(driver.getWindowHandles().iterator().next()).findElement(By.linkText("确定")).click();
		sleep(3);
	}
	
	//从优选基金中选
	private ExtendWebElement getFund(String fundCode){
		String expected = "/lion-trade/t/fixedInvestmentFundCode.action?fundCode="+fundCode;
		ExtendWebElement fund_list = fixedInvestmentPage.getFund_list();
		ExtendWebElement target = null;
		int size = fund_list.getElements(By.className("fund-list")).size();
		for (int i = 1; i <= size; i++) {
			By locator = By.xpath("//div[@id='fundList0']/div["+i+"]/table/tbody/tr/td[3]/a");
			System.out.println("-------------start search--------------"+i+"count");
			target = fund_list.getElement(locator);
			String actual = target.getAttributeText("href");
			if (expected.equals(actual)) {
				return target;
			}
		}
		return target;
	}
	
	//从全部基金中选
	private ExtendWebElement getFundAll(String fundCode){
		String expected = fundCode;
		ExtendWebElement fund_list = fixedInvestmentPage.getAll_fund_list();
		ExtendWebElement target = null;
		int size = fund_list.getElements(By.className("border-top")).size();
		for (int i = 2; i <= size; i++) {
			By locator = By.xpath("//*[@id=\"fundList\"]/tr["+i+"]/td[1]/div[2]/span[2]");
			System.out.println("-------------start search--------------"+i+"count");
			target = fund_list.getElement(locator);
			String actual = target.getText();
			if (expected.equals(actual)) {
				return target;
			}
		}
		return target;
	}
	
	//从有效定投中选
	private ExtendWebElement getAvaFixed(String fundCode){
		List<WebElement> avaFixed_list = fixedInvestmentPage.getAva_fixList().getElements(By.className("fund-list1"));
		for (int i = 1; i <= avaFixed_list.size(); i+=2) {
			ExtendWebElement target = fixedInvestmentPage.getAva_fixList().getElement(By.cssSelector(
					"#fixList > div:nth-child("+i+") > div.fund-style.sub-l > span:nth-child(2) > i"));
			String actual = target.getText();
			if (fundCode.equals(actual)) {
				return target;
			}
		}
		return null;
	}
	
	private void editFixed(String amount,String cycle,String date,String pwd){
		String actual = fixedInvestmentPage.getTitle().getText();
		isTextCorrect(actual, "设置定投");
		fixedInvestmentPage.getFund_source().click();//点击资金来源
		sleep(1);
		fixedInvestmentPage.getBank_list().getElement(By.tagName("a"), 1).click();//选择资金来源
		sleep(1);
		fixedInvestmentPage.getPay_cycle().click();//点击扣款周期
		sleep(1);
		fixedInvestmentPage.getCycle_list().getElement(selectDate(cycle)).selectByText(date);//选择扣款周期
		
		fixedInvestmentPage.getConfirm_cycle_btn().click();//点击确认
//		String js = "document.getElementById('chooseCycleBtn').click();";
//		executeJS(js, null);
		fixedInvestmentPage.getFix_amount().clear();
		fixedInvestmentPage.getFix_amount().type(amount);//输入金额
		fixedInvestmentPage.getNext_step_btn().click();
		sleep(3);
		actual = fixedInvestmentPage.getStep4_title().getText();
		isTextCorrect(actual, "确认定投");
		fixedInvestmentPage.getPwd().type(pwd);
		fixedInvestmentPage.getComfirm_btn().click();
	}
	
	//校验定投结果
	private void checkFixedResult(String amount){
		String title = fixedInvestmentPage.getStep5().getElement(By.cssSelector("#step5 > header > div.title")).getText();
		isTextCorrect(title, "受理结果");
		String actualAmount = fixedInvestmentPage.getStep5().getElement(By.cssSelector("#share5")).getText();
		isTextCorrect(actualAmount, amount);
	}
	
	private By selectDate(String cycle){
		switch (cycle) {
		case "每月":
			return By.id("date0");
		case "每周":
			return By.id("date1");
		case "每双周":
			return By.id("date2");
		default:
			return null;
		}
	}
}
