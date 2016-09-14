package com.test.utils.page;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.test.utils.Config;

public class PageHelper {
	static Logger logger = Logger.getLogger(PageHelper.class.getName());
	private WebDriver driver;
	
	public PageHelper(WebDriver driver) {
		this.driver = driver;
	}

	public PageHelper(){
		
	}

	public void setWebDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver launchBrowser(String browserName, ITestContext context,String webUrl,int timeOut) {
		SelectBrowser select = new SelectBrowser();
		this.driver = select.selectExplorerByName(browserName, context);
		try {
//			maxWindow(browserName);
//			setBrowserSize(320, 480);
			get(webUrl);
			waitForPageLoading(timeOut);
			return driver;
		} catch (TimeoutException e) {
			logger.warn("注意：页面没有完全加载出来，刷新重试！！");
			refresh();
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			String status= (String)js.executeScript("return document.readyState");
			logger.info("打印状态："+status);
			return driver;
		}

	}

	/**
	 * 判断文本是不是和需求要求的文本一致
	 * **/
	public void isTextCorrect(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			logger.error("expected word: [" + expected + "] but find [" + actual + "]");
			Assert.fail("expected word: [" + expected + "] but find [" + actual + "]");
		}
		logger.info("find expected word: [" + expected + "]");
	}
	
	/**
	 * 最大化浏览器操作
	 * */
	public void maxWindow(String browserName) {
		logger.info("最大化浏览器:" + browserName);
		driver.manage().window().maximize();
	}

	/**
	 * 设定浏览器窗口大小： 设置浏览器窗口的大小有下面两个比较常见的用途：<br>
	 * 1、在统一的浏览器大小下运行用例，可以比较容易的跟一些基于图像比对的工具进行结合
	 * ，提升测试的灵活性及普遍适用性。比如可以跟sikuli结合，使用sikuli操作flash；<br>
	 * 2、在不同的浏览器大小下访问测试站点，对测试页面截图并保存，然后观察或使用图像比对工具对被测页面的前端样式进行评测。
	 * 比如可以将浏览器设置成移动端大小(320x480)，然后访问移动站点，对其样式进行评估；<br>
	 * */
	public void setBrowserSize(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}
	
	public void executeJS(String js, Object... args) {
		((JavascriptExecutor) driver).executeScript(js, args);
		logger.info("执行JavaScript语句：[" + js + "]");
	}

	public void get(String url) {
		driver.get(url);
		logger.info("打开测试页面:[" + url + "]");
	}

	public void close() {
		driver.close();
		logger.info("关闭浏览器");
	}

	public void refresh() {
		driver.navigate().refresh();
		logger.info("页面刷新成功！");
	}

	public void back() {
		driver.navigate().back();
		logger.info("前一个页面");
	}

	/**
	 * 前进方法包装
	 * */
	public void forward() {
		driver.navigate().forward();
	}
	/** 跳出frame */
	public void outFrame() {
		driver.switchTo().defaultContent();
	}

	// webdriver中可以设置很多的超时时间
	/** implicitlyWait。识别对象时的超时时间。过了这个时间如果对象还没找到的话就会抛出NoSuchElement异常 */
	public void implicitlyWait(int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	/** setScriptTimeout。异步脚本的超时时间。webdriver可以异步执行脚本，这个是设置异步执行脚本脚本返回结果的超时时间 */
	public void setScriptTimeout(int timeOut) {
		driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
	}

	/**
	 * pageLoadTimeout。页面加载时的超时时间。因为webdriver会等页面加载完毕在进行后面的操作，
	 * 所以如果页面在这个超时时间内没有加载完成，那么webdriver就会抛出异常
	 */
	public void waitForPageLoading(int pageLoadTime) {
		driver.switchTo().window(driver.getWindowHandle());
		driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
	}
	
	public void sleep(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上传文件，需要点击弹出上传照片的窗口才行
	 * 
	 * @param brower
	 *            使用的浏览器名称
	 * @param file
	 *            需要上传的文件及文件名
	 */
	public void handleUpload(String browser, File file) {
		String filePath = file.getAbsolutePath();
		String executeFile = "res/script/autoit/Upload.exe";
		String cmd = "\"" + executeFile + "\"" + " " + "\"" + browser + "\"" + " " + "\"" + filePath + "\"";
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description 对于windows GUI弹出框，要求输入用户名和密码时，
	 *              seleniumm不能直接操作，需要借助http://modifyusername:modifypassword@yoururl 这种方法
	 * 
	 * */
	public void loginOnWinGUI(String username, String password, String url) {
		driver.get(username + ":" + password + "@" + url);
	}
	
	public boolean isDispaly(final By by){
		boolean result;
		result = new WebDriverWait(driver, Integer.parseInt(Config
                 .getConfig("waitTime")))
                 .until(new ExpectedCondition<Boolean>() {
                     public Boolean apply(WebDriver d) {
                         return d.findElement(by).isDisplayed();
                     }
                 });
		
		return result;
	}
}
