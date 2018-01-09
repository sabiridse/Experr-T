package all_classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import org.apache.derby.client.am.DateTime;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import GUIbonus.CopyPasteDataInkass;
import GUIbonus.Dopi;
import GUIbonus.ShortStataByMarshrut;
import GUIbonus.Statistika;
import Lider_Dps.ServicePPS;
import Osmp_Osmp.Service;
import Ostatki.DataInkassDPS;
import adapter.ExcelAdapter;
import application.Fxrun;
import authorization.AuthForm;
import contextFind.TooManyCriteries;
import contextFind.TooManyInkassTableSerch;
import gruopAddExcept.AddDelExceptTerm;
import inkass.DataForInkass;
import inkass.DataForShortStata;
import inkass.SearchInTTMinkass;
import inkass.TTM_inkass;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import services.CurientTime;
import services.HintTextFieldUI;
import trmlist_report.Update;
import workBeforeStart.ServiceWBS;

import javax.mail.internet.AddressException;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import javax.swing.SpinnerListModel;
import javax.swing.JEditorPane;
import com.toedter.calendar.JDateChooser;

public class Experr {

	
///******insert some text into subbranch for comments 9:39*******
//********************************************************	
	public static int DBtriger = 1;//**1-Sql, 0-Derby
//********************************************************
	
	public static String select_checkbox_print = "";
	private static String [] subArr;
	public static JLabel lblNewLabel_2, lblNewLabel_1;
	public List <String> work_list;
	public static JFrame frmExperrtV;
	public static JTable table;
	public static JTable table_1;
	public static JTable table_term;
	public static JTable table_except;//***
	public static JTable table_workers;
	public static JTable table_2;
	public static JTable table_3;
	public static JTable table_4;
	public static JTable table_5;
	public static int history = 0;

	JTextField textField4;
	public static String path = new File("").getAbsolutePath();// путь у папке с
																// прогой ) в
																// дропбокс на
																// одну а\папку
																// недотягивает)
	public static String dir = System.getProperty("user.home");
	public static String directory_res, distr, groupp, query_group = "terminals.name_distr != '' and ", query_distr = "";
	// public static TableModel model = new DefaultTableModel();
	// public static AddArr_model adm = new AddArr_model();****************************************************************
	public static JPanel contentPane;
	public static JPanel panel_23 = new JPanel();
	JProgressBar progressBar;
	public static JProgressBar progressBar_inkass;
	 

	static JProgressBar progressBar_1;
	JProgressBar progressBar2;
	public static int year, month, day, days_signal = 0, days_pay = 2, Last_inkass = 0;
	public static JButton btnNewButton_1,
						  button_5;
	public static JLabel lblNewLabel_3;
	private static JLabel lebel_countRowsInTTMinkass;

	public static String find_number_terminal, find_terminal, bonus_number_terminal;
	// public static int counte = 1800;
	public static  String date_OT,
						  date_DO;

	public static TermTableModel model = new TermTableModel();
	public static TermTableModel_1 model_1 = new TermTableModel_1();
	public static TermTableMod_terminals model_term = new TermTableMod_terminals();
	public static TermTableMod_except model_except = new TermTableMod_except();
	public static TermTableMod_workers model_work = new TermTableMod_workers();
	public static TTM_spb model_spb = new TTM_spb();
	public static TTM_lo model_lo = new TTM_lo();
	public static TTM_reg model_reg = new TTM_reg();
	public static TTM_inkass model_inkass = new TTM_inkass();
	
	
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public static JTextField textField_8;
	public static JComboBox comboBox;

	public static long hours_signal = 7200000, hours_pay = 0;

	public static JTextField textField_numTerm;
	public static JTextField textField_naneterm;
	public static JTextField textField_numbexcept;
	public static JTextField textField_nameexcept;
	private JTextField textField_work;
	private JTextField textField_workmail;//**
	

	
	String [] work;
	public static JTextField textField_SS_for_repo;
	public static JTextField textField_Path_report;
	public static JTextField textField_last_inkass;
	public static JTextField txtFild_color_mailto1;
	public static JTextField txtFild_color_mailto2;
	
	public static JDateChooser dateChooser_OT;
	public static JDateChooser dateChooser_DO;
	
	private static String distr_inkass3 ="рута";
	public static String distr_inkass4 = "рута";
	public static String distr_inkass5 = "рута";
	public static String distr_inkass6 = "рута";
	public static String distr_inkass2 = "рута";
	public static int agent = 0;
	public static int limit = 80;
	public static int Summlimit = 70000;
	public static int SummlimitLO = 50000;
	public static int SummlimitPirSps = 20000;
	
	public static int New = 0;
	public static int CheckInkassDPSdata = 0;
	
	public static int allMarshruts = 0;
	public static JTextField textField_search;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {//EventQueue
			public void run() {
				
				Loging log = new Loging();
				log.logtext(" Старт программы "
							+"******************************************************************************");
				
				
			
				
				Calendar calendar = Calendar.getInstance();
				day = calendar.get(Calendar.DAY_OF_MONTH);
				month = calendar.get(Calendar.MONTH) + 1;
				year = calendar.get(Calendar.YEAR);

				directory_res = path + "//res//"; // путь к папке с прогой по
				
				new AuthForm().ShowAuthForm();
				
				// умолчанию
//				try {
//					Experr window = new Experr();
//					window.frmExperrtV.setVisible(true);//*****для дизайн моде разкоментить
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				
			}
		});
	}
//	public Experr() throws Exception {//*****для дизайн моде разкоментить
//
//		initialize();
//
//	}
	
	public void start() throws Exception {//*****для дизайн моде ЗАкоментить

		initialize();
		try {
			Experr window = new Experr();
			window.frmExperrtV.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private  void initialize() throws Exception {
		
		
		Xml_read xml = new Xml_read();
		
		
		frmExperrtV = new JFrame();
		
//**********************VERSION****************************************************
		frmExperrtV.setTitle("EXperr-t  v.3.0 Auth");//**********************VERSION**
//*********************************************************************************
		
		
		//frame.setOpacity(0.0f);
		frmExperrtV.setResizable(true);
		frmExperrtV.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmExperrtV.setIconImage(Toolkit.getDefaultToolkit().getImage(directory_res + "Ex5.png"));
		frmExperrtV.setBounds(5, 5, 1157, 870);
		frmExperrtV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExperrtV.getContentPane().setLayout(new BorderLayout(0, 0));
		frmExperrtV.setMinimumSize(new Dimension(700, 690));
		
		final JFXPanel fxPanel = new JFXPanel();
		frmExperrtV.getContentPane().add(fxPanel);//**************************************************JAVAFX****************
		
		
		Platform.runLater(new Runnable() {
			@Override
			 public void run() {
				new Fxrun().initFX(fxPanel);
			}
		});
	
		
									
		JScrollPane scrollPane_2 = new JScrollPane();
		frmExperrtV.getContentPane().add(scrollPane_2, BorderLayout.CENTER);		
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane_2.setViewportView(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setPreferredSize(new Dimension(1120, 820));
				
				ChangeListener listener = new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		                JSpinner js = (JSpinner) e.getSource();
		                hours_signal = 3600000 * (new Long(js.getValue().toString()));
		            }
		        };
				ChangeListener listener_1 = new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		                JSpinner js_1 = (JSpinner) e.getSource();
		                days_signal = (new Integer(js_1.getValue().toString()));
		            }
		        };
				ChangeListener listener_2 = new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		                JSpinner js_2 = (JSpinner) e.getSource();
		                days_pay = (new Integer(js_2.getValue().toString()));
		            }
		        };
				ChangeListener listener_3 = new ChangeListener() {
		            public void stateChanged(ChangeEvent e) {
		                JSpinner js_3 = (JSpinner) e.getSource();
		                hours_pay = 3600000 * (new Long(js_3.getValue().toString()));
		            }
		        };
				
				RowSorter<TermTableModel_1> sorter_1 = new TableRowSorter<TermTableModel_1>(model_1);
				RowSorter<TermTableMod_workers> sorter_work = new TableRowSorter<TermTableMod_workers>(model_work);

		        BD_write bdw = new BD_write();
				work_list = bdw.reqest_in_workerslist();
				work = work_list.toArray(new String[work_list.size()]);
				
				RowSorter<TermTableMod_terminals> sorter_term = new TableRowSorter<TermTableMod_terminals>(model_term);
				RowSorter<TermTableMod_except> sorter_except = new TableRowSorter<TermTableMod_except>(model_except);
				
//*****************комбобокс  работников************************************************************************************				
				JComboBox combo_1 = new JComboBox(work);
				combo_1.setMaximumRowCount(20);				
//***************************************************************************************************				
			//*****************МАССИВ  маршрутов для комбобокса		        
		        List <String> distrs_list = bdw.reqest_in_distrs();
				String [] distrs = distrs_list.toArray(new String[distrs_list.size()]);
//********************************************************************************************				
				JComboBox combo_2 = new JComboBox(distrs);//*/****комбо маршрутов в самой таблице терминалов
				combo_2.setMaximumRowCount(20);								
								
								ButtonGroup group = new ButtonGroup();								    										    						
//*************************************************************************
								
			    ActionListener listen = new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent ae) {		            			            	
				                switch ( ((JRadioButton)ae.getSource()).getText() ) {
				                case "SQL" :
				                	DBtriger = 1;
				                    break;
				                case "Derby" :
				                	ChooseColor cc=new ChooseColor();
				                	cc.setColor();
				                	
				                    break;		                
				                }
				                BD_write bdw = new BD_write();
				                bdw.connect();
								try {
									bdw.reqest_in_db_1();
								} catch (ClassNotFoundException e1) {}

								bdw.close_connect();
																							
								try {
									bdw.reqest_in_db_TTmodel_except();
								} catch (ClassNotFoundException e1) {}
								
								try {
									bdw.reqest_in_db_TTmodel_workers();
								} catch (ClassNotFoundException e1) {}

		            }
		        };
			        						                            				
			        						                            				JPanel panel_3 = new JPanel();
			        						                            				tabbedPane.addTab("\u041E\u0448\u0438\u0431\u043A\u0438", null, panel_3, null);
			        						                            				tabbedPane.setBackgroundAt(0, new Color(51, 204, 255));
			        						                            				panel_3.setLayout(new BorderLayout(0, 0));
			        						                            				
			        						                            				JPanel panel_4 = new JPanel();
			        						                            				panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        						                            				panel_4.setBackground(new Color(51, 153, 153));
			        						                            				panel_3.add(panel_4, BorderLayout.SOUTH);
			        						                            				panel_4.setLayout(new MigLayout("", "[145.00][56.00,left][912.00,grow,fill]", "[16px,bottom]"));					                            				
//**************************************************************************************************					    													        						                            				
			        						                            				JLabel label = new JLabel("\u041A\u043E\u043B-\u0432\u043E \u043E\u0448\u0438\u0431\u043E\u043A :");
			        						                            				panel_4.add(label, "cell 0 0");//********eie-ai ioeaie
			        						                            				label.setVerticalAlignment(SwingConstants.TOP);
			        						                            				label.setForeground(new Color(153, 255, 153));
			        						                            				label.setFont(new Font("Tahoma", Font.ITALIC, 16));
		        						                            							        						                            				
