package all_classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.table.TableModel;

import GUIbonus.CopyPasteDataInkass;
import Warning_lost_terminals.Find_lost_term;
import inkass.TTM_inkass;
import inkass.TTMcopyPaste;
import javenue.csv.Csv;
import services.CurientTime;
import services.TurnDataTimeInkass;



public class BD_write {

	public	static List <String> row = new ArrayList<String>();
	public	static List<List<String>> term = new ArrayList();
	
	public	static ArrayList<String []> List_sig = new ArrayList<String []>();
	public	static ArrayList<String []> List_cash = new ArrayList<String []>();
	public	static ArrayList<String []> List_pay = new ArrayList<String []>();
	public	static ArrayList<String []> List_spb = new ArrayList<String []>();
	public	static ArrayList<String []> List_lo = new ArrayList<String []>();
	public	static ArrayList<String []> List_reg = new ArrayList<String []>();
	
	public	static ArrayList<String []> workers_spb = new ArrayList<String []>();
		
	String dir = System.getProperty("user.home");
	
	public TTM_spb ttm_spb = new TTM_spb();
	public TTM_lo ttm_lo = new TTM_lo();
	public TTM_reg ttm_reg = new TTM_reg();
	
	public static Connection conn = null;
	public  static ArrayList<String []> Data_mailto;
	public  static ArrayList<String []> Last_inkass_Arr;
	public  String query1;
	
	public static Statement st;
	public static int rows_count = 0;

	
//***************************************************************************************************************	
	public void connect  () {

		
		
		 Xml_read xml = new Xml_read();
		 String User = xml.read()[2];
		 String Password = xml.read()[3];

		 
					try {			        
						Properties properties=new Properties();
						properties.setProperty("user", User);
						properties.setProperty("password", Password);
						properties.setProperty("useUnicode","true");
						properties.setProperty("characterEncoding","UTF8");
						properties.put("charSet", "UTF8");
				        
				        	switch (Experr.DBtriger) {
				        	
				        	case 0 :Class.forName("com.mysql.jdbc.Driver");
							        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", properties );
			
							        break;
				        	case 1 :Class.forName (xml.read()[0]).newInstance ();
				        			conn = DriverManager.getConnection(xml.read()[1], properties);//,xml.read()[2], xml.read()[3]
				        			break;
				        	}
				    }
				    catch (Exception ex) {
				    	
				    	Gui1 gui1 = new Gui1();
				    	String txt = "<html><center>Нет подключения к БД, попробуйте ещё раз</html>";
						gui1.Gui0(txt);
				    }
		
	}

	
//****************************************************************************************************************************	
//**************************************************вставка в бд  ошибок после импорта всех файлов*************************************************************	
	public void inser_table_error33(String number,
									String sign,
									String pay,
									String cash,
									String print,
									String tach,
									String time) throws Exception{

		
		

									try {				       
									       query1 = "INSERT INTO errors33 VALUES (" + number + ", '" 
									    		   									+ sign + "', '" 
									    		   									+ pay + "', '" 
									    		   									+ cash + "', '" 
									    		   									+ print + "', '" 
									    		   									+ tach + "', '" 
									    		   									+ time + "')"; 
									       st = conn.createStatement();
									       st.execute(query1);
		
									}
								    catch (Exception ex) {
								        ex.printStackTrace();
								        Loging log = new Loging();
										log.log(ex,query1);
								    }					
	}		
//********************************************************************************************************************************	
//***********************************************************************************************************************************				

