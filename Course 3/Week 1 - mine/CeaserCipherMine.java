import edu.duke.*;


public class CeaserCipherMine {

	public String encrypt(String input, int key) {
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = alphabet.toLowerCase();

		String shiftedAlphabet = alphabet.substring(key) + 
								 alphabet.substring(0, key);
		String shiftedLowerAlphabet = shiftedAlphabet.toLowerCase();



		for (int i = 0; i<encrypted.length(); i++) {
			char currChar = encrypted.charAt(i);
			int indl = -1;
			int indh = -1;

			if (alphabet.indexOf(currChar) == -1)
				indl = lowerAlphabet.indexOf(currChar);
			else
				indh = alphabet.indexOf(currChar);

			if (indh != -1) {
				char newChar = shiftedAlphabet.charAt(indh);				
				encrypted.setCharAt(i,newChar);
			}
			if (indl != -1) {
				char veryNewChar = shiftedLowerAlphabet.charAt(indl);
				encrypted.setCharAt(i,veryNewChar);
			}
		}
	return encrypted.toString();	
	}

	public void testCeasar() {
		int key = 17;
		FileResource fr = new FileResource();
		String message = fr.asString();
		//message = message.toUpperCase();
		String encrypted = encrypt(message, key);
		System.out.println("sifrirana poruka: " + encrypted);
		String decrypted = encrypt(encrypted, 26-key);
		System.out.println("desifrirana poruka: " + decrypted);
	}
	
    public void testiiing() {
    String str1 = "java2s", str2 = "java2s.com";
    
    boolean retval = str1.matches(str2);

    System.out.println("Value returned = " + retval);

    retval = str2.matches("com");

    System.out.println("Value returned = " + retval);    

    retval = str1.matches("java");

    System.out.println("Value returned = " + retval);
}

}