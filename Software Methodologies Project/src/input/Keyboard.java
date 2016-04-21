package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import score.Statistics;

public class Keyboard implements KeyListener{
	
	private boolean moveUp =false;
	private boolean moveDown =false;
	private boolean moveLeft =false;
	private boolean moveRight =false;
	private boolean shoot = false;
	private boolean esc = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up (Moves the ship in the positive direction)
	        	moveUp=true;
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down
	        	moveDown=true;
	        	break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	moveLeft=true;
	            break;
	        case KeyEvent.VK_RIGHT:
	            // handle right
	        	moveRight=true;
	            break;
	        case KeyEvent.VK_SPACE:
	        	//handle space (shooting)
	        	shoot = true;
	        	Statistics.addShot();
	        	break;
	        case KeyEvent.VK_ESCAPE:
	        	esc=true;
	        	break;
	     }
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up (Moves the ship in the positive direction)
	        	moveUp=false;
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down
	        	moveDown=false;
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	moveLeft=false;
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	moveRight=false;
	            break;
	        case KeyEvent.VK_SPACE :
	        	// handle space (shooting)
	        	shoot=false;
	        	break;
	        case KeyEvent.VK_ESCAPE:
	        	esc=false;
	    }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public boolean up(){
		return moveUp;
	}
	
	public boolean down(){
		return moveDown;
	}
	
	public boolean left(){
		return moveLeft;
	}
	
	public boolean right(){
		return moveRight;
	}
	
	public boolean space(){
		return shoot;
	}
	
	public boolean esc(){
		return esc;
	}
}