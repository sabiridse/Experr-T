package Ostatki;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class Ostatki {
	
	private HSSFWorkbook wb_ostatki;
	private HSSFSheet sheet_ostatki;
	private static ArrayList<int[]> NumberTermWhithSumm = new ArrayList <int []>();;
	
//		public Ostatki() {
//			
//			NumberTermWhithSumm = new ArrayList <String []>();			
//		
//		}
	
	
			public void setValue(String numberTerm, String summ){
		
			NumberTermWhithSumm.add(new int[]{Integer.parseInt(numberTerm)
					,(int) Double.parseDouble(summ.replaceAll(",","."))});
				
			}
			
			public void creatureOstatki(){
				
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
			
			
			
			
				private int[] getNumberTermWhithSumm(int index){
					
					return NumberTermWhithSumm.get(index);
				}
				
				private void creatureWBOstatki(){				
					wb_ostatki = new HSSFWorkbook();
					sheet_ostatki = wb_ostatki.createSheet("Лист1");			
				}
				
				private void creatureRowOstatki(int IndexArray){
				
					Row row = sheet_ostatki.createRow(IndexArray+1);	
	
					row.createCell(0).setCellValue(this.getNumberTermWhithSumm(IndexArray)[0]);				
					row.createCell(1).setCellValue(this.getNumberTermWhithSumm(IndexArray)[1]);							
				}
				
				private void SaveFileOstatki() throws IOException{
					String dir = System.getProperty("user.home");
					FileOutputStream out = new FileOutputStream(new File(dir + "\\Downloads\\"+"остатки.xls"));
					wb_ostatki.write(out);
					out.close();
				}
				
}
