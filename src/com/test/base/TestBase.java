package com.test.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.test.data.constance.RegisterCenter;
import com.test.data.interfaces.DataInterface;
import com.test.keydriver.annotation.AutoMethod;
import com.test.keydriver.annotation.InitialAnnotation;
import com.test.utils.Config;
import com.test.utils.LogConfiguration;
import com.test.utils.page.PageHelper;

public class TestBase {

	static Logger logger = Logger.getLogger(TestBase.class.getName());
	WebDriver driver;
	PageHelper pageUtil = new PageHelper(driver);
	@BeforeClass
	public void setup(ITestContext context){
		LogConfiguration.initLog(this.getClass().getSimpleName());
		
		String browserName = context.getCurrentXmlTest().getParameter("browserName");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		int waitMillisecondsForAlert = Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));
		String webUrl = context.getCurrentXmlTest().getParameter("testurl");
		
		try {
			driver = pageUtil.launchBrowser(browserName, context,webUrl,timeOut);
			
			if(RegisterCenter.OBJ_POOLS.isEmpty()){
	            InitialAnnotation init = new InitialAnnotation(driver);
	            init.initialAnnotation();
	        }
	        AutoMethod am = new AutoMethod();
	        am.setMethodAnnotation(this);
			
		} catch (Exception e) {
			logger.error("浏览器不能正常工作，请检查是不是被手动关闭或者其他原因",e);
		}
		context.setAttribute("SELENIUM_DRIVER", driver);
	}
	
	@AfterClass
	public void teardown(ITestContext context){
		driver = (WebDriver) context.getAttribute("SELENIUM_DRIVER");
		if(driver!=null)
			driver.quit();
	}
	
    @DataProvider
    public Object[][] dataProvider(){
        return this.getTestData();
    }
    
    @DataProvider
    public Iterator<Object[]> testMethodDataProvider(ITestContext context){
    	DataInterface testData = this.getDataInstance(Config.DATA_SOURCE);
    	return this.getTestData(testData);
    }
     
    private Object[][] getTestData(){
    	DataInterface testData = this.getDataInstance(Config.DATA_SOURCE);
        List<Map<String, String>> listData = testData.getTestMethodData();
        Object[][] object = new Object[listData.size()][];
        for (int i = 0; i < listData.size(); i++) {
            object[i] = new Object[]{listData.get(i)};
        }
        return object;
    }
    
    private Iterator<Object[]> getTestData(DataInterface testData){
    	List<Map<String, String>> listData = testData.getTestMethodData();
    	List<Object[]> result = new ArrayList<>();
    	for (int i = 0; i < listData.size(); i++) {
             result.add(new Object[]{listData.get(i)});
        }
    	return result.iterator();
    }
    
    private DataInterface getDataInstance(String key){
        DataInterface data = null;
        try {
            data = (DataInterface) Class.forName(key).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
