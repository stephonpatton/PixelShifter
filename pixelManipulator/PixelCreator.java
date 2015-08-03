package pixelManipulator;
import java.awt.Color;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.imageio.ImageIO;

public class PixelCreator {
	public PixelCreator() {
		BufferedImage image = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
		File file = null;
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		Random rand = new Random();
		
		for(int x = 0; x<10000;x++) {
			for(int y = 0; y<10000; y++) {
				int randomX1 = rand.nextInt(imageWidth);
				int randomX2 = rand.nextInt(imageWidth);
				int randomY1 = rand.nextInt(imageHeight);
				int randomY2 = rand.nextInt(imageHeight);
				
				image.setRGB(randomX1, randomY1, Color.RED.getRGB());
				image.setRGB(randomX2, randomY2, Color.BLACK.getRGB());
			}
		}
		for(int x = 0; x<250; x++) {
			for(int y = 0; y<250; y++) {
				int red = rand.nextInt(255);
				int green = rand.nextInt(255);
				int blue = rand.nextInt(255);
				int color = new Color(red, green, blue).getRGB();
				image.setRGB(x, y, color);
			}
		}
		file = new File("save.jpg");
		try {
			ImageIO.write(image, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
