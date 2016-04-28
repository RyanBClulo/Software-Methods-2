package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import collision.Collision;
import gameobjectLists.EnemiesList;
import gameobjectLists.ProjectilesList;
import gameobjects.EnemyFormation;
import gameobjects.GameObjects;
import gameobjects.MiniBoss;
import gameobjects.PlayerShip;
import gameobjects.Projectile;
import main.MainWindow;
import score.Score;
import score.Statistics;

/**
 * Game state that runs when playing.
 * @author Eder Paz
 */
public class PlayingState extends GameState{
	
	private PlayerShip player;
	private EnemiesList enemies;
	private ProjectilesList enemyBullets;
	private Collision collisionDetector;
	private MiniBoss boss;
	
	private int enemyBulletType;
	private int difficulty;
	private int continues;
	
	private int enemiesWave;
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
		collisionDetector = new Collision(game);
		boss = new MiniBoss(game);
		continues=3;
	}
	
	public void gameStart(int difficulty){
		enemies.reset();
		enemyBullets.reset();
		enemiesWave=0;
		player.getBullets().reset();
		boss.backToInitialPosition();
		player.setShipLocation((float)(game.getWidth()-player.getWidth())/2,(float)(game.getHeight()-player.getHeight())/1.2f);
		player.setLife(5);
		player.resetSpecials();
		continues=3;
		this.difficulty=difficulty;
	}
	
	public void faseStart(){
		enemies.reset();
		enemyBullets.reset();
		enemiesWave=0;
		player.getBullets().reset();
		player.resetSpecials();
		boss.backToInitialPosition();
		player.setShipLocation((float)(game.getWidth()-player.getWidth())/2,(float)(game.getHeight()-player.getHeight())/1.2f);
		player.setLife(5);
	}
	
	/**
	 * Update the variable of all objects of the game.
	 */
	@Override
	public void updateVariables() {
		
		enemyBullets.updateVariables();
		player.updateVariables();
		if(enemiesWave!=6)enemies.updateVariables();
		else boss.updateVariables();
		
		Statistics.updateAccuracy();
		
		collisionDetector.playerBulletEnemy(player.getBullets(),enemies);
		collisionDetector.playerEnemy(player,enemies);
		collisionDetector.playerEnemybullet(enemyBullets, player);
		collisionDetector.specialsEnemy(player.getSpecials(), enemies);
		
		if(enemies.getEnemy1List().size()==0){				
			if(enemiesWave!=6){
				EnemyFormation.createFormation(game,enemies.getEnemy1List());
				enemiesWave++;
				enemyBulletType = r.nextInt(3)+3;
				Score.addScore(25);
			}
		}else{
			counter++;
			if(counter==40){
				counter=0;
				enemyIndex=r.nextInt(enemies.getEnemy1List().size());
				enemyBullets.addProjectile(
						new Projectile(game,
								enemies.getEnemy1List().get(enemyIndex).getX()+(GameObjects.enemyWidth-GameObjects.bulletWidth)/2,
								enemies.getEnemy1List().get(enemyIndex).getY()+GameObjects.enemyHeight/2, 8.0f,enemyBulletType));
			}
		}
		
		if(game.getKeyboard().esc()){
			if(GameState.getChangeState()){
				GameState.setGameStateTo(game.pauseState());
				GameState.setChangeState(false);
			}
		}else if(player.getLife()<=0){
			game.getContinueState().resetTimer();
			GameState.setGameStateTo(game.continueState());
			GameState.setChangeState(false);
		}else{
			GameState.setChangeState(true);
		}
	}
	
	/**
	 * Draw the objects of the game.
	 */
	@Override
	public void draw(Graphics graphics) {
		enemyBullets.draw(graphics);
		if(enemiesWave!=6)enemies.draw(graphics);
		else boss.draw(graphics);
		player.draw(graphics);
		Score.drawScore(graphics);
		graphics.setFont(font);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Amount of Lives: "+player.getLife(),game.getWidth()/2-70,game.getHeight()-50);

	}
	
	public PlayerShip getPlayerShip(){
		return player;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public int getContinues(){
		return continues;
	}
	
	public void useContinue(){
		continues-=1;
	}
}