package Lider_Dps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Osmp_Osmp.FileOperation;

public class ServicePPS {
	private int rows_in_PPS = 0;
	private Sheet sheetLid;
	private XSSFSheet sheetPPS;
	private HSSFWorkbook wb_points_info;
	private HSSFSheet sheet_points_info;
	private JFileChooser fileopen;
		
//*******************************************************************************************************************	
			@SuppressWarnings("resource")
			private XSSFSheet openLiderAndPPS() throws FileNotFoundException, IOException{

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
				
				return sheetPPS;
			}
	
//**********************************************************************************************************************
		private String getValue(Sheet sheet, int row, int cell){							
							
			try {
				return this.checkBYzeroStatus(sheet.getRow(row).getCell(cell).getStringCellValue());
				} catch(Exception e) {			
		return this.checkBYzeroTime(Integer.toString((int)sheet.getRow(row).getCell(cell).getNumericCellValue()));
			}							  														
		}
	
//************************************************************************************************************************	
					private String checkBYzeroStatus(String valueCell){
						
						if (valueCell.compareTo("") == 0){
							valueCell = "OK";
						}
						return valueCell;
					}
//************************************************************************************************************************	
					private String checkBYzeroTime(String valueCell){
						
						if (valueCell.compareTo("") == 0){
							valueCell = "01.01 00:00";
						}
						return valueCell;
					}
//**********************************************************************************************************				
				private String trimDateTimePPS(String date_time){// INPUT 12.08.2017 9:32:11  OUTPUT  12.08 09:32
							
							String zero = "0";							
							char[] char_zero = zero.toCharArray();
							char[] char_date_time = date_time.toCharArray();
							
							switch (char_date_time.length){
								case 18: char[]subchar_date_time1 = {char_date_time[0],char_date_time[1],char_date_time[2],char_date_time[3],char_date_time[4],
										char_date_time[10],char_zero[0],char_date_time[11],char_date_time[12],char_date_time[13],char_date_time[14]};            //INPUT 12.08.2017 9:33:21

								return new String(this.checkDateToDay(subchar_date_time1));// before return checking on Today or No, if Today - 09:22 or No - 12.08 09:22
								
								
								case 19: char[]subchar_date_time2 = {char_date_time[0],char_date_time[1],char_date_time[2],char_date_time[3],char_date_time[4],
										char_date_time[10],char_date_time[11],char_date_time[12],char_date_time[13],char_date_time[14],char_date_time[15]};       //INPUT 12.08.2017 10:33:21

								return new String(this.checkDateToDay(subchar_date_time2));// before return checking on Today or No, if Today - 09:22 or No - 12.08 09:22
														
							}

							return new String("01.01 00:00");
						}
						
//******************************************************************************************************************************						
								private char[] checkDateToDay (char[] char_today){
									
										String currientDay = this.curientDate();
										char[] trim_char_today = {char_today[0],char_today[1],char_today[2],char_today[3],char_today[4]};
										String checkingDay = new String(trim_char_today);
										
												if (checkingDay.compareTo(currientDay) == 0){
													
													char [] result_char = {char_today[6],char_today[7],char_today[8],char_today[9],char_today[10]};
													
													return result_char;
												}
										
									return char_today;
								}
//********************************************************************************************************************************						
				private void CreatureFile(){
							
					wb_points_info = new HSSFWorkbook();
					sheet_points_info = wb_points_info.createSheet("Sheet1");
									
				}
								
//*****************************************************************************************************								
								
								private void SaveFile() throws IOException{
									String dir = System.getProperty("user.home");
									FileOutputStream out = new FileOutputStream(new File(dir + "\\Downloads\\"+"points_info.xls"));
									wb_points_info.write(out);
									out.close();
								}
								
//****************************************************************************************************								
								public String curientDate(){
									
									long curTime = System.currentTimeMillis();
									String curientStringDateTame = new SimpleDateFormat("dd.MM").format(curTime);//просто текущее время
									return curientStringDateTame;
								}
//***********************************************************************************************************************************						
			private void cretureRowPoints_info( XSSFSheet sheetPPS, int numberRowSource, int numberRowTarget){
				
				Row row = sheet_points_info.createRow(numberRowTarget);	

				row.createCell(0).setCellValue(this.getValue(sheetPPS, numberRowSource+2, 0));				
				row.createCell(1).setCellValue(this.trimDateTimePPS(this.getValue(sheetPPS, numberRowSource+2, 1)));					
				row.createCell(2).setCellValue(this.trimDateTimePPS(this.getValue(sheetPPS, numberRowSource+2, 2)));					
				row.createCell(3).setCellValue(this.getValue(sheetPPS, numberRowSource+2, 4));//cash and print change column				
				row.createCell(4).setCellValue(this.getValue(sheetPPS, numberRowSource+2, 3));//cash and print change column					
				row.createCell(5).setCellValue("OK");			
						
						
			}
								
//****************************************************************************************************								
				public void addPoints_info() throws FileNotFoundException, IOException{
					
					this.CreatureFile();
					
					XSSFSheet sheet_first_file = this.openLiderAndPPS();
						for (int q =1; q < rows_in_PPS-1; q++){
								this.cretureRowPoints_info(sheet_first_file, q, q);
						}
						
							fileopen.getSelectedFile().delete();
						
					int firstRowSecondFile = rows_in_PPS-1;
					XSSFSheet sheet_second_file = this.openLiderAndPPS();
						for (int i =firstRowSecondFile; i < rows_in_PPS-3; i++){
								this.cretureRowPoints_info(sheet_second_file, i-firstRowSecondFile+1, i);
						}
					
							fileopen.getSelectedFile().delete();
						
					try {
											this.SaveFile();
										} catch (IOException e) {
											e.printStackTrace();
										}
									
				}


}
