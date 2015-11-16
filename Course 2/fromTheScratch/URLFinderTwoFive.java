import edu.duke.*;
import java.io.*;

public class URLFinderTwoFive {
	public StorageResource findURLs(String url) {
       //napravi novi urlresource gdje ces pohraniti web stranicu
       URLResource page = new URLResource(url);
       //spremiti stranicu sve nekako u jedan string
       String source = page.asString();
       //napraviti skladiste
       StorageResource store = new StorageResource();

       //pocni od nule
       int start = 0;

       while (true) {
       	//nadji indeks pocetka linka
       	int index = source.indexOf("href=", start);
       	//ako nema nista, izidji
       	if (index == -1)
       		break;
        //prvi quote ili link, stagod
        int firstQuote = index+6; // nakon href="
        //zadnji quote
        int endQuote = source.indexOf("\"", firstQuote);

        //uzmi string izmedju
        String sub = source.substring(firstQuote,endQuote);

        //i tek sad nastupa na djelu drugo skladiste
        //ako je na djelu link, dodaj ga u skladiste
        if (sub.startsWith("http")) 
        	store.add(sub);
      
       //odi na sljedeci indeks nakon ovog linka
       start = endQuote + 1;
		}
   
	}

	public void testURL() {
		//stvori dva storage resourca
		StorageResource s1 = findURLs("https://www.whitehouse.gov");
		StorageResource s2 = findURLs("http://www.doctorswithoutborders.org");

		//za svaki link u s2 (za svaki podatak) isprintaj taj link
        for (String link : s1.data()) {
        	System.out.println(link);
        }		
        //size prvog storagea i drugog storagea
        System.out.println("size = " + s1.size());
        System.out.println("size = " + s2.size());
	}
}