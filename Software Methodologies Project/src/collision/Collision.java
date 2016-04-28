package collision;

import gameobjectLists.EnemiesList;
import gameobjectLists.ProjectilesList;
import gameobjects.PlayerShip;
import main.MainWindow;
import score.Score;
import score.Statistics;

/**
 * 
 * @author Eder
 *
 */
public class Collision {
	
	private MainWindow game;
	
	public Collision(MainWindow game){
		this.game=game;
	}
	/**
	 * 
	 * @param bullets
	 * @param enemy
	 */
	public void playerBulletEnemy(ProjectilesList bullet,EnemiesList enemy){
		for(int x=0 ; x<bullet.getBulletList().size() ; x++){
			for(int y=0; y<enemy.getEnemy1List().size() ; y++){
				if(bullet.getBulletList().get(x).getBounds().intersects(enemy.getEnemy1List().get(y).getBounds())){
					bullet.removeProjectile(bullet.getBulletList().get(x));
					enemy.getEnemy1List().get(y).setLife(enemy.getEnemy1List().get(y).getLife()-game.getPlayingState().getPlayerShip().bulletpower());
					if(enemy.getEnemy1List().get(y).getLife()<=0)
						enemy.removeEnemy1(enemy.getEnemy1List().get(y));
					Score.hitScore();
					Statistics.addhit();
					break;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param player
	 * @param enemy
	 */
	public void playerEnemy(PlayerShip player,EnemiesList enemy){
		for(int x=0 ; x<enemy.getEnemy1List().size() ; x++){
			if(enemy.getEnemy1List().get(x).getBounds().intersects(player.getBounds())){
				player.playerDeath();
				enemy.getEnemy1List().clear();
			}
		}
	}
	
	/**
	 * 
	 * @param bullet
	 * @param player
	 */
	public void playerEnemybullet(ProjectilesList bullet,PlayerShip player){
		for(int x=0 ; x<bullet.getBulletList().size() ; x++){
			if(bullet.getBulletList().get(x).getBounds().intersects(player.getBounds())){
				bullet.removeProjectile(bullet.getBulletList().get(x));
				player.playerDeath();
				player.setLife(player.getLife()-1);
				break;
			}
		}
	}
}