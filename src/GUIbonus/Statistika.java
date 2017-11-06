package GUIbonus;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import all_classes.Experr;

import javax.swing.JSeparator;
import java.awt.Window.Type;
import java.util.List;

public class Statistika extends JFrame {
	
	
	public void showStat (List <String> ArraySummInkass) {
	
		JFrame frame = new JFrame();     
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Experr.directory_res + "Ex5.png"));
		frame.setTitle("Статистика по маршрутам инкассации");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(500, 450, 655, 350);
		
		JPanel panel_statistika = new JPanel();
		panel_statistika.setBackground(new Color(153, 204, 255));		
		panel_statistika.setLayout(null);
		setContentPane(panel_statistika);
		frame.getContentPane().add(panel_statistika);
		
		frame.setVisible(true);
		panel_statistika.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Маршрут 11");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 94, 30);
		panel_statistika.add(lblNewLabel);
		
		JLabel label = new JLabel("Маршрут 12");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 54, 94, 30);
		panel_statistika.add(label);
		
		JLabel label_1 = new JLabel("Маршрут 51");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 95, 94, 30);
		panel_statistika.add(label_1);
		
		JLabel label_2 = new JLabel("Маршрут 52");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 136, 94, 30);
		panel_statistika.add(label_2);
		
		JLabel label_3 = new JLabel("Маршрут 61");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 177, 94, 30);
		panel_statistika.add(label_3);
		
		JLabel label_4 = new JLabel("Маршрут 62");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 218, 94, 30);
		panel_statistika.add(label_4);
		
		JLabel label_12 = new JLabel("Маршрут 41");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_12.setBounds(237, 11, 94, 30);
		panel_statistika.add(label_12);
		
		JLabel label_13 = new JLabel("Маршрут 42");
		label_13.setHorizontalAlignment(SwingConstants.LEFT);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_13.setBounds(237, 52, 94, 30);
		panel_statistika.add(label_13);
		
		JLabel label_14 = new JLabel("Маршрут 81");
		label_14.setHorizontalAlignment(SwingConstants.LEFT);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_14.setBounds(237, 95, 94, 30);
		panel_statistika.add(label_14);
		
		JLabel label_15 = new JLabel("Маршрут 82");
		label_15.setHorizontalAlignment(SwingConstants.LEFT);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15.setBounds(237, 136, 94, 30);
		panel_statistika.add(label_15);
		
		JLabel label_16 = new JLabel("Маршрут 91");
		label_16.setHorizontalAlignment(SwingConstants.LEFT);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_16.setBounds(237, 177, 94, 30);
		panel_statistika.add(label_16);
		
		JLabel label_17 = new JLabel("Маршрут 92");
		label_17.setHorizontalAlignment(SwingConstants.LEFT);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_17.setBounds(237, 218, 94, 30);
		panel_statistika.add(label_17);
		
		JLabel label_24 = new JLabel("Маршрут 4А1");
		label_24.setHorizontalAlignment(SwingConstants.LEFT);
		label_24.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_24.setBounds(463, 11, 98, 30);
		panel_statistika.add(label_24);
		
		JLabel label_26 = new JLabel("Маршрут 4А2");
		label_26.setHorizontalAlignment(SwingConstants.LEFT);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_26.setBounds(463, 54, 98, 30);
		panel_statistika.add(label_26);
		
		JLabel label_27 = new JLabel("Маршрут 8А1");
		label_27.setHorizontalAlignment(SwingConstants.LEFT);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_27.setBounds(463, 95, 98, 30);
		panel_statistika.add(label_27);
		
		JLabel label_28 = new JLabel("Маршрут 8А2");
		label_28.setHorizontalAlignment(SwingConstants.LEFT);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_28.setBounds(463, 136, 98, 30);
		panel_statistika.add(label_28);
		
		JLabel label_29 = new JLabel("Маршрут 9А1");
		label_29.setHorizontalAlignment(SwingConstants.LEFT);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_29.setBounds(463, 177, 98, 30);
		panel_statistika.add(label_29);
		
		JLabel label_30 = new JLabel("Маршрут 9А2");
		label_30.setHorizontalAlignment(SwingConstants.LEFT);
		label_30.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_30.setBounds(463, 218, 98, 30);
		panel_statistika.add(label_30);
		
		JLabel label_10 = new JLabel("Итого СПб");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBounds(10, 259, 94, 30);
		panel_statistika.add(label_10);
		
		JLabel label_36 = new JLabel("Итого ЛО");
		label_36.setHorizontalAlignment(SwingConstants.LEFT);
		label_36.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_36.setBounds(351, 259, 94, 30);
		panel_statistika.add(label_36);
//******************************************************************		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 634, 1);
		panel_statistika.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 83, 634, 1);
		panel_statistika.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 124, 634, 1);
		panel_statistika.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 164, 634, 1);
		panel_statistika.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 206, 634, 1);
		panel_statistika.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 247, 634, 1);
		panel_statistika.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(208, 11, 2, 290);
		panel_statistika.add(separator_6);
		