//*****************************************************************************************************************************							        						                            				
			        						                            				progressBar_1 = new JProgressBar();
			        						                            				panel_4.add(progressBar_1, "cell 2 0,grow");
			        						                            				progressBar_1.setStringPainted(true);
			        						                            				progressBar_1.setForeground(new Color(51, 204, 102));
			        						                            				progressBar_1.setBackground(new Color(153, 153, 153));
			        						                            				progressBar_1.setMaximum(2000);			        						                            				
//***********************счетчик кол-ва ошибок*********
			        						                            				lblNewLabel_3 = new JLabel();
			        						                            				lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			        						                            				lblNewLabel_3.setText("125");
			        						                            				panel_4.add(lblNewLabel_3, "cell 1 0,grow");
			        						                            				lblNewLabel_3.setForeground(new Color(204, 153, 153));
			        						                            				lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
			        						                            				
			        						                            				JPanel panel_5 = new JPanel();
			        						                            				panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        						                            				panel_5.setBackground(new Color(51, 153, 153));
			        						                            				panel_3.add(panel_5, BorderLayout.WEST);
			        						                            				panel_5.setLayout(new BorderLayout(0, 0));
			        						                            				
			        						                            				JPanel panel_6 = new JPanel();
			        						                            				panel_6.setBackground(new Color(51, 153, 153));
			        						                            				panel_5.add(panel_6, BorderLayout.CENTER);
			        						                            				panel_6.setLayout(null);
			        						                            				    										
//*****контекстный поиск терминала в таблице ошибок*************************************************					    										
			JButton button_1 = new JButton("\u041F\u043E\u0438\u0441\u043A");
			button_1.setToolTipText("\u041A\u043E\u043D\u0442\u0435\u043A\u0441\u0442\u043D\u044B\u0439 \u043F\u043E\u0438\u0441\u043A \u0442\u0435\u0440\u043C\u0438\u043D\u0430\u043B\u043E\u0432");
			button_1.setBounds(5, 95, 97, 29);
			panel_6.add(button_1);
			button_1.setForeground(new Color(153, 204, 153));
			button_1.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			button_1.setBackground(new Color(51, 153, 153));
			
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					

					BD_write bdw = new BD_write();
					switch (Experr.history){
					
					case 0 : String query_find = new TooManyCriteries().addQuery();											
								
								bdw.connect();
									try {
										bdw.reqest_in_db(query_find);
									} catch (Exception e) {
										
										System.out.println("context serch " +e);
									}
								bdw.close_connect(); break;
					case 1 :    try {
									bdw.main_reqest();
								} catch (Exception e) {
									e.printStackTrace();
								}		
					}
				}                                                       
				
			});
//************************************************************************************************************			        						                            							        						                            							        						                            				
			      textField_8 = new JTextField();
			      textField_8.setToolTipText("\u0432\u0432\u0435\u0434\u0438\u0442\u0435  \u043D\u043E\u043C\u0435\u0440 \u0442\u0435\u0440\u043C\u0438\u043D\u0430\u043B\u0430 \u0438\u043B\u0438 \u0447\u0430\u0441\u0442\u044C \u0430\u0434\u0440\u0435\u0441\u0430 ( \u043D\u0430\u0437\u0432\u0430\u043D\u0438\u044F)");
			      textField_8.setBounds(5, 64, 97, 20);
			      panel_6.add(textField_8);
			      textField_8.setColumns(100);
			      textField_8.setUI(new HintTextFieldUI("Поиск", false));
			      
			      JButton button_3 = new JButton("\u0412\u042B\u0425\u041E\u0414");
			      button_3.setBounds(5, 10, 97, 30);
			      panel_6.add(button_3);
			      button_3.setForeground(new Color(255, 153, 51));
			      button_3.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			      button_3.setBackground(new Color(255, 255, 153));

//*******aaeea i?eioa?a******************************************************************************************
			      JCheckBox checkBox_2 = new JCheckBox("\u041F\u0440\u0438\u043D\u0442\u0435\u0440");
			      checkBox_2.setToolTipText("\u043E\u0448\u0438\u0431\u043A\u0430 \"\u043F\u0440\u0438\u043D\u0442\u0435\u0440\"");
			      checkBox_2.setBounds(6, 187, 96, 25);
			      panel_6.add(checkBox_2);
			      checkBox_2.setBackground(new Color(0, 153, 153));
			      checkBox_2.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			      checkBox_2.setForeground(new Color(0, 204, 153));
			      
			      checkBox_2.addItemListener(new ItemListener() {
			          public void itemStateChanged(ItemEvent e) {
			            
					        	 if (checkBox_2.isSelected()) {
					        		 select_checkbox_print = " or print !='OK'";
					        		 
					        	 } else select_checkbox_print = "";
			          
					        	 BD_write bdw = new BD_write();
					    		  bdw.connect();
					    		  
					    		  try {
					    			  bdw.main_reqest();
					    		  } catch (Exception ex) {
					    			  
					    			  System.out.println("cai?in e i?eioa?o " +ex);
					    		  }
					    		  bdw.close_connect();			          
			          }
			      });
//************************************************************************************************************			      
			      JLabel label_6 = new JLabel("\u041C\u0430\u0440\u0448\u0440\u0443\u0442\u044B");
			      label_6.setBounds(0, 239, 102, 20);
			      panel_6.add(label_6);
			      label_6.setHorizontalAlignment(SwingConstants.CENTER);
			      label_6.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			      label_6.setForeground(new Color(51, 102, 51));
			      
			        //******************************ia?o?oou***********************************************************************						                            				
			        				comboBox = new JComboBox();
			        				comboBox.setBounds(5, 259, 97, 23);
			        				panel_6.add(comboBox);
			        				comboBox.setMaximumRowCount(12);
			        				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
			        				comboBox.setModel(new DefaultComboBoxModel(new String[] {
			        						 "ВСЕ",
											 "В.Новгород",
											 "Волхов",
											 "Всеволожск",
											 "Выборг",
											 "Гатчина",	
											 "Кингисепп",
											 "Кириши",
											 "Колпино",
											 "Коменда",
											 "Курорт",	
											 "Лодейное поле",
											 "Ломоносов",
											 "Луга",
											 "ПБ",
											 "Петрозаводск",
											 "Подпорожье",
											 "Приозерск",
											 "Псков",
											 "Север",
											 "Сланцы",
											 "Тихвин",
											 "Тосно",	
											 "Центр",
											 "ЮЗ"}));
			        				comboBox.setSelectedIndex(1);
			        				
			        				JLabel label_16 = new JLabel("\u0413\u0440\u0443\u043F\u043F\u044B");
			        				label_16.setBounds(26, 286, 52, 17);
			        				panel_6.add(label_16);
			        				label_16.setHorizontalAlignment(SwingConstants.CENTER);
			        				label_16.setForeground(new Color(51, 102, 51));
			        				label_16.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        						                            				
	//*******выбор группы маршрутов в таблице ошибок*********************************************************************************************************************					    										
			        						                            				
			  		JComboBox comboBox_1 = new JComboBox();
			  		comboBox_1.setBounds(5, 306, 97, 23);
			  		panel_6.add(comboBox_1);
			  		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ВСЕ", "СПб и ЛО", "Регионы", "СПб", "ЛО"}));
			  		comboBox_1.setSelectedIndex(0);
			  		comboBox_1.setMaximumRowCount(12);
			  		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			  					  					  		
			  		JButton button = new JButton("Почта");
			  		button.setToolTipText("\u041D\u0430\u0447\u0430\u0442\u044C \u0440\u0430\u0441\u0441\u044B\u043B\u043A\u0443 \u043E\u0448\u0438\u0431\u043E\u043A");
			  		button.setBounds(5, 371, 97, 29);
			  		panel_6.add(button);
			  		button.setForeground(new Color(153, 204, 153));
			  		button.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			  		button.setBackground(new Color(0, 153, 153));			        						                            				
			        						                            						    										
//***************************************Ia?aou*******************************************************************************
			      		JButton button_print = new JButton("\u041F\u0435\u0447\u0430\u0442\u044C");
			      		button_print.setToolTipText("\u041D\u0430\u043F\u0435\u0447\u0430\u0442\u0430\u0442\u044C \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u0435 \u043E\u0448\u0438\u0431\u043A\u0438 (\u0432\u044B\u0431\u0440\u0430\u0442\u044C \u043E\u0440\u0438\u0435\u043D\u0442\u0430\u0446\u0438\u044E \u043B\u0438\u0441\u0442\u0430)");
			      		button_print.setBounds(5, 411, 97, 30);
			      		panel_6.add(button_print);
			      		button_print.setForeground(Color.YELLOW);
			      		button_print.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			      		button_print.setBackground(new Color(0, 153, 153));
			        						                            				
//*****************************************************************************************************************************					    
			        						                            				
			      	JSeparator separator = new JSeparator();
			      	separator.setBounds(5, 51, 97, 2);
			      	panel_6.add(separator);
			      	
			      	JSeparator separator_10 = new JSeparator();
			      	separator_10.setBounds(5, 135, 97, 2);
			      	panel_6.add(separator_10);
			      	
			      	JSeparator separator_11 = new JSeparator();
			      	separator_11.setBounds(5, 226, 97, 2);
			      	panel_6.add(separator_11);
			      	
			      	JSeparator separator_12 = new JSeparator();
			      	separator_12.setBounds(5, 348, 97, 2);
			      	panel_6.add(separator_12);
			      	
			      	JSeparator separator_13 = new JSeparator();
			      	separator_13.setBounds(5, 461, 97, 2);
			      	panel_6.add(separator_13);
			        						                            							
			      JLabel lblNewLabel = new JLabel("\u0420\u0430\u0441\u0441\u044B\u043B\u043A\u0430");
			      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			      lblNewLabel.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			      lblNewLabel.setForeground(new Color(51, 102, 0));
			      lblNewLabel.setBounds(10, 474, 87, 20);
			      panel_6.add(lblNewLabel);
			      
			      JLabel label_11 = new JLabel("\u0431\u044B\u043B\u0430 :");
			      label_11.setToolTipText("\u0412\u0440\u0435\u043C\u044F \u043F\u043E\u0441\u043B\u0435\u0434\u043D\u0435\u0433\u043E \u043D\u0430\u0436\u0430\u0442\u0438\u044F \u043D\u0430 \u043A\u043D\u043E\u043F\u043A\u0443 \"\u041F\u041E\u0427\u0422\u0410\"");
			      label_11.setHorizontalAlignment(SwingConstants.CENTER);
			      label_11.setForeground(new Color(51, 102, 0));
			      label_11.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			      label_11.setBounds(5, 493, 87, 20);
			      panel_6.add(label_11);
			      
			      JLabel label_time_to_last_mail = new JLabel("");
			      label_time_to_last_mail.setHorizontalAlignment(SwingConstants.CENTER);
			      label_time_to_last_mail.setForeground(new Color(51, 102, 0));
			      label_time_to_last_mail.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			      label_time_to_last_mail.setBounds(5, 512, 87, 20);
			      panel_6.add(label_time_to_last_mail);

			      button_print.addActionListener(new ActionListener() {
			    	  public void actionPerformed(ActionEvent arg0) {
			    		  try {
			    			  table.print();
			    			 
			    		  } catch (PrinterException e) {
			    			  
			    			  e.printStackTrace();
			    		  }					
			    		  
			    	  }			    	  			    	  
			      });			    										
 
