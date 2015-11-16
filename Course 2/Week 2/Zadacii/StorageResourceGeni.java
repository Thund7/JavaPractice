import edu.duke.*;
import java.io.*;

public class StorageResourceGeni {
public StorageResource printAll(String dna) {       
        
    
        StorageResource storage = new StorageResource();
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
            storage.add(normalDna);
        }
             start = start + 3;
        }
        
        return storage;
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

    public float cgRatio (String dna) {
        FileResource fr = new FileResource("dna/brca1line.fa");
        StorageResource store = new StorageResource();
        int IndexDna = 0;
        while(true) {
            if(IndexDna >= dna.length())
                break;
            char slovo = dna.charAt(IndexDna);
            String slovoString = String.valueOf(slovo);
            store.add(slovoString);
            IndexDna = IndexDna + 1;
        } 
        StorageResource cCounter = new StorageResource();
        cCounter.add("c"); 
        for(String w : store.data()){
            if (cCounter.contains(w))
                cCounter.add(w);
        }

        StorageResource gCounter = new StorageResource();
        gCounter.add("g"); 
        for(String w : store.data()){
            if (gCounter.contains(w))
                gCounter.add(w);
        }

        //System.out.println("cCounter: " +(cCounter.size()-1));
        //System.out.println("gCounter: " + (gCounter.size()-1));
        float cgs = ((cCounter.size() + gCounter.size()) - 2);
        float size = store.size(); 
        float cgRatio = cgs / size;
        //System.out.println("cgRatio: " + cgRatio);
        return cgRatio;
    }  

    public void printGenes(StorageResource sr) {
        
        int numberOfStrings = 0;
        float cgRatio = 0;
        int numberOfCGRatios = 0;
        for (String link : sr.data()) {
            
            if (link.length() > 60) {
            System.out.println("dna: " + link);
            numberOfStrings++; 
            }   
            cgRatio = cgRatio(link);
            if (cgRatio > 0.35) {
            System.out.println("cgRatio: " + link);
            numberOfCGRatios++; 
            }

        }
        System.out.println("number of dna-s: " + numberOfStrings);
        System.out.println("number of cgRatios: " + numberOfCGRatios);
    }

    public void testing() {
        FileResource fr = new FileResource("dna/brca1line.fa");
        String dna  = fr.asString();
        System.out.println("Dna string is: \n" + dna);
        System.out.println(" ");
      
         StorageResource dinamo = new StorageResource();
         dinamo = printAll(dna);
         //printGenes(dinamo);        
         int counter = 0;
         for (String line : dinamo.data()) {
            counter++;}
            System.out.println("counter: " + counter);
        //cgRatio(dna);
        //System.out.println("result: " + lowerSubDna); 
    }
}
