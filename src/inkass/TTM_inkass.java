package inkass;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import org.apache.derby.client.am.DateTime;

import all_classes.BD_write;

public  class TTM_inkass extends AbstractTableModel{

		
	//public static String [] row_row = new String [8];	
	public static int rer =0;
	public static String id_term;
	private static final long serialVersionUID = 5783608448231036221L;
	private static int columnCount = 10;
	public  static ArrayList<ArrayList> dataArrayList;
	
	public TTM_inkass() {
		dataArrayList = new ArrayList<>();		
		for (int i = 0; i < dataArrayList.size(); i ++) {
	
			dataArrayList.add(new ArrayList<>());

		}
				
	}
		
	public Class<?> getColumnClass(int columnIndex) {
	    
					switch (columnIndex){
					
							case 0: return Integer.class;
							case 1: return String.class;
							case 2: return String.class;
							case 3: return String.class;
							case 4: return String.class;
							case 5: return String.class;
							case 6: return String.class;
							case 7: return Integer.class;
							case 8: return String.class;
							case 9: return String.class;
							
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
			case 2: return "Обьект";
			case 3: return "Адрес";
			case 4: return "Режим";
			case 5: return "Агент";
			case 6: return "Маршрут";
			case 7: return "Сумма";
			case 8: return "Дата Инкассации";
			case 9: return "Добавлено";
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
				
		BD_write bdw = new BD_write();		
		String id_term = Integer.toString((int) getValueAt(row, 0));
		String column_name = "";
		ArrayList <String> editable_row = dataArrayList.get(row);
	 	editable_row.set(editable_row.indexOf(editable_row.get(column)), (String) aValue);
	 	
	 	switch (column){
		 	case 2: column_name = "object"; break;
		 	case 3: column_name = "adress"; break;
		 	case 4: column_name = "regim"; break;
		 	case 6:	column_name = "distr_inkass"; break; 	
	 	}	 	
				 try {
					bdw.editCellOfTableInkass(id_term, column_name, editable_row.get(column));
				} catch (Exception e) {
					e.printStackTrace();
				}													
		 
	}
	
	
	public boolean isCellEditable(int row, int column)
    {
      if(column == 2 || column == 3 || column == 4 || column == 6)
      {
        return true;
      }
      return false;
    }
	
	public void addDate(ArrayList row) {
				
		ArrayList rowTable = new ArrayList();
		rowTable = row;
		dataArrayList.add(rowTable);
	}

}
