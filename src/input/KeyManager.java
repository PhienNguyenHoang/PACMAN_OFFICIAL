package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right,escape; 
	
	public boolean aup, adown, aleft, aright; 
	
	
	public KeyManager() {
		keys = new boolean[256];
	}
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		escape = keys[KeyEvent.VK_ESCAPE];
		
		aup = keys[KeyEvent.VK_UP];
		adown = keys[KeyEvent.VK_DOWN];
		aleft = keys[KeyEvent.VK_LEFT];
		aright = keys[KeyEvent.VK_RIGHT];
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}