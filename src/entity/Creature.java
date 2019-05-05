package entity;

public abstract class Creature extends Entity {
	protected int lives;
	
	
	public Creature(float x, float y) {
		super(x, y);
		lives = 2;
	}
	
	
	
}
