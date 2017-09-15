package Osmp_Osmp;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import all_classes.Gui1;

public class Service {
	
	Row rows_in_first_file;//10278276
	Row rows_in_second_file;
	Sheet sheet;
	Sheet sheet1;
	FileOperation fileOp;
	FileOperation fileOp1;
	
	public void two_in_one() throws IOException {
		
		fileOp = new FileOperation();
		sheet = fileOp.OpenFile("terminal_monitoring.xls");//work sheet in file
		rows_in_first_file = sheet.getRow(fileOp.getRows_in_osmp_import()-1);//	last row
		sheet.removeMergedRegion(0);//delete merge columns
		sheet.removeRow(rows_in_first_file);
		
		fileOp1 = new FileOperation();
		sheet1 = fileOp1.OpenFile("terminal_monitoring (1).xls");//work sheet in file
		rows_in_second_file = sheet1.getRow(fileOp1.getRows_in_osmp_import()-1);//last row
		
		
	   for ( int i = 1; i < fileOp1.getRows_in_osmp_import()-1; i++){
	    		 this.copyRow(i);  //copy rows osmp to osmp
	   }  
		
		fileOp.DeleteFiles("terminal_monitoring.xls");
		fileOp.DeleteFiles("terminal_monitoring (1).xls");
		fileOp.SaveFile(fileOp.getCurientWB_open(), "terminal_monitoring.xls");

		
	}
	
	private void copyRow(int i){
		
		Row row = sheet.createRow(fileOp.getRows_in_osmp_import()-2+i);
		
		for (int q =0; q<10; q++){
			row.createCell(q).setCellValue(sheet1.getRow(i).getCell(q).getStringCellValue());
		}
	
	}
	
	
}
