package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import inkass.Marshruts;
import trmlist_report.ObjectName;
import trmlist_report.Update;

public class TestRun {

	public static void main(String[] args) {
		
//		Marshruts marsh = new 	Marshruts();
//
//		ArrayList <List<String>> sheet = new ArrayList<>();
//		
//		String object = "Продукты";
//		String id = "10273000";
//		String adres = "Невский пр 173";
//
//		sheet.add(Arrays.asList(object, id, adres, "9-21", "ПИР"));
//		sheet.add(Arrays.asList("Пятерочка", "10288222", "Гражданский пр 84", "9-21", "СК"));
//		sheet.add(Arrays.asList("Полушка", "10344553", "Гороховая ул 18", "9-21", "ПИР"));
//		sheet.add(Arrays.asList("Продукты", "10299222", "Московский пр 115", "9-21", "ПИР"));
//		sheet.add(Arrays.asList("Семья", "103852633", "Науки пр 44", "9-21", "СК"));
//		
//
//		marsh.OpenFile();
//		
//		marsh.writeSheet(sheet, 1);
//		marsh.writeSheet(sheet, 2);
//		marsh.writeSheet(sheet, 3);
//		
//		marsh.saveAndClose();
		
		ObjectName om = new ObjectName();
		System.out.println(new ObjectName().getObjectName("Вырица пгт (Ленинградская обл/Гатчинский р-н)"));
		
		
	}

}
