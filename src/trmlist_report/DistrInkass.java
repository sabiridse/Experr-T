package trmlist_report;

import java.util.ArrayList;
import java.util.List;

import all_classes.BD_write;

public class DistrInkass {

	private static List <String> cityAndStreet = new ArrayList<String>();
	String distr_inkass = "не определено";
			
			public String getDistrInkass (String id_term){
				cityAndStreet.clear();
				BD_write bdw = new BD_write();
				try {
					cityAndStreet = bdw.getCityAndStreet(id_term);
				} catch (Exception e) {
					e.printStackTrace();
				}
					
				if (cityAndStreet.size() > 0){
							
								try {
																		
									distr_inkass = bdw.getDistr_inkass(cityAndStreet.get(0), cityAndStreet.get(1));
								} catch (Exception e) {
									e.printStackTrace();
								}
					
									if ( distr_inkass.compareTo("не определено") == 0){
										
											if (cityAndStreet.get(0).compareTo("Санкт-Петербург г") !=0){
												
												try {
													
													distr_inkass = bdw.getDistr_inkassForLo(cityAndStreet.get(0));
												} catch (Exception e) {
													e.printStackTrace();
												}
												
											}
									}

				}
				
				return distr_inkass;
			}
	
	public void start(String id_term){
		
		this.getDistrInkass(id_term);
		
	}
	
	public String getCity_name(){
		
		return cityAndStreet.get(0);
	}
	
}
