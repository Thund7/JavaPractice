import edu.duke.*;
import java.io.*;

public class PrimeFinderTwoThree{

    //testira da li je zadani broj prosti broj
	public void isPrime(int num) {
		//prvi dijeljioc
		int div = 2;
        //ako je zadani broj jednako dva, 
        //on je primarni broj
		if (num == 2) {
			return true;
		}

		while (true) {
            //ako nema nikakav ostatak,
            //tj ako je dijeljiv onda nije prosti broj 
			if (num % div ==) {
				return false;
			} 
            
            //absolutno ne kuzim ovaj dio koda
			if (div > Math.sqrt(num))
				break;
			div = div + 1;
		}
	}

	public void testPrimes() {
		//zapamti RangeResource i .sequence
		RangeResource rr = new RangeResource(2,200);
		for (int value : rr.sequence()){
			//ako vraca true
			if (isPrime(value)) {
				System.out.println(value +"\t is prime");
			}
		}
	}
}