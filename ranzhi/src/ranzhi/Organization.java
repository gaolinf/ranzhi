package ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Organization extends BaseTest{
	@Test
	public void GetInBackStage(){
		//登录然之系统
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}	
	
	@Test(dependsOnMethods="GetInBackStage")
	public void bmname(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//添加后台管理中维护部门中的部门
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.typeAndClear("xpath=.//*[@id='children[]']", "我是部门");
		webtest.typeAndClear("xpath=.//*[@id='children[]']", "我也是部门");
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void shangjibumen(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//添加后台管理的组织中各部门的上级部门
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/a[1]");
		webtest.click("xpath=.//*[@id='parent_chosen']/a/div");
		webtest.click("xpath=.//*[@id='parent_chosen']/div/ul/li[2]");
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void bumenname(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//编辑后台管理的组织中各部门的部门名称
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li/ul/li/a[1]");
		webtest.type("name=name", "我才是部门");
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void bumenmanager(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//编辑后台管理的组织中部门的部门经理
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/a[1]");
		webtest.click("xpath=.//*[@id='moderators_chosen']/a");
		webtest.click("xpath=.//*[@id='moderators_chosen']/div/ul/li[7]");
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void findmember(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//在后台管理-组织-成员列表中搜索某一成员
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.type("name=query","admin");
		webtest.click("xpath=.//*[@id='submit']");
//		assertTrue(webtest.getHtmlSource().contains("admin"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
}