									public void  getArrayForInkassTable(String query) throws Exception {
										
										rows_count = 0;
										TTM_inkass ttm = new TTM_inkass();
										ttm.dataArrayList.clear(); 
										Statement stmt;				
										try {	
											stmt = conn.createStatement();						
												ResultSet result;
												result = stmt.executeQuery(query);
															while (result.next()) {
																	ArrayList<Object> row = new ArrayList<>();
																	row.add(result.getInt("id_term"));
																	row.add(result.getString("name_term"));
																	row.add(result.getString("object"));
																	row.add(result.getString("adress"));
																	row.add(result.getString("regim"));
																	row.add(result.getString("agent"));
																	row.add(result.getString("distr_inkass"));
																	row.add(result.getInt("summ"));
																	row.add(result.getString("last_inkass_data"));
																	row.add(result.getString("auto"));	
																	ttm.addDate(row);
															}
															result.close();							
											}	catch (SQLException e)	{Loging log = new Loging();
																		log.log(e," Запрос для таблицы inkass: ");}
										Experr.table_5.updateUI();
										Experr.table_5.revalidate();
										Experr.table_5.repaint();
										Experr.model_inkass.fireTableDataChanged();
										Experr.setcountRowsInTTMinkass(Integer.toString(ttm.getRowCount()));
								
								    }
									
//**********************************************************************************************************************									
									public void  getArrayForCopyPasteTable(String query) throws Exception {
										TurnDataTimeInkass tdti = new TurnDataTimeInkass();
										TTMcopyPaste copyPaste = new TTMcopyPaste();
										copyPaste.dataArrayList.clear();
										Statement stmt;				
										try {	
											stmt = conn.createStatement();						
												ResultSet result;
												result = stmt.executeQuery(query);
															while (result.next()) {
																	ArrayList<Object> rowCopyPaste = new ArrayList<>();
																	rowCopyPaste.add(result.getInt("id_term"));
																	rowCopyPaste.add(tdti.rEturningString(result.getString("last_inkass_data")));
																	copyPaste.addDate(rowCopyPaste);
															}
															result.close();							
											}	catch (SQLException e)	{Loging log = new Loging();
																		log.log(e," Запрос для таблички copyPaste: ");}
										CopyPasteDataInkass.table_CopyPaste.updateUI();
										CopyPasteDataInkass.table_CopyPaste.revalidate();
										CopyPasteDataInkass.table_CopyPaste.repaint();
										CopyPasteDataInkass.model.fireTableDataChanged();
										    }
									
//********************************************************ДЛЯ таблицы  ошибок **запрос в базу********************										
									public void reqest_in_db (String query) throws ClassNotFoundException {
										rows_count = 0;
										TermTableModel ttm = new TermTableModel();				
										ttm.dataArrayList.clear();  			        
										Statement stmt;				
										try {	
											stmt = conn.createStatement();						
												ResultSet result;
												result = stmt.executeQuery(query);					
															while (result.next()) {
																	String [] row = {
																			result.getString("id_term"),
																			result.getString("name_term"),
																			(result.getString("heart_bit")).substring(0, 16),
																			(result.getString("pay")).substring(0, 16),
																			result.getString("cash"),
																			result.getString("print"),
																			result.getString("tach"),
																			result.getString("other"),
																			result.getString("name_distr"),
																			(result.getString("curtime")).substring(0, 16)												
																	};												
																	ttm.addDate(row);
																	rows_count++;											
															}
						
															result.close();							
											}	catch (SQLException e)	{Loging log = new Loging();
																		log.log(e," Запрос для таблицы ошибок: ");}
										Experr.table.updateUI();
										Experr.table.revalidate();
										Experr.table.repaint();
										Experr.model.fireTableDataChanged();
										Experr.lblNewLabel_3.setText(Integer.toString(rows_count));
								    }
									
//*******************************************************ADD array of numbers terminals in terminals table in DB***********************************************************************									
									public void addArrayOfNumberTerm_in_terminalsTable (int exceptValue) throws SQLException {
										Find_lost_term findLT = new Find_lost_term();	
										findLT.getNumberTermIn_terminalsTable().clear(); 			        
										Statement stmt;				
										try {	
											stmt = conn.createStatement();						
												ResultSet result;
												result = stmt.executeQuery("Select id_term from terminals where except_term = " + exceptValue);					
															
															while (result.next()) {		
																
																findLT.addNumberTermIn_terminalsTable(result.getString("id_term"));	
																	
															}
						
															result.close();	
															
										}	catch (SQLException e){
												e.printStackTrace();
											}
										
										
								    }
									
									
//********************����� ���-�� ����� � ������� tbl_terminal_error_history********************************************									
		public String maxID () throws SQLException { 			        
			Statement stmt;	
			String maxID ="111111";
						try {	
							stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery("select max(ID) from tbl_terminal_error_history");
								while (result.next()) {
									maxID = result.getString("max(ID)");
								};
						}	catch (SQLException e){
							e.printStackTrace();
							}
				return maxID;
		}
								
									

//******************отчёт******************************************************			
		public void report_spb (String query, int trig) throws ClassNotFoundException {					
									
		//CHAR из формата 2017-02-27 12:39  в формат 27.02.2017 12:39
					
				Report repa = new Report();			        
				Statement stmt;				
				try {	
					stmt = conn.createStatement();						
					ResultSet result;
					result = stmt.executeQuery(query);					
						while (result.next()) {
							
							switch(trig){
									case 1://������� �������
										char[] substring_time_sig = (result.getString("heart_bit")).substring(0, 16).toCharArray();
										char[] arr_char_time_sig = 
											   {substring_time_sig[8],substring_time_sig[9],'.',//����
												substring_time_sig[5],substring_time_sig[6],'.',//�����
												substring_time_sig[0],substring_time_sig[1],
												substring_time_sig[2],substring_time_sig[3],' ',//���
												substring_time_sig[11],substring_time_sig[12],//�����
												substring_time_sig[13],substring_time_sig[14],
												substring_time_sig[15],						  //�����
											   };																
											String []row = {
													result.getString("id_term"),
													result.getString("name_term"),
													new String (arr_char_time_sig),
													result.getString("tach"),
													result.getString("name_work"),
													result.getString("other")										
													};ttm_spb.addDate(repa.edit_row(row,1));
											List_spb.add(repa.edit_row(row,1));break;
																
									case 2://����� ������
										char[] substring_time_pay = (result.getString("pay")).substring(0, 16).toCharArray();
										char[] arr_char_time_pay = 
											   {substring_time_pay[8],substring_time_pay[9],'.',//����
												substring_time_pay[5],substring_time_pay[6],'.',//�����
												substring_time_pay[0],substring_time_pay[1],
												substring_time_pay[2],substring_time_pay[3],' ',//���
												substring_time_pay[11],substring_time_pay[12],//�����
												substring_time_pay[13],substring_time_pay[14],
												substring_time_pay[15],						  //�����
											   };	
										   String []row1 = {
												result.getString("id_term"),
												result.getString("name_term"),
												new String (arr_char_time_pay),
												"купюра",
												result.getString("name_work"),
												result.getString("other")										
										};ttm_spb.addDate(repa.edit_row(row1,2));
										List_spb.add(repa.edit_row(row1,2));break;	
																
									case 3://� ����� �������
										char[] substring_time_payGreat = (result.getString("pay")).substring(0, 16).toCharArray();
										char[] arr_char_time_payGreat = 
											{substring_time_payGreat[8],substring_time_payGreat[9],'.',//����
											 substring_time_payGreat[5],substring_time_payGreat[6],'.',//�����
											 substring_time_payGreat[0],substring_time_payGreat[1],
											 substring_time_payGreat[2],substring_time_payGreat[3],' ',//���
											 substring_time_payGreat[11],substring_time_payGreat[12],//�����
											 substring_time_payGreat[13],substring_time_payGreat[14],
											 substring_time_payGreat[15],						  //�����
											};
																	
										 String []row2 = {
												result.getString("id_term"),
												result.getString("name_term"),
												new String (arr_char_time_payGreat),
												result.getString("tach"),
												result.getString("name_work"),
												result.getString("other")										
										};ttm_spb.addDate(repa.edit_row(row2,3));
										List_spb.add(repa.edit_row(row2,3));break;
										
							}																			
						}						
															result.close();							
											}	catch (SQLException e)	{Loging log = new Loging();
																		log.log(e," делаю отчёт о СПБ ");}

				 }
	
				
//*******************��ר�* ��******************************************************			
		public void report_lo (String query, int trig) throws ClassNotFoundException {					
			//CHAR ������� ����� ���� ���� 2017-02-27 12:39 �� ���� ���������� � ����� ��� 27.02.2017 12:39 - �������� ������ ���							
									Report repa = new Report();			        
										Statement stmt;				
										try {	
											stmt = conn.createStatement();						
												ResultSet result;
												result = stmt.executeQuery(query);					
															while (result.next()) {
																	
																switch(trig){
																case 1://������� �������
																	char[] substring_time_sig = (result.getString("heart_bit")).substring(0, 16).toCharArray();
																	char[] arr_char_time_sig = 
																		   {substring_time_sig[8],substring_time_sig[9],'.',//����
																			substring_time_sig[5],substring_time_sig[6],'.',//�����
																			substring_time_sig[0],substring_time_sig[1],
																			substring_time_sig[2],substring_time_sig[3],' ',//���
																			substring_time_sig[11],substring_time_sig[12],//�����
																			substring_time_sig[13],substring_time_sig[14],
																			substring_time_sig[15],						  //�����
																		   };																
																		String []row = {
																				result.getString("id_term"),
																				result.getString("name_term"),
																				new String (arr_char_time_sig),
																				result.getString("tach"),
																				result.getString("name_work"),
																				result.getString("other")										
																				};ttm_lo.addDate(repa.edit_row(row,1));
																List_lo.add(repa.edit_row(row,1));break;
																
																case 2://����� ������
																	char[] substring_time_pay = (result.getString("pay")).substring(0, 16).toCharArray();
																	char[] arr_char_time_pay = 
																		   {substring_time_pay[8],substring_time_pay[9],'.',//����
																			substring_time_pay[5],substring_time_pay[6],'.',//�����
																			substring_time_pay[0],substring_time_pay[1],
																			substring_time_pay[2],substring_time_pay[3],' ',//���
																			substring_time_pay[11],substring_time_pay[12],//�����
																			substring_time_pay[13],substring_time_pay[14],
																			substring_time_pay[15],						  //�����
																		   };	
																	   String []row1 = {
																			result.getString("id_term"),
																			result.getString("name_term"),
																			new String (arr_char_time_pay),
																			"купюра",
																			result.getString("name_work"),
																			result.getString("other")										
																	};ttm_lo.addDate(repa.edit_row(row1,2));
																List_lo.add(repa.edit_row(row1,2));break;	
																
																case 3://� ����� �������
																	char[] substring_time_payGreat = (result.getString("pay")).substring(0, 16).toCharArray();
																	char[] arr_char_time_payGreat = 
																		{substring_time_payGreat[8],substring_time_payGreat[9],'.',//����
																		 substring_time_payGreat[5],substring_time_payGreat[6],'.',//�����
																		 substring_time_payGreat[0],substring_time_payGreat[1],
																		 substring_time_payGreat[2],substring_time_payGreat[3],' ',//���
																		 substring_time_payGreat[11],substring_time_payGreat[12],//�����
																		 substring_time_payGreat[13],substring_time_payGreat[14],
																		 substring_time_payGreat[15],						  //�����
																		};
																								
																	 String []row2 = {
																			result.getString("id_term"),
																			result.getString("name_term"),
																			new String (arr_char_time_payGreat),
																			result.getString("tach"),
																			result.getString("name_work"),
																			result.getString("other")										
																	};ttm_lo.addDate(repa.edit_row(row2,3));
																List_lo.add(repa.edit_row(row2,3));break;
														
																}																			
															}						
															result.close();							
											}	catch (SQLException e)	{Loging log = new Loging();
																		log.log(e," сделал отчёт пл ЛО ");}

				 }				
				
	
//*******************��ר�* �������******************************************************			
				public void report_reg (String query, int trig) throws ClassNotFoundException {					
					//CHAR ������� ����� ���� ���� 2017-02-27 12:39 �� ���� ���������� � ����� ��� 27.02.2017 12:39 - �������� ������ ���							
											Report repa = new Report();			        
												Statement stmt;				
												try {	
													stmt = conn.createStatement();						
														ResultSet result;
														result = stmt.executeQuery(query);					
																	while (result.next()) {
																			
																		switch(trig){
																		case 1://������� �������
																			char[] substring_time_sig = (result.getString("heart_bit")).substring(0, 16).toCharArray();
																			char[] arr_char_time_sig = 
																				   {substring_time_sig[8],substring_time_sig[9],'.',//����
																					substring_time_sig[5],substring_time_sig[6],'.',//�����
																					substring_time_sig[0],substring_time_sig[1],
																					substring_time_sig[2],substring_time_sig[3],' ',//���
																					substring_time_sig[11],substring_time_sig[12],//�����
																					substring_time_sig[13],substring_time_sig[14],
																					substring_time_sig[15],						  //�����
																				   };																
																				String []row = {
																						result.getString("id_term"),
																						result.getString("name_term"),
																						new String (arr_char_time_sig),
																						result.getString("tach"),
																						result.getString("name_work"),
																						result.getString("other")										
																						};ttm_reg.addDate(repa.edit_row(row,1));
																		List_reg.add(repa.edit_row(row,1));break;
																		
																		case 2://����� ������
																			char[] substring_time_pay = (result.getString("pay")).substring(0, 16).toCharArray();
																			char[] arr_char_time_pay = 
																				   {substring_time_pay[8],substring_time_pay[9],'.',//����
																					substring_time_pay[5],substring_time_pay[6],'.',//�����
																					substring_time_pay[0],substring_time_pay[1],
																					substring_time_pay[2],substring_time_pay[3],' ',//���
																					substring_time_pay[11],substring_time_pay[12],//�����
																					substring_time_pay[13],substring_time_pay[14],
																					substring_time_pay[15],						  //�����
																				   };	
																			   String []row1 = {
																					result.getString("id_term"),
																					result.getString("name_term"),
																					new String (arr_char_time_pay),
																					"купюра",
																					result.getString("name_work"),
																					result.getString("other")										
																			};ttm_reg.addDate(repa.edit_row(row1,2));
																		List_reg.add(repa.edit_row(row1,2));break;	
																		
																		case 3://� ����� �������
																			char[] substring_time_payGreat = (result.getString("pay")).substring(0, 16).toCharArray();
																			char[] arr_char_time_payGreat = 
																				{substring_time_payGreat[8],substring_time_payGreat[9],'.',//����
																				 substring_time_payGreat[5],substring_time_payGreat[6],'.',//�����
																				 substring_time_payGreat[0],substring_time_payGreat[1],
																				 substring_time_payGreat[2],substring_time_payGreat[3],' ',//���
																				 substring_time_payGreat[11],substring_time_payGreat[12],//�����
																				 substring_time_payGreat[13],substring_time_payGreat[14],
																				 substring_time_payGreat[15],						  //�����
																				};
																										
																			 String []row2 = {
																					result.getString("id_term"),
																					result.getString("name_term"),
																					new String (arr_char_time_payGreat),
																					result.getString("tach"),
																					result.getString("name_work"),
																					result.getString("other")										
																			};ttm_reg.addDate(repa.edit_row(row2,3));
																		List_reg.add(repa.edit_row(row2,3));break;
																
																		}																			
																	}						
																	result.close();							
													}	catch (SQLException e)	{Loging log = new Loging();
																				log.log(e," Сделал отчёт по Регионам ");}

						 }	
			
