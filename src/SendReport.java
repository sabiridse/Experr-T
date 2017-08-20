import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendReport {
	private String username;
    private String password;
    private Properties props;
   
 
    public SendReport(String host, String port, String username, String password) {
        this.username = username;
        this.password = password;
 
        props = new Properties();
       // props.put("mail.smtp.auth", "true");
      //  props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "192.168.8.100");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
    }
 
    public void send(String subject, String text, String fromEmail, Address[] toEmails){
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        System.out.println("����� ��������");
        try {
        	
       	
            Message message = new MimeMessage(session);
            //�� ����
            message.setFrom(new InternetAddress(fromEmail));
            //����
            message.setRecipients(Message.RecipientType.TO, toEmails);
            //��������� ������
            message.setSubject(subject);
            //����������
            message.setContent(text, "text/html;charset=\"UTF-8\"");

            //���������� ���������
            Transport.send(message, toEmails);
        } catch (MessagingException e) {Loging log = new Loging();
			 							log.log(e," �������� �����: ");
        }
       
    }



	
	
	
	
	
}
