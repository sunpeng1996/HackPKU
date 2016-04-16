package hit.common;

import hit.po.User;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class JavaMailUtils {
	
	public static void main(String[] args) {
		//Send("287594495@qq.com", "测试", "孙鹏");
	}
   
    /**
     * 
     * @author 作者: 如今我已·剑指天涯
     * @Description:发送邮件的静态方法
    TODO
     *创建时间:2016年4月9日下午3:26:25
     * @param to
     * @return
     * @throws Exception 
     * User user,String key
     */
		
		public static void sendMail(String to_mail,String to_title,String to_content){
			try{

				Properties props = new Properties();
				props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.setProperty("mail.smtp.port", "465");
				props.setProperty("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.host","smtp.qq.com"); //   淢   ʼ           Ϣ
				props.put("mail.smtp.auth","true");		//ͬʱͨ    ֤
				Session s = Session.getInstance(props); //        ½ һ   ʼ  Ự
				s.setDebug(true);
				//   ʼ  Ự ½ һ    Ϣ    
				MimeMessage message = new MimeMessage(s);
				//     ʼ   Ϣ
				InternetAddress from = new InternetAddress("209930949@qq.com");
				message.setFrom(from);  //   ÷     
				InternetAddress to = new InternetAddress(to_mail);
				message.setRecipient(Message.RecipientType.TO, to); //     ռ  ˣ                
				message.setSubject(to_title); //        
				message.setText(to_content); //     ż     
				message.setSentDate(new Date());  //   ÷   ʱ  
				//     ʼ 
				message.saveChanges();  //     ʼ     Ϣ
				Transport transport = s.getTransport("smtp");
				
				transport.connect("smtp.qq.com", "209930949", "hyz13669094224");
				transport.sendMessage(message,message.getAllRecipients()); //    ַ
				transport.close();
			}catch(MessagingException e){
				e.printStackTrace();
			}
		}
}

	
    
    