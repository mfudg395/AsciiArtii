import java.util.Scanner;
/**
 * AsciiArtii - ArtiiApp class
 * 
 * The ArtiiApp class handles main duties of the program such as displaying
 * the menu, reading user choice, and loading a new AsciiArt file. It primarily
 * handles user interaction with the program.
 * 
 * @author Matthew Fudge
 *
 */
public class ArtiiApp {

	public static final String ROOT_DIR = System.getProperty("user.dir");
	
	private Scanner keyboard;
	private AsciiArt art;
	private CharToColorMap artColorMap;
	private AsciiConverter converter;
	private FileHelper fileHelper;
	
	public ArtiiApp() { 
		keyboard = new Scanner(System.in);
		art = new AsciiArt();
		artColorMap = new CharToColorMap();
		converter = new AsciiConverter(art, artColorMap);
		fileHelper = new FileHelper(ROOT_DIR);
	}
	
	/**
	 * Displays a welcome message and then displays the current ASCII art
	 * info + the main menu. Also waits for user choices until user decides
	 * to quit.
	 */
	public void run() {
		String choice = "0";
		displayWelcome();
		while (!choice.equals("4")) {
			displayCurrentArt();
			displayArtInfo();
			displayDivider();
			displayMenu();
			choice = keyboard.nextLine();
			handle(choice);
		}
	}
	
	private void displayWelcome() {
		System.out.println("Welcome to ArtiiApp!");
	}
	
	private void displayDivider() {
		System.out.println("***************************************************");
	}
	
	private void displayMenu() {
		System.out.println("1 - save current ascii art as png");
		System.out.println("2 - save current ascii art as hex colors");
		System.out.println("3 - load ascii art file");
		System.out.println("4 - quit\n");
		System.out.print("Choice? ");
	}
	
	/**
	 * Prints the ASCII art currently loaded. A default art is provided in the
	 * AsciiArt class as a starting point.
	 */
	private void displayCurrentArt() {
		System.out.println(art.toString());
	}
	
	/**
	 * Prints info about the ASCII art currently loaded; this info includes the
	 * art's height, width, total number of characters, and unique characters used.
	 */
	private void displayArtInfo() {
		System.out.println("height: " + art.getImageHeight());
		System.out.println("width: " + art.getImageWidth());
		System.out.println("characters used: " + art.getUniqueChars());
		System.out.println("total characters: " + art.getNumChars());
	}
	
	/**
	 * Reads the choice the user made and calls the appropriate methods in response.
	 * 
	 * @param choice the menu selection the user made
	 */
	private void handle(String choice) {
		if (choice.equals("1")) {
			savePngFile();
		} else if  (choice.equals("2")) { 
			saveHexFile();
		} else if (choice.equals("3")) {
			loadArtFile();
		} else if (choice.equals("4")) {
			createMapFile();
		} else if (choice.equals("4")) {
			System.out.print("Thanks for arting.");
		} else {
			System.out.println("Invalid choice.");
		}
	}
	
	/**
	 * Saves a .png file of the current ASCII art loaded. If the .png file does not
	 * have an associated .map, all colors will be #FFFFFF.
	 */
	private void savePngFile() {
		String filePath = fileHelper.pngFilePath(art.getName());
		converter.savePngFile(filePath);
		System.out.println("File saved to: " + filePath);
	}
	
	/**
	 * Saves a .hex file of the current ASCII art loaded. The hex file will be a 
	 * representation of the ASCII art where all characters are replaced with their
	 * appropriate color as a six-digit hex value, as indicated by the ASCII art's 
	 * corresponding .map file.
	 */
	private void saveHexFile() {
		String filePath = fileHelper.hexcolorFilePath(art.getName());
		converter.saveHexFile(filePath);
		System.out.println("File saved to: " + filePath);
	}
	
	/**
	 * Prompts the user for a new art file to load from the available files in
	 * ascii-art-files. The chosen AsciiArt will then be initialized.
	 */
	private void loadArtFile() {
		String artToLoad = "";
		
		listAsciiArtFiles();
		while (!fileHelper.asciiArtExists(artToLoad)) {
			artToLoad = keyboard.nextLine();
			if (!fileHelper.asciiArtExists(artToLoad)) {
				System.out.print("Error: No such file. Try again: ");
			}
		}
		art = new AsciiArt(fileHelper.asciiArtFilePath(artToLoad));
		artColorMap = new CharToColorMap(fileHelper.mapFilePath(artToLoad));
		converter = new AsciiConverter(art, artColorMap);
	}
	
	/**
	 * Displays a formatted list of available files in ascii-art-files.
	 */
	private void listAsciiArtFiles() {
		System.out.println("Here is a list of available art files: ");
		for (String fileName : fileHelper.availableAsciiArtFiles()) {
			System.out.println("[*] " + fileName);
		}
		System.out.print("Type the file to load: ");
	}
	
	private void createMapFile() {
		// TODO: implement the creation of a new .map file for current art
	}
}