//**********************************************************************		
		JLabel label_M11 = new JLabel(ArraySummInkass.get(0));
		label_M11.setHorizontalAlignment(SwingConstants.CENTER);
		label_M11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_M11.setBounds(114, 11, 77, 30);
		panel_statistika.add(label_M11);				
		
			JLabel label_M12 = new JLabel(ArraySummInkass.get(1));
			label_M12.setHorizontalAlignment(SwingConstants.CENTER);
			label_M12.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_M12.setBounds(114, 52, 77, 30);
			panel_statistika.add(label_M12);
		
				JLabel label_M51 = new JLabel(ArraySummInkass.get(2));
				label_M51.setHorizontalAlignment(SwingConstants.CENTER);
				label_M51.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_M51.setBounds(114, 95, 77, 30);
				panel_statistika.add(label_M51);
		
					JLabel label_M52 = new JLabel(ArraySummInkass.get(3));
					label_M52.setHorizontalAlignment(SwingConstants.CENTER);
					label_M52.setFont(new Font("Tahoma", Font.PLAIN, 14));
					label_M52.setBounds(114, 136, 77, 30);
					panel_statistika.add(label_M52);
		
				JLabel label_M61 = new JLabel(ArraySummInkass.get(4));
				label_M61.setHorizontalAlignment(SwingConstants.CENTER);
				label_M61.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_M61.setBounds(114, 177, 77, 30);
				panel_statistika.add(label_M61);
		
			JLabel label_M62 = new JLabel(ArraySummInkass.get(5));
			label_M62.setHorizontalAlignment(SwingConstants.CENTER);
			label_M62.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_M62.setBounds(114, 218, 77, 30);
			panel_statistika.add(label_M62);
		
		JLabel label_M41 = new JLabel(ArraySummInkass.get(7));
		label_M41.setHorizontalAlignment(SwingConstants.CENTER);
		label_M41.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_M41.setBounds(341, 11, 77, 30);
		panel_statistika.add(label_M41);
		
			JLabel label_M42 = new JLabel(ArraySummInkass.get(8));
			label_M42.setHorizontalAlignment(SwingConstants.CENTER);
			label_M42.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_M42.setBounds(341, 54, 77, 30);
			panel_statistika.add(label_M42);
		
				JLabel label_M81 = new JLabel(ArraySummInkass.get(9));
				label_M81.setHorizontalAlignment(SwingConstants.CENTER);
				label_M81.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_M81.setBounds(341, 95, 77, 30);
				panel_statistika.add(label_M81);
		
					JLabel label_M82 = new JLabel(ArraySummInkass.get(10));
					label_M82.setHorizontalAlignment(SwingConstants.CENTER);
					label_M82.setFont(new Font("Tahoma", Font.PLAIN, 14));
					label_M82.setBounds(341, 136, 77, 30);
					panel_statistika.add(label_M82);
		
				JLabel label_M91 = new JLabel(ArraySummInkass.get(11));
				label_M91.setHorizontalAlignment(SwingConstants.CENTER);
				label_M91.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_M91.setBounds(341, 177, 77, 30);
				panel_statistika.add(label_M91);
		
			JLabel label_M92 = new JLabel(ArraySummInkass.get(12));
			label_M92.setHorizontalAlignment(SwingConstants.CENTER);
			label_M92.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_M92.setBounds(341, 218, 77, 30);
			panel_statistika.add(label_M92);
						
		JLabel label_M4A1 = new JLabel(ArraySummInkass.get(13));
		label_M4A1.setHorizontalAlignment(SwingConstants.CENTER);
		label_M4A1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_M4A1.setBounds(567, 11, 77, 30);
		panel_statistika.add(label_M4A1);
						
			JLabel label_M4A2 = new JLabel(ArraySummInkass.get(14));
			label_M4A2.setHorizontalAlignment(SwingConstants.CENTER);
			label_M4A2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_M4A2.setBounds(567, 54, 77, 30);
			panel_statistika.add(label_M4A2);
		
				JLabel label_M8A1 = new JLabel(ArraySummInkass.get(15));
				label_M8A1.setHorizontalAlignment(SwingConstants.CENTER);
				label_M8A1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_M8A1.setBounds(567, 95, 77, 30);
				panel_statistika.add(label_M8A1);
		
					JLabel label_M8A2 = new JLabel(ArraySummInkass.get(16));
					label_M8A2.setHorizontalAlignment(SwingConstants.CENTER);
					label_M8A2.setFont(new Font("Tahoma", Font.PLAIN, 14));
					label_M8A2.setBounds(567, 136, 77, 30);
					panel_statistika.add(label_M8A2);
		
				JLabel label_M9A1 = new JLabel(ArraySummInkass.get(17));
				label_M9A1.setHorizontalAlignment(SwingConstants.CENTER);
				label_M9A1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_M9A1.setBounds(567, 177, 77, 30);
				panel_statistika.add(label_M9A1);
		
			JLabel label_M9A2 = new JLabel(ArraySummInkass.get(18));
			label_M9A2.setHorizontalAlignment(SwingConstants.CENTER);
			label_M9A2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_M9A2.setBounds(567, 218, 77, 30);
			panel_statistika.add(label_M9A2);
		
		JLabel label_AllSPb = new JLabel(ArraySummInkass.get(6));
		label_AllSPb.setHorizontalAlignment(SwingConstants.CENTER);
		label_AllSPb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_AllSPb.setBounds(114, 259, 77, 30);
		panel_statistika.add(label_AllSPb);
				
		JLabel label_AllLo = new JLabel(ArraySummInkass.get(19));
		label_AllLo.setHorizontalAlignment(SwingConstants.CENTER);
		label_AllLo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_AllLo.setBounds(444, 259, 77, 30);
		panel_statistika.add(label_AllLo);
		
	}
}
