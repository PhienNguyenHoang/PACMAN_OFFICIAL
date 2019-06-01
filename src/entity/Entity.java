package entity;

import java.awt.Graphics;
import java.awt.Rectangle; 


import game.HandleClass;

public  abstract class Entity {
	
	public static final int DEFAULT_HEALTH=1;
	protected int health; 
	protected HandleClass handler;
	protected float x, y;
	protected int width,height;
	protected boolean active= true;
	protected Rectangle bounds;


	
	
	public Entity(HandleClass handler,float x, float y,int width,int height) {
		this.handler= handler; 
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		bounds = new Rectangle(0, 0, width, height);
		this.handler = handler;
		health= DEFAULT_HEALTH;
	}
	
	
	public boolean checkEntityCollisions(float xOffset, float yOffset ) {
		for ( Entity e : handler.getWorld().getEntityManager().getEntities()) {
			
			if ( e.equals(this)) {
				continue; 
			}
			if( (e.getCollisionBounds(0f,0f)).intersects(getCollisionBounds((int)xOffset, yOffset))) {
				return true; 
			}
		}
		return false; 
		
	}
	public Rectangle getCollisionBounds(float xOffset, float yOffset ) {
		return new Rectangle ((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset), bounds.width, bounds.height);
	}
	
	public void eat (int amt) {
		health=-amt;
		if (health<=0) {
			active= false; 
			die();
		}
	}
	
	public abstract void die();
	


	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}


