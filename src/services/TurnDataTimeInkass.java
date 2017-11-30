package services;


public class TurnDataTimeInkass {

	public String turningString (String input){

		String yyyy = input.substring(6, 10);
		String MM = input.substring(3, 5);
		String dd = input.substring(0, 2);
		String time = input.substring(11, 16);

		if (time.lastIndexOf(":")==4){
			time = time.substring(0,4);
		}
		
		
		String outPut = yyyy + "-" + MM + "-" + dd + " " + time;
		return outPut;
	}
	
	public String rEturningString (String input){
		//2017-10-23 12:06
		String outPut ="" ;
		if (input.compareTo("нет данных") !=0){
			try {
				String yyyy = input.substring(0,4);
				String MM = input.substring(5, 7);
				String dd = input.substring(8, 10);
				outPut = dd + "." + MM + "." + yyyy;
			} catch (Exception e) {
				outPut = "";
			}
		}
		return outPut;
	}
	
}
