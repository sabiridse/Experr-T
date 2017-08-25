package Lider_Dps;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Sheet;

import Osmp_Osmp.FileOperation;

public class Service {
	private Sheet sheetLid;
	private Sheet sheetPPS;
//*******************************************************************************************************************	
			private void openLiderAndPPS(){
				
				FileOperation fileOperationLid = new FileOperation();
				try {
					sheetLid = fileOperationLid.OpenFile("points_info.xls");
				} catch (IOException e) {			
					e.printStackTrace();
				}
				
				FileOperation fileOperationPPS = new FileOperation();
				try {
					sheetPPS = fileOperationPPS.OpenFile("Терминалы.xls");
				} catch (IOException e) {			
					e.printStackTrace();
				}
				
			}
	
//**********************************************************************************************************************
						private String getValue(Sheet sheet, int row, int cell){							
							
							try {
								return sheet.getRow(row).getCell(cell).getStringCellValue();
							} catch(Exception e) {			
								return Integer.toString((int)sheet.getRow(row).getCell(cell).getNumericCellValue());
							}							  														
						}
	
//************************************************************************************************************************	
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

							return new String("");
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
						
								public String curientDate(){
									
									long curTime = System.currentTimeMillis();
									String curientStringDateTame = new SimpleDateFormat("dd.MM").format(curTime);//просто текущее время
									return curientStringDateTame;
								}
//***********************************************************************************************************************************						
						
								public void testOutput(){
									
									this.openLiderAndPPS();
									
									System.out.println(this.getValue(sheetLid, 5, 0));	
									System.out.println(this.getValue(sheetLid, 5, 1));
									System.out.println(this.getValue(sheetLid, 5, 2));
									System.out.println(this.getValue(sheetLid, 5, 3));
									System.out.println(this.getValue(sheetLid, 5, 4));
									System.out.println(this.getValue(sheetLid, 5, 5));
									
									System.out.println(this.getValue(sheetPPS, 27, 0));
									System.out.println(this.trimDateTimePPS(this.getValue(sheetPPS, 27, 1)));
									System.out.println(this.trimDateTimePPS(this.getValue(sheetPPS, 27, 2)));
									System.out.println(this.getValue(sheetPPS, 27, 3));
									System.out.println(this.getValue(sheetPPS, 27, 4));
									System.out.println(this.getValue(sheetPPS, 27, 5));
									System.out.println(this.getValue(sheetPPS, 27, 6));
								}
}
