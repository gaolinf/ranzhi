package ranzhi;//¼àÌıÆ÷

import javax.mail.MessagingException;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.webtest.util.Log;


public class WebtestListener extends TestListenerAdapter{

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		Log.info("·¢ËÍÓÊ¼şÁË");
		Mail mail = new Mail();		
		try {
			mail.sendMail("15732175160@163.com","123456g","gaolinfei");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}