//*************************?eoa? ec AA a?aiy iineaaiae ?annueee*****************		    		 	    			 
	    			 label_time_to_last_mail.setText(bdw.get_time_last_mail());
	    			 
	    			 JButton btnInkassDPS = new JButton("Инкасс ДПС");
	    			 btnInkassDPS.setToolTipText("Добавление в базу дат инкассации ДПС (предварительно скачать отчет)");
	    			 btnInkassDPS.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    			 btnInkassDPS.setForeground(new Color(102, 204, 102));
	    			 btnInkassDPS.setBackground(new Color(51, 153, 153));
	    			 btnInkassDPS.setBounds(5, 535, 97, 30);
	    			 panel_6.add(btnInkassDPS);
	    			 
	    			 btnInkassDPS.addActionListener(new ActionListener() {
				    	  public void actionPerformed(ActionEvent arg0) {
				    		  new DataInkassDPS().getLastInkassDpsAndWriteInOstatki();
				    	  }			    	  			    	  
				      });		
	    			 	    			 			      
//***************************************************ПОЧТА**********************************************				
			      button.addActionListener(new ActionListener() {
			    	  public void actionPerformed(ActionEvent arg0) {
			    		
			    		  Loging log = new Loging();
							log.logtext(" Делаю рассылку. ");
		    		  
	//****************************Ieoo a?aiy iineaaiae ?annueee	(oaeuaa) a AA****					
							long curTime = System.currentTimeMillis();
			    			 String curientStringDateTame = new SimpleDateFormat("HH:mm").format(curTime);
			    			 bdw.set_time_last_mail(curientStringDateTame);
			    			 
	//*****************************************************************		    			 			    			 
			    			 SendMail sm = new SendMail();	
			    		  try {
							sm.data_for_send_mails();
						} catch (IOException e) {
							
							e.printStackTrace();
						}	
			    		  
			    		  label_time_to_last_mail.setText(bdw.get_time_last_mail());
			    	  }			    	  
			    	  
			      });
			      
			      comboBox_1.addActionListener(new ActionListener() {
			    	  public void actionPerformed(ActionEvent event) {             //****выбор группы
			    		  groupp = comboBox_1.getSelectedItem().toString();
			    		  
			    		  if (groupp.contains("ВСЕ") == true) {query_group = "terminals.name_distr != '' and ";}
			    		  if (groupp.contains("ВСЕ") == false) {
			    			  
			    			  switch (groupp) {
			    			  
			    			  case "СПб и ЛО" : query_group = " terminals.spb_lo = 1 and "; break;
			    			  
			    			  case "Регионы" : query_group  = " terminals.regions = 1 and "; break;
			    			  
			    			  case "СПб" :	query_group =   " terminals.spb = 1 and "; break;
			    			  
			    			  case "ЛО" :   query_group   =  " terminals.lo = 1 and "; break;
			    			  
			    			  }
			    		  }			    		  	
			    		  	
			    		  BD_write bdw = new BD_write();
			    		  bdw.connect();
			    		  
			    		  try {
			    			  bdw.main_reqest();
			    		  } catch (Exception e) {
			    			  
			    			  System.out.println("111 " +e);
			    		  }
			    		  bdw.close_connect();
			    		  
			    	  }
			      });			      
			      
			      comboBox.addActionListener(new ActionListener() {
			    	  public void actionPerformed(ActionEvent event) {           //****выбор маршрута
							distr = comboBox.getSelectedItem().toString();
			    		 // distr = comboBox.getSelectedItem().toString();
			    		  
			    		  if (distr.contains("ВСЕ") == true) {query_distr = " terminals.name_distr != '' and ";}
			    		  if (distr.contains("ВСЕ") == false) {query_distr = " terminals.name_distr = '" + distr + "' and ";}
			    		  BD_write bdw = new BD_write();
			    		  bdw.connect();
			    		  
			    		  try {
			    			  bdw.main_reqest();
			    		  } catch (Exception e) {
			    			  
			    			  System.out.println("1 " +e);
			    		  }
			    		  bdw.close_connect();
			    		  
			    	  }
			      });			      
			      
//**********подсветка  кнопки выход при наведении мышки на нее*************************************																
			        						                            															
			    		button_3.addMouseListener(new MouseListener() {
			   
			    			public void mouseEntered(MouseEvent event) {
			    				
			    				button_3.setBackground(new Color(204, 0, 51));
			    				button_3.setForeground(new Color(255, 153, 51));
			    			}
			    			
			    			@Override
			    			public void mouseClicked(MouseEvent e) {			    				
			    				
			    			}
			    			
			    			@Override
			    			public void mousePressed(MouseEvent e) {			    				
			    				
			    			}
			    			
			    			@Override
			    			public void mouseReleased(MouseEvent e) {			    				
			    				
			    			}
			    			
			    			@Override
			    			public void mouseExited(MouseEvent e) {
			    				button_3.setBackground(new Color(255, 255, 153));
			    				button_3.setForeground(new Color(255, 153, 51));
			    				
			    			}			    			
			    			
			    		});
//********************************************************************************************			    					    		
			    		
			    		button_3.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent arg0) {
			    				
			    				Gui1 gui1 = new Gui1();
			    				
			    				gui1.Gui3("СЛУЧАЙНО НАЖАЛ ?"); //"ВЫХОД"
			    				
			    			}
			    		});
			    		
			    		JPanel panel_7 = new JPanel();
			    		panel_5.add(panel_7, BorderLayout.SOUTH);
			    		panel_7.setLayout(new BorderLayout(0, 0));
			    		
			    		JPanel panel_8 = new JPanel();
			    		panel_8.setBackground(new Color(51, 153, 153));
			    		panel_7.add(panel_8, BorderLayout.NORTH);			    		
			        						                            																												
//*****************СТАРТ****************************************************									
			    		btnNewButton_1 = new JButton("\u0421\u0422\u0410\u0420\u0422");
			    		btnNewButton_1.setToolTipText("\u0417\u0430\u043F\u0443\u0441\u043A \u0441\u0431\u043E\u0440\u0430 \u043E\u0448\u0438\u0431\u043E\u043A \u0438\u0437  \u0444\u0430\u0439\u043B\u043E\u0432");
			    		panel_8.add(btnNewButton_1);
			    		btnNewButton_1.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
			    		btnNewButton_1.setForeground(new Color(153, 204, 153));
			    		btnNewButton_1.setBackground(new Color(0, 102, 255));
			    		btnNewButton_1.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent arg0) {
			    				
			    				Loging log = new Loging();
			    				
//				    				log.logtext(" Объединяю файлы и создаю в нужном формате ");			    				
			    				ServiceWBS swbs = new ServiceWBS();
				    						   swbs.creatureAllFiles();
			    							    				
						    				log.logtext(" Собираю данные об ошибках ");				    				
						    				btnNewButton_1.setEnabled(false);
						    				//button_5.setVisible(true);
						    				Files_check f_c = new Files_check();
						    				f_c.checking();                         //"Запуск ЭКСПОРТА"
			    							    							    				
			    			}			    						    			
			    		});
			    					    		
//**********подсветка  кнопки СТАРТ при наведении мышки на нее***************************************																
						
			    		btnNewButton_1.addMouseListener(new MouseListener() {
			   
			    			public void mouseEntered(MouseEvent event) {
			    				
			    				btnNewButton_1.setBackground(new Color(51, 204, 0));
			    				btnNewButton_1.setForeground(new Color(0, 102,255));
			    			}
			    			
			    			@Override
			    			public void mouseClicked(MouseEvent e) {
			    							    				
			    			}
			    			
			    			@Override
			    			public void mousePressed(MouseEvent e) {
			    							    				
			    			}
			    			
			    			@Override
			    			public void mouseReleased(MouseEvent e) {
			    							    				
			    			}
			    			
			    			@Override
			    			public void mouseExited(MouseEvent e) {
			    				btnNewButton_1.setBackground(new Color(0, 102, 255));
			    				btnNewButton_1.setForeground(new Color(153, 204, 153));
			    				
			    			}			    			
			    			
			    		});
//********************************************************************************************	
			    		JPanel panel_9 = new JPanel();
			    		panel_9.setBackground(new Color(51, 153, 153));
			    		panel_7.add(panel_9, BorderLayout.SOUTH);
			    		
			    		JLabel lblNewLabel5 = new JLabel();
			    		panel_9.add(lblNewLabel5);
			    		lblNewLabel5.setIcon(new ImageIcon(directory_res + "Ex5big.jpg"));
			    		
			    		JPanel panel_10 = new JPanel();
			    		panel_3.add(panel_10, BorderLayout.CENTER);
			    		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
			    		//*******************************************************************************************************								
			    		
			    		JScrollPane scrollPane = new JScrollPane();
			    		panel_10.add(scrollPane);
			    		scrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 204)));
			    		//**********************************************************************************************************************								
			        	
			    		
			   
			    		
			    		
									table = new JTable(model);																													
									table.setToolTipText("kkkbjkb");
									table.setFont(new Font("Tahoma", Font.PLAIN, 12));
									
									table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
									table.setCellSelectionEnabled(true);
									table.setSelectionBackground(new Color(153, 204, 204));	
									
									table.setBackground(new Color(255, 255, 204));
									table.setRowHeight(22);
									table.setGridColor(Color.BLUE);
													    						
									RowSorter<TermTableModel> sorter = new TableRowSorter<TermTableModel>(model);
									JTableHeader head = table.getTableHeader();								
		    						head.setBackground(new Color(51, 153, 153));
									head.setForeground(new Color(153, 204, 153));
									head.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
									
									table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
										  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
										    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
										    setToolTipText(getText());

										    return this;
										    }
										});
									
									
									table.setDefaultRenderer(String.class, new Render_string());
									table.setDefaultRenderer(DateTime.class, new Render_time());
									
									table.setRowSorter(sorter);									    						
									table.getColumnModel().getColumn(0).setResizable(true);
									table.getColumnModel().getColumn(0).setPreferredWidth(15);
									table.getColumnModel().getColumn(1).setResizable(true);
									table.getColumnModel().getColumn(1).setPreferredWidth(180);
									table.getColumnModel().getColumn(2).setResizable(true);
									table.getColumnModel().getColumn(2).setPreferredWidth(50);
									table.getColumnModel().getColumn(3).setResizable(true);
									table.getColumnModel().getColumn(3).setPreferredWidth(50);
									table.getColumnModel().getColumn(4).setResizable(true);
									table.getColumnModel().getColumn(4).setPreferredWidth(40);
									table.getColumnModel().getColumn(5).setResizable(true);
									table.getColumnModel().getColumn(5).setPreferredWidth(10);
									table.getColumnModel().getColumn(6).setResizable(true);
									table.getColumnModel().getColumn(6).setPreferredWidth(10);
									table.getColumnModel().getColumn(7).setResizable(true);					    										
									table.getColumnModel().getColumn(7).setPreferredWidth(40);
									table.getColumnModel().getColumn(8).setResizable(true);
									table.getColumnModel().getColumn(8).setPreferredWidth(20);
									table.getColumnModel().getColumn(9).setResizable(true);
									table.getColumnModel().getColumn(9).setPreferredWidth(50);
									
									scrollPane.setViewportView(table);
									progressBar_1.setVisible(false);
							       	
									
									
									ExcelAdapter myAd = new ExcelAdapter(table);
									
									
									
									JPanel panel_1 = new JPanel();
									panel_1.setBackground(new Color(102, 153, 153));
									tabbedPane.addTab("\u0422\u0435\u0440\u043C\u0438\u043D\u0430\u043B\u044B", null, panel_1, null);
									tabbedPane.setBackgroundAt(1, new Color(0, 255, 153));
									panel_1.setLayout(new BorderLayout(0, 0));
									
									JPanel panel_11 = new JPanel();
									panel_11.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
									panel_1.add(panel_11, BorderLayout.WEST);
									panel_11.setLayout(new BorderLayout(0, 0));
							       							       							       							       	        
 //*************************************************************************				        
							    JScrollPane scrollPane_term = new JScrollPane();
							    panel_11.add(scrollPane_term);							    
							    
							    table_term = new JTable(model_term);//********************таблица  терминалы
							    scrollPane_term.setViewportView(table_term);
							    table_term.setCellSelectionEnabled(true);
							    table_term.setRowSorter(sorter_term);	
							    table_term.setRowHeight(20);
							    table_term.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(combo_2));
							    
							    JPanel panel_12 = new JPanel();
							    panel_12.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
							    panel_1.add(panel_12, BorderLayout.CENTER);
							    panel_12.setLayout(new BorderLayout(0, 0));
							    //***************************************************************************		        							    
							    JScrollPane scrollPane_except = new JScrollPane();
							    panel_12.add(scrollPane_except);
							    
							    table_except = new JTable(model_except);//*********************таблица  исключения
							    table_except.setBackground(new Color(255, 255, 204));
							    scrollPane_except.setViewportView(table_except);
							    table_except.setCellSelectionEnabled(true);
							    table_except.setRowSorter(sorter_except);	
							    table_except.setRowHeight(20);
							    
							    JPanel panel_13 = new JPanel();
							    panel_13.setBackground(new Color(102, 153, 153));
							    panel_1.add(panel_13, BorderLayout.SOUTH);
							    panel_13.setLayout(new MigLayout("", "[120.00][171.00][151.00][:120:120,grow,right][78.00,grow][78.00,grow][:180px:180px,grow]", "[][]"));
							    							     
