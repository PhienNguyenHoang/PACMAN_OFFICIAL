package Graphics;

import java.awt.image.BufferedImage;

public class CropImage {
	private BufferedImage crop;
	
	public CropImage(BufferedImage crop) {
		this.crop=crop;
		
	}
	public BufferedImage crop(int x, int y, int width, int height) {
		return crop.getSubimage(x, y, width, height);
	}
}
