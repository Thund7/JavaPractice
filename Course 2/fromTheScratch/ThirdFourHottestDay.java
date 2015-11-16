import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class ThirdFourHottestDay {
	public CSVRecord hottestHourInFile(CSVParser parser) {
		CSVRecord largestSoFar = null;
		for (CSVRecord currentRow : parser) {
        	largestSoFar = getLargestOfTwo(currentRow,largestSoFar);       
        } 
    return largestSoFar;    
	}
    
	public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
		if (largestSoFar == null)
        		largestSoFar =  currentRow;
        else {
       		double tempTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
       		double largest  = Double.parseDouble(largestSoFar.get("TemperatureF"));
       		if (tempTemperature > largest)
       			largestSoFar = currentRow;
        }
    return largestSoFar;
	}

	public CSVRecord hottestInManyDays () {
		CSVRecord largestSoFar  = null;

		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
			largestSoFar = getLargestOfTwo(currentRow,largestSoFar);    
		}
	return largestSoFar;
	}

	public void testHottestDay () {
				CSVRecord largest = hottestInManyDays();
				System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				   " at " + largest.get("DateUTC"));
		
	}
}
