package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import Graphics.Animation;
import Graphics.Assets;
import State.EndingState;
import State.GameState;

import State.WinnerState;

import entitystatic.Diamond;

import game.HandleClass;

import sun.audio.AudioPlayer;
import javax.swing.Timer; 



public class Player extends Creature {
	
	
	private Animation pac_left,pac_right;

	
	

	
	public boolean up=true,down,right,left,die;
	
	private HashMap<String,AudioPlayer> sfx ;
	
	
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
		sfx = new HashMap<String,AudioPlayer>();
//		sfx.put("eat", new AudioPlayer("/Sound/pacman_eatfruit.wav"));
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
        checkWin();
		
		
	}
	
	
	
	public void checkAttack() {
	        
	        Rectangle cb = this.getCollisionBounds();   
	           

	        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
	        	//boolean frighten=true; 
	            if (e.equals(this)) {
	                continue;
	            }
	            
	            if (e.getCollisionBounds().intersects(cb)) {
	           
	                if(e instanceof Ghost1 ||e instanceof Ghost2 || e instanceof Ghost3 || e instanceof Ghost4){
	                
	                	if(handler.getGame().getFrighten()==true) {
	                		e.beEaten(3);
	                		handler.getGame().setScore(100);
	                		return;
	                	}
	                	else {
	                		this.beEaten(1); 
	                		handler.getGame().setLives(1);
	                		newPos();
	                		if(handler.getGame().getLives()==0) {                		
	                			handler.getState().setState(new EndingState(handler));
	                		}
	                	}
	               		return;
	                   
	                }
	               	
	                if(e instanceof Diamond) {
	                	
	                	e.beEaten(3);
	                	handler.getGame().setScore(100);
	                	handler.getGame().setFrighten(true);
	                	Timer timer = new Timer(3000, new ActionListener() {
	                		  @Override
	                		  public void actionPerformed(ActionEvent arg0) {
	                			  handler.getGame().setFrighten(false);
	                		  }
	                		});
	                		timer.setRepeats(false);
	                		timer.start(); 
	                	
            			return;
	                	
                	}
	                else {
    
	                	e.beEaten(3);
	                	handler.getGame().setScore(10);
	                	return;
	                }
	            }    
	       }
	        
	}
	     
	        
	
	                  
	    
	public void newPos() {
		super.x=30*20;
		super.y=30*9;
		
	}

	 
	    
	 private void checkWin(){
		 
		 // Check win if eat all coin ==> win
	        
//	        int count = 0;
//	        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
//	            if((e instanceof Coin)||(e instanceof Diamond)) {
//	                count++;
//	            }
//	        }
//	        
//	       	if(count==0) {
//	       		handler.getState().setState(new WinnerState(handler));;
//	        }
		 
		 if (handler.getGame().getScore()== 1500) {
			 handler.getState().setState(new WinnerState(handler));
		 }
//	        
	        
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
	    	if(handler.getKeyManager().escape){
	         die();
	         handler.getState().setState(new EndingState(handler));
	    	}
	    }
	    
	   

	

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);
		g.setColor(Color.red);
		g.setFont(new Font("Sergiue", Font.BOLD, 20));
		g.drawString("SCORE : " + handler.getGame().getScore()  /*handler.getGame().getCanvas().getWidth() - 150 , 50*/, 30*25,28);
		g.drawString("LIVES: "+ handler.getWorld().getEntityManager().getPlayer().getHealth(),30*2,28);
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
