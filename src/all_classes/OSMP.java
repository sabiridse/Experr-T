package all_classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Lider_Dps.ServicePPS;
import Osmp_Osmp.Service;
import Ostatki.Ostatki;
import Warning_lost_terminals.Find_lost_term;
import Warning_lost_terminals.TrackingNewAndLostTerminals;
import javenue.csv.Csv;
import services.TurnDataTimeInkass;
import export_err.NewThread_one;

public  class OSMP  {
	
	public static Csv.Writer writer_bonus;
	static Sheet sheet_osmp_import;
	static Row row;
	public static int size_errors_array,//*********эта переменная вызывается в классе для таблицы
					  rows_in_osmp_import;
	public static String Number_terminal,
						 Real_time_payment,
						 Real_time_signal,
						 string_whis_numberOfterminal,
						 string_whis_signal,
						 string_whis_payment,
						 string_info_devices;
	
	
	public static String curientStringDateTame,
						 StringDateTime,
						 StringDateTime_sign,
						 StringDateTime_pay;
	public static Bonus bonus = new Bonus();
	public static Input_csv input_csv = new Input_csv();
	public static Gui1 gui1 = new Gui1();
	public static OSMP osmp = new OSMP();

	
	public void Input_Data() throws Exception {
				
		int triger = 0;
		String  err0 = "OK",
				err1 = "Стекер заполнен",
				err11 = "Ридер в ошибке",
				err111 ="Ридер не подключен",
				err2 = "Зажевана купюра",
				err3 = "текер снят",
				err4 = "Купюроприемник вернул нераспознанный ответ",
				err5 = "Купюроприемник не найден",
				err6 = "Купюроприемник неисправен",
				err7 = "Ошибка связи с купюроприемником",
				err8 = "Ошибка связи с принтером",
				err9 = "Принтер не исправен или зажевана бумага",
				err10 = "Принтер не найден";
		String incass_time;
		Date time_last_incassation;
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long curTime = System.currentTimeMillis();//получаю системное впемя в миллисекундах
		String curStringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime - 3600000);//преобразую в СТРОКУ на 60 минут позже настоящего для буфера времени чтоб за 60мин ушла стекер снят после инкассации
		Date time_curient= format1.parse(curStringDate); //преобразую а формат даты						
		
		curientStringDateTame = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime);//просто текущее время
		
		
		
			rows_in_osmp_import = -1;  // для подсчёта количества строк в таблице***************
			
				
				//******************открываю поток для файла terminal_monitoring в даунлодах********************************
				
				String dir = System.getProperty("user.home");//узнаю текущую попку даунлоадов*****************************
								
				
				FileInputStream Osmp_import = new FileInputStream(dir + "\\Downloads\\terminal_monitoring.xls");
				Workbook wb_osmp_import = new HSSFWorkbook(Osmp_import);
				sheet_osmp_import = wb_osmp_import.getSheetAt(0);
				  
		        
				
				//******вычисляю кол-во нормальных строк ( последняя "ВСЕ" объеденённая не нужна) в terminal_monitoring
				Iterator<Row> iterator_osmp_import = sheet_osmp_import.iterator();
			        while (iterator_osmp_import.hasNext()) {
			            iterator_osmp_import.next();
			            rows_in_osmp_import++;        // эта переменная и будет кол-вом строк после полного цикла
			        }
			        
	
			    	//gui1.creature_prog_bar(rows_in_osmp_import);//показываю ПРОГРЕССбар в главном окне
			    	Experr.progressBar_1.setVisible(true);  
		
			    	
		 Magic_Osmp mo = new Magic_Osmp();	
		 BD_write bdw = new BD_write();
		 Ostatki ostatki = new Ostatki();
		 Find_lost_term flt = new Find_lost_term();	
		 TurnDataTimeInkass tdti = new TurnDataTimeInkass();
			
			bdw.connect();//****************подключаюсь к бд****************
		 
		 String delDermoshkaTerm = "delete from terminals where name_distr = 'CHECKING'";//*******пока на базе триггер - сам удаляю терема присланные дерьмошкой
		 bdw.uni_reqest_in_db(delDermoshkaTerm);
			
			
