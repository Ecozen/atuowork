package com.test.utils.element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNGException;

import com.test.utils.Config;
/**
 * @description manage element with yaml
 * @author wenxiang.zheng
 *
 */
public class Locator {
	
    private String yamlFile;
    
    private WebDriver driver;   
    
    private ExtendWebElement extWebElement;
    
    public Logger logger = Logger.getLogger(Locator.class);
    
    public Locator(WebDriver driver,String file) {    
        this.driver = driver;
        yamlFile=file;
        this.getYamlFile();
        extWebElement = new ExtendWebElement();
    }
 
    public Locator(WebDriver driver) {       
        this.driver = driver;
        this.getYamlFile();
        extWebElement = new ExtendWebElement();
    }
    
    private HashMap<String, HashMap<String, String>> ml;
    
    private HashMap<String, HashMap<String, String>> extendLocator;
 
    @SuppressWarnings("unchecked")
    public void getYamlFile() {
        File f = new File(yamlFile + ".yaml");
        try {
            ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()),
                    HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
	public void loadExtendLocator(String fileName){
        File f = new File(fileName + ".yaml");
        try {
            extendLocator = Yaml.loadType(new FileInputStream(f.getAbsolutePath()),
                    HashMap.class);
            ml.putAll(extendLocator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }   

    public ExtendWebElement getElement(String key) {
    	logger.debug("find element:"+key);
    	 return this.getLocator(key, null, true);
    }
    
    public ExtendWebElement getElementNoWait(String key) {
    	logger.debug("find element no wait:"+key);
    	 return this.getLocator(key, null, false);
    }
    
    public ExtendWebElement getElement(String key, String[] replace) {
        return this.getLocator(key, replace, true);
    }
     
    public ExtendWebElement getElementNoWait(String key, String[] replace) {
        return this.getLocator(key, replace, false);
    }

    private ExtendWebElement getLocator(String key,String[] replace, boolean wait) {
        WebElement element = null;
        if (ml.containsKey(key)) {
            HashMap<String, String> m = ml.get(key);
            String type = m.get("type");
            String value = m.get("value");   
            if (replace != null)
                value = this.getLocatorString(value, replace);

            By by = this.getBy(type, value);
            if (wait) {
                element = this.watiForElement(by);
                boolean flag = this.waitElementToBeDisplayed(element);
                if (!flag)
                    element = null;
            } else {
                try {
                    element = driver.findElement(by);
                } catch (Exception e) {
                    element = null;
                }
            }
        } else{
        	logger.error("Locator " + key + " is not exist in " + yamlFile
                    + ".yaml");
        }
        extWebElement.setElement(element);
        return extWebElement;
    }
        
    private WebElement watiForElement(final By by) {
        WebElement element = null;
        int waitTime = Integer.parseInt(Config.getConfig("waitTime"));
        try {
            element = new WebDriverWait(driver, waitTime)
                    .until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver d) {
                            return d.findElement(by);
                        }
                    });	
        } catch (Exception e) {
            logger.error(by.toString() + " is not exist until " + waitTime);
            throw new TestNGException(by.toString() + " is not exist until " + waitTime, e);
        }
        return element;
    } 
    
    private String getLocatorString(String locatorString, String[] ss) {
        for (String s : ss) {
            locatorString = locatorString.replaceFirst("%s", s);
        }
        return locatorString;
    }
    /**
     * @description replace variable with value 
     * @param variable
     * @param value
     */
    public void setLocatorVariableValue(String variable, String value){
        Set<String> keys = ml.keySet();
        for(String key:keys){
             String v = ml.get(key).get("value").replaceAll("%"+variable+"%", value);
             ml.get(key).put("value",v);
        }
    }
    
    private boolean waitElementToBeDisplayed(final WebElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {
            wait = new WebDriverWait(driver, Integer.parseInt(Config
                    .getConfig("waitTime")))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return element.isDisplayed();
                        }
                    });
        } catch (Exception e) {
            logger.error(element.toString() + "is not displayed");
            throw new TestNGException(element.toString() + "is not displayed", e);
        }
        return wait;
    }
    
    public boolean waitElementToBeNonDisplayed(final WebElement element) {
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
            + "] is also displayed", e);
        }
        return wait;
    }
    
    private By getBy(String type, String value) {
        By by = null;
        if (type.equals("id")) {
            by = By.id(value);
        }
        if (type.equals("name")) {
            by = By.name(value);
        }
        if (type.equals("css")) {
            by = By.cssSelector(value);
        }
        if (type.equals("tagName")) {
            by = By.tagName(value);
        }
        if (type.equals("xpath")) {
            by = By.xpath(value);
        }
        if (type.equals("className")) {
            by = By.className(value);
        }
        if (type.equals("linkText")) {
            by = By.linkText(value);
        }
        if (type.equals("partialLinkText")) {
            by = By.partialLinkText(value);
        }
        return by;
    }
    
}
