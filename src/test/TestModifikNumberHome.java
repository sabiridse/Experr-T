package test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import Osmp_Osmp.FileOperation;
import contextFind.TooManyCriteries;
import export_err.NewThread_one;

public class TestModifikNumberHome {
	
	
	

			public static void main(String[] args) {
				
				try {
					new TestModifikNumberHome().run();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			
			private int modificNumberHome (String input){
				String subStr="";
				int integer;
				
				char [] numberHome = input.toCharArray ();

					for (int i =0; i < numberHome.length; i++){						
								try {
									integer= Integer.parseInt(""+numberHome[i]);								
									subStr = subStr + ""+numberHome[i];
								} catch (Exception e){break;}											
					}
				
				
				return Integer.parseInt(subStr);
			}
			
			private void run() throws IOException{
				
				
				FileOperation fo = new FileOperation();
				
				for (int q =1; q<1000; q++){
					System.out.println(this.modificNumberHome(fo.OpenFile("report.xls").getRow(q).getCell(6).getStringCellValue()));
				}
				
			}
			
			
			
}
	
