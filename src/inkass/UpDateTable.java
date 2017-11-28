package inkass;

import all_classes.BD_write;
import all_classes.Experr;

public class UpDateTable {

	public void start() {
		BD_write bdw = new BD_write();
		  String query = "SELECT ostatki.id_term, terminals.name_term, trmlist_report.object, trmlist_report.adress, trmlist_report.adressForKassa,"
		  			   + "trmlist_report.regim, trmlist_report.agent,trmlist_report.distr_inkass, ostatki.summ, ostatki.last_inkass_data, "
		  			   + "trmlist_report.auto "
		  			   + "FROM ostatki "
		  			   + "left JOIN terminals ON ostatki.id_term = terminals.id_term "
		  			   + "left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term "
		  			   + "where terminals.except_term !=1 and "
		  			   + "terminals.regions = 0";
		  bdw.connect();
			try {

				bdw.getArrayForInkassTable(query,0);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

	}
}
