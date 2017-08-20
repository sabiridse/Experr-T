package all_classes;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;

import org.apache.derby.client.am.DateTime;




public class TermTableModel_1 extends AbstractTableModel{
	
	
	public static String [] row_row = new String [10];
	
	public static int rer =0;
	public static String id_term;
	
	//public String[][] terminal;
	
	public	 List <String> row = new ArrayList<String>();
	public	 List<List<String>> term = new ArrayList();

	private static final long serialVersionUID = 5783608448231036221L;

	private static int columnCount = 3;
	public  static ArrayList<String []> dataArrayList;
	
	public TermTableModel_1() {
		dataArrayList = new ArrayList<String []>();

	
		
		for (int i = 0; i < dataArrayList.size(); i ++) {
	
			dataArrayList.add(new String[getColumnCount()]);

		}
		
		
	}
	
	
	public Class<?> getColumnClass(int columnIndex) {
	    
					switch (columnIndex){
					
							case 0: return String.class;
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
		case 0: return "Маршрут";
		case 1: return "Сотрудник";
		case 2: return "Почта";
		}
		
			return "";
	}
	
	
	
	

	public Object getValueAt(int rowIndex, int columnIndex) {


		String [] rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
	
	}

	
	public void getArr_row(){
		

		id_term = (String)getValueAt(1, 1);
		

		
	}
	
	
	
	
	
	public void setValueAt(Object aValue, int row, int column) {
		
		BD_write bdw = new BD_write();		
		bdw.connect();
		String name_distr = (String) getValueAt(row, 0);
		String name_work = (String) aValue;

		
		String query = "UPDATE mailto set name_work = '" + name_work + "' WHERE name_distr = '" + name_distr + "'";
		
		 if ( getValueAt(row, column) != null) {			 
				 try {
					bdw.write_db(query);//*********************update ��������
				} catch (Exception e) {					e.printStackTrace();
				}													
		 }
		
		 bdw.connect(); 
		 
		 
		 String query1 = "select user_mailto.mailto from user_mailto "
				 		+"where user_mailto.name_work = '" + name_work + "'";
			
		 String mail = bdw.reqest_in_mailto(query1);


		 String query2 = "UPDATE mailto set mailto = '" + mail + "' WHERE name_distr = '" + name_distr + "'";
		 
				try {
					bdw.write_db(query2);
				} catch (Exception e) {System.out.println("55 " +e);}
		
		 	
			
			bdw.connect(); 
			try {
				bdw.reqest_in_db_1();
			} catch (ClassNotFoundException e1) {

			}
			bdw.close_connect();
			
			String [] editable_row = dataArrayList.get(row);
			editable_row[column] = (String) aValue;
	}
	
	
	public boolean isCellEditable(int row, int column)
    {
		if(column == 1)
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