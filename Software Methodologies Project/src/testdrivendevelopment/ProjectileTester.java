package testdrivendevelopment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import org.junit.Test;
import gameobjects.Projectile;

public class ProjectileTester {
	
	/**
	 * Test if projectile initiates with the desired speed, x and y positions.<br>
	 * Also tests if it starts with the desired pattern size.
	 */
	@Test
	public void initialization() {
		
		for(int x=0 ; x<100 ; x++){
			for(int y=0 ; y<100 ; y++){
				for(int z=-11 ; z<11 ; z++){
					Projectile bullet = new Projectile(null,x,y,z);
					
					assertEquals(bullet.getX(),x,0.0f);
					assertEquals(bullet.getY(),y,0.0f);
					assertEquals(bullet.getSpeed(),z,0.0f);
					assertEquals(bullet.getWidth(),20);
					assertEquals(bullet.getHeight(),20);
				}
			}
		}
	}
	
	/**
	 * Test if the projectile moves accordingly with its respective speed.
	 */
	@Test
	public void movement(){
		for(float y=1 ; y<100 ; y++){
			//y defines the speed in which the projectile should be moving
			
			//for positive speed
			Projectile bullet1 = new Projectile(null,100,100,y);
			for(float x=0 ; x<100 ; x+=y){
				assertEquals(bullet1.getX(),100,0.0f);
				assertEquals(bullet1.getY(),100+x,0.0f);
				bullet1.updateVariables(); //moves the projectile
			}
			
			//for negative speed
			Projectile bullet2 = new Projectile(null,100,100,-y);
			for(float x=0 ; x<100 ; x+=y){
				assertEquals(bullet2.getX(),100,0.0f);
				assertEquals(bullet2.getY(),100-x,0.0f);
				bullet2.updateVariables(); //moves the projectile
			}
		}
	}
	
	/**
	 * Test if the hit box used for collision detection is created right
	 */
	@Test
	public void HitBox(){
		for(int x=0 ; x<200 ; x++){
			for(int y=0 ; y<200 ; y++){
				Projectile bullet = new Projectile(null,x,y,1);
				/*
				 * The hit box of a projectile should always be a rectangle located 4 pixels to the right of its x position
				 * and 4 pixels below its y position.
				 * It also should hold the size of 12 x 12 pixels;
				 */
				Rectangle hitBox = new Rectangle(x+4,y+4,12,12);
				assertTrue(hitBox.equals(bullet.getBounds()));
			}
		}
	}
	
	/**
	 * Test if the projectile hit box moves together with the projectile
	 */
	@Test
	public void hitBoxPosition(){
		for(float y=1 ; y<100 ; y++){ //assign different speed for the projectile
			//for positive speed
			Projectile bullet1 = new Projectile(null,100,100,y);
			for(float x=0 ; x<100 ; x+=y){
				
				Rectangle hitBox = new Rectangle(100+4,100+(int)x+4,12,12); //create a new rectangle on the expected position
		
				assertEquals(hitBox,bullet1.getBounds());
				
				bullet1.updateVariables(); //moves the projectile
			}
			
			//for negative speed
			Projectile bullet2 = new Projectile(null,100,100,-y);
			for(float x=0 ; x<100 ; x+=y){
				
				Rectangle hitBox2 = new Rectangle(100+4,100-(int)x+4,12,12); //create a new rectangle on the expected position
				
				assertEquals(hitBox2,bullet2.getBounds());				
				
				bullet2.updateVariables(); //moves the projectile
			}
		}
	}
	
	//Still looking for the right coding to put in here
	@Test
	public void graphics(){
		
		JFrame frame1 = new JFrame();
		Canvas canvas1 = new Canvas();
		frame1.add(canvas1);
		frame1.pack();
		
		JFrame frame2 = new JFrame();
		Canvas canvas2 = new Canvas();
		frame2.add(canvas2);
		frame2.pack();
		
		Graphics graphics1,graphics2;
		graphics1 = canvas1.getGraphics();
		graphics2 = canvas2.getGraphics();
		
		System.out.println(graphics1);
		System.out.println(graphics2);
		
		
		
		System.out.println(graphics1.getClass());
		System.out.println(graphics1.getClip());
		System.out.println(graphics1.getClipBounds());
	
		Projectile bullet = new Projectile(null,0,0,0);
		
		graphics1.setColor(Color.GREEN);	//Hard code drawing the bullet image
		graphics1.fillOval(0, 0, 20, 500000000);
		
		bullet.draw(graphics2);
		
		assertEquals(graphics1.toString(),graphics2.toString());
		
		System.out.println(graphics1);
		System.out.println(graphics2);		
	}
}