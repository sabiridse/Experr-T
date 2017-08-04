import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Loging {
	
	public void log(Exception ex, String message) {
	
	PrintWriter log;
    FileWriter logFile;
	
	try {
        logFile = new FileWriter("exceptions.log", true);
        log = new PrintWriter((java.io.Writer)logFile);
    } catch (IOException e) {
        ex.printStackTrace();
        return;
    }
	
	log.printf("\n%s: %s\n", LocalDateTime.now(), message, ex.getMessage());
    ex.printStackTrace(log);
    log.flush();
	
	}
	public void logtext (String message) {
		
		PrintWriter log;
	    FileWriter logFile;
		
		try {
	        logFile = new FileWriter("exceptions.log", true);
	        log = new PrintWriter((java.io.Writer)logFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return;
	    }

		log.println(LocalDateTime.now()+" : "+message);
	
	    log.flush();
		
		}
	
}
