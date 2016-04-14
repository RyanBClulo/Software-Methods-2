package collision;

import gameobjectLists.EnemiesList;
import gameobjectLists.ProjectilesList;
import gameobjects.PlayerShip;

/**
 * 
 * @author Eder
 *
 */
public class Collision {
	
	/**
	 * 
	 * @param bullets
	 * @param enemy
	 */
	public void playerBulletEnemy(ProjectilesList bullet,EnemiesList enemy){
		for(int x=0 ; x<bullet.getPlayerBullet().size() ; x++){
			for(int y=0; y<enemy.getEnemy1List().size() ; y++){
				if(bullet.getPlayerBullet().get(x).getBounds().intersects(enemy.getEnemy1List().get(y).getBounds())){
					enemy.removeEnemy1(enemy.getEnemy1List().get(y));
					bullet.removeProjectile(bullet.getPlayerBullet().get(x));
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
}