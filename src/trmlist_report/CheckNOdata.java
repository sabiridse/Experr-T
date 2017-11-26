package trmlist_report;

import java.sql.SQLException;
import java.util.ArrayList;

import all_classes.BD_write;

public class CheckNOdata {

	public void checkIn(){
		ArrayList<ArrayList <String>> terms = new ArrayList<>();
		ObjectName obNa = new ObjectName();
		BD_write bdw = new BD_write();
		try {
			terms = bdw.getTerminalsWhithNOdataInObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (ArrayList<String> term:terms){
			
			String id_term = term.get(0);
			String city_name = term.get(1);
			String object_name = obNa.getObjectName(id_term, city_name);
			String query = "update trmlist_report set object = '"+object_name
					      +"' where id_term = "+id_term	;
			try {
				bdw.uni_reqest_in_db(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
