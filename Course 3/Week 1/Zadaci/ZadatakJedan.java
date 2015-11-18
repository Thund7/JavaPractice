import edu.duke.*;

public class ZadatakJedan {
	//-------1---------------
	public boolean isVowel(char cha) {
		if (cha == 'a' || cha == 'e' || cha == 'i' || cha == 'o' || cha == 'u' ||
			cha == 'A' || cha == 'E' || cha == 'I' || cha == 'O' || cha == 'U') {
			return true;
		}
		else
			return false;
	}

	public void testIsVowel() {
		System.out.println(isVowel('t'));
	}
    //----end-1---------------

    //------2-----------------

	public String replaceVowels(String phrase, char cha){
		StringBuilder fraza = new StringBuilder(phrase);

		for (int i = 0; i<phrase.length(); i++) {
			char currChar = fraza.charAt(i);
			if (isVowel(currChar)) {
				fraza.setCharAt(i, cha);
			}
		}
	return fraza.toString();
	}

	public void testReplaceVowels() {
		System.out.println(replaceVowels("dinAMo", '+'));
	}

    //----end-2---------------

    //------3-----------------

	public String emphasize(String phrase, char cha) {
		StringBuilder fraza = new StringBuilder(phrase);

		for (int i = 0; i<phrase.length(); i++) {
			char currChar = fraza.charAt(i);
			if (isVowel(currChar)) {
				if (phrase.indexOf(currChar,i) % 2 == 0)
					fraza.setCharAt(i, '*');
				else if (phrase.indexOf(currChar,i) % 2 == 1)
					fraza.setCharAt(i, '+');
			}
		}
	return fraza.toString();	
	}

	public void testEmphasize() {
		System.out.println(emphasize("Mary Bella Abracadabra", 'a') );
	}

    //------end 3--------------
}