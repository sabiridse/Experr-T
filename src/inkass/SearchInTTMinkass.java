package inkass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import all_classes.BD_write;

public class SearchInTTMinkass {

	public void insertArrayTTMInDB(ArrayList<ArrayList> subtable){
		
		BD_write bdw = new BD_write();
		
		try {
			bdw.uni_reqest_in_db("delete from sutable_inkass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (ArrayList row:subtable){
			
			String id_term = Integer.toString((int)row.get(0));
			String name_term = (String) row.get(1);
			String object = (String) row.get(2);
			String adress = (String) row.get(3);
			String adressForKassa = (String) row.get(4);
			String regim = (String) row.get(5);
			String agent = (String) row.get(6);
			String distr_inkass = (String) row.get(7);
			String summ = Integer.toString((int) row.get(8));
			String last_inkass_data = (String) row.get(9);
			String auto = (String) row.get(10);
	
		String query ="INSERT INTO sutable_inkass "
					 +"(id_term,name_term,object,adress,adressForKassa,regim,agent,distr_inkass,summ,last_inkass_data,auto) "
				   	 +"VALUES ('"+id_term+"','"+name_term+"','"+object+"','"+adress+"','"
								 +adressForKassa+"','"+regim+"','"+agent+"','"+distr_inkass+"', '"
							   	 +summ+"','"+last_inkass_data+"','"+auto+"')";
		
		try {
			bdw.uni_reqest_in_db(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	}
	
	
}
