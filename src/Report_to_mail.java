import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Report_to_mail {
	 public SendReport sender;
public void open_socket() {
	
		
		sender = new SendReport("192.168.8.100",                     //адрес SMTP сервера
				   "25",                                //порт  SMTP сервера
				   "tm/pavlovd",                //логин учетки БЕЗ АВТОРИЗАЦИИ
				   "Pa666oV");	                     //пароль учетки БЕЗ АВТОРИЗАЦИИ
//		
		
//			sender = new Sender("webmail.td-mobile.ru",                     //адрес SMTP сервера
//									   "25",                                //порт  SMTP сервера
//									   "",                //логин учетки БЕЗ АВТОРИЗАЦИИ
//									   "");	                     //пароль учетки БЕЗ АВТОРИЗАЦИИ
	}
	
	
	public void resiv_mail(String table, Address [] mailto){
		
				
	
					sender.send("Список ошибок",
								table,							//ТЕКСТ САМОГО ПИСЬМА
						       "it_ss@td-mobile.ru",                //отправительписьма
						       mailto);                 //получатель письма
	   			   
	}

	public void address_repo() throws AddressException{
		System.out.println("Создаю адреса рассылки : ");
		
		Address [] mailto = new Address[5];

			mailto[0]=new InternetAddress("pavlovd@td-mobile.ru");
			mailto[1]=new InternetAddress("it_ss@td-mobile.ru");
			mailto[2]=new InternetAddress("koseva@td-mobile.ru");
			mailto[3]=new InternetAddress("pavlovd@td-mobile.ru");
			mailto[4]=new InternetAddress("pavlovd@td-mobile.ru");
			System.out.println(mailto[0]);
			System.out.println(mailto[1]);
			System.out.println(mailto[2]);
			System.out.println(mailto[3]);
			System.out.println(mailto[4]);
			
		this.resiv_mail("test multiaddress", mailto);
		
	}
	
}
