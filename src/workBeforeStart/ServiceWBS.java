package workBeforeStart;

import java.io.FileNotFoundException;
import java.io.IOException;

import Lider_Dps.ServicePPS;
import Osmp_Osmp.Service;
import export_err.NewThread_one;

public class ServiceWBS {
	
	public void creatureAllFiles(){
		
		ServicePPS service = new ServicePPS();
		try {
			
				service.addPoints_info();// chooser 2 files TERMINALS xlsx   = points_info whith all errors DPS
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//*********************************************************************		    	
						Service serviceOsmp = new Service();
							try {
								serviceOsmp.two_in_one();// terminal_monitoring + terminal_monitoring (1) = terminal_monitoring  whith all errors OSMP
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
//********************************************************************		
									//new NewThread_one().New_Three();// terminal_monitoring + points_info = export_errors.csv  for dermoshka
//*******************************************************************		
		
	}

}
