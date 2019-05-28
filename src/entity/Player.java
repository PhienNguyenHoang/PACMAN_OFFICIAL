package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Graphics.Animation;
import Graphics.Assets;
import game.Game;



public class Player extends Creature {
	
	private Game game;
	private Animation pac_left,pac_right;
	public Player(Game game, float x, float y) {
		super(x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		this.game = game;
		
		pac_left= new Animation(300,Assets.pac_left);
		pac_right= new Animation(300,Assets.pac_right);
		
	}

	@Override
	public void tick() {
		pac_left.tick();
		pac_right.tick();
		getInput();
		move();
		
		
	}
	public void getInput() {
		xMove=0;
		yMove=0;
		
		if(game.getKeyManager().up) {
			yMove= -speed;
		}
		if(game.getKeyManager().down) {
			yMove= speed;
		}
		if(game.getKeyManager().right) {
			xMove= speed;
		}
		if(game.getKeyManager().left) {
			xMove= -speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);
	}
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove<0) {
			return pac_left.getCurrentFrame(); 
		}
		else if(xMove>0) {
			return pac_right.getCurrentFrame();
		}
		return pac_right.getCurrentFrame();
	}

	
}
