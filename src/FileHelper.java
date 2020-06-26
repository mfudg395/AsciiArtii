import java.io.File;
import java.util.ArrayList;

public class FileHelper {

	private final String artRootDir;
	
	/**
	 * The constructor is past the root directory of this project.
	 * .PNG files, Color Map files, and other ASCII art .txt files
	 * are stored in separate folders from the root directory.
	 * 
	 * @param rootDir the root directory of this project
	 */
	public FileHelper(String rootDir) {
		artRootDir = rootDir + "/ascii-art-files";
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
	
}
