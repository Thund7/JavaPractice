import edu.duke.*;
import org.apache.commons.csv.*;

public class zadatakJedan {
	public void listExporters(CSVParser parser, String country) {
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			String export = record.get("Exports");
			if (export.contains(country)) {
				System.out.println(record.get("Country")+": "+record.get("Exports") +
					": " + record.get("Value"));
			}
			else System.out.println("NOT FOUND");
		}
	}

	public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2) {
		for (CSVRecord record : parser) {
			String exports = record.get("Exports");
			if (exports.contains(exportItem1) && exports.contains(exportItem2)) 
				System.out.println(record.get("Country"));
		}
	}

	public int numberOfExporters (CSVParser parser, String exportItem) {
		for (CSVRecord record : parser) {
			String export = record.get("Exports");
			int counter = 0;
			if (export.contains(exportItem))
				return counter;
		}
	}

	public void bigExporters (CSVParser parser, String amount)
	     for (CSVRecord record : parser)  {
	     	String amountS = record.get("Value");
	     	if (amountS.length() > amount.length())
	     		System.out.println(record.get("Country") + " " + record.get("Value"));

	     }

	public void tester() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		listExporters(parser, "tea");
	}
}
