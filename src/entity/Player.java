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
	        
	        Rectangle cb = this.getCollisionBounds();  //cb is the boundary box of the player 
	           

	        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
	        	//boolean frighten=true; 
	            if (e.equals(this)) {  // if entity is the player
	                continue; // skip and continue to another entity
	            }
	            
	            if (e.getCollisionBounds().intersects(cb)) {  // check if the boundary box of being scanned entity intersects with the boundary box of the player
	           
	                if(e instanceof Ghost1 ||e instanceof Ghost2 || e instanceof Ghost3 || e instanceof Ghost4){ // if entity is one of the Ghosts
	                
	                	if(handler.getGame().getFrighten()==true) { // if the player has earned a diamond and still in the time of first 3 seconds
	                		e.beEaten(1); // Ghost is eaten by player
	                		handler.getGame().setScore(100); // Bonus 100 points 
	                		return;
	                	}
	                	else {
	                		this.beEaten(1); // if player has not collected a diamond or out of the time of the first 3 seconds after having it  
	                		handler.getGame().setLives(1); // player live decreases by one
	                		newPos(); // set new position for player
	                		if(handler.getGame().getLives()==0) {                		
	                			handler.getState().setState(new EndingState(handler)); // if die == > GAME OVER 
	                		}
	                	}
	               		return;
	                   
	                }
	               	
	                if(e instanceof Diamond) { //if entity is a diamond
	                	
	                	e.beEaten(1); // diamond is eaten 
	                	handler.getGame().setScore(100); //bonus 100 points
	                	handler.getGame().setFrighten(true); 
	                	Timer timer = new Timer(3000, new ActionListener() { // use timer to set 3 seconds for eating back the Ghosts
	                		  @Override
	                		  public void actionPerformed(ActionEvent arg0) {
	                			  handler.getGame().setFrighten(false);
	                		  }
	                		});
	                		timer.setRepeats(false);// after 3 seconds, the ghosts back to initial state 
	                		timer.start(); 
	                	
            			return;
	                	
                	}
	                else { //if entity is a coin
    
	                	e.beEaten(3); // coin is eaten 
	                	handler.getGame().setScore(10); //set 10 points 
	                	return;
	                }
	            }    
	       }
	        
	}
	     
	    
	public void newPos() { // method new position called for after player loses one life
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
		 
		 if (handler.getGame().getScore()>= 1500) {
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
