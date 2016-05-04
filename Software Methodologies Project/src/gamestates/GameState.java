package gamestates;

import java.awt.Font;
import java.awt.Graphics;

import main.MainWindow;

/**
 * 
 * @author Eder Paz
 */
public abstract class GameState{
	
	protected MainWindow game;
	protected int counter;
	
	private static GameState currentState = null,lastState = null;
	private static boolean change = true;
	
	/**
	 * 
	 * @param game
	 */
	public GameState(MainWindow game){
		this.game=game;
	}
	
	/**
	 * 
	 */
	public abstract void updateVariables();
	
	/**
	 * 
	 */
	public abstract void draw(Graphics graphics);
	
	/**
	 * 
	 * @return
	 */
	public static GameState getCurrentGameState(){
		return currentState;
	}
	
	/**
	 * 
	 * @return
	 */
	public static GameState getLastGameState(){
		return lastState;
	}
	
	/**
	 * 
	 * @param state
	 */
	public static void setGameStateTo(GameState state){
		if(change){
			lastState=currentState;
			currentState=state;
		}
	}
	
	/**
	 * 
	 */
	public static void backToLastState(){
		currentState=lastState;
	}
	
	/**
	 * 
	 * @param b
	 */
	public static void setChangeState(boolean b){
		change=b;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean getChangeState(){
		return change;
	}
}