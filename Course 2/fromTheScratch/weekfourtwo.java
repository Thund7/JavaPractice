import edu.duke.*;
import org.apache.commons.csv.*;

public class weekfourtwo {

	public void printNames() {
		FileResource fr  = new FileResource();
		CSVParser parser  = fr.getCSVParser(false);

		for(CSVRecord record : parser) {
			int numero = Integer.parseInt(record.get(2));
			if (numero <= 100) {
			System.out.println("ime bebe: " + record.get(0) + "    \t" +
								"spol: " + record.get(1) + "    \t" +
								"broj istih imena u godini: " + record.get(2));
			}
		}
	}
}