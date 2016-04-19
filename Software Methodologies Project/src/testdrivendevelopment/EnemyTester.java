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
	
	/**
	 * The enemy that moves from one side to another should move in a straight line of length 200 pixels
	 */
	@Test
	public void sideToSideEnemy(){
		float initialX=0,initialY=0,finalX=0;
		float lastSpeed;
		
		Enemy enemy = new Enemy(null,0,0,0,0); //create an enemy that moves from one side to another
		
		do{ //moves the player until it completes the initial movement
			enemy.updateVariables();
			initialY=enemy.getY(); // y position will never change
		}while(enemy.getSpeed()!=1.0f);
		
		do{ //moves the player until it changes of direction, record the coordinates where it did
			lastSpeed=enemy.getSpeed();
			enemy.updateVariables();
			assertEquals(initialY,enemy.getY(),0.0f); // test if the enemy stays in the same y position for every updateVariables() call
			if(lastSpeed!=enemy.getSpeed()){
				initialX=enemy.getX();
			}
		}while(lastSpeed==enemy.getSpeed());
		
		do{ //moves the player until it changes of direction, record the coordinates where it did
			lastSpeed=enemy.getSpeed();
			enemy.updateVariables();
			assertEquals(initialY,enemy.getY(),0.0f); // test if the enemy stays in the same y position for every updateVariables() call
			if(lastSpeed!=enemy.getSpeed()){
				finalX=enemy.getX();
			}
		}while(lastSpeed==enemy.getSpeed());
		
		float distance = (float) Math.sqrt(Math.pow(initialX-finalX,2)); // calculate the distance that the enemy has moved
		
		assertEquals(200f,distance,0.0f); // test if it is equal to what it is supposed to be
	}
	
	/**
	 * The enemy that moves in a square patter should move in a square that has size 100x100.
	 */
	@Test
	public void squareMovingEnemy(){
		float lastY;
		float lastX;
		float[] X = new float[4];
		float[] Y = new float[4];
		
		Enemy enemy = new Enemy(null,0,0,2,0); //create an enemy that moves in a square pattern
		
		do{ //moves the player until it completes the initial movement
			enemy.updateVariables();
		}while(enemy.getSpeed()!=1.0f);
		
		X[0]=enemy.getX();
		Y[0]=enemy.getY();
		
		do{ //move the enemy until it starts to move down
			lastY=enemy.getY();
			enemy.updateVariables();
		}while(lastY==enemy.getY());
		
		X[1]=enemy.getX();
		Y[1]=enemy.getY()-1.0f; //get the correct position where the enemy changed movement
		
		//Test if the first distance moved is equal to 50, because it starts in the middle of the square
		assertEquals(50f,Math.sqrt(Math.pow(X[0]-X[1],2)+Math.pow(Y[0]-Y[1],2)),0.0f);
		
		do{ //move the enemy until it starts to move to the left
			lastX=enemy.getX();
			enemy.updateVariables();
		}while(lastX==enemy.getX());
		
		X[2]=enemy.getX()+1.0f; //get the correct position where the enemy changed movement
		Y[2]=enemy.getY();
		
		//Test if the first distance moved is equal to 100
		assertEquals(100f,Math.sqrt(Math.pow(X[1]-X[2],2)+Math.pow(Y[1]-Y[2],2)),0.0f);
		
		do{ //move the enemy until it starts to move up
			lastY=enemy.getY();
			enemy.updateVariables();
		}while(lastY==enemy.getY());
		
		X[3]=enemy.getX();
		Y[3]=enemy.getY()+1.0f; //get the correct position where the enemy changed movement
		
		//Test if the first distance moved is equal to 100
		assertEquals(100f,Math.sqrt(Math.pow(X[2]-X[3],2)+Math.pow(Y[2]-Y[3],2)),0.0f);
		
		do{ //move the enemy until it starts to move to the right again
			lastX=enemy.getX();
			enemy.updateVariables();
		}while(lastX==enemy.getX());
		
		X[0]=enemy.getX()-1.0f; //get the correct position where the enemy changed movement
		Y[0]=enemy.getY();
		
		//Test if the first distance moved is equal to 100
		assertEquals(100f,Math.sqrt(Math.pow(X[0]-X[3],2)+Math.pow(Y[0]-Y[3],2)),0.0f);
		
		do{ //move the enemy until it starts to move down again
			lastX=enemy.getX();
			lastY=enemy.getY();
			enemy.updateVariables();
		}while(lastY==enemy.getY());
		
		//Test if the enemy changed position in the same corner than before
		assertEquals(X[1],lastX,0.0f);
		assertEquals(Y[1],lastY,0.0f);
		
		//Now that all the corners of the square have been passed through, test if the diagonal of the square are equal
		//to 100 times square root of two, defining a 100x100 square movement
		assertEquals(100*Math.sqrt(2),Math.sqrt(Math.pow(X[0]-X[2],2)+Math.pow(Y[0]-Y[2],2)),0.0);
		assertEquals(100*Math.sqrt(2),Math.sqrt(Math.pow(X[1]-X[3],2)+Math.pow(Y[1]-Y[3],2)),0.0);
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