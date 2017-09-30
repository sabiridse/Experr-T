package contextFind;

import all_classes.Experr;

public class TooManyCriteries {

	private String InputData;
	private String[] SplitInputData;
	private String[] OtputData;
	
			 String[] getSplitInputData(){
				
					try {
						InputData = Experr.textField_8.getText();
					} catch (Exception e) {
						e.printStackTrace();
					}				
					SplitInputData = InputData.split(" ");
			return SplitInputData;
			}
	
			 public String addQuery(){
				 
				 String[] sub = this.getSplitInputData();
				 String firstRowWithoutLike = " errors33.id_term = '" + sub[0] + "'";//1 строка
				 String nextRowsWithoutLike = "";
				 String firstRowLike = " terminals.name_term like '%" + sub[0] + "%'";//1 строка
				 String nextRowsLike = ""; 
				 
					if (sub.length  > 1)	{ 
				 
					 		for (int i = 1; i < sub.length; i++){
								 																 
					 			nextRowsWithoutLike = nextRowsWithoutLike + " or errors33.id_term = '" + sub[i] + "'";//2
					 			nextRowsLike = nextRowsLike + " and terminals.name_term like '%" + sub[i] + "%'";//2
								 
							 }
					}
				 
				 String query_find = "select errors33.id_term, terminals.name_term, errors33.heart_bit, errors33.pay, errors33.cash,"
							+ " errors33.print, errors33.tach, terminals.other, terminals.name_distr, errors33.curtime"
							+ " from errors33"
							+ " left join terminals on errors33.id_term = terminals.id_term "   															
							+ " where "
							+ firstRowWithoutLike + nextRowsWithoutLike
							+ " union "
							+ " select errors33.id_term, terminals.name_term, errors33.heart_bit, errors33.pay, errors33.cash,"
							+ " errors33.print, errors33.tach, terminals.other, terminals.name_distr, errors33.curtime"
							+ " from errors33"
							+ " left join terminals on errors33.id_term = terminals.id_term "   															
							+ " where "
							+ firstRowLike + nextRowsLike;		
				 
				 
				 
				return query_find; 
			 }
			 
			 
}
