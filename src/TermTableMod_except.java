import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;

import org.apache.derby.client.am.DateTime;




public class TermTableMod_except extends AbstractTableModel{
	
	
	public static String [] row_row = new String [10];
	
	public static int rer =0;
	public static String id_term;
	
	//public String[][] terminal;
	
	public	 List <String> row = new ArrayList<String>();
	public	 List<List<String>> term = new ArrayList();

	private static final long serialVersionUID = 5783608448231036221L;

	private static int columnCount = 5;
	public  static ArrayList<String []> dataArrayList;
	
	public TermTableMod_except() {
		dataArrayList = new ArrayList<String []>();

	
		
		for (int i = 0; i < dataArrayList.size(); i ++) {
	
			dataArrayList.add(new String[getColumnCount()]);

		}
		
		
	}
	
	
	public Class<?> getColumnClass(int columnIndex) {
	    
					switch (columnIndex){
					
							case 0: return Integer.class;
							case 1: return String.class;
							case 2: return String.class;
							case 3: return String.class;
							case 4: return String.class;

							
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
		case 1: return "Терминал";			
		case 2: return "Примечание";
		case 3: return "Маршрут";
		case 4: return "Дата";
		}
		
			return "";
	}
	
	
	
	

	public Object getValueAt(int rowIndex, int columnIndex) {
		String [] rows = dataArrayList.get(rowIndex);
		Experr.table_except.setToolTipText(rows[columnIndex]);
        return rows[columnIndex];	
	}

	
	public void getArr_row(){
		id_term = (String)getValueAt(1, 1);
	}	
	
	public void setValueAt(Object aValue, int row, int column) {	
		 	String [] editable_row = dataArrayList.get(row);
			editable_row[column] = (String) aValue;		 
	}
	
	
	public boolean isCellEditable(int row, int column)
    {
      if(column == 2)
      {
        return true;
      }
      return false;
    }
	
	public void addDate(String [] row) {
				
		String [] rowTable = new String [getColumnCount()];
		rowTable = row;
		dataArrayList.add(rowTable);
		
	}


}