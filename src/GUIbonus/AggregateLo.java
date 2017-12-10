package GUIbonus;


	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import java.awt.BorderLayout;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;

	import all_classes.Experr;
	import all_classes.TermTableModel;
import inkass.TTMaggregatLO;
import inkass.TTMcopyPaste;

	import java.awt.Font;
	import java.awt.Toolkit;
	import java.awt.Color;

	public class AggregateLo extends JFrame{
		public AggregateLo() {
		}
		public static JTable table_aggregate;
		public static TTMaggregatLO model = new TTMaggregatLO();
		
		public void showFrame() {
			
			JFrame frame = new JFrame();     
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
			frame.setTitle("Маршруты ИТ в инкассации на завтра");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setBounds(300, 300, 500, 200);
			frame.setBackground(new Color(102, 102, 255));
			
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table_aggregate = new JTable(model);
			table_aggregate.setBackground(new Color(255, 255, 204));
			table_aggregate.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table_aggregate.setCellSelectionEnabled(true);
			scrollPane.setViewportView(table_aggregate);
			
			frame.setVisible(true);
			panel.setVisible(true);
			
		}	
}
