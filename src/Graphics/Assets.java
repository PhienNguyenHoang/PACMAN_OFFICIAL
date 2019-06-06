package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	

	public static BufferedImage coin,diamond,background,wall,bg,gameover, winner, frighten ;
	public static BufferedImage[] pac_left,pac_right,blinky,pinky,inky,clyde,button;
	
	
	public static void init() {
		
		
		//Tiles
		background=ImageLoader.loadImage("/Images/black.png");
		wall=ImageLoader.loadImage("/Images/wall.png");
		
		//
		blinky= new BufferedImage[3];
		blinky[0]=ImageLoader.loadImage("/Images/2469740-blinky.png"); 
		blinky[1]=ImageLoader.loadImage("/Images/blinky_right.png");
		//
		inky=new BufferedImage[3];
		inky[0]=ImageLoader.loadImage("/Images/2469741-inky.png");
		inky[1]=ImageLoader.loadImage("/Images/inky_right.png");
		//
		clyde = new BufferedImage[3];
		clyde[0]=ImageLoader.loadImage("/Images/2469743-orange.png");
		clyde[1]=ImageLoader.loadImage("/Images/orange_right.png");
		//
		pinky=new BufferedImage[3];
		pinky[0]=ImageLoader.loadImage("/Images/pinky_left.png");
		pinky[1]=ImageLoader.loadImage("/Images/pinky_right.png");
		//
		coin=ImageLoader.loadImage("/Images/cointile.png");
		//
		pac_left=new BufferedImage[2];
		pac_left[0] = ImageLoader.loadImage("/Images/pac_left.png");
		pac_left[1] = ImageLoader.loadImage("/Images/pac_left1.png");
		//
		pac_right=new BufferedImage[2];
		pac_right[0] = ImageLoader.loadImage("/Images/pac_right.png");
		pac_right[1] = ImageLoader.loadImage("/Images/pac_right1.png");
//		//


		diamond=ImageLoader.loadImage("/Images/diamond.png");
		//
		button=new BufferedImage[2];
		button[0] = ImageLoader.loadImage("/Images/button1.png");
		button[1] = ImageLoader.loadImage("/Images/button.png");
		//
		bg=ImageLoader.loadImage("/Images/ready.png");
		
		gameover=ImageLoader.loadImage("/Images/gameover.png");
		winner= ImageLoader.loadImage("/Images/youwin.png");
		
		frighten= ImageLoader.loadImage("/Images/frighten.png");
		
	}
	
	
}

