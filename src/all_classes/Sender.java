package all_classes;
//import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;


/*
public class MailHelper {
	 
	private Properties properties;
	private Session session;
	private String currentEmail;
 
	public MailHelper(String host,String port,
		final String user,final String password,String email){
		properties = new Properties();
		properties.setProperty("mail.smtp.auth","true");
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port",port);
		currentEmail = email;
		session = Session.getInstance(properties,
      		  new javax.mail.Authenticator() {
      			protected PasswordAuthentication getPasswordAuthentication() {
      				return new PasswordAuthentication(user,password);
      			}
      		  });
	}
 
	public void send(String email,String subject,String body) throws Exception{
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(currentEmail));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		msg.setSubject(subject);
		msg.setContent(body, "text/html; charset=utf-8");
		Transport.send(msg);
	}
}


*/



public class Sender {

	
	private String username;
    private String password;
    private Properties props;
 
    public Sender(String host, String port, String username, String password) {
        this.username = username;
        this.password = password;
 
        props = new Properties();
     // props.put("mail.smtp.auth", "true");
     // props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.ssl.trust", "192.168.64.16");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
    }
 
    public void send(String subject, String text, String fromEmail, String toEmail){
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
        	
       	
            Message message = new MimeMessage(session);
            //�� ����
            message.setFrom(new InternetAddress(fromEmail));
            //����
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //��������� ������
            message.setSubject(subject);
            //����������
            message.setContent(text, "text/html;charset=\"UTF-8\"");

            //���������� ���������
            Transport.send(message);
        } catch (MessagingException e) {Loging log = new Loging();
			 							log.log(e," Рассылаю ошибки: ");
        }
       
    }
	
}
