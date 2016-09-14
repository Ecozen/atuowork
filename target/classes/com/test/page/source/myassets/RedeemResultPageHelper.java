package com.test.page.source.myassets;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.test.keydriver.annotation.KeyMethod;
import com.test.keydriver.annotation.KeyObject;
import com.test.utils.page.PageHelper;

@KeyObject
public class RedeemResultPageHelper extends PageHelper {

	private RedeemResultPage redeemResultPage;
	public RedeemResultPageHelper(WebDriver driver) {
		redeemResultPage = new RedeemResultPage(driver);
		setWebDriver(driver);
	}
	
	@KeyMethod("检查取现结果")
	public void checkRedeemResult(Map<String,Object> params){
		sleep(5);
		String title = redeemResultPage.getRedeem_title().getText();
		isTextCorrect(title, "取现结果");
		String amount = (String)params.get("amount");
		isTextCorrect(redeemResultPage.getRedeem_amount().getText(),"取现金额："+amount+"元");
		sleep(5);
		redeemResultPage.getGo_back().click();
	}
}
