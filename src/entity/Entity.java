package entity;

import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

import game.HandleClass;

public  abstract class Entity {
	protected HandleClass handler;
	protected float x, y;
	protected int width,height;
	protected Rectangle bounds;
	
	
	public Entity(HandleClass handler,float x, float y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		bounds = new Rectangle(0, 0, width, height);
		this.handler = handler;
	}
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
}
