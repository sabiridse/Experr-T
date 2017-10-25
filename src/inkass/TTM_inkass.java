package inkass;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import all_classes.BD_write;

public  class TTM_inkass extends AbstractTableModel{

		
	//public static String [] row_row = new String [8];	
	public static int rer =0;
	public static String id_term;
	private static final long serialVersionUID = 5783608448231036221L;
	private static int columnCount = 8;
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

		//String id_term = (String) getValueAt(row, 0);

		
		 if ( getValueAt(row, column) != null) {			 
				 try {
					//bdw.write_others(id_term, others, 2);//*********************update ��������
				} catch (Exception e) {
					e.printStackTrace();
				}													
		 }
		
		 if ( getValueAt(row, column) == null) {		 
				 try {

					//bdw.write_others(id_term, others, 1);//*********************�������� ����� ������ 
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }
		
		 	ArrayList <String> editable_row = dataArrayList.get(row);
		 	editable_row.set(editable_row.indexOf(editable_row.get(column)), (String) aValue);
		 	//editable_row.get(column). = (String) aValue;	
		 
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
