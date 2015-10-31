import edu.duke.*;
import java.io.*;

public class Links {

	public void TestingLinks() {
		URLResource rs = 
		new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
	    for (String item: rs.words()) {
	    	String itemLower = item.toLowerCase();
    int pos = itemLower.indexOf("youtube.com");
	        //String link = ""; 
	        if (pos != -1) {
	        	int beg = item.lastIndexOf("\"", pos);
int end = item.indexOf("\"", pos +1);
System.out.println(item.substring(beg + 1, end));
}
	        }
	}
}

