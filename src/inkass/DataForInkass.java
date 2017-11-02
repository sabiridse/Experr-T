package inkass;

import java.util.ArrayList;
import java.util.List;

import all_classes.BD_write;
import all_classes.Experr;
import all_classes.Gui1;
import trmlist_report.ObjectName;

public class DataForInkass {

	private ArrayList<String[]> inputData = new ArrayList<>();
	private BD_write bdw = new BD_write();
	private Marshruts marsh = new Marshruts();
	
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
	
			public void addInputData() throws Exception{
				
				
				
				//bdw.connect();
				marsh.OpenFile();

				Experr experr = new Experr();
				
				switch (experr.getAllMarshrutsStatus()){				
						case 0: this.fiveMarshruts();break;
						case 1: this.allMarshruts();break;								
				}
				
//				try {
//						this.getPrivateDataByMarshrut(experr.getDistr_inkass4(),
//													  experr.agent, 
//													  experr.limit);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//						try {
//							this.getPrivateDataByMarshrut(experr.getDistr_inkass5(),
//														  experr.agent, 
//														  experr.limit);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//							try {
//								this.getPrivateDataByMarshrut(experr.getDistr_inkass6(),
//															  experr.agent, 
//															  experr.limit);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//								try {
//									this.getPrivateDataByMarshrut(experr.getDistr_inkass2(),
//																  experr.agent, 
//																  experr.limit);
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
					//bdw.close_connect();
					marsh.deleteEmptySheets();
					marsh.saveAndClose();
			
					Gui1 gui = new Gui1();
					String txt = "<html><center>файл МАРШРУТЫ готов</html>";
					gui.Gui0(txt);
					
			}
			
			private void fiveMarshruts() throws Exception{
				
				Experr experr = new Experr();
				List <String> distrs = new ArrayList<>();
				distrs.add(experr.getDistr_inkass3());
				distrs.add(experr.getDistr_inkass4());
				distrs.add(experr.getDistr_inkass5());
				distrs.add(experr.getDistr_inkass6());
				distrs.add(experr.getDistr_inkass2());
								
					for ( String curientDistr:distrs){
				
							try {
								this.getPrivateDataByMarshrut(curientDistr,
															  experr.agent, 
															  experr.limit);
							} catch (Exception e) {
								e.printStackTrace();
							}					
					}
			}
			
			private void allMarshruts(){				
				String [] allDistrs = {"11","12","51","52","61","62","4","8","9","4А","8А","9А"};				
				for ( String curientDistr:allDistrs){
					
						try {
							this.getPrivateDataByMarshrut(curientDistr,0,400);
						} catch (Exception e) {
							e.printStackTrace();
						}					
				}
			}
			
		 private void creatureMarsh(String partUp, String partCenter, String partDown, 
				 					int agentIndex, int limit, int sheetIndex, boolean LO){
			 
			switch (String.valueOf(LO))	{	
			 
				case "true":	this.getInputDataLO(partUp,partCenter,partDown,agentIndex);
							marsh.writeSheet(inputData, sheetIndex, LO);break;
						 
						 
				case "false":	 this.getInputData(partCenter,limit, agentIndex);
							marsh.writeSheet(inputData, sheetIndex, LO);break;
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
	
	
	
	
}