			public void reqest_in_db_TTmodel_terminals () throws ClassNotFoundException {
				this.connect();
				String query = "select id_term, name_term, name_distr from terminals";
				TermTableMod_terminals ttm_t = new TermTableMod_terminals();				
				ttm_t.dataArrayList.clear();  			        
				Statement stmt;				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery(query);					
									while (result.next()) {
											String [] row = {
													result.getString("id_term"),
													result.getString("name_term"),
													result.getString("name_distr"),	};																							
											ttm_t.addDate(row);											
									}
											result.close();							
					}	catch (SQLException e)	{System.out.println("77 " +e);}
				Experr.table_term.updateUI();
				Experr.table_term.revalidate();
				Experr.table_term.repaint();
				Experr.model_term.fireTableDataChanged();
				Experr.textField_naneterm.setText("");
				this.close_connect();
		}
//******запрос для построения таблицы исключений******************************************************************************************			
							public void reqest_in_db_TTmodel_except () throws ClassNotFoundException {
								this.connect();
								String query = "select id_term, name_term, name_distr, except_name, time_except from terminals "
											 + "where except_term != 0";
								TermTableMod_except ttm_e = new TermTableMod_except();				
								ttm_e.dataArrayList.clear();  			        
								Statement stmt;				
								try {	
									stmt = conn.createStatement();						
										ResultSet result;
										result = stmt.executeQuery(query);					
													while (result.next()) {
															String [] row = {
																	result.getString("id_term"),
																	result.getString("name_term"),																																		
																	result.getString("except_name"),
																	result.getString("name_distr"),
																	result.getString("time_except"),};																							
															ttm_e.addDate(row);											
													}
															result.close();							
									}	catch (SQLException e)	{Loging log = new Loging();
																 log.log(e," ������ ��� ������� ����������: ");}
								Experr.table_except.updateUI();
								Experr.table_except.revalidate();
								Experr.table_except.repaint();
								Experr.model_except.fireTableDataChanged();
								this.close_connect();
						}
		
