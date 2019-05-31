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
	public Animation ghost;
	public boolean up=true,down,left,right;
	public Ghost1(HandleClass handler, float x, float y) {

		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		
		bounds.x=0;
		bounds.y=0;
		bounds.width=27;
		bounds.height=27;
		
		ghost=new Animation(500,Assets.blinky);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		ghost.tick();
		gMove();
		move();
		
		
	}
	public void gMove() {
		xMove=0;
		yMove=0;
		int hor=(int) super.x;
		int ver=(int) super.y;
		int w=Tile.TILEWIDTH;
		//System.out.println("Up: " + up + "Down: " + down + "Right: "+right +"Left: "+left);
		if(up) {
			if(World.World.tiles[hor/w][(ver+29)/w-1]==0) {
				yMove-=speed;
			}
			else {
				if(World.World.tiles[hor/w+1][ver/w]==0 && World.World.tiles[hor/w-1][ver/w]==0) {
					int r= new Random().nextInt(2);
					if(r==1) {
						xMove-=speed;
						up=false;
						left=true;
					}
					else {
						xMove+=speed;
						up=false;
						right=true;
					}
				}
				else if(World.World.tiles[hor/w-1][ver/w]==0) {
					xMove-=speed;
					up=false;
					left=true;
				}
				else if(World.World.tiles[hor/w+1][ver/w]==0) {
					xMove+=speed;
					up=false;
					right=true;
				}
				else {
					yMove+=speed;
					up=false;
					down=true;
				}
			}
		}

		if(down) {
			if(World.World.tiles[hor/w][(ver-29)/w+2]==0) {
				
				yMove+=speed;
				
			}
			else {
				if(World.World.tiles[hor/w+1][ver/w]==0 && World.World.tiles[hor/w-1][ver/w]==0) {
					int r= new Random().nextInt(2);
					if(r==1) {
						xMove-=speed;
						down=false;
						left=true;
					}
					else {
						xMove+=speed;
						down=false;
						right=true;
					}
				}
				else if(World.World.tiles[hor/w-1][ver/w]==0) {
					xMove-=speed;
					down=false;
					left=true;
				}
				else if(World.World.tiles[hor/w+1][ver/w]==0) {
					xMove+=speed;
					down=false;
					right=true;
				}
				else {
					yMove-=speed;
					down=false;
					up=true;
				}
			}
		}
		//System.out.println(World.World.tiles[(hor+29)/w-1][ver/w]);
		if(left) {
			if(World.World.tiles[(hor+29)/w-1][ver/w]==0) {
				xMove-=speed;
			}
			else {
				if(World.World.tiles[hor/w][ver/w+1]==0 && World.World.tiles[hor/w][ver/w-1]==0) {
					int r= new Random().nextInt(2);
					if(r==1) {
						yMove-=speed;
						left=false;
						up=true;
					}
					else {
						yMove+=speed;
						left=false;
						down=true;
					}
				}
				else if(World.World.tiles[hor/w][ver/w-1]==0) {
					yMove-=speed;
					left=false;
					up=true;
				}
				else if(World.World.tiles[hor/w][ver/w+1]==0) {
					yMove+=speed;
					left=false;
					down=true;
				}
				else {
					xMove+=speed;
					left=false;
					right=true;
				}
			}
		}
		//System.out.print(World.World.tiles[(hor-29)/w+2][ver/w]);
		if(right) {
			if(World.World.tiles[(hor-29)/w+2][ver/w]==0) {
				xMove+=speed;
			}
			else {
				if(World.World.tiles[hor/w][ver/w+1]==0 && World.World.tiles[hor/w][ver/w-1]==0) {
					int r= new Random().nextInt(2);
					if(r==1) {
						yMove-=speed;
						right=false;
						up=true;
					}
					else {
						yMove+=speed;
						right=false;
						down=true;
					}
				}
				else if(World.World.tiles[hor/w][ver/w-1]==0) {
					yMove-=speed;
					right=false;
					up=true;
				}
				else if(World.World.tiles[hor/w][ver/w+1]==0) {
					yMove+=speed;
					right=false;
					down=true;
				}
				else {
					xMove-=speed;
					right=false;
					left=true;
				}
			}
		}
		
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);
		
	}

	private BufferedImage getCurrentAnimationFrame() {
		// TODO Auto-generated method stub
		return ghost.getCurrentFrame();
	}
	

}
