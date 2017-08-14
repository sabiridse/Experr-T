import java.io.File;



public class Files_check {
	
	String dir = System.getProperty("user.home");//����� ������� ����� ����������*****************************				
	File export_errors = new File(dir + "\\Downloads\\export_errors.csv");
	File terminal_monitoring = new File(dir + "\\Downloads\\terminal_monitoring.xls");
	File points_info = new File(dir + "\\Downloads\\points_info.xls");
	
	
	public void checking() {
	
			Gui1 gui1 = new Gui1();
			
			int triger = 0;
				
			
			Boolean e_e = export_errors.exists();//���� ��� ��� ����			
			Boolean t_m = terminal_monitoring.exists();//���� ��� ��� ����			
			Boolean p_i = points_info.exists();//���� ��� ��� ����
			
			
			if (e_e == true) { export_errors.delete();}
			
			if (t_m == false) {String txt = "<html><center>нет файла ОСМП</html>";triger = 1;Experr.btnNewButton_1.setEnabled(true); gui1.Gui0(txt);}
			
			if (p_i == false) {String txt = "<html><center>нет файла Лидера</html>";triger = 1;Experr.btnNewButton_1.setEnabled(true); gui1.Gui0(txt);}

			
			if (triger == 0){
				NewThread_one thone3 = new NewThread_one();
				thone3.New_Three();  
			}
	
	}
	
	
	public void delete_old() {

		terminal_monitoring.delete();
		points_info.delete();
		
	}
	
}
