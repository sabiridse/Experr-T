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
	private Workbook curientWB_open;
		
	
			public void setRows_in_osmp_import(int rows_in_osmp_import) {
				this.rows_in_osmp_import = rows_in_osmp_import;
			}
		
			public int getRows_in_osmp_import() {
				return rows_in_osmp_import;
			}
		
			
			public String getDir() {
				return System.getProperty("user.home")+"\\Downloads\\";
			}
			
			public Workbook getCurientWB_open() {
				return curientWB_open;
			}
			
			public Sheet OpenFile(String file_name) throws IOException{								
				Osmp_import = new FileInputStream(this.getDir()+file_name);
				curientWB_open = new HSSFWorkbook(Osmp_import);
				Sheet sheet_osmp_import = curientWB_open.getSheetAt(0);
				  		
				//******вычисляю кол-во нормальных строк ( последняя "ВСЕ" объеденённая не нужна) в terminal_monitoring
				Iterator<Row> iterator_osmp_import = sheet_osmp_import.iterator();
			        while (iterator_osmp_import.hasNext()) {
			            iterator_osmp_import.next();
			            rows_in_osmp_import++;        // эта переменная и будет кол-вом строк после полного цикла
			        }
							        
			        return sheet_osmp_import;
			        
			}
			
			
			public void SaveFile(Workbook curientWB, String curientFileName) throws IOException{
				
				FileOutputStream out = new FileOutputStream(new File(this.getDir()+curientFileName));
				curientWB.write(out);
				out.close();
			}
			
			public void DeleteFiles(String fileName){
				
				new File(this.getDir()+fileName).delete();
				
			}

			

			
}
