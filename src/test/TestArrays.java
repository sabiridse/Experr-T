package test;

import java.util.ArrayList;

public class TestArrays {
	
	private  static ArrayList<String> errors33 = new ArrayList<String>();
	private  static ArrayList<String> terminals = new ArrayList<String>();
	
	
	public ArrayList<String> getErrors33() {
		return errors33;
	}
	
	public ArrayList<String> getTerminals() {
		return terminals;
	}
	
	public void add_errors33(String newValue_errors33){
		
		errors33.add(newValue_errors33);
	}
	
	public void add_terminals(String newValue_terminals){
		
		terminals.add(newValue_terminals);
	}
	
	public int size_terminals(){
		
		return terminals.size();
	}
	
	public int size_errors33(){
		
		return errors33.size();
	}
}
