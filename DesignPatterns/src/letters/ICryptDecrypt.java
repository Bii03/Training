package letters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

public interface ICryptDecrypt {
	void crypt(FileInputStream inputFile, FileOutputStream outputFile, Map<String, Integer> hashMap);
	
	void decrypt(File inputFile, FileOutputStream outputFile, Map<String, Integer> hashMap);
}
