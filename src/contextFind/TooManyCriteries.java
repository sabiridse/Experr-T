package contextFind;

import all_classes.Experr;

public class TooManyCriteries {

	private String InputData;
	private String[] SplitInputData;
	private String[] OtputData = new String[5];
	
			public String[] getSplitInputData(){
				
				try {
					InputData = Experr.textField_8.getText();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				SplitInputData = InputData.split(" ");

					switch (SplitInputData.length){
						
							case 1: OtputData[0] = SplitInputData[0];
									OtputData[1] = "";
									OtputData[2] = "";
									OtputData[3] = "";
									OtputData[4] = "";
									break;
									
							case 2: OtputData[0] = SplitInputData[0];
									OtputData[1] = SplitInputData[1];
									OtputData[2] = "";
									OtputData[3] = "";
									OtputData[4] = "";
									break;
							
							case 3: OtputData[0] = SplitInputData[0];
									OtputData[1] = SplitInputData[1];
									OtputData[2] = SplitInputData[2];
									OtputData[3] = "";
									OtputData[4] = "";
									break;
							
							case 4: OtputData[0] = SplitInputData[0];
									OtputData[1] = SplitInputData[1];
									OtputData[2] = SplitInputData[2];
									OtputData[3] = SplitInputData[3];
									OtputData[4] = "";
									break;
							
							case 5: OtputData[0] = SplitInputData[0];
									OtputData[1] = SplitInputData[1];
									OtputData[2] = SplitInputData[2];
									OtputData[3] = SplitInputData[3];
									OtputData[4] = SplitInputData[4];
									break;
					
					}
				
				
				return OtputData;
			}
	
}
