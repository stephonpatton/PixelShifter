package pixelManipulator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class PixelShifter {
	{
	
	BufferedImage image = null;
	File outputFile = null;
	
	try {
		image = ImageIO.read(new File("robot.jpg"));
		outputFile = new File("saved.jpg");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	int imageWidth = image.getWidth();
	int imageHeight = image.getHeight();
	Color[] color = new Color[imageWidth];
	Random rand = new Random();
	int[] redArray = new int[imageWidth];
	int[] greenArray = new int[imageWidth];
	int[] blueArray = new int[imageWidth];
	int[] rgb = new int[imageWidth];
	int red, green, blue;
	for(int i = 0; i<imageHeight; i++) {
		for(int x = 0; x<imageHeight; x++) {
			int tempPixel = image.getRGB(i, i);
			red = (tempPixel & 0x00ff0000) >> 16;
			green = (tempPixel & 0x00000ff00) >> 8;
			blue = tempPixel & 0x000000ff;
			redArray[i] = red;
			greenArray[i] = green;
			blueArray[i] = blue;
			color[i] = new Color(redArray[i], greenArray[i], blueArray[i]);
			rgb[i] = new Color(redArray[i], greenArray[i], blueArray[i]).getRGB();
		}
	}
	
	int pixelOne, pixelTwo;
	for(int i = 0; i<2000000; i++) {	
		int randomX1 = rand.nextInt(imageWidth);
		int randomY1 = rand.nextInt(imageWidth);
		int randomX2 = rand.nextInt(imageWidth);
		int randomY2 = rand.nextInt(imageWidth);
		
		pixelOne = image.getRGB(randomX1, randomY1);
		int pixelOneRed = (pixelOne & 0x00ff0000) >> 16;
		int pixelOneGreen = (pixelOne & 0x00000ff00) >> 8;
		int pixelOneBlue = pixelOne & 0x000000ff;
		
		pixelTwo = image.getRGB(randomX2, randomY2);
		int pixelTwoRed = (pixelTwo & 0x00ff0000) >> 16;
		int pixelTwoGreen = (pixelTwo & 0x00000ff00) >> 8;
		int pixelTwoBlue = pixelTwo & 0x000000ff;

		int rgb1 = new Color(pixelOneRed, pixelOneGreen, pixelOneBlue).getRGB();
		int rgb2 = new Color(pixelTwoRed, pixelTwoGreen, pixelTwoBlue).getRGB();
		
		image.setRGB(randomX1, randomY1, rgb2);
		image.setRGB(randomX2, randomY1, rgb1);
	}
	
	try {
			ImageIO.write(image, "jpeg", outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
