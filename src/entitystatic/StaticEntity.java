package entitystatic;

import entity.Creature;
import entity.Entity;
import game.HandleClass;

public abstract class StaticEntity extends Entity {
	
	public final static int STATICENTITY_DEFAULT_WIDTH=30,STATICENTITY_DEFAULT_HEIGHT=30;
	public StaticEntity ( HandleClass handler, float x, float y , int width, int height  ) {
		super ( handler, x, y ,Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT); 
	}
	
	public void tick() {
		
	}
	public void render() {
		
	}
	
	
	

}
