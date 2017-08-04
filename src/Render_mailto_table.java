
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


@SuppressWarnings("serial")
public class Render_mailto_table extends JLabel implements TableCellRenderer  
{


  public Component getTableCellRendererComponent(JTable table,
          Object value, boolean isSelected, boolean hasFocus, int row, int column)
  {
	  setText((String) value);
	  setFont(Experr.table.getFont());	
	  setForeground(Color.BLACK);

	 
	  
	switch (column) {
			case 0:try {
				if(((String) value).contains("Центр") == true){setBackground(new Color(255,153,153));setOpaque(true); break;}
				if(((String) value).contains("ПБ") == true){setBackground(new Color(255,153,153));setOpaque(true); break;}
				if(((String) value).contains("ЮЗ") == true){setBackground(new Color(255,153,153));setOpaque(true); break;}
				if(((String) value).contains("Север") == true){setBackground(new Color(255,153,153));setOpaque(true); break;}
				if(((String) value).contains("Коменда") == true){setBackground(new Color(255,153,153));setOpaque(true); break;}
			
			
			
			} catch (Exception e) {}			
			case 1:setBackground(Color.WHITE); break;
			case 2:setBackground(Color.WHITE); break;
				
	}
   
    return this;
  }
}
