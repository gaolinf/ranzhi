package ranzhi;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class System extends BaseTest{
	@Test
	public void GetInBackStage(){
		//登录然之系统
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void xuanxuanKey(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//喧喧秘钥
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[1]/a");
		webtest.typeAndClear("xpath=.//*[@id='key']","85214632588");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void sendEmail(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//发信
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.type("xpath=.//*[@id='fromAddress']", "123456789@qq.com");
		webtest.click("xpath=.//*[@id='submit']");
		
		assertTrue(webtest.getHtmlSource().contains("成功保存"));
	}
	
	@Test(dependsOnMethods="sendEmail")
	public void EditsendEmail(){
		
		//发信编辑
		webtest.click("xpath=.//*[@id='turnon1']");
		webtest.click("xpath=.//*[@id='auth0']");
		webtest.click("xpath=.//*[@id='debug2']");
		webtest.click("xpath=.//*[@id='submit']");
	}	
	
	@Test(dependsOnMethods="EditsendEmail")
	public void TestsendEmail(){
		
		//发信编辑
		webtest.click("xpath=html/body/div[2]/div/div[2]/div[2]/button");
		webtest.click("xpath=.//*[@id='to']");
		webtest.click("value=pandami");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void recyclebin(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//查看回收站及已隐藏的对象
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[3]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void LAplantask(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//查看并添加计划任务
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a[2]");
		webtest.type("xpath=.//*[@id='h']", "20");
		webtest.type("xpath=.//*[@id='dom']", "2");
		webtest.type("xpath=.//*[@id='mon']", "10");
		webtest.type("xpath=.//*[@id='dow']", "4");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void ClosePlantask(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//关闭计划任务
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a[1]");
		//浏览器弹窗的定位
		webtest.getAlert().accept();
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void backups(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//查看备份并设置备份天数
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menuActions']/div/a[1]");
		webtest.type("xpath=.//*[@id='saveDays']", "30");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("保存成功"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void RestoreBackups(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//还原备份
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		//浏览器弹窗定位
		webtest.getAlert().accept();
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
		
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void DeleteBackups(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//删除备份
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
		//浏览器弹窗定位
		webtest.getAlert().accept();
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}

	public static Properties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
