import edu.duke.*;


public class ZadatakDva {

	public String encrypt(String input, int key) {
		StringBuilder poruka = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = alphabet.toLowerCase();

		String shiftedAlphabet = alphabet.substring(key) + 
								 alphabet.substring(0, key);
		String shiftedLowerAlphabet = shiftedAlphabet.toLowerCase();



		for (int i = 0; i<poruka.length(); i++) {
			char currChar = poruka.charAt(i);
			int indl = -1;
			int indh = -1;

			if (alphabet.indexOf(currChar) == -1)
				indl = lowerAlphabet.indexOf(currChar);
			else
				indh = alphabet.indexOf(currChar);

			if (indh != -1) {
				char newChar = shiftedAlphabet.charAt(indh);				
				poruka.setCharAt(i,newChar);
			}
			if (indl != -1) {
				char veryNewChar = shiftedLowerAlphabet.charAt(indl);
				poruka.setCharAt(i,veryNewChar);
			}
		}
	return poruka.toString();	
	}

   	public String encrypt(String input, int key1, int key2) {
		StringBuilder poruka = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = alphabet.toLowerCase();

		String keyOneShiftedAlphabet = alphabet.substring(key1) + 
								 alphabet.substring(0, key1);
		String keyOneShiftedLowerAlphabet = keyOneShiftedAlphabet.toLowerCase();



		for (int i = 0; i<poruka.length(); i=i+2) {
			char currChar = poruka.charAt(i);
			int indl = -1;
			int indh = -1;

			if (alphabet.indexOf(currChar) == -1)
				indl = lowerAlphabet.indexOf(currChar);
			else
				indh = alphabet.indexOf(currChar);

			if (indh != -1) {
				char newChar = keyOneShiftedAlphabet.charAt(indh);				
				poruka.setCharAt(i,newChar);
			}
			if (indl != -1) {
				char veryNewChar = keyOneShiftedLowerAlphabet.charAt(indl);
				poruka.setCharAt(i,veryNewChar);
			}
		}

		String keyTwoShiftedAlphabet = alphabet.substring(key2) + 
								 alphabet.substring(0, key2);
		String keyTwoShiftedLowerAlphabet = keyTwoShiftedAlphabet.toLowerCase();



		for (int i = 1; i<poruka.length(); i=i+2) {
			char currChar = poruka.charAt(i);
			int indl = -1;
			int indh = -1;

			if (alphabet.indexOf(currChar) == -1)
				indl = lowerAlphabet.indexOf(currChar);
			else
				indh = alphabet.indexOf(currChar);

			if (indh != -1) {
				char newChar = keyTwoShiftedAlphabet.charAt(indh);				
				poruka.setCharAt(i,newChar);
			}
			if (indl != -1) {
				char veryNewChar = keyTwoShiftedLowerAlphabet.charAt(indl);
				poruka.setCharAt(i,veryNewChar);
			}
		}
	return poruka.toString();	
	}

	public void testCeasar() {
	    
		//FileResource fr = new FileResource();
		//String message = fr.asString();
		int key1 = 8;
		int key2 = 21;
		String poruka = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
		String encrypted = encrypt(poruka, key1, key2);
		System.out.println("key1 is " + key1 + ", key2 is " + key2 +"\n" + encrypted);
		
		int key = 15;
		//System.out.println(encrypt(poruka, key));
	}
	


}