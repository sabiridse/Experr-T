package trmlist_report;

import all_classes.BD_write;

public class ObjectName {

	private String objectName;
			
			public void cater(String input, String city_name){	

				objectName = "нет данных";
				String city ="";
						try {
									Integer.parseInt(input.substring(0, 3));
									objectName = input.substring(input.indexOf(" ")+1, input.indexOf("("));
						} catch(Exception e) {
							  try{
								   objectName = input.substring(0, input.indexOf("("));
							  } catch(Exception ex) {}					  							  
						}
						
						
						
						 if (city_name.contains("Санкт-Петербург")==false & objectName.compareTo("нет данных")!=0){							 
							 //city = city_name.substring(0, city_name.indexOf("(")-1);
							 objectName = city +"., " + objectName;							 
						 }
			}

		public String getObjectName(String id_term, String city_name) {
			this.cater(new BD_write().getName_term(id_term), city_name);
			return objectName.trim();
		}	
	
}
