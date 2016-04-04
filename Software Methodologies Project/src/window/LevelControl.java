package window;

import java.util.Iterator;
import java.util.Random;

import physicsObjects.Enemy;

public class LevelControl {
	private static int currentFormationPattern;
	private static int levelNumber;

	public static int getCurrentFormationPattern() {
		return currentFormationPattern;
	}

	/**
	 * This method is called in the game loop to check if the level is finished.
	 * Currently very empty (for testing)
	 * @return
	 */
	public static void updateLevel() {
		// TODO Auto-generated method stub
		Random rnd=new Random();
		Iterator<Enemy> enemyExistanceCheck = Enemy.enemyIterator();
		if(!enemyExistanceCheck.hasNext()){
        	EnemyFormation.createFormation();
        	currentFormationPattern=rnd.nextInt(EnemyPatterns.patternCount());
		}
	}
	
	
}
