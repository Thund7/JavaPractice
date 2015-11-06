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

//------------------------------------------5----------------------------------------------

public double averageTemperatureInFile(CSVParser parser) {
      double allTemps = 0;
      double counter = 0;

    for (CSVRecord currentRow : parser) {
        allTemps = allTemps + Double.parseDouble(currentRow.get("TemperatureF"));      
        counter++;

    }
     double average = allTemps / counter;
    
     return average; 
}

public void testAverageTemperatureInFile() {
    FileResource fr = new FileResource();
    double average = averageTemperatureInFile(fr.getCSVParser());
    System.out.println("Average temperature was " + average);
}

//-----------------------------------------------------------------------------------------

//--------------------------------------6--------------------------------------------------

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        CSVRecord highestSoFar = null;
        CSVRecord firstSoFar = null;
        CSVParser noviParser = parser;
        double sakupljac = 0;
        double counter = 0;
        //if (result)

        for (CSVRecord currentRow : parser) {
            if (highestSoFar == null) {
            highestSoFar = getHighestHumidityOfTwo(currentRow, highestSoFar); 
            sakupljac = sakupljac +  Double.parseDouble(currentRow.get("TemperatureF"));
            counter++;
            }
            else if ( Double.parseDouble(highestSoFar.get("Humidity")) < Double.parseDouble(currentRow.get("Humidity"))) {
                sakupljac = 0;
                counter = 0;
            }
            else if (Double.parseDouble(highestSoFar.get("Humidity")) == Double.parseDouble(currentRow.get("Humidity"))) {
            highestSoFar = getHighestHumidityOfTwo(currentRow, highestSoFar); 
                sakupljac = sakupljac + Double.parseDouble(currentRow.get("TemperatureF"));
                counter++;
            }
            else 
            highestSoFar = getHighestHumidityOfTwo(currentRow, highestSoFar); 


            }

            double average = sakupljac / counter;
            if (!(average > 0 && average < 999))
                 return -1;
            else 
            return average;     

        } 
 
         
        
 

public void testAverageTemperatureWithHighHumidityInFile() {
    FileResource fr = new FileResource();
    CSVParser parser  = fr.getCSVParser();
    CSVParser anotherParser = fr.getCSVParser();
    int value = 80;

    double watafak = averageTemperatureWithHighHumidityInFile(parser, value);
    if (watafak == -1)
        System.out.println("No temperatures with that humidity");
    else {
        System.out.println("Average Temp when high Humidity is " + watafak);
        
}
}

public CSVRecord getHighestHumidityOfTwo(CSVRecord currentRow, CSVRecord highestSoFar) {
    


    if (highestSoFar == null)
        highestSoFar =  currentRow;
 
    else {
        String hjumidity = currentRow.get("Humidity");
        double tempHumidity = 0;
    //  if (hjumidity == "NaN")
    //      tempHumidity = 0;
    //  else
            tempHumidity = Double.parseDouble(currentRow.get("Humidity"));

        double highest  = Double.parseDouble(highestSoFar.get("Humidity"));
        if (tempHumidity > highest)
            highestSoFar = currentRow;
        }
   
return highestSoFar;
}
//-----------------------------------------------------------------------------------------

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
        public CSVRecord getLowestHumidityOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar) {
        if (lowestSoFar == null)
                lowestSoFar =  currentRow;
        else if (lowestSoFar == currentRow)
               return lowestSoFar;
         else {
            double tempHumidity = Double.parseDouble(currentRow.get("Humidity"));
            double lowest  = Double.parseDouble(lowestSoFar.get("Humidity"));
            if (tempHumidity < lowest)
                lowestSoFar = currentRow;
         }
   
    return lowestSoFar;
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        CSVRecord firstSoFar = null;
        for (CSVRecord currentRow : parser) {
            lowestSoFar = getLowestHumidityOfTwo(currentRow,lowestSoFar);       
        } 

    return lowestSoFar; 

    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at "+ csv.get("DateUTC"));
    }



//---------------    4

    public CSVRecord lowestHumidityInManyFiles () {
        CSVRecord lowestSoFar  = null;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            lowestSoFar = getLowestHumidityOfTwo(currentRow,lowestSoFar);    
        }
    return lowestSoFar;
    }

        public void testLowestHumidityInManyFiles () {
                CSVRecord lowest = lowestHumidityInManyFiles();
                System.out.println("lowest humidity was " + lowest.get("Humidity") +
                   " at " + lowest.get("DateUTC"));
        }

//---------------

    public void testColdestInDay () {
        FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") +
                   " at " + smallest.get("TimeEST"));
    }
}