import edu.duke.*;
import org.apache.commons.csv.*;

public class WeekFourThree {
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

/*	public boolean doesNameRepeats(FileResource fr, CSVRecord reader) {
		int counter = 0;
		int birthsNumbers = Integer.parseInt(reader.get(2));
		for (CSVRecord secondReader : fr.getCSVParser(false)) {
			if(secondReader.get(0).equals(name));
			counter++;
		}
		if (counter > 1)
			return true;
		else
			return false;
	}
*/
	public void totalBirths (FileResource fr) {
		
		int totalBirths = 0;
		int totalGirls = 0;
		int totalBoys = 0;

		int uniqueBirths = 0;
		int uniqueGirls = 0;
		int uniqueBoys = 0;

		String uniqueName = "";
          
		for (CSVRecord reader : fr.getCSVParser(false)) {
			int brojRodjenih = Integer.parseInt(reader.get(2));
			totalBirths += brojRodjenih;

			//---1--- ako se ime ne ponavlja, pokrecemo counter, ako ne, preskacemo counter
			uniqueBirths = uniqueBirths + ( Integer.parseInt(reader.get(2)) - (Integer.parseInt(reader.get(2)) - 1) ) ;

			if(reader.get(1).equals("F"))
				totalGirls += brojRodjenih;
			else
				totalBoys += brojRodjenih;
		}
		System.out.println("Potpuni broj rodjenih: " + totalBirths);
		System.out.println("Broj zenske djece: " + totalGirls);
		System.out.println("Broj muske djece: " + totalBoys);
		System.out.println("Broj svih imena: " + uniqueBirths);
	}

	public void testTotalBirths () {
		FileResource fr = new FileResource();
		totalBirths(fr);
	}
//-------------------------------------------------------------

}