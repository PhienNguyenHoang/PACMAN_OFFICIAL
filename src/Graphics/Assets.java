package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width=75, height=75;
	
	public static BufferedImage pacman,blinky,pinky,inky,clyde,coin,diamond,background,wall;
	
	public static void init() {
		CropImage sheet=new CropImage(ImageLoader.loadImage("/Images/final.png"));
		
		background=sheet.crop(0,0, width, height);
		wall=sheet.crop(width, 0, width, height);
		blinky=sheet.crop(0, height, width, height);
		inky=sheet.crop(width, height, width, height);
		clyde=sheet.crop(width*2, height, width, height);
		pinky=sheet.crop(0, height*2, width, height);
		coin=sheet.crop(width*3, height, width, height);
		pacman = sheet.crop(width, height*2, width, height);
		diamond=sheet.crop(width*2, height*3, width, height);
	}
	
	
}