//********ПОЛЯ для таблицы терминалов***********************************************************************************		         
							     
							     textField_numTerm = new JTextField();
							     textField_numTerm.setToolTipText("\u041F\u0443\u0441\u0442\u043E\u0435 \u043F\u043E\u043B\u0435 - \u043F\u043E\u0438\u0441\u043A \u0432\u0441\u0435\u0445 \u0442\u0435\u0440\u043C\u0438\u043D\u0430\u043B\u043E\u0432");
							     panel_13.add(textField_numTerm, "cell 0 0,grow");
							     textField_numTerm.setColumns(10);
							     
							     textField_naneterm = new JTextField();
							     panel_13.add(textField_naneterm, "cell 1 0,grow");
							     textField_naneterm.setColumns(10);
							     
							     
							      JComboBox comboBox_distr_term = new JComboBox(distrs);
							      panel_13.add(comboBox_distr_term, "cell 2 0,grow");
							      comboBox_distr_term.setMaximumRowCount(20);
//***********************************************************************************************
	//***********ПОЛЯ номер терема исключений и текст самого исключения******************************************							 	
							      textField_numbexcept = new JTextField();
							      textField_numbexcept.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u0435 \u043D\u0435\u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0449\u0435\u0433\u043E \u0442\u0435\u0440\u043C\u0438\u043D\u0430\u043B\u0430 - \u0433\u043E\u0440\u044F\u0447\u0435\u0435 \u043E\u0431\u043D\u043E\u0432\u043B\u0435\u043D\u0438\u0435 \u0441\u043F\u0438\u0441\u043A\u0430");
							      panel_13.add(textField_numbexcept, "cell 3 0,grow");
							      textField_nameexcept = new JTextField();
							      panel_13.add(textField_nameexcept, "cell 6 0,grow");
							      textField_nameexcept.setColumns(10);
							      //**************************************************************************************************************						        				 										        				 										      
							      //****КНОПКА ПОИСК ТЕРИМНАЛА В ТАБЛИЦЕ ТЕРМИНАЛЫ***********************************				        
							      
							      JButton button_find_term = new JButton("\u041F\u043E\u0438\u0441\u043A");
							      panel_13.add(button_find_term, "cell 0 1,grow");
							      button_find_term.setForeground(Color.BLUE);
							      button_find_term.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
							      button_find_term.setBackground(Color.LIGHT_GRAY);
							      //***********************************************************************************************			        
							      
							    //КНОПКА ДОБАВИТЬ В ТАБЛИЦУ ТЕРМИНАЛОВ*************************************************************			        
							      JButton btn_Term = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
							      panel_13.add(btn_Term, "cell 1 1,alignx right");
							      btn_Term.setForeground(new Color(0, 0, 255));
							      btn_Term.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
							      btn_Term.setBackground(new Color(102, 153, 255));
							      
							      
							      //чекбокс добавлять новые терема
							      JCheckBox chckbxaddNew = new JCheckBox("Добавлять NEW");
							      chckbxaddNew.setSelected(true);
							      chckbxaddNew.setToolTipText("Автоматическое добавление новых терминалов");
							      chckbxaddNew.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
							      chckbxaddNew.setBackground(new Color(102, 153, 153));
							      chckbxaddNew.setForeground(new Color(0, 0, 255));
							      panel_13.add(chckbxaddNew, "cell 2 1,alignx right");
							      
							      chckbxaddNew.addItemListener(new ItemListener() {
							          public void itemStateChanged(ItemEvent e) {
							            
									        	 if (chckbxaddNew.isSelected()) {									        		
									        		New = 1; 
									        	 } else New = 0;							          									        	 	          
							          }
							      });
							      
							      //*************************************************************************************************************							     
							      
							    //******КНОПКА ПОИСК НОМЕРА В ИСКЛЮЧЕНИЯХ*****************************************************************							     
							      JButton button_find_except = new JButton("\u041F\u043E\u0438\u0441\u043A");
							      panel_13.add(button_find_except, "cell 3 1,grow");
							      button_find_except.setForeground(Color.BLUE);
							      button_find_except.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
							      button_find_except.setBackground(Color.LIGHT_GRAY);
							    //******КНОПКА УДАЛИТЬ ИЗ ИСКЛЮЧЕНИЙ***********************************								        	           
							      
							      JButton delete_except = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
							      panel_13.add(delete_except, "cell 4 1,alignx right");
							      delete_except.setForeground(new Color(0, 0, 255));
							      delete_except.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
							      delete_except.setBackground(new Color(255, 102, 102));
							      
  				 				  	delete_except.addActionListener(new ActionListener() {
  				 				  		public void actionPerformed(ActionEvent e) {
  				 				  			//TextFild tf = new TextFild();
			        	        		try 	{
									//tf.delete_term_exception(textField_numbexcept.getText());
			        	        			new AddDelExceptTerm().groupAddDel(0);
										} catch (Exception e1) {
										}	
			        	        		
			        	        		
  				 				  		}
						           });														        	        
//****************************КНОПКА ДОБАВИТЬ ТЕРЕМ К ИСКЛЮЧЕНИЯМ***************							        	        
  				 				  	
  				 				  	JButton add_except = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
  				 				  	panel_13.add(add_except, "cell 5 1,alignx left");
  				 				  	add_except.setForeground(Color.BLUE);
  				 				  	add_except.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
  				 				  	add_except.setBackground(new Color(51, 255, 153));
  				 				  	
							     add_except.addActionListener(new ActionListener() {
			        	        	   public void actionPerformed(ActionEvent e) {
			        	        		try {
										new AddDelExceptTerm().groupAddDel(1);
			        	        		
			        	        		} catch (Exception e1) {
										}
			        	        		   
			        	        	   }
			        	           });
//********кнопка поиск в исключениях*************************************************************************************							     
							     button_find_except.addActionListener(new ActionListener() {
			        	        	   public void actionPerformed(ActionEvent e) {
			        	        		   			        	        		   
			        	        	   }
		        	           });
							     
//********добавить в таблицу теремов************************************************			        
						        btn_Term.addActionListener(new ActionListener() {
							     public void actionPerformed(ActionEvent arg0) {
							     
							     	if (textField_numTerm.getText().compareTo("") != 0) {
							     			String number_term = textField_numTerm.getText();
							     			String name_term = textField_naneterm.getText();
							     			//String distr_term = textField_distrterm.getText();
							     			String distr_term =comboBox_distr_term.getSelectedItem().toString();
							     					TextFild txtf = new TextFild();
							     					try {
							     						txtf.insert_term(number_term,name_term,distr_term);
							     					} catch (Exception e) {

							     					}																							
							     	}	
							     		
							     }
								});
						        
//*********************************************************************************************************************						        			       		        
//************поиск терема в таблице теремов*********************************************
						        button_find_term.addActionListener(new ActionListener() {
							        	        	   public void actionPerformed(ActionEvent e) {
							        	        		   
							        	        		   if (textField_numTerm.getText().compareTo("") != 0) {
							        	        			   TextFild tf = new TextFild();
							        	        			   try {
							        	        				   tf.find_term_in_terminals(textField_numTerm.getText());
							        	        			   } catch (Exception e1) {}
							        	        		   } 
							        	        		   else {
							        	        			   
							        	        			   try {
							        	        				   bdw.reqest_in_db_TTmodel_terminals();
							        	        			   } catch (ClassNotFoundException e1) {}
							        	        		   }
							        	        	   }
						        });
//**********************************************************************************************************************						        
						        JPanel panel_14 = new JPanel();
						        panel_14.setBackground(new Color(102, 153, 153));
						        panel_1.add(panel_14, BorderLayout.NORTH);
						        panel_14.setLayout(new BorderLayout(0, 0));
						        //**************************************************************************************		        
		        
		        
		        JLabel label_13 = new JLabel("                                             \u0422 \u0415 \u0420 \u041C \u0418 \u041D \u0410 \u041B \u042B");
		        panel_14.add(label_13, BorderLayout.WEST);
		        label_13.setForeground(new Color(255, 204, 0));
		        label_13.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
		        label_13.setHorizontalAlignment(SwingConstants.CENTER);
		        
		        JLabel label_14 = new JLabel("\u0418 \u0421 \u041A \u041B \u042E \u0427 \u0415 \u041D \u0418 \u042F                                                              ");
		        label_14.setBackground(new Color(102, 153, 153));
		        panel_14.add(label_14, BorderLayout.EAST);
		        label_14.setHorizontalAlignment(SwingConstants.CENTER);
		        label_14.setForeground(new Color(255, 153, 204));
		        label_14.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
							       							       
		        JPanel panel = new JPanel();
		        panel.setBackground(new Color(142, 153, 255));
		        tabbedPane.addTab("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0438", null, panel, null);
		        tabbedPane.setForegroundAt(2, new Color(0, 0, 0));
		        tabbedPane.setEnabledAt(2, true);
		        tabbedPane.setBackgroundAt(2, new Color(204, 153, 102));
		        panel.setLayout(null);
				        						
