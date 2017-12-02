package inkass;

import java.util.ArrayList;
import java.util.List;

import GUIbonus.ProgressBarInkass;
import all_classes.BD_write;
import all_classes.Experr;
import all_classes.Gui1;
import trmlist_report.ObjectName;

public class DataForInkass {

	private ArrayList<String[]> inputData = new ArrayList<>();
	private BD_write bdw = new BD_write();
	private Marshruts marsh = new Marshruts();
	private static int countMarshruts;
	private static int trigerForFinishMassage;
	
	private void getInputData(String indexMarshrut, int rowLimitCount, int agentIndex) {
			
		inputData.clear();
			  
		inputData = bdw.getDataForInkassSPb(indexMarshrut,rowLimitCount,agentIndex);	
			    
		}
	
	private void getInputDataLO(String MarshrutPart1, String MarshrutPart2,String MarshrutPart3, int agentIndex) {
		
		inputData.clear();
			  
		inputData = bdw.getDataForInkassLO(MarshrutPart1,agentIndex);	
		inputData.addAll(bdw.getDataForInkassLO(MarshrutPart2,agentIndex));
		inputData.addAll(bdw.getDataForInkassLO(MarshrutPart3,agentIndex));
			    
		}
	
	public void checkBefore() throws Exception{
		
		trigerForFinishMassage = 0;
		int agentIndex = Experr.agent;
		int marshrutIndex = Experr.getAllMarshrutsStatus();
		if (marshrutIndex ==1){
			this.addInputData(0);
		}
		
		if (marshrutIndex == 0){
			
			switch (agentIndex){
				case 0: trigerForFinishMassage = 2;
						this.addInputData(1);
						this.addInputData(3);
						trigerForFinishMassage = 1;
						this.addInputData(2);
						trigerForFinishMassage = 0;
						break;
				case 1: this.addInputData(1);break;
				case 2: this.addInputData(2);break;
				case 3: this.addInputData(3);break;			
			}			
		}
	}
	
			private void addInputData(int agentIndex) throws Exception{

				Experr.progressBar_inkass.setVisible(true);
				
				//bdw.connect();
				marsh.OpenFile();
				Experr.progressBar_inkass.setValue(1);
				switch (Experr.getAllMarshrutsStatus()){				
						case 0: this.fiveMarshruts(agentIndex);break;
						case 1: this.allMarshruts();break;								
				}	
					Experr.progressBar_inkass.setValue(98);
					marsh.deleteEmptySheets();
					marsh.dopi(new DopiTerminals().getArrayDopi());
					Experr.progressBar_inkass.setValue(98);
					marsh.saveAndClose(agentIndex);
					
					Experr.progressBar_inkass.setVisible(false);
					Experr.progressBar_inkass.setValue(0);

					
					switch (trigerForFinishMassage){					
						case 0 : new Gui1().Gui0("<html><center>файл МАРШРУТЫ готов</html>"); break;
						case 1 : new Gui1().Gui0("<html><center>файлы маршрутов готовы</html>"); break;	
						case 2 : break;
					}					

			}
			
			private void fiveMarshruts(int agentIndex) throws Exception{//****main cicle for creature MARSHRUTS by ONLY for 1,2,3,4,5 marshruts
				
				//Experr experr = new Experr();
				List <String> distrs = new ArrayList<>();
				distrs.add(Experr.getDistr_inkass3());
				distrs.add(Experr.getDistr_inkass4());
				distrs.add(Experr.getDistr_inkass5());
				distrs.add(Experr.getDistr_inkass6());
				distrs.add(Experr.getDistr_inkass2());
				
				countMarshruts = distrs.size();
				int step = (int) 100/countMarshruts;
				int stepB = step;
					for ( String curientDistr:distrs){
				
						//Experr.progressBar_inkass.setValue(step);
						step = step + stepB;
							try {
								this.getPrivateDataByMarshrut(curientDistr,
															  agentIndex, 
															  Experr.limit);
							} catch (Exception e) {
								e.printStackTrace();
							}					
					}
					
					
			}
			
			private void allMarshruts(){				//****main cicle for creature MARSHRUTS by ONLY for ALL marshruts
				String [] allDistrs = {"11","12","51","52","61","62","4","8","9","4А","8А","9А"};	
				countMarshruts = 12;
				int step = 8;
				for ( String curientDistr:allDistrs){
					
					//Experr.progressBar_inkass.setValue(step);
					step = step + 8;
						try {
							this.getPrivateDataByMarshrut(curientDistr,0,300);
						} catch (Exception e) {
							e.printStackTrace();
						}					
				}
			}
			
		 private void creatureMarsh(String partUp, String partCenter, String partDown, 
				 					int agentIndex, int limit, int sheetIndex, boolean LO){
			
					 
					switch (String.valueOf(LO))	{	
					 
						case "true":	this.getInputDataLO(partUp,partCenter,partDown,agentIndex);
										if (inputData.size() > 0){
											marsh.writeSheet(inputData, sheetIndex, LO, countMarshruts);
										}
										break;
								 
								 
						case "false":   this.getInputData(partCenter,limit, agentIndex);
										if (inputData.size() > 0){
											marsh.writeSheet(inputData, sheetIndex, LO, countMarshruts);
										}
										break;
					} 
			 
			
			
		 }
		 
		 private void getPrivateDataByMarshrut(String distr_inkass, int agent, int limit) throws Exception{

			 if (distr_inkass.compareTo("рута") != 0){
				 ArrayList data = bdw.getPrivateDate(distr_inkass);
				 			 
				 this.creatureMarsh((String) data.get(0), (String) data.get(1),  
						 			(String) data.get(2), agent, limit, 
						 			(int) data.get(3), (boolean) data.get(4));
			 }
			 
		}
	
	public static int getCountMarshruts(){
		return countMarshruts;
	}
	
	
}
