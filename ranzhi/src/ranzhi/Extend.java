package ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Extend extends BaseTest{
	@Test
	public void GetInBackStage(){
		//登录然之系统
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void Extension(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//扩展-获取插件
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
		
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void DownloadPlugin(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//扩展-获取插件
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		//下载插件
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void Plugininfoemation(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//扩展-获取插件
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		//查看插件详情
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[4]/a");
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void Pluginuse(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//扩展-获取插件
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		//试用插件
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[4]/a");
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
}