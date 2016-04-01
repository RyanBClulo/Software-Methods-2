package window;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import javax.swing.*;
import graphics.Images;
import input.Keyboard;
import input.Mouse;
import phisicsObjects.Enemy;
import phisicsObjects.PlayerShip;
import phisicsObjects.Projectile;

public class MainWindow implements ImageObserver {
	
	private int counter;
	private long lasttime;
	private long newtime;
	
	private JLabel label1;
	private JFrame frame;
	
	private static Keyboard keyboard;
	private static Mouse mouse;
	
	private static PlayerShip player;
	
	private boolean done=false;
	public static final Point aspectRatio = new Point(800,950); 
	
	private BufferedImage bufferedImage = new BufferedImage(aspectRatio.x, aspectRatio.y, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D bufferedImageG2D = (Graphics2D) bufferedImage.getGraphics();
	
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
		
		Images.initiateImages(); //This method initializes all the images of the game
		
		keyboard =  new Keyboard(); //Creating a new Keyboard object
		mouse = new Mouse();	//Creating a new mouse object
		 
		frame = new JFrame();
		frame.setBounds(40, 40, aspectRatio.x, aspectRatio.y);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.addKeyListener(keyboard); //adding the keyboard object to the game frame
		frame.addMouseListener(mouse);	//adding the mouse object to the game frame
		frame.setVisible(true);
		
		player = new PlayerShip();
		
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
		
		lasttime=System.nanoTime();
		
		label1= new JLabel("Our Game Here");
		frame.add(label1);
		//This while loop contains all of the things drawn on the screen
		while (!done) {
			
			counter++;
			newtime=System.nanoTime();

			if(newtime-lasttime>1000000000){
				System.out.println("Frames per second: "+counter);
				counter=0;
				lasttime=newtime;
			}
			
			
			
			bufferedImageG2D.clearRect(0,0,aspectRatio.x,aspectRatio.y);
			
			//This section renders the background
			bufferedImageG2D.setColor(Color.black);                 
			bufferedImageG2D.fillRect(0,0,aspectRatio.x,aspectRatio.y);
			
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
				if(ship.containsPoint(new Point((int)player.getShipX()-25,(int)player.getShipY()-25),30)){
					ship.clearEnemies();
					player.playerDeath();
				}
				//Controls enemy formation movement
				if(ship.hasReachedDestination){
					EnemyPatterns.moveFormation(ship,LevelControl.getCurrentFormationPattern());
				}
			}
			
			// commented to work with the new bullet project
			//This section keeps track of and renders all of the player projectiles in the arraylist within the Projectile Class
			Projectile shot;
			Iterator<Projectile> projectileIterator = Projectile.ProjecileIterator();
			bufferedImageG2D.setColor(Color.GREEN);
			while (projectileIterator.hasNext()) {
				shot = (Projectile) projectileIterator.next();
				if (shot.exists()){
					shot.updateVariables();
					shot.draw(bufferedImageG2D);
					bufferedImageG2D.fillOval(shot.currentLocation().x,shot.currentLocation().y,20,20);
				}
			}
			
			//updates the player position and prints it
			player.updateVariables(aspectRatio);
			player.draw(bufferedImageG2D);

			LevelControl.updateLevel(); //This method will be called to check level end condition
			
			//This line renders all the graphics together on the screen
			frame.getGraphics().drawImage(bufferedImage, 0, 0, this);
		}
	}
	
	public boolean imageUpdate(Image img, int infoflags, int x, int y,int width, int height) {
		return false;
	}
	
	//GETTERS
	
	public static Keyboard getKeyboard(){
		return keyboard;
	}
	
	public static PlayerShip getPlayerShip(){
		return player;
	}
}