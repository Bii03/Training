package letters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import letters.CryptDecryptFactory.CryptDecryptType;

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
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		List<LetterMapping> listLetterMappings = createListOfLetterMappings();
		Map<String, Integer> hashMapLetterMappings = createHashMapOfLetterMappings();
		
		CryptDecryptFactory factory = CryptDecryptFactory.getInstance();
		ICryptDecrypt cryptDecrypt = factory.createCryptDecrypt(CryptDecryptType.CryptDecryptSimple);
		
		FileOutputStream outputCrypted = new FileOutputStream("cryptedInput.txt");
		FileInputStream inputNotCrypted = new FileInputStream("flatInput.txt");
		File inputCrypted = new File("cryptedInput.txt");
		FileOutputStream outputDecrypted = new FileOutputStream("decryptedInput.txt");
	
		cryptDecrypt.crypt(inputNotCrypted, outputCrypted, hashMapLetterMappings);
		cryptDecrypt.decrypt(inputCrypted, outputDecrypted, hashMapLetterMappings);
		
		

	}

}
