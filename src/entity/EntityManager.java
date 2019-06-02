package entity;

import java.awt.Graphics;
import java.util.ArrayList;

import game.HandleClass;
import entity.Player;
import entitystatic.Coin;
import entitystatic.Diamond; 

public class EntityManager {
	
	private HandleClass handler;
	
	
	public static Player player;
	
	private ArrayList<Entity> entities;
	

	public EntityManager(HandleClass handler,Player player) {
		this.handler= handler; 
		this.player= player;
		entities= new ArrayList<Entity>();
		addEntity1();
		addEntity(player);
	
	}
	
	public void tick() {
		  for(int i = 0 ; i < entities.size() ; i++){
	            Entity e = entities.get(i);
	            e.tick();
	            if(e.isActive()==false)
	                entities.remove(e);
			}
			
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
	
	public void addEntity1() {
		//ADD COIN
		
				addEntity(new Coin (handler,30*2, 30));
				addEntity(new Coin (handler,30*3, 30));
				addEntity(new Coin (handler,30*4, 30));
				addEntity(new Coin (handler,30*5, 30));
				addEntity(new Coin (handler,30*6, 30));
				addEntity(new Coin (handler,30*7, 30));
				addEntity(new Coin (handler,30*8, 30));
				addEntity(new Coin (handler,30*9, 30));
				addEntity(new Coin (handler,30*10, 30));
				addEntity(new Coin (handler,30*11, 30));
				addEntity(new Coin (handler,30*12, 30));
				addEntity(new Coin (handler,30*13, 30));
				addEntity(new Coin (handler,30*14, 30));
				addEntity(new Coin (handler,30*15, 30));
				addEntity(new Coin (handler,30*16, 30));
				addEntity(new Coin (handler,30*17, 30));
				addEntity(new Coin (handler,30*18, 30));
				addEntity(new Coin (handler,30*19, 30));
				addEntity(new Coin (handler,30*20, 30));
				addEntity(new Coin (handler,30*21, 30));
				addEntity(new Coin (handler,30*22, 30));
				addEntity(new Coin (handler,30*23, 30));
				addEntity(new Coin (handler,30*24, 30));
				addEntity(new Coin (handler,30*25, 30));
				addEntity(new Coin (handler,30*26, 30));
				addEntity(new Coin (handler,30*27, 30));
				addEntity(new Coin (handler,30*28, 30));
				
				addEntity(new Coin (handler,30, 30*2));
				addEntity(new Coin (handler,30*3, 30*2));
				addEntity(new Coin (handler,30*7, 30*2));
				addEntity(new Coin (handler,30*11, 30*2));
				addEntity(new Coin (handler,30*18, 30*2));
				addEntity(new Coin (handler,30*22, 30*2));
				addEntity(new Coin (handler,30*26, 30*2));
				addEntity(new Coin (handler,30*28, 30*2));
				addEntity(new Coin (handler,30, 30*3));
				
				addEntity(new Coin (handler,30*3, 30*3));
				addEntity(new Coin (handler,30*7, 30*3));
				addEntity(new Coin (handler,30*11, 30*3));
				addEntity(new Coin (handler,30*12, 30*3));
				addEntity(new Coin (handler,30*17, 30*3));
				addEntity(new Coin (handler,30*18, 30*3));
				addEntity(new Coin (handler,30*22, 30*3));
				addEntity(new Coin (handler,30*26, 30*3));
				addEntity(new Coin (handler,30*28, 30*3));
				
				addEntity(new Coin (handler,30, 30*4));
				addEntity(new Coin (handler,30*2, 30*4));
				addEntity(new Coin (handler,30*3, 30*4));
				addEntity(new Coin (handler,30*4, 30*4));
				addEntity(new Coin (handler,30*5, 30*4));
				addEntity(new Coin (handler,30*6, 30*4));
				addEntity(new Coin (handler,30*7, 30*4));
				addEntity(new Coin (handler,30*8, 30*4));
				addEntity(new Coin (handler,30*9, 30*4));
				addEntity(new Coin (handler,30*10, 30*4));
				addEntity(new Coin (handler,30*11, 30*4));
				addEntity(new Coin (handler,30*12, 30*4));
				addEntity(new Coin (handler,30*13, 30*4));
				addEntity(new Coin (handler,30*14, 30*4));
				addEntity(new Coin (handler,30*15, 30*4));
				addEntity(new Coin (handler,30*16, 30*4));
				addEntity(new Coin (handler,30*17, 30*4));
				addEntity(new Coin (handler,30*18, 30*4));
				addEntity(new Coin (handler,30*19, 30*4));
				addEntity(new Coin (handler,30*20, 30*4));
				addEntity(new Coin (handler,30*21, 30*4));
				addEntity(new Coin (handler,30*22, 30*4));
				addEntity(new Coin (handler,30*23, 30*4));
				addEntity(new Coin (handler,30*24, 30*4));
				addEntity(new Coin (handler,30*25, 30*4));
				addEntity(new Coin (handler,30*26, 30*4));
				addEntity(new Coin (handler,30*27, 30*4));
				addEntity(new Coin (handler,30*28, 30*4));

				addEntity(new Coin (handler,30, 30*5));
				addEntity(new Coin (handler,30*5, 30*5));
				addEntity(new Coin (handler,30*24, 30*5));
				addEntity(new Coin (handler,30*28, 30*5));
				
				addEntity(new Coin(handler,30,30*6));
				addEntity(new Coin (handler,30*2, 30*6));
				addEntity(new Coin (handler,30*3, 30*6));
				addEntity(new Coin (handler,30*4, 30*6));
				addEntity(new Coin (handler,30*5, 30*6));
				addEntity(new Coin (handler,30*6, 30*6));
				addEntity(new Coin (handler,30*7, 30*6));
				addEntity(new Coin (handler,30*8, 30*6));
				addEntity(new Coin (handler,30*9, 30*6));
				addEntity(new Coin (handler,30*10, 30*6));
				addEntity(new Coin (handler,30*11, 30*6));
				addEntity(new Coin (handler,30*12, 30*6));
				addEntity(new Coin (handler,30*13, 30*6));
				addEntity(new Coin (handler,30*14, 30*6));
				addEntity(new Coin (handler,30*15, 30*6));
				addEntity(new Coin (handler,30*16, 30*6));
				addEntity(new Coin (handler,30*17, 30*6));
				addEntity(new Coin (handler,30*18, 30*6));
				addEntity(new Coin (handler,30*19, 30*6));
				addEntity(new Coin (handler,30*20, 30*6));
				addEntity(new Coin (handler,30*21, 30*6));
				addEntity(new Coin (handler,30*22, 30*6));
				addEntity(new Coin (handler,30*23, 30*6));
				addEntity(new Coin (handler,30*24, 30*6));
				addEntity(new Coin (handler,30*25, 30*6));
				addEntity(new Coin (handler,30*26, 30*6));
				addEntity(new Coin (handler,30*27, 30*6));
				addEntity(new Coin (handler,30*28, 30*6));
				
				addEntity(new Coin(handler,30,30*7));
				addEntity(new Coin (handler,30*3, 30*7));
				addEntity(new Coin (handler,30*7, 30*7));
				addEntity(new Coin (handler,30*9, 30*7));
				addEntity(new Coin (handler,30*20, 30*7));
				addEntity(new Coin (handler,30*22, 30*7));
				addEntity(new Coin (handler,30*26, 30*7));
				addEntity(new Coin (handler,30*28, 30*7));
				
				addEntity(new Coin(handler,30,30*8));
				addEntity(new Coin (handler,30*3, 30*8));
				addEntity(new Coin (handler,30*4, 30*8));
				addEntity(new Coin (handler,30*5, 30*8));
				addEntity(new Coin (handler,30*7, 30*8));
				addEntity(new Coin (handler,30*9, 30*8));
				addEntity(new Coin (handler,30*11, 30*8));
				addEntity(new Coin (handler,30*12, 30*8));
				addEntity(new Coin (handler,30*13, 30*8));
				addEntity(new Coin (handler,30*14, 30*8));
				addEntity(new Coin (handler,30*15, 30*8));
				addEntity(new Coin (handler,30*16, 30*8));
				addEntity(new Coin (handler,30*17, 30*8));
				addEntity(new Coin (handler,30*18, 30*8));
				addEntity(new Coin (handler,30*20, 30*8));
				addEntity(new Coin (handler,30*22, 30*8));
				addEntity(new Coin (handler,30*24, 30*8));
				addEntity(new Coin (handler,30*25, 30*8));
				addEntity(new Coin (handler,30*26, 30*8));
				addEntity(new Coin (handler,30*28, 30*8));
				
				addEntity(new Coin (handler, 30, 30*9));
				addEntity(new Coin (handler,30*5, 30*9));
				addEntity(new Coin (handler,30*7, 30*9));
				//
				addEntity(new Diamond (handler, 30*9, 30*9));
				addEntity(new Diamond (handler, 30*20, 30*9));
				
				//
				addEntity(new Coin (handler,30*15, 30*9));
				addEntity(new Coin (handler,30*22, 30*9));
				addEntity(new Coin (handler,30*24, 30*9));
				addEntity(new Coin (handler,30*28, 30*9));
				
				addEntity(new Coin(handler,30,30*10));
				addEntity(new Coin (handler,30*5, 30*10));
				addEntity(new Coin (handler,30*7, 30*10));
				addEntity(new Coin (handler,30*11, 30*10));
				addEntity(new Coin (handler,30*12, 30*10));
				addEntity(new Coin (handler,30*13, 30*10));
				addEntity(new Coin (handler,30*14, 30*10));
				addEntity(new Coin (handler,30*15, 30*10));
				addEntity(new Coin (handler,30*16, 30*10));
				addEntity(new Coin (handler,30*17, 30*10));
				addEntity(new Coin (handler,30*18, 30*10));
				addEntity(new Coin (handler,30*22, 30*10));
				addEntity(new Coin (handler,30*24, 30*10));
				addEntity(new Coin (handler,30*26, 30*10));
				addEntity(new Coin (handler,30*28, 30*10));
				
				addEntity(new Coin(handler,30,30*11));
				addEntity(new Coin (handler,30*2, 30*11));
				addEntity(new Coin (handler,30*3, 30*11));
				addEntity(new Coin (handler,30*4, 30*11));
				addEntity(new Coin (handler,30*5, 30*11));
				addEntity(new Coin (handler,30*6, 30*11));
				addEntity(new Coin (handler,30*7, 30*11));
				addEntity(new Coin (handler,30*8, 30*11));
				addEntity(new Coin (handler,30*9, 30*11));
				addEntity(new Coin (handler,30*11, 30*11));
				addEntity(new Coin (handler,30*18, 30*11));
				addEntity(new Coin (handler,30*19, 30*11));
				addEntity(new Coin (handler,30*20, 30*11));
				addEntity(new Coin (handler,30*21, 30*11));
				addEntity(new Coin (handler,30*22, 30*11));
				addEntity(new Coin (handler,30*23, 30*11));
				addEntity(new Coin (handler,30*24, 30*11));
				addEntity(new Coin (handler,30*26, 30*11));
				addEntity(new Coin (handler,30*28, 30*11));
				

				addEntity(new Coin(handler,30,30*12));
				addEntity(new Coin (handler,30*5, 30*12));
				addEntity(new Coin (handler,30*9, 30*12));
				addEntity(new Coin (handler,30*11, 30*12));
				addEntity(new Coin (handler,30*13, 30*12));
				addEntity(new Coin (handler,30*16, 30*12));
				addEntity(new Coin (handler,30*18, 30*12));
				addEntity(new Coin (handler,30*20, 30*12));
				addEntity(new Coin (handler,30*24, 30*12));
				addEntity(new Coin (handler,30*26, 30*12));
				addEntity(new Coin (handler,30*27, 30*12));
				addEntity(new Coin (handler,30*28, 30*12));
				

				addEntity(new Coin(handler,30,30*13));
				addEntity(new Coin (handler,30*3, 30*13));
				addEntity(new Coin (handler,30*4, 30*13));
				addEntity(new Coin (handler,30*5, 30*13));
				addEntity(new Coin (handler,30*6, 30*13));
				addEntity(new Coin (handler,30*7, 30*13));
				addEntity(new Coin (handler,30*9, 30*13));
				addEntity(new Coin (handler,30*11, 30*13));
				addEntity(new Coin (handler,30*13, 30*13));
				addEntity(new Coin (handler,30*16, 30*13));
				addEntity(new Coin (handler,30*18, 30*13));
				addEntity(new Coin (handler,30*20, 30*13));
				addEntity(new Coin (handler,30*22, 30*13));
				addEntity(new Coin (handler,30*23, 30*13));
				addEntity(new Coin (handler,30*24, 30*13));
				addEntity(new Coin (handler,30*25, 30*13));
				addEntity(new Coin (handler,30*26, 30*13));
				addEntity(new Coin (handler,30*28, 30*13));
				
				addEntity(new Coin(handler,30,30*14));
				addEntity(new Coin (handler,30*3, 30*14));
				addEntity(new Coin (handler,30*7, 30*14));
				addEntity(new Coin (handler,30*9, 30*14));
				addEntity(new Coin (handler,30*11, 30*14));
				addEntity(new Coin (handler,30*13, 30*14));
				addEntity(new Coin (handler,30*16, 30*14));
				addEntity(new Coin (handler,30*20, 30*14));
				addEntity(new Coin (handler,30*22, 30*14));
				addEntity(new Coin (handler,30*26, 30*14));
				addEntity(new Coin (handler,30*28, 30*14));

				addEntity(new Coin(handler,30,30*15));
				addEntity(new Coin (handler,30*3, 30*15));
				addEntity(new Coin (handler,30*4, 30*15));
				addEntity(new Coin (handler,30*5, 30*15));
				addEntity(new Coin (handler,30*6, 30*15));
				addEntity(new Coin (handler,30*7, 30*15));
				addEntity(new Coin (handler,30*9, 30*15));
				addEntity(new Coin (handler,30*11, 30*15));
				addEntity(new Coin (handler,30*12, 30*15));
				addEntity(new Coin (handler,30*13, 30*15));
				addEntity(new Coin (handler,30*14, 30*15));
				addEntity(new Coin (handler,30*15, 30*15));
				addEntity(new Coin (handler,30*16, 30*15));
				addEntity(new Coin (handler,30*17, 30*15));
				addEntity(new Coin (handler,30*18, 30*15));
				addEntity(new Coin (handler,30*20, 30*15));
				addEntity(new Coin (handler,30*22, 30*15));
				addEntity(new Coin (handler,30*23, 30*15));
				addEntity(new Coin (handler,30*24, 30*15));
				addEntity(new Coin (handler,30*25, 30*15));
				addEntity(new Coin (handler,30*26, 30*15));
				addEntity(new Coin (handler,30*28, 30*15));
				
				addEntity(new Coin(handler,30,30*16));
				addEntity(new Coin (handler,30*3, 30*16));
				addEntity(new Coin (handler,30*7, 30*16));
				addEntity(new Coin (handler,30*9, 30*16));
				addEntity(new Coin (handler,30*11, 30*16));
				addEntity(new Coin (handler,30*12, 30*16));
				addEntity(new Coin (handler,30*17, 30*16));
				addEntity(new Coin (handler,30*18, 30*16));
				addEntity(new Coin (handler,30*20, 30*16));
				addEntity(new Coin (handler,30*22, 30*16));
				addEntity(new Coin (handler,30*26, 30*16));
				addEntity(new Coin (handler,30*28, 30*16));
				
				addEntity(new Coin(handler,30,30*16));
				addEntity(new Coin (handler,30*3, 30*16));
				addEntity(new Coin (handler,30*7, 30*16));
				addEntity(new Coin (handler,30*9, 30*16));
				addEntity(new Coin (handler,30*11, 30*16));
				addEntity(new Coin (handler,30*18, 30*16));
				addEntity(new Coin (handler,30*20, 30*16));
				addEntity(new Coin (handler,30*22, 30*16));
				addEntity(new Coin (handler,30*26, 30*16));
				addEntity(new Coin (handler,30*28, 30*16));
				
				
				addEntity(new Coin(handler,30,30*17));
				addEntity(new Coin (handler,30*3, 30*17));
				addEntity(new Coin (handler,30*7, 30*17));
				addEntity(new Coin (handler,30*9, 30*17));
				addEntity(new Coin (handler,30*11, 30*17));
				addEntity(new Coin (handler,30*18, 30*17));
				addEntity(new Coin (handler,30*20, 30*17));
				addEntity(new Coin (handler,30*22, 30*17));
				addEntity(new Coin (handler,30*26, 30*17));
				addEntity(new Coin (handler,30*28, 30*17));
				
				addEntity(new Coin(handler,30,30*18));
				addEntity(new Coin (handler,30*3, 30*18));
				addEntity(new Diamond (handler,30*7, 30*18));
				addEntity(new Coin (handler,30*11, 30*18));
				addEntity(new Coin (handler,30*12, 30*18));
				addEntity(new Coin (handler,30*13, 30*18));
				addEntity(new Coin (handler,30*14, 30*18));
				addEntity(new Coin (handler,30*15, 30*18));
				addEntity(new Coin (handler,30*16, 30*18));
				addEntity(new Coin (handler,30*17, 30*18));
				addEntity(new Coin (handler,30*18, 30*18));
				addEntity(new Diamond (handler,30*22, 30*18));
				addEntity(new Coin (handler,30*26, 30*18));
				addEntity(new Coin (handler,30*28, 30*18));
				
			//ADD GHOST
				
				addEntity(new Ghost1(handler, 30*14, 30*18)); 
				addEntity(new Ghost2(handler, 30*14, 30*19));
				addEntity(new Ghost2 (handler, 30*7, 30*4));
				addEntity(new Ghost3(handler,30*4, 30*6));
				
				
		
	}
	
	//GETTERS && SETTERS

	public HandleClass getHandler() {
		return handler;
	}

	public void setHandler(HandleClass handler) {
		this.handler = handler;
	}

	

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		EntityManager.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	
	
	
}