//***************************************************************************************************************************							
							public void insert_new_worker (String new_work, String mailwork) throws ClassNotFoundException {				
								String query = "insert into user_mailto (name_work, mailto) "
											  +"value ('" + new_work + "', '" + mailwork + "')";
								
								this.connect();			
								Statement stmt;				
											try {	
												stmt = conn.createStatement();
												stmt.execute(query);
											}	catch (SQLException e)	{Loging log = new Loging();
																		 log.log(e," �������� ������ ���������: ");}
								this.close_connect();
								this.reqest_in_db_TTmodel_workers();
								Experr.table_workers.updateUI();
								Experr.table_workers.revalidate();
								Experr.table_workers.repaint();
								Experr.model_work.fireTableDataChanged();
								
							}			
							
//***************************************************************************************************************************							
				public void insert_curient_inkass (String term, String time_incass) throws ClassNotFoundException {				
							String query = "insert into curient_last_inkass (id_term, time) "
									+"values ('" + term + "', '" + time_incass + "')";							
							Statement stmt;				
							try {	
								stmt = conn.createStatement();
								stmt.execute(query);
							}	catch (SQLException e)	{System.out.println("���������� " +e);}							
				}						
//*******************************************************************************************************************							
			
//***************************************************************************************************************************							
							public void clear_table (String table) throws ClassNotFoundException {				
										String query = "truncate table " + table;						
										Statement stmt;				
										try {	
											stmt = conn.createStatement();
											stmt.execute(query);
										}	catch (SQLException e)	{System.out.println("������� ������� " +e);}							
							}						
//*******************************************************************************************************************				
				
							
		public void reqest_in_db_TTmodel_workers () throws ClassNotFoundException {
		    this.connect();
			String query = "select * from user_mailto";
			TermTableMod_workers ttm_w = new TermTableMod_workers();				
		   ttm_w.dataArrayList.clear();  			        
			Statement stmt;				
			try {	
			stmt = conn.createStatement();						
			ResultSet result;
			result = stmt.executeQuery(query);					
			while (result.next()) {
					String [] row = {
							result.getString("name_work"),
							result.getString("mailto"),};																							
							ttm_w.addDate(row);											
					}
							result.close();							
			}	catch (SQLException e)	{System.out.println("99 " +e);}
					this.close_connect();
					Experr.table_workers.updateUI();
					Experr.table_workers.revalidate();
					Experr.table_workers.repaint();
					Experr.model_work.fireTableDataChanged();
	 }			
													public void reqest_in_db_1 () throws ClassNotFoundException {				
															String query = "Select * from mailto";				
															rows_count = 0;
															TermTableModel_1 ttm_1 = new TermTableModel_1();				
															ttm_1.dataArrayList.clear();  			        
															Statement stmt;				
															try {	
																stmt = conn.createStatement();						
																	ResultSet result;
																	result = stmt.executeQuery(query);					
																				while (result.next()) {
																						String [] row = {
																								result.getString("name_distr"),
																								result.getString("name_work"),
																								result.getString("mailto")												
																						};												
																						ttm_1.addDate(row);
																						rows_count++;											
																				}
																				result.close();							
																}	catch (SQLException e)	{System.out.println("2 " +e);}
															Experr.table_1.updateUI();
															Experr.table_1.revalidate();
															Experr.table_1.repaint();
															Experr.model_1.fireTableDataChanged();
													  }
			
//**************************������ ��������� � ���������� ��� �������� ������**********************************************************************
			
			public void reqest_for_posting (String bonus)  {
				this.connect();
				String query = "Select * from mailto"+bonus;
				Data_mailto = new ArrayList<String []>();    
				Statement stmt;				
					try {		
							stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);					
										while (result.next()) {
												String [] row_mailto = {
														result.getString("name_distr"),
														result.getString("name_work"),
														result.getString("mailto")												
												};	
												Data_mailto.add(row_mailto);
										}	
										result.close();							
						}	catch (SQLException e)	{System.out.println("2 " +e);}
					this.close_connect();
					Experr.model_1.fireTableDataChanged();
					Experr.table_1.updateUI();
					Experr.table_1.revalidate();
					Experr.table_1.repaint();
			}
			
