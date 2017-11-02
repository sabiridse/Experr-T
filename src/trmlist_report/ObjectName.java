package trmlist_report;

import all_classes.BD_write;

public class ObjectName {

	private String objectName;
			
			private void cater(String input){	

				objectName = "нет данных";				
						try {
									Integer.parseInt(input.substring(0, 3));
									objectName = input.substring(input.indexOf(" ")+1, input.indexOf("("));
						} catch(Exception e) {
							  try{
								   objectName = input.substring(0, input.indexOf("("));
							  } catch(Exception ex) {}					  							  
						}
						
						DistrInkass distrInkass = new DistrInkass();						
						String city_name = distrInkass.getCity_name().substring(0, distrInkass.getCity_name().indexOf("(")-1);
						
						System.out.println(city_name+" "+objectName);
						
						 if (city_name.compareTo("Санкт-Петербург г")!=0){							 
							 objectName = city_name +"., " + objectName;							 
						 }
			}

		public String getObjectName(String id_term) {
			this.cater(new BD_write().getName_term(id_term));
			return objectName.trim();
		}	
	
}
