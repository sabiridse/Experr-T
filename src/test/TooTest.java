package test;

public class TooTest {

		public  void creatureErrors33(){
				
				TestArrays testArr = new TestArrays();
				
				testArr.add_errors33("1");
				testArr.add_errors33("2");
				testArr.add_errors33("3");
				testArr.add_errors33("4");
				testArr.add_errors33("5");

				
				
				System.out.println("создал errors33 размером " + testArr.size_errors33());
				
				
			}
	
		public void printSizeTerminals(){
			
			TestArrays testArr = new TestArrays();
			System.out.println("вижу terminals размером " + testArr.size_terminals());
		}
}
