package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import display.Display;
import graphics.Images;
import input.Keyboard;
import input.Mouse;
import phisicsObjects.Enemy;
import phisicsObjects.PlayerShip;
import phisicsObjects.Projectile;

public class MainWindow implements ImageObserver,Runnable {
	
	private int counter;
	private long lasttime;
	private long newtime;
	
	private BufferStrategy bs;
	private Graphics graphics;
	private Thread thread;
	private Display display;
	
	private static Keyboard keyboard;
	private static Mouse mouse;
	
	private static PlayerShip player;
	
	private boolean running=false;
	public final Point aspectRatio = new Point(800,950); 
	
	//Constructor - starts the MainWindow objects
	public MainWindow(){
		keyboard =  new Keyboard(); //Creating a new Keyboard object
		mouse = new Mouse();	//Creating a new mouse object
		player = new PlayerShip(aspectRatio);
	}
	
	//Starts the MainWindow thread
	public synchronized void start(){
		if(running)
			return;
		running=true;
		thread = new Thread(this);
		thread.start();
	}
	
	//Ends and closes the game
	public synchronized void stop(){
		if(!running)
			return;
		running=false;
		display.close();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//here is where the game loop is now
	@Override
	public void run() {
		
		initiate();
		
		lasttime=System.nanoTime();
		
		while(running){
			
			counter++;
			newtime=System.nanoTime();
			if(newtime-lasttime>1000000000){
				System.out.println("Frames per second: "+counter); //prints how many times per second this programs is running
				counter=0;
				lasttime=newtime;
			}
			
			//This method will update all variables of the game in the future
			upgradeVariables();
			
			//This method will update all variables of the game in the future
			draw();
		}		
	}
	
	//Initiate the game display and images of the game
	public void initiate(){
		
		//Creates the window of the game
		display = new Display();
		display.createDisplay();
		
		//Adds the mouse and the keyboard to the game
		display.getFrame().addKeyListener(keyboard);
		display.getFrame().addMouseListener(mouse);
		display.getCanvas().addMouseListener(mouse);
	
		Images.initiateImages(); //This method initializes all the images of the game	
	}
	
	//This method will update all variables of the game in the future
	public void upgradeVariables(){
		player.updateVariables(aspectRatio);
	}
	
	//This method will update all variables of te game in the future
	public void draw(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = bs.getDrawGraphics();
		graphics.clearRect(0,0,aspectRatio.x,aspectRatio.y);
		
		//DRAW HERE!!!!!!!
		
		renderingLoop(); //Calls the renderingLoop temporarily until we get to split the game in update variables and draw
		player.draw(graphics);
		
		//RENDERS EVERYTHING TOGETHER AND DRAWS IT!!!!
		bs.show();
		graphics.dispose();
	}
		
	@SuppressWarnings("static-access")
	public void renderingLoop() {
		
		//This while loop contains all of the things drawn on the screen
			
			//This section renders the background
			graphics.setColor(Color.black);                 
			graphics.fillRect(0,0,aspectRatio.x,aspectRatio.y);
			
			//This section keeps track of and renders all of the enemies in the arraylist within the Enemy Class
			//It also checks if ships were destroyed by projectiles
			//moves the ship to its next destination.
			Enemy ship;
			Iterator<Enemy> enemyIterator = Enemy.enemyIterator();		//Always create and refresh the iterator to get the list of enemy objects to display. Same for other objects.
			graphics.setColor(Color.RED);
			while (enemyIterator.hasNext()) {
				ship = (Enemy) enemyIterator.next();
				if (ship.exists()){ //render
					ship.draw(graphics);
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
			graphics.setColor(Color.GREEN);
			while (projectileIterator.hasNext()) {
				shot = (Projectile) projectileIterator.next();
				if (shot.exists()){
					shot.updateVariables();
					shot.draw(graphics);
					graphics.fillOval(shot.currentLocation().x,shot.currentLocation().y,20,20);
				}
			}

			LevelControl.updateLevel(); //This method will be called to check level end condition
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