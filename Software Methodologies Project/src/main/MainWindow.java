package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Iterator;
import java.util.Random;

import display.Display;
import gamestates.*;
import graphics.Images;
import input.*;
import physicsObjects.*;

public class MainWindow implements Runnable {
	
	private int 	counter;
	private long	lasttime,
					newtime;
	
	private String	name;
	private int 	width,
					height,
					starX;
	
	private BufferStrategy	bs;
	private Graphics	graphics;
	private Thread		thread;
	private Display		display;
	private boolean		running=false;
	
	private static		Keyboard keyboard;
	private static		Mouse mouse;
	
	private GameState	playingState,
						startMenuState,
						handleQuitState,
						pauseState,
						shipSelectionState;
	
	private Stars bullet = new Stars();
	Random r = new Random();
	
	
	/**
	 * Sets Game window variables.
	 * @param name Name at the upper left of the screen.
	 * @param width Game Window width.
	 * @param height Game window Height.
	 */
	public MainWindow(String name,int width,int height){
		this.name=name;
		this.width=width;
		this.height=height;
	}
	
	/**
	 * Start the main window thread.
	 */
	public synchronized void start(){
		if(running)
			return;
		running=true;
		thread = new Thread(this);
		thread.start();
	}
	

	/**
	 * Ends the thread, closes the window and finishes the program.
	 */
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
	
	/**
	 * GAME LOOP.
	 */
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
			
			int fps = 60;
			double timePerTick = 1000000000/fps;
			double delta = 0;
			long now;
			long lastTime = System.nanoTime();
			long timer = 0;
			int ticks = 0;
			
			while(running){
				now = System.nanoTime();
				delta += (now - lastTime)/timePerTick;
				timer += now - lastTime;
				lastTime = now;
				
				if(delta >= 1){
					upgradeVariables();
					draw();
					ticks++;
					delta--;
				}
				
				if(timer >= 1000000000){
					System.out.println("Tickts and Frames: "+ticks);
					ticks = 0;
					timer = 0;
				}
			}
		}		
	}
	
	/**
	 * Initiate the game display, images, keyboard listener, mouse listener and states of the game.
	 */
	public void initiate(){
		
		//Creates the window of the game
		display = new Display(name,width,height);
		display.createDisplay();
		
		//Adds the mouse and the keyboard to the game
		keyboard =  new Keyboard(); //Creating a new Keyboard object
		mouse = new Mouse(); //Creating a new mouse object
		display.getFrame().addKeyListener(keyboard);
		display.getFrame().addMouseListener(mouse);
		display.getFrame().addMouseMotionListener(mouse);
		display.getCanvas().addMouseListener(mouse);
		display.getCanvas().addMouseMotionListener(mouse);
	
		Images.initiateImages(); //This method initializes all the images of the game
		
		//Creates the states of the game and start the first one
		playingState = new PlayingState(this);
		startMenuState = new StartMenuState(this);
		handleQuitState = new HandleQuitState(this);
		pauseState = new PauseState(this);
		shipSelectionState = new ShipSelectionState(this);
		GameState.setGameStateTo(startMenuState);
		
	}
	
	/**
	 * Update all variable of the game.
	 */
	public void upgradeVariables(){
		GameState.getCurrentGameState().updateVariables();
	}
	
	/**
	 * Draw all the game objects in the screen.
	 */
	public void draw(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = bs.getDrawGraphics();
		graphics.clearRect(0,0,width,height);
		
		//DRAW HERE!!!!!!!
		
		//This section renders the background
		graphics.setColor(Color.black);
		graphics.fillRect(0,0,width,height);
		
		starLoop(graphics);
		GameState.getCurrentGameState().draw(graphics); //Draw the current running game state
		
		//RENDERS EVERYTHING TOGETHER AND DRAWS IT!!!!
		bs.show();
		graphics.dispose();
	}
	
	
	/**
	 * 
	 * @param graphics
	 */
	public void starLoop(Graphics graphics) {
		
		// commented to work with the new bullet project
		//This section keeps track of and renders all of the player star in the starlist within the Star Class
		
		starX = r.nextInt(getWidth());
		
		bullet.addStar(new Star((int)starX,(int)-10));
		Star shot;
		Iterator<Star> starIterator = Star.StarIterator();
		while (starIterator.hasNext()) {
			shot = (Star) starIterator.next();
			if (shot.exists()){
				shot.updateVariables();
				shot.draw(graphics);
			}
		}
	}
	
	
	
	
	
	
	/**
	 * Getter of the game window width.
	 * @return Game window width
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * Getter for the game window height.
	 * @return Game window height.
	 */
	public int getHeight(){
		return height;
	}
	
	/**
	 * Getter for the game keyboard listener.
	 * @return Keyboard listener object.
	 */
	public Keyboard getKeyboard(){
		return keyboard;
	}
	
	/**
	 * Getter for the game mouse listener.
	 * @return Mouse listener and motion listener object
	 */
	public Mouse getMouse(){
		return mouse;
	}
	
	/**
	 * Getter for the start menu game state.
	 * @return Start Menu game state.
	 */
	public GameState startMenu(){
		return startMenuState;
	}
	
	/**
	 * Getter for the playing game state.
	 * @return Playing game state.
	 */
	public GameState playingState(){
		return playingState;
	}
	
	/**
	 * Getter for the handle quit game state.
	 * @return Handle quit game state.
	 */
	public GameState handleQuitState(){
		return handleQuitState;
	}
	
	/**
	 * Getter for the pause game state.
	 * @return Pause game state.
	 */
	public GameState pauseState(){
		return pauseState;
	}
	
	/**
	 * Getter for the ship selection game state.
	 * @return Ship selection game state.
	 */
	public GameState shipSelectionState(){
		return shipSelectionState;
	}
}