//*****������� ������ ��������� ����������***************************************************************************			
			public void last_inkass_array ()  {
				this.connect();
				String query = "call last_inkass()";
				Last_inkass_Arr = new ArrayList<String []>();    
				Statement stmt;				
					try {		
							stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);					
										while (result.next()) {
												String [] row = {
														result.getString("id_distr"),
														result.getString("MAX(curient_last_inkass.time)")												
												};	
												Last_inkass_Arr.add(row);
										}	
										result.close();							
						}	catch (SQLException e)	{System.out.println("������ ��������� ���������� " +e);}
			}
//********************************************************************************************************			
//**********************������ ������� ��������� ��������**********************
			public String get_time_last_mail ()  {
				this.connect();
				String query = "select value from constant where name_const = 'time_last_mail'";
				String time_last_mail = "";   
				Statement stmt;				
					try {		
							stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);					
										while (result.next()) {
												
												time_last_mail =	result.getString("value");											
												
										}	
										result.close();							
						}	catch (SQLException e)	{System.out.println("������ ������� �������� " +e);}
			
			return time_last_mail;
			}
//**************************************************************************			
//**********************������ � �� ������� ��������� ��������**********************
						public void set_time_last_mail (String time_last_mail)  {
								this.connect();
								String query = "update constant set value = '"+ time_last_mail + "' "
											 + "where name_const = 'time_last_mail'";  
								Statement stmt;				
								try {	
									stmt = conn.createStatement();
									stmt.execute(query);
								}	catch (SQLException e)	{System.out.println("������ ������� �������� " +e);}	
				
						}
			
//********************************************************************************************			
			public  List<String> reqest_in_workerslist () throws ClassNotFoundException {
											this.connect();
											String query = "select name_work from user_mailto ORDER BY name_work";
											List <String> workers = new ArrayList<String>();
											int i = 0;			        
											Statement stmt;				
											try {	
												stmt = conn.createStatement();						
													ResultSet result;
													result = stmt.executeQuery(query);				
																while (result.next()) {
																		workers.add(i, result.getString("name_work"));
																	i++;	
																}
																result.close();							
											}	catch (SQLException e)	{System.out.println("2 " +e);}
											this.close_connect();			
											return workers;
										}
//*********************������ ����������  ������ � ����������  ��� ����������� 	**************************		
										
			public  List<String> reqest_in_distrs () throws Exception {
						this.connect();
						String query = "select name_distr from distrs ORDER BY name_distr";
						List <String> distrs = new ArrayList<String>();
						int i = 0;			        
						Statement stmt;				
						try {	
							stmt = conn.createStatement();						
								ResultSet result;
								result = stmt.executeQuery(query);				
											while (result.next()) {													
												distrs.add(i, result.getString("name_distr"));
												i++;	
											}
											result.close();							
						}	catch (SQLException e)	{System.out.println("2 " +e);}
						this.close_connect();			
						return distrs;
			}
//******************************************************************************************************************************		
		
														public void reqest_in_terminals (String query) throws Exception {	
															this.connect();
															TermTableMod_terminals ttm_t = new TermTableMod_terminals();				
															ttm_t.dataArrayList.clear();  			        
													
															Statement stmt;				
															try {	
																stmt = conn.createStatement();						
																	ResultSet result;
																	result = stmt.executeQuery(query);					
																				while (result.next()) {
																						String [] row = {
																								result.getString("id_term"),
																								result.getString("name_term"),
																								result.getString("name_distr")												
																						};												
																						ttm_t.addDate(row);			
																				}
																				result.close();							
																}	catch (SQLException e)	{System.out.println("9954 " +e);}															
															Experr.table_term.updateUI();
															Experr.table_term.revalidate();
															Experr.model_term.fireTableDataChanged();
															Experr.table_term.repaint();
															
															this.close_connect();
														}
//******************************************************************************************************************************		
														
				public void reqest_workers_for_repo () throws Exception {	
					this.connect();
					String query = "call work_spb_repo";
					Statement stmt;				
					try {	
						stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery(query);					
						while (result.next()) {
							String [] row = {
									result.getString("name_work")												
							};														
							workers_spb.add(row);
						}
						result.close();							
					}	catch (SQLException e)	{System.out.println("9954 " +e);}															
					
					this.close_connect();
				}
//*********************************************************************************************************			
			
		public String reqest_in_mailto (String query)  {			
				String resultat_query = "��� ������";
				Statement stmt;
				try {	
						stmt = conn.createStatement();	
						ResultSet result;
						result = stmt.executeQuery(query);						
						while (result.next()) {
							resultat_query = result.getString("mailto");	
						}
						result.close();							
				}	catch (SQLException e)	{System.out.println("2333 " +e);}
					return resultat_query;					
		}	
			
//********������ ���������� ������ ����� ( 1 - ���������� � ������ 0 -� �� ���������6�) ��� ��������� ��������			
													public  int[] reqest_in_distrs (String distr) throws ClassNotFoundException {
														this.connect();
														String query = "select spb_lo, spb, lo, regions from distrs "
																	  +"where name_distr = '" + distr + "'";
														int [] groups = new int [4];								        
														Statement stmt;				
														try {	
															stmt = conn.createStatement();						
																ResultSet result;
																result = stmt.executeQuery(query);				
																			while (result.next()) {
																					groups [0] =result.getInt("spb_lo");
																					groups [1] =result.getInt("spb");
																					groups [2] =result.getInt("lo");
																					groups [3] =result.getInt("regions");
																			}
																			result.close();							
														}	catch (SQLException e)	{System.out.println("reqest_in_distrs " +e);}
														this.close_connect();			
														return groups;
													}
//******************************************************************************************************************************		
			
		public String getMailtoAt(int rowIndex, int columnIndex) {
			String [] rows = Data_mailto.get(rowIndex);
	        return rows[columnIndex];			
		}			
		public int getRowMail() {				
			return Data_mailto.size();
		}
			
