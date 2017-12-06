package inkass;

import java.util.ArrayList;

import all_classes.BD_write;

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
		ArrayList <String> distrInkasForAggregates = new ArrayList<String>();
		DataForShortStata dfss = new DataForShortStata();
		distrInkasForAggregates = dfss.getDistrInkasForAggregates();
		return distrInkasForAggregates.get(index);
	}
	
	private ArrayList<ArrayList<String>>checkDoubleDistrs(ArrayList <ArrayList<String>> input){
		
		for (ArrayList<String> row:input){
			
			if (row.get(1).length() == 0){
				System.out.println(row.get(0));
			}
		}
		
		
		
		return null;
	}
	
	public void data(){
		System.out.println(this.getDistrAndOther());
		this.checkDoubleDistrs(this.getDistrAndOther());
	}
}
