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
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="CompanyName")
	public void zzcyname(){
		//�����̨�������֯����ӳ�Ա���û���
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[1]");
		webtest.type("xpath=.//*[@id='account']","jo2o0w");
		webtest.type("name=realname", "������");
		webtest.click("xpath=.//*[@id='genderm']");
		webtest.type("name=password1", "123456");
		webtest.type("name=password2", "123456");
		webtest.type("name=email", "11551395@qq.com");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="zzcyname")
	public void bmname(){
		//��Ӻ�̨������ά�������еĲ���
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
	public void bumenname(){
		//�༭��̨�������֯�и����ŵĲ�������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li/ul/li/a[1]");
		webtest.type("name=name", "�Ҳ��ǲ���");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void bumenmanager(){
		//�༭��̨�������֯�в��ŵĲ��ž���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li[1]/a[1]");
		webtest.click("xpath=.//*[@id='moderators_chosen']/a");
		webtest.click("xpath=.//*[@id='moderators_chosen']/div/ul/li[7]");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void findmember(){
		//�ں�̨����-��֯-��Ա�б�������ĳһ��Ա
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.type("name=query","admin");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void addgroup(){
		//�ں�̨����-Ȩ������ӷ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/div/span/a");
		webtest.type("xpath=.//*[@id='name']", "Group-1");
		webtest.type("xpath=.//*[@id='desc']", "The group number is 1");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void deletegroup(){
		//�ں�̨����-Ȩ����ɾ��ĳһ����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[4]/td[5]/a[5]");
		webtest.getAlert();
		webtest.alertAccept();
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void shouquan(){
		//��Ȩ������ȨĳһӦ��
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[1]");
		webtest.click("xpath=.//*[@id='appscash']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupSQ(){
		//��Ȩĳһ����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[3]");
		webtest.click("xpath=.//*[@id='ajaxForm']/div[1]/div/table/tbody/tr[4]/th/label/input");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void editgroup(){
		//�༭ĳһ����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[4]");
		webtest.type("xpath=.//*[@id='name']","1");
		webtest.type("xpath=.//*[@id='desc']","111");
		webtest.click("xpath=.//*[@id='submit']");
		
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupmembers(){
		//�༭ĳһ����ĳ�Ա
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[2]");
		webtest.click("xpath=.//*[@id='membersadmin']");
		webtest.click("xpath=.//*[@id='memberspandami']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AddApps1(){
		//���һ��Ӧ�� ����һ
		//�������������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[2]/a");
		webtest.type("xpath=.//*[@id='name']","111");
		webtest.type("xpath=.//*[@id='abbr']", "DS");
		webtest.type("xpath=.//*[@id='code']", "dasen1");
		webtest.type("xpath=.//*[@id='login']", "http://www.baidu.com");
		webtest.click("xpath=.//*[@id='groups3']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppPermission(){
		//����Ӧ��Ȩ��
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[1]");
		webtest.click("xpath=.//*[@id='groups5']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppStyle(){
		//����Ӧ����ʽ
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[2]");
		webtest.click("xpath=.//*[@id='control']");
		webtest.click("value=full");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void EditApp(){
		//�༭Ӧ��
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[4]");
		webtest.type("xpath=.//*[@id='name']", "�ͻ�����1");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AddApps2(){
		//���һ��Ӧ�� ������
		//�������������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=html/body/div[2]/div/div/div[1]/div/a[2]");
		webtest.type("xpath=.//*[@id='name']","111");
		webtest.type("xpath=.//*[@id='abbr']", "DS");
		webtest.type("xpath=.//*[@id='code']", "dasen1");
		webtest.type("xpath=.//*[@id='login']", "http://www.baidu.com");
		webtest.click("xpath=.//*[@id='groups3']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppGroup1(){
		//ά������ ����һ
		//�������������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=html/body/div[2]/div/div/div[1]/div/a[1]");
		webtest.type("xpath=.//*[@id='children[]']", "group-1");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppGroup2(){
		//ά������ ������
		//�������������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.type("xpath=.//*[@id='children[]']", "group-2");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void ScanWebAppList(){
		//���webӦ�á�������¡�������ӡ��������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='byupdatedtime']");
		webtest.click("xpath=.//*[@id='byaddedtime']");
		webtest.click("xpath=.//*[@id='bydownloads']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void SearchWebApp(){
		//����webӦ��
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.type("xpath=.//*[@id='key']", "css");
		webtest.click("class=btn btn-submit");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void InstallWebApp(){
		//��װwebӦ��
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='webapp9']/div[4]/div/div/a[1]");
	}

	@Test(dependsOnMethods="GetInBackStage")
	public void PreviewWebApp(){
		//Ԥ��webӦ��
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='useapp6']");
	}

	@Test(dependsOnMethods="GetInBackStage")
	public void WebAppInformation(){
		//�鿴ĳһwebӦ�õ���ϸ��Ϣ
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='webapp6']/div[2]/strong/a");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void BrowseWebApp(){
		//�������webӦ��
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
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void WebAppPageSetting(){
		//����webӦ�õ�ҳ������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='_recPerPage']");
		webtest.click("xpath=html/body/div[2]/div[2]/div[2]/div/div/ul/li[2]/a");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void xuanxuanKey(){
		//������Կ
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[1]/a");
		webtest.type("xpath=.//*[@id='key']","88888888888888888888888888888888");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void sendEmail(){
		//����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.type("xpath=.//*[@id='fromAddress']", "123456789@qq.com");
		webtest.click("xpath=.//*[@id='submit']");
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
		//�鿴����վ�������صĶ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[3]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void LAplantask(){
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
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void ClosePlantask(){
		//�رռƻ�����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a[1]");
		//ûд�� ����������Ķ�λ
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void backups(){
		//�鿴���ݲ����ñ�������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menuActions']/div/a[1]");
		webtest.type("xpath=.//*[@id='saveDays']", "30");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void RestoreBackups(){
		//��ԭ����
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		//�����������λ
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void DeleteBackups(){
		//ɾ������
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
		//�����������λ
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void Extension(){
		//��չ-��ȡ���
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
	}
	
	@Test(dependsOnMethods="Extension")
	public void DownloadPlugin(){
		//���ز��
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
	}
	
	@Test(dependsOnMethods="Extension")
	public void Plugininfoemation(){
		//�鿴�������
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[4]/a");
	}
	
	@Test(dependsOnMethods="Extension")
	public void Pluginuse(){
		//���ò��
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[4]/a");
	}
}