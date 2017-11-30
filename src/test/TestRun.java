package test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import inkass.Marshruts;
import services.CurientTime;
import services.TurnDataTimeInkass;
import trmlist_report.ObjectName;
import trmlist_report.Update;

public class TestRun {

	public static void main(String[] args) {
		
		
		System.out.println(new TurnDataTimeInkass().turningString("01.10.2017 14:15:52"));

		//System.out.println(new ObjectName().cater("Верный (Волхов г., Державина пр-кт., д.38)", "Волхов г (Ленинградская обл/Волховский р-н)"));
		
		    //System.out.println(new Update().addAdressForKassa("Горбунки д (Ленинградская обл/Ломоносовский р-н)", "", "д.16"));
		
		
	}

}
