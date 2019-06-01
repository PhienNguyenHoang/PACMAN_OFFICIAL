package entity;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import Graphics.Animation;
import Graphics.Assets;
import State.GameState;
import State.State;
import entitystatic.Coin;
import entitystatic.Diamond;
import game.HandleClass;



public class Player extends Creature {
	
	private HandleClass handler;
	private Animation pac_left,pac_right;
	public static int pX,pY;
	private GameState gameState;
	
	public Player(HandleClass handler, float x, float y) {
		super(handler, x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		this.handler = handler;

		
		pac_left= new Animation(300,Assets.pac_left);
		pac_right= new Animation(300,Assets.pac_right);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 25;
		bounds.height = 25;
	}

	@Override
	public void tick() {
		pac_left.tick();
		pac_right.tick();
		getInput();
		move();
		checkAttack();
        checkScore();;
		
		
	}
	
	public void checkAttack() {
	        
	        Rectangle cb = getCollisionBounds(0,0);   
	        Rectangle ar = new Rectangle();    
	        int arSize = 10;             
	        ar.width = arSize;                          
	        ar.height = arSize;     

	        if (handler.getKeyManager().up) {                  
	            ar.x = cb.x + cb.width / 2 - arSize / 2; 
	            ar.y = cb.y - arSize /2  + 30; 
	        } else if (handler.getKeyManager().down) {            
	            ar.x = cb.x + cb.width / 2 - arSize / 2;
	            ar.y = cb.y + cb.height - 40;
	        } else if (handler.getKeyManager().left) {
	            ar.x = cb.x - arSize + 60;
	            ar.y = cb.y + cb.height / 2 - arSize / 2 + 20;
	        } else if (handler.getKeyManager().right) {
	            ar.x = cb.x + cb.width - 40;
	            ar.y = cb.y + cb.height / 2 - arSize / 2 + 20;
	        }
	        else{
	            ar.x = cb.x - arSize + 40;
	            ar.y = cb.y + cb.height / 2 - arSize / 2;
	        }

	        
	        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
	            if (e.equals(this)) {
	                continue;
	            }
	            if (e.getCollisionBounds(0,0).intersects(ar)) {
	                if(e instanceof Ghost1 || e instanceof Ghost2){
	                    die();
	                    
	                    return;
	                }
	                e.eat(10);
	                handler.getGame().setScore(1);
	                return;
	            }

	        }   
	    }
	    
	 
	  public boolean winner;
	    
	  private void checkScore(){
	        
	        int count = 0;
	        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
	            if((e instanceof Coin)||(e instanceof Diamond)) {
	                count++;
	            }
	        }
	           
	     }
	    
	    
	    
	   

	    private BufferStrategy br;
	    
	    @Override
	    public void die() {
	        active = true;
	    }
	    
	    public void getInput() {
		xMove=0;
		yMove=0;
		
		if(handler.getKeyManager().up) {
			yMove= -speed;
		}
		if(handler.getKeyManager().down) {
			yMove= speed;
		}
		if(handler.getKeyManager().right) {
			xMove= speed;
		}
		if(handler.getKeyManager().left) {
			xMove= -speed;
		}
		/* if(handler.getKeyManager().escape){
	            active = true;
	            State.setCurrentState(handler.getGame().menuState);*/
	 }
	        
	
	
	

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);
		
		g.setFont(new Font("Sergiue", Font.BOLD, 25));
       g.drawString("Score : " + handler.getGame().getScore()  /*handler.getGame().getCanvas().getWidth() - 150 , 50*/, 30*26,30);
	}
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove<0) {
			return pac_left.getCurrentFrame(); 
		}
		else if(xMove>0) {
			return pac_right.getCurrentFrame();
		}
		return pac_right.getCurrentFrame();
	}
	
}
