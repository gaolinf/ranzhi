package ranzhi;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Extend extends BaseTest{
	@Test
	public void GetInBackStage(){
		//��¼Ȼ֮ϵͳ
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void Extension(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//��չ-��ȡ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
		
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void DownloadPlugin(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//��չ-��ȡ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		//���ز��
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void Plugininfoemation(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//��չ-��ȡ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		//�鿴�������
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
		//��չ-��ȡ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
		
		//���ò��
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[4]/a");
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
}