package letters;

/**
 * This factory is a singleton in order to have only one factory instance through the entire application.
 * @author btesila
 *
 */

public class CryptDecryptFactory {
	
	public enum CryptDecryptType{
		CryptDecryptSimple, CryptDecryptSpecial
	}
	
	private static CryptDecryptFactory INSTANCE = null;
	
	private CryptDecryptFactory(){
		
	}
	
	public static ICryptDecrypt createCryptDecrypt(CryptDecryptType cryptDecryptType){
		switch(cryptDecryptType){
		case CryptDecryptSimple: return new CryptDecryptSimple();
		case CryptDecryptSpecial: return new CryptDecryptSpecial();
		}
		
		throw new IllegalArgumentException("The crypt/decrypt type is not recognized");
	}
	
	public static CryptDecryptFactory getInstance(){
		
		if(INSTANCE == null){
			INSTANCE = new CryptDecryptFactory();
		}
		return INSTANCE;
	}
}
