package gamestates;

import java.awt.Graphics;

import gameobjectLists.EnemiesList;
import gameobjects.EnemyFormation;
import gameobjects.PlayerShip;
import main.MainWindow;

/**
 * Game state that runs when playing.
 * @author Eder Paz
 */
public class PlayingState extends GameState{
	
	private PlayerShip player;
	private EnemiesList enemies;
	
	/**
	 * Constructor of the state.<br>
	 * Creates the player.
	 * @param game
	 */
	public PlayingState(MainWindow game) {
		super(game);
		player = new PlayerShip(game);
		enemies = new EnemiesList();
		
	}
	
	/**
	 * Update the variable of all objects of the game.
	 */
	@Override
	public void updateVariables() {
		
		player.updateVariables();
		enemies.updateVariables();
		
		if(enemies.getEnemy1List().size()==0){
			EnemyFormation.createFormation(game,enemies.getEnemy1List());
		}
		
		if(game.getKeyboard().esc){
			if(GameState.getChangeState()){
				GameState.setGameStateTo(game.pauseState());
				GameState.setChangeState(false);
			}
		}else{
			GameState.setChangeState(true);
		}
	}
	
	/**
	 * Draw the objects of the game.
	 */
	@Override
	public void draw(Graphics graphics) {
		player.draw(graphics);
		enemies.draw(graphics);
	}
}