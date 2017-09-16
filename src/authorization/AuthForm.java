package authorization;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthForm extends JFrame{
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	public AuthForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Public\\workspace\\Experr-t\\res\\ex.ico"));
		setTitle("Авторизация");
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnEnter = new JButton("ВХОД");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AuthForm auth = new AuthForm();
				String user = auth.getTextFieldUser().getText();
				String pass = auth.getPasswordField().getText();
				
				System.out.println("User " + user);
				System.out.println("Pass " + pass);
				
			}
		});
		btnEnter.setBackground(new Color(51, 153, 153));
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnter.setBounds(134, 218, 191, 29);
		panel.add(btnEnter);
		
		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUser.setToolTipText("Пользователь");
		textFieldUser.setBounds(134, 85, 191, 29);
		panel.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setToolTipText("Пароль");
		passwordField.setBounds(134, 135, 191, 29);
		panel.add(passwordField);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(new Color(255, 51, 51));
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessage.setBounds(134, 27, 191, 29);
		panel.add(lblMessage);
		
		this.getRootPane().setVisible(true);
		panel.setVisible(true);
		
		
	}
	public JTextField getTextFieldUser() {
		return textFieldUser;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
