package tiles;

import java.awt.image.BufferedImage;

import Graphics.Assets;

public class blackTile extends Tile {

	public blackTile( int id) {
		super(Assets.background,id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}
