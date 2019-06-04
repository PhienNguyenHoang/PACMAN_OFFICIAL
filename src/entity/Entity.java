package entity;

import java.awt.Graphics;
import java.awt.Rectangle; 


import game.HandleClass;

public  abstract class Entity {
	
	public static final int DEFAULT_HEALTH=3;
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
		health= DEFAULT_HEALTH;
	}
	
	
	public boolean checkEntityCollisions( ) {
		for ( Entity e : handler.getWorld().getEntityManager().getEntities()) {
			
			if ( e.equals(this)) {
				continue; 
			}
			if( (e.getCollisionBounds()).intersects(getCollisionBounds())) {
				return true; 
			}
		}
		return false; 
		
	}
	public Rectangle getCollisionBounds() {
		return new Rectangle ((int)(x+bounds.x),(int)(y+bounds.y), bounds.width, bounds.height);
	}
	
	public void beEaten (int amt) {
		health-=amt;
		if (health<=0) {
			active= false; 
			die();
		}
	}
	
	
	public abstract void die() ;


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


