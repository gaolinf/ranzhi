package ranzhi;

import static org.testng.Assert.assertTrue;

import com.webtest.core.WebDriverEngine;

public class AddMembersClass {
	public WebDriverEngine webtest;
	public AddMembersClass(WebDriverEngine webtest){
		this.webtest=webtest;
	}
	
	public void input(String name,String realname,String pwd1,String pwd2,String email){
		//�����̨�������֯����ӳ�Ա���û���
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[1]");
		webtest.type("xpath=.//*[@id='account']",name);
		webtest.type("name=realname", realname);
		webtest.click("xpath=.//*[@id='genderm']");
		webtest.type("name=password1", pwd1);
		webtest.type("name=password2", pwd2);
		webtest.type("name=email", email);
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
	}
	
}
