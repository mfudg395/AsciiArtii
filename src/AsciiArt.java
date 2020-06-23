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
	
	private String name;
	private int imageHeight;
	private int imageWidth;
	private int numChars;
	
	private ArrayList<String> rows;
	private ArrayList<Character> uniqueChars;
	
	private Scanner artScanner;
	
	/**
	 * Initializes all instance variables.
	 * 
	 * We are not loading art from a file when this constructor is called.
	 * We are using DEFAULT_ART as the initial ASCII art when first running.
	 */
	public AsciiArt() {
		name = "default";
		imageHeight = 0;
		imageWidth = 0;
		numChars = 0;
		rows = new ArrayList<String>();
		uniqueChars = new ArrayList<Character>();
		artScanner = new Scanner(DEFAULT_ART);
		
		initialize();
	}
	
	/**
	 * Retrieves necessary data for the AsciiArt being used. This includes the
	 * art's height, width, number of characters used, and a list of each unique
	 * character in the art.
	 */
	private void initialize() {
		rows = calculateRows();
		imageHeight = calculateHeight();
		imageWidth = calculateWidth();
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
	 * Calculates the height of the ASCII art. Because we already have a list of each
	 * row of the ASCII art, the height is equal to the number of rows there are.
	 * 
	 * @return height of art
	 */
	private int calculateHeight() {
		return rows.size();
	}
	
	/**
	 * Calculates the width of the ASCII art.
	 * 
	 * @return width of art
	 */
	private int calculateWidth() {
		return 0;
	}
	
}
