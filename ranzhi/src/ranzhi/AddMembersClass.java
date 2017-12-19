package ranzhi;

import static org.testng.Assert.assertTrue;

import com.webtest.core.WebDriverEngine;

public class AddMembersClass {
	public WebDriverEngine webtest;
	public AddMembersClass(WebDriverEngine webtest){
		this.webtest=webtest;
	}
	
	public void input(String name,String realname,String pwd1,String pwd2,String email){
		//输入后台管理的组织中添加成员的用户名
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[1]");
		webtest.type("xpath=.//*[@id='account']",name);
		webtest.type("name=realname", realname);
		webtest.click("xpath=.//*[@id='genderm']");
		webtest.type("name=password1", pwd1);
		webtest.type("name=password2", pwd2);
		webtest.type("name=email", email);
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("保存成功"));
	}
	
}
