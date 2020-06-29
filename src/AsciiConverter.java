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
}
