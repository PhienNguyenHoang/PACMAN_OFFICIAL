package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import Graphics.Animation;
import Graphics.Assets;
import game.HandleClass;
import tiles.Tile;

public class Ghost1 extends Creature {
	
	public Animation ghost1;
	public boolean up=true,down,left,right;
	
	public Ghost1(HandleClass handler, float x, float y) {

		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		
		bounds.x=0;
		bounds.y=0;
		bounds.width=25;
		bounds.height=25;
		
		
		//Animation
		ghost1= new Animation(500,Assets.blinky);
	
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		ghost1.tick();
		
		
		gMove();
		
		move();
		
		
	}
	public void gMove() {
		xMove=0;
		yMove=0;
		int hor=(int) super.x;
		int ver=(int) super.y;
		int w=Tile.TILEWIDTH;
//		System.out.println(EntityManager.player.getX()+ " "+ EntityManager.player.getY() );
//		System.out.println(super.x +" "+ super.y);
		//System.out.println("Up: " + up + "Down: " + down + "Right: "+right +"Left: "+left);
		
		// if GHOST moves UP
		if(up) {
			//Check tiles ahead is wall or blackTile
			//
			if(World.World.tiles[hor/w][(ver+29)/w-1]==0) {
				yMove-=speed;//move up one position
			}
			else {
				
				//if UP is wall =>> check if LEFT and RIGHT are not wall 
				if(World.World.tiles[hor/w+1][ver/w]==0 && World.World.tiles[hor/w-1][ver/w]==0) {
					int r= new Random().nextInt(2);// random direction to go (1 for left, 2 for right)
					if(r==1) {
						xMove-=speed;//move left
						up=false;
						left=true;
					}
					else {
						xMove+=speed;//move right
						up=false;
						right=true;
					}
				}
				// if only LEFT is not wall 
				else if(World.World.tiles[hor/w-1][ver/w]==0) {
					xMove-=speed;//move left
					up=false;
					left=true;
				}
				//if only right is not wall 
				else if(World.World.tiles[hor/w+1][ver/w]==0) {
					xMove+=speed;//move right
					up=false;
					right=true;
				}
				//if only DOWN is not wall 
				else {
					yMove+=speed;//move down 
					up=false;
					down=true;
				}
			}
		}
		//if ghost moves DOWN
		if(down) {
			//check next down tile is not wall 
			if(World.World.tiles[hor/w][(ver-29)/w+2]==0) {
				
				yMove+=speed;//move down
				
			}
			else {
				//if next down tile is wall 
				// if neft and right are not wall 
				if(World.World.tiles[hor/w+1][ver/w]==0 && World.World.tiles[hor/w-1][ver/w]==0) {
					int r= new Random().nextInt(2);//random to go left or right 
					if(r==1) {
						xMove-=speed;//move left
						down=false;
						left=true;
					}
					else {
						xMove+=speed;//move right
						down=false;
						right=true;
					}
				}
				//if only left is not wall 
				else if(World.World.tiles[hor/w-1][ver/w]==0) {
					xMove-=speed;//move left
					down=false;
					left=true;
				}
				//if only right is not wall 
				else if(World.World.tiles[hor/w+1][ver/w]==0) {
					xMove+=speed;//move right
					down=false;
					right=true;
				}
				//if only up is not wall 
				else {
					yMove-=speed;//move up 
					down=false;
					up=true;
				}
			}
		}
		//System.out.println(World.World.tiles[(hor+29)/w-1][ver/w]);
		
		
		//ghost move LEFT
		if(left) {
			// if next left tile is not wall 
			if(World.World.tiles[(hor+29)/w-1][ver/w]==0) {
				xMove-=speed;//move left
			}
			else {
				//if left is wall
				//if up and down are not wall 
				if(World.World.tiles[hor/w][ver/w+1]==0 && World.World.tiles[hor/w][ver/w-1]==0) {
					int r= new Random().nextInt(2);//random to go up or down 
					if(r==1) {
						yMove-=speed;//move up 
						left=false;
						up=true;
					}
					else {
						yMove+=speed;//move down
						left=false;
						down=true;
					}
				}
				//if only up is not wall 
				else if(World.World.tiles[hor/w][ver/w-1]==0) {
					yMove-=speed;//move up 
					left=false;
					up=true;
				}//if only right is not wall 
				else if(World.World.tiles[hor/w][ver/w+1]==0) {
					yMove+=speed;//move down
					left=false;
					down=true;
				}
				
				//if only right is not wall
				else {
					xMove+=speed;//move right
					left=false;
					right=true;
				}
			}
		}
		//System.out.print(World.World.tiles[(hor-29)/w+2][ver/w]);
		
		
		//if GHOST moves RIGHT
		if(right) {
			//if next right tile is not wall 
			if(World.World.tiles[(hor-29)/w+2][ver/w]==0) {
				xMove+=speed;//move right
			}
			else {
				//if next right tile is wall 
				//if up and down are not wall 
				if(World.World.tiles[hor/w][ver/w+1]==0 && World.World.tiles[hor/w][ver/w-1]==0) {
					int r= new Random().nextInt(2);//random to go up or down 
					if(r==1) {
						yMove-=speed;//move up 
						right=false;
						up=true;
					}
					else {
						yMove+=speed;//move down 
						right=false;
						down=true;
					}
				}
				
				//if only up is not wall 
				else if(World.World.tiles[hor/w][ver/w-1]==0) {
					yMove-=speed;//move up 
					right=false;
					up=true;
				}
				
				//if only down is not wall 
				else if(World.World.tiles[hor/w][ver/w+1]==0) {
					yMove+=speed;//move down 
					right=false;
					down=true;
				}
				//if only left is not wall 
				else {
					xMove-=speed;//move left
					right=false;
					left=true;
				}
			}
		}
		
	}
	
	


	
		


		
	
	
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		if (handler.getGame().getFrighten()==true) {
			g.drawImage(Assets.frighten,(int) x, (int) y,width,height, null);
			
		}
		else {
		
			g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);
		}
		
	}
	private BufferedImage getCurrentAnimationFrame() {
		return ghost1.getCurrentFrame();
		
		
	}
	
	
	public void die() {}

	
	

}
