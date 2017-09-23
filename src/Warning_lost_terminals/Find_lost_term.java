package Warning_lost_terminals;

import java.sql.SQLException;
import java.util.ArrayList;

import all_classes.BD_write;

public class Find_lost_term {

	
	private static ArrayList<String> NumberTermIn_errors33Table = new ArrayList <String>();
	private static ArrayList<String> NumberTermIn_terminalsTable = new ArrayList <String>();	
     		public ArrayList<String> getNumberTermIn_terminalsTable() {
				
				
				return NumberTermIn_terminalsTable;
			}
	
			public void addNumberTermIn_terminalsTable(String numberTerm){
				
				NumberTermIn_terminalsTable.add(numberTerm);
				
			}
			
			public int getSizeNumberTermIn_terminalsTable(){
				
				return NumberTermIn_terminalsTable.size();
			}
			
			public String getNumberTermOFterminalsArray(int index){
				
				return NumberTermIn_terminalsTable.get(index);
				
			}
			
			
	
						public ArrayList<String> getNumberTermIn_errors33Table() {
							

							return NumberTermIn_errors33Table;
						}
			
			
						public  void addNumberTermIn_errors33Table(String numberTerm){
										
							NumberTermIn_errors33Table.add(numberTerm);
						}
						
						public  int getSizeNumberTermIn_errors33Table(){
							
							return NumberTermIn_errors33Table.size();
						}
						
						public String getNumberTermOFerrors33Array(int index){
							
							return NumberTermIn_errors33Table.get(index);
							
						}
						
						
						
								public void queryForArray_terminals_table(int exceptValue){
									
									try {
										new BD_write().addArrayOfNumberTerm_in_terminalsTable(exceptValue);//query in DB
									} catch (SQLException e) {
										e.printStackTrace();
									}
									
									
									
								}

								

								
						
						
						
						
						
}
