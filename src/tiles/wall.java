package tiles;



import Graphics.Assets;

public class wall extends Tile{

	public wall(int id) {
		super(Assets.wall, id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isSolid() {
		return true;
	}
	
	

}
