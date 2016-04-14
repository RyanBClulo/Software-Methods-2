package gamestates;

import java.awt.Graphics;
import java.util.Random;

import collision.Collision;
import gameobjectLists.EnemiesList;
import gameobjectLists.ProjectilesList;
import gameobjects.EnemyFormation;
import gameobjects.GameObjects;
import gameobjects.PlayerShip;
import gameobjects.Projectile;
import main.MainWindow;

/**
 * Game state that runs when playing.
 * @author Eder Paz
 */
public class PlayingState extends GameState{
	
	private PlayerShip player;
	private EnemiesList enemies;
	private ProjectilesList enemyBullets;
	private Collision collisionDetector;
	
	private int counter;
	private int enemyIndex;
	private Random r = new Random();
	
	/**
	 * Constructor of the state.<br>
	 * Creates the player.
	 * @param game
	 */
	public PlayingState(MainWindow game) {
		super(game);
		player = new PlayerShip(game);
		enemies = new EnemiesList();
		enemyBullets = new ProjectilesList();
		collisionDetector = new Collision();
		
	}
	
	/**
	 * Update the variable of all objects of the game.
	 */
	@Override
	public void updateVariables() {
		
		enemyBullets.updateVariables();
		player.updateVariables();
		enemies.updateVariables();
		
		if(enemies.getEnemy1List().size()==0){
			EnemyFormation.createFormation(game,enemies.getEnemy1List());
		}else{
			counter++;
			if(counter==100){
				counter=0;
				enemyIndex=r.nextInt(enemies.getEnemy1List().size());
				enemyBullets.addProjectile(
						new Projectile(game,
								enemies.getEnemy1List().get(enemyIndex).getX()+(GameObjects.enemyWidth-GameObjects.bulletWidth)/2,
								enemies.getEnemy1List().get(enemyIndex).getY()+GameObjects.enemyHeight/2, 8.0f));
			}
		}
		
		if(game.getKeyboard().esc){
			if(GameState.getChangeState()){
				GameState.setGameStateTo(game.pauseState());
				GameState.setChangeState(false);
			}
		}else{
			GameState.setChangeState(true);
		}
		
		collisionDetector.playerBulletEnemy(player.getBullets(),enemies);
		collisionDetector.playerEnemy(player,enemies);
	}
	
	/**
	 * Draw the objects of the game.
	 */
	@Override
	public void draw(Graphics graphics) {
		enemyBullets.draw(graphics);
		enemies.draw(graphics);
		player.draw(graphics);
	}
}