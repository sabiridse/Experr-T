package export_err;
/*   1:    */ import java.io.FileInputStream;
/*   2:    */ import java.io.FileOutputStream;
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.util.Iterator;
/*   5:    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*   6:    */ import org.apache.poi.ss.usermodel.Cell;
/*   7:    */ import org.apache.poi.ss.usermodel.Row;
/*   8:    */ import org.apache.poi.ss.usermodel.Sheet;
/*   9:    */ import org.apache.poi.ss.usermodel.Workbook;
/*  10:    */ 
/*  11:    */ public class Pir
/*  12:    */ {
/*  13:    */   String input_data;
/*  14:    */   String string_whis_numberOfterminal;
/*  15:    */   String output_data;
/*  16:    */   static Row row_ex;
/*  17:    */   static Cell cell00;
/*  18:    */   static Sheet sheet_Pir_ex;
/*  19:    */   static Sheet sheet_Pir_imp;
/*  20:    */   static Sheet sheet_poi_inf;
/*  21:    */   
/*  22:    */   public void Pir_read(int rows_in_osmp_import)
/*  23:    */     throws IOException
/*  24:    */   {
/*  25: 28 */     int rows_in_points_info = -1;
/*  26:    */     
/*  27:    */ 
/*  28: 31 */     String dir = System.getProperty("user.home");
/*  29: 32 */     FileInputStream exp_err = new FileInputStream(dir + "\\Downloads\\export_errors.xls");
/*  30: 33 */     Workbook wb_export_error = new HSSFWorkbook(exp_err);
/*  31: 34 */     sheet_Pir_ex = wb_export_error.getSheetAt(0);
/*  32:    */     
/*  33:    */ 
/*  34: 37 */     FileInputStream points_info = new FileInputStream(dir + "\\Downloads\\points_info.xls");
/*  35: 38 */     Workbook wb_poi_inf = new HSSFWorkbook(points_info);
/*  36: 39 */     sheet_poi_inf = wb_poi_inf.getSheetAt(0);
/*  37:    */     
/*  38:    */ 
/*  39:    */ 
/*  40:    */ 
/*  41: 44 */     Iterator<Row> iterator_points_info = sheet_poi_inf.iterator();
/*  42: 45 */     while (iterator_points_info.hasNext())
/*  43:    */     {
/*  44: 46 */       Row row_poi_info = (Row)iterator_points_info.next();
/*  45: 47 */       rows_in_points_info++;
/*  46:    */     }
/*  47: 54 */     Pir pir = new Pir();
/*  48: 57 */     for (int y = rows_in_osmp_import; y < rows_in_osmp_import + rows_in_points_info; y++) {
/*  49: 58 */       pir.Pir_list_create(y);
/*  50:    */     }
/*  51: 63 */     for (int y = rows_in_osmp_import; y < rows_in_osmp_import + rows_in_points_info; y++) {
/*  52: 64 */       pir.Pir_list(y, 0, rows_in_osmp_import);
/*  53:    */     }
/*  54: 66 */     for (int y = rows_in_osmp_import; y < rows_in_osmp_import + rows_in_points_info; y++) {
/*  55: 67 */       pir.Pir_list(y, 1, rows_in_osmp_import);
/*  56:    */     }
/*  57: 69 */     for (int y = rows_in_osmp_import; y < rows_in_osmp_import + rows_in_points_info; y++) {
/*  58: 70 */       pir.Pir_list(y, 2, rows_in_osmp_import);
/*  59:    */     }
/*  60: 72 */     for (int y = rows_in_osmp_import; y < rows_in_osmp_import + rows_in_points_info; y++) {
/*  61: 73 */       pir.Pir_list(y, 3, rows_in_osmp_import);
/*  62:    */     }
/*  63: 75 */     for (int y = rows_in_osmp_import; y < rows_in_osmp_import + rows_in_points_info; y++) {
/*  64: 76 */       pir.Pir_list(y, 4, rows_in_osmp_import);
/*  65:    */     }
/*  66: 78 */     for (int y = rows_in_osmp_import; y < rows_in_osmp_import + rows_in_points_info; y++) {
/*  67: 79 */       pir.Pir_list(y, 5, rows_in_osmp_import);
/*  68:    */     }
/*  69: 83 */     FileOutputStream fos = new FileOutputStream(dir + "\\Downloads\\export_errors.xls");
/*  70: 84 */     wb_export_error.write(fos);
/*  71: 85 */     fos.close();
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void Pir_list(int y, int x, int rows_in_osmp_import)
/*  75:    */   {
/*  76: 95 */     Row row_imp = sheet_poi_inf.getRow(y - rows_in_osmp_import + 1);
/*  77:    */     try
/*  78:    */     {
/*  79: 98 */       this.input_data = row_imp.getCell(x).getStringCellValue();
/*  80:    */     }
/*  81:    */     catch (NullPointerException e)
/*  82:    */     {
/*  83: 99 */       this.input_data = "";
/*  84:    */     }
/*  85:102 */     row_ex = sheet_Pir_ex.getRow(y);
/*  86:103 */     cell00 = row_ex.createCell(x);
/*  87:104 */     cell00.setCellValue(this.input_data);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void Pir_list_create(int y)
/*  91:    */   {
/*  92:110 */     row_ex = sheet_Pir_ex.createRow(y);
/*  93:    */   }
/*  94:    */ }


/* Location:           C:\Users\ывожпл\Downloads\ExpoErrold\ExpoErrold\EXport\
 * Qualified Name:     Pir
 * JD-Core Version:    0.7.0.1
 */