//*********копирую предыдущие ТОЛЬКО ОШИБКИ ( примерно 200-250 шт, а не всё что считалось 2000шт) в таблицу хранилище*************					
			String query_copy = "insert into errors_save "
					+ "select errors33.id_term, errors33.heart_bit, errors33.pay, errors33.cash, "//my first shiiiiiiiiiitCode ;)
					+ "errors33.print, errors33.tach, errors33.curtime, terminals.other "
					+ "from errors33 "
					+ "left join terminals on errors33.id_term = terminals.id_term "
					+"where terminals.except_term = 0 and "                      //***терем не в исключениях
					+"(heart_bit < (DATE_SUB(errors33.curtime,Interval 2 HOUR)) or "//***сигнал 2более 2 часов
					+"pay < (DATE_SUB(errors33.curtime,Interval 2 DAY)) or "//***платеджи более 2 дней
					+"cash != 'OK' or "                                     //***ошибка купюра
					+"terminals.other != '' or "                            //***есть запись в примечаниях
					+"print != 'OK')";	                                    //***ошибка принтер
			bdw.uni_reqest_in_db(query_copy);
//*******************************************************************************************************************
//*********************************очищаю рабочую таблицу************************************************************					
			String query_clear = "Delete from errors33";
			bdw.uni_reqest_in_db(query_clear);
			bdw.clear_table("curient_last_inkass");//****очищаю таблицу последних инкассаций
//********************************************************************************************************************
			
			//Last_incass lastincass = new Last_incass();


			flt.getNumberTermIn_errors33Table().clear();
		 
