import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SummInkass {

	String dir = System.getProperty("user.home");
	
	static Sheet sheet_osmp_import;
	static Row row;
	static int rows_in_osmp_import; 
	public static String Number_terminal,
						string_whis_numberOfterminal,
						string_whith_summ,
						Summ_in_term;
	public	static ArrayList<String []> Summ_inkass = new ArrayList<String []>();
	
	public void osmp() throws IOException{
		
		rows_in_osmp_import = -1;
		
		
		FileInputStream Osmp_import = new FileInputStream(dir + "\\Downloads\\terminal_monitoring.xls");
		Workbook wb_osmp_import = new HSSFWorkbook(Osmp_import);
		sheet_osmp_import = wb_osmp_import.getSheetAt(0);
		
			Iterator<Row> iterator_osmp_import = sheet_osmp_import.iterator();
	        while (iterator_osmp_import.hasNext()) {
	            iterator_osmp_import.next();
	            rows_in_osmp_import++;        // эта переменная и будет кол-вом строк после полного цикла
	        }
        
	   for ( int i = 1; i < rows_in_osmp_import ; i++) {   
	    	 
		  row = sheet_osmp_import.getRow(i);  //текущая строка i - от 2 до конца

			
			//******************вычисляю НОМЕР ТЕРМИНАЛА из строки в ячейке D i***********************************************************
		  string_whis_numberOfterminal = row.getCell(3).getStringCellValue();//значение ячейки D в строке i (текущая в цикле_)
		  Number_terminal = string_whis_numberOfterminal.substring(0, 8);    //вырезаю из значения  первые 8 символов - получаю номер терема 
	    	 
		  string_whith_summ = row.getCell(4).getStringCellValue();//сумма наличных в терминале, но 33545.00 неформат
			
		  Summ_in_term = string_whith_summ.substring(0, string_whith_summ.indexOf(","));
	    	 
	    	 
	   }  
        
	}
	
	public void lider(){
			
			
			
			
		}
	public void dps(){
		
		
		
		
	}
	
	
	
}