//************IA?AEE??AOAEU AAC*******************************************************************************************								
			        									        						
			        						JRadioButton rdbtnSql = new JRadioButton("SQL");
			        						rdbtnSql.setBounds(576, 81, 57, 20);
			        						panel.add(rdbtnSql);
			        						
			        						JRadioButton rdbtnDerby = new JRadioButton("Derby");
			        						rdbtnDerby.setBounds(576, 104, 57, 20);
			        						panel.add(rdbtnDerby);
			        									        						
			        						group.add(rdbtnSql);
			        						group.add(rdbtnDerby);			        						
			        						
//******ПЕРЕКЛЮЧАТЕЛЬ БАЗ***********//rdbtnDerby.setSelected(true);
			        						rdbtnSql.setSelected(true);							
			        						rdbtnSql.addActionListener(listen);
			        						rdbtnDerby.addActionListener(listen);
			        						                            
//******************************************************************************************************************************
			        						                            			        						                            
			JLabel label_7 = new JLabel("\u0418\u0441\u043F\u043E\u043B\u044C\u0437\u0443\u0435\u0442\u0441\u044F \u0434\u0440\u0430\u0439\u0432\u0435\u0440 :");
			label_7.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			label_7.setForeground(new Color(0, 0, 204));
			label_7.setBounds(28, 39, 166, 37);
			panel.add(label_7);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_1.setBounds(202, 41, 354, 37);
			panel.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(xml.read()[0]);			
			
			JLabel lblDatabase = new JLabel("\u0425\u043E\u0441\u0442 \u0438 DataBase :");
			lblDatabase.setForeground(new Color(0, 0, 204));
			lblDatabase.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			lblDatabase.setBounds(28, 87, 166, 37);
			panel.add(lblDatabase);
			
			JLabel lblDb = new JLabel("\u041F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u044C DB :");
			lblDb.setForeground(new Color(0, 0, 204));
			lblDb.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			lblDb.setBounds(28, 135, 166, 37);
			panel.add(lblDb);
			
			JLabel lblDb_1 = new JLabel("\u041F\u0430\u0440\u043E\u043B\u044C DB :");
			lblDb_1.setForeground(new Color(0, 0, 204));
			lblDb_1.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			lblDb_1.setBounds(28, 183, 166, 37);
			panel.add(lblDb_1);
			
			JLabel label_5 = new JLabel("\u0421\u0438\u0433\u043D\u0430\u043B");
			label_5.setBounds(715, 47, 87, 20);
			panel.add(label_5);
			label_5.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			label_5.setForeground(new Color(153, 0, 255));
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			        						                            
//************************************************СИГНАЛ*********************************				
			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner.setBounds(1031, 39, 48, 30);                          //****ЧАСЫ
			panel.add(spinner);
			spinner.setModel(new SpinnerNumberModel(2, 0, 23, 1));				
			spinner.addChangeListener(listener);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner_1.setBounds(880, 43, 48, 30);                           //****ДНИ
			panel.add(spinner_1);
			spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
			spinner_1.addChangeListener(listener_1);
			//************************************************ПЛАТЕЖ*******************************				
			JSpinner spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerNumberModel(2, 0, 10, 1));
			spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner_2.setBounds(880, 81, 48, 30);                                //****ДНИ
			panel.add(spinner_2);
			spinner_2.addChangeListener(listener_2);
									
			JSpinner spinner_3 = new JSpinner();                                //****ЧАСЫ
			spinner_3.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner_3.setBounds(1031, 75, 48, 30);
			panel.add(spinner_3);
			spinner_3.addChangeListener(listener_3);
						        						                            				
//****************************************************************************************************************							        						                            				
			JLabel label_1 = new JLabel("\u0427\u0430\u0441\u043E\u0432");
			label_1.setBounds(964, 47, 57, 20);
			panel.add(label_1);
			label_1.setForeground(new Color(51, 102, 51));
			label_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
			
			JLabel label_3 = new JLabel("\u0414\u043D\u0435\u0439");
			label_3.setBounds(828, 47, 57, 20);
			panel.add(label_3);
			label_3.setForeground(new Color(51, 102, 51));
			label_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_2.setColumns(10);
			textField_2.setBounds(202, 89, 354, 37);
			panel.add(textField_2);
			textField_2.setText(xml.read()[1]);
						
			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_3.setColumns(10);
			textField_3.setBounds(202, 135, 354, 37);
			panel.add(textField_3);
			textField_3.setText(xml.read()[2]);			
			
			textField_4 = new JTextField();
			textField_4.setEditable(false);
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_4.setColumns(10);
			textField_4.setBounds(202, 185, 354, 37);
			panel.add(textField_4);
			textField_4.setText(xml.read()[3]);
			
			JLabel lblDownloads = new JLabel("\u041F\u0443\u0442\u044C \u043A Downloads :");
			lblDownloads.setForeground(new Color(0, 0, 204));
			lblDownloads.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			lblDownloads.setBounds(28, 231, 166, 37);
			panel.add(lblDownloads);
			        						                            				
			textField_6 = new JTextField();
			textField_6.setEditable(false);
			textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_6.setColumns(10);
			textField_6.setBounds(202, 233, 354, 37);
			panel.add(textField_6);
			textField_6.setText(dir);
			
			JLabel label_8 = new JLabel("\u0420\u0430\u0431\u043E\u0447\u0430\u044F \u0434\u0438\u0440\u0435\u043A\u0442\u043E\u0440\u0438\u044F :");
			label_8.setForeground(new Color(0, 0, 204));
			label_8.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			label_8.setBounds(28, 279, 166, 37);
			panel.add(label_8);
			
			textField_7 = new JTextField();
			textField_7.setEditable(false);
			textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_7.setColumns(10);
			textField_7.setBounds(202, 281, 354, 37);
			panel.add(textField_7);
			textField_7.setText(path);		
			
			JLabel lblNewLabel_4 = new JLabel("\u0421\u0438\u0441\u0442\u0435\u043C\u043D\u044B\u0435 \u043D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0438 :");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 12));
			lblNewLabel_4.setForeground(new Color(153, 0, 0));
			lblNewLabel_4.setBounds(220, 11, 157, 14);
			panel.add(lblNewLabel_4);
			
			JLabel label_9 = new JLabel("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0438 \u0444\u0438\u043B\u044C\u0442\u0440\u0430:");
			label_9.setForeground(new Color(51, 102, 0));
			label_9.setFont(new Font("Tahoma", Font.ITALIC, 12));
			label_9.setBounds(843, 12, 157, 14);
			panel.add(label_9);
			
			JLabel label_4 = new JLabel("\u0414\u043D\u0435\u0439");
			label_4.setForeground(new Color(51, 102, 51));
			label_4.setFont(new Font("Tahoma", Font.ITALIC, 16));
			label_4.setBounds(828, 81, 48, 20);
			panel.add(label_4);
			
			JLabel label_2 = new JLabel("\u0427\u0430\u0441\u043E\u0432");
			label_2.setForeground(new Color(51, 102, 51));
			label_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
			label_2.setBounds(964, 79, 57, 20);
			panel.add(label_2);
			
			JLabel label_10 = new JLabel("\u041F\u043B\u0430\u0442\u0451\u0436");
			label_10.setHorizontalAlignment(SwingConstants.CENTER);
			label_10.setForeground(new Color(153, 0, 255));
			label_10.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			label_10.setBounds(715, 81, 97, 20);
			panel.add(label_10);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(28, 356, 395, 329);
			panel.add(scrollPane_1);						        						                            				
//*****таблица маилто*************************************************				
			table_1 = new JTable(model_1); 
			table_1.setRowSelectionAllowed(false);
			table_1.setCellSelectionEnabled(true);
			scrollPane_1.setViewportView(table_1);
			table_1.setRowSorter(sorter_1);	
			table_1.setRowHeight(20);
			
			table_1.setDefaultRenderer(String.class, new Render_mailto_table());
						
			JLabel label_12 = new JLabel("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430 \u0440\u0430\u0441\u0441\u044B\u043B\u043A\u0438 :");
			label_12.setForeground(new Color(204, 0, 204));
			label_12.setFont(new Font("Tahoma", Font.ITALIC, 12));
			label_12.setBounds(233, 340, 157, 14);
			panel.add(label_12);
			
			JScrollPane scrollPane_workers = new JScrollPane();
			scrollPane_workers.setBounds(740, 282, 339, 403);
			panel.add(scrollPane_workers);
			        						                            				
//************************************************************************************		        
			table_workers = new JTable(model_work);
			scrollPane_workers.setViewportView(table_workers);
			table_workers.setCellSelectionEnabled(true);
			table_workers.setRowSorter(sorter_work);	
			table_workers.setRowHeight(20);			
			
			JLabel label_15 = new JLabel("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0438 \u0441\u043E\u0442\u0440\u0443\u0434\u043D\u0438\u043A\u043E\u0432:");
			label_15.setForeground(new Color(51, 102, 255));
			label_15.setFont(new Font("Tahoma", Font.ITALIC, 12));
			label_15.setBounds(843, 254, 157, 14);
			panel.add(label_15);
			
			JSeparator separator_7 = new JSeparator();
			separator_7.setBounds(28, 327, 605, 2);
			panel.add(separator_7);
			
			JSeparator separator_8 = new JSeparator();
			separator_8.setBounds(633, 220, 546, 2);
			panel.add(separator_8);
			
			JSeparator separator_9 = new JSeparator();
			separator_9.setOrientation(SwingConstants.VERTICAL);
			separator_9.setBounds(633, 26, 2, 744);
			panel.add(separator_9);
//*******************************************************************************************************************		          
				table_1.getColumnModel().getColumn(0).setPreferredWidth(10);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(10);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(60);
				table_1.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(combo_1));				        
//*********добавить нового сотрудника и почту********************************************		        
			        JButton button_insert_new_work = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C/\u041E\u0431\u043D\u043E\u0432\u0438\u0442\u044C");
			        button_insert_new_work.setForeground(Color.BLUE);
			        button_insert_new_work.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
			        button_insert_new_work.setBackground(new Color(102, 102, 255));
			        button_insert_new_work.setBounds(740, 727, 339, 25);
			        panel.add(button_insert_new_work);
			        			        
			        textField_work = new JTextField();
			        textField_work.setColumns(10);
			        textField_work.setBounds(740, 696, 163, 20);
			        panel.add(textField_work);
			        
			        textField_workmail = new JTextField();
			        textField_workmail.setColumns(10);
			        textField_workmail.setBounds(913, 696, 166, 20);
			        panel.add(textField_workmail);
			        
			        JLabel lblNewLabel_5 = new JLabel("\u0421\u0442\u0430\u0440\u0448\u0438\u0439 \u0441\u043C\u0435\u043D\u044B \u0434\u043B\u044F \u041E\u0422\u0427\u0401\u0422\u0410:");
			        lblNewLabel_5.setForeground(new Color(0, 0, 255));
			        lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        lblNewLabel_5.setBounds(28, 696, 218, 14);
			        panel.add(lblNewLabel_5);