// ГЛАВНЫЙ ТЯЖЕЛЫЙ ПОТОК - вношу данные в файл экспорта**************************************************************************

		for ( int i = 1; i < rows_in_osmp_import ; i++) {    
		

					gui1.runable_progbar(i);//каждый круг добавляю в прогресс бар и магия твориться
					//получаю данные из терминал мониторинг****************************************************************			
					
					row = sheet_osmp_import.getRow(i);  //текущая строка i - от 2 до конца
					
					triger = 0;
					
					//******************вычисляю НОМЕР ТЕРМИНАЛА из строки в ячейке D i***********************************************************
					string_whis_numberOfterminal = row.getCell(3).getStringCellValue();//значение ячейки D в строке i (текущая в цикле_)
					Number_terminal = string_whis_numberOfterminal.substring(0, 8);    //вырезаю из значения  первые 8 символов - получаю номер терема
				
					//время инкассации получаю для отсеивания стекер снят недавно
					incass_time = row.getCell(9).getStringCellValue();
					String incass_timeBonus = row.getCell(9).getStringCellValue();
					
					if (incass_time.compareTo("") == 0) {incass_time = "не было"; incass_timeBonus = "01.01.1900 00:00:00";} else {
						incass_time = tdti.turningString(row.getCell(9).getStringCellValue());
					}
					
					ostatki.setValue(Number_terminal, row.getCell(4).getStringCellValue(),incass_time);// add ARRAY for OSTATKI
					
					
					
					
					
					string_whis_signal= row.getCell(6).getStringCellValue();//получаю из terminal monitoring значение ячейки G с сигналом, строка таже i

					string_whis_payment= row.getCell(7).getStringCellValue();//получаю из terminal monitoring значение H с последним платежом строки i
	

	/*магия преобразования*/mo.strings_by_magic(string_whis_signal, string_whis_payment);
										
					string_info_devices = row.getCell(8).getStringCellValue();
					
					
					
										
						//lastincass.creature_array_incass(Number_terminal,incass_time);//***пишу массив с временем инкассаций
						
						format1.applyPattern("dd.MM.yyyy HH:mm:ss");
						time_last_incassation= format1.parse(incass_timeBonus);//время инкассации в формате даты					
												
							if (string_info_devices.compareTo("") != 0) {//если строка статусов не пустая...
							
							
								if (string_info_devices.contains(err1) == true) {string_info_devices = "Стек полон"; triger = 1;}
								if (string_info_devices.contains(err11) == true) {string_info_devices = "Ридер в ошибке"; triger = 1;}
								if (string_info_devices.contains(err111) == true) {string_info_devices = "Ридер не подключен"; triger = 1;}
								if (string_info_devices.contains(err2) == true) {string_info_devices = "Зажевана купюра"; triger = 1;}
								
								
								if (time_curient.compareTo(time_last_incassation) == 1) {//если инкассация была более 60 минут назад
									if (string_info_devices.contains(err3) == true) {string_info_devices = "Стек снят"; triger = 1;}				
								}
								
								
								if (string_info_devices.contains(err4) == true) {string_info_devices = "Критическая ошибка"; triger = 1;}
								if (string_info_devices.contains(err5) == true) {string_info_devices = "Купюроприемник не найден"; triger = 1;}
								if (string_info_devices.contains(err6) == true) {string_info_devices = "Критическая ошибка"; triger = 1;}
								if (string_info_devices.contains(err7) == true) {string_info_devices = "Ошибка связи"; triger = 1;}
								if (string_info_devices.contains(err8) == true) {string_info_devices = "Ошибка связи"; triger = 2;}
								if (string_info_devices.contains(err9) == true) {string_info_devices = "Критическая ошибка"; triger = 2;}
								if (string_info_devices.contains(err10) == true) {string_info_devices = "Принтер не найден"; triger = 2;}														
								if (triger == 0) string_info_devices = err0;
							}
							else string_info_devices = err0;
					
								
						
					
					//*****************************************************************************************				
										
					if (string_whis_payment.compareTo("") == 0) {
						string_whis_payment = "60 дней, 16 часов и58 минут";// поле ПЛАТЕЖ в terminal monitoring пустое то ставлю 9 дней и 16 часов назад (просто так)
					}
					
					Real_time_signal = mo.result_time_signal;//
				    Real_time_payment = mo.result_time_last_payment;//
				    
				   
				    
				    
				    flt.addNumberTermIn_errors33Table(Number_terminal);//add array of numbers terminals in errors33 table in DB 
				    
				    
				    
//************************************************************************************************************************************
//**********************************************************************************************************************************				    
//************************************************************************************************************************************
//**********************************************************************************************************************************	
				   // input_csv.number_term_errors_arr.add(Number_terminal);//пишу массив для сравнения с бонусом
				    //******************************ПЕРЕДАЮ СТРОКУ ВСТАВЩИКУ В БД
				    switch (triger){				    
						    case 0 :  bdw.inser_table_error33(Number_terminal, 
						    								  Real_time_signal, 
						    								  Real_time_payment, 
						    								  "OK", "OK", "OK", 
						    								  curientStringDateTame);
						    		  break;
						    case 1 :  bdw.inser_table_error33(Number_terminal, 
						    								  Real_time_signal, 
						    								  Real_time_payment,              
						    								  string_info_devices, 
						    								  "OK", "OK", 
						    								  curientStringDateTame);
						    		  break;
						    case 2 :  bdw.inser_table_error33(Number_terminal, 
						    								  Real_time_signal, 
						    								  Real_time_payment, 
						    								  "OK", 
						    								  string_info_devices, 
						    								  "OK", 
						    								  curientStringDateTame);
				    		  		  break;				    
				    }
				    
		}
//*************************************************************************************************************	

					Osmp_import.close();//закрываю поток файла terminall_monitoring из ОСМП
			
					String file_points_info = dir + "\\Downloads\\points_info.xls";		
					input_csv.writePir(file_points_info);//***********************************вставщик ПИРа в БД
													
					//bonus.open_csv_bonus();		//пошел делать массив bonus
								
					
					
					
					//osmp.compari_bonus_and_experr_arrs();// пошел сравнивать массивы errors(создается при создании файла) и bonus
										
					//osmp.experr_in_bonus();// проверяю есть ли в ошибках терема, которых нет в BONUS и добавляю обнаруженные
					
					
					
		
					
					
					//**********************************закрытие вставщика в CSV**************************************			
					//bonus.number_term_bonus_arr.clear();
					
					
					
					//input_csv.number_term_errors_arr.clear(); //очистка массивов

					
					bdw.main_reqest();
				
					ostatki.creatureOstatki();
					
					//input_csv.close_bonus_csv();
//********************************************************************************		
		
					
					
					//Experr.table.revalidate();
					//Experr.table.repaint();
					
					//bdw.last_inkass_array();
					
					flt.queryForArray_terminals_table(0);
					
					TrackingNewAndLostTerminals tnalt = new TrackingNewAndLostTerminals();
					tnalt.InsertLostSignalInLostTerm();
					
					if (Experr.New == 1){
						tnalt.addNewTermInDB();//*****only checkBox NEW is selected
					}
					
					
					bdw.close_connect();	
					
					
					
					
