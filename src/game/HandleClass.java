package game;

import World.World;
import game.Game;
import input.KeyManager;

public class HandleClass {
	private Game game;
	private World world;
	
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
}
