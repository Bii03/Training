package letters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class CryptDecryptSimple implements ICryptDecrypt{

	@Override
	public void crypt(FileInputStream inputFile, FileOutputStream outputFile,
			Map<String, Integer> hashMap) {
		// TODO Auto-generated method stub
		
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		try{
			reader = new BufferedReader(new InputStreamReader(inputFile));
			writer = new PrintWriter(outputFile);
			
			int r;
			while((r = reader.read()) != -1){
				String key = String.valueOf((char) r);
				
				if(hashMap.containsKey(key)){
					int value = hashMap.get(key);
					writer.append(value+" ");
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(reader != null){
					reader.close();
				}
				
				if(writer != null){
					writer.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void decrypt(File inputFile, FileOutputStream outputFile,
			Map<String, Integer> hashMap) {
		// TODO Auto-generated method stub
		
		Scanner scanner = null;
		PrintWriter writer = null;
		
		try{
			scanner = new Scanner(inputFile);
			writer = new PrintWriter(outputFile);
			

			while(scanner.hasNext()){
				
				int value = Integer.parseInt(scanner.next());
				
				for(Map.Entry<String, Integer> letterMapping: hashMap.entrySet()){
					if(value == letterMapping.getValue()){
						writer.append(letterMapping.getKey());
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(scanner != null){
					scanner.close();
				}
				
				if(writer != null){
					writer.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}



}
