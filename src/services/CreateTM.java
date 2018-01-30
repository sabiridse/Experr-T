package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateTM {//***если ОСМП больше не нужно, то делаю фиктивный файлик чтоб потом просто галкой можно вкл\выкл

	public void creature(){
		String dir = System.getProperty("user.home");			
		Workbook workbook_repo =new HSSFWorkbook();
		Sheet sheet_repo = workbook_repo.createSheet();
		FileOutputStream out;
		try {
			out = new FileOutputStream(new File(dir + "\\Downloads\\terminal_monitoring.xls"));
			workbook_repo.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
		}
	
}
