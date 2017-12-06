package authorization;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import all_classes.Experr;
import services.HintTextFieldUI;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class AuthForm extends JFrame{
	public AuthForm() {
	}
	
	private static JTextField textFieldUser;
	private static JPasswordField passwordField;
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lblMessage;
	long i = 0;

	
	public void ShowAuthForm() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(300, 300, 450, 300);
		frame.setTitle("Авторизация");
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnEnter = new JButton("ВХОД");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i = System.currentTimeMillis();
				new AuthService().getAuthDataOnForm();
			}
		});
		btnEnter.setBackground(new Color(51, 153, 153));
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnter.setBounds(134, 218, 191, 29);
		panel.add(btnEnter);

		
		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//textFieldUser.setToolTipText("Пользователь");
		textFieldUser.setBounds(134, 85, 191, 29);
		panel.add(textFieldUser);
		textFieldUser.setColumns(10);
		textFieldUser.setUI(new HintTextFieldUI("Пользователь", false));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//passwordField.setToolTipText("Пароль");
		passwordField.setColumns(10);
		passwordField.setBounds(134, 135, 191, 29);
		panel.add(passwordField);
		passwordField.setUI(new HintTextFieldUI("Пароль", false));
		
		lblMessage = new JLabel("");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(new Color(255, 51, 51));
		lblMessage.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblMessage.setBounds(134, 27, 191, 29);
		panel.add(lblMessage);
		
		frame.setVisible(true);
		panel.setVisible(true);

		MouseListener clickListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	lblMessage.setText("");
            }
		};
		textFieldUser.addMouseListener(clickListener);
		passwordField.addMouseListener(clickListener);
		
	}
	public static JTextField getTextFieldUser() {
		return textFieldUser;
	}
	public static JPasswordField getPasswordField() {
		return passwordField;
	}
	public static void noVisible(){
		frame.setVisible(false);
		panel.setVisible(false);
	}
	public static void setTextOkMessage(String textMassage){
		lblMessage.setForeground(new Color(51,255,153));
		lblMessage.setText(textMassage);
	}
	public static void setTextErrorMessage(String textMassage){
		lblMessage.setForeground(new Color(255,102,102));
		lblMessage.setText(textMassage);
	}
}
