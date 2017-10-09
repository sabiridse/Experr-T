package inkass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Marshruts {

	private FileInputStream Marshruts;
	private Workbook curientWB_open;
	private Sheet curientSheet;
		

		private void setCurientSheet(int index) {
			curientSheet = curientWB_open.getSheetAt(index);

		}

			private String getDir() {
				return System.getProperty("user.home")+"\\Downloads\\";//*********потом поменять на папку ресурсов
			}
		
				private void OpenFile() throws IOException{								
					Marshruts = new FileInputStream(this.getDir()+"МАРШРУТЫ_болван.xlsx");
					curientWB_open = new XSSFWorkbook(Marshruts);
								   	        
				}
		
		
					private void SaveFile() throws IOException{
						
						FileOutputStream out = new FileOutputStream(new File(this.getDir()+"МАРШРУТЫ.xlsx"));
						curientWB_open.write(out);
						out.close();
					}
	
	
	public void write(){
		
		try {
			this.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		
			
		      
		    this.setCurientSheet(1);
		    
		    //System.out.println("Лист "+curientSheet.getSheetName());
		      
			curientSheet.getRow(3).getCell(1).setCellValue("Полушка");
			curientSheet.getRow(3).getCell(2).setCellValue(10273315);
			curientSheet.getRow(3).getCell(3).setCellValue("Гражданский пр 73");
			curientSheet.getRow(3).getCell(5).setCellValue("24ч");
			curientSheet.getRow(3).getCell(5).setCellStyle(this.lightCK());
			
			curientSheet.getRow(4).getCell(1).setCellValue("Продукты");
			curientSheet.getRow(4).getCell(2).setCellValue(10279229);
			curientSheet.getRow(4).getCell(3).setCellValue("Ушинского ул 36");
			curientSheet.getRow(4).getCell(5).setCellValue("10-20");
			

			this.finisherSheet(1, 2);
			
			
			this.setCurientSheet(2);
			

			
			curientSheet.getRow(3).getCell(1).setCellValue("Пятерочка");
			curientSheet.getRow(3).getCell(2).setCellValue(10275102);
			curientSheet.getRow(3).getCell(3).setCellValue("Большевиков пр 18");
			curientSheet.getRow(3).getCell(5).setCellValue("9-22");
			
			
			curientSheet.getRow(4).getCell(1).setCellValue("Лента");
			curientSheet.getRow(4).getCell(2).setCellValue(10271817);
			curientSheet.getRow(4).getCell(3).setCellValue("Энергетиков пр 12");
			curientSheet.getRow(4).getCell(5).setCellValue("10-20");
			curientSheet.getRow(4).getCell(5).setCellStyle(this.lightCK());
			
			curientSheet.getRow(5).getCell(1).setCellValue("SPAR");
			curientSheet.getRow(5).getCell(2).setCellValue(10365118);
			curientSheet.getRow(5).getCell(3).setCellValue("Колотнай ул 18");
			curientSheet.getRow(5).getCell(5).setCellValue("8-21");
			
			
			this.finisherSheet(2, 3);
			
			try {
				this.SaveFile();
			} catch (IOException e) {
				e.printStackTrace();
			}					
								
			try {
				Marshruts.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
	}
	
	private void copyRow(int resourceRow, Row targetRow, int firstCell, int endCell){
		
		for (int i = firstCell; i < endCell+1; i++){
			targetRow.createCell(i);
			curientSheet.getRow(targetRow.getRowNum()).getCell(i).setCellStyle(curientSheet.getRow(resourceRow).getCell(i).getCellStyle());
			
				try{
					curientSheet.getRow(targetRow.getRowNum()).getCell(i).setCellValue(curientSheet.getRow(resourceRow).getCell(i).getStringCellValue());
				} catch(Exception e){
					curientSheet.getRow(targetRow.getRowNum()).getCell(i).setCellFormula(curientSheet.getRow(resourceRow).getCell(i).getCellFormula());
				}
		}			
	}
	
	private void finisherSheet(int indexSheet, int finalRow){

				finalRow = finalRow +3;
				curientSheet.removeRow(curientSheet.getRow(finalRow));
				curientSheet.removeRow(curientSheet.getRow(finalRow+1));
				curientSheet.removeRow(curientSheet.getRow(finalRow+2));
				curientSheet.removeRow(curientSheet.getRow(finalRow+3));
				curientSheet.removeRow(curientSheet.getRow(finalRow+4));
				
				
				
				Row row14 = curientSheet.createRow(finalRow+1);
				Row row15 = curientSheet.createRow(finalRow+2);
				Row row17 = curientSheet.createRow(finalRow+4);
				
				this.copyRow(304, row14, 3, 3);
				this.copyRow(305, row15, 3, 3);
				this.copyRow(307, row17, 1, 1);
				this.copyRow(307, row17, 5, 5);	
				
				
				for (int i = finalRow+5 ; i<308; i++){
					
					curientSheet.removeRow(curientSheet.getRow(i));	
					
				}
					
				
				curientWB_open.setPrintArea(
						indexSheet, //sheet index
			    	      1, //start column
			    	      11, //end column
			    	      0, //start row
			    	      finalRow+4 //end row*********************************************************переменная числа строк в таблице
			    	      );
		
	}
	
	private CellStyle lightCK(){
	
			//************************************************************************для выделения СК голубым****			
			Font font1 = curientWB_open.createFont();
			font1.setFontName("ARIAL");
			font1.setColor((short) 0);
			font1.setFontHeightInPoints((short) 14);
			
			CellStyle style1 = curientWB_open.createCellStyle();
		      style1.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		      style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		      style1.setFont(font1);
		      style1.setAlignment(HorizontalAlignment.CENTER);
		      style1.setVerticalAlignment(VerticalAlignment.CENTER);
		//***************************************************************************************************
		      
		    return style1;  
	}
}