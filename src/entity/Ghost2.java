package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Graphics.Animation;
import Graphics.Assets;
import game.HandleClass;

public class Ghost2 extends Creature {
	public Animation ghost1;
	
	public Ghost2(HandleClass handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width=27;
		bounds.height=27;
		
		ghost1=new Animation(500,Assets.inky);
	}
	
	

	@Override
	public void tick() {
		ghost1.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);		
	}
	private BufferedImage getCurrentAnimationFrame() {
		// TODO Auto-generated method stub
		return ghost1.getCurrentFrame();
	}
	
	
	private void checkRoute() {
		//float xInky = 
		
	}
	
	private void checkDistance() {
		
	}

}
