package ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Permission extends BaseTest{
	@Test
	public void GetInBackStage(){
		//��¼Ȼ֮ϵͳ
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void addgroup(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//�ں�̨����-Ȩ������ӷ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/div/span/a");
		webtest.type("xpath=.//*[@id='name']", "Group-11");
		webtest.type("xpath=.//*[@id='desc']", "The group number is 11");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
//	@Test(dependsOnMethods="GetInBackStage")
//	public void deletegroup(){
//		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
//		//�ں�̨����-Ȩ����ɾ��ĳһ����
//		webtest.enterFrame("iframe-superadmin");
//		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
//		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[4]/td[5]/a[5]");
//		webtest.getAlert();
//		webtest.alertAccept();
//		webtest.leaveFrame();
//		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
//	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void shouquan(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//��Ȩ������ȨĳһӦ��
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[1]");
		webtest.click("xpath=.//*[@id='appscash']");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupSQ(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//��Ȩĳһ����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[3]");
		webtest.click("xpath=.//*[@id='ajaxForm']/div[1]/div/table/tbody/tr[4]/th/label/input");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("�ɹ�����"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void editgroup(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//�༭ĳһ����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[4]");
		webtest.type("xpath=.//*[@id='name']","1");
		webtest.type("xpath=.//*[@id='desc']","111");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupmembers(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//�༭ĳһ����ĳ�Ա
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[2]");
		webtest.click("xpath=.//*[@id='membersadmin']");
		webtest.click("xpath=.//*[@id='memberspandami']");
		webtest.click("xpath=.//*[@id='submit']");
		//assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
}
