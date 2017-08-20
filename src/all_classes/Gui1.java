package all_classes;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gui1 extends JFrame {


	public static JPanel contentPane;
	static JProgressBar progressBar;
	JProgressBar progressBar2;
	JTextField  textField ,
				textField2,
				textField3,
				textField4;
	String find_number_terminal,
		   bonus_number_terminal;
	Boolean visible = true;
	
	
	
	//public String path = new File("").getAbsolutePath();

//************************************************************************************************************	
	public void creature_prog_bar(int max_value_progressbar) {

//		progressBar = new JProgressBar();
//		progressBar.setMaximum(max_value_progressbar);
//		progressBar.setForeground(new Color(51, 204, 102));
//		progressBar.setBackground(new Color(153, 153, 153));
//		Experr.panel_1.add(progressBar, "cell 3 38,growx,aligny center");                    //****�������� �����������
//		progressBar.setVisible(true);
	}
	
	public void runable_progbar(int value_progressBar) {
		
		Experr.progressBar_1.setValue(value_progressBar);
	
	}
	
	
	//*********************************************************************************************************
	
	

	//������ ���� ��� �������� ��������� � ����������  txt 
	public void Gui0(String txt)  {
		
		JFrame frame = new JFrame();                                 //******�������������*******

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
		frame.setTitle("\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435 \u042D\u041A\u0421\u041F\u041E\u0420\u0422\u0410");
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 450, 300, 200);
		
		
		JPanel contentPane = new JPanel();
	
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel(txt);//\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);//SwingConstants
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(51, 0, 204));
		lblNewLabel.setBounds(10, 10, 280, 105);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u041E \u041A");
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(0, 51, 153));
		btnNewButton.setBounds(115, 125, 70, 35);
		contentPane.add(btnNewButton);
		
		
		
		frame.setVisible(true);
		contentPane.setVisible(true);
		lblNewLabel.setVisible(true);
		btnNewButton.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				frame.setVisible(false);
				
				
			}
		});
		
		
	}

//	public void choise_DB()  {
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(153, 204, 204));
//		getContentPane().add(panel, BorderLayout.CENTER);
//		panel.setLayout(null);
//		
//		JLabel label = new JLabel("\u0412\u044B\u0431\u043E\u0440 \u0431\u0430\u0437\u044B \u0434\u0430\u043D\u043D\u044B\u0445 :");
//		label.setForeground(new Color(0, 0, 255));
//		label.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setBounds(10, 11, 214, 44);
//		panel.add(label);
//		
//		
//		ButtonGroup group = new ButtonGroup();
//		
//		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("MySQL");
//		rdbtnNewRadioButton.setSelected(true);
//		rdbtnNewRadioButton.setBackground(new Color(153, 204, 255));
//		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.ITALIC, 16));
//		rdbtnNewRadioButton.setBounds(70, 62, 109, 23);
//		panel.add(rdbtnNewRadioButton);
//		
//		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Derby");
//		rdbtnNewRadioButton_1.setBackground(new Color(153, 204, 255));
//		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
//		rdbtnNewRadioButton_1.setBounds(70, 102, 109, 23);
//		panel.add(rdbtnNewRadioButton_1);
//
//		group.add(rdbtnNewRadioButton);
//        group.add(rdbtnNewRadioButton_1);
//
//		
//	}
	
	
public void Gui111(String telo) {
		
		JFrame frame = new JFrame();                                 //******�������������*******
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
		frame.setTitle("\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435 \u042D\u041A\u0421\u041F\u041E\u0420\u0422\u0410");
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(300, 200, 800, 700);
		
		
		JPanel contentPane = new JPanel();
	
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel(telo);//\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);//SwingConstants
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(51, 0, 204));
		lblNewLabel.setBounds(5, 5, 790, 690);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u041E \u041A");
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(0, 51, 153));
		btnNewButton.setBounds(250, 640, 60, 30);
		contentPane.add(btnNewButton);
		
		
		
		frame.setVisible(true);
		contentPane.setVisible(true);
		lblNewLabel.setVisible(true);
		btnNewButton.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				frame.setVisible(false);
				
				
			}
		});
		
		
	}
	
