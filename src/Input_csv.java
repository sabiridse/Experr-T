import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javenue.csv.Csv;

public class Input_csv {
	
		public static String dir = System.getProperty("user.home");

		
		public	ArrayList<String> number_term_errors_arr= new ArrayList<String>();
		
		String input_data,
		string_whis_numberOfterminal,
			   output_data;
		
		static Row row_ex;
		static Cell cell00;

		static Sheet sheet_Pir_ex,
					 sheet_Pir_imp,
					 sheet_poi_inf;
		
		public static  BD_write bdw = new BD_write();
	
	
	public void write_array (String number_term) throws Exception {
	
		int except_term = bdw.get_except_term(number_term);//***������� ������ ���������� ������
	
		if (except_term == 0){
		
				String time_lost_term = bdw.get_MAX_time_lost_term(number_term);//***������� �������� ����� ������� ���������� ������		
				bdw.inser_table_error33(number_term, 
						time_lost_term, 
						time_lost_term, 
						"OK", 
						"OK", 
						"OK", 
						OSMP.curientStringDateTame);	
		}
	}
		
	
	public void writePir(String file) throws Exception{
		
		
		int rows_in_points_info = 1;
		String number_terminal,
			   time_signal,
			   time_pay,
			   status_cash,
			   status_print;
		
		
		 OSMP osmp = new OSMP();
		 Magic_Osmp magic_osmp = new Magic_Osmp();
		
		FileInputStream points_info = new FileInputStream(file);//��� ������
		Workbook wb_poi_inf = new HSSFWorkbook(points_info);
		sheet_poi_inf = wb_poi_inf.getSheetAt(0);
	
		Iterator<Row> iterator_points_info = sheet_poi_inf.iterator();
        while (iterator_points_info.hasNext()) {
            Row row_poi_info = iterator_points_info.next();
            rows_in_points_info++;        // ��� ���������� � ����� ���-��� ����� ����� ������� �����
        }
		

        
		for (int i = 1; i < rows_in_points_info-1; i++) {
	
					Row row_imp = sheet_poi_inf.getRow(i);//������ ��� ������		
					
					
								try {	
										number_terminal = row_imp.getCell(0).getStringCellValue();//����� ������ �� ������
										
//*****************************************************************************************************										
										number_term_errors_arr.add(number_terminal);	//���� � ������			
//*****************************************************************************************************								
								
								} catch (NullPointerException e) {number_terminal = "";}
	
				
		//***************************************************************************************************	
								try {
									
									time_signal = row_imp.getCell(1).getStringCellValue();//����� ������ �� ������
								
								} catch (NullPointerException e) {time_signal = "01.11.2016 12:00";}		
				
		    //*************************************************************************************************		
								try {
									
									time_pay = row_imp.getCell(2).getStringCellValue();//����� ������ �� ������
								
								} catch (NullPointerException e) {time_pay = "01.11.2016 12:00";}
			//****************************************************************************************************					
								try {
									
									status_cash = row_imp.getCell(3).getStringCellValue();//����� ������ �� ������
								} catch (NullPointerException e) {status_cash = "";}
									
								try {	
									
									status_print = row_imp.getCell(4).getStringCellValue();//����� ������ �� ������
			
								} catch (NullPointerException e) {status_print = "";}	
								

								
								
								time_signal = magic_osmp.getTime_to_time(time_signal);
								time_pay = magic_osmp.getTime_to_time(time_pay);
								
								
								
								bdw.inser_table_error33(number_terminal, 
														time_signal, 
														time_pay, 
														status_cash, 
														status_print, 
														"OK", 
					    								OSMP.curientStringDateTame);					
																		
		}	
	
		
	}
	
	
	
}
