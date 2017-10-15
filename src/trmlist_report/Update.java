package trmlist_report;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Osmp_Osmp.FileOperation;
import all_classes.BD_write;
import all_classes.Experr;
import all_classes.Gui1;
import all_classes.NewThread_one;

public class Update {

	private Sheet sheet_repo;
	Gui1 gui1 = new Gui1();
	private FileInputStream repo;
	private Workbook curientWB_open;
	private List<String> id_term_inDB = new ArrayList<String>();
	BD_write bdw = new BD_write();
	
	public void insertTo(){
		
			this.openRepo();
			if (sheet_repo != null){
				
				long curTime1 = System.currentTimeMillis();
				System.out.println("начал");
				this.iteration();
				
				long curTime2 = System.currentTimeMillis();
				int result = (int) ((curTime2 - curTime1)/1000);
				System.out.println("закончил за "+result+ " секунд");
			}
			
				
		
	}
	
					private String getDir() {
						return System.getProperty("user.home")+"\\Downloads\\";
					}
					
							private void repoClose(){
								try {
									repo.close();
								} catch (IOException e) {String txt = "<html><center>Закройте файл trmlist-report.xls</html>";gui1.Gui0(txt);
									e.printStackTrace();
								}
							}
					
									private void openRepo(){
										try {
											repo = new FileInputStream(this.getDir()+"trmlist-report.xls");
											curientWB_open = new HSSFWorkbook(repo);
											sheet_repo = curientWB_open.getSheetAt(0);
										} catch (IOException e) {
											String txt = "<html><center>Скачайте файл trmlist-report.xls</html>";
											gui1.Gui0(txt);

										}
										
									}
												private void iteration(){
													bdw.connect();
													int i = 0;
													
													Iterator<Row> iterator = sheet_repo.iterator();
											        while (iterator.hasNext()) {
											        	iterator.next();
											        	i++;
											        }
											        
											        int rowInPart = (int) Math.floor(i/10);
											        int bonusRow = i - rowInPart*10;
											        
//											       this.New_ThreadInsert(1, i-1);
											       
											        
											        this.insertData(1,i-1);
											        
											        
//											        this.New_ThreadInsert(rowInPart+1, rowInPart*2);
//											        this.New_ThreadInsert(rowInPart*2+1, rowInPart*3);
//											        this.New_ThreadInsert(rowInPart*3+1, rowInPart*4);
//											        this.New_ThreadInsert(rowInPart*4+1, rowInPart*5);
//											        this.New_ThreadInsert(rowInPart*5+1, rowInPart*6);
//											        this.New_ThreadInsert(rowInPart*6+1, rowInPart*7);
//											        this.New_ThreadInsert(rowInPart*7+1, rowInPart*8);
//											        this.New_ThreadInsert(rowInPart*8+1, rowInPart*9);
//											        this.New_ThreadInsert(rowInPart*9+1, rowInPart*10+bonusRow-1);
												
											        bdw.close_connect();
													this.repoClose();
													
												}
	
												
												public void insertData(int startRow, int finishRow){
													
													int id_term;
													String city_name;
													String street_name;
													String home_number;
													
													for(int row = startRow; row <finishRow; row++){
											        	
											        	id_term = (int) sheet_repo.getRow(row).getCell(1).getNumericCellValue();
											        	city_name =     sheet_repo.getRow(row).getCell(4).getStringCellValue();
											        	street_name =   sheet_repo.getRow(row).getCell(5).getStringCellValue();
											        	home_number =   sheet_repo.getRow(row).getCell(6).getStringCellValue();
											        	
												        	switch (this.checkDouble(Integer.toString(id_term))){															
																case 0: bdw.insertInTo_trmlist_report(id_term, city_name, street_name, this.modificNumberHome(home_number));
																		break;																	
																case 1:	break;													
												        	}											        	
											        }	
													
													
												}
												
												
													private int modificNumberHome (String input){
														String subStr="";
														int integer;
														
														char [] numberHome = input.toCharArray ();
	
															for (int i =0; i < numberHome.length; i++){						
																		try {
																			integer= Integer.parseInt(""+numberHome[i]);								
																			subStr = subStr + ""+numberHome[i];
																		} catch (Exception e){break;}											
															}		
														return Integer.parseInt(subStr);
													}	
												
															private int checkDouble(String number_term){
																int trigger = 0;
																this.addArrayIdTerm();
																	
																
																	for (int i = 0; i < id_term_inDB.size(); i++){

																		
																		if (number_term.compareTo(id_term_inDB.get(i)) == 0){																			
																			trigger = 1;
																			break;
																		}
																	}
																	
																return trigger;
															}
																	private void addArrayIdTerm(){																		
																		BD_write bdw = new BD_write();																		
																		id_term_inDB = new BD_write().getAll_id_termTrmlist_report();
																		
																	}
															
						
					private void New_ThreadInsert(int start, int finish){						
						new Thread(() -> {					
						        try {				
						        	this.insertData(start,finish);
								} catch (Exception e) {
									e.printStackTrace();
								}
						}).start();					
					}
											
}
