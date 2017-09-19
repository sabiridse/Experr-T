package export_err;
/*  1:   */ import java.io.File;
/*  2:   */ 
/*  3:   */ public class Files_check
/*  4:   */ {
/*  5: 5 */   String dir = System.getProperty("user.home");
/*  6: 6 */   File export_errors = new File(this.dir + "\\Downloads\\export_errors.csv");
/*  7: 7 */   File terminal_monitoring = new File(this.dir + "\\Downloads\\terminal_monitoring.xls");
/*  8: 8 */   File points_info = new File(this.dir + "\\Downloads\\points_info.xls");
/*  9:   */   
/* 10:   */   public void checking()
/* 11:   */   {
/* 12:13 */    
/* 13:   */     
/* 14:15 */     int triger = 0;
/* 15:   */     
/* 16:   */ 
/* 17:18 */     Boolean e_e = Boolean.valueOf(this.export_errors.exists());
/* 18:19 */     Boolean t_m = Boolean.valueOf(this.terminal_monitoring.exists());
/* 19:20 */     Boolean p_i = Boolean.valueOf(this.points_info.exists());
/* 20:23 */     if (e_e.booleanValue()) {
/* 21:23 */       this.export_errors.delete();
/* 22:   */     }
/* 23:25 */     if (!t_m.booleanValue())
/* 24:   */     {
/* 25:25 */       String txt = "<html><center>Нет файла terminal_monitoring</html>";triger = 1;
/* 26:   */     }
/* 27:27 */     if (!p_i.booleanValue())
/* 28:   */     {
/* 29:27 */       String txt = "<html><center>Нет файла points_info</html>";triger = 1;
/* 30:   */     }
/* 31:30 */     if (triger == 0)
/* 32:   */     {
/* 33:31 */       NewThread_one thone3 = new NewThread_one();
/* 34:32 */       thone3.New_Three();
/* 35:   */     }
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void delete_old()
/* 39:   */   {
/* 40:40 */     this.terminal_monitoring.delete();
/* 41:41 */     this.points_info.delete();
/* 42:   */   }
/* 43:   */ }


/* Location:           C:\Users\ывожпл\Downloads\ExpoErrold\ExpoErrold\EXport\
 * Qualified Name:     Files_check
 * JD-Core Version:    0.7.0.1
 */