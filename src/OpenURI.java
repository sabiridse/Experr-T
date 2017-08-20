import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenURI {

//	public static void main(String[] args) throws URISyntaxException {
//	    final URI uri = new URI("https://ps.leadermt.ru:4431/server/monitoring/equipment_statuses3.seam?report=points_info");
//	    
//
//	        open(uri);
//	      
//
//	    
//	    }
//	
	
	private static void open(URI uri) {
	    if (Desktop.isDesktopSupported()) {
			      try {
			        Desktop.getDesktop().browse(uri);
			      } catch (IOException e) { /* TODO: error handling */ }
	    } else { /* TODO: error handling */ }
	  }
	
}
