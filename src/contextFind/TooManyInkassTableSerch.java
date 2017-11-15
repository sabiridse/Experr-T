package contextFind;

import java.util.ArrayList;

import GUIbonus.CopyPasteDataInkass;
import all_classes.BD_write;
import all_classes.Experr;
import trmlist_report.DistrInkass;

public class TooManyInkassTableSerch {

	private static String InputData;
	private static String[] SplitInputData;
	private String[] OtputData;
	static BD_write bdw = new BD_write();
	

	
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
							+ " trmlist_report.regim, trmlist_report.agent,trmlist_report.distr_inkass, ostatki.summ, ostatki.last_inkass_data, trmlist_report.auto"
							+ " from ostatki"
							+ " left JOIN terminals ON ostatki.id_term = terminals.id_term "
							+ " left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term"
							+ " where terminals.except_term !=1 and "
							+ " terminals.regions = 0 and "
							+ firstRowWithoutLike + nextRowsWithoutLike
							+ " union "
							+ "select ostatki.id_term, terminals.name_term, trmlist_report.object, trmlist_report.adress,"
							+ " trmlist_report.regim, trmlist_report.agent,trmlist_report.distr_inkass, ostatki.summ, ostatki.last_inkass_data, trmlist_report.auto"
							+ " from ostatki"
							+ " left JOIN terminals ON ostatki.id_term = terminals.id_term "
							+ " left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term"
							+ " where terminals.except_term !=1 and "
							+ " terminals.regions = 0 and "
							+ firstRowLike + nextRowsLike;	
				 
				return query_find; 
		}	
		public void serchRequest (){

			bdw.connect();
			try {
				bdw.getArrayForInkassTable(this.addQuery());
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		private String addQueryForCopyPaste (){
			
			String[] sub = this.getSplitInputData();
			String query ="";
			String nextRow = "";
			String firstRow = "select id_term, last_inkass_data from ostatki where id_term = '" + sub[0] + "'";//1 строка				
					if (sub.length  > 1)	{ 					 
				 		for (int i = 1; i < sub.length; i++){				
				 			nextRow = nextRow + " union select id_term, last_inkass_data from ostatki where id_term = '" + sub[i] + "'";				 			
				 		}				 			
					}					
					query = firstRow + nextRow;	 						
			return query;
		}
		
		public void creatureCopyPasteTable(){

			ArrayList<ArrayList<String>> arrayForCopyPaste = new ArrayList<>();
			String[] sub = this.getSplitInputData();
			try {
				Integer.parseInt(sub[0]);//******check for integer or string in the search
				arrayForCopyPaste = bdw.getArrayForCopyPasteTable(this.addQueryForCopyPaste());
				System.out.println(this.addList(arrayForCopyPaste, sub));
			} catch(Exception e){
			}
			
		}
		
		private ArrayList addList(ArrayList<ArrayList<String>> dataOfDB, String [] dataOfTextFild){
			ArrayList<ArrayList<String>> CopyPaste = new ArrayList<>();
			for (String id_term:dataOfTextFild){
				for (ArrayList<String> rowIn:dataOfDB){
					ArrayList<String> rowOut = new ArrayList();
					if (rowIn.get(0).compareTo(id_term)==0){
						rowOut.add(rowIn.get(0));
						rowOut.add(rowIn.get(1));
						CopyPaste.add(rowOut);
					}				
				}				
			}		
			return CopyPaste;	
		}
		
}
