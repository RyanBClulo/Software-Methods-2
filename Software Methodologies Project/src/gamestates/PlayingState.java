package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import physicsObjects.Enemy;
import physicsObjects.PlayerShip;
import physicsObjects.Projectile;
import window.EnemyPatterns;
import window.LevelControl;
import window.MainWindow;

/**
 * Game state that runs when playing.
 * @author Eder Paz
 */
public class PlayingState extends GameState{
	
	private PlayerShip player;
	
	/**
	 * Constructor of the state.<br>
	 * Creates the player.
	 * @param game
	 */
	public PlayingState(MainWindow game) {
		super(game);
		player = new PlayerShip(game);
	}
	
	/**
	 * Update the variable of all objects of the game.
	 */
	@Override
	public void updateVariables() {
		
		player.updateVariables();
		
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
		renderingLoop(graphics);
		player.draw(graphics);
	}
	
	@SuppressWarnings("static-access")
	public void renderingLoop(Graphics graphics) {
		
		//This while loop contains all of the things drawn on the screen
			
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
}