//****************************************************************************************			        
			        textField_SS_for_repo = new JTextField();
			        textField_SS_for_repo.setText("\u0422\u0438\u043C\u0430\u043D\u043E\u0432 \u0410.");
			        textField_SS_for_repo.setBounds(256, 696, 367, 20);
			        panel.add(textField_SS_for_repo);
			        textField_SS_for_repo.setColumns(10);
			        
			        JLabel lblNewLabel_6 = new JLabel("\u041F\u0443\u0442\u044C \u0434\u043B\u044F \u0441\u043E\u0445\u0440\u0430\u043D\u0435\u043D\u0438\u044F \u0444\u0430\u0439\u043B\u0430 \u043E\u0442\u0447\u0451\u0442\u0430:");
			        lblNewLabel_6.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
			        lblNewLabel_6.setForeground(new Color(51, 0, 204));
			        lblNewLabel_6.setBounds(28, 732, 218, 14);
			        panel.add(lblNewLabel_6);
//**********ioou aey io??oa	***************************************************************************		        
			        textField_Path_report = new JTextField();
			        textField_Path_report.setBounds(256, 730, 367, 20);
			        panel.add(textField_Path_report);
			        textField_Path_report.setColumns(10);
			        textField_Path_report.setText(xml.read()[4]);
			        
			        JLabel label_17 = new JLabel("\u041F\u0443\u0442\u044C \u043A \u043F\u043E\u0441\u043B\u0435\u0434\u043D\u0438\u043C \u0438\u043D\u043A\u0430\u0441\u0441\u0430\u0446\u0438\u044F\u043C:");
			        label_17.setForeground(new Color(51, 0, 204));
			        label_17.setFont(new Font("Century Schoolbook", Font.ITALIC, 12));
			        label_17.setBounds(28, 768, 218, 14);
			        panel.add(label_17);
//******Последниеинкассации**********************************************************************************			        
			        textField_last_inkass = new JTextField();
			        textField_last_inkass.setText((String) null);
			        textField_last_inkass.setColumns(10);
			        textField_last_inkass.setBounds(256, 766, 367, 20);
			        panel.add(textField_last_inkass);
			        textField_last_inkass.setText(xml.read()[5]);
//***********история ошибок от*******************************************************************			        
			       
			        ChangeListener listener_OT = new ChangeListener() {
			            public void stateChanged(ChangeEvent e) {
			                JSpinner js_OT = (JSpinner) e.getSource();
			               date_OT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(js_OT.getValue());
			            }
			        };
//**********************************************************************************************************************			        
			        JLabel label_18 = new JLabel("\u0418\u0441\u0442\u043E\u0440\u0438\u044F \u041E\u0422:");
			        label_18.setHorizontalAlignment(SwingConstants.CENTER);
			        label_18.setForeground(new Color(153, 0, 255));
			        label_18.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        label_18.setBounds(715, 143, 107, 20);
			        panel.add(label_18);
			        
			        JLabel label_19 = new JLabel("\u0418\u0441\u0442\u043E\u0440\u0438\u044F \u0414\u041E:");
			        label_19.setHorizontalAlignment(SwingConstants.CENTER);
			        label_19.setForeground(new Color(153, 0, 255));
			        label_19.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        label_19.setBounds(715, 183, 107, 20);
			        panel.add(label_19);
//***********история ошибок До*****************************************************************			        
			       
			        ChangeListener listener_DO = new ChangeListener() {
			            public void stateChanged(ChangeEvent e) {
			                JSpinner js_DO = (JSpinner) e.getSource();
			                date_DO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(js_DO.getValue());
			                
			            }
			        };
			       
//************вкл выкл выгрузки истории***********************************************			        
			        JCheckBox CheckBox_history = new JCheckBox("\u043F\u0440\u0438\u043C\u0435\u043D\u0438\u0442\u044C");
			        CheckBox_history.setToolTipText("\u0412\u043A\u043B/\u0412\u044B\u043A\u043B \u0432\u044B\u0433\u0440\u0443\u0437\u043A\u0438 \u0438\u0441\u0442\u043E\u0440\u0438\u0438 \u043E\u0448\u0438\u0431\u043E\u043A");
			        CheckBox_history.setBackground(new Color(153, 153, 255));
			        CheckBox_history.setForeground(new Color(0, 102, 51));
			        CheckBox_history.setBounds(831, 165, 97, 23);
			        panel.add(CheckBox_history);
//******Задание Цвета в рассылку************************************просто шняшка-красивость			        
			        txtFild_color_mailto1 = new JTextField();
			        txtFild_color_mailto1.setText("#EECFA1");
			        txtFild_color_mailto1.setBounds(470, 357, 86, 20);
			        panel.add(txtFild_color_mailto1);
			        txtFild_color_mailto1.setColumns(10);
			        
			        JLabel label_color_mailto = new JLabel("Цвета рассылки :");
			        label_color_mailto.setForeground(new Color(204, 0, 204));
			        label_color_mailto.setFont(new Font("Tahoma", Font.ITALIC, 12));
			        label_color_mailto.setBounds(469, 340, 113, 14);
			        panel.add(label_color_mailto);
			        
			        txtFild_color_mailto2 = new JTextField();
			        txtFild_color_mailto2.setText("#EEE9BF");
			        txtFild_color_mailto2.setColumns(10);
			        txtFild_color_mailto2.setBounds(470, 388, 86, 20);
			        panel.add(txtFild_color_mailto2);
//*********************************************************************************************
			        
			        dateChooser_OT = new JDateChooser();
			        dateChooser_OT.setForeground(new Color(0, 0, 0));
			        dateChooser_OT.setDateFormatString("yyyy-MM-dd");
			        dateChooser_OT.setBounds(929, 135, 150, 30);
			        panel.add(dateChooser_OT);
			        dateChooser_OT.setDate(new Date());
			        
			        dateChooser_DO = new JDateChooser();
			        dateChooser_DO.setDateFormatString("yyyy-MM-dd");
			        dateChooser_DO.setBounds(929, 179, 150, 30);
			        panel.add(dateChooser_DO);
			        dateChooser_DO.setDate(new Date());
			        
			        
			        
//***************************************************************************************
			        
			        CheckBox_history.addItemListener(new ItemListener() {
				          public void itemStateChanged(ItemEvent e) {
				            
						        	 if (CheckBox_history.isSelected()) {
						        		history = 1;
						        	 
						        	 }else {history = 0;}
				          				          
				          }
				      });			        
//***************************************************************************************			        
			        JPanel panel_2 = new JPanel();
			        panel_2.setBackground(new Color(255, 204, 153));
			        tabbedPane.addTab("\u041E\u0442\u0447\u0451\u0442", null, panel_2, null);
			        panel_2.setLayout(new BorderLayout(0, 0));
			        
//****IO??O****************************************************************************************************			        
			        JPanel panel_15 = new JPanel();
			        panel_15.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        panel_15.setBackground(new Color(51, 153, 153));
			        panel_2.add(panel_15, BorderLayout.WEST);
			        panel_15.setLayout(new MigLayout("", "[]", "[][][]"));
//****кнопка отчет		        
			        JButton btn_report = new JButton("\u041E\u0442\u0447\u0451\u0442");
			        btn_report.setToolTipText("\u0421\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u0442\u044C \u043E\u0442\u0447\u0451\u0442 \u043F\u043E \u0444\u0438\u043B\u044C\u0442\u0440\u0443 \u0432 \u043D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430\u0445");
			        btn_report.setForeground(new Color(204, 204, 102));
			        btn_report.setBackground(new Color(51, 153, 153));
			        btn_report.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			        panel_15.add(btn_report, "cell 0 0,growx");
			        
					        btn_report.addActionListener(new ActionListener() {
		     	        	   public void actionPerformed(ActionEvent e) {
		     	        		   Report repo = new Report();
		     	        		   repo.query_for_report_spb();		     	        		   		     	        		   
		     	        		      
		     	        	   }
					        });
//*********************************************************		        
//*кнопка в ексель*************************************************************
			        JButton btnNewButton_2 = new JButton("\u0432 Excel");
			        btnNewButton_2.setToolTipText("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0444\u0430\u0439\u043B \u043E\u0442\u0447\u0451\u0442\u0430 \u043F\u043E \u043F\u0443\u0442\u0438 \u0432 \u043D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430\u0445");
			        btnNewButton_2.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			        btnNewButton_2.setForeground(new Color(204, 204, 102));
			        btnNewButton_2.setBackground(new Color(51, 153, 153));
			        panel_15.add(btnNewButton_2, "cell 0 2,growx");

					        btnNewButton_2.addActionListener(new ActionListener() {
			     	        	   public void actionPerformed(ActionEvent e) {
			     	        		//************************* 
			     	        		 BD_write.List_spb.clear();
			     	        		 BD_write.List_lo.clear();     //***очистка предыдущих данных
			     	        		 BD_write.List_reg.clear();
			     	        		//**************************   
			     	        		Report repo = new Report();    //***caiieiee ieii?aoaeuiuie aaiiuie ianneau io??oia
			     	        		repo.query_for_report_spb();
			     	        		//**************************   			     	        		   
			     	        		   Repo_Excel rexcel = new Repo_Excel();
			     	        		   try {
										rexcel.create_file_report();
									} catch (Exception e1) {
									}
			     	        		   
			     	        		      
			     	        	   }
					        });
//******************************************************************************************************			        
			        JPanel panel_16 = new JPanel();
			        panel_16.setBackground(new Color(51, 153, 153));
			        panel_2.add(panel_16, BorderLayout.CENTER);
			        panel_16.setLayout(new MigLayout("", "[1020.00,grow,fill]", "[335.00,grow,fill][297.00,grow][158.00,grow]"));
			        
			        JPanel panel_17 = new JPanel();
			        panel_17.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        panel_16.add(panel_17, "cell 0 0,grow");
			        panel_17.setLayout(new BorderLayout(0, 0));
			        
			        JScrollPane scrollPane_3 = new JScrollPane();
			        panel_17.add(scrollPane_3, BorderLayout.CENTER);
			        
//****таблица отчета спб********************************************************			        
			        table_2 = new JTable(model_spb);
			        table_2.setBackground(new Color(255, 204, 153));
			        RowSorter<TTM_spb> sorterTTM = new TableRowSorter<TTM_spb>(model_spb);
			        table_2.setRowSorter(sorterTTM);
//***********************************************************************			   
			        scrollPane_3.setViewportView(table_2);
			        
			        JPanel panel_18 = new JPanel();
			        panel_18.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        panel_16.add(panel_18, "cell 0 1,grow");
			        panel_18.setLayout(new BorderLayout(0, 0));
			        
			        JScrollPane scrollPane_4 = new JScrollPane();
			        panel_18.add(scrollPane_4, BorderLayout.CENTER);
//****табл отч ло******************************************************			        
			        table_3 = new JTable(model_lo);
			        table_3.setBackground(new Color(204, 255, 153));
			        table_3.setCellSelectionEnabled(true);	
				    RowSorter<TTM_lo> sorterlo = new TableRowSorter<TTM_lo>(model_lo);
			        table_3.setRowSorter(sorterlo);
//*****************************************************************			 
			        scrollPane_4.setViewportView(table_3);
			        
			        JPanel panel_19 = new JPanel();
			        panel_19.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        panel_16.add(panel_19, "cell 0 2,grow");
			        panel_19.setLayout(new BorderLayout(0, 0));
			        
			        JScrollPane scrollPane_5 = new JScrollPane();
			        panel_19.add(scrollPane_5, BorderLayout.CENTER);
			        
//***табл отч регионы*********************************************************			        
			        table_4 = new JTable(model_reg);
			        table_4.setBackground(new Color(153, 255, 255));
			        RowSorter<TTM_reg> sorterreg = new TableRowSorter<TTM_reg>(model_reg);
			        table_4.setRowSorter(sorterreg);
