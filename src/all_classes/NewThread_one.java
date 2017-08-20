package all_classes;
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