//**************************************************************************************************************************			
			
			
			public void write_db (String query) throws Exception {
				BD_write bdw = new BD_write();					
					bdw.connect();
					bdw.uni_reqest_in_db(query);								
					bdw.close_connect();
			}
//***************������ ��� ������ ������ ��� �������� ������ ������, ���������� ������ ������� ���������� � ����		
												public  List<String> reqest_for_double (String for_except) throws Exception {
													this.connect();
													String query = "select id_term from terminals" + for_except;
						List <String> numbers_term = new ArrayList<String>();//������ ������� ���������� ��� �������� �� ��������****
													int i = 0;			        
													Statement stmt;				
													try {	
														stmt = conn.createStatement();						
															ResultSet result;
															result = stmt.executeQuery(query);				
																		while (result.next()) {													
																			numbers_term.add(i, result.getString("id_term"));
																			i++;	
																		}
																		result.close();							
													}	catch (SQLException e)	{System.out.println("5432 " +e);}
													this.close_connect();			
													return numbers_term;
										}
//****�������������� ����� ������ ( �������� ������, ��������)***********************************************************************************************			
			public void write_others (String id_term, String others, int write_or_update) throws Exception {
				String query,
					   query1,
					   query2,
					   query3;
				BD_write bdw = new BD_write();
				bdw.connect();
				
				switch (write_or_update) {
					
						case 1: query = "UPDATE terminals SET other = '" + others + "' WHERE id_term = " + id_term;
								bdw.uni_reqest_in_db(query);

//********************************����� ��������� � � ���������***************************************************
								query2 = "UPDATE tbl_terminal SET Note = '" + others + "' WHERE ID = " + id_term;
								bdw.uni_reqest_in_db(query2);
//***********************************************************************************************								
								
							break;
							
						case 2: query1 = "UPDATE terminals SET other = '" + others + "' WHERE id_term = " + id_term;// + " COMMIT";
								bdw.uni_reqest_in_db(query1);
						
//********************************����� ��������� � � ���������***************************************************						
						query3 = "UPDATE tbl_terminal SET Note = '" + others + "' WHERE ID = " + id_term;		
						bdw.uni_reqest_in_db(query3);		
//************************************************************************************************************						
								
							break;					
				}
				
								
				bdw.close_connect();
			}
//*****************************************************************************************************************			
			public void write_distr (String name_distr, String name_work) throws Exception {
				String query,
					   query1;
				BD_write bdw = new BD_write();
				bdw.connect();
				
						query = "UPDATE mailto SET name_work = '" + name_work + "' WHERE name_distr = " + name_distr;

								bdw.uni_reqest_in_db(query);				

				
								
				bdw.close_connect();
			}
//**************************************************************************************************************************			
													public void insert_new_term (String query) throws ClassNotFoundException {				
														this.connect();			
														Statement stmt;				
																	try {	
																		stmt = conn.createStatement();
																		stmt.execute(query);
																	}	catch (SQLException e)	{Loging log = new Loging();
																							log.log(e," �������� ����� �����: ");}
														this.close_connect();
														this.reqest_in_db_TTmodel_terminals();
														this.reqest_in_db_TTmodel_except();
													}
//****************************************************************************************************************	
													public void insert_new_term_only_for_errors (String numberNewTerm) throws ClassNotFoundException {						
														Statement stmt;	
														
																	try {	
																		stmt = conn.createStatement();
																		stmt.execute("INSERT INTO terminals (id_term,name_term,name_distr,spb_lo,spb,lo,regions,other,except_name,except_term,time_except) "
																				    +"VALUES ("+numberNewTerm+",'NEW','CHECKING',0,0,0,0,'новая установка',NULL,0,NULL)");
																		Loging log = new Loging();
																		log.logtext("add new term № "+numberNewTerm);
																	}	catch (SQLException e)	{Loging log = new Loging();
																							log.log(e," ERROR add new term № "+numberNewTerm);}
																	
													}
//****************************************************************************************************************														
													
			
			public void uni_reqest_in_db (String query) throws ClassNotFoundException {
							        
						Statement stmt;
						
						try {
			
							stmt = conn.createStatement();
							stmt.execute(query);
		
						}	catch (SQLException e)	{System.out.println(e);}
				
			}
			
//************************������ ������ ���������� ������� ������� ���������� �� ����������� ������****************			
			public String get_MAX_time_lost_term (String id_term)  {
	
				String query = "select max(heart_bit)  from errors_save where id_term = '" + id_term + "'";
				String max_time_lost_term = "";   
				Statement stmt;				
					try {		
							stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);					
										while (result.next()) {
												
											max_time_lost_term =result.getString("max(heart_bit)");											
												
										}	
							
						}	catch (SQLException e)	{System.out.println("������ ���������� ������� ���������� ������ " +e);}
			
			return max_time_lost_term;
			}
//******************************************************************************************************************			
//************************�������� ������ � ����������� �� �� ��� ���****************			
			public int get_except_term (String id_term)  {
				
				String query = "select except_term  from terminals where id_term = '" + id_term + "'";
			    int except_term = 0;   
				Statement stmt;				
					try {		
							stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);					
										while (result.next()) {
												
											except_term =result.getInt("except_term");											
												
										}	
															
						}	catch (SQLException e)	{System.out.println("������ ���������� " +e);}
			
			return except_term;
			}		
			
			
//*********�������������� �������� ������ ��� �������� � ������� �������*******************************************************************			
			public void edit_pole_terminals (String pole_for_editable, String editable, String id_term, int column, int[] groups) throws Exception {

												this.connect();												
		String query1 = "UPDATE terminals SET " + pole_for_editable + " = '" + editable
				       +"' , spb_lo = "+ groups[0]
				       +", spb = "+ groups[1]
				       +", lo = "+ groups[2]
				       +", regions = "+ groups[3]
				       +" WHERE id_term = '" + id_term + "'";
		

		
												this.uni_reqest_in_db(query1);	
//						String query2 = "UPDATE terminals SET name_distr = '" + name_distr + "' WHERE id_term = '" + id_term + "'";								
//												this.uni_reqest_in_db(query2);													
												this.close_connect();
			}
//*******************************************************************************************************************************			
		
			public void contextFindTerminalsInMainTable_terminals(){
				
				
			}
			
