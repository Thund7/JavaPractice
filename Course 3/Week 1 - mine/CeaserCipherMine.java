import edu.duke.*;
import java.io.*;


public class CeaserCipherMine {

	public String encrypt(String input, int key) {
		StringBuilder poruka = new StringBuilder(input);
		String highAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowAlphabet = highAlphabet.toLowerCase();

		String shiftedHighAlphabet = highAlphabet.substring(key) + 
								 highAlphabet.substring(0, key);
		String shiftedlowAlphabet = shiftedHighAlphabet.toLowerCase();

        System.out.println(shiftedHighAlphabet);  

		for (int indexSlova = 0; indexSlova<poruka.length(); indexSlova++) {
			char trenutacnoSlovo = poruka.charAt(indexSlova);
			int indexLowAlph = -1;
			int indexHighAlph = -1;

			//ako nema slova kojeg trazimo u visokoj abecedi,
			// onda spremi indeks trenutacnog slova iz niske abecede
			if (highAlphabet.indexOf(trenutacnoSlovo) == -1)
				//ovo znaci ima slova u niskoj abecedi
				indexLowAlph = lowAlphabet.indexOf(trenutacnoSlovo);
			else
				//ovo znaci ima slova u visokoj abecedi
				indexHighAlph = highAlphabet.indexOf(trenutacnoSlovo);

			//ako ima slova u visokoj abecedi, nadji slovo iz shiftane
			//abecede i spremi u shifted char
			//tada spremi shifted char u poruku na istom mjestu
			if (indexHighAlph != -1) {
				//ovo je dio gdje taman nalazimo sifrirano slovo i sprmeamo ga
				//u poruku	
				char shiftedChar = shiftedHighAlphabet.charAt(indexHighAlph);			
				poruka.setCharAt(indexSlova,shiftedChar);
			}
			if (indexLowAlph != -1) {
				char lowShiftedChar = shiftedlowAlphabet.charAt(indexLowAlph);
				poruka.setCharAt(indexSlova,lowShiftedChar);
			}
		}
	return poruka.toString();	
	}

	public void testCeasar() {
		int key = 17;
		FileResource fr = new FileResource();
		String message = fr.asString();
		//message = message.toUpperCase();
		String poruka = encrypt(message, key);
		System.out.println("sifrirana poruka: " + poruka);
		String decrypted = encrypt(poruka, 26-key);
		System.out.println("desifrirana poruka: " + decrypted);
	}

//------------------------------------------------------------
//------------------------------------------------------------
	

	public int[] countLetters(String message) {
		String alph = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
 		for (int k=0; k < message.length(); k++) {
 			char cha = Character.toLowerCase(message.charAt(k));
 			int dex = alph.indexOf(cha);
 			if (dex != -1) {
 				counts[dex] += 1;
 			}
 		}
 		return counts;
	}

 	public String decrypt(String encrypted) {
 		CaesarCipher cc = new CaesarCipher();
	 	int[] freqs = countLetters(encrypted);
	 	int maxDex  = maxDex(freqs);
	 	int dkey = maxDex - 4;
	 	if (maxDex < 4) {
	 		dkey = 26 - (4 - maxDex);
	 	}
	 	return cc.encrypt(encrypted, 26-dkey);
	 }

	public int maxDex(int[] vals) {
		int maxDex = 0;
		for (int k = 0; k<vals.length; k++) {
		if (vals[k] > vals[maxDex])
			maxDex = k;
		}
	return maxDex;
	} 

}