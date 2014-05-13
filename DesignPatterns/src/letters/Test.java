package letters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static List<LetterMapping> createListOfLetterMappings(){
		
		List<LetterMapping> listLetterMappings = new ArrayList<>();
		
		for(char c='a'; c<'z';c++){
			listLetterMappings.add(new LetterMapping(String.valueOf(c), (int)c));
		}
		
		return listLetterMappings;
	}
	
	public static Map<String, Integer> createHashMapOfLetterMappings(){
		
		Map<String, Integer> hashMapLetterMappings = new HashMap<>();
		
		for(char c='a'; c<'z';c++){
			hashMapLetterMappings.put(String.valueOf(c), (int)c);
		}
		
		return hashMapLetterMappings;
		
	}
	
	
	public static void main(String[] args) {
		
		List<LetterMapping> listLetterMappings = createListOfLetterMappings();
		Map<String, Integer> hashMapLetterMappings = createHashMapOfLetterMappings();

	}

}
