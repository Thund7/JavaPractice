import edu.duke.*;
import java.util.Random;

public class DiceRollingMine {
	public void simpleSimulate (int rolls){
		Random rand = new Random();

		int twos = 0;
		int twelves = 0;

		for (int k = 0; k<rolls; k++) {
			int kocka1 = rand.nextInt(6) + 1;
			int kocka2 = rand.nextInt(6) + 1;

			if (kocka1 + kocka2 == 2)
				twos++;

			if (kocka1 + kocka2 == 12)
				twelves++;
		}

		System.out.println("snakeEyes: " + twos + "\t" +
						 "percentage: " + 100.0 * twos/rolls);
		System.out.println("twelves: " + twelves + "\t" +
						   "percentage: " + 100.0 * twelves/rolls);

	}

		public void simulate (int rolls) {
			
			Random rand = new Random();

			int [] counts = new int[13];

			for (int k = 0; k<rolls; k++) {
				int kocka1 = rand.nextInt(6) + 1;
				int kocka2 = rand.nextInt(6) + 1;
				System.out.println(kocka1 + " + " + 
									kocka2 + " = " + (kocka1+kocka2));
				counts[kocka1 + kocka2] += 1  ;
			}

			for (int k = 2; k<=12; k++) {
				System.out.println  (k + "'s\t" + counts[k] + "\t" +
									100.0 * counts[k]/rolls);
			}
		}
}
