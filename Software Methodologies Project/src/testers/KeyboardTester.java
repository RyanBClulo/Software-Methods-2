package testers;

import static org.junit.Assert.assertTrue;
import java.awt.Button;
import java.awt.event.KeyEvent;
import java.util.Random;
import org.junit.Test;
import input.Keyboard;

public class KeyboardTester {
	
	/**
	 * Test if all the instance boolean variables are initiated as false
	 */
	@Test
	public void initialization(){
		
		Keyboard keyboard = new Keyboard();
		
		assertTrue(!keyboard.moveDown);
		assertTrue(!keyboard.moveUp);
		assertTrue(!keyboard.moveRight);
		assertTrue(!keyboard.moveLeft);
		assertTrue(!keyboard.esc);
		assertTrue(!keyboard.shoot);
	}
	
	/**
	 * Test if the moveDown variable changes whenever the key down is pressed on the keyboard
	 */
	@Test
	public void moveDownVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_DOWN,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertTrue(!keyboard.moveDown);
			keyboard.keyPressed(event);
			assertTrue(keyboard.moveDown);
		}
	}
	
	/**
	 * Test if the moveUp variable changes whenever the key up is pressed on the keyboard
	 */
	@Test
	public void moveUpVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_UP,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertTrue(!keyboard.moveUp);
			keyboard.keyPressed(event);
			assertTrue(keyboard.moveUp);
		}
	}
	
	/**
	 * Test if the moveRight variable changes whenever the key right is pressed on the keyboard
	 */
	@Test
	public void moveRightVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_RIGHT,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertTrue(!keyboard.moveRight);
			keyboard.keyPressed(event);
			assertTrue(keyboard.moveRight);
		}
	}
	
	/**
	 * Test if the moveLeft variable changes whenever the key left is pressed on the keyboard
	 */
	@Test
	public void moveLeftVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_LEFT,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertTrue(!keyboard.moveLeft);
			keyboard.keyPressed(event);
			assertTrue(keyboard.moveLeft);
		}
	}
	
	/**
	 * Test if the shoot variable changes whenever the space bar is pressed on the keyboard
	 */
	@Test
	public void shootVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_SPACE,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertTrue(!keyboard.shoot);
			keyboard.keyPressed(event);
			assertTrue(keyboard.shoot);
		}
	}
	
	/**
	 * Test if the shoot variable changes whenever the space bar is pressed on the keyboard
	 */
	@Test
	public void escVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_ESCAPE,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertTrue(!keyboard.esc);
			keyboard.keyPressed(event);
			assertTrue(keyboard.esc);
		}
	}
	
	/**
	 * Test if the variables change when other keys others are pressed on the keyboard
	 */
	@Test
	public void otherKeysActions(){
		
		Keyboard keyboard = new Keyboard();
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,0,' ');
		
		Random r = new Random();
		int keyCode;
		
		for(int x=0 ; x<1000 ; x++){
			do{
				keyCode = r.nextInt(256);
			}while(	keyCode==KeyEvent.VK_ESCAPE || keyCode==KeyEvent.VK_SPACE ||
					keyCode==KeyEvent.VK_UP || keyCode==KeyEvent.VK_DOWN ||
					keyCode==KeyEvent.VK_RIGHT || keyCode==KeyEvent.VK_LEFT);
			
			event.setKeyCode(keyCode);
			
			keyboard.keyReleased(event);
			assertTrue(!keyboard.esc);
			assertTrue(!keyboard.shoot);
			assertTrue(!keyboard.moveDown);
			assertTrue(!keyboard.moveUp);
			assertTrue(!keyboard.moveRight);
			assertTrue(!keyboard.moveLeft);
			
			keyboard.keyPressed(event);
			assertTrue(!keyboard.esc);
			assertTrue(!keyboard.shoot);
			assertTrue(!keyboard.moveDown);
			assertTrue(!keyboard.moveUp);
			assertTrue(!keyboard.moveRight);
			assertTrue(!keyboard.moveLeft);
			
			keyboard.keyTyped(event);
			assertTrue(!keyboard.esc);
			assertTrue(!keyboard.shoot);
			assertTrue(!keyboard.moveDown);
			assertTrue(!keyboard.moveUp);
			assertTrue(!keyboard.moveRight);
			assertTrue(!keyboard.moveLeft);
		}		
	}
}