package State;

import java.awt.Graphics;

import World.World;
import entity.Ghost1;
import entity.Player;
import game.Game;
import game.HandleClass;
import tiles.Tile;

public class GameState extends State{

	private Ghost1 ghost;
	private Player player;
	private World world;
	
	public GameState(HandleClass handler) {
		super(handler);
		world=new World("resources/Images/world1.txt");
		handler.setWorld(world);
		player = new Player(handler,30,30);
		ghost=new Ghost1(handler,270,120);
		
	}
	
	@Override
	public void tick() {
		player.tick();
		ghost.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		
		// TODO Auto-generated method stub
		world.render(g);
		player.render(g);
		ghost.render(g);
	}

}
