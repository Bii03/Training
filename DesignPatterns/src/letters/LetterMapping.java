package letters;

public class LetterMapping {
	private String letter;
	private int value;
	
	public LetterMapping(String letter, int value) {
		// TODO Auto-generated constructor stub
		this.letter = letter;
		this.value = value;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Letter "+letter+": "+value;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
