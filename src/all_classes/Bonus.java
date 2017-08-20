package all_classes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javenue.csv.Csv;

public class Bonus {
	
	
	int size_arr_bonus;
	String numb_term_bonus = "101483";//qq
			Row row;
			Cell cell0;
		 	static Sheet bpt_sheet;
		 	Workbook bonus_book;
		 	Sheet bonus_sheet;
			static int rows_in_bonus;


			public static ArrayList<String> number_term_bonus_arr;
		
		public void open_csv_bonus() throws IOException{
			
			BufferedReader br = new BufferedReader(new FileReader(Experr.directory_res + "bonus.csv"));

				String ln = "";
				
				
				number_term_bonus_arr = new ArrayList<String>();				

				Bonus bonus = new Bonus();

						bonus.read_bonus(br);	

		//**************цикл выполняется пока не наткнется на пустую строку******************************					
							
							while ((ln = bonus.numb_term_bonus) != null  ){//проверяю слкдующую строку ( или первую)
		//***************************************************************************						
							
								number_term_bonus_arr.add(bonus.numb_term_bonus);								
	
								
								//**************************************************************************					
								bonus.read_bonus(br);//получаю  в БУФЕР ( не значение , а потому может быть NULL без екзепшна ) следующую строку

							}
						
		}
			
			
		public void read_bonus(BufferedReader br) throws IOException{
	
			numb_term_bonus =  br.readLine();
					
		}
			
	
		
		
		
		
		public void close_bonus() throws IOException{
			
			FileOutputStream fos = new FileOutputStream(Experr.directory_res + "bonus.xls");
			bonus_book.write(fos);                                                               
			fos.close();
			
			
		}
		
}
