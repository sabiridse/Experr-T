package inkass;

import java.util.ArrayList;
import java.util.List;

import GUIbonus.ShortStataByMarshrut;
import all_classes.BD_write;
import all_classes.Experr;

public class DataForShortStata {

	private static List <String> countTerminalsinStata = new ArrayList<String>();
	private static ArrayList <String> distrInkasForAggregates = new ArrayList<String>();
		
	public void getData(){
			countTerminalsinStata.clear();	
			distrInkasForAggregates.clear();
			this.creature(Experr.getDistr_inkass3());
			this.creature(Experr.getDistr_inkass4());
			this.creature(Experr.getDistr_inkass5());
			this.creature(Experr.getDistr_inkass6());
			this.creature(Experr.getDistr_inkass2());
						
			ShortStataByMarshrut ssbm = new ShortStataByMarshrut();
 		  	ssbm.showStata(countTerminalsinStata);
			
		}
		
		
		private void creature (String distr_inkass){
			
			List <String> ListPrivateData = new ArrayList<String>();
			String limit = "0";
			int trigger = 0;
			if (distr_inkass.compareTo("рута")==0){
				distr_inkass = "";
				countTerminalsinStata.add("0");
				countTerminalsinStata.add("0");
				countTerminalsinStata.add("0");
				countTerminalsinStata.add("0");
			}
				
			if (distr_inkass.compareTo("")!=0){	
				BD_write bdw = new BD_write();
				ListPrivateData = bdw.getPrivateDate(distr_inkass);
					
				switch (String.valueOf(ListPrivateData.get(4))){
						case "true": limit = Integer.toString(Experr.SummlimitLO);trigger = 1;break;
						case "false": limit = Integer.toString(Experr.Summlimit);trigger = 0;break;									
				}
				
				if (trigger==1){
					distrInkasForAggregates.add(ListPrivateData.get(0));
					distrInkasForAggregates.add(ListPrivateData.get(1));
					distrInkasForAggregates.add(ListPrivateData.get(2));
				}
				
				countTerminalsinStata.addAll(bdw.getStatByMarshrut(ListPrivateData.get(0),
															  ListPrivateData.get(1),
															  ListPrivateData.get(2),
															  limit, Integer.toString(Experr.SummlimitPirSps)));										
				countTerminalsinStata.add(distr_inkass);
			}
			
			
		}
		
		public ArrayList <String> getDistrInkasForAggregates(){
			return this.distrInkasForAggregates;
		}
		
		
}
