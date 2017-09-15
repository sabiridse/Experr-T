package all_classes;
import java.util.ArrayList;
import java.util.List;

public class Check_Double {
	private List <String> list_numbers_term = new ArrayList<String>();
	private String [] arr_number_term;
	
		public String checking (String numb_term, String for_except) throws Exception {
				
				String number_term = numb_term;
				BD_write bdw = new BD_write();
				list_numbers_term = bdw.reqest_for_double(for_except);
				arr_number_term = list_numbers_term.toArray(new String[list_numbers_term.size()]);
					
				for (int i = 0; i < list_numbers_term.size(); i++) {
						
						if (arr_number_term[i].toString().compareTo(numb_term) == 0) {
							
						
							
							String txt = "<html><center>Номер "+numb_term+" уже существует в исключениях</html>";
							Gui1 gui1 = new Gui1();
							gui1.Gui0(txt);
							number_term = "kaka";
							break;
						}
				
				}
				
				return number_term;
				
		}
}
