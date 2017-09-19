package export_err;
 import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*   4:    */ import java.text.ParseException;
/*   5:    */ import java.text.SimpleDateFormat;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.Iterator;
/*   9:    */ import javax.swing.JProgressBar;

import javenue.csv.Csv;
/*  10:    */ import javenue.csv.Csv.Writer;
/*  11:    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*  12:    */ import org.apache.poi.ss.usermodel.Cell;
/*  13:    */ import org.apache.poi.ss.usermodel.Row;
/*  14:    */ import org.apache.poi.ss.usermodel.Sheet;
/*  15:    */ import org.apache.poi.ss.usermodel.Workbook;
/*  16:    */ 
/*  17:    */ public class OSMP
/*  18:    */ {
/*  19:    */   public static Csv.Writer writer_bonus;
/*  20:    */   static Sheet sheet_osmp_import;
/*  21:    */   static Row row;
/*  22:    */   public static int rows_in_osmp_import;
/*  23:    */   public static String Number_terminal;
/*  24:    */   public static String Real_time_payment;
/*  25:    */   public static String Real_time_signal;
/*  26:    */   public static String string_whis_numberOfterminal;
/*  27:    */   public static String string_whis_signal;
/*  28:    */   public static String string_whis_payment;
/*  29:    */   public static String string_info_devices;
/*  30: 31 */  // public static Bonus bonus = new Bonus();
/*  31: 32 */   public static Input_csv input_csv = new Input_csv();
/*  33: 34 */   public static OSMP osmp = new OSMP();
/*  34:    */   
/*  35:    */   public static void Input_Data()
/*  36:    */     throws IOException, ParseException
/*  37:    */   {
/*  38: 40 */     int triger = 0;
/*  39:    */     
/*  40: 42 */     String err0 = "OK";
/*  41: 43 */     String err1 = "Стекер заполнен";String err11 = "РџРµСЂРµРїРѕР»РЅРµРЅРёРµ СЃС‚РµРєР°";//"РџРµСЂРµРїРѕР»РЅРµРЅРёРµ СЃС‚РµРєР°";
/*  42: 44 */     String err2 = "Зажевана купюра";String err21 = "Р—Р°Р¶РµРІР°РЅР° РєСѓРїСЋСЂР°";//"Р—Р°Р¶РµРІР°РЅР° РєСѓРїСЋСЂР°";
/*  43: 45 */     String err3 = "текер снят";String err31 = "РЎС‚РµРє РЅРµ РІСЃС‚Р°РІР»РµРЅ";
/*  44: 46 */     String err4 = "Купюроприемник вернул нераспознанный ответ";String err41 = "Р’РѕР·РјРѕР¶РЅРѕРµ Р·Р°Р¶РµРІС‹РІР°РЅРёРµ";
/*  45: 47 */     String err5 = "Купюроприемник не найден";String err51 = "РћС€РёР±РєР° СЃРѕРµРґРёРЅРµРЅРёСЏ";
/*  46: 48 */     String err6 = "Купюроприемник неисправен";String err61 = "Р’РѕР·РјРѕР¶РЅРѕРµ Р·Р°Р¶РµРІС‹РІР°РЅРёРµ";
/*  47: 49 */     String err7 = "Ошибка связи с купюроприемником";String err71 = "РћС€РёР±РєР° СЃРѕРµРґРёРЅРµРЅРёСЏ";
/*  48: 50 */     String err8 = "Ошибка связи с принтером";String err81 = "РќРµ РЅР° СЃРІСЏР·Рё";
/*  49: 51 */     String err9 = "Принтер не исправен или зажевана бумага";String err91 = "РћС€РёР±РєР°";
/*  50: 52 */     String err10 = "Принтер не найден";String err101 = "РќРµ РЅР° СЃРІСЏР·Рё";
/*  51:    */     
/*  52:    */ 
/*  53:    */ 
/*  54: 56 */     SimpleDateFormat format1 = new SimpleDateFormat();
/*  55:    */     
/*  56: 58 */     long curTime = System.currentTimeMillis();
/*  57: 59 */     String curStringDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Long.valueOf(curTime - 3600000L));
/*  58: 60 */     Date time_curient = format1.parse(curStringDate);
/*  59:    */     
/*  60:    */ 
/*  61: 63 */     rows_in_osmp_import = -1;
/*  62:    */     
/*  63:    */ 
/*  64:    */ 
/*  65:    */ 
/*  66: 68 */     String dir = System.getProperty("user.home");
/*  67:    */     
/*  68: 70 */     FileInputStream Osmp_import = new FileInputStream(dir + "\\Downloads\\terminal_monitoring.xls");
/*  69: 71 */     Workbook wb_osmp_import = new HSSFWorkbook(Osmp_import);
/*  70: 72 */     sheet_osmp_import = wb_osmp_import.getSheetAt(0);
/*  71:    */     
/*  72:    */ 
/*  73:    */ 
/*  74:    */ 
/*  75: 77 */     Iterator<Row> iterator_osmp_import = sheet_osmp_import.iterator();
/*  76: 78 */     while (iterator_osmp_import.hasNext())
/*  77:    */     {
/*  78: 79 */       Row row_osmp_import = (Row)iterator_osmp_import.next();
/*  79: 80 */       rows_in_osmp_import += 1;
/*  80:    */     }
///*  81: 84 */     gui1.creature_prog_bar(rows_in_osmp_import);
///*  82: 85 */     gui1.progressBar.setVisible(true);
/*  83:    */     
/*  84:    */ 
/*  85: 88 */     Magic_Osmp mo = new Magic_Osmp();
/*  86:    */     
/*  87:    */ 
/*  88:    */ 
/*  89:    */ 
/*  90:    */ 
/*  91: 94 */     input_csv.open_stream_csv();
/*  92: 99 */     for (int i = 1; i < rows_in_osmp_import; i++)
/*  93:    */     {
/*  94:102 */       //gui1.runable_progbar(i);
/*  95:    */       
/*  96:    */ 
/*  97:    */ 
/*  98:106 */       row = sheet_osmp_import.getRow(i);
/*  99:    */       
/* 100:108 */       triger = 0;
/* 101:    */       
/* 102:    */ 
/* 103:111 */       string_whis_numberOfterminal = row.getCell(3).getStringCellValue();
/* 104:112 */       Number_terminal = string_whis_numberOfterminal.substring(0, 8);
/* 105:    */       
/* 106:    */ 
/* 107:115 */       string_whis_signal = row.getCell(6).getStringCellValue();
/* 108:    */       
/* 109:117 */       string_whis_payment = row.getCell(7).getStringCellValue();
/* 110:    */       
/* 111:    */ 
/* 112:120 */       mo.strings_by_magic(string_whis_signal, string_whis_payment);
/* 113:    */       
/* 114:    */ 
/* 115:123 */       string_info_devices = row.getCell(8).getStringCellValue();
/* 116:124 */       String incass_time = row.getCell(9).getStringCellValue();
/* 117:126 */       if (incass_time.compareTo("") == 0) {
/* 118:126 */         incass_time = "01.11.2016 12:00:00";
/* 119:    */       }
/* 120:129 */       format1.applyPattern("dd.MM.yyyy HH:mm:ss");
/* 121:130 */       Date time_last_incassation = format1.parse(incass_time);
/* 122:132 */       if (string_info_devices.compareTo("") != 0)
/* 123:    */       {
/* 124:135 */         if (string_info_devices.contains(err1))
/* 125:    */         {
/* 126:135 */           string_info_devices = err11;triger = 1;
/* 127:    */         }
/* 128:136 */         if (string_info_devices.contains(err2))
/* 129:    */         {
/* 130:136 */           string_info_devices = err21;triger = 1;
/* 131:    */         }
/* 132:139 */         if ((time_curient.compareTo(time_last_incassation) == 1) && 
/* 133:140 */           (string_info_devices.contains(err3)))
/* 134:    */         {
/* 135:140 */           string_info_devices = err31;triger = 1;
/* 136:    */         }
/* 137:144 */         if (string_info_devices.contains(err4))
/* 138:    */         {
/* 139:144 */           string_info_devices = err41;triger = 1;
/* 140:    */         }
/* 141:145 */         if (string_info_devices.contains(err5))
/* 142:    */         {
/* 143:145 */           string_info_devices = err51;triger = 1;
/* 144:    */         }
/* 145:146 */         if (string_info_devices.contains(err6))
/* 146:    */         {
/* 147:146 */           string_info_devices = err61;triger = 1;
/* 148:    */         }
/* 149:147 */         if (string_info_devices.contains(err7))
/* 150:    */         {
/* 151:147 */           string_info_devices = err71;triger = 1;
/* 152:    */         }
/* 153:148 */         if (string_info_devices.contains(err8))
/* 154:    */         {
/* 155:148 */           string_info_devices = err81;triger = 2;
/* 156:    */         }
/* 157:149 */         if (string_info_devices.contains(err9))
/* 158:    */         {
/* 159:149 */           string_info_devices = err91;triger = 2;
/* 160:    */         }
/* 161:150 */         if (string_info_devices.contains(err10))
/* 162:    */         {
/* 163:150 */           string_info_devices = err101;triger = 2;
/* 164:    */         }
/* 165:151 */         if (triger == 0) {
/* 166:151 */           string_info_devices = err0;
/* 167:    */         }
/* 168:    */       }
/* 169:    */       else
/* 170:    */       {
/* 171:153 */         string_info_devices = err0;
/* 172:    */       }
/* 173:160 */       if (string_whis_payment.compareTo("") == 0) {
/* 174:161 */         string_whis_payment = "9 дней, 16 часов и58 минут";
/* 175:    */       }
/* 176:177 */       Real_time_signal = Magic_Osmp.result_time_signal;
/* 177:178 */       Real_time_payment = Magic_Osmp.result_time_last_payment;
/* 178:    */       
/* 179:    */ 
/* 180:    */ 
/* 181:    */ 
/* 182:183 */       input_csv.write(triger, Number_terminal, Real_time_signal, Real_time_payment, string_info_devices);
/* 183:    */     }
/* 184:188 */     Osmp_import.close();
/* 185:    */     
/* 186:190 */     String file_points_info = dir + "\\Downloads\\points_info.xls";
/* 187:191 */     input_csv.writePir(file_points_info);
/* 188:    */     
///* 189:193 */     bonus.open_csv_bonus();
///* 190:    */     
///* 191:195 */     osmp.compari_bonus_and_experr_arrs();
///* 192:    */     
///* 193:197 */     osmp.experr_in_bonus();
///* 194:    */     
///* 195:    */ 
///* 196:    */ 
///* 197:201 */     bonus.number_term_bonus_arr.clear();
///* 198:202 */     input_csv.number_term_errors_arr.clear();
/* 199:203 */     input_csv.close_csv();
/* 200:    */     
/* 201:    */ 
/* 202:    */ 
/* 203:207 */     //gui1.progressBar.setVisible(false);
/* 204:    */     
///* 205:209 */     String txt = "<html><center>Файл export_errors готов и лежит в Downloads</html>";
///* 206:210 */     gui1.Gui0(txt);
/* 207:    */     
/* 208:    */ 
///* 209:213 */     Files_check f_c = new Files_check();
///* 210:214 */     f_c.delete_old();
/* 211:    */   }
/* 212:    */   
///* 213:    */   public void compari_bonus_and_experr_arrs()
///* 214:    */   {
///* 215:221 */     String element_bonus_arr = (String)bonus.number_term_bonus_arr.get(0);
///* 216:    */     
///* 217:    */ 
///* 218:224 */     int triger = 0;
///* 219:225 */     int size_bonus_arr = bonus.number_term_bonus_arr.size();
///* 220:226 */     int size_err_arr = input_csv.number_term_errors_arr.size();
///* 221:229 */     for (int z = 0; z < size_bonus_arr; z++)
///* 222:    */     {
///* 223:231 */       triger = 0;
///* 224:233 */       for (int i = 0; i < size_err_arr; i++)
///* 225:    */       {
///* 226:235 */         element_bonus_arr = (String)bonus.number_term_bonus_arr.get(z);
///* 227:236 */         String element_errors_arr = (String)input_csv.number_term_errors_arr.get(i);
///* 228:240 */         if (element_bonus_arr.compareTo(element_errors_arr) == 0)
///* 229:    */         {
///* 230:242 */           triger = 1;
///* 231:243 */           break;
///* 232:    */         }
///* 233:    */       }
///* 234:248 */       if (triger == 0) {
///* 235:248 */         input_csv.write_array(element_bonus_arr);
///* 236:    */       }
///* 237:    */     }
///* 238:    */   }
///* 239:    */   
///* 240:    */   public void experr_in_bonus()
///* 241:    */     throws IOException
///* 242:    */   {
///* 243:259 */     String element_errors_arr = (String)input_csv.number_term_errors_arr.get(0);
///* 244:    */     
///* 245:261 */     int triger = 0;
///* 246:    */     
///* 247:263 */     int size_bonus_arr = bonus.number_term_bonus_arr.size();
///* 248:264 */     int size_err_arr = input_csv.number_term_errors_arr.size();
///* 249:266 */     for (int z = 0; z < size_err_arr; z++)
///* 250:    */     {
///* 251:268 */       triger = 0;
///* 252:270 */       for (int i = 0; i < size_bonus_arr; i++)
///* 253:    */       {
///* 254:272 */         String element_bonus_arr = (String)bonus.number_term_bonus_arr.get(i);
///* 255:273 */         element_errors_arr = (String)input_csv.number_term_errors_arr.get(z);
///* 256:275 */         if (element_bonus_arr.compareTo(element_errors_arr) == 0)
///* 257:    */         {
///* 258:277 */           triger = 1;
///* 259:278 */           break;
///* 260:    */         }
///* 261:    */       }
///* 262:283 */       if (triger == 0) {
///* 263:283 */         bonus.number_term_bonus_arr.add(element_errors_arr);
///* 264:    */       }
///* 265:    */     }
///* 266:287 */     int size_new_bonus = bonus.number_term_bonus_arr.size();
///* 267:288 */     osmp.write_new_bonus(size_new_bonus);
///* 268:    */   }
///* 269:    */   
///* 270:    */   public void write_new_bonus(int size_new_bonus)
///* 271:    */     throws IOException
///* 272:    */   {
///* 273:294 */     //osmp.open_bonus_csv();
///* 274:296 */     for (int i = 0; i < size_new_bonus; i++)
///* 275:    */     {
///* 276:297 */       String number_term_new_bonus = (String)bonus.number_term_bonus_arr.get(i);
///* 277:298 */       osmp.write_bonus_csv(number_term_new_bonus);
///* 278:    */     }
///* 279:301 */     osmp.close_bonus_csv();
///* 280:    */   }
/* 281:    */   
/* 282:    */  
/* 286:    */   
/* 287:    */   public void write_bonus_csv(String number_term)
/* 288:    */   {
/* 289:311 */     writer_bonus.value(number_term).newLine();
/* 290:    */   }
/* 291:    */   
/* 292:    */   public void close_bonus_csv()
/* 293:    */     throws FileNotFoundException
/* 294:    */   {
/* 295:315 */     writer_bonus.close();
/* 296:    */   }
/* 297:    */ }


/* Location:           C:\Users\ывожпл\Downloads\ExpoErrold\ExpoErrold\EXport\
 * Qualified Name:     OSMP
 * JD-Core Version:    0.7.0.1
 */