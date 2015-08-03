package pixelManipulator;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
	public static void main(String[] args) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("robot.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		int imageRGB = 0, red = 0, green =0, blue = 0;
		int[] redArray = new int[imageWidth];
		int[] greenArray = new int[imageWidth];
		int[] blueArray = new int[imageWidth];
			for(int x = 0; x<imageWidth; x++) {	
				imageRGB = image.getRGB(x, x);
				red = (imageRGB & 0x00ff0000) >> 16;
				redArray[x] = red;
				green = (imageRGB & 0x00000ff00) >> 8;
				greenArray[x] = green;
				blue = imageRGB & 0x000000ff;
				blueArray[x] = blue;
				System.out.println(x + " " + x);
				System.out.println("Red is " + red);
				System.out.println("Green is " + green);
				System.out.println("Blue is " + blue);
			}
	}
}
