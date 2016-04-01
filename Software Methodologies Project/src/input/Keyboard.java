package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import phisicsObjects.Enemy;
import phisicsObjects.Projectile;
import window.EnemyFormation;
import window.MainWindow;

public class Keyboard implements KeyListener{
	
	public boolean moveUp =false;
	public boolean moveDown =false;
	public boolean moveLeft =false;
	public boolean moveRight =false;
	public boolean spamPrevention=false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
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
			        case KeyEvent.VK_RIGHT :
			            // handle right
			        	moveRight=true;
			            break;
			        case KeyEvent.VK_SPACE:
			        	//handle space (Fires projectiles from the player's ship)
			        	//spam prevention prevents the player from holding down the spacebar to shoot.
			        	if(!spamPrevention)
			        		new Projectile((int)MainWindow.getPlayerShip().getShipX()-10,(int)MainWindow.getPlayerShip().getShipY()-10);
			        	spamPrevention=true;
			        	break;
			        case KeyEvent.VK_E:
			        	//handle E (creates random enemies for testing purposes)
			        	new Enemy();
			        	break;
			        case KeyEvent.VK_F:
			        	//handle F (creates random or preset enemy formations for testing purposes)
			        	EnemyFormation.createFormation();break;
			        	
			        case KeyEvent.VK_C:
			        	// handle C (clears all enemies for testing purposes)
			        	Enemy.clearEnemies();break;
			     }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
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
			        	//spam protection stops when you let go of space
			        	spamPrevention=false;
			        	break;
			    }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}