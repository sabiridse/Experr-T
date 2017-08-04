import java.awt.Point;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;

import org.apache.derby.client.am.DateTime;




public class TermTableModel extends AbstractTableModel{
	
	
	public static String [] row_row = new String [10];
	
	public static int rer =0;
	public static String id_term;
	
	//public String[][] terminal;
	
//	public	 List <String> row = new ArrayList<String>();
//	public	 List<List<String>> term = new ArrayList();

	private static final long serialVersionUID = 5783608448231036221L;

	private static int columnCount = 10;
	public  static ArrayList<String []> dataArrayList;
	
	public TermTableModel() {
		dataArrayList = new ArrayList<String []>();

	
		
		for (int i = 0; i < dataArrayList.size(); i ++) {
	
			dataArrayList.add(new String[getColumnCount()]);

		}
		
		
	}
	
	
	public Class<?> getColumnClass(int columnIndex) {
	    
					switch (columnIndex){
					
							case 0: return Integer.class;
							case 1: return String.class;
							case 2: return DateTime.class;
							case 3: return DateTime.class;
							case 4: return String.class;
							case 5: return String.class;
							case 6: return String.class;
							case 7: return String.class;
							case 8: return String.class;
							case 9: return DateTime.class;
							
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
			case 2: return "Сигнал";
			case 3: return "Платёж";
			case 4: return "Купюрник";
			case 5: return "Принтер";
			case 6: return "Тач";
			case 7: return "Другое";
			case 8: return "Маршрут";
			case 9: return "Выгрузка";
		}
		
			return "";
	}
	
	
	
	

	public Object getValueAt(int rowIndex, int columnIndex) {

//       int rowNum = Experr.table.getRowSorter().convertRowIndexToModel(rowIndex);
//       int rowM = Experr.table.getRowSorter().convertRowIndexToView(rowIndex);
       //System.out.println(rowIndex + " " + rowNum + " " + rowM + " " + dataArrayList.size());
		

		String [] rows = dataArrayList.get(rowIndex);
		
		Experr.table.setToolTipText(rows[columnIndex]);//***����������� ��������� ����������� ������
		
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
		
		
		
		BD_write bdw = new BD_write();		

		String id_term = (String) getValueAt(row, 0);
		String others = (String) aValue;

		
		 if ( getValueAt(row, column) != null) {			 
				 try {
					bdw.write_others(id_term, others, 2);//*********************update ��������
				} catch (Exception e) {
					e.printStackTrace();
				}													
		 }
		
		 if ( getValueAt(row, column) == null) {		 
				 try {

					bdw.write_others(id_term, others, 1);//*********************�������� ����� ������ 
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }
		
		 	String [] editable_row = dataArrayList.get(row);
			editable_row[column] = (String) aValue;
		 
	}
	
	
	public boolean isCellEditable(int row, int column)
    {
      if(column == 7)
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