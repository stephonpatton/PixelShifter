package pixelManipulator;
import java.awt.Color;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Main {
	public static void main(String[] args) {
		BufferedImage image = null;
		File outputFile = null;
		try {
			image = ImageIO.read(new File("robot.jpg"));
			outputFile = new File("saved.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		int imageRGB = 0, red = 0, green =0, blue = 0;
//		int[] redArray = new int[imageWidth];
//		int[] greenArray = new int[imageWidth];
//		int[] blueArray = new int[imageWidth];
//			for(int x = 0; x<imageWidth; x++) {	
//				imageRGB = image.getRGB(x, x);
//				red = (imageRGB & 0x00ff0000) >> 16;
//				redArray[x] = red;
//				green = (imageRGB & 0x00000ff00) >> 8;
//				greenArray[x] = green;
//				blue = imageRGB & 0x000000ff;
//				blueArray[x] = blue;
////				System.out.println(x + " " + x);
////				System.out.println("Red is " + red);
////				System.out.println("Green is " + green);
////				System.out.println("Blue is " + blue);
//			}
		Random rand = new Random();
	
		int pixelOne, pixelTwo, pixelThree;
		for(int i = 0; i<10000; i++) {	
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
			
			int rgb = new Color(pixelOneRed, pixelOneGreen, pixelOneBlue).getRGB();
			int rgb2 = new Color(pixelTwoRed, pixelTwoGreen, pixelTwoBlue).getRGB();
			image.setRGB(randomX2, randomY2, rgb);
			image.setRGB(randomX1, randomY1, rgb2);

		}	
		try {
				ImageIO.write(image, "jpeg", outputFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
