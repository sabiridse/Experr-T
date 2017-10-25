package inkass;

import java.util.ArrayList;

import all_classes.BD_write;
import all_classes.Gui1;
import trmlist_report.ObjectName;

public class DataForInkass {

	private ArrayList<String[]> inputData = new ArrayList<>();
	private BD_write bdw = new BD_write();
	private Marshruts marsh = new 	Marshruts();
		
	private void getInputData(int indexMarshrut, int rowLimitCount, int agentIndex) {
			
		inputData.clear();
			  
		inputData = bdw.getDataForInkassSPb(indexMarshrut,rowLimitCount,agentIndex);	
			    
		}
	
	private void getInputDataLO(String MarshrutPart1, String MarshrutPart2,String MarshrutPart3, int agentIndex) {
		
		inputData.clear();
			  
		inputData = bdw.getDataForInkassLO(MarshrutPart1,agentIndex);	
		inputData.addAll(bdw.getDataForInkassLO(MarshrutPart2,agentIndex));
		inputData.addAll(bdw.getDataForInkassLO(MarshrutPart3,agentIndex));

			    
		}
	
			public void addInputData(){
				
				bdw.connect();
				marsh.OpenFile();
				
				this.getInputData(11,500,0);
				marsh.writeSheet(inputData, 1, false);
				
					this.getInputData(12,500,0);
					marsh.writeSheet(inputData, 2, false);
						
						this.getInputData(51,500,0);
						marsh.writeSheet(inputData, 3, false);
						
							this.getInputData(52,500,0);
							marsh.writeSheet(inputData, 4, false);
							
								this.getInputData(61,500,0);
								marsh.writeSheet(inputData, 5, false);
								
									this.getInputData(62,500,0);
									marsh.writeSheet(inputData, 6, false);
									
										this.getInputDataLO("41","40","42",0);
										marsh.writeSheet(inputData, 7, true);
										
											this.getInputDataLO("81","80","82",0);
											marsh.writeSheet(inputData, 8, true);
											
												this.getInputDataLO("91","90","92",0);
												marsh.writeSheet(inputData, 9, true);
												
													this.getInputDataLO("4А1","4А0","4А2",0);
													marsh.writeSheet(inputData, 10, true);
													
														this.getInputDataLO("8А1","8А0","8А2",0);
														marsh.writeSheet(inputData, 11, true);
														
															this.getInputDataLO("9А1","9А0","9А2",0);
															marsh.writeSheet(inputData, 12, true);

					bdw.close_connect();				
					marsh.saveAndClose();
			
					Gui1 gui = new Gui1();
					String txt = "<html><center>файл МАРШРУТЫ готов</html>";
					gui.Gui0(txt);
					
			}

	
	
	
	
	
}
