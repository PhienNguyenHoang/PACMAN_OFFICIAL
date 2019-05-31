package World;



import java.awt.Graphics;
import game.HandleClass;
import World.Utils;

import entity.EntityManager;
import entity.Ghost1;
import entity.Ghost2;
import entity.Player;
import entitystatic.Coin;
import entitystatic.Diamond;
import tiles.Tile;



public class World {
	private int width,height;
	private HandleClass handler; 
	public static int [][] tiles;
	private int spawnX, spawnY;
	private EntityManager entityManager;
	
	

	
	
	public World(HandleClass handler, String path) {
		
		//Add PLAYER
		entityManager = new EntityManager(handler, new Player (handler,30,30));
				
		
		//ADD COIN
		
		
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*3, 30));
		entityManager.addEntity(new Coin (handler,30*4, 30));
		entityManager.addEntity(new Coin (handler,30*5, 30));
		entityManager.addEntity(new Coin (handler,30*6, 30));
		entityManager.addEntity(new Coin (handler,30*7, 30));
		entityManager.addEntity(new Coin (handler,30*8, 30));
		entityManager.addEntity(new Coin (handler,30*9, 30));
		entityManager.addEntity(new Coin (handler,30*10, 30));
		entityManager.addEntity(new Coin (handler,30*11, 30));
		entityManager.addEntity(new Coin (handler,30*12, 30));
		entityManager.addEntity(new Coin (handler,30*13, 30));
		entityManager.addEntity(new Coin (handler,30*14, 30));
		entityManager.addEntity(new Coin (handler,30*15, 30));
		entityManager.addEntity(new Coin (handler,30*16, 30));
		entityManager.addEntity(new Coin (handler,30*17, 30));
		entityManager.addEntity(new Coin (handler,30*18, 30));
		entityManager.addEntity(new Coin (handler,30*19, 30));
		entityManager.addEntity(new Coin (handler,30*20, 30));
		entityManager.addEntity(new Coin (handler,30*21, 30));
		entityManager.addEntity(new Coin (handler,30*22, 30));
		entityManager.addEntity(new Coin (handler,30*23, 30));
		entityManager.addEntity(new Coin (handler,30*24, 30));
		entityManager.addEntity(new Coin (handler,30*25, 30));
		entityManager.addEntity(new Coin (handler,30*26, 30));
		entityManager.addEntity(new Coin (handler,30*27, 30));
		entityManager.addEntity(new Coin (handler,30*28, 30));
		
		entityManager.addEntity(new Coin (handler,30, 30*2));
		entityManager.addEntity(new Coin (handler,30*3, 30*2));
		entityManager.addEntity(new Coin (handler,30*7, 30*2));
		entityManager.addEntity(new Coin (handler,30*11, 30*2));
		entityManager.addEntity(new Coin (handler,30*18, 30*2));
		entityManager.addEntity(new Coin (handler,30*22, 30*2));
		entityManager.addEntity(new Coin (handler,30*26, 30*2));
		entityManager.addEntity(new Coin (handler,30*28, 30*2));
		entityManager.addEntity(new Coin (handler,30, 30*3));
		
		entityManager.addEntity(new Coin (handler,30*3, 30*3));
		entityManager.addEntity(new Coin (handler,30*7, 30*3));
		entityManager.addEntity(new Coin (handler,30*11, 30*3));
		entityManager.addEntity(new Coin (handler,30*18, 30*3));
		entityManager.addEntity(new Coin (handler,30*22, 30*3));
		entityManager.addEntity(new Coin (handler,30*26, 30*3));
		entityManager.addEntity(new Coin (handler,30*28, 30*3));
		
		entityManager.addEntity(new Coin (handler,30, 30*4));
		entityManager.addEntity(new Coin (handler,30*2, 30*4));
		entityManager.addEntity(new Coin (handler,30*3, 30*4));
		entityManager.addEntity(new Coin (handler,30*4, 30*4));
		entityManager.addEntity(new Coin (handler,30*5, 30*4));
		entityManager.addEntity(new Coin (handler,30*6, 30*4));
		entityManager.addEntity(new Coin (handler,30*7, 30*4));
		entityManager.addEntity(new Coin (handler,30*8, 30*4));
		entityManager.addEntity(new Coin (handler,30*9, 30*4));
		entityManager.addEntity(new Coin (handler,30*10, 30*4));
		entityManager.addEntity(new Coin (handler,30*11, 30*4));
		entityManager.addEntity(new Coin (handler,30*12, 30*4));
		entityManager.addEntity(new Coin (handler,30*13, 30*4));
		entityManager.addEntity(new Coin (handler,30*14, 30*4));
		entityManager.addEntity(new Coin (handler,30*15, 30*4));
		entityManager.addEntity(new Coin (handler,30*16, 30*4));
		entityManager.addEntity(new Coin (handler,30*17, 30*4));
		entityManager.addEntity(new Coin (handler,30*18, 30*4));
		entityManager.addEntity(new Coin (handler,30*19, 30*4));
		entityManager.addEntity(new Coin (handler,30*20, 30*4));
		entityManager.addEntity(new Coin (handler,30*21, 30*4));
		entityManager.addEntity(new Coin (handler,30*22, 30*4));
		entityManager.addEntity(new Coin (handler,30*23, 30*4));
		entityManager.addEntity(new Coin (handler,30*24, 30*4));
		entityManager.addEntity(new Coin (handler,30*25, 30*4));
		entityManager.addEntity(new Coin (handler,30*26, 30*4));
		entityManager.addEntity(new Coin (handler,30*27, 30*4));
		entityManager.addEntity(new Coin (handler,30*28, 30*4));

		entityManager.addEntity(new Coin (handler,30, 30*5));
		entityManager.addEntity(new Coin (handler,30*5, 30*5));
		entityManager.addEntity(new Coin (handler,30*24, 30*5));
		entityManager.addEntity(new Coin (handler,30*28, 30*5));
		
		entityManager.addEntity(new Coin(handler,30,30*6));
		entityManager.addEntity(new Coin (handler,30*2, 30*6));
		entityManager.addEntity(new Coin (handler,30*3, 30*6));
		entityManager.addEntity(new Coin (handler,30*4, 30*6));
		entityManager.addEntity(new Coin (handler,30*5, 30*6));
		entityManager.addEntity(new Coin (handler,30*6, 30*6));
		entityManager.addEntity(new Coin (handler,30*7, 30*6));
		entityManager.addEntity(new Coin (handler,30*8, 30*6));
		entityManager.addEntity(new Coin (handler,30*9, 30*6));
		entityManager.addEntity(new Coin (handler,30*10, 30*6));
		entityManager.addEntity(new Coin (handler,30*11, 30*6));
		entityManager.addEntity(new Coin (handler,30*12, 30*6));
		entityManager.addEntity(new Coin (handler,30*13, 30*6));
		entityManager.addEntity(new Coin (handler,30*14, 30*6));
		entityManager.addEntity(new Coin (handler,30*15, 30*6));
		entityManager.addEntity(new Coin (handler,30*16, 30*6));
		entityManager.addEntity(new Coin (handler,30*17, 30*6));
		entityManager.addEntity(new Coin (handler,30*18, 30*6));
		entityManager.addEntity(new Coin (handler,30*19, 30*6));
		entityManager.addEntity(new Coin (handler,30*20, 30*6));
		entityManager.addEntity(new Coin (handler,30*21, 30*6));
		entityManager.addEntity(new Coin (handler,30*22, 30*6));
		entityManager.addEntity(new Coin (handler,30*23, 30*6));
		entityManager.addEntity(new Coin (handler,30*24, 30*6));
		entityManager.addEntity(new Coin (handler,30*25, 30*6));
		entityManager.addEntity(new Coin (handler,30*26, 30*6));
		entityManager.addEntity(new Coin (handler,30*27, 30*6));
		entityManager.addEntity(new Coin (handler,30*28, 30*6));
		
		entityManager.addEntity(new Coin(handler,30,30*7));
		entityManager.addEntity(new Coin (handler,30*3, 30*7));
		entityManager.addEntity(new Coin (handler,30*7, 30*7));
		entityManager.addEntity(new Coin (handler,30*9, 30*7));
		entityManager.addEntity(new Coin (handler,30*20, 30*7));
		entityManager.addEntity(new Coin (handler,30*22, 30*7));
		entityManager.addEntity(new Coin (handler,30*26, 30*7));
		entityManager.addEntity(new Coin (handler,30*28, 30*7));
		
		entityManager.addEntity(new Coin(handler,30,30*8));
		entityManager.addEntity(new Coin (handler,30*3, 30*8));
		entityManager.addEntity(new Coin (handler,30*4, 30*8));
		entityManager.addEntity(new Coin (handler,30*5, 30*8));
		entityManager.addEntity(new Coin (handler,30*7, 30*8));
		entityManager.addEntity(new Coin (handler,30*9, 30*8));
		entityManager.addEntity(new Coin (handler,30*11, 30*8));
		entityManager.addEntity(new Coin (handler,30*12, 30*8));
		entityManager.addEntity(new Coin (handler,30*13, 30*8));
		entityManager.addEntity(new Coin (handler,30*14, 30*8));
		entityManager.addEntity(new Coin (handler,30*15, 30*8));
		entityManager.addEntity(new Coin (handler,30*16, 30*8));
		entityManager.addEntity(new Coin (handler,30*17, 30*8));
		entityManager.addEntity(new Coin (handler,30*18, 30*8));
		entityManager.addEntity(new Coin (handler,30*20, 30*8));
		entityManager.addEntity(new Coin (handler,30*22, 30*8));
		entityManager.addEntity(new Coin (handler,30*24, 30*8));
		entityManager.addEntity(new Coin (handler,30*25, 30*8));
		entityManager.addEntity(new Coin (handler,30*26, 30*8));
		entityManager.addEntity(new Coin (handler,30*28, 30*8));
		
		entityManager.addEntity(new Coin (handler, 30, 30*9));
		entityManager.addEntity(new Coin (handler,30*5, 30*9));
		entityManager.addEntity(new Coin (handler,30*7, 30*9));
		//
		entityManager.addEntity(new Diamond (handler, 30*9, 30*9));
		entityManager.addEntity(new Diamond (handler, 30*20, 30*9));
		
		//
		entityManager.addEntity(new Coin (handler,30*15, 30*9));
		entityManager.addEntity(new Coin (handler,30*22, 30*9));
		entityManager.addEntity(new Coin (handler,30*24, 30*9));
		entityManager.addEntity(new Coin (handler,30*28, 30*9));
		
		entityManager.addEntity(new Coin(handler,30,30*10));
		entityManager.addEntity(new Coin (handler,30*5, 30*10));
		entityManager.addEntity(new Coin (handler,30*7, 30*10));
		entityManager.addEntity(new Coin (handler,30*11, 30*10));
		entityManager.addEntity(new Coin (handler,30*12, 30*10));
		entityManager.addEntity(new Coin (handler,30*13, 30*10));
		entityManager.addEntity(new Coin (handler,30*14, 30*10));
		entityManager.addEntity(new Coin (handler,30*15, 30*10));
		entityManager.addEntity(new Coin (handler,30*16, 30*10));
		entityManager.addEntity(new Coin (handler,30*17, 30*10));
		entityManager.addEntity(new Coin (handler,30*18, 30*10));
		entityManager.addEntity(new Coin (handler,30*22, 30*10));
		entityManager.addEntity(new Coin (handler,30*24, 30*10));
		entityManager.addEntity(new Coin (handler,30*26, 30*10));
		entityManager.addEntity(new Coin (handler,30*28, 30*10));
		
		entityManager.addEntity(new Coin(handler,30,30*11));
		entityManager.addEntity(new Coin (handler,30*2, 30*11));
		entityManager.addEntity(new Coin (handler,30*3, 30*11));
		entityManager.addEntity(new Coin (handler,30*4, 30*11));
		entityManager.addEntity(new Coin (handler,30*5, 30*11));
		entityManager.addEntity(new Coin (handler,30*6, 30*11));
		entityManager.addEntity(new Coin (handler,30*7, 30*11));
		entityManager.addEntity(new Coin (handler,30*8, 30*11));
		entityManager.addEntity(new Coin (handler,30*9, 30*11));
		entityManager.addEntity(new Coin (handler,30*11, 30*11));
		entityManager.addEntity(new Coin (handler,30*18, 30*11));
		entityManager.addEntity(new Coin (handler,30*19, 30*11));
		entityManager.addEntity(new Coin (handler,30*20, 30*11));
		entityManager.addEntity(new Coin (handler,30*21, 30*11));
		entityManager.addEntity(new Coin (handler,30*22, 30*11));
		entityManager.addEntity(new Coin (handler,30*23, 30*11));
		entityManager.addEntity(new Coin (handler,30*24, 30*11));
		entityManager.addEntity(new Coin (handler,30*26, 30*11));
		entityManager.addEntity(new Coin (handler,30*28, 30*11));
		

		entityManager.addEntity(new Coin(handler,30,30*12));
		entityManager.addEntity(new Coin (handler,30*5, 30*12));
		entityManager.addEntity(new Coin (handler,30*9, 30*12));
		entityManager.addEntity(new Coin (handler,30*11, 30*12));
		entityManager.addEntity(new Coin (handler,30*13, 30*12));
		entityManager.addEntity(new Coin (handler,30*16, 30*12));
		entityManager.addEntity(new Coin (handler,30*18, 30*12));
		entityManager.addEntity(new Coin (handler,30*20, 30*12));
		entityManager.addEntity(new Coin (handler,30*24, 30*12));
		entityManager.addEntity(new Coin (handler,30*26, 30*12));
		entityManager.addEntity(new Coin (handler,30*27, 30*12));
		entityManager.addEntity(new Coin (handler,30*28, 30*12));
		

		entityManager.addEntity(new Coin(handler,30,30*13));
		entityManager.addEntity(new Coin (handler,30*3, 30*13));
		entityManager.addEntity(new Coin (handler,30*4, 30*13));
		entityManager.addEntity(new Coin (handler,30*5, 30*13));
		entityManager.addEntity(new Coin (handler,30*6, 30*13));
		entityManager.addEntity(new Coin (handler,30*7, 30*13));
		entityManager.addEntity(new Coin (handler,30*9, 30*13));
		entityManager.addEntity(new Coin (handler,30*11, 30*13));
		entityManager.addEntity(new Coin (handler,30*13, 30*13));
		entityManager.addEntity(new Coin (handler,30*16, 30*13));
		entityManager.addEntity(new Coin (handler,30*18, 30*13));
		entityManager.addEntity(new Coin (handler,30*20, 30*13));
		entityManager.addEntity(new Coin (handler,30*22, 30*13));
		entityManager.addEntity(new Coin (handler,30*23, 30*13));
		entityManager.addEntity(new Coin (handler,30*24, 30*13));
		entityManager.addEntity(new Coin (handler,30*25, 30*13));
		entityManager.addEntity(new Coin (handler,30*26, 30*13));
		entityManager.addEntity(new Coin (handler,30*28, 30*13));
		
		entityManager.addEntity(new Coin(handler,30,30*14));
		entityManager.addEntity(new Coin (handler,30*3, 30*14));
		entityManager.addEntity(new Coin (handler,30*7, 30*14));
		entityManager.addEntity(new Coin (handler,30*9, 30*14));
		entityManager.addEntity(new Coin (handler,30*11, 30*14));
		entityManager.addEntity(new Coin (handler,30*13, 30*14));
		entityManager.addEntity(new Coin (handler,30*16, 30*14));
		entityManager.addEntity(new Coin (handler,30*20, 30*14));
		entityManager.addEntity(new Coin (handler,30*22, 30*14));
		entityManager.addEntity(new Coin (handler,30*26, 30*14));
		entityManager.addEntity(new Coin (handler,30*28, 30*14));

		entityManager.addEntity(new Coin(handler,30,30*15));
		entityManager.addEntity(new Coin (handler,30*3, 30*15));
		entityManager.addEntity(new Coin (handler,30*4, 30*15));
		entityManager.addEntity(new Coin (handler,30*5, 30*15));
		entityManager.addEntity(new Coin (handler,30*6, 30*15));
		entityManager.addEntity(new Coin (handler,30*7, 30*15));
		entityManager.addEntity(new Coin (handler,30*9, 30*15));
		entityManager.addEntity(new Coin (handler,30*11, 30*15));
		entityManager.addEntity(new Coin (handler,30*12, 30*15));
		entityManager.addEntity(new Coin (handler,30*13, 30*15));
		entityManager.addEntity(new Coin (handler,30*14, 30*15));
		entityManager.addEntity(new Coin (handler,30*15, 30*15));
		entityManager.addEntity(new Coin (handler,30*16, 30*15));
		entityManager.addEntity(new Coin (handler,30*17, 30*15));
		entityManager.addEntity(new Coin (handler,30*18, 30*15));
		entityManager.addEntity(new Coin (handler,30*20, 30*15));
		entityManager.addEntity(new Coin (handler,30*22, 30*15));
		entityManager.addEntity(new Coin (handler,30*23, 30*15));
		entityManager.addEntity(new Coin (handler,30*24, 30*15));
		entityManager.addEntity(new Coin (handler,30*25, 30*15));
		entityManager.addEntity(new Coin (handler,30*26, 30*15));
		entityManager.addEntity(new Coin (handler,30*28, 30*15));
		
		entityManager.addEntity(new Coin(handler,30,30*16));
		entityManager.addEntity(new Coin (handler,30*3, 30*16));
		entityManager.addEntity(new Coin (handler,30*7, 30*16));
		entityManager.addEntity(new Coin (handler,30*9, 30*16));
		entityManager.addEntity(new Coin (handler,30*11, 30*16));
		entityManager.addEntity(new Coin (handler,30*12, 30*16));
		entityManager.addEntity(new Coin (handler,30*17, 30*16));
		entityManager.addEntity(new Coin (handler,30*18, 30*16));
		entityManager.addEntity(new Coin (handler,30*20, 30*16));
		entityManager.addEntity(new Coin (handler,30*22, 30*16));
		entityManager.addEntity(new Coin (handler,30*26, 30*16));
		entityManager.addEntity(new Coin (handler,30*28, 30*16));
		
		entityManager.addEntity(new Coin(handler,30,30*16));
		entityManager.addEntity(new Coin (handler,30*3, 30*16));
		entityManager.addEntity(new Coin (handler,30*7, 30*16));
		entityManager.addEntity(new Coin (handler,30*9, 30*16));
		entityManager.addEntity(new Coin (handler,30*11, 30*16));
		entityManager.addEntity(new Coin (handler,30*18, 30*16));
		entityManager.addEntity(new Coin (handler,30*20, 30*16));
		entityManager.addEntity(new Coin (handler,30*22, 30*16));
		entityManager.addEntity(new Coin (handler,30*26, 30*16));
		entityManager.addEntity(new Coin (handler,30*28, 30*16));
		
		
		entityManager.addEntity(new Coin(handler,30,30*17));
		entityManager.addEntity(new Coin (handler,30*3, 30*17));
		entityManager.addEntity(new Coin (handler,30*7, 30*17));
		entityManager.addEntity(new Coin (handler,30*9, 30*17));
		entityManager.addEntity(new Coin (handler,30*11, 30*17));
		entityManager.addEntity(new Coin (handler,30*18, 30*17));
		entityManager.addEntity(new Coin (handler,30*20, 30*17));
		entityManager.addEntity(new Coin (handler,30*22, 30*17));
		entityManager.addEntity(new Coin (handler,30*26, 30*17));
		entityManager.addEntity(new Coin (handler,30*28, 30*17));
		
		entityManager.addEntity(new Coin(handler,30,30*18));
		entityManager.addEntity(new Coin (handler,30*3, 30*18));
		entityManager.addEntity(new Diamond (handler,30*7, 30*18));
		entityManager.addEntity(new Coin (handler,30*11, 30*18));
		entityManager.addEntity(new Coin (handler,30*12, 30*18));
		entityManager.addEntity(new Coin (handler,30*13, 30*18));
		entityManager.addEntity(new Coin (handler,30*14, 30*18));
		entityManager.addEntity(new Coin (handler,30*15, 30*18));
		entityManager.addEntity(new Coin (handler,30*16, 30*18));
		entityManager.addEntity(new Coin (handler,30*17, 30*18));
		entityManager.addEntity(new Coin (handler,30*18, 30*18));
		entityManager.addEntity(new Diamond (handler,30*22, 30*18));
		entityManager.addEntity(new Coin (handler,30*26, 30*18));
		entityManager.addEntity(new Coin (handler,30*28, 30*18));
		
		
		
		//ADD GHOST
		entityManager.addEntity(new Ghost1(handler, 30*27, 30*17));
		entityManager.addEntity(new Ghost2(handler, 30*5, 30*6));
		

		
		
		loadWorld(path);
	
		entityManager.getPlayer().setX((int)spawnX);
		entityManager.getPlayer().setY((int)spawnY);
	
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
