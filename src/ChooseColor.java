
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ChooseColor extends JFrame{

	private static final long serialVersionUID = 1L;
	private Color setingColor = Color.lightGray;
	
	public Color setColor(){
		setingColor = JColorChooser.showDialog(this, "Выбери цвет поля", setingColor);		
		return setingColor;				
	}
	
}
