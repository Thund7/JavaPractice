import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class FinalniProjekt {
    public void printNames() {
        FileResource fr = new FileResource();
    
        for(CSVRecord record : fr.getCSVParser(false)) {
            int numero = Integer.parseInt(record.get(2));
            if (numero <= 100) {
            System.out.println("ime bebe: " + record.get(0) + "    \t" +
                                "spol: " + record.get(1) + "    \t" +
                                "broj istih imena u godini: " + record.get(2));
            }
        }
    }

//---------------1--totalBirths--------------------------------

    public void totalBirths (FileResource fr) {
        
        int totalBirths = 0;
        int totalGirls = 0;
        int totalBoys = 0;

        int uniqueBirths = 0;
        int uniqueGirls = 0;
        int uniqueBoys = 0;
        

        for (CSVRecord currentRow : fr.getCSVParser(false)) {
            int brojRodjenih = Integer.parseInt(currentRow.get(2));
            totalBirths += brojRodjenih;

            //---1--- ako se ime ne ponavlja, pokrecemo counter, ako ne, preskacemo counter
            int numberofBirths = Integer.parseInt(currentRow.get(2));
            uniqueBirths = uniqueBirths + ( numberofBirths - (numberofBirths - 1 ));

            if(currentRow.get(1).equals("F")) {
                int numberofGirls = Integer.parseInt(currentRow.get(2));
                totalGirls += brojRodjenih;
                uniqueGirls = uniqueGirls + ( numberofGirls - (numberofGirls - 1 ));
            }
            else {
                int numberofBoys = Integer.parseInt(currentRow.get(2));
                totalBoys += brojRodjenih;
                uniqueBoys = uniqueBoys + ( numberofBoys - (numberofBoys - 1 ));
            }
        }
        System.out.println("Potpuni broj rodjenih: " + totalBirths);
        System.out.println("Broj zenske djece: " + totalGirls);
        System.out.println("Broj muske djece: " + totalBoys);
        System.out.println(" ");
        System.out.println("Broj svih jedinstvenih imena: " + uniqueBirths);
        System.out.println("Broj jedinstvenih imena muske djece: " + uniqueBoys);
        System.out.println("Broj jedinstvenih imena zenske djece: " + uniqueGirls);
    }

    public void testTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
//-------------------------------------------------------------


//-----------------2-------------------------------------------

public int getRank(int year, String name, String gender) {
    String fname = "testing/yob" + year + "short.csv";          
    FileResource fr = new FileResource(fname);
    
    int rank = 0;
    int nameBirths = 0;

    String tempName = "";
        //ako je ime jednako imenu koju trazimo i spolu koju trazimo,
        //parsiramo ime kao rank 1, i kasnije ga podizemo ako nije rank 1  


   // tempName = currentRow.get(0).toString();
    CSVRecord highestNumberOfBirths = null;    

    for (CSVRecord currentRow : fr.getCSVParser(false)) {
        highestNumberOfBirths = getHighestBirthsOfTwo(currentRow,highestNumberOfBirths);
//stao sam na mjestu gdje odredjujem rank
        if (Integer.parseInt(currentRow.get(2)) >= nameBirths && currentRow.get(1).equals(gender)) {
            rank++;
            tempName = currentRow.get(0).toString();
            if (tempName.equals(name))
                 break;
         }
    }
        if (!tempName.equals(name))
            rank = -1;
return rank;     
}
//-----------------------------------------------------------------

//----------------3------------------------------------------------
//ovo cemo analizirati
public String getName(int year, int rank, String gender) {
	String fname = "testing/yob" + year + "short.csv";
	FileResource fr  =new FileResource(fname);
        int highestNameBirths = 0;
        int howManyRanks = 0;
        String name = "";
        int counter = 0;
		for (CSVRecord record : fr.getCSVParser(false)) {
			if(record.get(1).equals(gender) && (rank >= 1) && (!record.get(0).equals(name)) ){
				  if ( highestNameBirths < Integer.parseInt(record.get(2)) )
                  highestNameBirths = Integer.parseInt(record.get(2));    
                  howManyRanks++;  
                  name = record.get(0).toString();
                  if (howManyRanks == rank) 
                  	return name;
			}
		}	
		if (rank > howManyRanks)
				return "NO NAME";


return name;  
}

//-----------------------------------------------------------------


//------------4-----------------------------------------------------
public void whatIsNameInYear(String name, int year, int newYear, String gender) {
	int rank = getRank(year,name,gender);
	String newName = getName(newYear, rank, gender);
	System.out.println(name +" born in "+ year + " would be " + newName +
		" if she was born in " + newYear);
}


//------------------------------------------------------------------

//-------------5----------------------------------------------------
    public CSVRecord totalBirths (FileResource fr, String name, String gender) {
        
        int totalBirths = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        
        int uniqueBirths = 0;
        int uniqueBoys = 0;
        int uniqueGirls = 0;
        CSVRecord dinamo = null;

        for (CSVRecord currentRow : fr.getCSVParser(false)) {
            int brojRodjenih = Integer.parseInt(currentRow.get(2));
            totalBirths += brojRodjenih;

            //---1--- ako se ime ne ponavlja, pokrecemo counter, ako ne, preskacemo counter
            int numberofBirths = Integer.parseInt(currentRow.get(2));
             uniqueBirths = uniqueBirths + ( numberofBirths - (numberofBirths - 1 ));

            if(currentRow.get(1).equals(gender) && currentRow.get(0).equals(name)) {
                int numberofGirls = Integer.parseInt(currentRow.get(2));
                totalGirls += brojRodjenih;
                uniqueGirls = uniqueGirls + ( numberofGirls - (numberofGirls - 1 ));
                dinamo = currentRow;
            }
        }
       return dinamo;
    }

    public int getRank(int year, String name, String gender) {
    String fname = "testing/yob" + year + "short.csv";          
    FileResource fr = new FileResource(fname);
    
    int rank = 0;
    int nameBirths = 0;
//znaci napraviti ne da ti vraca potpuni broj rodjenja, nego csvrecord s najvisim rankom
    String tempName = "";
    CSVRecord highestNumberOfBirths = null;    

    for (CSVRecord currentRow : fr.getCSVParser(false)) {
        highestNumberOfBirths = getHighestBirthsOfTwo(currentRow,highestNumberOfBirths);
//stao sam na mjestu gdje odredjujem rank
        if (Integer.parseInt(currentRow.get(2)) >= nameBirths && currentRow.get(1).equals(gender)) {
            rank++;
            tempName = currentRow.get(0).toString();
            if (tempName.equals(name))
                 break;
         }
    }
        if (!tempName.equals(name))
            rank = -1;
return rank;     
}

    public void yearWithHighestRank(String name, String gender) {
        CSVRecord highestSoFar  = null;
        String fajl = " ";
        int births = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = totalBirths(fr, name, gender);
            highestSoFar = getHighestBirthsOfTwo(currentRow,highestSoFar); 
            if (currentRow == highestSoFar) {
                 fajl = f.toString();    
                 int index = fajl.lastIndexOf("yob");
                 fajl = fajl.substring(index+3,index+7);
            }
        }
    System.out.println("highest rank was " +  getRank(Integer.parseInt(fajl), name, gender) +
                       " in year " + fajl);
    }

    public CSVRecord getHighestBirthsOfTwo(CSVRecord currentRow, CSVRecord highestSoFar) {

    if (highestSoFar == null)
        highestSoFar =  currentRow; 
    else {
        String numberofBirths = currentRow.get(2);
        int tempNumberOfBirths = 0;
            tempNumberOfBirths = Integer.parseInt(currentRow.get(2));

        int highest  = Integer.parseInt(highestSoFar.get(2));
        if (tempNumberOfBirths > highest)
            highestSoFar = currentRow;
        }
   
    return highestSoFar;
    }




//------------------------------------------------------------------
}

  



