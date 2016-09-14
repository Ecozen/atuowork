package com.test.page.source.myassets;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;

@KeyObject
public class PurchaseResultPageHelper extends PageHelper{

	private PurchaseResultPage purchaseResultPage;
	
	public PurchaseResultPageHelper(WebDriver driver){
		this.purchaseResultPage = new PurchaseResultPage(driver);
		setWebDriver(driver);
	}
	
	@KeyMethod("检查充值结果")
	public void checkPurchaseResult(Map<String,Object> params){
		sleep(5);
		String title = purchaseResultPage.getPurchase_title().getText();
		isTextCorrect(title, "充值结果");
		String amount = (String)params.get("amount");
		isTextCorrect(purchaseResultPage.getPurchase_reslut().getText(), "成功充值"+amount+"元");
		sleep(5);
		purchaseResultPage.getGo_back().click();
	}
}
