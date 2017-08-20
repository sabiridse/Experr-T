import java.awt.Point;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;

import org.apache.derby.client.am.DateTime;




public class TTM_reg extends AbstractTableModel{
	
	
	public static String [] row_row = new String [10];
	
	public static int rer =0;
	public static String id_term;
	
	//public String[][] terminal;
	
	public	 List <String> row = new ArrayList<String>();
	public	 List<List<String>> term = new ArrayList();


	private static int columnCount = 6;
	public  static ArrayList<String []> dataArrayList;
	
	public TTM_reg() {
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
							case 3: return String.class;
							case 4: return String.class;
							case 5: return String.class;

							
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
			case 2: return "Время ошибки";
			case 3: return "Ошибка";
			case 4: return "Сотрудник";
			case 5: return "Комментарий";
		}
		
			return "";
	}
	
	
	
	

	public Object getValueAt(int rowIndex, int columnIndex) {

//       int rowNum = Experr.table.getRowSorter().convertRowIndexToModel(rowIndex);
//       int rowM = Experr.table.getRowSorter().convertRowIndexToView(rowIndex);
       //System.out.println(rowIndex + " " + rowNum + " " + rowM + " " + dataArrayList.size());
		

		String [] rows = dataArrayList.get(rowIndex);
		
		Experr.table_2.setToolTipText(rows[columnIndex]);//***����������� ��������� ����������� ������
		
        return rows[columnIndex];
		
				

		
	
	}

	
	public void getArr_row(){
		

		id_term = (String)getValueAt(1, 1);
		

		
	}
	
//	private void jTable1MouseMoved(java.awt.event.MouseEvent evt) {
//    if (evt.getSource() instanceof JTable){
//        JTable tb = (JTable)evt.getSource();
//        Point p = evt.getPoint();
//        int column = tb.columnAtPoint(p);
//        int row = tb.rowAtPoint(p);
//        tb.setToolTipText(Experr.model.getValueAt(row, column).toString());
//        tb.getToolTipText();
//    }
//}
	
	
	
	public void setValueAt(Object aValue, int row, int column) {
		
		 	String [] editable_row = dataArrayList.get(row);
			editable_row[column] = (String) aValue;
		 
	}
	
	
	public boolean isCellEditable(int row, int column) {
      
        return true;

    }
	
	public void addDate(String [] row) {
		

		
		String [] rowTable = new String [getColumnCount()];
		rowTable = row;
		dataArrayList.add(rowTable);
		
	}


}