import java.util.ArrayList;
import java.util.Scanner;

public class AsciiArt {

	private static final String DEFAULT_ART =
	        "      _           _" + "\n" +
		"     / \\_______ /|_\\" + "\n" +
		"    /          /_/ \\__" + "\n" +
		"   /             \\_/ /" + "\n" +
		" _|_              |/|_" + "\n" +
		" _|_  O    _    O  _|_" + "\n" +
		" _|_      (_)      _|_" + "\n" +
		"  \\                 /" + "\n" +
		"   _\\_____________/_" + "\n" +
		"  /  \\/  (___)  \\/  \\" + "\n" +
	        "  \\__(  o     o  )__/";
	
	private Scanner artScanner;
	
	private final String name;
	private final int imageHeight;
	private final int imageWidth;
	private final int numChars;
	
	private final ArrayList<String> rows;
	private final ArrayList<Character> uniqueChars;
	

	
	/**
	 * Initializes all instance variables.
	 * 
	 * We are not loading art from a file when this constructor is called.
	 * We are using DEFAULT_ART as the initial ASCII art when first running.
	 */
	public AsciiArt() {
		artScanner = new Scanner(DEFAULT_ART);
		
		name = "default";
		rows = calculateRows();
		imageHeight = calculateHeight();
		imageWidth = calculateWidth();
		numChars = calculateNumChars();
		
		uniqueChars = new ArrayList<Character>();
	}
	
	/**
	 * Calculates the number of lines ("rows") that the ASCII art uses. An ArrayList
	 * is used to store each row; each String element in the ArrayList is a single row
	 * of the ASCII art.
	 * 
	 * @return rows of art
	 */
	private ArrayList<String> calculateRows() {
		ArrayList<String> rowsOfArt = new ArrayList<String>();
		while (artScanner.hasNextLine()) {
			rowsOfArt.add(artScanner.nextLine());
		}
		return rowsOfArt;
	}
	
	/**
	 * Calculates the height of the ASCII art. Because we have a list of each row of
	 * the ASCII art, the height is equal to the number of rows there are.
	 * 
	 * @return height of art
	 */
	private int calculateHeight() {
		return rows.size();
	}
	
	/**
	 * Calculates the width of the ASCII art. Because we have a list of each row of
	 * the ASCII art, the width is equal to the String element with the longest length
	 * in the list.
	 * 
	 * @return width of art
	 */
	private int calculateWidth() {
		int longestRow = 0;
		for (String row : rows) {
			longestRow = Math.max(longestRow, row.length());
		}
		return longestRow;
	}
	
	/**
	 * Calculates the total number of characters used to make the ASCII art. Because we have
	 * a list of each row of the ASCII art, the number of characters is equal to the sum of
	 * the characters of each list element.
	 * 
	 * @return total chars used for art
	 */
	private int calculateNumChars() {
		int totalChars = 0;
		for (String row : rows) {
			totalChars += row.length();
		}
		return totalChars;
	}
	
	/**
	 * Returns the ASCII art image.
	 * 
	 * @return String of ASCII art
	 */
	public String toString() {
		String art = "";
		for (String row : rows) {
			art += row + "\n";
		}
		return art;
	}
	
	/**
	 * @return height of ASCII art (in characters)
	 */
	public int getImageHeight() {
		return imageHeight;
	}
	
	/**
	 * @return width of ASCII art (in characters)
	 */
	public int getImageWidth() {
		return imageWidth;
	}
	
	/**
	 * @return number of characters in ASCII art
	 */
	public int getNumChars() {
		return numChars;
	}
	
}
