package all_classes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//*************************преобразование формата ОСМП в нормальный*********
public class Magic_Osmp {

	public static String day,
	   mounth,
	   hour = "0",
	   finaly_time,
	   min,
	   result_time_signal,
	   result_time_last_payment;
	  
	public static int 
						 iday,
						 ihour,
						 imin,
						 index0,
						 index1,
						 index2,
						 index3,
						 index4,
						 index5;
	
	public static long    imounth,
						  curTime,
						  result_time;
	
	public static Magic_Osmp magic_osmp = new Magic_Osmp();
	
	
	public void strings_by_magic (String string_whis_signal, String string_whis_payment){
		
		
		
				magic_osmp.magic(string_whis_signal);
				result_time_signal = magic_osmp.finaly_time;
				
				magic_osmp.magic(string_whis_payment);
				result_time_last_payment = magic_osmp.finaly_time;
		
	}
	
	
	
	
	
	public void magic (String string){
		
		 index0 = string.indexOf("мес");
		 index1 = string.indexOf("д");
		 index2 = string.indexOf("ч");
		 index3 = string.indexOf(",");
		 index4 = string.indexOf("мин");
		 index5 = string.indexOf("и");


if(index0 != -1){//если есть месяц или месяцев			
		mounth = string.substring(0,index0-1);			
} else { mounth = "0";}



		if(index1 != -1){//если есть день или дней			
				if(index1 < 4){day = string.substring(0,index1-1);}//если день в начале	
				if (index1 > 8 && index2 < 16 && index3 < 0){hour = string.substring(index5+1,index1-1);}	//если перед ним месяц а после ничего			
				if (index1 > 8 && index2 < 16 && index3 > 0){day = string.substring(index3+2,index1-1);}	//если перед днем месяц а после еще чтото
		} else { day = "0";}


	
				if(index2 != -1){//если есть часа или часов
						if (index2 < 4){hour = string.substring(0,index2-1);}//если час в начале
						if (index2 > 7 && index2 < 15 && index3 < 0){hour = string.substring(index5+1,index2-1);}
						if (index2 > 7 && index2 < 15 && index3 > 0){hour = string.substring(index3+2,index2-1);}//если перед час есть день					
						if (index2 > 15){hour = string.substring(index1+6,index2-1);}//если есть день и месяц
				} else { hour = "0";}
		

				
						if(index4 != -1){//если есть минут или минута
								if (index4 < 4){min = string.substring(0,index4-1);}//если минут в начале
								else {min = string.substring(index5+1,index4-1);}	//всё остальное привязано к "И"												
						} else { min = "0";}
						

						
			imounth = Long.parseLong(mounth);
			iday = Integer.parseInt(day);
			ihour = Integer.parseInt(hour);
			imin = Integer.parseInt(min);
							
			result_time = imin*60000 + ihour*60000*60 + iday*60000*60*24 + imounth*60000*60*24*30;
			if (result_time == 0){result_time =1209600000;}
			
			curTime = System.currentTimeMillis();//получаю системное впемя в миллисекундах
			
			
	finaly_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime - result_time);//итог обработки
	
	
	
}
	
	public String getTime_to_time(String date_time) {
		
				StringBuffer time_signal1 = new StringBuffer(date_time);	
				SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				String dateTime = "2016-11-01 12:00:00";
				
				
				switch (date_time.length()) {
					
					case 11: 	time_signal1.insert(11, ":00");			
								try {
									Date qqq = format.parse((time_signal1.insert(5, "." + Experr.year)).toString());
									long aa = qqq.getTime();					
									dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aa);
					
								} catch (ParseException e) {
									e.printStackTrace();
								}
					break;
					case 5:  	time_signal1.insert(5, ":00");	
								dateTime = time_signal1.insert(0, Experr.year + "-" + Experr.month+ "-" + Experr.day + " ").toString();
					break;		
								
								
				}		
							return dateTime;
		
	}
	
	
	
	
}
