package GUIbonus;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import all_classes.Experr;
import all_classes.TermTableModel;
import inkass.TTMcopyPaste;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class CopyPasteDataInkass extends JFrame{
	private static final long serialVersionUID = 8978546716428029947L;
	public static JTable table_CopyPaste;
	public static TTMcopyPaste model = new TTMcopyPaste();
	
	public void showFrame() {
		
		JFrame frame = new JFrame();     
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
		frame.setTitle("Дата инкассации выбраных терминалов");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(400, 400, 300, 400);
		frame.setBackground(new Color(102, 102, 255));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		frame.setVisible(true);
		panel.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table_CopyPaste = new JTable(model);
		table_CopyPaste.setBackground(new Color(255, 255, 204));
		table_CopyPaste.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_CopyPaste.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table_CopyPaste);
		
		
		
	}	
	
}