//***********************************************************************************			
				public  List<String> getAll_id_termTrmlist_report () {
					//this.connect();
					String query = "select id_term from trmlist_report";
					List <String> id_term = new ArrayList<String>();		        
					Statement stmt;				
					try {	
						stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);				
										while (result.next()) {													
											id_term.add(result.getString("id_term"));	
										}
										result.close();							
					}	catch (SQLException e)	{}
								
					return id_term;
		}
			
				public  List<String> getSummInkass () { //*****************PROCEDURE**************
					this.connect();
					String query = "CALL getSummInkass";
					List <String> summ = new ArrayList<String>();		        
					Statement stmt;				
					try {	
						stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);				
										while (result.next()) {													
											summ.add(result.getString("SUM(summ)"));	
										}
										result.close();							
					}	catch (SQLException e)	{}
								
					return summ;
		}
				
				public  List<String> getStatByMarshrut (String distrUp,String distrCenter,String distrDown, String limit_inkass) { //*****************PROCEDURE**************
					this.connect();
					int i =0;
					String query = "CALL statByMarshrut ('"+distrUp+"' , '"+distrCenter+"' , '"+distrDown+"' , "+limit_inkass+")";
					List <String> stata = new ArrayList<String>();	
					stata.add("0");
					stata.add("0");
					stata.add("0");
					Statement stmt;				
					try {	
						stmt = conn.createStatement();						
							ResultSet result;
							result = stmt.executeQuery(query);				
										while (result.next()) {		
											stata.set(i, result.getString("COUNT(*)"));	
											i++;
										}
										result.close();							
					}	catch (SQLException e)	{}
					return stata;
		}
				
			public void insertInTo_trmlist_reportPartOne(int id_term, String city_name, String street_name,
														 int home_number,String distr_inkass, String object,
														 String adress){
				
				String query = "INSERT INTO trmlist_report (id_term,city_name,street_name,"
							  + "home_number,agent, regim, distr_inkass, object,adress, auto) "
							  +"VALUES ("+id_term+", '"+city_name+"' , '"+street_name
							  +"' ,"+home_number+", 'СК', '9-21', '"+ distr_inkass+"','"+object+"','"+adress+"', '"+new CurientTime().get()+"')";
						try {
							this.uni_reqest_in_db(query);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}					
			}