public void Gui3(String txt) {
		
		JFrame frame = new JFrame();                                 //******�������������*******
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
		frame.setTitle("\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435 \u042D\u041A\u0421\u041F\u041E\u0420\u0422\u0410");
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 450, 300, 200);
		
		
		JPanel contentPane = new JPanel();
	
		contentPane.setBackground(new Color (51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel(txt);//\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);//SwingConstants
		lblNewLabel.setFont(new Font("Arial Black",Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(51, 0, 204));
		lblNewLabel.setBounds(10, 10, 280, 105);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButtonYES = new JButton("Да");
		btnNewButtonYES.setBackground(new Color(204, 204, 204));
		btnNewButtonYES.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButtonYES.setForeground(new Color(0, 51, 153));
		btnNewButtonYES.setBounds(30, 110, 70, 35);
		contentPane.add(btnNewButtonYES);
		
		JButton btnNewButtonNO = new JButton("Нет");
		btnNewButtonNO.setBackground(new Color(204, 204, 204));
		btnNewButtonNO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButtonNO.setForeground(new Color(0, 51, 153));
		btnNewButtonNO.setBounds(200, 110, 70, 35);
		contentPane.add(btnNewButtonNO);
		
		frame.setVisible(true);
		contentPane.setVisible(true);
		lblNewLabel.setVisible(true);
		btnNewButtonYES.setVisible(true);
		btnNewButtonNO.setVisible(true);
		
		
		btnNewButtonYES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);                              //������� ��
	
			}
		});
		
		
		btnNewButtonNO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Loging log = new Loging();
				log.logtext(" ����� �� ��������� ");
				System.exit(0);                                  //������ ���
	
			}
		});
		
		
	}
	


			public void wer(){
	
				
				Gui1 gui1 = new Gui1();
				
				
				String term = gui1.textField.getText();
				gui1.Gui0(term);
				
				
			}

//************************************************������� ���������* ���� ��������************************			
/*	public void Gui_bonus() {
		
				JFrame frame4 = new JFrame();
				frame4.setIconImage(Toolkit.getDefaultToolkit().getImage(JExcel.directory_res + "Ex5.png"));
				frame4.setTitle("���������� ���������� � ��������");
				frame4.setResizable(false);			
				frame4.setBounds(500, 400, 360, 200);
				
				JPanel contentPane4 = new JPanel();		
				contentPane4.setBackground(new Color(102, 153, 255));
				contentPane4.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane4);
				contentPane4.setLayout(null);
				frame4.getContentPane().add(contentPane4);
		
								
				textField4 = new JTextField(10);		
				textField4.setBounds(120, 70, 120, 30);
				textField4.setForeground(new Color(0, 102, 255));
				textField4.setFont(new Font("Tahoma", Font.BOLD, 15));
				contentPane4.add(textField4);
				textField4.setColumns(10);
				
				JLabel lblNewLabel6 = new JLabel("���������� ���������:");
				lblNewLabel6.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel6.setBounds(70, 20, 200, 40);
				lblNewLabel6.setForeground(new Color(240, 240, 240));
				lblNewLabel6.setBackground(new Color(240, 240, 240));
				lblNewLabel6.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane4.add(lblNewLabel6);	
				
				
				JButton btnNewButton7 = new JButton("\u041E \u041A");
				btnNewButton7.setBackground(new Color(204, 204, 204));
				btnNewButton7.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton7.setForeground(new Color(0, 51, 153));
				btnNewButton7.setBounds(145, 125, 70, 35);
				contentPane4.add(btnNewButton7);
				
				frame4.setVisible(true);
				contentPane4.setVisible(true);
				lblNewLabel6.setVisible(true);
				btnNewButton7.setVisible(true);          
			
				
				btnNewButton7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int triger = 0;
							bonus_number_terminal = textField4.getText();
						
							try {
								int	f_nt = Integer.parseInt(bonus_number_terminal);														
								} catch (NumberFormatException e) {
									String txt = "<html><center>������������ ����</html>";
									Gui1 gui1 = new Gui1();
									gui1.Gui0(txt);	
									triger =1;
								  }
						if (triger == 0){
									
								Bonus bonus = new Bonus();
								try {
									bonus.open_bonus();
								} catch (IOException e) {}
								
								bonus.write_bonus(bonus_number_terminal);
														
								try {
									bonus.close_bonus();						
								} catch (IOException e) {
								}						
								frame4.setVisible(false);
								
						}		
						
						
					}
				});
				
				
		}
*/			
//******************************************************************************************************************************			
			
