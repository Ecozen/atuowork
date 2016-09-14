package com.test.keydriver.annotation;

import org.openqa.selenium.WebDriver;

public class InitialAnnotation {
	 
	private WebDriver driver;
     
	public InitialAnnotation(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	public void initialAnnotation(){       
	    LoadObjects lo = new LoadObjects();
	    lo.setDriver(driver);
	    lo.loadAllPage();
	    AutoMethod am = new AutoMethod();
	    am.setMethodAnnotation();
	    }
}
