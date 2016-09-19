package com.test.utils.page;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;

import com.test.utils.Config;

/**
 * @author young
 * @description 在不同的平台上选择对应的浏览器,系统平台程序自动判断是什么平台
 * */
public class SelectBrowser {
	Logger logger = Logger.getLogger(SelectBrowser.class);

	public WebDriver selectExplorerByName(String browser, ITestContext context) {
//		Properties props = System.getProperties(); 
//		String currentPlatform = props.getProperty("os.name"); 
		String currentPlatform = context.getCurrentXmlTest().getParameter("platform");//手动配置操作系统
		logger.info("当前操作系统是:[" + currentPlatform + "]");
		logger.info("启动测试浏览器：[" + browser + "]");
		String driverConfgFilePath = context.getCurrentXmlTest().getParameter("driverConfgFilePath");//配置驱动路径
		//运行webDriver的地址
		String testEnv = context.getCurrentXmlTest().getParameter("testEnv");
		URL url = null;
		try {
			url = new URL("http://"+testEnv+":4444/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		/** 声明好驱动的路径 */
		String chromedriver_win = Config.getConfig(driverConfgFilePath, "chromedriver_win");
		String chromedriver_linux = Config.getConfig(driverConfgFilePath, "chromedriver_linux");
		String chromedriver_mac = Config.getConfig(driverConfgFilePath, "chromedriver_mac");
		String ghostdriver_win = Config.getConfig(driverConfgFilePath, "ghostdriver_win");
		String iedriver = Config.getConfig(driverConfgFilePath, "iedriver");
		if (currentPlatform.toLowerCase().contains("win")) { //如果是windows平台

			if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", iedriver);
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				//IE的常规设置，便于执行自动化测试
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				return new RemoteWebDriver(url, ieCapabilities);
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromedriver_win);
				logger.info("start loading :"+testEnv);
				 return new RemoteWebDriver(url, DesiredCapabilities.chrome());
			} else if (browser.equalsIgnoreCase("firefox")) {
				return new RemoteWebDriver(url,DesiredCapabilities.firefox());

			} else if(browser.equalsIgnoreCase("ghost")){
				DesiredCapabilities ghostCapabilities = new DesiredCapabilities();
				ghostCapabilities.setJavascriptEnabled(true);                       
				ghostCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, ghostdriver_win);
			    return new PhantomJSDriver(ghostCapabilities);
				
			}else {

				logger.error("The [" + browser + "]" + " explorer is not applicable  for  [" + currentPlatform + "] OS");
				Assert.fail("The [" + browser + "]" + " explorer does not apply to  [" + currentPlatform + "] OS");
			}

		} else if (currentPlatform.toLowerCase().contains("linux")) { //如果是linux平台

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromedriver_linux);
				return new RemoteWebDriver(url, DesiredCapabilities.chrome());

			} else if (browser.equalsIgnoreCase("firefox")) {
				return new RemoteWebDriver(url, DesiredCapabilities.firefox());
			} else {
				logger.error("The [" + browser + "]" + " explorer does not apply to  [" + currentPlatform + "] OS");
				Assert.fail("The [" + browser + "]" + " explorer does not apply to  [" + currentPlatform + "] OS");
			}

		} else if (currentPlatform.toLowerCase().contains("mac")) { //如果是mac平台
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromedriver_mac);
				return new RemoteWebDriver(url, DesiredCapabilities.chrome());
			} else if (browser.equalsIgnoreCase("firefox")) {
				return new RemoteWebDriver(url, DesiredCapabilities.firefox());
			} else {
				logger.error("The [" + browser + "]" + " explorer does not apply to  [" + currentPlatform + "] OS");
				Assert.fail("The [" + browser + "]" + " explorer does not apply to  [" + currentPlatform + "] OS");
			}

		} else
			logger.error("The [" + currentPlatform + "] is not supported for this automation frame,please change the OS(Windows,MAC or LINUX)");
		
		Assert.fail("The [" + currentPlatform + "] is not supported for this automation frame,please change the OS(Windows,MAC or LINUX)");
		return null;
	}

}
