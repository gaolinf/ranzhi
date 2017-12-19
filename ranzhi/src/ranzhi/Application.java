package ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Application extends BaseTest{
	@Test
	public void GetInBackStage(){
		//登录然之系统
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}	
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AddApps1(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//添加一个应用 方法一
		//可添加数据驱动
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[2]/a");
		webtest.type("xpath=.//*[@id='name']","111");
		webtest.type("xpath=.//*[@id='abbr']", "DS");
		webtest.type("xpath=.//*[@id='code']", "glfglf1");
		webtest.type("xpath=.//*[@id='login']", "http://www.baidu.com");
		webtest.click("xpath=.//*[@id='groups3']");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppPermission(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//更改应用权限
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[1]");
		webtest.click("xpath=.//*[@id='groups5']");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppStyle(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//更改应用样式
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[2]");
		webtest.click("xpath=.//*[@id='control']");
		webtest.click("value=full");
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void EditApp(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//编辑应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[4]");
		webtest.type("xpath=.//*[@id='name']", "客户管理1");
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AddApps2(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//添加一个应用 方法二
		//可添加数据驱动
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=html/body/div[2]/div/div/div[1]/div/a[2]");
		webtest.type("xpath=.//*[@id='name']","111");
		webtest.type("xpath=.//*[@id='abbr']", "DS");
		webtest.type("xpath=.//*[@id='code']", "dasen1");
		webtest.type("xpath=.//*[@id='login']", "http://www.baidu.com");
		webtest.click("xpath=.//*[@id='groups3']");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppGroup1(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//维护分组 方法一
		//可添加数据驱动
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=html/body/div[2]/div/div/div[1]/div/a[1]");
		webtest.type("xpath=.//*[@id='children[]']", "group-1");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppGroup2(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//维护分组 方法二
		//可添加数据驱动
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.type("xpath=.//*[@id='children[]']", "group-2");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void ScanWebAppList(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//浏览web应用、最近更新、最新添加、最多下载
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='byupdatedtime']");
		webtest.click("xpath=.//*[@id='byaddedtime']");
		webtest.click("xpath=.//*[@id='bydownloads']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void SearchWebApp(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//搜索web应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.type("xpath=.//*[@id='key']", "css");
		webtest.click("class=btn btn-submit");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void InstallWebApp(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//安装web应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='webapp9']/div[4]/div/div/a[1]");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}

	@Test(dependsOnMethods="GetInBackStage")
	public void PreviewWebApp(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//预览web应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='useapp6']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}

	@Test(dependsOnMethods="GetInBackStage")
	public void WebAppInformation(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//查看某一web应用的详细信息
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='webapp6']/div[2]/strong/a");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void BrowseWebApp(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//分类浏览web应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='module6']");
		webtest.click("xpath=.//*[@id='module7']");
		webtest.click("xpath=.//*[@id='module8']");
		webtest.click("xpath=.//*[@id='module9']");
		webtest.click("xpath=.//*[@id='module10']");
		webtest.click("xpath=.//*[@id='module11']");
		webtest.click("xpath=.//*[@id='module12']");
		webtest.click("xpath=.//*[@id='module13']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void WebAppPageSetting(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//更改web应用的页码设置
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='_recPerPage']");
		webtest.click("xpath=html/body/div[2]/div[2]/div[2]/div/div/ul/li[2]/a");
//		assertTrue(webtest.getHtmlSource().contains("WEB应用"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
}
