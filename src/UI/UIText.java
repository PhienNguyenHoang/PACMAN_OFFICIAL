package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIText extends UIObject {

	private BufferedImage images;

	public UIText(float x, float y, int width, int height, BufferedImage images) {
		super(x, y, width, height);
		this.images=images;

		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

			g.drawImage(images,(int)x,(int)y,width,height,null);
			

		
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
	}

}
