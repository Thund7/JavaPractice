import java.io.*;
import edu.duke.*;

public class TagFinder{

	public String findSubDna(String dna) {
		int firstIndex = dna.indexOf("tag");
		
		if (firstIndex ==  -1) {
			return "nope";
		}
		
		String tag = "atg";
		int lastIndex = dna.indexOf(tag, firstIndex + 3);

		if ((lastIndex - firstIndex) % 3 != 0) {
			tag = "tga";
		}

		if ((lastIndex - firstIndex) % 3 != 0) {
			tag = "ttg";
		}

		lastIndex = dna.indexOf(tag, firstIndex + 3);

		if ((lastIndex - firstIndex) % 3 == 0) {
			return dna.substring(firstIndex, lastIndex + 3);
		}
		else{
			return "nope";
		} 

	}

    public void testing() {
    	String dna  = "tagxxxyyatgzttg";
        
        String subDna = findSubDna(dna);
        System.out.println("result: " + subDna); 
    }

}