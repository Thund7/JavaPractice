import edu.duke.*;

public class CommonWordsMine {

	public String[] getCommon() {
		FileResource tekst = new FileResource("data/common.txt");
		String [] common = new String [20]; //vazno je znati da smo ovo mi odredili
		int indeks = 0;
		for (String rijec : tekst.words()) {
			common[indeks] = rijec;
			indeks++;
		}  
	return common;	
	}

	public int indexOf(String[] commonWords, String rijec) {
		for (int k=0 ; k < commonWords.length ; k++) {
			if (commonWords[k].equals(rijec))
				return k;
		}
		return -1;
	}

	public void countWords(FileResource tekst, String[] najcesceRechi, int[] brojIstihRechi) {
		for (String rijec : tekst.words()) {
			rijec = rijec.toLowerCase();
			int index = indexOf(najcesceRechi, rijec);
			if (index != -1)
				brojIstihRechi[index]++;
		}
	}



	public void countShakespeare() {
		String [] tekstovi = {"small.txt"};
		String [] najcesceRechi = getCommon();
		int [] brojIstihRechi = new int[najcesceRechi.length];
		
		for (int k = 0; k<tekstovi.length; k++)  {
			FileResource tekst = new FileResource("data/" + tekstovi[k]);
			countWords(tekst, najcesceRechi, brojIstihRechi);
			System.out.println("we are done with " + tekstovi[k]);
		}

		for (int k = 0; k < najcesceRechi.length; k++) {
			System.out.println(najcesceRechi[k] + ":\t"
							+ brojIstihRechi[k]);
		}
	}
}