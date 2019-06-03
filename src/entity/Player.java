package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import Graphics.Animation;
import Graphics.Assets;
import State.GameState;
import State.State;
import entitystatic.Coin;
import entitystatic.Diamond;
import game.HandleClass;
import input.KeyManager;



public class Player extends Creature {
	
	
	private Animation pac_left,pac_right;

	
	
	public boolean dead=false; 
	public boolean winner=true; 

	private GameState gameState;
	public boolean up=true,down,right,left;
	

	
	public Player(HandleClass handler, float x, float y) {
		
		//super 
		super(handler, x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
	
		

		//Animation
		pac_left= new Animation(300,Assets.pac_left);
		pac_right= new Animation(300,Assets.pac_right);
		
		
		//Bounds
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 25;
		bounds.height = 25;
	}

	@Override
	public void tick() {
		
		//ANIMATION
		pac_left.tick();
		pac_right.tick();
		
		//MOVEMENT
		getInput();
		move();
		
		//eat
		checkAttack();
        checkScore();;
		
		
	}
	
	private boolean frighten= false; 
	
	public void checkAttack() {
	        
	        Rectangle cb = getCollisionBounds();   
	        Rectangle ar = new Rectangle();    
	        int arSize =5;             
	        ar.width = arSize;                          
	        ar.height = arSize;     

	        if (handler.getKeyManager().up) { 
	        	ar.x = cb.x + cb.width/ 2 - arSize / 2; 
        		ar.y = cb.y - arSize +10 ;      
	        } else if (handler.getKeyManager().down) {            
	            ar.x = cb.x + cb.width / 2 - arSize  / 2 +10;
	            ar.y = cb.y + cb.height -10 ;
	        } else if (handler.getKeyManager().left) {
	            ar.x = cb.x - arSize+10; 
	            ar.y = cb.y + cb.height / 2 - arSize / 2; 
	        } else if (handler.getKeyManager().right) {
	            ar.x = cb.x + cb.width ;
	            ar.y = cb.y + cb.height / 2 - arSize / 2; 
	        }
	        else{
	        	return;
	            //ar.x = cb.x - arSize ;
	            //ar.y = cb.y + cb.height / 2 - arSize / 2;
	        }

	        
	        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
	            if (e.equals(this)) {
	                continue;
	            }
	            if (e.getCollisionBounds().intersects(ar)) {
	                if(e instanceof Ghost1 ||e instanceof Ghost2){
	                	this.beEaten(1);
	                	
	                    //die();
	                    //handler.getGame().getG().drawString("You are Killed. Your Score : " + handler.getGame().getScore(), 300, 200);
	                    return;
	                }
	                	
	                if(e instanceof Diamond) {
	                	frighten= true;
	                	e.beEaten(3);
	                	handler.getGame().setScore(10);
	                	return;
	                }
	                
	                e.beEaten(3);
                	handler.getGame().setScore(1);
	                return;
	            }
	        }
	                  
	    }
	    
	
	
	
	 
	  //public boolean winner;
	    
	  private void checkScore(){
	        
	        int count = 0;
	        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
	            if((e instanceof Coin)||(e instanceof Diamond)) {
	                count++;
	            }
	        }
	           
	     }
	  
	  
	  
	 

	   
	    
	    @Override
	    public void die() {
	    	
	    	System.out.print("lose");
	    }
	    
	    public void getInput() {
		
	    	xMove=0;
	    	yMove=0;
		
	    	if(handler.getKeyManager().up) {
			yMove= -speed;
			up=true;
			down=false;
			right=false;
			left=false;
	    	}
	    	if(handler.getKeyManager().down) {
			yMove= speed;
			down=true;
			up=false;
			right=false;
			left=false;
	    	}
	    	if(handler.getKeyManager().right) {
			xMove= speed;
			right=true;
			up=false;
			down=false;
			left=false;
			
	    	}
	    	if(handler.getKeyManager().left) {
			xMove= -speed;
			left=true;
			right=false;
			up=false;
			down=false;
	    	}
	    	/*if(handler.getKeyManager().escape){
	         dead = true;
	         State.setState(handler.getGame().getMenuState());
	    	}*/
	    }
	        
	
	public boolean getFrighten() {
		return frighten; 
	}
//	public boolean getDirection(int key) {
//		if(up)
//		return up;
//		else if(key==KeyEvent.VK_S)
//			return down;
//		else if(key==KeyEvent.VK_D)
//			return right;
//		else if(key==KeyEvent.VK_A)
//			return left;
//		
//		return false;
//		
//	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Sergiue", Font.BOLD, 25));
		g.drawString("Score : " + handler.getGame().getScore()  /*handler.getGame().getCanvas().getWidth() - 150 , 50*/, 30*20,30);
		g.drawString("Lives: "+ handler.getWorld().getEntityManager().getPlayer().getHealth(),30*20,30*2);
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
