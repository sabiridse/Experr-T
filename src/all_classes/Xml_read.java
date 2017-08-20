package all_classes;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Xml_read {
	
	public static  String fild,
						  fild_count,
						  driver,
						  host,
						  db,
						  user,
						  path_repo,
						  path_inkass,
						  pass;

    public static String [] read() {
			        try{
								        DocumentBuilder xml= DocumentBuilderFactory.newInstance().newDocumentBuilder();
								        Document doc=xml.parse(new File(Experr.directory_res + "config.xml"));
								        Element rootel=doc.getDocumentElement();
								        Node el=rootel.getFirstChild(); 			        
					        do{
								        	fild = el.getNodeName();
								        	fild_count = el.getTextContent();			        	
							        	if ((fild.contains("#text") != true) & (fild.contains("#comment") != true)) {       	
									            
							        		switch (fild) {
							        		
									        		case "Driver": driver = fild_count; break;					        		
									        		case "host": host = fild_count; break;			        		
									        		case "user": user = fild_count; break;
									        		case "pass": pass = fild_count; break;
									        		case "path_repo": path_repo = fild_count; break;
									        		case "path_inkass": path_inkass = fild_count; break;
							        		}
							        	}             
							            el=el.getNextSibling();			           
						    }while(el!=null);			        
				    }catch(Exception e){}	
			        
			        
			        String [] config = new String [6];
			        config [0] = driver;
			        config [1] = host;
			        config [2] = user;
			        config [3] = pass;
			        config [4] = path_repo;
			        config [5] = path_inkass;
			        return config;

			        
    }
}