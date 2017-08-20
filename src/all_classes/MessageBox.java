package all_classes;
import java.awt.Dialog;
import java.awt.Frame;

public class MessageBox extends Dialog{

	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public MessageBox(String txt, Frame owner, String title) {
		super(owner, title);
		resize(300, 200);
	}


	
}
