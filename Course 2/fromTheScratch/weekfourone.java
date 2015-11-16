import edu.duke.*;
import org.apache.commons.csv.*;

public class weekfourone {
	public void readOneFile(int year) {
		//ime stringa koje zelimo uhvatiti
		String fname = "data/yob" + year + ".txt";

		//ime stringa ubacimo u objekt fileresource
		FileResource fr = new FileResource(fname);

		//parsiramo fileresource bez headera u csvparser
		CSVParser parser = fr.getCSVParser(false);

		//za svaki zapis u parseru ispisujemo ime i spol
		for (CSVRecord rec : parser) {
			String name = rec.get(0);
			String gender = rec.get(1);
		}
	}
}