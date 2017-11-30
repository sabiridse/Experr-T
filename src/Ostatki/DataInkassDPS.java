package Ostatki;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Osmp_Osmp.FileOperation;
import all_classes.BD_write;
import services.TurnDataTimeInkass;

public class DataInkassDPS {

	private int rows_in_PPS = 0;
	private XSSFSheet sheetPPS;
	private JFileChooser fileopen;
	
	@SuppressWarnings("resource")
	private XSSFSheet openPPSreportsInkass() throws FileNotFoundException, IOException{

		String dir = new FileOperation().getDir();				
					 fileopen = new JFileChooser(dir);
					 fileopen.setFileFilter(new FileNameExtensionFilter("xlsx","xlsx"));
					 fileopen.showDialog(null, "Выбрать файл");
		sheetPPS = new XSSFWorkbook(new FileInputStream(dir + fileopen.getSelectedFile().getName()))
					.getSheet("Данные");
		
		Iterator<Row> iterator_PPS = sheetPPS.iterator();
        while (iterator_PPS.hasNext()) {
        	iterator_PPS.next();
            rows_in_PPS ++;        // эта переменная и будет кол-вом строк после полного цикла
        }
		//rows_in_PPS --;
		return sheetPPS;
	}
	
		private ArrayList<ArrayList<String>>  writeData(){
			
			TurnDataTimeInkass tdti = new TurnDataTimeInkass();
			
			
			ArrayList<ArrayList<String>> inkassCollection = new ArrayList<>();
			
			for (int i = 3; i < rows_in_PPS; i++){
					ArrayList<String> row = new ArrayList<>();
					String id_term = Integer.toString((int) sheetPPS.getRow(i).getCell(0).getNumericCellValue());
					String last_inkass_data = tdti.turningString(sheetPPS.getRow(i).getCell(1).getStringCellValue());
					row.add(id_term);
					row.add(last_inkass_data);
					inkassCollection.add(row);
			}
			
		return inkassCollection;	
		}
		
		private String addQuery (String id_term, String last_inkass_data){
			
			String query = "update ostatki set last_inkass_data = '"
						  + last_inkass_data
						  + "' where id_term = "
						  + id_term;			
			return query;
		}
		
		public void getLastInkassDpsAndWriteInOstatki(){
			BD_write bdw = new BD_write();
			bdw.connect();			
			try {
				this.openPPSreportsInkass();
			} catch (IOException e) {
				e.printStackTrace();
			}
				for(ArrayList<String> row:this.writeData()){
					try {
						bdw.uni_reqest_in_db(this.addQuery(row.get(0), row.get(1)));
					} catch (SQLException e) {
	
						e.printStackTrace();
					}
					
				}
		fileopen.getSelectedFile().delete();	
			
		}
		
		
		
		
		
		
		
		
		
		
}
