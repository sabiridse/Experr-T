package test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import inkass.Marshruts;
import services.CreateTM;
import services.CurientTime;
import services.TurnDataTimeInkass;
import trmlist_report.ObjectName;
import trmlist_report.Update;


public class TestRun {

	public static void main(String[] args) {
		
		
		new CreateTM().creature();
		
		
//		ScriptEngineManager factory = new ScriptEngineManager();
//		ScriptEngine engine = factory.getEngineByName("nashorn");
//		int w=0;
//
//			try {
//				w = engine.eval("var q = n + 3;", "n=2");
//			} catch (ScriptException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			System.out.println(w);
		
	}

}
