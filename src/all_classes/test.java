package all_classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.Sizes;
import java.awt.Font;

public class test {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		
		String str = "5856689,00";
		
		int pos = str.indexOf(",");
		
		System.out.println(pos);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		tabbedPane.setPreferredSize(new Dimension(450, 300));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		//panel.setPreferredSize(new Dimension(450, 300));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(332, 209, 91, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(10, 11, 91, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(0, 153, 153));
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new MigLayout("", "[46px,shrink 0][81.00px][27.00px][19.00px:n,trailing][182.00px,grow,shrink 0]", "[21px]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel, "cell 0 0,alignx left,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("\u0412\u0441\u0435\u0433\u043E \u043E\u0448\u0438\u0431\u043E\u043A:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1, "cell 1 0,alignx center,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("123");
		panel_2.add(lblNewLabel_2, "cell 2 0,alignx center,aligny center");
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		progressBar.setValue(25);
		panel_2.add(progressBar, "cell 4 0,growx,aligny top");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(0, 153, 153));
		panel_1.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(new Color(0, 153, 153));
		panel_4.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 153, 153));
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBackground(new Color(0, 153, 153));
		panel_7.add(btnNewButton_3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 153, 153));
		panel_6.add(panel_8, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("m");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 70));
		panel_6.add(lblNewLabel_3, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(new Color(0, 153, 153));
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(5, 5, 91, 23);
		panel_5.add(btnNewButton_2);
		
		JButton button = new JButton("New button");
		button.setBounds(5, 39, 88, 23);
		panel_5.add(button);
		
		textField = new JTextField();
		textField.setBounds(5, 73, 86, 20);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(5, 105, 88, 22);
		panel_5.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(5, 157, 86, 22);
		panel_5.add(comboBox_1);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(5, 212, 91, 23);
		panel_5.add(btnNewButton_4);
	}
}
