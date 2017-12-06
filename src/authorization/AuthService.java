package authorization;

import java.util.Timer;
import java.util.regex.Pattern;

import all_classes.BD_write;
import all_classes.Experr;
import all_classes.Loging;

public class AuthService {
	private static AuthForm auth = new AuthForm();
	private static Loging log = new Loging();	

	public void getAuthDataOnForm (){		
		String user = auth.getTextFieldUser().getText();
		String pass = auth.getPasswordField().getText();
		
			if (this.checkLoginValidation(user)){
			
						this.entering(user, pass);
			} else {
						this.errorValidation();
			}
				
	}
	
			private boolean checkLoginValidation(String text){
				boolean status = false;
				if (text.length() < 11){		
					status = Pattern.compile("[a-z]+").matcher(text).matches();
				}
				
				return status;
			}
			
					private void entering(String user, String pass){
						BD_write bdw = new BD_write();
						
						
						if (user.compareTo("")!=0 & pass.compareTo("")!=0){
							
							if (pass.compareTo(bdw.getPacvord(user))==0){
								log.logtext("авторизация пользователя "+user+": успех");
								auth.noVisible();
									try {				
										new Experr().start();
									} catch (Exception e) {
										e.printStackTrace();
									}
							} else {
								log.logtext("авторизация пользователя "+user+": в доступе отказано");
								auth.setTextErrorMessage("В доступе отказано");						
								auth.getTextFieldUser().setText("");
								auth.getPasswordField().setText("");
							}
					
						}
					}
	
	private void errorValidation(){
		log.logtext("ошибка ввода логина");
		auth.setTextErrorMessage("Ошибка ввода");						
		auth.getTextFieldUser().setText("");
		auth.getPasswordField().setText("");
	}
	
}
