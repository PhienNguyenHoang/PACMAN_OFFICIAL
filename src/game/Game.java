package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import entity.Player;

import Display.Display;
import Graphics.Assets;
import Graphics.CropImage;
import Graphics.ImageLoader;
import State.GameState;
import State.State;

public class Game implements Runnable {
	private Display display;
	public int width, height;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage image;
	private CropImage x;
	
	private boolean running = false;
	private Thread thread;
	private Player player;
	
	//State
	private State gameState;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		player = new Player(50, 50);
		
	}
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		
		gameState = new GameState(this);
		State.setState(gameState);
		
	}
	
	private void tick() {
		if(State.getState()!=null) {
			State.getState().tick();
		}
	}
	public void render() {
		bs= display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(State.getState()!=null) {
			State.getState().render(g);
		}
		
		g.drawImage(Assets.pacman,10,10,null);
		
		bs.show();
		g.dispose();
		
	}
	@Override
	public void run() {
		init();
		while(running) {
			render();
		}
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
