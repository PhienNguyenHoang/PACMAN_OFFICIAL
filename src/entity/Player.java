package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.sun.prism.paint.Color;

import Graphics.Animation;
import Graphics.Assets;
import game.Game;
import game.HandleClass;



public class Player extends Creature {
	
	private HandleClass handler;
	private Animation pac_left,pac_right;
	public Player(HandleClass handler, float x, float y) {
		super(handler, x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		this.handler = handler;
		
		pac_left= new Animation(300,Assets.pac_left);
		pac_right= new Animation(300,Assets.pac_right);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 25;
		bounds.height = 25;
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
		
		if(handler.getKeyManager().up) {
			yMove= -speed;
		}
		if(handler.getKeyManager().down) {
			yMove= speed;
		}
		if(handler.getKeyManager().right) {
			xMove= speed;
		}
		if(handler.getKeyManager().left) {
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
