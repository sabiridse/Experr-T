package Osmp_Osmp;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Service {
	
	Row rows_in_first_file;
	Row rows_in_second_file;
	Sheet sheet;

	
	public void two_in_one() throws IOException {
		
		FileOperation fileOp = new FileOperation();
		sheet = fileOp.OpenFile("terminal_monitoring.xls");
		rows_in_first_file = sheet.getRow(fileOp.getRows_in_osmp_import()-1);		
		sheet.removeMergedRegion(1);
		
		System.out.println(sheet.getNumMergedRegions());
		
		
		FileOperation fileOp1 = new FileOperation();	
		rows_in_second_file = fileOp1.OpenFile("terminal_monitoring (1).xls").getRow(fileOp1.getRows_in_osmp_import()-1);
		
		

		fileOp.SaveFile();
		
	}
	
}
