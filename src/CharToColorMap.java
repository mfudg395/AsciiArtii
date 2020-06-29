import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * AsciiArtii - CharToColorMap class
 * 
 * The CharToColorMap reads from .map files associated with ASCII art files and
 * maps hex colors to characters used in the ASCII art. It is used to return the
 * hexcolor value associated with a given character.
 * 
 * @author Matthew Fudge
 *
 */
public class CharToColorMap {

	private static final String DEFAULT_COLOR = "#FFFFFF";

	private ArrayList<String> mapFileLines;
	private String hexColor;
	private Scanner scanner;

	/**
	 * Constructor. Initializes the ArrayList meant to hold the map file's
	 * contents. This is only used for the default AsciiArt.
	 */
	public CharToColorMap() {
		mapFileLines = new ArrayList<>();
	}
	
	/**
	 * Constructor. Fills the ArrayList holding the given file's contents.
	 *
	 * @param filePath the absolute path to the map file
	 */
	public CharToColorMap(String filePath) {
		File f = new File(filePath);
		mapFileLines = new ArrayList<>();
		scanner = null;
		hexColor = DEFAULT_COLOR;
		try {
			scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				mapFileLines.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: Cannot load .map file.");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	/**
	 * Returns the 6-digit hex color value of a given character in the .map file. 
	 * This value includes the initial '#' character.
	 * 
	 * If no such character can be found, returns DEFAULT_COLOR.
	 * 
	 * @param c the character to find a hex color code for
	 * @return the hex color code for the given character (or DEFAULT_COLOR)
	 */
	public String colorFor(char c) {
		hexColor = DEFAULT_COLOR;
		for (String mapLine : mapFileLines) {
			if (mapLine.charAt(0) == c) {
				hexColor = mapLine.substring(2);
				break;
			}
		}
		return hexColor;
	}
}