//					String txt = "<html><center>ошибки записаны в БД</html>";
//						gui1.Gui0(txt);
						Experr.btnNewButton_1.setEnabled(true);

						gui1.runable_progbar(2000);
						
					Files_check f_c = new Files_check();
					f_c.delete_old();//**********************************************************************************отключил для теста***********************

					//lastincass.output_inkass();	
					
					
					Experr.progressBar_1.setVisible(false);
					Experr.progressBar_1.setValue(0);
					
					
					
					
					
	}

//*********************************************НАХОЖУ БОНУС ТЕРМИНАЛЫ, КОТОРЫХ НЕТ В ERROR_EXPORT********************************
//	public void compari_bonus_and_experr_arrs() throws Exception{
//		
//					String element_bonus_arr = bonus.number_term_bonus_arr.get(0),
//						   element_errors_arr;
//					
//					int triger = 0,
//						size_bonus_arr = bonus.number_term_bonus_arr.size(),
//						size_err_arr = input_csv.number_term_errors_arr.size();
//					
//					
//						for (int z = 0; z < size_bonus_arr; z++){
//							
//							triger = 0;
//						
//								for (int i = 0; i < size_err_arr; i++){
//									
//										element_bonus_arr = bonus.number_term_bonus_arr.get(z);
//										element_errors_arr = input_csv.number_term_errors_arr.get(i);
//								
//										
//										
//											if (element_bonus_arr.compareTo(element_errors_arr) == 0){
//												
//												triger = 1;//нашел бонус терминал в error_export - продолжать цикл его поиска бессмысленно - выхожу из внутреннего цикла
//												break;
//											}
//						
//								}
//								
//									if (triger == 0){
//										try {
//											input_csv.write_array(element_bonus_arr);
//										} catch (Exception e) {
//		
//											e.printStackTrace();
//										} //отдаю вставщику в errors_export csv найденый терминал
//									}
//						}
//				
//	}
//*************************************************************************************************************************************	
	
//****************************************НАХОЖУ ТЕРМИНАЛЫ КОТОРЫЕ ЕСТЬ В ВЫГРУЗКЕ, НО НЕТ В BONUS**************	
	public void experr_in_bonus () throws IOException{
		
		String element_bonus_arr,
				   element_errors_arr = input_csv.number_term_errors_arr.get(0);
		
		int triger = 0,
				size_new_bonus,
				size_bonus_arr = bonus.number_term_bonus_arr.size(),
				size_err_arr = input_csv.number_term_errors_arr.size();

		for (int z = 0; z < size_err_arr; z++){
			
			triger = 0;
		
				for (int i = 0; i < size_bonus_arr; i++){
					
						element_bonus_arr = bonus.number_term_bonus_arr.get(i);
						element_errors_arr = input_csv.number_term_errors_arr.get(z);
				
							if (element_bonus_arr.compareTo(element_errors_arr) == 0){
								
								triger = 1;//нашел терминал из error_export в бонус - продолжать цикл его поиска бессмысленно - выхожу из внутреннего цикла
								break;
							}
		
				}
				
					if (triger == 0) { bonus.number_term_bonus_arr.add(element_errors_arr);} //добавляю терем который только в ошибках в BONUS
	
		}
		
					size_new_bonus = bonus.number_term_bonus_arr.size();//
					osmp.write_new_bonus(size_new_bonus);
	}
	
	
	public void write_new_bonus(int size_new_bonus) throws IOException{
		String number_term_new_bonus;
					osmp.open_bonus_csv();
					
					for ( int i = 0; i < size_new_bonus; i++) {
						number_term_new_bonus = bonus.number_term_bonus_arr.get(i);	
						osmp.write_bonus_csv(number_term_new_bonus);			
					}
		
		osmp.close_bonus_csv();
		
		
	}
	
	public void open_bonus_csv (){
		writer_bonus = new Csv.Writer(Experr.directory_res + "bonus.csv").delimiter(',');
}
	
	public void write_bonus_csv (String number_term) {		
		writer_bonus.value(number_term).newLine();		
}

	public void close_bonus_csv() throws FileNotFoundException{
		writer_bonus.close();		
}
	
	
	
}
