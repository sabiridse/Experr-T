package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurientTime {

	public String getString(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
	}
//	public Date getDate(){
//		Date time_curient = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		long curTime = System.currentTimeMillis();//получаю системное впемя в миллисекундах
//		String curStringDate = new SimpleDateFormat("yyyy-MM-dd").format(curTime - 3600000);//преобразую в СТРОКУ на 60 минут позже настоящего для буфера времени чтоб за 60мин ушла стекер снят после инкассации
//		try {
//			time_curient= sdf.format(time_curient);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} 
//		return time_curient;
//	}
	
}
