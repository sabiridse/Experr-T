package contextFind;

import java.util.ArrayList;

import GUIbonus.CopyPasteDataInkass;
import all_classes.BD_write;
import all_classes.Experr;
import inkass.TTMcopyPaste;
import trmlist_report.DistrInkass;

public class TooManyInkassTableSerch {

	private static String InputData;
	private static String[] SplitInputData;
	private String[] OtputData;
	static BD_write bdw = new BD_write();
	

	
		 String[] getSplitInputData(){
			
			try {
				InputData = Experr.textField_search.getText();
				if (InputData.compareTo(" ")==0){
					InputData="";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
				SplitInputData = InputData.split(" ");
			return SplitInputData;
		}

		private String addQuery(){
			 
			String[] sub = this.getSplitInputData();
			String firstRowWithoutLike = " id_term = '" + sub[0] + "'";//1 строка
			String nextRowsWithoutLike = "";
			String firstRowLike = " name_term like '%" + sub[0] + "%'";//1 строка
			String nextRowsLike = ""; 
				
			 if (sub.length  > 1)	{ 
			 
				 		for (int i = 1; i < sub.length; i++){							 																 
				 			nextRowsWithoutLike = nextRowsWithoutLike + " or id_term = '" + sub[i] + "'";//2
				 			nextRowsLike = nextRowsLike + " and name_term like '%" + sub[i] + "%'";//2				 			
						 }
				}
				 String query_find = "select id_term, name_term, object, adress, adressForKassa, "
							+ " regim, agent,distr_inkass, summ, last_inkass_data, auto"
							+ " from sutable_inkass"							
							+ " where"
							+ firstRowWithoutLike + nextRowsWithoutLike
							+ " union "
							+ "select id_term, name_term, object, adress, adressForKassa, "
							+ " regim, agent,distr_inkass, summ, last_inkass_data, auto"
							+ " from sutable_inkass"							
							+ " where"
							+ firstRowLike + nextRowsLike;	
				 
				return query_find; 
		}	
		
//		private String addQuery(){
//			 
//			String[] sub = this.getSplitInputData();
//			String firstRowWithoutLike = " terminals.id_term = '" + sub[0] + "'";//1 строка
//			String nextRowsWithoutLike = "";
//			String firstRowLike = " terminals.name_term like '%" + sub[0] + "%'";//1 строка
//			String nextRowsLike = ""; 
//				
//			 if (sub.length  > 1)	{ 
//			 
//				 		for (int i = 1; i < sub.length; i++){							 																 
//				 			nextRowsWithoutLike = nextRowsWithoutLike + " or terminals.id_term = '" + sub[i] + "'";//2
//				 			nextRowsLike = nextRowsLike + " and terminals.name_term like '%" + sub[i] + "%'";//2				 			
//						 }
//				}
//				 String query_find = "select ostatki.id_term, terminals.name_term, trmlist_report.object, trmlist_report.adress,"
//							+ " trmlist_report.regim, trmlist_report.agent,trmlist_report.distr_inkass, ostatki.summ, ostatki.last_inkass_data, trmlist_report.auto"
//							+ " from ostatki"
//							+ " left JOIN terminals ON ostatki.id_term = terminals.id_term "
//							+ " left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term"
//							+ " where terminals.except_term !=1 and "
//							+ " terminals.regions = 0 and "
//							+ firstRowWithoutLike + nextRowsWithoutLike
//							+ " union "
//							+ "select ostatki.id_term, terminals.name_term, trmlist_report.object, trmlist_report.adress,"
//							+ " trmlist_report.regim, trmlist_report.agent,trmlist_report.distr_inkass, ostatki.summ, ostatki.last_inkass_data, trmlist_report.auto"
//							+ " from ostatki"
//							+ " left JOIN terminals ON ostatki.id_term = terminals.id_term "
//							+ " left JOIN trmlist_report ON ostatki.id_term = trmlist_report.id_term"
//							+ " where terminals.except_term !=1 and "
//							+ " terminals.regions = 0 and "
//							+ firstRowLike + nextRowsLike;	
//				 
//				return query_find; 
//		}	
		
		public void serchRequest (){

			bdw.connect();
			try {
				bdw.getArrayForInkassTable(this.addQuery(),1);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		
		public void copyPasteTable(){
			try{
			Integer.parseInt(this.getSplitInputData()[0]);
			new CopyPasteDataInkass().showFrame();
			this.creatureCopyPasteTable();							     	        		 	 
   		  	
			} catch (Exception e){
				
			}
		}
		
		private String addQueryForCopyPaste (){
			
			String[] sub = this.getSplitInputData();
			String query ="";
			String nextRow = "";
			String firstRow = "select id_term, distr_inkass, last_inkass_data from sutable_inkass where id_term = '" + sub[0] + "'";//1 строка				
					if (sub.length  > 1)	{ 					 
				 		for (int i = 1; i < sub.length; i++){				
				 			nextRow = nextRow + " union select id_term, distr_inkass, last_inkass_data from sutable_inkass where id_term = '" + sub[i] + "'";				 			
				 		}				 			
					}					
					query = firstRow + nextRow;	 						
			return query;
		}
		
		private void creatureCopyPasteTable(){

			ArrayList<ArrayList<String>> arrayForCopyPaste = new ArrayList<>();
			String[] sub = this.getSplitInputData();
			try {
				Integer.parseInt(sub[0]);//******check for integer or string in the search
				arrayForCopyPaste = bdw.getArrayForCopyPasteTable(this.addQueryForCopyPaste());
				new TTMcopyPaste().addDate(this.addList(arrayForCopyPaste, sub));
			} catch(Exception e){
			}
			
		}
		
		private ArrayList addList(ArrayList<ArrayList<String>> dataOfDB, String [] dataOfTextFild){
			int triger =0;
			ArrayList<ArrayList<String>> CopyPaste = new ArrayList<>();
			for (String id_term:dataOfTextFild){
				ArrayList<String> rowOut = new ArrayList();
				rowOut.add(id_term);
				triger = 0;
					for (ArrayList<String> rowIn:dataOfDB){					
						if (rowIn.get(0).compareTo(id_term)==0){					
							rowOut.add(rowIn.get(1));
							rowOut.add(rowIn.get(2));
							triger = 1;
						}				
					}
					if (triger ==0){
						rowOut.add("");
						rowOut.add("");
					}
				CopyPaste.add(rowOut);
			}		
			return CopyPaste;	
		}
		
//		private ArrayList addList(ArrayList<ArrayList<String>> dataOfDB, String [] dataOfTextFild){
//			ArrayList<ArrayList<String>> CopyPaste = new ArrayList<>();
//			for (String id_term:dataOfTextFild){
//				for (ArrayList<String> rowIn:dataOfDB){
//					ArrayList<String> rowOut = new ArrayList();
//					
//					if (rowIn.get(0).compareTo(id_term)==0){
//						rowOut.add(rowIn.get(0));
//						rowOut.add(rowIn.get(1));
//						rowOut.add(rowIn.get(2));
//						CopyPaste.add(rowOut);
//					}				
//				}				
//			}		
//			return CopyPaste;	
//		}
}
