import edu.duke.*;
import org.apache.commons.csv.*;

public class ThirdOneFirstCSVExample {
	public void readFood() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();

		for (CSVRecord record : parser) {
			System.out.print("name: "+ record.get("Name") + "\t");
			System.out.print("favorite color: " + record.get("Favorite Color") +"\t");
			System.out.println("favorite food: " + record.get("Favorite Food") + "\t");

		}
	}
}