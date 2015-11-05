import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class zadatakDva {
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

	    public void testHottestInDay () {
        FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
                   " at " + largest.get("TimeEST"));
    }

//-----------------------------granica izmedju toplih i hladnih metoda----------------------------------

    	public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar) {
			if (smallestSoFar == null)
      	  			smallestSoFar =  currentRow;
       		 else {
       			double tempTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
       			double smallest  = Double.parseDouble(smallestSoFar.get("TemperatureF"));
       			if (tempTemperature < smallest)
       				smallestSoFar = currentRow;
       		 }
    	return smallestSoFar;
		}

    public CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord smallestSoFar = null;
		for (CSVRecord currentRow : parser) {
        	smallestSoFar = getSmallestOfTwo(currentRow,smallestSoFar);       
        } 
    return smallestSoFar; 
    }

//--------------


    public String fileWithColdestTemperature() {
		CSVRecord smallestSoFar  = null;
        String fajl = "";
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			smallestSoFar = getSmallestOfTwo(currentRow,smallestSoFar); 
			if (currentRow == smallestSoFar) {
			     fajl = f.toString();    
			     int index = fajl.lastIndexOf("weather");
			     fajl = fajl.substring(index);
			}
		}
	return fajl;
    }

    public void testFileWithColdestTemperature() {
    	FileResource fr = new FileResource("nc_weather/2014/" + fileWithColdestTemperature());
    	CSVRecord smallest = coldestHourInFile(fr.getCSVParser());

		System.out.println("Coldest day was in file " + fileWithColdestTemperature());
	    System.out.println("Coldest temperature on that day was " + smallest.get("TemperatureF"));
	    System.out.println("All the Temperatures on the coldest day were:");
	    for (CSVRecord row : fr.getCSVParser())
	    System.out.println(row.get("DateUTC") + " " + row.get("TemperatureF"));

    }

//--------------    

    	    public void testColdestInDay () {
        FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") +
                   " at " + smallest.get("TimeEST"));
    }
}