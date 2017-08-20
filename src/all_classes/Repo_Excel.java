package all_classes;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class Repo_Excel {
	
	
	public static String path = new File("").getAbsolutePath();
	
	@SuppressWarnings("deprecation")
	public void create_file_report() throws Exception{
		
		 Loging log = new Loging();
		 
		BD_write bdw = new BD_write();
		bdw.reqest_workers_for_repo();
		
		long curTime = System.currentTimeMillis();
		String date_repo = new SimpleDateFormat("dd MMMM yyyy").format(curTime-1000*60*60*24);
		String date_name_repo = new SimpleDateFormat("dd MM yy").format(curTime-1000*60*60*24);
		String dateMonth = new SimpleDateFormat("MMMM").format(curTime);
		
		String [] workers = new String[5];
		
		log.logtext("путь к болванке отчета " + path + "//res//bolvan.xls");
		
		FileInputStream report = new FileInputStream (path + "//res//bolvan.xls");
		Workbook workbook_repo = WorkbookFactory.create(report);
		Sheet sheet_repo = workbook_repo.getSheetAt(0);
		
		log.logtext("Начал делать отчёт ");
		
//		 HSSFWorkbook workbook_repo = new HSSFWorkbook();
//		 HSSFSheet sheet_repo = workbook_repo.createSheet("����� �� �����������");
		 
//		 sheet_repo.setColumnWidth(0, 2500);
//		 sheet_repo.setColumnWidth(1, 19000);
//		 sheet_repo.setColumnWidth(2, 5000);
//		 sheet_repo.setColumnWidth(3, 6000);
//		 sheet_repo.setColumnWidth(4, 4000);
//		 sheet_repo.setColumnWidth(5, 8000);
//*******************************************************************************
		 Font font1 = workbook_repo.createFont();
	      font1.setFontName("ARIAL");
	      font1.setBold(true);
	      font1.setColor((short) 0);
	      font1.setFontHeightInPoints((short) 11);
//**********************************************************************************
	      Font font2 = workbook_repo.createFont();
	      font2.setFontName("ARIAL");
	      font2.setBold(false);
	      font2.setColor((short) 0);
	      font2.setFontHeightInPoints((short) 10);
//**********************************************************************************	
	      Font font3 = workbook_repo.createFont();
	      font3.setFontName("ARIAL");
	      font3.setBold(true);
	      font3.setColor((short) 0);
	      font3.setFontHeightInPoints((short) 10);
	    //**********************************************************************************	      
	      CellStyle style1 = workbook_repo.createCellStyle();
	      style1.setAlignment(CellStyle.ALIGN_LEFT);
	      style1.setBorderBottom(CellStyle.BORDER_THIN);
	      style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	      style1.setBorderLeft(CellStyle.BORDER_THIN);
	      style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	      style1.setBorderRight(CellStyle.BORDER_THIN);
	      style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
	      style1.setBorderTop(CellStyle.BORDER_THIN);
	      style1.setTopBorderColor(IndexedColors.BLACK.getIndex());
	      style1.setFont(font2);
////*********************************************************************************	      
	      CellStyle style2 = workbook_repo.createCellStyle();
	      style2.setAlignment(CellStyle.ALIGN_LEFT);
	      style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	      style2.setBorderBottom(CellStyle.BORDER_THIN);
	      style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	      style2.setBorderLeft(CellStyle.BORDER_THIN);
	      style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	      style2.setBorderRight(CellStyle.BORDER_THIN);
	      style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
	      style2.setBorderTop(CellStyle.BORDER_THIN);
	      style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
	      style2.setFont(font2);
////***********************************************************************************	
//	        
	      CellStyle style3 = workbook_repo.createCellStyle();	      
	      style3.setAlignment(CellStyle.ALIGN_CENTER);
	      style3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	      style3.setBorderBottom(CellStyle.BORDER_THIN);
	      style3.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	      style3.setBorderLeft(CellStyle.BORDER_THIN);
	      style3.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	      style3.setBorderRight(CellStyle.BORDER_THIN);
	      style3.setRightBorderColor(IndexedColors.BLACK.getIndex());
	      style3.setBorderTop(CellStyle.BORDER_THIN);
	      style3.setTopBorderColor(IndexedColors.BLACK.getIndex());	      
	      style3.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
	      style3.setFont(font3);
	      style3.setWrapText(true);
////***********************************************************************************	
	      CellStyle style4 = workbook_repo.createCellStyle();	      
	      style4.setAlignment(CellStyle.ALIGN_CENTER);
	      style4.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	      style4.setFont(font1);
	      
//*****************************************��������� ������**********************************************	      
	     for (int i = 0; i <5; i++){
	      workers[i] = Arrays.toString(BD_write.workers_spb.get(i));      
	     }
	      
//	      sheet_repo.addMergedRegion(new CellRangeAddress(
//			      0, //first row (0-based)
//			      0, //last row (0-based)
//			      0, //first column (0-based)
//			      5 //last column (0-based)
//			      ));
//	      	Row row0 = sheet_repo.createRow(0);
//			 row0.setHeight((short) 500);
//		      Cell cell0 = row0.createCell(0);
//		      Cell cell1 = row0.createCell(1);
//		      Cell cell2 = row0.createCell(2);
//		      Cell cell3 = row0.createCell(3);
//		      Cell cell4 = row0.createCell(4);
//		      Cell cell5 = row0.createCell(5);	      
//		      cell0.setCellStyle(style4);
//		      cell1.setCellStyle(style4);
//		      cell2.setCellStyle(style4);
//		      cell3.setCellStyle(style4);
//		      cell4.setCellStyle(style4);
//		      cell5.setCellStyle(style4);
//		      
		      //cell0.setCellValue("���������� ��ר� �� �����������");
	      Row row1 = sheet_repo.createRow(2);
	      Cell cell11 = row1.createCell(1);
	      cell11.setCellValue("Старший смены: " + Experr.textField_SS_for_repo.getText());
	      Cell cell15 = row1.createCell(5);
	      cell15.setCellValue("Дата: " + date_repo);
	      Row row2 = sheet_repo.createRow(4);
	      Cell cell21 = row2.createCell(1);
	      cell21.setCellValue("Сотрудники Спб: "
	    		  +workers[0]+", "
	    		  +workers[1]+", "
	    		  +workers[2]+", "
	    		  +workers[3]+", "
	    		  +workers[4]);
//********************************************************************************************************	      
//	      
//	     sheet_repo.addMergedRegion(new CellRangeAddress(
//			      4, //first row (0-based)
//			      4, //last row (0-based)
//			      0, //first column (0-based)
//			      5 //last column (0-based)
//			      ));
//
//		 Row row4 = sheet_repo.createRow(4);
//		 row4.setHeight((short) 500);
//	      Cell cell40 = row4.createCell(0);
//	      Cell cell41 = row4.createCell(1);
//	      Cell cell42 = row4.createCell(2);
//	      Cell cell43 = row4.createCell(3);
//	      Cell cell44 = row4.createCell(4);
//	      Cell cell45 = row4.createCell(5);	      
//	      cell40.setCellStyle(style3);
//	      cell41.setCellStyle(style3);
//	      cell42.setCellStyle(style3);
//	      cell43.setCellStyle(style3);
//	      cell44.setCellStyle(style3);
//	      cell45.setCellStyle(style3);
//	      
//	      cell40.setCellValue("������������� �����-���������");
//**********************************************************************************************	    
	      log.logtext("Задал стили и шапку. "); 		 
		 	
//**************************************************************************************************************	        
//*****����� ������ �� ���*****	        
		 for (int i = 0; i < BD_write.List_spb.size(); i++){
		 
			 Row row6 = sheet_repo.createRow(i+9);//������� � 9 ������� �����			 
			 String [] rows = BD_write.List_spb.get(i);
			 
			 	Cell cell60 = row6.createCell(0);
			 	Cell cell61 = row6.createCell(1);
			 	Cell cell62 = row6.createCell(2);
			 	Cell cell63 = row6.createCell(3);
			 	Cell cell64 = row6.createCell(4);
			 	Cell cell65 = row6.createCell(5);
			 	cell60.setCellStyle(style2);
			 	cell61.setCellStyle(style1);
			 	cell62.setCellStyle(style2);
			 	cell63.setCellStyle(style2);
			 	cell64.setCellStyle(style2);
			 	cell65.setCellStyle(style2);
			 	cell60.setCellValue(rows[0]);
			 	cell61.setCellValue(rows[1]);
			 	cell62.setCellValue(rows[2]);
			 	cell63.setCellValue(rows[3]);
			 	cell64.setCellValue(rows[4]);
			 	cell65.setCellValue(rows[5]);
			 
			 
		 }
		 
		 
//		 Row row_del = sheet_repo.createRow(54);
//		 sheet_repo.removeRow(row_del);
//		 
		 
		
		 
		// sheet_repo.shiftRows(50,54,300); 	 
//		 for (int q = BD_write.List_spb.size()+9; q <55; q++){
//		 
//				 Row row_del = sheet_repo.createRow(54);
//				 this.DeleteRow(sheet_repo, row_del);
//		 }
		 
		 //******************************************		 
//			for( int q =9; q < 56; q++){
//					 sheet_repo.removeRowBreak(BD_write.List_spb.size()+q);
//					 
//					 
//			}
//*********************************************
		 
		 log.logtext("Вписал по СПб. ");
		 
		 
			//****************************************************************************************************************		 
		 sheet_repo.addMergedRegion(new CellRangeAddress(
				 BD_write.List_spb.size()+9, //first row (0-based)
				 BD_write.List_spb.size()+9, //last row (0-based)
			      0, //first column (0-based)
			      5 //last column (0-based)
			      ));

		 Row row_lo = sheet_repo.createRow(BD_write.List_spb.size()+9);
		 row_lo.setHeight((short) 400);
	      Cell celllo0 = row_lo.createCell(0);
	      Cell celllo1 = row_lo.createCell(1);
	      Cell celllo2 = row_lo.createCell(2);
	      Cell celllo3 = row_lo.createCell(3);
	      Cell celllo4 = row_lo.createCell(4);
	      Cell celllo5 = row_lo.createCell(5);	      
	      celllo0.setCellStyle(style4);
	      celllo1.setCellStyle(style4);
	      celllo2.setCellStyle(style4);
	      celllo3.setCellStyle(style4);
	      celllo4.setCellStyle(style4);
	      celllo5.setCellStyle(style4);
	      
	     celllo0.setCellValue("Неисправности Ленинградская область:");
//*************************************************************************************************************	
	     Row row5 = sheet_repo.createRow(BD_write.List_spb.size()+10);
		 	row5.setHeight((short) 600);
		 	Cell cell50 = row5.createCell(0);
		 	Cell cell51 = row5.createCell(1);
		 	Cell cell52 = row5.createCell(2);
		 	Cell cell53 = row5.createCell(3);
		 	Cell cell54 = row5.createCell(4);
		 	Cell cell55 = row5.createCell(5);
		 	cell50.setCellStyle(style3);
		 	cell51.setCellStyle(style3);
		 	cell52.setCellStyle(style3);
		 	cell53.setCellStyle(style3);
		 	cell54.setCellStyle(style3);
		 	cell55.setCellStyle(style3);
		 	cell50.setCellValue("№");
		 	cell51.setCellValue("Терминал");
		 	cell52.setCellValue("Время возникновения");
		 	cell53.setCellValue("Ошибка");
		 	cell54.setCellValue("Сотрудник");
		 	cell55.setCellValue("Комментарии");	 
 //*************************************************************************************************************		        
	      for (int i = 0; i < BD_write.List_lo.size(); i++){
	 		 
				 Row row_for_lo = sheet_repo.createRow(i+BD_write.List_spb.size()+11);			 
				 String [] rows_lo = BD_write.List_lo.get(i);
				 
				 	Cell cellforlo0 = row_for_lo.createCell(0);
				 	Cell cellforlo1 = row_for_lo.createCell(1);
				 	Cell cellforlo2 = row_for_lo.createCell(2);
				 	Cell cellforlo3 = row_for_lo.createCell(3);
				 	Cell cellforlo4 = row_for_lo.createCell(4);
				 	Cell cellforlo5 = row_for_lo.createCell(5);
				 	cellforlo0.setCellStyle(style2);
				 	cellforlo1.setCellStyle(style1);
				 	cellforlo2.setCellStyle(style2);
				 	cellforlo3.setCellStyle(style2);
				 	cellforlo4.setCellStyle(style2);
				 	cellforlo5.setCellStyle(style2);
				 	cellforlo0.setCellValue(rows_lo[0]);
				 	cellforlo1.setCellValue(rows_lo[1]);
				 	cellforlo2.setCellValue(rows_lo[2]);
				 	cellforlo3.setCellValue(rows_lo[3]);
				 	cellforlo4.setCellValue(rows_lo[4]);
				 	cellforlo5.setCellValue(rows_lo[5]);
				 
				 
			 }
	      //sheet_repo.shiftRows(56,76, -5);
	      log.logtext("Вписал Ло. ");
	      
//***************************************************************************************************************	      
//********************************�������************************************************************************		 
			 sheet_repo.addMergedRegion(new CellRangeAddress(
					 BD_write.List_spb.size()+BD_write.List_lo.size()+11, //first row (0-based)
					 BD_write.List_spb.size()+BD_write.List_lo.size()+11, //last row (0-based)
				      0, //first column (0-based)
				      5 //last column (0-based)
				      ));

			
			 
			 Row row_reg = sheet_repo.createRow(BD_write.List_spb.size()+BD_write.List_lo.size()+11);
			 row_reg.setHeight((short) 400);
		      Cell cellreg0 = row_reg.createCell(0);
		      Cell cellreg1 = row_reg.createCell(1);
		      Cell cellreg2 = row_reg.createCell(2);
		      Cell cellreg3 = row_reg.createCell(3);
		      Cell cellreg4 = row_reg.createCell(4);
		      Cell cellreg5 = row_reg.createCell(5);	      
		      cellreg0.setCellStyle(style4);
		      cellreg1.setCellStyle(style4);
		      cellreg2.setCellStyle(style4);
		      cellreg3.setCellStyle(style4);
		      cellreg4.setCellStyle(style4);
		      cellreg5.setCellStyle(style4);
		      
		      cellreg0.setCellValue("Неисправности Регионы:");
		    //*************************************************************************************************************	
		    Row row7 = sheet_repo.createRow(BD_write.List_spb.size()+BD_write.List_lo.size()+12);
		    row7.setHeight((short) 600);
		    Cell cell70 = row7.createCell(0);
		    Cell cell71 = row7.createCell(1);
		    Cell cell72 = row7.createCell(2);
		    Cell cell73 = row7.createCell(3);
		    Cell cell74 = row7.createCell(4);
		    Cell cell75 = row7.createCell(5);
		    cell70.setCellStyle(style3);
		    cell71.setCellStyle(style3);
		    cell72.setCellStyle(style3);
		    cell73.setCellStyle(style3);
		    cell74.setCellStyle(style3);
		    cell75.setCellStyle(style3);
		    cell70.setCellValue("№");
		    cell71.setCellValue("Терминал");
		    cell72.setCellValue("Время возникновения");
		    cell73.setCellValue("Ошибка");
		    cell74.setCellValue("Сотрудник");
		    cell75.setCellValue("Комментарии");
		      
//************************************************************************************		      
		      for (int i = 0; i < BD_write.List_reg.size(); i++){
		 		 
					 Row row_for_reg = sheet_repo.createRow(i+BD_write.List_spb.size()+BD_write.List_lo.size()+13);			 
					 String [] rows_reg = BD_write.List_reg.get(i);
					 
					 	Cell cellforreg0 = row_for_reg.createCell(0);
					 	Cell cellforreg1 = row_for_reg.createCell(1);
					 	Cell cellforreg2 = row_for_reg.createCell(2);
					 	Cell cellforreg3 = row_for_reg.createCell(3);
					 	Cell cellforreg4 = row_for_reg.createCell(4);
					 	Cell cellforreg5 = row_for_reg.createCell(5);
					 	cellforreg0.setCellStyle(style2);
					 	cellforreg1.setCellStyle(style1);
					 	cellforreg2.setCellStyle(style2);
					 	cellforreg3.setCellStyle(style2);
					 	cellforreg4.setCellStyle(style2);
					 	cellforreg5.setCellStyle(style2);
					 	cellforreg0.setCellValue(rows_reg[0]);
					 	cellforreg1.setCellValue(rows_reg[1]);
					 	cellforreg2.setCellValue(rows_reg[2]);
					 	cellforreg3.setCellValue(rows_reg[3]);
					 	cellforreg4.setCellValue(rows_reg[4]);
					 	cellforreg5.setCellValue(rows_reg[5]);
					 
					 
				 }
		     
		     // sheet_repo.shiftRows(56,56+BD_write.List_lo.size()+2,-(56-(BD_write.List_spb.size()+9)));
		      
		      log.logtext("Вписал Регионы. ");
	
		      workbook_repo.setPrintArea(
		    	      0, //sheet index
		    	      0, //start column
		    	      5, //end column
		    	      0, //start row
		    	      BD_write.List_spb.size()+BD_write.List_lo.size()+BD_write.List_reg.size()+12 //end row
		    	      );
		      //sheet_repo.removeRow(row_del);  
		      
		      
		      
		      
		      Xml_read xml = new Xml_read();
		     
				log.logtext("Сохраняю отчёт мониторинга. ");
				
				
		      	      
		 try (FileOutputStream out = new FileOutputStream(new File(Experr.textField_Path_report.getText()
				 										+ "/Отчет отдела мониторинга за " + date_name_repo + ".xls"))) {
	            workbook_repo.write(out);
	            log.logtext("Успешно сохранил.");   
	        } catch (IOException e) {

				log.log(e,"Ошибка сохранения: ");
	        }
		
		 BD_write.List_spb.clear();
		 BD_write.List_lo.clear();
		 BD_write.List_reg.clear();
	}

}
