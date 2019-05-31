package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Graphics.Animation;
import Graphics.Assets;
import game.HandleClass;
import java.math.*;
import java.util.LinkedList;
import java.util.Queue;

public class Ghost2 extends Creature {
	public Animation ghost1;
	public int [][] visited=new int[30][20];
	
	public Ghost2(HandleClass handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width=27;
		bounds.height=27;
		
		ghost1=new Animation(500,Assets.inky);
	}
	
	

	@Override
	public void tick() {
		ghost1.tick();
		checkRoute();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width,height, null);		
	}
	private BufferedImage getCurrentAnimationFrame() {
		// TODO Auto-generated method stub
		return ghost1.getCurrentFrame();
	}
	class Coordinate {
		public int x,y;
		public Coordinate(int x, int y) {
			this.x=x;
			this.y=y;
			}}

	
	private void checkRoute() {

		for(int i=0;i<30;i++) {
			for(int j=0;j<20;j++) {
				visited[i][j]=0;
				
			}
		}
		Queue<Coordinate> queue=new LinkedList<>();
		queue.add(new Coordinate((int)super.x/20,(int)super.y/20));

		Coordinate a= new Coordinate((int)super.x/20,(int)super.y/20);
		visited[a.x][a.y]=1;
		
		while (queue.size() != 0) 
        { 
			
			
            // Dequeue a vertex from queue and print it 
            Coordinate s = queue.poll();
//            if(visited[s.x][s.y]>=5) {
//            	chase=false;
//            	return false;
//            }
//            else if(s.x==EntityManager.player.getX() && s.y == EntityManager.player.getY()) {
//            	chase=true;
//            	return true;
//            }

            if(World.World.tiles[s.x][s.y - 1] == 0 && visited[s.x][s.y - 1] == 0) {
            	queue.add(new Coordinate(s.x,s.y-1));
            	visited[s.x][s.y - 1] = visited[s.x][s.y]+1;
            }
            
            
            if(World.World.tiles[s.x+1][s.y]==0 && visited[s.x+1][s.y] == 0) {
            	queue.add(new Coordinate(s.x+1,s.y) );
            	visited[s.x+1][s.y]=visited[s.x][s.y]+1;
            }
            if(World.World.tiles[s.x][s.y+1]==0 && visited[s.x][s.y + 1] == 0) {
            	queue.add(new Coordinate(s.x,s.y+1) );
            	visited[s.x][s.y+1]=visited[s.x][s.y]+1;
            }
            if(World.World.tiles[s.x-1][s.y ] == 0 && visited[s.x-1][s.y] == 0) {
            	queue.add(new Coordinate(s.x-1,s.y));
            	visited[s.x-1][s.y] = visited[s.x][s.y]+1;
            }
    		}
		for(int i=0;i<30;i++) {
			for(int j=0;j<20;j++) {
				System.out.print(visited[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		
		
		
	}
	


}
