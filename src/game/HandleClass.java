package game;

import State.State;
import World.World;
import game.Game;
import input.KeyManager;
import input.MouseManager;

public class HandleClass {
	private Game game;
	private World world;
	private State state;
	
	public HandleClass(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	public int getWidth() {
		return game.getWidth();
	}
	public int getHeight() {
		return game.getHeight();
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	public void setState(State state) {
		this.state=state;
	}
	public State getState() {
		return state.getState();
	}
	
	
}
