package contextFind;

import all_classes.BD_write;
import all_classes.Experr;
import trmlist_report.DistrInkass;

public class TooManyInkassTableSerch {

	private String InputData;
	private String[] SplitInputData;
	private String[] OtputData;
	
		String[] getSplitInputData(){
			
			try {
				InputData = Experr.textField_search.getText();
			} catch (Exception e) {
				e.printStackTrace();
			}				
				SplitInputData = InputData.split(" ");
			return SplitInputData;
		}

		private String addQuery(){
			 
			String[] sub = this.getSplitInputData();
			String firstRowWithoutLike = " terminals.id_term = '" + sub[0] + "'";//1 строка
			String nextRowsWithoutLike = "";
			String firstRowLike = " terminals.name_term like '%" + sub[0] + "%'";//1 строка
			String nextRowsLike = ""; 
				
			 if (sub.length  > 1)	{ 
			 
				 		for (int i = 1; i < sub.length; i++){							 																 
				 			nextRowsWithoutLike = nextRowsWithoutLike + " or terminals.id_term = '" + sub[i] + "'";//2
				 			nextRowsLike = nextRowsLike + " and terminals.name_term like '%" + sub[i] + "%'";//2				 			
						 }
				}
				 String query_find = "select ostatki.id_term, terminals.name_term, trmlist_report.object, trmlist_report.adress,"
							+ " trmlist_report.regim, trmlist_report.agent,trmlist_report.distr_inkass, ostatki.summ"
							+ " from ostatki"
							+ " left JOIN terminals ON ostatki.id_term = terminals.id_term "
							+ " left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term"
							+ " where terminals.except_term !=1 and "
							+ " terminals.regions = 0 and "
							+ firstRowWithoutLike + nextRowsWithoutLike
							+ " union "
							+ "select ostatki.id_term, terminals.name_term, trmlist_report.object, trmlist_report.adress,"
							+ " trmlist_report.regim, trmlist_report.agent,trmlist_report.distr_inkass, ostatki.summ"
							+ " from ostatki"
							+ " left JOIN terminals ON ostatki.id_term = terminals.id_term "
							+ " left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term"
							+ " where terminals.except_term !=1 and "
							+ " terminals.regions = 0 and "
							+ firstRowLike + nextRowsLike;	
				 
				return query_find; 
		}	
		public void serchRequest (){
			
			BD_write bdw = new BD_write();
			bdw.connect();
			try {
				bdw.getArrayForInkassTable(this.addQuery());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
