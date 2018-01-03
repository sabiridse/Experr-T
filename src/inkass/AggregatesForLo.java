package inkass;

import java.util.ArrayList;
import java.util.TreeSet;

import GUIbonus.AggregateLo;
import all_classes.BD_write;
import all_classes.Experr;

public class AggregatesForLo {
	
	@SuppressWarnings({ "unchecked", "unused" })
	private ArrayList getDistrAndOther (){
		ArrayList<ArrayList<String>> distrAndOther = new ArrayList<>();
		BD_write bdw = new BD_write();
		distrAndOther = bdw.getDistrAndOther(this.getDistrInkassLo(0),
											 this.getDistrInkassLo(1),
											 this.getDistrInkassLo(2),
											 this.getDistrInkassLo(3),
											 this.getDistrInkassLo(4),
											 this.getDistrInkassLo(5));
		return distrAndOther;
	}
	
	private String getDistrInkassLo(int index){
		String returnable = "0";
		ArrayList <String> distrInkasForAggregates = new ArrayList<String>();
		DataForShortStata dfss = new DataForShortStata();
		distrInkasForAggregates = dfss.getDistrInkasForAggregates();
		
		
		if (distrInkasForAggregates.size()!=0){
			returnable = distrInkasForAggregates.get(index);
		}
		return returnable;
	}
	
	private ArrayList removeDoubleDistrs(ArrayList<ArrayList<String>> input){	
		TreeSet<Integer> indexesForDel = new TreeSet<>();
		for (ArrayList<String> row: input){			
			if (row.get(1).length() == 0){
				for (ArrayList<String> subRow: input){			
					if (row.get(0).compareTo(subRow.get(0)) == 0 & subRow.get(1).length() != 0){
						indexesForDel.add(input.indexOf(row));												
					}
				}				
			}
		}
		for (int i : indexesForDel.descendingSet()){
			input.remove(i);
		}
		return input;
	}
	
	public void data(){
		new AggregateLo().showFrame();
		TTMaggregatLO ttmLo = new TTMaggregatLO();
		ttmLo.dataArrayList.clear();
		ttmLo.addDate(this.removeDoubleDistrs(this.getDistrAndOther()));
		
		
		
	}
}
