import java.util.ArrayList;
import java.util.List;

public class Check_Double {

	
		public String checking (String numb_term, String for_except) throws Exception {
				List <String> list_numbers_term = new ArrayList<String>();
				String number_term = numb_term;
				BD_write bdw = new BD_write();
				list_numbers_term = bdw.reqest_for_double(for_except);
				String [] arr_number_term = list_numbers_term.toArray(new String[list_numbers_term.size()]);
					
				for (int i = 0; i < list_numbers_term.size(); i++) {
						
						if (arr_number_term[i].toString().compareTo(numb_term) == 0) {
							String txt = "<html><center>Такой номер уже существует в базе</html>";
							Gui1 gui1 = new Gui1();
							gui1.Gui0(txt);
							number_term = "kaka";
							break;
						}
				
				}
				
				return number_term;
				
		}
}
