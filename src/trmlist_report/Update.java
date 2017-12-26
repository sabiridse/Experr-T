package trmlist_report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	private JFileChooser fileopen;
	
	public void insertTo(){
		
			this.openRepo();
			if (sheet_repo != null){

				this.iteration();
				
				Gui1 gui = new Gui1();
				String txt = "<html><center>Справочник обновлен</html>";
				gui.Gui0(txt);
			}
			
				
		
	}
	
					private String getDir() {
						return System.getProperty("user.home")+"\\Downloads\\";
					}
					
							private void repoClose(){
								try {
									repo.close();
								} catch (IOException e) {String txt = "<html><center>Закройте файл</html>";gui1.Gui0(txt);
									e.printStackTrace();
								}
							}
					
									private void openRepo(){
										
										String dir = new FileOperation().getDir();				
										 fileopen = new JFileChooser(dir);
										 fileopen.setFileFilter(new FileNameExtensionFilter("xls","xls"));
										 fileopen.showDialog(null, "Выбрать файл");
										 try {
											sheet_repo = new HSSFWorkbook(new FileInputStream(dir + fileopen.getSelectedFile().getName()))
											.getSheet("Данные");
										} catch (FileNotFoundException e1) {
											String txt = "<html><center>Скачайте файл отчёта по терминалам</html>";
											gui1.Gui0(txt);
											e1.printStackTrace();
										} catch (IOException e1) {
											String txt = "<html><center></html>";
											gui1.Gui0(txt);
											e1.printStackTrace();
										}
										
										
//										try {
//											repo = new FileInputStream(this.getDir()+"trmlist-report.xls");
//											curientWB_open = new HSSFWorkbook(repo);
//											sheet_repo = curientWB_open.getSheetAt(0);
//										} catch (IOException e) {
//											String txt = "<html><center>Скачайте файл отчёта по терминалам</html>";
//											gui1.Gui0(txt);
//
//										}
										
									}
												private void iteration(){
													bdw.connect();
													int i = 4;
													
													Iterator<Row> iterator = sheet_repo.iterator();
											        while (iterator.hasNext()) {
											        	iterator.next();
											        	i++;
											        }
											        
											        int rowInPart = (int) Math.floor(i/10);
											        int bonusRow = i - rowInPart*10;
											        
											        this.insertData(3,i-1);
												
											        bdw.close_connect();
													this.repoClose();
													
												}
	
												
				public void insertData(int startRow, int finishRow){
													
				  int id_term;
				  String city_name;
				  String street_name;
			      String home_number;
				  DistrInkass distInk = new DistrInkass();
				  ObjectName objName = new ObjectName();
				  Experr.progressBar_inkass.setMaximum(finishRow);
				  Experr.progressBar_inkass.setVisible(true);
					  for(int row = startRow; row <finishRow; row++){
												        	
//							id_term = (int) sheet_repo.getRow(row).getCell(1).getNumericCellValue();//*********0 для дпс
//							city_name =     sheet_repo.getRow(row).getCell(4).getStringCellValue();//**********3
//							street_name =   sheet_repo.getRow(row).getCell(5).getStringCellValue();//**********5
//							home_number =   sheet_repo.getRow(row).getCell(6).getStringCellValue();//**********6
							id_term = (int) sheet_repo.getRow(row).getCell(0).getNumericCellValue();//*********0 для дпс
							city_name =     sheet_repo.getRow(row).getCell(3).getStringCellValue();//**********3
							street_name =   sheet_repo.getRow(row).getCell(5).getStringCellValue();//**********5
							try {
								home_number =   sheet_repo.getRow(row).getCell(6).getStringCellValue();//**********6
							} catch (Exception e){
								home_number = Integer.toString((int)sheet_repo.getRow(row).getCell(6).getNumericCellValue());
							}
							System.out.println("update136: "+id_term);
							
							String adress = street_name + "., " + home_number;
							Experr.progressBar_inkass.setValue(row);				        	
							switch (this.checkDouble(Integer.toString(id_term))){															
								case 0: bdw.insertInTo_trmlist_reportPartOne(id_term, city_name, street_name, 
										this.modificNumberHome(home_number),
										distInk.getDistrInkass(city_name, street_name),
										objName.getObjectName(Integer.toString(id_term), city_name),
										adress, this.addAdressForKassa(city_name, street_name, adress));break;
									
								case 1:	break;													
							}											        	
					  }	
				  
					  Experr.progressBar_inkass.setVisible(false);
					  Experr.progressBar_inkass.setMaximum(100);
					  Experr.progressBar_inkass.setValue(0);
				}
												
				private String addAdressForKassa(String city_name, String street_name, String adress){
					
					String city = "";
					String distrLO = "";
					if (city_name.contains("Санкт-Петербург")==false){							 
						 city = city_name.substring(0, city_name.indexOf("(")-1);	
						 distrLO = city_name.substring(city_name.indexOf("/")+1,city_name.indexOf("р-н")+3)+", ";
					 } else city = city_name;
					
					if ( street_name.compareTo("")==0){
						adress = adress.substring(adress.indexOf(",")+1);
					}
					
					return distrLO+city+", "+adress;
				}
												
													private int modificNumberHome (String input){
														String subStr="";
														int integer;
														System.out.println("update173: "+input);
														char [] numberHome = input.toCharArray ();
	
															for (int i =0; i < numberHome.length; i++){						
																System.out.println("update177: "+numberHome[i]);		
																try {
																			integer= Integer.parseInt(""+numberHome[i]);								
																			subStr = subStr + ""+numberHome[i];
																		} catch (Exception e){}											
															}	
															
															System.out.println("update183: "+subStr);
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
