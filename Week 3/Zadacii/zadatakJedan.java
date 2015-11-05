import edu.duke.*;
import org.apache.commons.csv.*;

public class zadatakJedan {
    public String listExporters(CSVParser parser, String country) {
        String returnValue = "";
        for (CSVRecord record : parser) {
            String countryS = record.get("Country");
            
            if (countryS.contains(country)) {
                returnValue = record.get("Country")+": "+record.get("Exports") +
                    ": " + record.get("Value (dollars)");                  
            }
        }
        return returnValue;
    }

    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) 
                System.out.println(record.get("Country"));
        }
    }

    public int numberOfExporters (CSVParser parser, String exportItem) {
        int counter = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem))
                counter++;
        }
        return counter;
    }

    public void bigExporters (CSVParser parser, String amount) {
    	 System.out.println("Big exporters: ");
         for (CSVRecord record : parser)  {
            String amountS = record.get("Value (dollars)");
            if (amountS.length() > amount.length())
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
       }     
    }
       
        public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(listExporters(parser, "Nauru"));
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        System.out.println("number of exporters: " + numberOfExporters(parser, "gold"));
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
       
}

