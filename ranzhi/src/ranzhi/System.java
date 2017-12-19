package ranzhi;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class System extends BaseTest{
	@Test
	public void GetInBackStage(){
		//��¼Ȼ֮ϵͳ
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void xuanxuanKey(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//������Կ
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[1]/a");
		webtest.typeAndClear("xpath=.//*[@id='key']","85214632588");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void sendEmail(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.type("xpath=.//*[@id='fromAddress']", "123456789@qq.com");
		webtest.click("xpath=.//*[@id='submit']");
		
		assertTrue(webtest.getHtmlSource().contains("�ɹ�����"));
	}
	
	@Test(dependsOnMethods="sendEmail")
	public void EditsendEmail(){
		
		//���ű༭
		webtest.click("xpath=.//*[@id='turnon1']");
		webtest.click("xpath=.//*[@id='auth0']");
		webtest.click("xpath=.//*[@id='debug2']");
		webtest.click("xpath=.//*[@id='submit']");
	}	
	
	@Test(dependsOnMethods="EditsendEmail")
	public void TestsendEmail(){
		
		//���ű༭
		webtest.click("xpath=html/body/div[2]/div/div[2]/div[2]/button");
		webtest.click("xpath=.//*[@id='to']");
		webtest.click("value=pandami");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void recyclebin(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//�鿴����վ�������صĶ���
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
		//�鿴����Ӽƻ�����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a[2]");
		webtest.type("xpath=.//*[@id='h']", "20");
		webtest.type("xpath=.//*[@id='dom']", "2");
		webtest.type("xpath=.//*[@id='mon']", "10");
		webtest.type("xpath=.//*[@id='dow']", "4");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void ClosePlantask(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//�رռƻ�����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a[1]");
		//����������Ķ�λ
		webtest.getAlert().accept();
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void backups(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//�鿴���ݲ����ñ�������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menuActions']/div/a[1]");
		webtest.type("xpath=.//*[@id='saveDays']", "30");
		webtest.click("xpath=.//*[@id='submit']");
		assertTrue(webtest.getHtmlSource().contains("����ɹ�"));
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void RestoreBackups(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//��ԭ����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		//�����������λ
		webtest.getAlert().accept();
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
		
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void DeleteBackups(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//ɾ������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
		//�����������λ
		webtest.getAlert().accept();
		
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}

	public static Properties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
