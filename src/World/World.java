package World;



import java.awt.Graphics;


import tiles.Tile;


public class World {
	private int width,height;
	private int [][] tiles;
	private int spawnX, spawnY;
	
	public World(String path) {
		loadWorld(path);
		
		
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x,y).render(g, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT);
			}
		}
		
	}
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.blackTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.coin;
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

		String files =Utils. loadFileAsString(path);
		String[] tokens = files.split("\\s+");
		width = Utils. parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles= new int[width][height];
		
		for ( int y=0; y<height; y++){
			for ( int x=0; x< width; x++){
				tiles [x][y]= Utils.parseInt(tokens[(x+y*width)+4]);
			}


		}


		
	}
	

}
