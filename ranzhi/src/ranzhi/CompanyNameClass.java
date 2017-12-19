package ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;

public class CompanyNameClass {
	
	public WebDriverEngine webtest;
	public CompanyNameClass(WebDriverEngine webtest){
		this.webtest=webtest;
	}
	
	public void input(String name){
		//���빫˾����	
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[1]/a");
		webtest.typeAndClear("name=name", name);
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("���óɹ�"));
	}
}