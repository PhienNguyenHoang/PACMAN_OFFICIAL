package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static Tile[] tiles= new Tile[256];
	public static Tile blackTile= new blackTile(0);
	public static Tile wall= new wall(1);
	public static final int TILEWIDTH=75,TILEHEIGHT=75;
	
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile (BufferedImage texture,int id) {
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
		
	}
	public void tick() {
		
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
	}
	public boolean isSolid() {
		return false;
	}
	
	public int getID() {
		return id;
		
	}

}
