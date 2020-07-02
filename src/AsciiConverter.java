import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

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
	
	private static final int HEXIDECIMAL_BASE = 16;
	
	private final AsciiArt asciiArt;
	private final CharToColorMap colorMap;
	private final BufferedImage image;
	
	public AsciiConverter(AsciiArt asciiArt, CharToColorMap colorMap) {
		this.asciiArt = asciiArt;
		this.colorMap = colorMap;
		this.image = new BufferedImage(asciiArt.getImageWidth(), asciiArt.getImageHeight(), BufferedImage.TYPE_INT_RGB);
		setColors();
	}
	
	/**
	 * Saves the ASCII art as a .png file at the specified location. The location
	 * should always be the ROOT_DIR/generated-png-files.
	 * @param filePath
	 */
	public void savePngFile(String filePath) {
		File savedImage = new File(filePath);
		try {
			ImageIO.write(image, "png", savedImage);
		} catch (IOException e) {
			System.err.println("ERROR: Unable to save .png.");
		}
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
			for (int x = 0; x < image.getHeight(); x++) {
				for (int y = 0; y < image.getWidth(); y++) {
					int rgbCode = image.getRGB(y, x);
					String hexCode = String.format("#%06X", rgbCode & 0xFFFFFF);
					writer.print(hexCode + " ");
				}
				writer.println();
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Could not write to file.");
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	/**
	 * Sets each pixel of the BufferedImage to it's appropriate color. The BufferedImage is a
	 * representation of the ASCII art, so colors are determined based on the AsciiArt's associated
	 * ColorMap.
	 */
	private void setColors() {
		for (int x = 0; x < image.getHeight(); x++) {
			for (int y = 0; y < image.getWidth(); y++) {
				String hexCode = colorMap.colorFor(asciiArt.charAt(x, y));
				int hexCodeAsInt = Integer.parseInt(hexCode.substring(1), HEXIDECIMAL_BASE);
				image.setRGB(y, x, hexCodeAsInt);
			}
		}
	}
}
