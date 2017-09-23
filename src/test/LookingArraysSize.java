package test;

import java.util.ArrayList;

public class LookingArraysSize {

	private static ArrayList<String[]> Array1 = new ArrayList <String []>();
	
	public void setValue(String numberTerm, String summ){

		Array1.add(new String[]{numberTerm,summ});
		
	}
	
	
		public String[] getNumberTermWhithSumm(int index){
			
			return Array1.get(index);
		}
	
			public void add(){
					
					this.setValue("10273000", "76352");
					this.setValue("10273001", "211");
					this.setValue("10273002", "39888");
					this.setValue("10273003", "555567");
					this.setValue("10273004", "100288");

				
			}
			
			public void test(){
				
				this.add();
				
				for (int i=0;i<5;i++){
					
					 System.out.println(this.getNumberTermWhithSumm(i)[0]+" "+this.getNumberTermWhithSumm(i)[1]);
				}
				
			}
			
}
