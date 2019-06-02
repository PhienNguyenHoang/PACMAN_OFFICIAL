package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width=75, height=75;
	
	public static BufferedImage[] pac_left,pac_right,blinky,pinky,inky,clyde;
	public static BufferedImage pacman,coin,diamond,background,wall, mainpic, start, ghost, back;
	
	public static void init() {
		
		CropImage sheet=new CropImage(ImageLoader.loadImage("/Images/final.png"));
		
		background=ImageLoader.loadImage("/Images/black.png");
		wall=ImageLoader.loadImage("/Images/wall.png");
		blinky= new BufferedImage[2];
		blinky[0]=ImageLoader.loadImage("/Images/2469740-blinky.png"); 
		blinky[1]=ImageLoader.loadImage("/Images/blinky_right.png");
		//blinky[2]= ImageLoader.loadImage("/Images/pacmanhh.png");
		inky=new BufferedImage[2];
		inky[0]=ImageLoader.loadImage("/Images/2469741-inky.png");
		inky[1]=ImageLoader.loadImage("/Images/inky_right.png");
		//inky[2]= ImageLoader.loadImage("/Images/pacmanhh.png");
		clyde = new BufferedImage[2];
		clyde[0]=ImageLoader.loadImage("/Images/2469743-orange.png");
		clyde[1]=ImageLoader.loadImage("/Images/orange_right.png");
		//clyde[2]= ImageLoader.loadImage("/Images/pacmanhh.png");
		pinky=new BufferedImage[2];
		pinky[0]=ImageLoader.loadImage("/Images/pinky_left.png");
		pinky[1]=ImageLoader.loadImage("/Images/pinky_right.png");
		//pinky[2]= ImageLoader.loadImage("/Images/pacmanhh.png");
		coin=ImageLoader.loadImage("/Images/cointile.png");
		pac_left=new BufferedImage[2];
		pac_left[0] = ImageLoader.loadImage("/Images/pac_left.png");
		pac_left[1] = ImageLoader.loadImage("/Images/pac_left1.png");
		pac_right=new BufferedImage[2];
		pac_right[0] = ImageLoader.loadImage("/Images/pac_right.png");
		pac_right[1] = ImageLoader.loadImage("/Images/pac_right1.png");
		diamond=ImageLoader.loadImage("/Images/diamond.png");
		//mainpic = ImageLoader.loadImage("/Images/mainpic.png");
		//start= ImageLoader.loadImage("/Images/start.png");
		//back= ImageLoader.loadImage("/Images/navyback.png");
		
		
		
		
	}
	
	
}

