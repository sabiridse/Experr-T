package test;

import Warning_lost_terminals.Find_lost_term;

public class LookingArraysSize {

	public void look(){
		Find_lost_term flt = new Find_lost_term();
		System.out.println("смотритель видит  terminals размером " + flt.getSizeNumberTermIn_terminalsTable());
		System.out.println("смотритель видит errors33 размером " + flt.getSizeNumberTermIn_errors33Table());
		
	}
	
	
	
}
