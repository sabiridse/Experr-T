package gruopAddExcept;

import all_classes.Experr;
import all_classes.TextFild;

public class AddDelExceptTerm {

	private String data = Experr.textField_numbexcept.getText();
	private String[] NumbersForExceptTerm;
	
			public void groupAddDel(int triger){
				
				TextFild tf = new TextFild();
				
				NumbersForExceptTerm = data.split(" ");
				Experr.textField_numbexcept.setText("");
		
						for (int i = 0; i < NumbersForExceptTerm.length; i++){	
							
							
								switch(triger){	
						
									case 1: try {

												tf.insert_term_exception(NumbersForExceptTerm[i], Experr.textField_nameexcept.getText());// ADD
												break;
											} catch (Exception e) {						
												e.printStackTrace();
											}
											
									case 0: try {
												tf.delete_term_exception(NumbersForExceptTerm[i]);// DELETE
												break;
											} catch (Exception e) {						
												e.printStackTrace();
											}
								}	
									
						}
								
					
			}
			
			
}
