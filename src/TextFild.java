import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TextFild {
	
	static Sheet bpt_sheet;
	String number_term_in_bpt,
	  find_number = "Не найден",
	   name_term_in_bpt = "Не найден";
	@SuppressWarnings("resource")
	
///********блин, это похоже еще старый поиск терминала в древней версии проги**********************	
	public void read(String find_number_terminal) throws IOException{
		
		//HSSFWorkbook bpt_book;
		
		Gui1 gui1 = new Gui1();
		
		int rows_in_bpt = 0;
		
		int nt_bpt,
			f_nt = 0;		
		
		try {
			f_nt = Integer.parseInt(find_number_terminal);//искомый номер терминалва в виде цифры
		} catch (NumberFormatException e) {
			String txt = "<html><center>Недопустимый ввод</html>";
			gui1.Gui0(txt);
		  }
		
		FileInputStream bpt_file = new FileInputStream(Experr.directory_res + "bpt.xls");
		Workbook bpt_book = new HSSFWorkbook(bpt_file);
		bpt_sheet = bpt_book.getSheetAt(0);
	
		Iterator<Row> iterator_bpt = bpt_sheet.iterator();
	        while (iterator_bpt.hasNext()) {
	            Row row_bpt = iterator_bpt.next();
	            rows_in_bpt++;        // эта переменная и будет кол-вом строк после полного цикла
	        }
		
	        for (int i = 0; i < rows_in_bpt; i++) {
	        	
	        Row	row = bpt_sheet.getRow(i);
	        
	        number_term_in_bpt= row.getCell(0).getStringCellValue(); //искомый номер
	        nt_bpt = Integer.parseInt(number_term_in_bpt);//////****в  виде цифры       
	        if (nt_bpt == f_nt){	        	
	        	name_term_in_bpt= row.getCell(1).getStringCellValue();//найденое имя		        
		        find_number = row.getCell(2).getStringCellValue();// найденый номер	       
	        }	        
	        }
	        
	}
//добавление нового терминала в таблицу терминалы*/**************************************************************	
	public void insert_term (String number_term, String name_term, String distr_term) throws Exception{
		
		Check_Double chdu = new Check_Double();// проверка номера терминала на дубликат в базе
		number_term = chdu.checking(number_term,"");
		
		
				try {
								int numterm = Integer.parseInt(number_term);//искомый номер терминалва в виде цифры
								BD_write bdw = new BD_write();
								int [] groups = bdw.reqest_in_distrs (distr_term);
								
				String query = "insert into terminals (id_term, name_term, name_distr, SpbLo, Spb, Lo, Regions, other, except_term) "
							  +"values (" + number_term  + ", '" + name_term  + "', '" + distr_term 
							  +"', " + groups[0] + "," + groups[1] + "," + groups[2] + "," + groups[3]  + ",'новая установка'"+ ",0)";
								
	
								bdw.insert_new_term(query);

				
				} catch (NumberFormatException e) {
								String txt = "<html><center>Недопустимый ввод номера терминала</html>";
								Gui1 gui1 = new Gui1();
								gui1.Gui0(txt);
				  }		
	}
//*************************************************************************************************
//добавление терминала в исключения**************************************************************	
				public void insert_term_exception (String number_term, String name_exception) throws Exception{
					
					Check_Double chdu = new Check_Double();// проверка номера терминала на дубликат в базе
					number_term = chdu.checking(number_term," where except_term = 1");
					
					
							try {
											int numterm = Integer.parseInt(number_term);//искомый номер терминалва в виде цифры
											BD_write bdw = new BD_write();
						
											
							String query = "update terminals set except_name = '" + name_exception + "'"
										 +" where id_term = " + number_term;
											

											bdw.insert_new_term(query);
		
											if (name_exception.compareTo("") != 0) {
										String query1 = "update terminals set except_term = 1 where id_term = " + number_term;
										String query2 = "update terminals set time_except = '" 
												+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())
												+ "' where id_term = " + number_term;
										bdw.insert_new_term(query1);
										bdw.insert_new_term(query2);
														}
											
							
							} catch (NumberFormatException e) {
											String txt = "<html><center>Недопустимый ввод номера терминала</html>";
											Gui1 gui1 = new Gui1();
											gui1.Gui0(txt);
							  }		
				}
//********************************************************************************************************************			

//УДАЛЕНИЕ терминала из исключения*ПРОСТО СТАВЛЮ 0 В except_term*************************************************************	
				public void delete_term_exception (String number_term) throws Exception{
	
							try {
											int numterm = Integer.parseInt(number_term);//искомый номер терминалва в виде цифры
											BD_write bdw = new BD_write();											
											String query = "update terminals set except_term = 0 where id_term = " + number_term;											
											bdw.insert_new_term(query);														
							} catch (NumberFormatException e) {
											String txt = "<html><center>Недопустимый ввод номера терминала</html>";
											Gui1 gui1 = new Gui1();
											gui1.Gui0(txt);
							}		
				}
//********************************************************************************************************************	
				
	//поиск номера терминала в таблице терминалы********************************************************************	
							public void find_term_in_terminals (String number_term) throws Exception{
										
										try {
														int numterm = Integer.parseInt(number_term);//искомый номер терминалва в виде цифры
														BD_write bdw = new BD_write();
													
														
										String query = "select id_term, name_term, name_distr from terminals "
												+"where id_term like '%" + number_term + "%' "
												+"union "
												+"select id_term, name_term, name_distr from terminals "
												+"where name_term like '%" + number_term + "%'";
														
														
														bdw.reqest_in_terminals(query);
								
										
										} catch (NumberFormatException e) {
														String txt = "<html><center>Недопустимый ввод номера терминала</html>";
														Gui1 gui1 = new Gui1();
														gui1.Gui0(txt);
										  }		
							}
	

}