//
//	public void Gui2() {//******������� ���� ���������****************
//		
//		JFrame frame2 = new JFrame();                                    //******�������������*******
//		frame2.setIconImage(Toolkit.getDefaultToolkit().getImage(JExcel.directory_res + "Ex5.png"));//C:\\Users\\������\\Downloads
//		frame2.setTitle("������� ������ � ���������");
//		frame2.setResizable(false);
//		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame2.setBounds(300, 300, 760, 500);
//		
//		
//		
//		
//		Gui1.contentPane = new JPanel();
//		contentPane.setBackground(new Color(142, 153, 255));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		frame2.getContentPane().add(contentPane);
//	
//		
//		
////�������***********************************************************************************
//		JLabel lblNewLabel5 = new JLabel("New label");
//		lblNewLabel5.setIcon(new ImageIcon(JExcel.directory_res + "Trans.jpg"));
//		lblNewLabel5.setBounds(330, 50, 100, 100);
//		contentPane.add(lblNewLabel5);
//		lblNewLabel5.setVisible(true);
//		
//		
//
//		
////*****���� ������ ��������� ��� ������******************************************************************************************************************		
//		textField = new JTextField(10);		
//		textField.setBounds(70, 360, 120, 30);
//		textField.setForeground(new Color(0, 102, 255));
//		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
//		
//		JLabel lblNewLabel = new JLabel("������ �����:");
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblNewLabel.setBounds(70, 330, 120, 30);
//		lblNewLabel.setForeground(new Color(0, 102, 255));
//		lblNewLabel.setBackground(new Color(204, 204, 204));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		contentPane.add(lblNewLabel);
//		
//
//		
//		//*******�������� �������� ��������� ������� �����		
//		textField2 = new JTextField();
//		textField2.setBounds(70, 300, 620, 30);
//		textField2.setForeground(new Color(0, 102, 255));
//		textField2.setFont(new Font("Tahoma", Font.BOLD, 15));
//		contentPane.add(textField2);
//		textField2.setColumns(10);
//		
//		
//		JLabel lblNewLabel3 = new JLabel("�������� �������� ����������:");
//		lblNewLabel3.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblNewLabel3.setBounds(70, 270, 620, 30);
//		lblNewLabel3.setForeground(new Color(0, 102, 255));
//		lblNewLabel3.setBackground(new Color(204, 204, 204));
//		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
//		contentPane.add(lblNewLabel3);
//		
//		
//		JLabel lblNewLabel2 = new JLabel("����� �����:");
//		lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblNewLabel2.setBounds(570, 330, 120, 30);
//		lblNewLabel2.setForeground(new Color(0, 102, 255));
//		lblNewLabel2.setBackground(new Color(204, 204, 204));
//		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
//		contentPane.add(lblNewLabel2);
//		
//				
//		//**************����� ������ ���������************************		
//		textField3 = new JTextField();
//		textField3.setBounds(570, 360, 120, 30);
//		textField3.setForeground(new Color(0, 102, 255));
//		textField3.setFont(new Font("Tahoma", Font.BOLD, 15));
//		contentPane.add(textField3);
//		textField3.setColumns(10);
//		
////*****
//		
////**********************************************************************************************************************************************		
//
//		JButton btnNewButton4 = new JButton("�����");
//		btnNewButton4.setBackground(new Color(0, 100, 250));
//		btnNewButton4.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnNewButton4.setForeground(new Color(0, 250, 250));
//		btnNewButton4.setBounds(335, 360, 90, 30);
//		contentPane.add(btnNewButton4);
//		
//		JButton btnNewButton1 = new JButton("<html><center>������ �������� turbo ver.</html>");
//		btnNewButton1.setBackground(new Color(204, 204, 204));
//		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 16));
//		btnNewButton1.setForeground(new Color(0, 102, 255));
//		btnNewButton1.setBounds(260, 190, 240, 60);
//		contentPane.add(btnNewButton1);
//		
//		
//		JButton btnNewButton2 = new JButton("�����");
//		btnNewButton2.setBackground(new Color(0, 100, 250));
//		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnNewButton2.setForeground(new Color(0, 250, 250));
//		btnNewButton2.setBounds(630, 20, 90, 30);
//		contentPane.add(btnNewButton2);
//		
///*		
//		JButton btnNewButton3 = new JButton("������");
//		btnNewButton3.setBackground(new Color(0, 100, 250));
//		btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN, 14)); // ���� ��������
//		btnNewButton3.setForeground(new Color(0, 250, 250));
//		btnNewButton3.setBounds(40, 20, 90, 30);
//		contentPane.add(btnNewButton3);
//*/		
//		
//		frame2.setVisible(true);
//		contentPane.setVisible(true);
//		btnNewButton1.setVisible(true);
//		btnNewButton2.setVisible(true);
//		
////***************************************************************� � � � � �********************		
//		
//		
//		
//		
//		
//		
//		
//		btnNewButton4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//	
//				
//				
//				
//
//							TextFild tf = new TextFild();				
//							find_number_terminal = textField.getText();	
//							                                                            //�����**************
//							try {
//								tf.read(find_number_terminal);
//							} catch (IOException e) {
//				
//							  }
//							textField3.setText(tf.find_number);		
//							textField2.setText(tf.name_term_in_bpt);
//			
//						
//							
//			}                                                       
//			
//		});
//		
//
//		btnNewButton1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				
//				Files_check f_c = new Files_check();
//				f_c.checking();                                   //"������ ��������"
//	
//			}
//		});
//	
//		
//	
//		btnNewButton2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			
//			
//				Gui1 gui1 = new Gui1();
//				
//				gui1.Gui3("�������� ����� ?");
//				
//				                                      //"�����"
//				
//			}
//		});
//	
/*	
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//	Gui1 gui1 = new Gui1();
				//gui1.Gui_bonus();         //���� �������� �������
				
			
				Bonus bonus = new Bonus();
					try {                                         //������� ������ � ��������� ����������
						bonus.open_bonus();
					} catch (IOException e) {
							
					}
				
					 bonus.write_bonus();
					
					 try {
						bonus.close_bonus();
					} catch (IOException e) {
		
					}
						
	    	}
		});
*/		
		
		
//	}
}