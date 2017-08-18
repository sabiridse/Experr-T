package Osmp_Osmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FileOperation {
	private int rows_in_osmp_import = 0;
	private FileInputStream Osmp_import;
	private String dir;
	private Workbook wb_osmp_import;
		
	
			public void setRows_in_osmp_import(int rows_in_osmp_import) {
				this.rows_in_osmp_import = rows_in_osmp_import;
			}
		
			public int getRows_in_osmp_import() {
				return rows_in_osmp_import;
			}
		
			
			public Sheet OpenFile(String file_name) throws IOException{								
				dir = System.getProperty("user.home");//узнаю текущую попку даунлоадов*****************************
								
				Osmp_import = new FileInputStream(dir + "\\Downloads\\"+file_name);
				wb_osmp_import = new HSSFWorkbook(Osmp_import);
				Sheet sheet_osmp_import = wb_osmp_import.getSheetAt(0);
				  		
				//******вычисляю кол-во нормальных строк ( последняя "ВСЕ" объеденённая не нужна) в terminal_monitoring
				Iterator<Row> iterator_osmp_import = sheet_osmp_import.iterator();
			        while (iterator_osmp_import.hasNext()) {
			            iterator_osmp_import.next();
			            rows_in_osmp_import++;        // эта переменная и будет кол-вом строк после полного цикла
			        }
							        
			        return sheet_osmp_import;
			        
			}
			
			
			public void SaveFile() throws IOException{
				
				FileOutputStream out = new FileOutputStream(new File(dir + "\\Downloads\\"+"terminal_monitoring.xls"));
				wb_osmp_import.write(out);
			}
			
			public void DeleteFiles(){
				
				File terminal_monitoring = new File(dir + "\\Downloads\\terminal_monitoring.xls");
				File terminal_monitoring1 = new File(dir + "\\Downloads\\terminal_monitoring (1).xls");
				terminal_monitoring.delete();
				terminal_monitoring1.delete();
				
			}
	
}
