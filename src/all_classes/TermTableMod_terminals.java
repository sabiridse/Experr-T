package all_classes;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;

import org.apache.derby.client.am.DateTime;




public class TermTableMod_terminals extends AbstractTableModel{
	
	
	public static String [] row_row = new String [10];
	
	public static int rer =0;
	public static String id_term;
	
	//public String[][] terminal;
	
	public	 List <String> row = new ArrayList<String>();
	public	 List<List<String>> term = new ArrayList();

	private static final long serialVersionUID = 5783608448231036221L;

	private static int columnCount = 3;
	public  static ArrayList<String []> dataArrayList;
	
	public TermTableMod_terminals() {
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
		case 2: return "Маршрут";
		}
		
			return "";
	}
	
	
	
	

	public Object getValueAt(int rowIndex, int columnIndex) {
		String [] rows = dataArrayList.get(rowIndex);
		Experr.table_term.setToolTipText(rows[columnIndex]);
        return rows[columnIndex];	
	}

	
	public void getArr_row(){		
		id_term = (String)getValueAt(1, 1);		
	}

	
	//****���������������� ���� �������� ��������� � ����� ����������	� �������\� ���������
	public void setValueAt(Object aValue, int row, int column) {	
		
		
		BD_write bdw = new BD_write();	
		String pole ="";
		int [] groups = new int [4];
		//String name_distr = (String) getValueAt(row, 2);
		String id_term = (String) getValueAt(row, 0);
		
		
			switch (column) {		
					case 1: pole = "name_term";
						try {
							groups = bdw.reqest_in_distrs((String) getValueAt(row, 2));
						} catch (ClassNotFoundException e1) {
						}break;	
					case 2: pole = "name_distr";
						try {
							groups = bdw.reqest_in_distrs((String) aValue);
						} catch (ClassNotFoundException e1) {
						} break;		
			}
		
		String editable = (String) aValue;
		//System.out.println(column+ " " + pole + " " + editable);
		try {
					bdw.edit_pole_terminals(pole, editable, id_term, column, groups);
			} catch (Exception e) {
			}
		
		 	String [] editable_row = dataArrayList.get(row);
			editable_row[column] = (String) aValue;
		 
	}
	
	
	public boolean isCellEditable(int row, int column)
    {
		if(column == 0)
	      {
	        return false;
	      }
        return true;

    }
	
	public void addDate(String [] row) {
		

		
		String [] rowTable = new String [getColumnCount()];
		rowTable = row;
		dataArrayList.add(rowTable);
		
	}


}
