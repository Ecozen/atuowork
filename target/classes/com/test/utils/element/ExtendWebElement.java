package com.test.utils.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNGException;
import org.testng.log4testng.Logger;

import com.test.utils.Config;

/**
 * packaged WebElement API with convenience
 * @author wenxiang.zheng
 *
 */
public class ExtendWebElement {
	
    private WebElement element;
    
    public void setElement(WebElement element) {
        this.element = element;
    }
     
    public Logger logger = Logger.getLogger(ExtendWebElement.class);
    
	public void click() {
		try {
			clickTheClickable(System.currentTimeMillis(), 2500);
		} catch (StaleElementReferenceException e) {
			logger.error("The element you clicked:[" + element + "] is no longer exist!");
			Assert.fail("The element you clicked:[" + element + "] is no longer exist!");
		} catch (Exception e) {
			logger.error("Failed to click element [" + element + "]");
			Assert.fail("Failed to click element [" + element + "]",e);
		}
		logger.info("click element [" + element + "]");
	}

	/** 不能点击时候重试点击操作 */
	public void clickTheClickable(long startTime, int timeOut) throws Exception {
		try {
			element.click();
			logger.debug("try to click"+element.toString());
		} catch (Exception e) {
			if (System.currentTimeMillis() - startTime > timeOut) {
				logger.warn(element+ " is unclickable");
				throw new TestNGException(e);
			} else {
				Thread.sleep(500);
				logger.warn(element + " is unclickable, try again");
				clickTheClickable(startTime, timeOut);
			}
		}
	}

	/**
	 * 
	 * @return 元素文本
	 */
	public String getText() {
		String value = element.getText().trim();
		logger.info("get elment's text:"+value);
		return value;
	}

	/**
	 * 
	 * @param attribute:元素属性
	 * @return 元素属性值
	 */
	public String getAttributeText(String attribute) {
		String value = element.getAttribute(attribute).trim();
		logger.info("get element's attribute:"+value);
		return value;
	}

	/**
	 * 清除输入框内容
	 */
	public void clear() {
		if (!element.isEnabled()) {
			logger.warn("element:"+element+"is not editable！");
		}
		try {
			element.clear();
			logger.info("clear element :"+element+"content success");
		} catch (Exception e) {
			logger.error("clear element's txt failed:"+element);
			Assert.fail("clear element's txt failed:"+element);
		}
	}

	/**
	 * 向输入框输入内容
	 * */
	public void type(String key) {
		try {
			element.sendKeys(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("type [" + key + "] to [" + element + "]failed");
			Assert.fail("type [" + key + "] to [" + element + "]failed");
		}
		logger.info("type：[" + key + "] to [" + element + "]");
	}


	/**
	 * 选择下拉选项 -根据value
	 * */
	public void selectByValue(String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * 选择下拉选项 -根据index角标
	 * */
	public void selectByIndex(int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * 选择下拉选项 -根据文本内容
	 * */
	public void selectByText(String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * 获得当前select选择的值
	 * */
	public List<WebElement> getCurrentSelectValue(){
		List<WebElement> options = null;
		Select s = new Select(element);
			options =  s.getAllSelectedOptions();
			return options;
	}

	/**
	 * 包装selenium模拟鼠标操作 - 鼠标移动到指定元素
	 * @param driver 
	 * */
	public void mouseMoveToElement(WebDriver driver) {
		Actions builder = new Actions(driver);
		Actions mouse = builder.moveToElement(element);
		mouse.perform();
		logger.info("move mouse to:"+element);
	}
	
	/**
	 * 包装selenium模拟鼠标操作 - 鼠标右击
	 * @param driver 
	 * */
	public void mouseRightClick(WebDriver driver) {
		Actions builder = new Actions(driver);
		Actions mouse = builder.contextClick(element);
		mouse.perform();
		logger.info("right click:"+element);
	}

	/**
	 * 
	 * @param key
	 * @return css value
	 */
	public String getCSSValue(String key) {
		return element.getCssValue(key);
	}

	/** 使用testng的assetTrue方法 */
	public void assertTrue(String content) {
		String str = element.getText();
		Assert.assertTrue(str.contains(content), "字符串数组中不含有：" + content);
	}

	/**
	 * @description get element from list
	 * @param by
	 * @param attribute
	 * @param expected
	 * @return
	 */
	public ExtendWebElement getElement(By by,String attribute,String expected){
		List<WebElement> elements = element.findElements(by);
		for (WebElement element : elements) {
			String actual = element.getAttribute(attribute);
			if (actual.equals(expected)) {
				logger.debug("find element:"+element+"from list");
				this.element = element;
				return this;
			}
		}
		logger.warn("未在"+element+":中找到元素");
		return null;
	}
	/**
	 * @Description 返回一组元素
	 * @param by
	 * @return
	 */
	public List<WebElement> getElements(By by){
		List<WebElement> elements = element.findElements(by);
		return elements;
	}
	
	/**
	 * @Description 返回子元素
	 * @param by
	 * @return
	 */
	public ExtendWebElement getElement(By by){
		this.element = element.findElement(by);
		return this;
	}
	
	/**
	 * @description get element from list
	 * @param by
	 * @param index
	 * @return
	 */
	public ExtendWebElement getElement(By by,int index){
		List<WebElement> elements = element.findElements(by);
		if (elements.size()<1) {
			logger.warn("元素列表为空");
			throw new IndexOutOfBoundsException("The list of elements is empty");
		}
		this.element = elements.get(index);
		logger.debug("find element:"+element+"from list");
		return this;
	}
	
	public boolean waitElementDisappeared(WebDriver driver) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {
            wait = new WebDriverWait(driver, Integer.parseInt(Config
                    .getConfig("waitTime")))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return !element.isDisplayed();
                        }
                    });
        } catch (Exception e) {
        	logger.error("Locator [" + element.toString()
                    + "] is also displayed");
        	throw new TestNGException("Locator [" + element.toString()
            + "] is also displayed",e);
        }
        return wait;
    }
}
