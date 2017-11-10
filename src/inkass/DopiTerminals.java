package inkass;

import java.util.ArrayList;
import java.util.List;

import GUIbonus.Dopi;
import all_classes.BD_write;

public class DopiTerminals {

	private static List <List<String>> data = new ArrayList<>();
	
	private String [] getDataOfTextFild( String input_string){
			 String[] SplitInputData;
			 SplitInputData = input_string.split("\t");		 
		return SplitInputData;
	}
	
	public void add (){

		 String query;

		 
		 if (this.addArrayDopi().size() > 0){
			 BD_write bdw = new BD_write();
				 bdw.connect();
			 
				 for(List<String> terminal:this.addArrayDopi()){	
					 
						query = "UPDATE ostatki SET bonus = 80000 WHERE id_term = '"+ terminal.get(0)+"'";
						try {
							bdw.uni_reqest_in_db(query);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}				
				 }
			 
				 bdw.close_connect();
		 }
	}
	
	private List<List<String>> addArrayDopi(){
		
		data.clear();
		List <String> dirtyData = new ArrayList<>();
		
		 String[] terminalsDopi = this.getDataOfTextFild(new Dopi().getNumbersTerminals());
		int i;
		 for(String terminal:terminalsDopi){	
			 i =terminal.lastIndexOf(" ");			 
			 if (i > 0){
				 String text = terminal.substring(0, i);
				 String number = terminal.substring(i);
				 dirtyData.add(text.trim());
				 dirtyData.add(number.trim());
			 } else {			 
				 dirtyData.add(terminal);
			 }
		 }
		 
		 for (int q = 1; q < dirtyData.size(); q = q+2){
			 List <String> row = new ArrayList<>();
			 row.add(dirtyData.get(q-1));
			 row.add(dirtyData.get(q));
			 data.add(row);
		 }
		 return data;
	}
	public List<List<String>> getArrayDopi(){
		
		return this.data;
	}
	
	
}