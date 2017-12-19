package ranzhi;

import javax.mail.MessagingException;

public class testmail {
	Mail mail = null;

	public void sendMail(String title, String content, String recive) throws MessagingException {
		// TODO Auto-generated method stub
		mail = new Mail();

		mail.setMessage(title, content);
		mail.addAttachment("附件", "D:\\workspace\\ranzhi\\test-output\\TestReport.zip");

		mail.addToRecipent(recive);

		mail.sendMail("15732175160@163.com", "123456g", "gaolinfei");
	}

	public static void main(String args[]) throws MessagingException {
		testmail mail = new testmail();
		mail.sendMail("高林飞-测试报告", "用例执行完毕", "942915659@qq.com");
	}
}