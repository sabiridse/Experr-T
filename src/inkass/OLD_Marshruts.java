package inkass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import all_classes.BD_write;

public class OLD_Marshruts {

	private XSSFWorkbook wb_Marshruts;
	private XSSFSheet sheet_11;
	
	
	public void run(){
		
		this.creatureWB();
		this.creatureFile();
		try {
			this.SaveFile(wb_Marshruts);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	
	private void creatureWB(){				
		wb_Marshruts = new XSSFWorkbook();
		sheet_11 = wb_Marshruts.createSheet("11");			
	}
	
	private void creatureFile(){
		
		  sheet_11.setColumnWidth(0,1520); 
	      sheet_11.setColumnWidth(1,7200);
	      sheet_11.setColumnWidth(2,3640);
	      sheet_11.setColumnWidth(3,11480);
	      sheet_11.setColumnWidth(4,4200);
	      sheet_11.setColumnWidth(5,2120);
	      sheet_11.setColumnWidth(6,1960); 
	      sheet_11.setColumnWidth(7,18720);
	      
		
	      sheet_11.addMergedRegion(new CellRangeAddress(
					  0, //first row (0-based)
					  0, //last row (0-based)
				      3, //first column (0-based)
				      6 //last column (0-based)
				      ));
	      sheet_11.setAutoFilter(CellRangeAddress.valueOf("A" +
	                String.valueOf(3) + ":I" +
	               String.valueOf(200)));//**********************************************переменная числа строк в таблице
	     
	      wb_Marshruts.setPrintArea(
	    	      0, //sheet index
	    	      1, //start column
	    	      7, //end column
	    	      0, //start row
	    	      20 //end row*********************************************************переменная числа строк в таблице
	    	      );
	      
		
		
			Font font1 = wb_Marshruts.createFont();
			font1.setFontName("ARIAL");
			font1.setColor((short) 0);
			font1.setFontHeightInPoints((short) 12);
				
				Font font2 = wb_Marshruts.createFont();
				font2.setFontName("ARIAL");
				font2.setBold(true);
				font2.setColor((short) 0);
				font2.setFontHeightInPoints((short) 12);
	      
			  CellStyle style1 = wb_Marshruts.createCellStyle();
		      style1.setAlignment(HorizontalAlignment.LEFT);
		      style1.setBorderBottom(BorderStyle.THIN);
		      style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		      style1.setBorderLeft(BorderStyle.THIN);
		      style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		      style1.setBorderRight(BorderStyle.THIN);
		      style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
		      style1.setBorderTop(BorderStyle.THIN);
		      style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
		      style1.setFont(font1);
		      style1.setAlignment(HorizontalAlignment.RIGHT);
		      style1.setVerticalAlignment(VerticalAlignment.CENTER);
				      
		      		  CellStyle style2 = wb_Marshruts.createCellStyle();
				      style2.setAlignment(HorizontalAlignment.LEFT);
				      style2.setBorderBottom(BorderStyle.THIN);
				      style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				      style2.setBorderLeft(BorderStyle.THIN);
				      style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
				      style2.setBorderRight(BorderStyle.THIN);
				      style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
				      style2.setBorderTop(BorderStyle.THIN);
				      style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
				      style2.setFont(font1);
				      style2.setWrapText(true);
				      style2.setAlignment(HorizontalAlignment.CENTER);
				      style2.setVerticalAlignment(VerticalAlignment.CENTER);
				      
						      CellStyle style3 = wb_Marshruts.createCellStyle();
						      style3.setAlignment(HorizontalAlignment.LEFT);
						      style3.setBorderBottom(BorderStyle.THIN);
						      style3.setBottomBorderColor(IndexedColors.BLACK.getIndex());
						      style3.setBorderLeft(BorderStyle.THIN);
						      style3.setLeftBorderColor(IndexedColors.BLACK.getIndex());
						      style3.setBorderRight(BorderStyle.THIN);
						      style3.setRightBorderColor(IndexedColors.BLACK.getIndex());
						      style3.setBorderTop(BorderStyle.THIN);
						      style3.setTopBorderColor(IndexedColors.BLACK.getIndex());
						      style3.setFont(font2);
						      style3.setAlignment(HorizontalAlignment.CENTER);
						      style3.setVerticalAlignment(VerticalAlignment.CENTER);
						      
								      CellStyle style4 = wb_Marshruts.createCellStyle();
								      style4.setBorderTop(BorderStyle.THIN);
								      style4.setBottomBorderColor(IndexedColors.BLACK.getIndex());
								      
										      CellStyle style5 = wb_Marshruts.createCellStyle();									      
										      style5.setFont(font2);
										      style5.setAlignment(HorizontalAlignment.LEFT);
										      style5.setVerticalAlignment(VerticalAlignment.CENTER);

		
		      
		      
		      
		      
		      Row row0 = sheet_11.createRow(0);
		      row0.setHeightInPoints(85);
		     
				      Cell cell01 = row0.createCell(1);
				      cell01.setCellStyle(style1);
				      cell01.setCellValue("Дата инкассации:");
				      	
				      	Cell cell02 = row0.createCell(2);
				      	cell02.setCellStyle(style1);
				      	cell02.setCellFormula("СЕГОДНЯ()+1");
					      	
				      		Cell cell03 = row0.createCell(3);
					      	cell03.setCellStyle(style2);
					      	cell03.setCellValue(" время выезда________________________                                                 "
								      		  + "время возвращения___________________                                                 "
								      		  + "комментарии_________________________");
						      	
					      		Cell cell07 = row0.createCell(7);
						      	cell07.setCellStyle(style3);
						      	cell07.setCellValue("Телефон мониторинга: 8-962-680-25-77");
				      	
		      Row row1 = sheet_11.createRow(1);
			  row1.setHeightInPoints(30);      	
				    
					  Cell cell11 = row1.createCell(1);
				      cell11.setCellStyle(style5);
				      cell11.setCellValue("Кассир-инкассатор");
				      
					      Cell cell13 = row1.createCell(3);
					      cell13.setCellStyle(style5);
					      cell13.setCellValue("Водитель");
					      
						      Cell cell14 = row1.createCell(4);
						      cell14.setCellStyle(style4);
						      Cell cell15 = row1.createCell(5);
						      cell15.setCellStyle(style4);
						      Cell cell16 = row1.createCell(6);
						      cell16.setCellStyle(style4);
					      
							      Cell cell17 = row1.createCell(7);
							      cell17.setCellStyle(style5);
							      cell17.setCellValue("Охранник");
				   
			 Row row2 = sheet_11.createRow(2);
			 row2.setHeightInPoints(54);    
	
				  Cell cell21 = row2.createCell(1);
			      cell21.setCellStyle(style3);
			      cell21.setCellValue("№11");//*************************************************переменная маршрута
			      
				      Cell cell22 = row2.createCell(2);
				      cell22.setCellStyle(style2);
				      cell22.setCellValue("Код точки");
			      
					      Cell cell23 = row2.createCell(3);
					      cell23.setCellStyle(style2);
					      cell23.setCellValue("Адрес");
			      
						      Cell cell24 = row2.createCell(4);
						      cell24.setCellStyle(style2);
						      cell24.setCellValue("Сумма");
			      
							      Cell cell25 = row2.createCell(5);
							      cell25.setCellStyle(style2);
							      cell25.setCellValue("Режим");
			      
								      Cell cell26 = row2.createCell(6);
								      cell26.setCellStyle(style2);
								      cell26.setCellValue("Приоритет");
			      
									      Cell cell27 = row2.createCell(7);
									      cell27.setCellStyle(style2);
									      cell27.setCellValue("Примечания");
			 
			 
			 
	}
	
	private void SaveFile(Workbook workbook) throws IOException{
		String dir = System.getProperty("user.home");
		FileOutputStream out = new FileOutputStream(new File(dir + "\\Downloads\\"+"МАРШРУТЫ.xlsx"));
		workbook.write(out);
		out.close();
	}
	
	
	
	
	
}