//*******************************************************************************			  
			        scrollPane_5.setViewportView(table_4);
			        tabbedPane.setBackgroundAt(3, new Color(204, 204, 0));
			        
			        JPanel panel_20 = new JPanel();
			        tabbedPane.addTab("Инкассация", null, panel_20, null);
			        tabbedPane.setBackgroundAt(4, Color.CYAN);
			        panel_20.setLayout(new BorderLayout(0, 0));
			        
			        JPanel panel_21 = new JPanel();
			        panel_21.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        panel_21.setBackground(new Color(51, 153, 153));
			        panel_20.add(panel_21, BorderLayout.WEST);
			        panel_21.setLayout(new MigLayout("", "[grow]", "[31.00][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
			        
			        JLabel label_20 = new JLabel("Выбор маршрутов");
			        label_20.setHorizontalAlignment(SwingConstants.CENTER);
			        label_20.setForeground(new Color(51, 102, 0));
			        label_20.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			        panel_21.add(label_20, "cell 0 2,alignx center");
//*****************************************************************************************************************			        
			        
			        
//			        rdbtnAll.addItemListener(new ItemListener() {
//				          public void itemStateChanged(ItemEvent e) {
//				            
//						        	 if (rdbtnAll.isSelected()) {
//						        		 
//						        		 allMarshruts = 1;
//						        		 
//						        	 } else allMarshruts = 0;
//				          
//						        	 	          
//				          }
//				      });
			        
			        
			        
//**************************************************************************************************************************************			        
			        JComboBox comboBox_3 = new JComboBox();
			        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"нет маршрута", "маршрут 11", "маршрут 12", "маршрут 51", "маршрут 52", "маршрут 61", "маршрут 62", "маршрут 41", "маршрут 42", "маршрут 81", "маршрут 82", "маршрут 91", "маршрут 92", "маршрут 4А1", "маршрут 4А2", "маршрут 8А1", "маршрут 8А2", "маршрут 9А1", "маршрут 9А2"}));
			        comboBox_3.setSelectedIndex(0);
			        comboBox_3.setMaximumRowCount(12);
			        comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			        panel_21.add(comboBox_3, "cell 0 4,growx");
			        			        
			        comboBox_3.addActionListener(new ActionListener() {
				    	  public void actionPerformed(ActionEvent event) {           								
				    		 try { 				    		  
				    		  distr_inkass3 = comboBox_3.getSelectedItem()
														  .toString()
				    		 							  .substring(8); 
				    		 } catch(Exception e4) {
				    			
				    			 distr_inkass3 = "0";// combobox value "нет маршрута"

				    		 }
				    	  }
				      });
			        
			        JComboBox comboBox_4 = new JComboBox();
			        comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"нет маршрута", "маршрут 11", "маршрут 12", "маршрут 51", "маршрут 52", "маршрут 61", "маршрут 62", "маршрут 41", "маршрут 42", "маршрут 81", "маршрут 82", "маршрут 91", "маршрут 92", "маршрут 4А1", "маршрут 4А2", "маршрут 8А1", "маршрут 8А2", "маршрут 9А1", "маршрут 9А2"}));
			        comboBox_4.setSelectedIndex(0);
			        comboBox_4.setMaximumRowCount(12);
			        comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			        panel_21.add(comboBox_4, "cell 0 5,growx");
			        
			        comboBox_4.addActionListener(new ActionListener() {
				    	  public void actionPerformed(ActionEvent event) {           								
				    		 try { 				    		  
				    		  distr_inkass4 = comboBox_4.getSelectedItem()
														  .toString()
				    		 							  .substring(8); 
				    		 } catch(Exception e4) {				    			
				    			 distr_inkass4 = "0";// combobox value "нет маршрута"
				    		 }
				    	  }
				      });
			        
			        JComboBox comboBox_5 = new JComboBox();
			        comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"нет маршрута", "маршрут 11", "маршрут 12", "маршрут 51", "маршрут 52", "маршрут 61", "маршрут 62", "маршрут 41", "маршрут 42", "маршрут 81", "маршрут 82", "маршрут 91", "маршрут 92", "маршрут 4А1", "маршрут 4А2", "маршрут 8А1", "маршрут 8А2", "маршрут 9А1", "маршрут 9А2"}));
			        comboBox_5.setSelectedIndex(0);
			        comboBox_5.setMaximumRowCount(12);
			        comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			        panel_21.add(comboBox_5, "cell 0 6,growx");
			        
			        comboBox_5.addActionListener(new ActionListener() {
				    	  public void actionPerformed(ActionEvent event) {           								
				    		 try { 				    		  
				    		  distr_inkass5 = comboBox_5.getSelectedItem()
														  .toString()
				    		 							  .substring(8); 
				    		 } catch(Exception e4) {				    			
				    			 distr_inkass5 = "0";// combobox value "нет маршрута"
				    		 }
				    	  }
				      });
			        
			        JComboBox comboBox_6 = new JComboBox();
			        comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"нет маршрута", "маршрут 11", "маршрут 12", "маршрут 51", "маршрут 52", "маршрут 61", "маршрут 62", "маршрут 41", "маршрут 42", "маршрут 81", "маршрут 82", "маршрут 91", "маршрут 92", "маршрут 4А1", "маршрут 4А2", "маршрут 8А1", "маршрут 8А2", "маршрут 9А1", "маршрут 9А2"}));
			        comboBox_6.setSelectedIndex(0);
			        comboBox_6.setMaximumRowCount(12);
			        comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			        panel_21.add(comboBox_6, "cell 0 7,growx");
			        
			        comboBox_6.addActionListener(new ActionListener() {
				    	  public void actionPerformed(ActionEvent event) {           								
				    		 try { 				    		  
				    		  distr_inkass6 = comboBox_6.getSelectedItem()
														  .toString()
				    		 							  .substring(8); 
				    		 } catch(Exception e4) {				    			
				    			 distr_inkass6 = "0";// combobox value "нет маршрута"
				    		 }
				    	  }
				      });
			        
			        JComboBox comboBox_2 = new JComboBox();
			        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"нет маршрута", "маршрут 11", "маршрут 12", "маршрут 51", "маршрут 52", "маршрут 61", "маршрут 62", "маршрут 41", "маршрут 42", "маршрут 81", "маршрут 82", "маршрут 91", "маршрут 92", "маршрут 4А1", "маршрут 4А2", "маршрут 8А1", "маршрут 8А2", "маршрут 9А1", "маршрут 9А2"}));
			        comboBox_2.setSelectedIndex(0);
			        comboBox_2.setMaximumRowCount(12);
			        comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 12));			        
			        panel_21.add(comboBox_2, "cell 0 8,growx");	
			        
			        comboBox_2.addActionListener(new ActionListener() {
				    	  public void actionPerformed(ActionEvent event) {           								
				    		 try { 				    		  
				    		  distr_inkass2 = comboBox_2.getSelectedItem()
														  .toString()
				    		 							  .substring(8); 
				    		 } catch(Exception e4) {				    			
				    			 distr_inkass2 = "0";// combobox value "нет маршрута"
				    		 }
				    	  }
				      });
//****************************************************************************************************			        
			       
			        JRadioButton rdbtnAllMurshruts = new JRadioButton("полный файл маршруты");
			        rdbtnAllMurshruts.setToolTipText("полные данные обо всех маршрутах");
			        rdbtnAllMurshruts.setForeground(new Color(0, 204, 153));
			        rdbtnAllMurshruts.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        rdbtnAllMurshruts.setBackground(new Color(0, 153, 153));
			        panel_21.add(rdbtnAllMurshruts, "cell 0 3");
					
			        ButtonGroup groupAgents = new ButtonGroup();
			        groupAgents.add(rdbtnAllMurshruts);
			        			        
				        
				        				        
				        
			       
	       
			        JButton button_2 = new JButton("Обновить\r\n справочник");
			        button_2.setToolTipText("Предварительно скачайте trmlist-report");
			        button_2.setForeground(new Color(204, 204, 102));
			        button_2.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
			        button_2.setBackground(new Color(51, 153, 153));
			        panel_21.add(button_2, "cell 0 0,grow");
			        
			        button_2.addActionListener(new ActionListener() {
	     	        	   public void actionPerformed(ActionEvent e) {
	     	        		   
	     	        		   NewThread_one thread = new NewThread_one();
								thread.New_Thread();
	     	        		   	     	        		      
	     	        	   }
				        });
			        
			        JRadioButton radioButton_all = new JRadioButton("3 файла маршрутов ");
			        radioButton_all.setToolTipText("Создание 3 файлов маршрутов для завтрашней инкассации");
			        radioButton_all.setSelected(true);
			        radioButton_all.setForeground(new Color(153, 255, 102));
			        radioButton_all.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        radioButton_all.setBackground(new Color(51, 153, 153));
			        panel_21.add(radioButton_all, "cell 0 9");
			        groupAgents.add(radioButton_all);
			        
					
			        ChangeListener listenerLimit = new ChangeListener() {
			            public void stateChanged(ChangeEvent e) {
			                JSpinner spinner_Limit = (JSpinner) e.getSource();
			                limit = (int) spinner_Limit.getValue();
			            }
			        };
									        
									        JLabel label_22 = new JLabel("Кол-во терминалов");
									        label_22.setHorizontalAlignment(SwingConstants.CENTER);
									        label_22.setForeground(new Color(51, 102, 0));
									        label_22.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        panel_21.add(label_22, "cell 0 10,growx");
									       
									        ChangeListener listenerSummLimit = new ChangeListener() {
									            public void stateChanged(ChangeEvent e) {
									                JSpinner spinner_SummLimit = (JSpinner) e.getSource();
									                Summlimit = (int) spinner_SummLimit.getValue();
									            }
									        };
									        
									        JSpinner spinner_Limit_1 = new JSpinner();
									        spinner_Limit_1.setModel(new SpinnerNumberModel(80, 0, 300, 1));
									        panel_21.add(spinner_Limit_1, "cell 0 11,growx");
									        
									        spinner_Limit_1.addChangeListener(listenerLimit);
									        
									        JLabel label_23 = new JLabel("Лимит СК по СПб");
									        label_23.setHorizontalAlignment(SwingConstants.CENTER);
									        label_23.setForeground(new Color(51, 102, 0));
									        label_23.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        panel_21.add(label_23, "cell 0 12,growx");
									        
									        JSpinner spinner_SummLimit_1 = new JSpinner();
									        spinner_SummLimit_1.setModel(new SpinnerNumberModel(70000, 0, 150000, 1000));
									        panel_21.add(spinner_SummLimit_1, "cell 0 13,growx");
									        spinner_SummLimit_1.addChangeListener(listenerSummLimit);
									        
									        ChangeListener listener_spinner_4 = new ChangeListener() {
									            public void stateChanged(ChangeEvent e) {
									                JSpinner spinner_4_1 = (JSpinner) e.getSource();
									                SummlimitLO = (int) spinner_4_1.getValue();
									            }
									        };
									        
									        JSpinner spinner_4_1 = new JSpinner();
									        spinner_4_1.setModel(new SpinnerNumberModel(50000, 0, 150000, 1000));
									        panel_21.add(spinner_4_1, "cell 0 15,growx");
									        spinner_4_1.addChangeListener(listener_spinner_4);
									        
									        JSpinner spinner_PirSps = new JSpinner();
									        spinner_PirSps.setModel(new SpinnerNumberModel(20000, 0, 150000, 1000));
									        panel_21.add(spinner_PirSps, "cell 0 17,growx");
									        
									        ChangeListener listSpinner_PirSps = new ChangeListener() {
									            public void stateChanged(ChangeEvent e) {
									                JSpinner spinner_PirSps = (JSpinner) e.getSource();
									                SummlimitPirSps = (int) spinner_PirSps.getValue();
									            }
									        };
									        spinner_PirSps.addChangeListener(listSpinner_PirSps);
									        
									        ActionListener listenerAgents = new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													agent = 0;  
													if(rdbtnAllMurshruts.isSelected()){
									        			agent = 0;allMarshruts = 1;
									        			spinner_Limit_1.setValue(300);
									        			spinner_SummLimit_1.setValue(0);
									        			spinner_4_1.setValue(0);
									        		}
													
									        		if(radioButton_all.isSelected()){
									        			agent = 0;allMarshruts = 0;
									        			spinner_Limit_1.setValue(90);
									        			spinner_SummLimit_1.setValue(69000);
									        			spinner_4_1.setValue(50000);
									        			spinner_PirSps.setValue(20000);
									        		}
									        		
