package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import physicsObjects.Enemy;
import window.EnemyFormation;


public class Keyboard implements KeyListener{
	
	public boolean moveUp =false;
	public boolean moveDown =false;
	public boolean moveLeft =false;
	public boolean moveRight =false;
	public boolean shoot = false;
	public boolean esc = false;
	
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
	        	break;
	        case KeyEvent.VK_E:
	        	//handle E (creates random enemies for testing purposes)
	        	new Enemy();
	        	break;
	        case KeyEvent.VK_F:
	        	//handle F (creates random or preset enemy formations for testing purposes)
	        	EnemyFormation.createFormation();
	        	break;
	        case KeyEvent.VK_C:
	        	// handle C (clears all enemies for testing purposes)
	        	Enemy.clearEnemies();
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
}