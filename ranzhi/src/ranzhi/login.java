package ranzhi;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class login extends BaseTest{
	@Test
	public void loginranzhi(){
		//��¼Ȼ֮ϵͳ
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="loginranzhi" )
	public void GetInBackStage(){
		//�����̨����
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void CompanyName(){
		//���빫˾����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[1]/a");
		webtest.type("name=name", "Ȼ֮��˾");
		webtest.enterFrame("ke-edit-iframe");
		webtest.tabPress();
		webtest.tabPress();
		webtest.tabPress();
		webtest.tabType("Ȼ֮Эͬ�칫");
		webtest.click(".//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void zzcyname(){
		//�����̨�������֯����ӳ�Ա���û���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[1]");
		webtest.type("xpath=.//*[@id='account']","jjw");
		webtest.type("name=realname", "������");
		webtest.click("xpath=.//*[@id='genderm']");
		webtest.type("name=password1", "123456");
		webtest.type("name=password2", "123456");
		webtest.type("name=email", "112233445@qq.com");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void bmname(){
		//��Ӻ�̨������ά�������еĲ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.type("xpath=.//*[@id='children[]']", "���ǲ���");
		webtest.type("xpath=.//*[@id='children[]']", "��Ҳ�ǲ���");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void shangjibumen(){
		//��Ӻ�̨�������֯�и����ŵ��ϼ�����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/a[1]");
		webtest.click("xpath=.//*[@id='parent_chosen']/a/div");
		webtest.click("xpath=.//*[@id='parent_chosen']/div/ul/li[2]");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	
}