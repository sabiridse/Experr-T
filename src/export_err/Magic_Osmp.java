package export_err;
/*  1:   */ import java.text.SimpleDateFormat;
/*  2:   */ 
/*  3:   */ public class Magic_Osmp
/*  4:   */ {
/*  5:   */   public static String day;
/*  6:   */   public static String mounth;
/*  7: 8 */   public static String hour = "0";
/*  8:   */   public static String finaly_time;
/*  9:   */   public static String min;
/* 10:   */   public static String result_time_signal;
/* 11:   */   public static String result_time_last_payment;
/* 12:   */   public static int iday;
/* 13:   */   public static int ihour;
/* 14:   */   public static int imin;
/* 15:   */   public static int index0;
/* 16:   */   public static int index1;
/* 17:   */   public static int index2;
/* 18:   */   public static int index3;
/* 19:   */   public static int index4;
/* 20:   */   public static int index5;
/* 21:   */   public static long imounth;
/* 22:   */   public static long curTime;
/* 23:   */   public static long result_time;
/* 24:29 */   public static Magic_Osmp magic_osmp = new Magic_Osmp();
/* 25:   */   
/* 26:   */   public void strings_by_magic(String string_whis_signal, String string_whis_payment)
/* 27:   */   {
/* 28:36 */     magic_osmp.magic(string_whis_signal);
/* 29:37 */     result_time_signal = finaly_time;
/* 30:   */     
/* 31:39 */     magic_osmp.magic(string_whis_payment);
/* 32:40 */     result_time_last_payment = finaly_time;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void magic(String string)
/* 36:   */   {
/* 37:50 */     index0 = string.indexOf("мес");
/* 38:51 */     index1 = string.indexOf("д");
/* 39:52 */     index2 = string.indexOf("ч");
/* 40:53 */     index3 = string.indexOf(",");
/* 41:54 */     index4 = string.indexOf("мин");
/* 42:55 */     index5 = string.indexOf("и");
/* 43:58 */     if (index0 != -1) {
/* 44:59 */       mounth = string.substring(0, index0 - 1);
/* 45:   */     } else {
/* 46:60 */       mounth = "0";
/* 47:   */     }
/* 48:64 */     if (index1 != -1)
/* 49:   */     {
/* 50:65 */       if (index1 < 4) {
/* 51:65 */         day = string.substring(0, index1 - 1);
/* 52:   */       }
/* 53:66 */       if ((index1 > 8) && (index2 < 16) && (index3 < 0)) {
/* 54:66 */         hour = string.substring(index5 + 1, index1 - 1);
/* 55:   */       }
/* 56:67 */       if ((index1 > 8) && (index2 < 16) && (index3 > 0)) {
/* 57:67 */         day = string.substring(index3 + 2, index1 - 1);
/* 58:   */       }
/* 59:   */     }
/* 60:   */     else
/* 61:   */     {
/* 62:68 */       day = "0";
/* 63:   */     }
/* 64:72 */     if (index2 != -1)
/* 65:   */     {
/* 66:73 */       if (index2 < 4) {
/* 67:73 */         hour = string.substring(0, index2 - 1);
/* 68:   */       }
/* 69:74 */       if ((index2 > 7) && (index2 < 15) && (index3 < 0)) {
/* 70:74 */         hour = string.substring(index5 + 1, index2 - 1);
/* 71:   */       }
/* 72:75 */       if ((index2 > 7) && (index2 < 15) && (index3 > 0)) {
/* 73:75 */         hour = string.substring(index3 + 2, index2 - 1);
/* 74:   */       }
/* 75:76 */       if (index2 > 15) {
/* 76:76 */         hour = string.substring(index1 + 6, index2 - 1);
/* 77:   */       }
/* 78:   */     }
/* 79:   */     else
/* 80:   */     {
/* 81:77 */       hour = "0";
/* 82:   */     }
/* 83:81 */     if (index4 != -1)
/* 84:   */     {
/* 85:82 */       if (index4 < 4) {
/* 86:82 */         min = string.substring(0, index4 - 1);
/* 87:   */       } else {
/* 88:83 */         min = string.substring(index5 + 1, index4 - 1);
/* 89:   */       }
/* 90:   */     }
/* 91:   */     else {
/* 92:84 */       min = "0";
/* 93:   */     }
/* 94:88 */     imounth = Long.parseLong(mounth);
/* 95:89 */     iday = Integer.parseInt(day);
/* 96:90 */     ihour = Integer.parseInt(hour);
/* 97:91 */     imin = Integer.parseInt(min);
/* 98:   */     
/* 99:93 */     result_time = imin * 60000 + ihour * 60000 * 60 + iday * 60000 * 60 * 24 + imounth * 60000L * 60L * 24L * 30L;
/* :0:94 */     if (result_time == 0L) {
/* :1:94 */       result_time = 1209600000L;
/* :2:   */     }
/* :3:96 */     curTime = System.currentTimeMillis();
/* :4:   */     
/* :5:   */ 
/* :6:99 */     finaly_time = new SimpleDateFormat("dd.MM HH:mm").format(Long.valueOf(curTime - result_time));
/* :7:   */   }
/* :8:   */ }


/* Location:           C:\Users\ывожпл\Downloads\ExpoErrold\ExpoErrold\EXport\
 * Qualified Name:     Magic_Osmp
 * JD-Core Version:    0.7.0.1
 */