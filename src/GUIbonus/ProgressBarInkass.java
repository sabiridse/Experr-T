package GUIbonus;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import all_classes.Experr;
import inkass.DataForInkass;

public class ProgressBarInkass{
	public static JProgressBar progressBar_inkass;
	
	public void show(){
			progressBar_inkass = new JProgressBar();
		 	progressBar_inkass.setStringPainted(true);
	        progressBar_inkass.setForeground(Color.GREEN);
	        Experr.panel_23.add(progressBar_inkass, "cell 3 0,grow");
	        progressBar_inkass.setMaximum(100);
	        progressBar_inkass.setVisible(true);		
	}
	
	public void setValue(int value){
		progressBar_inkass.setValue(value);
		progressBar_inkass.repaint();
		
	}
	
	public void doNotShow(){
		progressBar_inkass.setVisible(false);
	}
	

}
