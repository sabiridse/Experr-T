package export_err;
/*   1:    */ import java.io.FileInputStream;
/*   2:    */ import java.io.FileNotFoundException;
/*   3:    */ import java.io.IOException;
import java.text.SimpleDateFormat;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.Iterator;

import javenue.csv.Csv;
/*   6:    */ import javenue.csv.Csv.Writer;
/*   7:    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*   8:    */ import org.apache.poi.ss.usermodel.Cell;
/*   9:    */ import org.apache.poi.ss.usermodel.Row;
/*  10:    */ import org.apache.poi.ss.usermodel.Sheet;
/*  11:    */ import org.apache.poi.ss.usermodel.Workbook;
/*  12:    */ 
/*  13:    */ public class Input_csv
/*  14:    */ {
/*  15: 16 */   public static String dir = System.getProperty("user.home");
/*  16:    */   public static Csv.Writer writer1;
				public String StringLastTime1,
							  StringLastTime2;
/*  17:    */   
/*  18:    */   public void open_stream_csv()
/*  19:    */   {
/*  20: 22 */     writer1 = new Csv.Writer(dir + "\\Downloads\\export_errors.csv").delimiter(';');
/*  21:    */   }
/*  22:    */   
/*  23: 26 */   public ArrayList<String> number_term_errors_arr = new ArrayList();
/*  24:    */   String input_data;
/*  25:    */   String string_whis_numberOfterminal;
/*  26:    */   String output_data;
/*  27:    */   static Row row_ex;
/*  28:    */   static Cell cell00;
/*  29:    */   static Sheet sheet_Pir_ex;
/*  30:    */   static Sheet sheet_Pir_imp;
/*  31:    */   static Sheet sheet_poi_inf;
/*  32:    */   
				

/*  33:    */   public void write(int triger, String number_terminal, String time_signal, String time_pay, String string_info_devices)
/*  34:    */   {
/*  35: 50 */     this.number_term_errors_arr.add(number_terminal);
/*  36: 52 */     if (triger == 0) {
/*  37: 55 */       writer1.value(number_terminal).value(time_signal).value(time_pay).value("OK").value("OK").value("OK").newLine();
/*  38:    */     }
/*  39: 59 */     if (triger == 1) {
/*  40: 62 */       writer1.value(number_terminal).value(time_signal).value(time_pay).value(string_info_devices).value("OK").value("OK").newLine();
/*  41:    */     }
/*  42: 65 */     if (triger == 2) {
/*  43: 68 */       writer1.value(number_terminal).value(time_signal).value(time_pay).value("OK").value(string_info_devices).value("OK").newLine();
/*  44:    */     }
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void write_array(String number_term)
/*  48:    */   {
	
					SimpleDateFormat format2 = new SimpleDateFormat("dd.MM HH:mm");
					long curTime = System.currentTimeMillis();//получаю системное впемя в миллисекундах
					StringLastTime1 = new SimpleDateFormat("dd.MM HH:mm").format(curTime - 1455200000 + (int) (Math.random() * 36000000));
					StringLastTime2 = new SimpleDateFormat("dd.MM HH:mm").format(curTime - 1455200000 - (int) (Math.random() * 36000000));
	
/*  49: 79 */     writer1.value(number_term).value(StringLastTime1).value(StringLastTime2).value("OK").value("OK").value("OK").newLine();
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void writePir(String file)
/*  53:    */     throws IOException
/*  54:    */   {
/*  55: 92 */     int rows_in_points_info = 1;
/*  56:    */     
/*  57:    */ 
/*  58:    */  String status_cash;
/*  59:    */  String status_print;
/*  60:    */ 
/*  61:    */ 
/*  62: 99 */     FileInputStream points_info = new FileInputStream(file);
/*  63:100 */     Workbook wb_poi_inf = new HSSFWorkbook(points_info);
/*  64:101 */     sheet_poi_inf = wb_poi_inf.getSheetAt(0);
/*  65:    */     
/*  66:103 */     Iterator<Row> iterator_points_info = sheet_poi_inf.iterator();
/*  67:104 */     while (iterator_points_info.hasNext())
/*  68:    */     {
/*  69:105 */       Row row_poi_info = (Row)iterator_points_info.next();
/*  70:106 */       rows_in_points_info++;
/*  71:    */     }
/*  72:111 */     for (int i = 1; i < rows_in_points_info - 1; i++)
/*  73:    */     {
/*  74:113 */       Row row_imp = sheet_poi_inf.getRow(i);
/*  75:    */       String number_terminal;
/*  76:    */       try
/*  77:    */       {
/*  78:117 */         number_terminal = row_imp.getCell(0).getStringCellValue();
/*  79:    */         
/*  80:    */ 
/*  81:120 */         this.number_term_errors_arr.add(number_terminal);
/*  82:    */       }
/*  83:    */       catch (NullPointerException e)
/*  84:    */       {
/*  85:123 */         number_terminal = "";
/*  86:    */       }
/*  87:    */       String time_signal;
/*  88:    */       try
/*  89:    */       {
/*  90:129 */         time_signal = row_imp.getCell(1).getStringCellValue();
/*  91:    */       }
/*  92:    */       catch (NullPointerException e)
/*  93:    */       {
/*  94:    */        
/*  95:131 */         time_signal = StringLastTime1;
/*  96:    */       }
/*  97:    */       String time_pay;
/*  98:    */       try
/*  99:    */       {
/* 100:136 */         time_pay = row_imp.getCell(2).getStringCellValue();
/* 101:    */       }
/* 102:    */       catch (NullPointerException e)
/* 103:    */       {
/* 104:    */         
/* 105:138 */         time_pay = StringLastTime2;
/* 106:    */       }
/* 107:    */       try
/* 108:    */       {
/* 109:142 */         status_cash = row_imp.getCell(3).getStringCellValue();
/* 110:    */       }
/* 111:    */       catch (NullPointerException e)
/* 112:    */       {
/* 113:    */        
/* 114:143 */         status_cash = "";
/* 115:    */       }
/* 116:    */       try
/* 117:    */       {
/* 118:147 */         status_print = row_imp.getCell(4).getStringCellValue();
/* 119:    */       }
/* 120:    */       catch (NullPointerException e)
/* 121:    */       {
/* 122:    */        
/* 123:149 */         status_print = "";
/* 124:    */       }
/* 125:152 */       status_cash = new String(status_cash.getBytes("utf8"));
/* 126:153 */       status_print = new String(status_print.getBytes("utf8"));
/* 127:    */       
/* 128:155 */       writer1
/* 129:156 */         .value(number_terminal).value(time_signal).value(time_pay)
/* 130:157 */         .value(status_cash).value(status_print).value("OK").newLine();
/* 131:    */     }
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void close_csv()
/* 135:    */     throws FileNotFoundException
/* 136:    */   {
/* 137:167 */     writer1.close();
/* 138:    */   }
/* 139:    */ }


/* Location:           C:\Users\ывожпл\Downloads\ExpoErrold\ExpoErrold\EXport\
 * Qualified Name:     Input_csv
 * JD-Core Version:    0.7.0.1
 */