package services;

import java.text.SimpleDateFormat;

public class CurientTime {

	public String get(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
	}
	
}
