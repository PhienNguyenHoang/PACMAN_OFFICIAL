package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Graphics.Animation;
import Graphics.Assets;
import World.World;
import game.HandleClass;
import tiles.Tile;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Ghost4 extends Creature {
	public Animation ghost4;
	public int [][] visited=new int[30][20];
	public boolean up=true,down,right,left,chase=false;

	private int xBefore;
	private int yBefore;

	
	public Ghost4(HandleClass handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width=25;
		bounds.height=25;
		
		ghost4=new Animation(500,Assets.pinky);
		
	}
	
	

	@Override
	public void tick() {
		ghost4.tick();
		
		chase= BFS();
		System.out.print("Chase: " + chase);
		if(chase==false) {
			gMove();
		}
		else {
			System.out.println("Up: " + up + "Down: " + down + "Right: "+right +"Left: "+left);
			chasing(findPath());
		}
		
		move();
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
		return ghost4.getCurrentFrame();
		
		
	}
	class Coordinate {
		public int x,y;
		public Coordinate(int x, int y) {
			this.x=x;
			this.y=y;
			}}

	
	public void gMove() {
		xMove=0;
		yMove=0;
		int hor=(int) super.x;
		int ver=(int) super.y;
		int w=Tile.TILEWIDTH;
	//	System.out.println(EntityManager.player.getX()+ " "+ EntityManager.player.getY() );
//		System.out.println(super.x +" "+ super.y);
		//System.out.println("Up: " + up + "Down: " + down + "Right: "+right +"Left: "+left);
		if(up) {
			if(World.tiles[hor/w][(ver+29)/w-1]==0) {
				yMove-=speed;
			}
			else {
				if(World.tiles[hor/w+1][ver/w]==0 && World.tiles[hor/w-1][ver/w]==0) {
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
				else if(World.tiles[hor/w-1][ver/w]==0) {
					xMove-=speed;
					up=false;
					left=true;
				}
				else if(World.tiles[hor/w+1][ver/w]==0) {
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
			if(World.tiles[hor/w][(ver-29)/w+2]==0) {
				
				yMove+=speed;
				
			}
			else {
				if(World.tiles[hor/w+1][ver/w]==0 && World.tiles[hor/w-1][ver/w]==0) {
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
				else if(World.tiles[hor/w-1][ver/w]==0) {
					xMove-=speed;
					down=false;
					left=true;
				}
				else if(World.tiles[hor/w+1][ver/w]==0) {
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
			if(World.tiles[(hor+29)/w-1][ver/w]==0) {
				xMove-=speed;
			}
			else {
				if(World.tiles[hor/w][ver/w+1]==0 && World.tiles[hor/w][ver/w-1]==0) {
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
				else if(World.tiles[hor/w][ver/w-1]==0) {
					yMove-=speed;
					left=false;
					up=true;
				}
				else if(World.tiles[hor/w][ver/w+1]==0) {
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
			if(World.tiles[(hor-29)/w+2][ver/w]==0) {
				xMove+=speed;
			}
			else {
				if(World.tiles[hor/w][ver/w+1]==0 && World.tiles[hor/w][ver/w-1]==0) {
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
				else if(World.tiles[hor/w][ver/w-1]==0) {
					yMove-=speed;
					right=false;
					up=true;
				}
				else if(World.tiles[hor/w][ver/w+1]==0) {
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
	private boolean BFS(){
		xMove=0f;
		yMove=0f;

		for(int i=0;i<30;i++) {
			for(int j=0;j<20;j++) {
				visited[i][j]=0;
				
			}
		}
		Queue<Coordinate> queue=new LinkedList<>();
		int x = 0, y = 0;

		System.out.println("x before: " + super.x + "; y before " + super.y);
		if (up) {
			x = (int)super.x / Tile.TILEHEIGHT;
			y = (int)(super.y + Tile.TILEHEIGHT -  5) / Tile.TILEHEIGHT;
		}
		else if (down) {
			x = (int)super.x / Tile.TILEHEIGHT;
			y = (int)(super.y) / Tile.TILEHEIGHT;
		}
		else if (left) {
			x = (int)(super.x + Tile.TILEHEIGHT - 5) /Tile.TILEHEIGHT;
			y = (int)(super.y) / Tile.TILEHEIGHT;
		}
		else if (right) {
			x = (int)(super.x + 5) / Tile.TILEHEIGHT;
			y = (int)(super.y) / Tile.TILEHEIGHT;
		}
		this.xBefore = x;
		this.yBefore = y;
		System.out.println("x before: " + this.xBefore + "; y before " + this.yBefore);
		queue.add(new Coordinate(x, y));

		visited[x][y]=1;
		//System.out.print("---------------------------------"+ EntityManager.player.getX() +" "+ EntityManager.player.getY());
		while (queue.size() != 0) 
        { 
			
            // Dequeue a vertex from queue and print it 
            Coordinate s = queue.poll();
          
            if(visited[s.x][s.y]>=5) {
//            	for(int i=0;i<20;i++) {
//        			for(int j=0;j<30;j++) {
//        				System.out.print(visited[j][i] + " ");    				
//        			}
//        			System.out.println();
//        		}
//            	
            	chase=false;
            	return false;
            }
            else if(s.x==(int)EntityManager.player.getX() / Tile.TILEHEIGHT && s.y == (int)EntityManager.player.getY() / Tile.TILEHEIGHT) {
//            	for(int i=0;i<20;i++) {
//        			for(int j=0;j<30;j++) {
//        				System.out.print(visited[j][i] + " ");    				
//        			}
//        			System.out.println();
//        		}
//            	System.out.println("true true true");
            	chase=true;
            	return true;
            }
//            System.out.print(s+" "); 
//            System.out.print(" x : " +s.x +" y : "+s.y);
            if(s.y > 0 && World.tiles[s.x][s.y - 1] == 0 && visited[s.x][s.y - 1] == 0) {
            	queue.add(new Coordinate(s.x,s.y-1));
            	visited[s.x][s.y - 1] = visited[s.x][s.y]+1;
            }
            
            
            if(s.x < 29 && World.tiles[s.x+1][s.y]==0 && visited[s.x+1][s.y] == 0) {
            	queue.add(new Coordinate(s.x+1,s.y) );
            	visited[s.x+1][s.y]=visited[s.x][s.y]+1;
            }
            if(s.y < 19 && World.tiles[s.x][s.y+1]==0 && visited[s.x][s.y + 1] == 0) {
            	queue.add(new Coordinate(s.x,s.y+1) );
            	visited[s.x][s.y+1]=visited[s.x][s.y]+1;
            }
            if(s.x > 1 && World.tiles[s.x-1][s.y ] == 0 && visited[s.x-1][s.y] == 0) {
            	queue.add(new Coordinate(s.x-1,s.y));
            	visited[s.x-1][s.y] = visited[s.x][s.y]+1;
            }
    		
    		}
		
			
		
		return false;
	
	 
		
			
		}
	public Coordinate findPath() {
		int q = visited[(int) EntityManager.player.getX() /Tile.TILEHEIGHT][(int) EntityManager.player.getY() /Tile.TILEHEIGHT];
//		System.out.println("First q:" + q);
		int x=(int) EntityManager.player.getX() / Tile.TILEHEIGHT,y=(int) EntityManager.player.getY() / Tile.TILEHEIGHT;
		while(q>2) {
			if(visited[x-1][y]==q - 1) {
				q--;
				x=x-1;
			}
			else if(visited[x+1][y]==q - 1) {
				q--;
				x=x+1;
			}
			else if(visited[x][y-1]==q - 1) {
				q--;
				y=y-1;
			}
			else if(visited[x][y+1]== q - 1){
				q--;
				y=y+1;
			}
			
		}
		
//		System.out.println("Path " + x + " " + y);
		return new Coordinate(x,y);

		
	}
	public void chasing(Coordinate p) {
		
		int x = p.x - this.xBefore;
		int y = p.y - this.yBefore;
		
		System.out.println("speed x: " + x);
		System.out.println("Speed y: " + y);
		
		
		if (y <= -1) {
			y = -1;
			up = true;
			down = false;
			left = false;
			right = false;
		}
		else if ( y >= 1) {
			y = 1;
			up = false;
			down = true;
			left = false;
			right = false;
		}
		else if (x <= -1) {
			x = -1;
			up = false;
			down = false;
			left = true;
			right = false;
		}
		
		else if (x >= 1) {
			x = 1;
			up = false;
			down = false;
			left = false;
			right = true;
		}
		xMove+=x*speed;
		yMove+=y*speed;
		gMove();
		
		
	}



	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}


}
