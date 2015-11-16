/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by firstIndex and lastIndex codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */
import edu.duke.*;
import java.io.*;

public class TagFinder {
	public String findProtein(String dna) {
		//ovo je uzimamo pocetni index od atg (odakle pocinje trazeni dna)
		int firstIndex = dna.indexOf("atg");
		//ako u stringu nema trazeni pocetni atg, vrati prazan string
		if (firstIndex == -1) {
			return "";
		}
		
		//nadji zadnji tag (tag) od kraja prvog indexa (atg)
		int lastIndex = dna.indexOf("tag", firstIndex+3);

		//ako pozicija gdje je zadnji tag nije dijeljiva sa tri, 
		//promjeni drug tag
		if ((lastIndex - firstIndex) % 3 != 0) {
			lastIndex = dna.indexOf("tag", firstIndex+3);
		}
        //i to radi...   
		if ((lastIndex - firstIndex) % 3 != 0) {
			lastIndex = dna.indexOf("tga", firstIndex+3);
		}
        //do kraja...
		if ((lastIndex - firstIndex) % 3 != 0) {
			lastIndex = dna.indexOf("taa", firstIndex+3);
		}
        //ako je razlika izmedju zadnjeg taga i prvog taga
        //dijeljiva sa tri, vracaj substring od pocetka prvog taga
        //(atg), do kraja drugog taga (xxx + 3)
		if ((lastIndex - firstIndex) % 3 == 0) {
			return dna.substring(firstIndex, lastIndex+3);
		}
        //ako se nista nije naslo, vrati prazan string
		else {
			return "";
		}
	}
	
    public String lastIndexCodon(String dna) {
        //nadji trazeni dna od pocetka do kraja
    	String answer = findProtein(dna);
    	//nadji velicinu stringa
    	int size = answer.length();
    	//string mora imati bar pocetni tag i zavrsni tag
    	if ( size > 6 ) {
    		//size je zadnji index, i oduzmemo - 9 da dobimo prvi index
    		return answer.substring(size - 3, size);
		}
		//ako nista od toga, vrati prazan string
		else 
    		return "";
	}

	public void testing() {
        //prvo odredi dna koji se zadaje
		String dna = "AATGCTAGTTTAAATCTGA";
		
		//stavi ga u lowercase da substring moze lakse ga manipulirati
		dna = dna.toLowerCase();
		
		//otkrij koji je zadnji lastIndexCodon
        String lastIndexCodon = lastIndexCodon(dna);

        //nadji prvi i zadnji indeks 
        int firstIndex = dna.indexOf("atg");
        int lastIndex = dna.indexOf(lastIndexCodon); 
        
        //spremi rezultate
        String result = dna.substring(firstIndex, lastIndex + 3);
        String secResult  = findProtein(dna); 

        //ispisi rezultate
		System.out.println("Result is: " + result);
		System.out.println("Second result is: " + secResult);
	}
}