//			public void updateInTo_trmlist_reportPartToo(int id_term, String distr_inkass, String object, String adress){
//				
//							String query = "update trmlist_report set distr_inkass = '"+ distr_inkass+"',"
//																  + " object = '"+object+"',"
//																  + " adress = '"+adress+"'"
//																  + " where id_term = '"+id_term+"'";
//									try {
//										this.uni_reqest_in_db(query);
//									} catch (ClassNotFoundException e) {
//										e.printStackTrace();
//									}					
//						}
			
			public String getName_term (String id_term){				
				String query = "select name_term from terminals where id_term = '"+id_term+"'";		        
				String name_term = "не определено";
				Statement stmt;				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery(query);				
									while (result.next()) {													
										name_term = result.getString("name_term");	
									}
									result.close();							
				}	catch (SQLException e)	{}
				
				return name_term;
			}
			
			
			public List<String> getCityAndStreet (String id_term) throws Exception {	
				//this.connect();
				List <String> CityAndStreet = new ArrayList<String>();
				Statement stmt;				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery("select city_name, street_name from trmlist_report where id_term = "+id_term);					
									while (result.next()) {
										
										CityAndStreet.add(result.getString("city_name"));
										CityAndStreet.add(result.getString("street_name"));										
									
									}
									result.close();							
					}	catch (SQLException e)	{System.out.println("9954 " +e);}																			
				//this.close_connect();
				System.out.println(id_term);
				System.out.println(CityAndStreet.get(0));
				
				return CityAndStreet;
			}
			public String getDistr_inkass (String city_name, String street_name ) throws Exception {	
				//this.connect();
				String distr_inkass = "";
				Statement stmt;				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery("select distr_inkass from trmlist_report where city_name = '"+city_name+"' and street_name = '"+street_name+"' and distr_inkass != '' LIMIT 1");//select distr_inkass from trmlist_report where street_name = '"+street_name+"' and distr_inkass !='' LIMIT 1");					
									while (result.next()) {										
										distr_inkass = result.getString("distr_inkass");									
									}
									result.close();							
					}	catch (SQLException e)	{}																			
				//this.close_connect();
				if (distr_inkass.compareTo("")==0 ){
					distr_inkass = "не определено";
				}
				
				return distr_inkass;
			}
			
			public String getDistr_inkassForLo (String city_name) throws Exception {	
				//this.connect();
				String distr_inkass = "не определено";
				Statement stmt;				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery("select distr_inkass from trmlist_report "
												 + "where city_name = '"+city_name+"' and distr_inkass != '' and distr_inkass != 'не определено' LIMIT 1");
								while (result.next()) {								
										distr_inkass = result.getString("distr_inkass");									
								}
									result.close();							
					}	catch (SQLException e)	{}																			
				return distr_inkass;
			}
			
			
			public void insertOstatki(String id_term, int summ, String last_inkass){
					String query = "INSERT INTO ostatki (id_term,summ,bonus, last_inkass_data) VALUES ('"+id_term+"',"+summ+" , 0, '"+last_inkass+"')";
					try {
						this.uni_reqest_in_db(query);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
			}
			
			public ArrayList getPrivateDate (String distr_inkass) {	
				this.connect();
				ArrayList privateData = new ArrayList<>();
				Statement stmt;				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery("select * from private_data where distr_inkass = '"+distr_inkass+"'");					
									while (result.next()) {
										
										privateData.add(result.getString("up_part"));	
										privateData.add(result.getString("center_part"));
										privateData.add(result.getString("down_part"));	
										privateData.add(result.getInt("sheet_index"));
										privateData.add(result.getBoolean("lo"));	
									
									}
									result.close();							
					}	catch (SQLException e)	{}																			

				return privateData;
			}
			
			
			public ArrayList<String[]> getDataForInkassSPb (String indexMarshrut, int rowLimitCount, int agentIndex) {	
				
				String agent = "(agent = 'ПИР' or agent = 'СК'or agent = 'СПС') ";
				int summLimit = 0;
				switch (agentIndex){
				case 1: agent = "agent = 'ПИР' "; break;
				case 2:	agent = "agent = 'СК' "; break;	
				case 3:	agent = "agent = 'СПС' "; break;
				}
				
				if (Experr.allMarshruts == 0){
					summLimit = Experr.Summlimit;
				}
				
				ArrayList<String[]> dataForInkass = new ArrayList<>();				
				String query = "(SELECT trmlist_report.object, ostatki.id_term, trmlist_report.adress, trmlist_report.regim, "   // querry only for SPb marshruts
							 + "trmlist_report.street_name, trmlist_report.home_number, trmlist_report.agent "
							 + "FROM ostatki "
							 + "left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term "
							 + "left JOIN terminals ON ostatki.id_term = terminals.id_term "
							 + "where terminals.except_term = 0 and "
							 + "distr_inkass = '"+indexMarshrut+"' and " 
							 + "(ostatki.summ + ostatki.bonus) >= " + summLimit + " and "
							 + agent									// var distr_inkass  and var agent
							 + "order by (summ + bonus) DESC limit "+rowLimitCount+") order by street_name, home_number";			// var value of LIMIT
		        
				Statement stmt;	
				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery(query);					
									while (result.next()) {
											String [] row = {
													result.getString("object"),
													result.getString("id_term"),
													result.getString("adress"),
													result.getString("regim"),
													result.getString("agent")
											};												
											dataForInkass.add(row);										
									}
									result.close();							
					}	catch (SQLException e)	{}
				return dataForInkass;
		  }
			
			
			public ArrayList<String[]> getDataForInkassLO (String indexMarshrut, int agentIndex) {	
				
				String agent = "(agent = 'ПИР' or agent = 'СК'or agent = 'СПС') ";
				int summLimit = 0;
				switch (agentIndex){
				case 1: agent = "agent = 'ПИР' "; break;
				case 2:	agent = "agent = 'СК' "; break;	
				case 3:	agent = "agent = 'СПС' "; break;
				}
				
				if (Experr.allMarshruts == 0){
					summLimit = Experr.SummlimitLO;
				}
				
				
				ArrayList<String[]> dataForInkass = new ArrayList<>();				
				String query = "SELECT trmlist_report.object, ostatki.id_term, trmlist_report.adress, trmlist_report.regim, "   // querry only for LO marshruts
							 + "trmlist_report.city_name, trmlist_report.street_name, trmlist_report.home_number, trmlist_report.agent, trmlist_report.distr_inkass "
							 + "FROM ostatki "
							 + "left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term "
							 + "left JOIN terminals ON ostatki.id_term = terminals.id_term "
							 + "where terminals.except_term = 0 and "
							 + "distr_inkass = '"+indexMarshrut+"' and " 
							 + "(ostatki.summ + ostatki.bonus) >= " + summLimit + " and "
							 + agent									// var distr_inkass  and var agent
							 + "order by city_name, street_name, home_number";			
				Statement stmt;				
				
				try {	
					stmt = conn.createStatement();						
						ResultSet result;
						result = stmt.executeQuery(query);					
									while (result.next()) {
											String [] row = {
													result.getString("object"),
													result.getString("id_term"),
													result.getString("adress"),
													result.getString("regim"),
													result.getString("agent"),
													result.getString("distr_inkass")
											};												
											dataForInkass.add(row);										
									}
									result.close();							
					}	catch (SQLException e)	{System.out.println("делаю массив данных для маршрутов инкассации " +e);}
				return dataForInkass;
		  }
			
			public void editCellOfTableInkass (String id_term, String column_name, String cell_value) throws Exception {
				String query;
				BD_write bdw = new BD_write();
				bdw.connect();
				query = "UPDATE trmlist_report SET "+column_name+"= '" + cell_value + "' WHERE id_term = " + id_term;
				bdw.uni_reqest_in_db(query);				
				bdw.close_connect();
			}
			
			
		public void close_connect(){
			

				try {
					BD_write.conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}


			BD_write.conn = null;
			
			
		}
		
		
		public void main_reqest () throws Exception{
			long curTime = System.currentTimeMillis();
			//String StringDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime - 60000);
			String StringDateTime_sign = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime
																				- (Experr.days_signal*24*60*60000 
																				 + Experr.hours_signal));
						
			String StringDateTime_pay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime
																				- (Experr.days_pay*24*60*60000 
																				 + Experr.hours_pay));
			
			
			BD_write bdw = new BD_write();
			
//			System.out.println(Experr.history);	
//			System.out.println(Experr.date_OT);
//			System.out.println(Experr.date_DO);
//			System.out.println(Experr.query_distr);
			
			if ( Experr.history == 0) {
			
					String query_main_for_table = "select errors33.id_term, terminals.name_term, errors33.heart_bit, errors33.pay, errors33.cash,"
							 + " errors33.print, errors33.tach, terminals.other, terminals.name_distr, errors33.curtime"
							 + " from errors33"
							 + " left join terminals on errors33.id_term = terminals.id_term"					 					 
							 + " where (heart_bit < '" + StringDateTime_sign + "' or"
							 + " pay < '" + StringDateTime_pay + "' or"
							 + " cash != 'OK' or terminals.other != ''" + Experr.select_checkbox_print + ") and "
							 +   Experr.query_group
							 +   Experr.query_distr										
							 + " terminals.except_term = 0";
					
					bdw.reqest_in_db(query_main_for_table);
				}
		
				if ( Experr.history == 1) {
					
					System.out.println(Experr.date_OT);
					System.out.println(Experr.date_DO);
					
					String query_main_for_table = "select errors_save.id_term, terminals.name_term, errors_save.heart_bit, "
							                     +"errors_save.pay, errors_save.cash, errors_save.print, errors_save.tach, "
							                     +"errors_save.others, terminals.name_distr, errors_save.curtime "
							                     +"from errors_save "
							                     +"left join terminals on errors_save.id_term = terminals.id_term "
							                     +"where "
							                     +"curtime > '" + Experr.date_OT + "' and "
							                     +"curtime < '" + Experr.date_DO + "'";
//							                     + Experr.query_distr
//							                     +"(errors_save.signal < ADDDATE(curtime, INTERVAL -2 hour) or "
//							                     +"errors_save.pay < ADDDATE(curtime, INTERVAL -2 day) or "
//							                     +"errors_save.cash != 'OK' or "
//							                     +"errors_save.others !='' )";
					
						bdw.reqest_in_db(query_main_for_table);
				}
		
		
		}
		
		
		
			
}
