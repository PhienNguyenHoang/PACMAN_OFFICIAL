package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import Graphics.Assets;
import game.Game;


public class Player extends Creature {
	
	private Game game;
	private BufferedImage pacman;
	
	
	public Player(Game game, float x, float y) {
		super(x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
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
		g.drawImage(Assets.pacman,(int) x, (int) y,width,height, null);
	}
	
	
	
}
