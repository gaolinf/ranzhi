package ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class CompanyName extends BaseTest{
//	@Test
//	public void loginranzhi(){
//		//登录然之系统
//		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
//		webtest.type("name=account", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("xpath=.//*[@id='submit']");
//	}
//	
//	@Test(dependsOnMethods="loginranzhi" )
//	public void GetInBackStage(){
//		//进入后台管理
//		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
//	}
//	
	@Test(dataProvider="company",dataProviderClass=NSDataProvicer.class)
	public void testCompanyName(String name){
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");

		webtest.enterFrame("iframe-superadmin");
		
		
		CompanyNameClass cnname=new CompanyNameClass(webtest);
		cnname.input(name);
		
		
	}
}
