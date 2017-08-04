
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;


public class Render_string extends JLabel implements TableCellRenderer  
{
  private static final long serialVersionUID = 1L;

  @Override
  public Component getTableCellRendererComponent(JTable table,
          Object value, boolean isSelected, boolean hasFocus, int row, int column)
  {
	  setText((String) value);
	  setFont(Experr.table.getFont());	
	  setForeground(Color.BLACK);


	  
			if (isSelected == false) {
			
					switch (column) {
							case 7:try {if(((String)value).length() > 0){setBackground(new Color(153, 255, 153));setOpaque(true); break;}} catch (Exception e) {}
							case 1:setBackground(new Color(255, 255, 204)); break;
							case 4:try {if(((String) value).contains("OK") != true){setBackground(new Color(255,102,102));setOpaque(true); break;}} catch (Exception e) {}
							case 5:try {if(((String) value).contains("OK") != true){setBackground(new Color(51,153,255));setOpaque(true); break;}} catch (Exception e) {}
							case 6:try {if(((String) value).contains("OK") != true){setBackground(new Color(153,204,155));setOpaque(true); break;}} catch (Exception e) {}			
							case 8:setBackground(new Color(255, 255, 204)); break;
							case 9:setBackground(new Color(255, 255, 204)); break;
								
					}
			}
			
			if (isSelected == true) {setBackground(new Color(153, 204, 204));setOpaque(true);}
				
				
         
			
					return this;
			
	}
}

