package entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import game.HandleClass;
import entity.Player;
import entitystatic.Coin; 

public class EntityManager {
	
	private HandleClass handler;
	
	
	public static Player player;
	
	
	
	private ArrayList<Entity> entities;
	

	public EntityManager(HandleClass handler,Player player) {
		this.handler= handler; 
		this.player= player; 
		entities= new ArrayList<Entity>();
		addEntity(player);
		
		
		
		
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			e.tick();
			
		}
		//player.tick();
		
	}
	
	
	
	public void render(Graphics g) {
		for(Entity e : entities){
			e.render(g);
		}
		//player.render(g);
		
	}
	
	
	public void addEntity(Entity e ) {
		
		entities.add(e);
		
	}
	
	//GETTERS && SETTERS

	public HandleClass getHandler() {
		return handler;
	}

	public void setHandler(HandleClass handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	
	
	
}
