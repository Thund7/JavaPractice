import edu.duke.*;
import java.io.*;

public class Links{

	public void TestingLinks() {
	URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		for (String item : ur.words()) {
			String tempItem = item.toLowerCase();
			int jubito = tempItem.indexOf("youtube.com");	
        	if (jubito != -1) {
 		       	int firstIndex = item.lastIndexOf("\"", jubito);
        		int lastIndex = item.indexOf("\"",jubito + 1); 
        		System.out.println(item.substring(firstIndex+1, lastIndex));
				}
		}
	} 
} 