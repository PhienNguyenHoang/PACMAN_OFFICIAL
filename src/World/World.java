package World;



import java.awt.Graphics;
import game.HandleClass;
import World.Utils;
import entity.Creature;
import entity.EntityManager;
import entity.Ghost1;
import entity.Ghost2;
import entity.Player;
import entitystatic.Coin;
import tiles.Tile;



public class World {
	private int width,height;
	private HandleClass handler; 
	public static int [][] tiles;
	private int spawnX, spawnY;
	private EntityManager entityManager;
	

	
	
	public World(HandleClass handler, String path) {
		
		
		entityManager = new EntityManager(handler, new Player (handler,30,30));
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
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		entityManager.addEntity(new Coin (handler,30*2, 30));
		
		entityManager.addEntity(new Ghost1(handler, 30*27, 30*17));
		entityManager.addEntity(new Ghost2(handler, 30*5, 30*6));
		
		/*for(int y=0;y< this.height;y++) {
			for(int x=0;x<this.width;x++) {
				if((this.getTile(x,y)!=Tile.wall)&& (x!=spawnX)&&(y!= spawnY)) {
					entityManager.addEntity(new Coin(handler,(int) x,(int)y));
				}
			}
		}*/
		
		
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
				//entityManager.render(g, x*Creature.DEFAULT_WIDTH, y*Creature.DEFAULT_HEIGHT);
				//
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
		/*width=10;
		height=10;
		tiles=new int [width][height];
		
		for (int x=0;x<width;x++) {
			for(int y=0;y<height;y++) {
				tiles[x][y]=0;
				
			}*/
		
		
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
