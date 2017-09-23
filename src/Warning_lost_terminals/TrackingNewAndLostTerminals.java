package Warning_lost_terminals;

import java.util.ArrayList;

import all_classes.BD_write;
import all_classes.Input_csv;
import all_classes.Loging;

public class TrackingNewAndLostTerminals {
	
	private static ArrayList<String> LostTerminals;
	private static ArrayList<String> NewTerminals;
	
	
			public TrackingNewAndLostTerminals(){
				this.initialization();
			}
	

			private  void initialization(){
				
				Find_lost_term flt = new Find_lost_term();
				
				LostTerminals = new ArrayList <String>(flt.getNumberTermIn_terminalsTable());//subArray copy getNumberTermIn_terminalsTable	
				LostTerminals.removeAll(flt.getNumberTermIn_errors33Table());//терминалы не в исключениях,но их нет в ошибках			
				
				NewTerminals = new ArrayList <String>(flt.getNumberTermIn_errors33Table());//subArray copy getNumberTermIn_errors33Table array
				NewTerminals.removeAll(flt.getNumberTermIn_terminalsTable()); // remove 0 except terms
				flt.queryForArray_terminals_table(1);						 // add array numbers terminal except 1
				NewTerminals.removeAll(flt.getNumberTermIn_terminalsTable());//новые терминалы FINISH ARRAY
								
			}	
		
				
					public static ArrayList<String> getLostTerminals() {
						return LostTerminals;
					}
		
		
					public static ArrayList<String> getNewTerminals() {
						return NewTerminals;
					}
			
						public void addNewTermInDB(){
							Loging log = new Loging();
							BD_write bdw = new BD_write();
						
							for (int i = 0 ; i < getNewTerminals().size();i++){
									
									try {
										log.logtext(" NEW term " + NewTerminals.get(i));
										bdw.insert_new_term_only_for_errors(NewTerminals.get(i));
										
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
										log.log(e," new term ");
									}
									
							}
						
						}
				
								public void InsertLostSignalInLostTerm(){
									Loging log = new Loging();
									Input_csv lostHeartBitLostTerm = new Input_csv();
										for (int i = 0 ; i < getLostTerminals().size();i++){										
											
											try {
												log.logtext(" lost term " + getLostTerminals().get(i));												
												lostHeartBitLostTerm.insertLostSignal(getLostTerminals().get(i));
											
											} catch (Exception e) {
												e.printStackTrace();
												
												log.log(e," lost term ");
											}
													
										}
								
								}


								
		
		

	
}
