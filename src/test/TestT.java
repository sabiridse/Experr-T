package test;

public class TestT {
	
	public  void creatureTerminals(){
		
		TestArrays testArr = new TestArrays();
		
		testArr.add_terminals("1");
		testArr.add_terminals("2");
		testArr.add_terminals("3");
		testArr.add_terminals("4");
		testArr.add_terminals("5");
		testArr.add_terminals("6");
		testArr.add_terminals("7");
		testArr.add_terminals("8");
		testArr.add_terminals("9");
		testArr.add_terminals("10");
		
		
		System.out.println("создал terminals размером " + testArr.size_terminals());
		
		TooTest tot = new TooTest();
		tot.creatureErrors33();
		System.out.println("подтверждаю создание errors33 размером " + testArr.size_errors33());
		
	}
	
	public void printSizeErrors33(){
		
		TestArrays testArr = new TestArrays();
		System.out.println("вижу errors33 размером " + testArr.size_errors33());
	}
	
	
	
	
}	
