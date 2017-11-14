package inkass;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import all_classes.BD_write;

public class TTMcopyPaste extends AbstractTableModel {
	private static final long serialVersionUID = 3254069490988388770L;
	public static String id_term;
	private static int columnCount = 2;
	public  static ArrayList<ArrayList> dataArrayList;
	
	public TTMcopyPaste() {
		dataArrayList = new ArrayList<>();		
		for (int i = 0; i < dataArrayList.size(); i ++) {
	
			dataArrayList.add(new ArrayList<>());

		}
				
	}
		
	public Class<?> getColumnClass(int columnIndex) {
	    
					switch (columnIndex){
					
							case 0: return String.class;
							case 1: return String.class;							
					}
				return String.class;
	}
	
	public int getColumnCount() {

		return columnCount;
	}

	public int getRowCount() {
		
		return dataArrayList.size();
	}

	
	public String getColumnName ( int columnIndex) {
		
		switch (columnIndex){
			case 0: return "Номер";
			case 1: return "Дата";
		}		
			return "";
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {

		ArrayList rows = dataArrayList.get(rowIndex);		
        return rows.get(columnIndex);
	
	}

	
	public void getArr_row(){
		
		id_term = (String)getValueAt(1, 1);
				
	}	
	
	public void setValueAt(Object aValue, int row, int column) {

		String id_term = Integer.toString((int) getValueAt(row, 0));
		String column_name = "";
		ArrayList <String> editable_row = dataArrayList.get(row);
	 	editable_row.set(editable_row.indexOf(editable_row.get(column)), (String) aValue);
	 			 
	}
	
	
	public boolean isCellEditable(int row, int column) {      
      return false;
    }
	
	public void addDate(ArrayList row) {
				
		ArrayList rowTable = new ArrayList();
		rowTable = row;
		dataArrayList.add(rowTable);

	}

}
