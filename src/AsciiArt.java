import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * AsciiArtii - AsciiArt class
 * 
 * The AsciiArt class is a data type that represents a piece of ASCII art. Information
 * about the ASCII art - it's height and width (in chars) as well as the number and
 * types of characters used - is contained in AsciiArt objects.
 * 
 * @author Matthew Fudge
 *
 */
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
		
		uniqueChars = calculateUniqueChars();
	}
	
	/**
	 * Initializes all instance variables.
	 * 
	 * This constructor takes in the path of an ASCII art file located in the
	 * ascii-art-files directory, and sets the information according to that
	 * ASCII art.
	 * 
	 * @param artFilePath the name of a file to load
	 */
	public AsciiArt(String artFilePath) {
		File asciiArt = new File(artFilePath);
		try {
			artScanner = new Scanner(asciiArt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		name = asciiArt.getName();
		rows = calculateRows();
		imageHeight = calculateHeight();
		imageWidth = calculateWidth();
		numChars = calculateNumChars();
		
		uniqueChars = calculateUniqueChars();
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
	 * Calculates all the unique characters used to make the ASCII art. Because we have a list
	 * of each row of the ASCII art, we can check the characters of each 
	 * 
	 * @return ArrayList of all unique chars used to make the art
	 */
	private ArrayList<Character> calculateUniqueChars() {
		ArrayList<Character> uniqueChars = new ArrayList<Character>();
		for (String row : rows) {
			int length = row.length();
			for (int i = 0; i < length; i++) {
				if (!uniqueChars.contains(row.charAt(i))) {
					uniqueChars.add(row.charAt(i));
				}
			}
		}
		return uniqueChars;
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
	
	/**
	 * @return list of unique characters in ASCII art
	 */
	public ArrayList<Character> getUniqueChars() {
		return uniqueChars;
	}
}
