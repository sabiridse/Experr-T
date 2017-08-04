
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class Render_time extends JLabel implements TableCellRenderer  
{
  private static final long serialVersionUID = 1L;

  @Override
  public Component getTableCellRendererComponent(JTable table,
          Object value, boolean isSelected, boolean hasFocus, int row, int column)
  {
	   	
	    long curTime = System.currentTimeMillis();//получаю системное впемя в миллисекундах
		long time_st = 0;
	    
	    String uu = value.toString();
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    try {
			Date time= format1.parse(uu);
			time_st = time.getTime();
			
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
	    
	    long res = curTime - time_st;

		 
	    
	    
	  //  String rr = setText(value.toString());
	  
	  setText(value.toString());
	  setFont(Experr.table.getFont());	
	  setForeground(Color.BLACK);
	  setBackground(new Color(255, 255, 204));
	  table.setCellSelectionEnabled(true);
	long interval_sign = Experr.days_signal*24*60*60000 + Experr.hours_signal;
	long interval_pay = Experr.days_pay*24*60*60000 + Experr.hours_pay;

	if (isSelected == false){
				switch (column) {
			
						case 2:try {if(res > interval_sign){setBackground(new Color(255, 153, 153));setOpaque(true); break;}} catch (Exception e) {}
						case 3:try {if(res >  interval_pay){setBackground(new Color(255, 153, 153));setOpaque(true); break;}} catch (Exception e) {}
						case 9:setBackground(new Color(255, 255, 204)); break;
							
				}
	}
	if (isSelected == true) {setBackground(new Color(153, 204, 204));setOpaque(true);}
	
    return this;
  }
}

