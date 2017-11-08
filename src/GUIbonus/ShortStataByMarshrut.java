package GUIbonus;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import all_classes.Experr;
import inkass.DataForInkass;
import inkass.DopiTerminals;

import javax.swing.JButton;

public class ShortStataByMarshrut extends JFrame{
	
	public void showStata() {
		
		JFrame frame = new JFrame();     
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
		frame.setTitle("Число терминалов в маршрутах при лимите "+Experr.Summlimit+ " руб.");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(400, 400, 450, 350);
		frame.setBackground(new Color(102, 102, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		frame.setVisible(true);
		panel.setVisible(true);
		
		JLabel label_1M = new JLabel("9А1");
		label_1M.setFont(new Font("Century Schoolbook", Font.PLAIN, 30));
		label_1M.setBounds(62, 43, 56, 37);
		panel.add(label_1M);
		
		JLabel label_2M = new JLabel("9А1");
		label_2M.setFont(new Font("Century Schoolbook", Font.PLAIN, 30));
		label_2M.setBounds(142, 43, 56, 37);
		panel.add(label_2M);
		
		JLabel label_3M = new JLabel("9А1");
		label_3M.setFont(new Font("Century Schoolbook", Font.PLAIN, 30));
		label_3M.setBounds(221, 43, 56, 37);
		panel.add(label_3M);
		
		JLabel label_4M = new JLabel("9А1");
		label_4M.setFont(new Font("Century Schoolbook", Font.PLAIN, 30));
		label_4M.setBounds(298, 43, 56, 37);
		panel.add(label_4M);
		
		JLabel label_5M = new JLabel("9А1");
		label_5M.setFont(new Font("Century Schoolbook", Font.PLAIN, 30));
		label_5M.setBounds(376, 43, 56, 37);
		panel.add(label_5M);
								
			JLabel label_CK1 = new JLabel("23");
			label_CK1.setForeground(new Color(0, 102, 255));
			label_CK1.setFont(new Font("Tahoma", Font.PLAIN, 22));
			label_CK1.setHorizontalAlignment(SwingConstants.CENTER);
			label_CK1.setBounds(72, 91, 43, 38);
			panel.add(label_CK1);
			
			JLabel label_CK2 = new JLabel("23");
			label_CK2.setHorizontalAlignment(SwingConstants.CENTER);
			label_CK2.setForeground(new Color(0, 102, 255));
			label_CK2.setFont(new Font("Tahoma", Font.PLAIN, 22));
			label_CK2.setBounds(152, 91, 43, 38);
			panel.add(label_CK2);
			
			JLabel label_CK3 = new JLabel("23");
			label_CK3.setHorizontalAlignment(SwingConstants.CENTER);
			label_CK3.setForeground(new Color(0, 102, 255));
			label_CK3.setFont(new Font("Tahoma", Font.PLAIN, 22));
			label_CK3.setBounds(231, 91, 43, 38);
			panel.add(label_CK3);
			
			JLabel label_CK4 = new JLabel("23");
			label_CK4.setHorizontalAlignment(SwingConstants.CENTER);
			label_CK4.setForeground(new Color(0, 102, 255));
			label_CK4.setFont(new Font("Tahoma", Font.PLAIN, 22));
			label_CK4.setBounds(308, 91, 43, 38);
			panel.add(label_CK4);
			
			JLabel label_CK5 = new JLabel("23");
			label_CK5.setHorizontalAlignment(SwingConstants.CENTER);
			label_CK5.setForeground(new Color(0, 102, 255));
			label_CK5.setFont(new Font("Tahoma", Font.PLAIN, 22));
			label_CK5.setBounds(376, 91, 43, 38);
			panel.add(label_CK5);
			
				JLabel label_PIR1 = new JLabel("23");
				label_PIR1.setHorizontalAlignment(SwingConstants.CENTER);
				label_PIR1.setForeground(new Color(0, 102, 255));
				label_PIR1.setFont(new Font("Tahoma", Font.PLAIN, 22));
				label_PIR1.setBounds(75, 154, 43, 38);
				panel.add(label_PIR1);
				
				JLabel label_PIR2 = new JLabel("23");
				label_PIR2.setHorizontalAlignment(SwingConstants.CENTER);
				label_PIR2.setForeground(new Color(0, 102, 255));
				label_PIR2.setFont(new Font("Tahoma", Font.PLAIN, 22));
				label_PIR2.setBounds(155, 154, 43, 38);
				panel.add(label_PIR2);
				
				JLabel label_PIR3 = new JLabel("23");
				label_PIR3.setHorizontalAlignment(SwingConstants.CENTER);
				label_PIR3.setForeground(new Color(0, 102, 255));
				label_PIR3.setFont(new Font("Tahoma", Font.PLAIN, 22));
				label_PIR3.setBounds(234, 154, 43, 38);
				panel.add(label_PIR3);
				
				JLabel label_PIR4 = new JLabel("23");
				label_PIR4.setHorizontalAlignment(SwingConstants.CENTER);
				label_PIR4.setForeground(new Color(0, 102, 255));
				label_PIR4.setFont(new Font("Tahoma", Font.PLAIN, 22));
				label_PIR4.setBounds(311, 154, 43, 38);
				panel.add(label_PIR4);
				
				JLabel label_PIR5 = new JLabel("23");
				label_PIR5.setHorizontalAlignment(SwingConstants.CENTER);
				label_PIR5.setForeground(new Color(0, 102, 255));
				label_PIR5.setFont(new Font("Tahoma", Font.PLAIN, 22));
				label_PIR5.setBounds(376, 154, 43, 38);
				panel.add(label_PIR5);
			
					JLabel label_SPS1 = new JLabel("23");
					label_SPS1.setHorizontalAlignment(SwingConstants.CENTER);
					label_SPS1.setForeground(new Color(0, 102, 255));
					label_SPS1.setFont(new Font("Tahoma", Font.PLAIN, 22));
					label_SPS1.setBounds(72, 215, 43, 38);
					panel.add(label_SPS1);
													
					JLabel label_SPS2 = new JLabel("23");
					label_SPS2.setHorizontalAlignment(SwingConstants.CENTER);
					label_SPS2.setForeground(new Color(0, 102, 255));
					label_SPS2.setFont(new Font("Tahoma", Font.PLAIN, 22));
					label_SPS2.setBounds(152, 215, 43, 38);
					panel.add(label_SPS2);
					
					JLabel label_SPS3 = new JLabel("23");
					label_SPS3.setHorizontalAlignment(SwingConstants.CENTER);
					label_SPS3.setForeground(new Color(0, 102, 255));
					label_SPS3.setFont(new Font("Tahoma", Font.PLAIN, 22));
					label_SPS3.setBounds(234, 215, 43, 38);
					panel.add(label_SPS3);
					
					JLabel label_SPS4 = new JLabel("23");
					label_SPS4.setHorizontalAlignment(SwingConstants.CENTER);
					label_SPS4.setForeground(new Color(0, 102, 255));
					label_SPS4.setFont(new Font("Tahoma", Font.PLAIN, 22));
					label_SPS4.setBounds(311, 215, 43, 38);
					panel.add(label_SPS4);
					
					JLabel label_SPS5 = new JLabel("23");
					label_SPS5.setHorizontalAlignment(SwingConstants.CENTER);
					label_SPS5.setForeground(new Color(0, 102, 255));
					label_SPS5.setFont(new Font("Tahoma", Font.PLAIN, 22));
					label_SPS5.setBounds(376, 215, 43, 38);
					panel.add(label_SPS5);
		
//***********************************************************************************		
		JButton button_Start = new JButton("Продолжить");
		button_Start.setBackground(new Color(51, 153, 153));
		button_Start.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_Start.setBounds(263, 272, 120, 39);
		panel.add(button_Start);
		
		button_Start.addActionListener(new ActionListener() {
	      	   public void actionPerformed(ActionEvent e) {
	      		   
	      		 frame.setVisible(false);
	     		 panel.setVisible(false);
	      		   
		     		Dopi dopi = new Dopi();
	      		    dopi.showDopi();
	      	   }
		        });
		
		JButton button_Abort = new JButton("Отказаться");
		button_Abort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_Abort.setBackground(new Color(204, 51, 153));
		button_Abort.setBounds(62, 272, 120, 39);
		panel.add(button_Abort);
		
		button_Abort.addActionListener(new ActionListener() {
	      	   public void actionPerformed(ActionEvent e) {
	      		 frame.setVisible(false);
	     		 panel.setVisible(false);
	      	   }
		        });
		
		
		
		
//*************************************************************************************		
		JLabel label_1AG = new JLabel("СК");
		label_1AG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1AG.setBounds(10, 101, 31, 32);
		panel.add(label_1AG);
		
		JLabel label_2AG = new JLabel("ПИР");
		label_2AG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2AG.setBounds(10, 167, 43, 25);
		panel.add(label_2AG);
		
		JLabel label_3AG = new JLabel("СПС");
		label_3AG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3AG.setBounds(10, 215, 43, 32);
		panel.add(label_3AG);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 422, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(52, 49, 2, 212);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 140, 422, 2);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 203, 422, 2);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(128, 49, 2, 212);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(209, 49, 2, 212);
		panel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(287, 49, 2, 212);
		panel.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(364, 49, 2, 212);
		panel.add(separator_7);
		
	}
}
