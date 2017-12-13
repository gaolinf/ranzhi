package ranzhi;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class login extends BaseTest{
	@Test
	public void loginranzhi(){
		//登录然之系统
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="loginranzhi" )
	public void GetInBackStage(){
		//进入后台管理
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void CompanyName(){
		//输入公司名称
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[1]/a");
		webtest.type("name=name", "然之公司");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="CompanyName")
	public void zzcyname(){
		//输入后台管理的组织中添加成员的用户名
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[1]");
		webtest.type("xpath=.//*[@id='account']","jo2o0w");
		webtest.type("name=realname", "冀晋文");
		webtest.click("xpath=.//*[@id='genderm']");
		webtest.type("name=password1", "123456");
		webtest.type("name=password2", "123456");
		webtest.type("name=email", "11551395@qq.com");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="zzcyname")
	public void bmname(){
		//添加后台管理中维护部门中的部门
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.type("xpath=.//*[@id='children[]']", "我是部门");
		webtest.type("xpath=.//*[@id='children[]']", "我也是部门");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void shangjibumen(){
		//添加后台管理的组织中各部门的上级部门
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
		//编辑后台管理的组织中各部门的部门名称
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div/div/div[1]/div/div[2]/a[2]");
		webtest.click("xpath=.//*[@id='treeMenuBox']/ul/li/ul/li/a[1]");
		webtest.type("name=name", "我才是部门");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void bumenmanager(){
		//编辑后台管理的组织中部门的部门经理
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
		//在后台管理-组织-成员列表中搜索某一成员
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[2]/a");
		webtest.type("name=query","admin");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void addgroup(){
		//在后台管理-权限中添加分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/div/span/a");
		webtest.type("xpath=.//*[@id='name']", "Group-1");
		webtest.type("xpath=.//*[@id='desc']", "The group number is 1");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void deletegroup(){
		//在后台管理-权限中删除某一分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[4]/td[5]/a[5]");
		webtest.getAlert();
		webtest.alertAccept();
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void shouquan(){
		//在权限中授权某一应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[1]");
		webtest.click("xpath=.//*[@id='appscash']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupSQ(){
		//授权某一分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[3]");
		webtest.click("xpath=.//*[@id='ajaxForm']/div[1]/div/table/tbody/tr[4]/th/label/input");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void editgroup(){
		//编辑某一分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[4]");
		webtest.type("xpath=.//*[@id='name']","1");
		webtest.type("xpath=.//*[@id='desc']","111");
		webtest.click("xpath=.//*[@id='submit']");
		
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupmembers(){
		//编辑某一分组的成员
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[2]");
		webtest.click("xpath=.//*[@id='membersadmin']");
		webtest.click("xpath=.//*[@id='memberspandami']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AddApps1(){
		//添加一个应用 方法一
		//可添加数据驱动
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
		//更改应用权限
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[1]");
		webtest.click("xpath=.//*[@id='groups5']");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppStyle(){
		//更改应用样式
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[2]");
		webtest.click("xpath=.//*[@id='control']");
		webtest.click("value=full");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void EditApp(){
		//编辑应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='entryList']/li[1]/div/div[6]/a[4]");
		webtest.type("xpath=.//*[@id='name']", "客户管理1");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AddApps2(){
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
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppGroup1(){
		//维护分组 方法一
		//可添加数据驱动
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=html/body/div[2]/div/div/div[1]/div/a[1]");
		webtest.type("xpath=.//*[@id='children[]']", "group-1");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void AppGroup2(){
		//维护分组 方法二
		//可添加数据驱动
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.type("xpath=.//*[@id='children[]']", "group-2");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void ScanWebAppList(){
		//浏览web应用、最近更新、最新添加、最多下载
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='byupdatedtime']");
		webtest.click("xpath=.//*[@id='byaddedtime']");
		webtest.click("xpath=.//*[@id='bydownloads']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void SearchWebApp(){
		//搜索web应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.type("xpath=.//*[@id='key']", "css");
		webtest.click("class=btn btn-submit");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void InstallWebApp(){
		//安装web应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='webapp9']/div[4]/div/div/a[1]");
	}

	@Test(dependsOnMethods="GetInBackStage")
	public void PreviewWebApp(){
		//预览web应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='useapp6']");
	}

	@Test(dependsOnMethods="GetInBackStage")
	public void WebAppInformation(){
		//查看某一web应用的详细信息
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='webapp6']/div[2]/strong/a");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void BrowseWebApp(){
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
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void WebAppPageSetting(){
		//更改web应用的页码设置
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='_recPerPage']");
		webtest.click("xpath=html/body/div[2]/div[2]/div[2]/div/div/ul/li[2]/a");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void xuanxuanKey(){
		//喧喧秘钥
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[1]/a");
		webtest.type("xpath=.//*[@id='key']","88888888888888888888888888888888");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void sendEmail(){
		//发信
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.type("xpath=.//*[@id='fromAddress']", "123456789@qq.com");
		webtest.click("xpath=.//*[@id='submit']");
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
		//查看回收站及已隐藏的对象
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[3]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void LAplantask(){
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
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void ClosePlantask(){
		//关闭计划任务
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[4]/a");
		webtest.click("xpath=.//*[@id='menuActions']/a[1]");
		//没写完 浏览器弹窗的定位
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void backups(){
		//查看备份并设置备份天数
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menuActions']/div/a[1]");
		webtest.type("xpath=.//*[@id='saveDays']", "30");
		webtest.click("xpath=.//*[@id='submit']");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void RestoreBackups(){
		//还原备份
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		//浏览器弹窗定位
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void DeleteBackups(){
		//删除备份
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[5]/a");
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
		//浏览器弹窗定位
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void Extension(){
		//扩展-获取插件
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[6]/a");
		webtest.click("xpath=html/body/div[1]/div/div[1]/div/a[2]");
	}
	
	@Test(dependsOnMethods="Extension")
	public void DownloadPlugin(){
		//下载插件
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[2]");
	}
	
	@Test(dependsOnMethods="Extension")
	public void Plugininfoemation(){
		//查看插件详情
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[4]/a");
	}
	
	@Test(dependsOnMethods="Extension")
	public void Pluginuse(){
		//试用插件
		webtest.click("xpath=html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]/a[1]");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[2]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div[1]/table/tbody/tr/td[1]/div/ul/li[4]/a");
	}
}