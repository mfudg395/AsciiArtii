import java.util.ArrayList;

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
		
	}
	
}
