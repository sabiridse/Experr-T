package export_err;
public class NewThread_one extends Thread{
	
	
	
	public void New_Three(){//*****ГЛАВНЫЙ ТЯЖЕЛЫЙ ПОТОК ЦИКЛА ОБРАБОТКИ ДАННЫХ*****
				
			new Thread(() -> {
			        OSMP main_heavy_Thread = new OSMP();
			        try {
						main_heavy_Thread.Input_Data();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}).start();
			
	}
/*	
	public void New_fore(){//*****ПОТОК ЦИКЛА ОБРАБОТКИ ДАННЫХ  строки статусов*****
		
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
