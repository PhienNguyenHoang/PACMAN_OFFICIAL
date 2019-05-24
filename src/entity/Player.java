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
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up)
			y -= 3;
		if(game.getKeyManager().down)
			y += 3;
		if(game.getKeyManager().left)
			x -= 3;
		if(game.getKeyManager().right)
			x += 3;
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.pacman,(int) x, (int) y, null);
	}
	
}
