package test_driven_development;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Iterator;

import org.junit.Test;

import phisicsObjects.Enemy;
import phisicsObjects.Projectile;

public class GameTest {

	@Test
	public void testEnemyCreation(){
		new Enemy(new Point(100,-25),new Point(100,200));
		Enemy ship;
		Iterator<Enemy> enemyIterator = Enemy.enemyIterator();
		if(enemyIterator.hasNext()){
			ship = (Enemy) enemyIterator.next();
			assertNotNull(ship);
		}
		Enemy.clearEnemies();
	}

	@Test
	public void testEnemyLocation(){
		new Enemy(new Point(100,-25),new Point(100,200));
		Enemy ship;
		Iterator<Enemy> enemyIterator = Enemy.enemyIterator();
		if(enemyIterator.hasNext()){
			ship = (Enemy) enemyIterator.next();
			assertEquals((int)100,(int)ship.origin.getX());
			assertEquals((int)-25,(int)ship.origin.getY());
			assertEquals((int)100,(int)ship.destination.getX());
			assertEquals((int)200,(int)ship.destination.getY());
		}
		Enemy.clearEnemies();
	}
	
	@Test
	public void testEnemyContainsPoint(){
		new Enemy(new Point(200,200), new Point(200,200));
		new Enemy(new Point(400,400), new Point(400,400));
		Enemy ship;
		Iterator<Enemy> enemyIterator = Enemy.enemyIterator();
		if(enemyIterator.hasNext()){
			ship = (Enemy) enemyIterator.next();
			for(int i=0;i<100;i++){
				Projectile shot =new Projectile(200,200+i);
				System.out.println(ship.containsPoint(shot.currentLocation(),30));
				if(i<5)
					assertEquals(true,ship.containsPoint(shot.currentLocation(),30));
			}
		}
		else assert(false);
		Enemy.clearEnemies();
	}
	
	@Test
	public void testUpdateLevel(){
		
	}

}