//									        		if(radioButton_Sps.isSelected()){
//									        			agent = 3;allMarshruts = 0;
//									        			spinner_SummLimit_1.setValue(19000);
//									        			spinner_4.setValue(19000);
//									        		}
//									        		
//									        		if(radioButton_Pir.isSelected()){
//									        			agent = 1;allMarshruts = 0;
//									        			spinner_SummLimit_1.setValue(19000);
//									        			spinner_4.setValue(19000);
//									        		}
//									        		
//									        		if(rdbtnSK.isSelected()){
//									        			agent = 2;allMarshruts = 0;
//									        			spinner_SummLimit_1.setValue(70000);
//									        			spinner_4.setValue(50000);
//									        			spinner_Limit.setValue(80);
//									        			
//									        		}
												}
												
									        };
									        rdbtnAllMurshruts.addActionListener(listenerAgents);
									        radioButton_all.addActionListener(listenerAgents);
									        
									        JLabel label_24 = new JLabel("Лимит СК по ЛО");
									        label_24.setHorizontalAlignment(SwingConstants.CENTER);
									        label_24.setForeground(new Color(51, 102, 0));
									        label_24.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        panel_21.add(label_24, "cell 0 14,growx");
									        
									        JLabel label_21 = new JLabel("Лимит ПИР и СПС ");
									        label_21.setHorizontalAlignment(SwingConstants.CENTER);
									        label_21.setForeground(new Color(51, 102, 0));
									        label_21.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        panel_21.add(label_21, "cell 0 16,growx");
									        
									        
									        
									        
									        
									        
									        
									        JButton button_4 = new JButton("МАРШРУТЫ");
									        button_4.setToolTipText("Сформировать файл МАРШРУТЫ");
									        button_4.setForeground(new Color(204, 204, 102));
									        button_4.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        button_4.setBackground(new Color(51, 153, 153));
									        panel_21.add(button_4, "cell 0 18,grow");	
									        
						        button_4.addActionListener(new ActionListener() {
				     	        	   public void actionPerformed(ActionEvent e) {
				     	        		  DataForShortStata sfss = new DataForShortStata();
				     	        		  sfss.getData();									//********
//				     	        		  NewThread_one thread = new NewThread_one();
//											thread.New_ThreadInkass();
				     	        	   }
							        });
									        
									        
									        
									        
									        JButton button_statistik = new JButton("Статистика");
									        button_statistik.setToolTipText("показать окно статистики");
									        button_statistik.setForeground(new Color(204, 204, 102));
									        button_statistik.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        button_statistik.setBackground(new Color(51, 153, 153));
									        panel_21.add(button_statistik, "cell 0 19,growx");
									        button_statistik.addActionListener(new ActionListener() {
							     	        	   public void actionPerformed(ActionEvent e) {
							     	        		 	    	        		   
							     	        		  Statistika stata = new Statistika();
														stata.showStat(bdw.getSummInkass());
							     	        	   }
										        });
									        
									        JSeparator separator_1 = new JSeparator();
									        panel_21.add(separator_1, "cell 0 20,grow");
									        
									        textField_search = new JTextField();
									        panel_21.add(textField_search, "cell 0 22,growx");
									        textField_search.setColumns(10);
									        
									        textField_search.setUI(new HintTextFieldUI("Поиск", false));
									        
									        JButton button_search = new JButton("Поиск в таблице");
									        button_search.setToolTipText("контекстный поиск терминалов");
									        button_search.setForeground(new Color(204, 204, 102));
									        button_search.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        button_search.setBackground(new Color(51, 153, 153));
									        panel_21.add(button_search, "cell 0 23,growx");
									        button_search.addActionListener(new ActionListener() {
							     	        	   public void actionPerformed(ActionEvent e) {
							     	        		  TooManyInkassTableSerch tmits = new TooManyInkassTableSerch();							     	        		
							     	        		  	tmits.serchRequest();
							     	        		    tmits.copyPasteTable();
							     	        	   }  	
										    });
									        
									        
									        
									        
									        
									        JButton button_6 = new JButton("Обновить таблицу");
									        button_6.setToolTipText("Обновить данные по инкассации");
									        button_6.setForeground(new Color(153, 204, 153));
									        button_6.setFont(new Font("Century Schoolbook", Font.ITALIC, 16));
									        button_6.setBackground(new Color(0, 153, 153));
									        panel_21.add(button_6, "cell 0 25,growx");
									        button_6.addActionListener(new ActionListener() {
							     	        	   public void actionPerformed(ActionEvent e) {

							     	        		 new NewThread_one().New_ThreadUpDateTable();
															
							     	        	   }
										        });
									        
									        JSeparator separator_2 = new JSeparator();
									        panel_21.add(separator_2, "cell 0 27,grow");
									        
//**************************************************************************************************************************************************			        
			        JPanel panel_22 = new JPanel();
			        panel_22.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			        panel_22.setBackground(new Color(51, 153, 153));
			        panel_20.add(panel_22, BorderLayout.CENTER);
			        panel_22.setLayout(new MigLayout("", "[grow]", "[grow]"));
			        
			        JScrollPane scrollPane_6 = new JScrollPane();
			        scrollPane_6.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 204)));
			        panel_22.add(scrollPane_6, "cell 0 0,grow");
			        
			        table_5 = new JTable(model_inkass);
			        table_5.setToolTipText("kkkbjkb");
			        table_5.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			        table_5.setSelectionBackground(new Color(153, 204, 204));
			        table_5.setRowHeight(22);
			        table_5.setGridColor(Color.BLUE);
			        table_5.setFont(new Font("Tahoma", Font.PLAIN, 12));         
			        table_5.setCellSelectionEnabled(true);
			        table_5.setBackground(new Color(255, 255, 204));
			        scrollPane_6.setViewportView(table_5);
			        
			        RowSorter<TTM_inkass> sorterInkass = new TableRowSorter<TTM_inkass>(model_inkass);
			        JTableHeader headInkass = table_5.getTableHeader();
			        headInkass.setBackground(new Color(51, 153, 153));
			        headInkass.setForeground(new Color(153, 204, 153));
			        headInkass.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        
			        table_5.setRowSorter(sorterInkass);		
			        ExcelAdapter myAd1 = new ExcelAdapter(table_5);
			        
			        
			        
			        //JPanel panel_23 = new JPanel();
			        panel_23.setBackground(new Color(0, 153, 153));
			        panel_20.add(panel_23, BorderLayout.SOUTH);
			        panel_23.setLayout(new MigLayout("", "[223.00][114.00][][560.00][][][][][][]", "[][grow]"));
			        
			        JLabel lblNewLabel_7 = new JLabel("Кол-во терминалов :");
			        lblNewLabel_7.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
			        lblNewLabel_7.setForeground(new Color(0, 255, 153));
			        panel_23.add(lblNewLabel_7, "cell 1 0");
			        
			        lebel_countRowsInTTMinkass = new JLabel("0");
			        lebel_countRowsInTTMinkass.setHorizontalAlignment(SwingConstants.LEFT);
			        lebel_countRowsInTTMinkass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			        lebel_countRowsInTTMinkass.setForeground(new Color(204, 153, 204));
			        panel_23.add(lebel_countRowsInTTMinkass, "cell 2 0");
			        
			        progressBar_inkass = new JProgressBar();
			        progressBar_inkass.setStringPainted(true);
			        progressBar_inkass.setForeground(Color.GREEN);
			        panel_23.add(progressBar_inkass, "cell 3 0,grow");
			        progressBar_inkass.setMinimum(0);
			       // progressBar_inkass.setMaximum(100);
			        progressBar_inkass.setVisible(false);
			        
							        
			        button_insert_new_work.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
										
											if (textField_work.getText().compareTo("") != 0) {
					        				
												if (textField_workmail.getText().compareTo("") != 0) {
							        				
													 BD_write bdw = new BD_write();
													 try {
														bdw.insert_new_worker(textField_work.getText(),textField_workmail.getText());

														work_list = bdw.reqest_in_workerslist();
														work = work_list.toArray(new String[work_list.size()]);

														combo_1.setModel(new MyComboModel(work_list));
														combo_1.updateUI();
													} catch (ClassNotFoundException e) {

													}
													
								        		} 														
										
											} 
											BD_write bdw = new BD_write();
											try {
												work_list = bdw.reqest_in_workerslist();
											} catch (ClassNotFoundException e) {
		
												e.printStackTrace();
											}
											combo_1.setModel(new MyComboModel(work_list));
											combo_1.updateUI();
											textField_work.setText("");
											textField_workmail.setText("");
											bdw.connect();
											try {
												bdw.reqest_in_db_1();
											} catch (ClassNotFoundException e1) {}

											bdw.close_connect();
											
											try {
												bdw.reqest_in_db_TTmodel_except();
											} catch (ClassNotFoundException e1) {}
											try {
												bdw.reqest_in_db_TTmodel_workers();
											} catch (ClassNotFoundException e1) {}
										}
									});
//*********************************************************************************************************			        
			        
				bdw.connect();
				try {
					bdw.reqest_in_db_1();
				} catch (ClassNotFoundException e1) {}

				bdw.close_connect();
				
				try {
					bdw.reqest_in_db_TTmodel_except();
				} catch (ClassNotFoundException e1) {}
				try {
					bdw.reqest_in_db_TTmodel_workers();
				} catch (ClassNotFoundException e1) {}
												
	}
	

	public static int getAllMarshrutsStatus(){		
		return allMarshruts;
	}
	
	public static String getDistr_inkass3() {
		return distr_inkass3;
	}
	public static String getDistr_inkass4() {
		return distr_inkass4;
	}
	public static String getDistr_inkass5() {
		return distr_inkass5;
	}
	public static String getDistr_inkass6() {
		return distr_inkass6;
	}
	public static String getDistr_inkass2() {
		return distr_inkass2;
	}

	public static void setcountRowsInTTMinkass(String countRowsInTtmInkass){
		
		lebel_countRowsInTTMinkass.setText(countRowsInTtmInkass);
	}
}
