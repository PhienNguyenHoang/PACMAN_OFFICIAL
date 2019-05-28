package entity;

public abstract class Creature extends Entity {
	public static final int DEFAULT_LIVE=2;
	public static final int DEFAULT_WIDTH=28;
	public static final int DEFAULT_HEIGHT=28;
	public static final float DEFAULT_SPEED=2.0f;
	protected int lives;
	protected float speed;
	protected float xMove,yMove;
	

	public Creature(float x, float y,int width,int height) {
		super(x, y,width,height);
		lives = DEFAULT_LIVE;
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
		
	}
	public void move() {
		x+=xMove;
		y+=yMove;
	}
	
	
	public float getxMove() {
		return xMove;
	}


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}


	public float getyMove() {
		return yMove;
	}


	public void setyMove(float yMove) {
		this.yMove = yMove;
	}



	
	
	
}
