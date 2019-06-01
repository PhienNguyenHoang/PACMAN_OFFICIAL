package State;

import java.awt.Graphics;

import World.World;
import game.HandleClass;


public class GameState extends State{

	private World world;
	
	public GameState(HandleClass handler) {
		super(handler);
		world=new World(handler, "resources/Images/world1.txt");
		handler.setWorld(world);
		
	}
	
	@Override
	public void tick() {
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		
		// TODO Auto-generated method stub
		world.render(g);
		
	}

}
