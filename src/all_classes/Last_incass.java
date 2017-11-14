package all_classes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Last_incass {
	
	
	public void creature_array_incass ( String term, String time_incass) throws ClassNotFoundException {
		
		long curTime = System.currentTimeMillis();
		String curient_date = new SimpleDateFormat("dd.MM.yyyy").format(curTime);		
		String date_inkass = time_incass.substring(0, 10);
		String time_inkass = time_incass.substring(11, 16);
		int hourse_inkass = Integer.parseInt(time_incass.substring(11, 13));
		
//				if (date_inkass.compareTo(curient_date) == 0) {//*****нужны только сегодняшние инкассации
//					
//					if (hourse_inkass > 13){//***нужны инкассации после обеда
					
						BD_write bdw = new BD_write();
						bdw.insert_curient_inkass(term, time_inkass);

//					}
//		
//				}
	}
	
	public String getInkass(int rowIndex, int columnIndex) {

		String [] rows = BD_write.Last_inkass_Arr.get(rowIndex);		
        return rows[columnIndex];
	
	}
	
	
	public void output_inkass()  {
		try{
			FileInputStream	last_inkass = new FileInputStream(Experr.textField_last_inkass.getText() + "/ПоследняяИнкассация.xls");

		
		Workbook inkass = new HSSFWorkbook(last_inkass);
		Sheet sheet_li = inkass.getSheetAt(1);
		
		
//		HSSFWorkbook workbook_last_inkass = new HSSFWorkbook();
//		 HSSFSheet sheet_li = workbook_last_inkass.createSheet("инкассации");
		 Row row1 = sheet_li.createRow(1);
		
		 	for (int i = 0; i < BD_write.Last_inkass_Arr.size(); i++){
		 	
		 		if(this.getInkass(i, 0)!=null){
		 		
			 		switch(this.getInkass(i, 0)) {
			 		
			 				case "" :break;
					 		case "1" : Cell cell1 = row1.createCell(1);
					 				 	cell1.setCellValue(this.getInkass(i, 1)); break;
					 		
					 		case "5" : Cell cell5 = row1.createCell(2);
					 					cell5.setCellValue(this.getInkass(i, 1)); break;
							 
					 		case "6" : Cell cell6 = row1.createCell(3);
					 					cell6.setCellValue(this.getInkass(i, 1)); break;
							 
					 		case "4" : Cell cell4 = row1.createCell(4);
					 					cell4.setCellValue(this.getInkass(i, 1)); break;
							 
					 		case "8" : Cell cell8 = row1.createCell(5);
					 					cell8.setCellValue(this.getInkass(i, 1)); break;
							 
					 		case "9" : Cell cell9 = row1.createCell(6);
					 					cell9.setCellValue(this.getInkass(i, 1)); break;
							 
					 		case "4А" : Cell cell4a = row1.createCell(7);
					 					cell4a.setCellValue(this.getInkass(i, 1)); break;
							 
					 		case "8А" : Cell cell8a = row1.createCell(8);
					 					cell8a.setCellValue(this.getInkass(i, 1)); break;
							 
					 		case "9А" : Cell cell9a = row1.createCell(9);
					 					cell9a.setCellValue(this.getInkass(i, 1)); break;					 			 		
			 		}
		 		}
		 	}
		 
		 			try{
					 	FileOutputStream fos = new FileOutputStream(Experr.textField_last_inkass.getText() + "/ПоследняяИнкассация.xls");
					 	inkass.write(fos);                                                               
						fos.close();
				}	catch (Exception e)	{Loging log = new Loging();
				 log.log(e," Сохраняю инкассации: ");}
		 
		}	catch (Exception e)	{Loging log = new Loging();
		 log.log(e," Открываю инкассации: ");} 
		 
		 
	}
	
	
	
	
}
