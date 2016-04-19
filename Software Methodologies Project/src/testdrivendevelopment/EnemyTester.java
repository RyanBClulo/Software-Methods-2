package testdrivendevelopment;

import static org.junit.Assert.assertEquals;
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
	 * Every enemy should start with a speed of 9.0f and decrease this speed by 98% at every updateVariables() method calling.
	 * When the speed decreases to lower then 1.0f, it is set to 1.0f so the enemy can enter in its specific movement.
	 */
	@Test
	public void initialMovement(){
		float speed;
		for(int y=0 ; y<4 ; y++){ //generate all four moving patterns of enemies
			Enemy enemy = new Enemy(null,0,0,y,0);
			speed=9.0f;
			for(int x=0 ; x<500 ; x++){
				if(speed>1.0f){
					assertEquals(speed,enemy.getSpeed(),0.0f);
					speed*=0.98f;
				}else{
					assertEquals(1.0f,Math.abs(enemy.getSpeed()),0.0f);
				}
				enemy.updateVariables();
			}
		}
	}
	
	/**
	 * The stationary enemy should do the initial movement and after stays fixed in the position it stopped
	 */
	@Test
	public void stationaryEnemy(){
		float lastX=0, lastY=0;
		Enemy enemy = new Enemy(null,0,0,3,0); //create a stationary enemy
		
		do{ //moves the player until it completes the initial movement
			enemy.updateVariables();
			if(enemy.getSpeed()==1.0f){
				lastX=enemy.getX();
				lastY=enemy.getY();
			}
		}while(enemy.getSpeed()!=1.0f);
		
		for(int x=0 ; x<200 ; x++){
			enemy.updateVariables();
			assertEquals(lastX,enemy.getX(),0.0f);
			assertEquals(lastY,enemy.getY(),0.0f);
		}
	}
	
	@Test
	public void sideToSideEnemy(){
		float initialX=0,initialY=0,finalX=0,finalY=0;
		float lastSpeed;
		
		Enemy enemy = new Enemy(null,0,0,0,0); //create an enemy that moves from one side to another
		
		do{ //moves the player until it completes the initial movement
			enemy.updateVariables();
		}while(enemy.getSpeed()!=1.0f);
		
		do{ //moves the player until it changes of direction, record the coordinates where it did
			lastSpeed=enemy.getSpeed();
			enemy.updateVariables();
			if(lastSpeed!=enemy.getSpeed()){
				initialX=enemy.getX();
				initialY=enemy.getY();
			}
		}while(lastSpeed==enemy.getSpeed());
		
		do{ //moves the player until it changes of direction, record the coordinates where it did
			lastSpeed=enemy.getSpeed();
			enemy.updateVariables();
			if(lastSpeed!=enemy.getSpeed()){
				finalX=enemy.getX();
				finalY=enemy.getY();
			}
		}while(lastSpeed==enemy.getSpeed());
		
		float distance = (float) Math.sqrt(Math.pow(initialX-finalX,2)+Math.pow(initialY-finalY,2));
		
		assertEquals(200f,distance,5f);		
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
		
		for(int y=0 ; y<4 ; y++){ //generate all moving patterns of enemies
			Enemy enemy = new Enemy(null,500,500,y,0);
			
			for(int x=0 ; x<500 ; x++){
				// create a new rectangle on the expected position
				Rectangle hitBox = new Rectangle((int)enemy.getX()+5,(int)enemy.getY()+5,40,40);
				assertEquals(hitBox,enemy.getBounds());
				enemy.updateVariables(); //move the enemy
			}
		}
	}
}