package trmlist_report;

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
			}

		public String getObjectName(String name_term) {
			this.cater(name_term);
			return objectName.trim();
		}	
	
}
