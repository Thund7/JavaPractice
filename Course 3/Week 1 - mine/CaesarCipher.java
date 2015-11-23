import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder poruka = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = alphabet.toLowerCase();

        String shiftedAlphabet = alphabet.substring(key) + 
                                 alphabet.substring(0, key);
        String shiftedLowerAlphabet = shiftedAlphabet.toLowerCase();

        System.out.println(shiftedAlphabet);  

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

}

