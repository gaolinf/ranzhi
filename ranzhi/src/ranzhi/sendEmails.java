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
	    
	  //ʹ��JavaMail�����ʼ�
	  //1.����session
        Session session = Session.getInstance(prop);
      //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
	    session.setDebug(true);
	  //2.ͨ��session�õ�transport����
	    Transport ts = session.getTransport("smtp");
	  //3.ʹ��������û��������������ʼ�������������Ҫ�ύ������û����� ��smtp������
		ts.connect("smtp.163.com", "15732175160@163.com","123456g");
      //4.�����ʼ�
		Message message = setMessage(session);//����setMessage����
      //5.�����ʼ�
	    ts.sendMessage(message, message.getAllRecipients());

//		ts.close();
		Log.info("E-mail send");
	}

	private MimeMessage setMessage(Session session) throws AddressException, MessagingException {
	  //1.�����ʼ�����
        MimeMessage message = new MimeMessage(session);
      //2.�ʼ��ķ�����
        message.setFrom(new InternetAddress("15732175160@163.com"));
      //3.�ʼ����ռ���
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("626231936@qq.com"));
//        message.setRecipient(Message.RecipientType.CC, new InternetAddress("glflying@163.com"));
      //4.�ʼ��ı���
        message.setSubject("Report");
      //5.�ʼ����ı�����
     
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("This is the report.From:���ַ�", "text/html;charset=UTF-8");
        //�����ʼ�����
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("D:\\workspace\\ranzhi\\test-output.zip"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());  
        
        //���������������ݹ�ϵ
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");
        message.setContent(mp);
        
        message.saveChanges();
        
        
     //�����ʼ�����
//	     MimeBodyPart attach = new MimeBodyPart();
//	     DataHandler dh = new DataHandler(new FileDataSource("F:\6270E341A79011864A75F3B047B2B164.png"));
//         attach.setDataHandler(dh);
//	     attach.setFileName(dh.getName());  
        
      //6.���ش����õ��ʼ�����
        return message;
    }
	
	public static void main(String[] args) throws AddressException, MessagingException {
		sendEmails mail = new sendEmails();
		mail.sendMail();
	}
}
