import edu.duke.*
import java.io.*

public class WisdomTwoFour {
	public void findWisdom() {
		FileResource fr = new FileResource("data/confucius.txt");
		StorageResource store = new StorageResource();
		for (String w : fr.words()) {
			if (store.contains(w))
			store.add(w);
		}    
		return store;
	}



}