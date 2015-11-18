public class CharacterDemoMine {

	public void digitTest() {
		String test = "abABCg123456789|#&$q@b/*%|&q{}";

		for (int k = 0; k<test.length(); k++) {
			char cha = test.charAt(k);
			if (Character.isDigit(cha))
				System.out.println(cha +" is a digit");
			if (Character.isAlphabetic(cha))
				System.out.println(cha + " is alphabetic");
			if (cha == '#')
				System.out.println(cha + " is hashtag");
		}
	}

	public void conversionTest() {
		String test = "abABCg123456789|#&$q@b/*%|&q{}";

		for (int k = 0; k<test.length(); k++) {
			char cha = test.charAt(k);
			char ucha = Character.toUpperCase(cha);
			char lcha = Character.toLowerCase(cha);
			System.out.println(cha + "\t" + ucha + "\t" + lcha);
		}
	}
}