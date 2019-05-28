package State;

import java.awt.Graphics;

import World.World;
import entity.Player;
import game.Game;
import tiles.Tile;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game,100,100);
		world=new World("resources/Images/world1.txt");
	}
	
	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		
		// TODO Auto-generated method stub
		world.render(g);
		player.render(g);
	}

}
