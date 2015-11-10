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

//-----------------totalBirths--------------------------------

	public void totalBirths (FileResource fr) {
		
		int totalBirths = 0;
		int totalGirls = 0;
		int totalBoys = 0;
          
		for (CSVRecord reader : fr.getCSVParser(false)) {
			int brojRodjenih = Integer.parseInt(reader.get(2));
			totalBirths += brojRodjenih;

			if(reader.get(1).equals("F"))
				totalGirls += brojRodjenih;
			else
				totalBoys += brojRodjenih;
		}
		System.out.println("Potpuni broj rodjenih: " + totalBirths);
		System.out.println("Broj zenske djece: " + totalGirls);
		System.out.println("Broj muske djece: " + totalBoys);
	}

	public void testTotalBirths () {
		FileResource fr = new FileResource();
		totalBirths(fr);
	}
//-------------------------------------------------------------

}