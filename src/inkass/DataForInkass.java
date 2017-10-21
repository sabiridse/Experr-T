package inkass;

import java.util.ArrayList;

import all_classes.BD_write;
import trmlist_report.ObjectName;

public class DataForInkass {

	private ArrayList<String[]> inputData = new ArrayList<>();

	
		private void getInputData() {
			inputData.clear();
			 BD_write bdw = new BD_write();
			  bdw.connect();
			   inputData = bdw.getDataForInkass();	
			    bdw.close_connect();
		}
	
			public void addInputData(){
				
				String object = "нет данных";
				
					this.getInputData();
					
					System.out.println(inputData.size());
				for (int i=0; i < inputData.size(); i++){	
					String [] row = inputData.get(i);
					
					object = new ObjectName().getObjectName(row[1]);
					
						if (row[2].compareTo("Санкт-Петербург г")!=0){
							
							object = new ObjectName().getObjectName(row[2])+","+new ObjectName().getObjectName(row[1]);
						}
					
					String adress = row[3]+" "+row[4];
					
					System.out.println(object+"|"+row[0]+"|"+adress+"|"+row[5]+"|"+row[6]+"|"+row[7]);
					
				}	
			}

	
	
	
	
	
}
