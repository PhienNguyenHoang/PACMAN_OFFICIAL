package entitystatic;

import java.awt.Graphics;

import Graphics.Assets;
import entity.Creature;
import game.HandleClass;


public class Coin extends StaticEntity  {
	
	
	
	public Coin (HandleClass handler , float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		
		//set boundary
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 25;
		bounds.height = 25;
		
	}
	
	
	@Override 
	public void die() {
	
	}
	
	@Override 
	public void tick() {

	}
	
	public void render(Graphics g ) {
		g.drawImage(Assets.coin,(int)x, (int)y,width, height, null);
	}
}