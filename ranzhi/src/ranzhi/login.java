package ranzhi;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class login extends BaseTest{
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
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void addgroup(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//在后台管理-权限中添加分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/div/span/a");
		webtest.type("xpath=.//*[@id='name']", "Group-1");
		webtest.type("xpath=.//*[@id='desc']", "The group number is 1");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void deletegroup(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//在后台管理-权限中删除某一分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[4]/td[5]/a[5]");
		webtest.getAlert();
		webtest.alertAccept();
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void shouquan(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//在权限中授权某一应用
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[1]");
		webtest.click("xpath=.//*[@id='appscash']");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupSQ(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//授权某一分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[3]");
		webtest.click("xpath=.//*[@id='ajaxForm']/div[1]/div/table/tbody/tr[4]/th/label/input");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void editgroup(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//编辑某一分组
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[4]");
		webtest.type("xpath=.//*[@id='name']","1");
		webtest.type("xpath=.//*[@id='desc']","111");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void groupmembers(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//编辑某一分组的成员
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[3]/a");
		webtest.click("xpath=html/body/div[1]/div/table/tbody/tr[1]/td[5]/a[2]");
		webtest.click("xpath=.//*[@id='membersadmin']");
		webtest.click("xpath=.//*[@id='memberspandami']");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
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
		webtest.type("xpath=.//*[@id='code']", "dasen1");
		webtest.type("xpath=.//*[@id='login']", "http://www.baidu.com");
		webtest.click("xpath=.//*[@id='groups3']");
		webtest.click("xpath=.//*[@id='submit']");
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
		webtest.leaveFrame();
		webtest.open("http://127.0.0.1/ranzhi/sys/admin/");
	}
	
	@Test(dependsOnMethods="GetInBackStage")
	public void xuanxuanKey(){
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");
		//喧喧秘钥
		webtest.enterFrame("iframe-superadmin");
		webtest.click("xpath=.//*[@id='mainNavbar']/ul/li[5]/a");
		webtest.click("xpath=.//*[@id='menu']/ul/li[1]/a");
		webtest.type("xpath=.//*[@id='key']","88888888888888888888888888888888");
		webtest.click("xpath=.//*[@id='submit']");
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
	
	@Test(dependsOnMethods="Extension")
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
	
	@Test(dependsOnMethods="Extension")
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
	
	@Test(dependsOnMethods="Extension")
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