package Ostatki;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import all_classes.BD_write;

public class Ostatki {
	
	private HSSFWorkbook wb_ostatki;
	private HSSFSheet sheet_ostatki;
	private static ArrayList<List<Object>> NumberTermWhithSumm = new ArrayList <>();
	BD_write bdw = new BD_write();
//		public Ostatki() {
//			
//			NumberTermWhithSumm = new ArrayList <String []>();			
//		
//		}
	
	
			public void setValue(String numberTerm, String summ, String last_inkass_data){
				
				List<Object> Row = new ArrayList <>();
				Row.add(Integer.parseInt(numberTerm));
				Row.add((int) Double.parseDouble(summ.replaceAll(",",".")));
				Row.add(last_inkass_data);
				
			NumberTermWhithSumm.add(Row);//parse string 1238,00 in int 1238
			
			
			
			}
			
			public void creatureOstatki(){
				
				try {
					bdw.uni_reqest_in_db("DELETE FROM ostatki");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				this.creatureWBOstatki();
				
				for (int i = 0; i < NumberTermWhithSumm.size();i++){
					
					this.creatureRowOstatki(i);
					
				}
				
				try {
					this.SaveFileOstatki();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				NumberTermWhithSumm.clear();
				
			}
			
			
			
			
				private List<Object> getNumberTermWhithSumm(int index){
					
					return NumberTermWhithSumm.get(index);
				}
				
				private void creatureWBOstatki(){				
					wb_ostatki = new HSSFWorkbook();
					sheet_ostatki = wb_ostatki.createSheet("Лист1");			
				}
				
				private void creatureRowOstatki(int IndexArray){
				
					Row row = sheet_ostatki.createRow(IndexArray+1);
					
					int id_term = (int) this.getNumberTermWhithSumm(IndexArray).get(0);
					int summ = (int) this.getNumberTermWhithSumm(IndexArray).get(1);
					String last_inkass = (String) this.getNumberTermWhithSumm(IndexArray).get(2);
					
					row.createCell(0).setCellValue((double) id_term);				
					row.createCell(1).setCellValue((double) summ);	

					bdw.insertOstatki(Integer.toString(id_term), summ, last_inkass);
					
				}
				
				private void SaveFileOstatki() throws IOException{
					String dir = System.getProperty("user.home");
					FileOutputStream out = new FileOutputStream(new File(dir + "\\Downloads\\"+"остатки.xls"));
					wb_ostatki.write(out);
					out.close();
				}
				
}
