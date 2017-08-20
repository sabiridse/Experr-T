package all_classes;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class MyComboModel implements ComboBoxModel
   {
      private List data = new ArrayList();
      private int selected = 0;

      public MyComboModel(List list)
      {
         data = list;
      }

      public void setSelectedItem(Object o)
      {
         selected = data.indexOf(o);
      }

      public Object getSelectedItem()
      {
         return data.get(selected);
      }

      public int getSize()
      {
         return data.size();
      }

      public Object getElementAt(int i)
      {
         return data.get(i);
      }

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}
   }