package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import entity.Player;
import input.KeyManager;
import input.MouseManager;
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
	

	private boolean running = false;
	private Thread thread;

	
	
	//worldNumber and Score
    private int worldNumber = 1;
    private int score;
    
	
	//State
	private State gameState;
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	//Handler
	private HandleClass handler;

	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title; 
		keyManager = new KeyManager();
		
	}
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        
     
        
		Assets.init();
		handler = new HandleClass(this);
		gameState = new GameState(handler);
		State.setState(gameState);
		
	}
	
	private void tick() {
		keyManager.tick();
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
		
//		g.drawImage(Assets.pacman,10,10,null);
		
		bs.show();
		g.dispose();
		
	}
	@Override
	public void run() {
		init();
		
		int fps = 60; 
		double timePerTick= 1000000000/ fps; 
		double delta=0; 
		long now; 
		long lastTime= System.nanoTime(); 
		long timer =0; 
		int ticks=0;
		
		while(running) {
			tick();
			render();

			now= System.nanoTime();
			delta+= (now- lastTime)/ timePerTick;
			timer+= now - lastTime;
			lastTime= now;
			if(delta>=1){
				tick();
				render();
				ticks++; 
				delta--; 
			}
			if (timer> 1000000000) {
				System.out.println("Ticks and Frame : " + ticks);
				ticks=0; 
				timer=0; 
			}
		}
		stop();
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
	

 
	 public int getScore() {
	    return score;
	 }
	 public void setScore(int score) {
	    this.score = this.score + score;
	 }
	    
	
	public Canvas getCanvas(){
        return display.getCanvas();
    }
	public KeyManager getKeyManager() {
		return keyManager;
	}

	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
