import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * AsciiArtii - AsciiConverter class
 * 
 * AsciiConverter handles the conversion of a given ASCII art to either
 * a .png or a .hex file. 
 * 
 * .png files are standard images, while .hex files are a representation of
 * the image with each pixel replaced by a color hexcode.
 * 
 * @author Matthew Fudge
 */
public class AsciiConverter {
	
	private final AsciiArt asciiArt;
	private final CharToColorMap colorMap;
	
	public AsciiConverter(AsciiArt asciiArt, CharToColorMap colorMap) {
		this.asciiArt = asciiArt;
		this.colorMap = colorMap;
	}
	
	/**
	 * Saves the ASCII art as a .hex file at the specified location. The location
	 * should always be the ROOT_DIR/generated-hex-files.
	 * 
	 * @param filePath
	 */
	public void saveHexFile(String filePath) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filePath);
			for (String artRow : asciiArt.getRows()) { // access each line of ASCII art
				for (char rowChar : artRow.toCharArray()) { // access to each char in each line
					writer.print(colorMap.colorFor(rowChar) + " ");
				}
				writer.print("\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Could not write to file.");
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
