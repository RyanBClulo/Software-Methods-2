package test_driven_development;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import phisicsObjects.Enemy;
import window.EnemyFormation;

public class FormationTest {

	@Test
	public void formationLINE(){
		EnemyFormation.createFormation(EnemyFormation.LINE);
		Enemy ship;
		Iterator<Enemy> enemyIterator = Enemy.enemyIterator();
		int[] locationArray={100,200,300,400,500,600,700};
		for(int i=0;enemyIterator.hasNext();i++){
			ship = (Enemy) enemyIterator.next();
			assertEquals((int)ship.destination.getX(),locationArray[i]);
		}
	}

}
