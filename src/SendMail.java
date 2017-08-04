import java.io.DataInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JTable;

public class SendMail {
	Sender sender;

	 static DataInputStream dis = null;
	
	public static String distr,
						 name;
	
	public void open_socket() {
	
	
		this.sender = new Sender("192.168.8.100",                     //�192.168.8.100���� SMTP �������
				   "25",                                //����  SMTP �������
				   "",                //tm\point_errors����� ������ ��� �����������
				   "");	                     //Po666nT������ ������ ��� �����������
		
		
		  


		
		
		
//			sender = new Sender("webmail.td-mobile.ru",                     //����� SMTP �������
//									   "25",                                //����  SMTP �������
//									   "",                //����� ������ ��� �����������
//									   "");	                     //������ ������ ��� �����������
	}
	
	
	public void resiv_mail(String table, String mailto) throws IOException{
		
		
					this.sender.send("Список ошибок",
								table,							//����� ������ ������
						       "it_ss@td-mobile.ru",                //�����������������
						       mailto);                 //���������� ������
					

//					String readstr = dis.readLine();
//				        System.out.println("SMTP respons: " + readstr);
	   			   
	}
	
	public void engin_mail (String mailto, String distr) throws IOException{
		StringBuilder data = new StringBuilder();	
		String [] row_telo = new String [TermTableModel.dataArrayList.size()];
		String [] rows = new String [TermTableModel.dataArrayList.size()];
		String number_terminal;
		String name_terminal; 
		String status_signal;
		String status_pay;
		String status_cash;
		String status_print;
		String status_others;
		int index = 0;
		String colorRow,
			   colorRow1,
			   colorRow2;
	   
		colorRow1 = "<tr bgcolor='"+ Experr.txtFild_color_mailto1.getText()+"'>";
		colorRow2 = "<tr bgcolor='"+ Experr.txtFild_color_mailto2.getText()+"'>";
		
		long interval_sign = Experr.days_signal*24*60*60000 + Experr.hours_signal;
		long interval_pay = Experr.days_pay*24*60*60000 + Experr.hours_pay;
		
		colorRow = colorRow1;
	    
	  
		for (int i = 0; i < TermTableModel.dataArrayList.size(); i++) {
		
			
				rows = TermTableModel.dataArrayList.get(Experr.table.getRowSorter().convertRowIndexToModel(i));
				
				if (rows[8].compareTo(distr) == 0){
//**************************************************************************************************************************				
								long curTime = System.currentTimeMillis();//������� ��������� ����� � �������������
								long time_st = 0;
								long time_st1 = 0;
							    
							    String uu = rows[2].toString();
							    String uu11 = rows[3].toString();
							    
							   
							   
							    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							    try {
									Date time= format1.parse(uu);
									time_st = time.getTime();
									Date time1= format1.parse(uu11);
									time_st1 = time1.getTime();
									
								} catch (ParseException e1) {
				
									e1.printStackTrace();
								}
							    
							    long res = curTime - time_st;
							    long res1 = curTime - time_st1;							   
//*************************************************************************************************************************				
							    status_signal="";
							    status_pay="";
							    status_cash="";
							    status_others="";
							    status_print="";
							    
							    
								char[] ch_sig = rows[2].toCharArray();
								char[] ch_pay = rows[3].toCharArray();
								
								char[] subch_sig = {ch_sig[8],ch_sig[9],ch_sig[7],ch_sig[5],ch_sig[6],
										   			ch_sig[10],ch_sig[11],ch_sig[12],ch_sig[13],ch_sig[14],ch_sig[15]};
								char[] subch_pay = {ch_pay[8],ch_pay[9],ch_pay[7],ch_pay[5],ch_pay[6],
							   						ch_pay[10],ch_pay[11],ch_pay[12],ch_pay[13],ch_pay[14],ch_sig[15]};
								
								String rows2 = new String (subch_sig);
								String rows3 = new String (subch_pay);
								
										number_terminal = rows[0];
										name_terminal=rows[1];
										if (res > interval_sign){status_signal="c:"+rows2.replace("-", ".");}
										//if (res < 7260000){status_signal="" + rows2.substring(5).replace("-", ".");;}
										if (res1 > interval_pay){status_pay="|пл:"+rows3.replace("-", ".");}
										//if (res1 < 172860000){status_pay="";}												
										if(rows[4].compareTo("OK")!=0){status_cash="|к:"+rows[4];}
										if(rows[5].compareTo("OK")!=0){status_print="|пр:"+rows[5];}
										
										if (rows[7]==null){rows[7]="";}//***������ �� null 
										
										

										String other = new String (rows[7]);
										
										
										
										if(other.compareTo("")!=0){status_others="|"+other;}
								
										 
										
										row_telo[index] = (colorRow + "<td style='border: 1px solid #999;'>"+number_terminal
												 +"</td><td style='border: 1px solid #999;'>"+name_terminal
												 +"</td><td style='border: 1px solid #999;'>"+status_signal+status_pay
												 +status_cash+status_print+status_others+"</td></tr>");
							
										
						
							if(colorRow.compareTo(colorRow1)!=0) {colorRow = colorRow1;} else colorRow = colorRow2;
										
								data.append(row_telo[index]);
								index++;
										
								
							
											
												
											
								
								
								
//											switch (colorRow) {
//											case "<tr bgcolor='#00BFFF'>": colorRow = "<tr bgcolor='#CDC9C9'>"; break;
//											case "<tr bgcolor='#CDC9C9'>": colorRow = "<tr bgcolor='#00BFFF'>"; break;																					
//											}
											
											
											
								}				
		}		
		SendMail sendmail = new SendMail();
		
	
		
		
		sendmail.open_socket();
		
		

		
		sendmail.resiv_mail("<table>"
							+ data
							+"</table>"
							+"<font style='Italic' size='3' color='blue' face='Arial'><em>created by PD for " +SendMail.name + " on " + SendMail.distr + "</em></font>", mailto);						
	}
	
//***************************************************************************************************	
	public void data_for_send_mails () throws IOException{
		
		SendMail sendmail = new SendMail();
		BD_write bdw = new BD_write();
		//Gui1 gui1 = new Gui1();
		
		
		
	

    	
		
		
		if (Experr.distr.contains("ВСЕ") == false) {//****если выбран какой то отдельный маршрут
			bdw.reqest_for_posting(" where name_distr = '" + Experr.distr + "'");//****запрос селект только одного марщрута
								distr = Experr.distr;
								String mailto = bdw.getMailtoAt(0,2);
								name = bdw.getMailtoAt(0,1);
								
								
							
								
									sendmail.engin_mail(mailto,distr);
			
		}
	
		
		
		if (Experr.distr.contains("ВСЕ") == true) {//*****если отдельный маршрут не выбран*******
						bdw.reqest_for_posting("");//запрос селект без условий ( все маршруты)
					    	for (int i = 0; i < bdw.getRowMail(); i++) {
								
								
								distr = bdw.getMailtoAt(i,0);
								String mailto = bdw.getMailtoAt(i,2);
								name = bdw.getMailtoAt(i,1);
									sendmail.engin_mail(mailto,distr);
								
							}
		}
		
		
	}
	


}
