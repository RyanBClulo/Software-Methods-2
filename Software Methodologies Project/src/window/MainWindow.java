package window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.*;

import graphics.ImageLoader;
import graphics.SpriteSheet;
import phisicsObjects.Enemy;
import phisicsObjects.PlayerShip;
import phisicsObjects.Projectile;

public class MainWindow implements MouseListener, ImageObserver, KeyListener {
	
	private JLabel label1;
	private JFrame frame;
	private boolean done=false;
	public static final Point aspectRatio=new Point(800,950); 
	
	private BufferedImage bufferedImage = new BufferedImage(aspectRatio.x, aspectRatio.y, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D bufferedImageG2D = (Graphics2D) bufferedImage.getGraphics();
	private BufferedImage image = new BufferedImage(aspectRatio.x, aspectRatio.y, BufferedImage.TYPE_INT_ARGB);
	
	/**
	 * This method creates the window and contains the game loop that renders all sprites and controls game functions.
	 * Call this method to initiate the game.
	 * @return
	 * @param String[] args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					window.frame.setResizable(false); 
					window.runGameLoop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainWindow() {
		initialize();
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(40, 40, aspectRatio.x, aspectRatio.y);
		frame.setCursor(Cursor.DEFAULT_CURSOR);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(this);
		frame.addKeyListener(this);
		SpriteSheet test =new SpriteSheet(ImageLoader.loadImage("/test.png"));
		image = test.crop(0, 0, 100, 100);
		
		
	}

	public void runGameLoop() {
		Thread loop = new Thread() {
			public void run() {
				renderingLoop();
			}
		};
		loop.start();
	}
		
	@SuppressWarnings("static-access")
	public void renderingLoop() {
		label1= new JLabel("Our Game Here");
		frame.add(label1);
		//This while loop contains all of the things drawn on the screen
		while (!done) {
			//This section renders the background
			bufferedImageG2D.setColor(Color.black);                 
			bufferedImageG2D.fillRect(0,0,aspectRatio.x,aspectRatio.y);

			
			//This section renders and updates the player ship
			bufferedImageG2D.setColor(Color.CYAN);
			//bufferedImageG2D.fillOval(PlayerShip.getShipX()-25, PlayerShip.getShipY()-25, 50, 50);
			bufferedImageG2D.drawImage(image, PlayerShip.getShipX()-50, PlayerShip.getShipY()-50, this);
			checkMovement();//checks for player movement using a system of booleans and keylistener method
			
			//This section keeps track of and renders all of the enemies in the arraylist within the Enemy Class
			//It also checks if ships were destroyed by projectiles
			//moves the ship to its next destination.
			Enemy ship;
			Iterator<Enemy> enemyIterator = Enemy.enemyIterator();		//Always create and refresh the iterator to get the list of enemy objects to display. Same for other objects.
			bufferedImageG2D.setColor(Color.RED);
			while (enemyIterator.hasNext()) {
				ship = (Enemy) enemyIterator.next();
				if (ship.exists()){ //render
					bufferedImageG2D.fillOval(ship.currentLocation().x-25,ship.currentLocation().y-25,50,50);
				}
				Projectile collisionCheck;//collision check with player projectiles
				Iterator<Projectile> projectileCheckIterator = Projectile.ProjecileIterator();
				while(projectileCheckIterator.hasNext()){
					collisionCheck=projectileCheckIterator.next();
					if(ship.containsPoint(collisionCheck.currentLocation(),30)){
						ship.enemyDestroyed();
						collisionCheck.hit();
					}
				}
				//checks for enemy/player collision
				if(ship.containsPoint(new Point(PlayerShip.getShipX()-25,PlayerShip.getShipY()-25),30)){
					ship.clearEnemies();
					PlayerShip.playerDeath();
				}
				//Controls enemy formation movement
				if(ship.hasReachedDestination){
					EnemyPatterns.moveFormation(ship,LevelControl.getCurrentFormationPattern());
				}
			}
	
			//This section keeps track of and renders all of the player projectiles in the arraylist within the Projectile Class
			Projectile shot;
			Iterator<Projectile> projectileIterator = Projectile.ProjecileIterator();
			bufferedImageG2D.setColor(Color.GREEN);
			while (projectileIterator.hasNext()) {
				shot = (Projectile) projectileIterator.next();
				if (shot.exists()){
					bufferedImageG2D.fillOval(shot.currentLocation().x,shot.currentLocation().y,20,20);
				}
			}

			LevelControl.updateLevel(); //This method will be called to check level end condition
			
			//This line renders all the graphics together on the screen
			frame.getGraphics().drawImage(bufferedImage, 0, 0, this);
		}
	}
	
	
	/**
	 * This method is called in the game loop to check if the player ship needs to be moved based on the booleans set in the override methods of keylistener.
	 * @return
	 */
	private static void checkMovement(){
		if(PlayerShip.getShipY()>50 && moveUp)
    		PlayerShip.moveShipY(-PlayerShip.getShipSpeed());
    	if(PlayerShip.getShipY()<aspectRatio.getY()-35 && moveDown)
    		PlayerShip.moveShipY(PlayerShip.getShipSpeed());
    	if(PlayerShip.getShipX()>25 && moveLeft)
    		PlayerShip.moveShipX(-PlayerShip.getShipSpeed());
    	if(PlayerShip.getShipX()<aspectRatio.getX()-25 && moveRight)
    		PlayerShip.moveShipX(PlayerShip.getShipSpeed());
	}
	//private variables that control keyboard input
	private static boolean moveUp =false;
	private static boolean moveDown =false;
	private static boolean moveLeft =false;
	private static boolean moveRight =false;
	private static boolean spamPrevention=false;
	
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
	        		new Projectile(PlayerShip.getShipX()-10,PlayerShip.getShipY()-10);
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//sets player ship location to mouse click for testing purposes 
		PlayerShip.setShipLocation(new Point(e.getX(),e.getY()));
		PlayerShip.updateXY();
	}
	
	//Unused mouse and key listener methods
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y,
			int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
}





