package State;

import java.awt.Graphics;

import World.World;
import entity.Ghost1;
import entity.Ghost2;
import entity.Player;
import game.Game;
import game.HandleClass;
import tiles.Tile;

public class GameState extends State{

	private Ghost1 ghost;
	private Ghost2 inky;
	private Player player;
	private World world;
	
	public GameState(HandleClass handler) {
		super(handler);
		world=new World("resources/Images/world1.txt");
		handler.setWorld(world);
		player = new Player(handler,30,30);
		ghost=new Ghost1(handler,270,120);
		inky = new Ghost2(handler, 91, 100);
	}
	
	@Override
	public void tick() {
		player.tick();
		ghost.tick();
		inky.tick();
	}

	@Override
	public void render(Graphics g) {
		
		
		// TODO Auto-generated method stub
		world.render(g);
		player.render(g);
		ghost.render(g);
		inky.render(g);
	}

}
