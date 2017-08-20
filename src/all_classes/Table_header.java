package all_classes;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//*************************************************ВСТАВЩИК В ФАЙЛ export_erroes***все операции с ним***********************************************
public class Table_header {

	Workbook export_errors = new HSSFWorkbook();
	Sheet sheet1_export = export_errors.createSheet("ОСМП");
	
	Row row1;
	
	Cell cell,
		 cell2,
		 cell3,
		 cell4,
		 cell6;
	
	public Table_header(){
		export_errors = new HSSFWorkbook();
		sheet1_export = export_errors.createSheet("ОСМП");
	
	}
	
	
	public void Sheet_OCMP() throws IOException {  //**********************лист ОСМП  и его шапка**********************************
		

		Row row0 = sheet1_export.createRow(0);			
		
		Cell cell0 = row0.createCell(0);
		cell0.setCellValue("Номер точки");
		
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("Последнее соединение (время)");
		
		Cell cell2 = row0.createCell(2);
		cell2.setCellValue("Последний платеж (время)");
		
		Cell cell3 = row0.createCell(3);
		cell3.setCellValue("Статус купюроприемника");
		
		Cell cell4 = row0.createCell(4);
		cell4.setCellValue("Статус принтера");
		
		Cell cell5 = row0.createCell(5);
		cell5.setCellValue("Статус тачскрина");
		
		
	}
	
	public void Sheet_Pir() throws IOException {//*****************************лист пир и его шапка********************************
		
		
		Sheet sheet2_export = export_errors.createSheet("Пир");
	
		Row row0 = sheet2_export.createRow(0);			
	
		Cell cell0 = row0.createCell(0);
		cell0.setCellValue("Номер точки");
		
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("Последнее соединение (время)");
		
		Cell cell2 = row0.createCell(2);
		cell2.setCellValue("Последний платеж (время)");
		
		Cell cell3 = row0.createCell(3);
		cell3.setCellValue("Статус купюроприемника");
		
		Cell cell4 = row0.createCell(4);
		cell4.setCellValue("Статус принтера");
		
		Cell cell5 = row0.createCell(5);
		cell5.setCellValue("Статус тачскрина");
		
		
	}
	
	
	public void Sheet_Msk() throws IOException {//****************************лист МСК и его шапка************************************
	
		
		Sheet sheet3_export = export_errors.createSheet("МСК");
	
		Row row0 = sheet3_export.createRow(0);			
		
		Cell cell0 = row0.createCell(0);
		cell0.setCellValue("Номер точки");
		
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("Последнее соединение (время)");
		
		Cell cell2 = row0.createCell(2);
		cell2.setCellValue("Последний платеж (время)");
		
		Cell cell3 = row0.createCell(3);
		cell3.setCellValue("Статус купюроприемника");
		
		Cell cell4 = row0.createCell(4);
		cell4.setCellValue("Статус принтера");
		
		Cell cell5 = row0.createCell(5);
		cell5.setCellValue("Статус тачскрина");
				

	}
//***************ВСТАВЩИК данных в лист ОСМП******принимает данные из цикла ОСМП.input data
	
	public void Osmp_input(int i, int triger, String Number_terminal, String Real_time_signal, String Real_time_payment, String string_info_devices){
		   
		
		
		
				this.row1 = sheet1_export.createRow(i);			
				
				this.cell = row1.createCell(0);
				cell.setCellValue(Number_terminal);	
				
				this.cell2 = row1.createCell(1);
				cell2.setCellValue(Real_time_signal);
		 
				this.cell3 = row1.createCell(2);
				cell3.setCellValue(Real_time_payment);
				
				
				if ( triger == 0){
					this.cell4 = row1.createCell(3);
					cell4.setCellValue(string_info_devices);
				
					this.cell4 = row1.createCell(4);
					cell4.setCellValue(string_info_devices);
				}
				
				
				if ( triger == 1){
					this.cell4 = row1.createCell(3);
					cell4.setCellValue(string_info_devices);
				
					this.cell4 = row1.createCell(4);
					cell4.setCellValue("OK");
				}
				
				if ( triger == 2){
					this.cell4 = row1.createCell(3);
					cell4.setCellValue("OK");
				
					this.cell4 = row1.createCell(4);
					cell4.setCellValue(string_info_devices);
				}
				
				
				this.cell6 = row1.createCell(5);
				cell6.setCellValue("OK");       //************ЭТО СТАТУС тачскрина- всегда ОК, если будут приходит реальные статусы - нужно ДОПИЛИТЬ
				
	}
	
	
	public void Osmp_input_2(int z, String string_info_devices){
		
		
		this.row1 = sheet1_export.createRow(z);					
		this.cell4 = row1.createCell(3);
		cell4.setCellValue("БЛу");	
		//System.out.println(z + " " + string_info_devices);
	}
//*******************************************************************************************************	
	public void close(String dir) throws IOException {
		FileOutputStream fos = new FileOutputStream(dir + "\\Downloads\\export_errors.xls");
		export_errors.write(fos);                                                                 // закрытие файла в буфере с сохранением
		fos.close();
	}
	
}
