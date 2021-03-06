package collision;

import gameobjectLists.EnemiesList;
import gameobjectLists.ProjectilesList;
import gameobjectLists.SpecialLists;
import gameobjects.GameObjects;
import gameobjects.PlayerShip;
import main.MainWindow;
import score.Score;
import score.Statistics;
import input.Sound;

/**
 * 
 * @author Eder
 *
 */
public class Collision {
		
	private MainWindow game;
	private Sound b;
	
	public Collision(MainWindow game){
		this.game=game;
		b = new Sound("hit.wav");
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
				b.play();
				break;
			}
		}
	}
	
	public void specialsEnemy(SpecialLists specials,EnemiesList enemies){
		
		for(int x=0 ; x<enemies.getEnemy1List().size() ; x++){
			for(int y=0 ; y<specials.getShurikenList().size() ; y++){
				if(enemies.getEnemy1List().get(x).getBounds().intersects(specials.getShurikenList().get(y).getBounds())){
					if(!specials.getShurikenList().get(y).hasDoneDamage()){
						specials.getShurikenList().get(y).damage();
						enemies.getEnemy1List().get(x).setLife(enemies.getEnemy1List().get(x).getLife()-GameObjects.shurikenPower);
						if(enemies.getEnemy1List().get(x).getLife()<=0)
							enemies.removeEnemy1(enemies.getEnemy1List().get(x));
					}
					break;
				}
			}
		}
		
		for(int x=0 ; x<enemies.getEnemy1List().size() ; x++){
			for(int y=0 ; y<specials.getSuperNovaList().size() ; y++){
				if(enemies.getEnemy1List().get(x).getBounds().intersects(specials.getSuperNovaList().get(y).getBounds())){
					if(specials.getSuperNovaList().get(y).isExploded()){
						enemies.getEnemy1List().get(x).setLife(enemies.getEnemy1List().get(x).getLife()-1);
						if(enemies.getEnemy1List().get(x).getLife()<=0){
							enemies.removeEnemy1(enemies.getEnemy1List().get(x));
							break;
						}
					}else{
						specials.getSuperNovaList().get(y).explode();
					}
				}
			}
		}
		
		for(int x=0 ; x<specials.getLaserList().size() ; x++){
			for(int y=0 ; y<enemies.getEnemy1List().size() ; y++){
				if(enemies.getEnemy1List().get(y).getBounds().intersects(specials.getLaserList().get(x).getBounds())){
					specials.getLaserList().get(x).hit(	(enemies.getEnemy1List().get(y).getBounds().y+enemies.getEnemy1List().get(y).getBounds().width-2));
					if(!specials.getLaserList().get(x).hasDoneDamage()){
						specials.getLaserList().get(x).damage();
						enemies.getEnemy1List().get(y).setLife(enemies.getEnemy1List().get(y).getLife()-GameObjects.laserPower);
						if(enemies.getEnemy1List().get(y).getLife()<=0){
							enemies.removeEnemy1(enemies.getEnemy1List().get(y));
						}
					}
					break;
				}else
					specials.getLaserList().get(x).release();
			}
		}
	}
}