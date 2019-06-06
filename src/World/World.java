package World;



import java.awt.Graphics;
import game.HandleClass;
import World.Utils;

import entity.EntityManager;
import entity.Ghost1;
//import entity.Ghost2;
import entity.Player;
import entitystatic.Coin;
import entitystatic.Diamond;
import tiles.Tile;



public class World {
	private int width,height;
	private HandleClass handler; 
	
	private int spawnX, spawnY; 
	public static int [][] tiles;

	private EntityManager entityManager;
	
	

	
	
	public World(HandleClass handler, String path) {
		
		this.handler = handler; 
		
		//Initialize entityManager; 
		entityManager = new EntityManager(handler, new Player(handler,450,30));
		
		loadWorld(path);
		
	}
	
	
	
	public void tick() {
		entityManager.tick(); 
		
	}
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x,y).render(g, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT);
				
			}
			
		}
		entityManager.render(g);
		
		
	}
	
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public  Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.blackTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if(t==null)
			return Tile.blackTile;
		return t;
	}
	
	
	private void loadWorld(String path) {
		
		//load words from file world1.txt
		String files =Utils. loadFileAsString(path);
		String[] tokens = files.split("\\s+");
		width = Utils. parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles= (new int[width][height]);
		
		for ( int y=0; y<height; y++){
			for ( int x=0; x< width; x++){
				tiles [x][y]= Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
	}
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public HandleClass getHandler() {
		return handler;
	}
	public void setHandler(HandleClass handler) {
		this.handler = handler;
	}
	
	
}
