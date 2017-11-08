package inkass;

import GUIbonus.Dopi;
import all_classes.BD_write;

public class DopiTerminals {

	
	private String [] getDataOfTextFild( String input_string){
			 String[] SplitInputData;
			 SplitInputData = input_string.split(" ");		 
		return SplitInputData;
	}
	
	public void add (){
		
		 String[] terminalsDopi = this.getDataOfTextFild(new Dopi().getNumbersTerminals());
		 String query;
		 
		 if (terminalsDopi.length > 0){
			 BD_write bdw = new BD_write();
				 bdw.connect();
			 
				 for(String terminal:terminalsDopi){			 
						query = "UPDATE ostatki SET bonus = 80000 WHERE id_term = " + terminal;
						try {
							bdw.uni_reqest_in_db(query);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}				
				 }
			 
				 bdw.close_connect();
		 }
	}
}
