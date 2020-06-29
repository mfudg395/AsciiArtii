import java.io.File;
import java.util.ArrayList;
/**
 * AsciiArtii - FileHelper class
 * 
 * The FileHelper class provides various helper methods to assist with file handling in
 * AsciiArtii. This includes listing available ASCII art files and methods to retrieve all
 * necessary file paths.
 * 
 * @author Matthew Fudge
 */
public class FileHelper {

	private final String artRootDir;
	private final String hexcolorRootDir;
	
	/**
	 * The constructor is past the root directory of this project.
	 * .PNG files, Color Map files, and other ASCII art .txt files
	 * are stored in separate folders from the root directory.
	 * 
	 * @param rootDir the root directory of this project
	 */
	public FileHelper(String rootDir) {
		artRootDir = rootDir + "/ascii-art-files";
		hexcolorRootDir = rootDir + "/generated-hexcolor-files";
	}
	
	/**
	 * Returns an ArrayList<String> of all available art file names in
	 * ascii-art-files. The .txt extension is removed from these names
	 * before returning them.
	 * 
	 * @return ArrayList<String> of all ASCII art file names located in
	 * 		   ROOT_DIR/ascii-art-files.
	 */
	public ArrayList<String> availableAsciiArtFiles() {
		ArrayList<String> availableFiles = new ArrayList<>();
		
		File asciiArtDirectory = new File(artRootDir); // directory of ASCII art files
		File[] fileList = asciiArtDirectory.listFiles(); // array containing all ASCII art files
		
		for (File file : fileList) {
			availableFiles.add(file.getName().replaceAll(".txt", ""));
		}
		
		return availableFiles;
	}
	
	/**
	 * Returns true if a given file exists in the ascii-art-files directory.
	 * 
	 * @return
	 */
	public boolean asciiArtExists(String asciiArtName) {
		for (String file : availableAsciiArtFiles()) {
			if (asciiArtName.equals(file)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the absolute path to a .txt file associated with a given ASCII art
	 * image name.
	 * 
	 * @param asciiArtName the name of an ASCII art file
	 * @return the absolute path to the ASCII art file
	 */
	public String asciiArtFilePath(String asciiArtName) {
		return artRootDir + "/" + asciiArtName + ".txt";
	}
	
	/**
	 * Returns the absolute path to a hexcolor file associated with a given ASCII art
	 * image name.
	 * 
	 * @param asciiArtName the name of an ASCII art file
	 * @return the absolute path to the hexcolor file of given ASCII art
	 */
	public String hexcolorFilePath(String asciiArtName) {
		return hexcolorRootDir + "/" + asciiArtName + ".hex";
	}
}
