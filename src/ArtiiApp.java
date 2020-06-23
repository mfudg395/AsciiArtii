import java.util.Scanner;
import java.util.ArrayList;
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
	
	public ArtiiApp() { 
		keyboard = new Scanner(System.in);
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
			displayDivider();
			displayMenu();
			choice = keyboard.nextLine();
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
}