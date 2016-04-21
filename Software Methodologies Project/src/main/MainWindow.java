package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import display.Display;
import gameobjectLists.Stars;
import gamestates.*;
import graphics.Images;
import input.*;

public class MainWindow implements Runnable {
	
	private int 	counter;
	private long	lasttime,
					newtime;
	
	private String	name;
	private int 	width,
					height;
	
	private BufferStrategy	bs;
	private Graphics	graphics;
	private Thread		thread;
	private Display		display;
	private boolean		running=false;
	
	private				Keyboard keyboard =  new Keyboard(); //Creating a new Keyboard object
	private				Mouse mouse = new Mouse(); //Creating a new mouse object;
	
	private GameState	playingState,
						startMenuState,
						handleQuitState,
						pauseState,
						shipSelectionState,
						difficultyState,
						continueState,
						gameOverState,
						highScoreState;
	
	private Stars stars;
	
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
		
		display.getFrame().addKeyListener(keyboard);
		display.getFrame().addMouseListener(mouse);
		display.getFrame().addMouseMotionListener(mouse);
		display.getCanvas().addMouseListener(mouse);
		display.getCanvas().addMouseMotionListener(mouse);
	
		Images.initiateImages(); //This method initializes all the images of the game
		
		stars = new Stars(this);
		
		//Creates the states of the game and start the first one
		playingState = new PlayingState(this);
		startMenuState = new StartMenuState(this);
		handleQuitState = new HandleQuitState(this);
		pauseState = new PauseState(this);
		shipSelectionState = new ShipSelectionState(this);
		continueState = new ContinueState(this);
		difficultyState = new DifficultyState(this);
		gameOverState = new GameOverState(this);
		highScoreState = new HighScoreState(this);
		GameState.setGameStateTo(startMenuState);
		
	}
	
	/**
	 * Update all variable of the game.
	 */
	public void upgradeVariables(){
		
		stars.updateVariables();
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
		
		stars.draw(graphics);
		GameState.getCurrentGameState().draw(graphics); //Draw the current running game state
		
		//RENDERS EVERYTHING TOGETHER AND DRAWS IT!!!!
		bs.show();
		graphics.dispose();
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
	
	/**
	 * Getter for the continue screen.
	 * @return Continue game state.
	 */
	public GameState continueState(){
		return continueState;
	}
	
	/**
	 * Getter for the select difficulty screen.
	 * @return Select difficulty state.
	 */
	public GameState difficultyState(){
		return difficultyState;
	}
	
	/**
	 * Getter for the game over screen.
	 * @return Game Over state.
	 */
	public GameState gameOverState(){
		return gameOverState;
	}
	
	/**
	 * Getter for the high scores screen.
	 * @return High score game state.
	 */
	public GameState highScoreState(){
		return highScoreState;
	}
	
	/**
	 * Getter for the game playing state, allows to use the methods defined within the playing state class.
	 * @return Playing state itself.
	 */
	public PlayingState getPlayingState(){
		return (PlayingState)playingState;
	}
	
	/**
	 * Getter for the game difficulty select screen, allows to use the methods defined within the difficulty state class.
	 * @return Difficulty selection state itself.
	 */
	public DifficultyState getDifficultystate(){
		return (DifficultyState)difficultyState;
	}
}