package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Player extends Creature {

	private BufferedImage pacman;
	public Player(float x, float y) {
		super(x, y);
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(pacman,50, 50, null);
	}
	
}
