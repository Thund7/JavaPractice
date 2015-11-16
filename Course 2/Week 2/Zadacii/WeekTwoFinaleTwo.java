import java.io.*;
import edu.duke.*;

public class WeekTwoFinaleTwo {
	public StorageResource findURLs(String url) {
		URLResource page = new URLResource(url);
		String source = page.asString();
		StorageResource store = new StorageResource();
		int start = 0;
		while (true) {
			int index = source.indexOf("href=", start);
			if (index == -1) {
				break;
			}
			int firstQuote = index+6; // after href="
			int endQuote = source.indexOf("\"", firstQuote);
			String sub = source.substring(firstQuote, endQuote);
			if (sub.startsWith("http")) {
				store.add(sub);
			}
			start = endQuote + 1;
		}
		return store;
	}

	public int returnDots(String dots) {
		int counter = 0;
		for( int i=0; i<dots.length(); i++ ) {
    		if( dots.charAt(i) == '.' ) {
        	counter++;
    		} 
		}
       return counter;
	}

	public void testURL() {
		StorageResource s1 = findURLs("https://www.whitehouse.gov");
		StorageResource s2 = findURLs("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
		int counter = 0;
		int counterDotCom = 0;
		int counterDotComSlash = 0;
		int counterDot = 0;
		for (String link : s2.data()) {
			System.out.println(link);
			if (link.contains("https")) {
			counter++;
		    }
		    if (link.contains(".com"))
		    	counterDotCom++;
		    if (link.contains(".com") || link.contains(".com/"))
		    	counterDotComSlash++;
		    if (link.contains("."))
		    	counterDot = counterDot + returnDots(link); 
		}
		//System.out.println("size = " + s1.size());
		System.out.println("size = " + s2.size());
	    System.out.println("number of https: " + counter);
	    System.out.println("number of .com: " + counterDotCom);
	    System.out.println("number of .com or .com/" + counterDotComSlash);
	    System.out.println("number of all dots: " + counterDot);
	}
}
