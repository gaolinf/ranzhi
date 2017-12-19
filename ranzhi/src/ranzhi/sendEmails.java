package ranzhi;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.webtest.util.Log;

public class sendEmails {
	
	public void sendMail() throws AddressException, MessagingException{
	    Properties prop = new Properties();
	    prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
	    prop.setProperty("mail.smtp.auth", "true");	
	    
	  //使用JavaMail发送邮件
	  //1.创建session
        Session session = Session.getInstance(prop);
      //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	    session.setDebug(true);
	  //2.通过session得到transport对象
	    Transport ts = session.getTransport("smtp");
	  //3.使用邮箱的用户名和密码连上邮件服务器，发需要提交邮箱的用户名和 给smtp服务器
		ts.connect("smtp.163.com", "15732175160@163.com","123456g");
      //4.创建邮件
		Message message = setMessage(session);//调用setMessage方法
      //5.发送邮件
	    ts.sendMessage(message, message.getAllRecipients());

//		ts.close();
		Log.info("E-mail send");
	}

	private MimeMessage setMessage(Session session) throws AddressException, MessagingException {
	  //1.创建邮件对象
        MimeMessage message = new MimeMessage(session);
      //2.邮件的发件人
        message.setFrom(new InternetAddress("15732175160@163.com"));
      //3.邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("626231936@qq.com"));
//        message.setRecipient(Message.RecipientType.CC, new InternetAddress("glflying@163.com"));
      //4.邮件的标题
        message.setSubject("Report");
      //5.邮件的文本内容
     
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("This is the report.From:高林飞", "text/html;charset=UTF-8");
        //创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("D:\\workspace\\ranzhi\\test-output.zip"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());  
        
        //创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");
        message.setContent(mp);
        
        message.saveChanges();
        
        
     //创建邮件附件
//	     MimeBodyPart attach = new MimeBodyPart();
//	     DataHandler dh = new DataHandler(new FileDataSource("F:\6270E341A79011864A75F3B047B2B164.png"));
//         attach.setDataHandler(dh);
//	     attach.setFileName(dh.getName());  
        
      //6.返回创建好的邮件对象
        return message;
    }
	
	public static void main(String[] args) throws AddressException, MessagingException {
		sendEmails mail = new sendEmails();
		mail.sendMail();
	}
}
