package State;

import java.awt.Graphics;

import game.Game;
import game.HandleClass;

public abstract class State {
	
	private static State currentState=null;
	
	public static void setState(State state) {
		currentState= state;
	}
	
	public static State getState () {
		return currentState;
	}
	
	protected HandleClass handler;
	public State (HandleClass handler) {
		this.handler = handler;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
}
