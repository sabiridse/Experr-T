package all_classes;

import inkass.DataForInkass;
import inkass.UpDateTable;
import trmlist_report.CheckNOdata;
import trmlist_report.Update;

//import src.OSMP;


public class NewThread_one extends Thread{
	
	
	
	public void New_Three(){//*****������� ������� ����� ����� ��������� ������*****
				
			new Thread(() -> {
			        OSMP main_heavy_Thread = new OSMP();
			        try {

						main_heavy_Thread.Input_Data();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}).start();
			
	}
	
					public void New_Thread(){
						
						Update update = new Update();
						
						
						new Thread(() -> {
						       
				
						        try {
				
						        	update.insertTo();
						        	new CheckNOdata().checkIn();
								} catch (Exception e) {
									e.printStackTrace();
								}
						}).start();
					}	
							
					
					
					
					public void New_ThreadInkass(){						
						new Thread(() -> {
						       				
						        try {
						        	DataForInkass dfi = new DataForInkass();
						        	dfi.checkBefore();
								} catch (Exception e) {
									e.printStackTrace();
								}
						}).start();
					}
					
									public void New_ThreadNO_data(){																			
										
										
										new Thread(() -> {										       							
										        try {
							
										        	
												} catch (Exception e) {
													e.printStackTrace();
												}
										}).start();
									
									}
	
									public void New_ThreadUpDateTable(){						
										new Thread(() -> {
										       				
										        try {
										        	new UpDateTable().start();
												} catch (Exception e) {
													e.printStackTrace();
												}
										}).start();
									}
	
/*	
	public void New_fore(){//*****����� ����� ��������� ������  ������ ��������*****
		
		new Thread(() -> {
		        OSMP status_Thread = new OSMP();
		        try {
		        	status_Thread.Statuses();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}).start();
		
}
*/	
}
