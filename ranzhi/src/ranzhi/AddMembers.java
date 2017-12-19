package ranzhi;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class AddMembers extends BaseTest{
	@Test(dataProvider="addmembers",dataProviderClass=NSDataProvicer.class)
	public void testAddMembers(String name,String realname,String pwd1,String pwd2,String email){
		webtest.open("http://127.0.0.1/ranzhi/sys/user-login-L3JhbnpoaS9zeXMv.html");
		webtest.type("name=account", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=.//*[@id='submit']");
		webtest.click("xpath=.//*[@id='s-menu-superadmin']/button");

		webtest.enterFrame("iframe-superadmin");
		
		AddMembersClass addmem=new AddMembersClass(webtest);
		addmem.input(name,realname,pwd1,pwd2,email);
	}
}
