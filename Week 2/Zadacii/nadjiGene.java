import edu.duke.*;
import java.io.*;

public class nadjiGene {
public void printAll(String dna) {		

        String lowerSubDna = dna.toLowerCase(); 
        String normalDna = "";
        System.out.println("Genes are:");
   		int start = 0;
        while (true) {

    		//prvi indeks od atg
    		int tag = lowerSubDna.indexOf("atg", start);
    		//ako atg ne postoji, izadji iz stringa
    		if (tag == -1) {
          	   break;  
    		}
        	
    		//start se pomice 0 prema prvom atg indeksu
    		int end  = findStopIndex(dna, tag+3);
            //nadji end pozivanjem metode findStopIndex  
            //int tempIndex = end;
    		
           
    		if (end != dna.length())
    		{
            //pohrani startCodon i stop Codon
            String startCodon = lowerSubDna.substring(tag, tag+3);
    		String stopCodon = lowerSubDna.substring(end,end+3);
            //ako si dosao do kraja dna, prekidaj 


             System.out.println(startCodon + "- starts at: " + tag);
    		 System.out.println(stopCodon + "- stops at: " +  end  + " - " + stopCodon);
    		normalDna = dna.substring(tag, end + 3);
    		System.out.println(normalDna);
            System.out.println(" ");
            start = end;
        }
    		 
        }
        
        
    }

    //nadji zadnji kodon(e), argumenti su originalni
    //dna i indeks cega vec
    public int findStopIndex(String dna, int index) {
    	//odredi polozaj tga nakon odredjenog indeksa
    	int stop1 = dna.indexOf("tga", index);

    	//ako tga postoji ili ako nije dijeljiv sa tri
    	//vrati totalni dna length  
    	if (stop1 == -1 || (stop1-index) % 3 !=0) {
    		stop1 = dna.length();
    	}
     	
     	//odredi polozaj tga nakon odredjenog indeksa
    	int stop2 = dna.indexOf("taa", index);
    	//ako tga postoji ili ako nije dijeljiv sa tri
    	//vrati totalni dna length 
    	if (stop2 == -1 || (stop2-index) % 3 !=0) {
    		stop2 = dna.length();
    	}

     	//odredi polozaj tga nakon odredjenog indeksa
    	int stop3 = dna.indexOf("tag", index);
    	//ako tga postoji ili ako nije dijeljiv sa tri
    	//vrati totalni dna length 
    	if (stop3 == -1 || (stop3-index) % 3 !=0) {
    		stop3 = dna.length();
    	}
    	return Math.min(stop1, Math.min(stop2,stop3));
    }

    public void testing() {
    	String dna  = "ccatgccctaataaatgtctgtaatgtaga";
        System.out.println("Dna string is: \n" + dna);
        System.out.println(" ");

         printAll(dna);
        //System.out.println("result: " + lowerSubDna); 
    }
}
