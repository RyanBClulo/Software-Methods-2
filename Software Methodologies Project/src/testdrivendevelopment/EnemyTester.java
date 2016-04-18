package testdrivendevelopment;

import static org.junit.Assert.*;
import java.awt.Rectangle;
import org.junit.Test;
import gameobjects.Enemy;

public class EnemyTester {
	
	/**
	 * Test if the enemy is initiated on the expected position on the screen.<br>
	 * Test if the speed of the player is also initiated right.
	 */
	@Test
	public void initialization(){
		for(int x=0 ; x<200 ; x++){
			for(int y=0 ; y<200 ; y++){
				Enemy enemy = new Enemy(null,x,y,0,0);
				assertEquals(x,enemy.getX(),0.0f);
				assertEquals(y,enemy.getY(),0.0f);
				assertEquals(9.0f,enemy.getSpeed(),0.0f);
			}
		}
	}
	
	/**
	 * Test if the hit box used for collision detection is created right.
	 */
	@Test
	public void hitBox(){
		for(int x=0 ; x<200 ; x++){
			for(int y=0 ; y<200 ; y++){
				Enemy enemy = new Enemy(null,x,y,0,0);
				/*
				 * The hit box of an enemy should always be a rectangle located 5 pixels to the right of its x position
				 * and 5 pixels below its y position.
				 * It also should hold the size of 40 x 40 pixels;
				 */
				Rectangle hitBox = new Rectangle(x+5,y+5,40,40);
				assertEquals(hitBox,enemy.getBounds());
			}
		}
	}
	
	/**
	 * Test if the player hit box moves together with the enemy.
	 */
	@Test
	public void hitBoxPosition(){
		
		//enemy that moves from one side to another
		Enemy enemy1 = new Enemy(null,500,500,0,0);
		
		for(int x=0 ; x<500 ; x++){
			// create a new rectangle on the expected position
			Rectangle hitBox = new Rectangle((int)enemy1.getX()+5,(int)enemy1.getY()+5,40,40);
			assertEquals(hitBox,enemy1.getBounds());
			enemy1.updateVariables(); //move the enemy
		}
		
		//enemy that moves in an eight pattern
		Enemy enemy2 = new Enemy(null,500,500,1,0);
		
		for(int x=0 ; x<500 ; x++){
			// create a new rectangle on the expected position
			Rectangle hitBox = new Rectangle((int)enemy2.getX()+5,(int)enemy2.getY()+5,40,40);
			assertEquals(hitBox,enemy2.getBounds());
			enemy2.updateVariables(); //move the enemy
		}
		
		//enemy that moves in an square pattern
		Enemy enemy3 = new Enemy(null,500,500,2,0);
		
		for(int x=0 ; x<500 ; x++){
			// create a new rectangle on the expected position
			Rectangle hitBox = new Rectangle((int)enemy3.getX()+5,(int)enemy3.getY()+5,40,40);
			assertEquals(hitBox,enemy3.getBounds());
			enemy3.updateVariables(); //move the enemy
		}
		
		//stationary enemy
		Enemy enemy4 = new Enemy(null,500,500,3,0);
		
		for(int x=0 ; x<500 ; x++){
			// create a new rectangle on the expected position
			Rectangle hitBox = new Rectangle((int)enemy4.getX()+5,(int)enemy4.getY()+5,40,40);
			assertEquals(hitBox,enemy4.getBounds());
			enemy4.updateVariables(); //move the enemy
		}
	}
}