package testers;

import static org.junit.Assert.*;
import java.awt.Button;
import java.awt.event.KeyEvent;
import org.junit.Test;
import input.Keyboard;

public class KeyboardTester {
	
	/**
	 * Test if all the instance boolean variables are initiated as false
	 */
	@Test
	public void initialization(){
		
		Keyboard keyboard = new Keyboard();
		
		assertFalse(keyboard.down());
		assertFalse(keyboard.up());
		assertFalse(keyboard.right());
		assertFalse(keyboard.left());
		assertFalse(keyboard.esc());
		assertFalse(keyboard.space());
	}
	
	/**
	 * Test if the moveDown variable changes whenever the key down is pressed on the keyboard.<br>
	 * Test if any of the other variables are not changed by this actions to.
	 */
	@Test
	public void moveDownVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_DOWN,' ');
		
		for(int x=0 ; x<501 ; x++){
			keyboard.keyReleased(event);
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
			
			keyboard.keyPressed(event);
			assertTrue(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
		}
	}
	
	/**
	 * Test if the moveUp variable changes whenever the key up is pressed on the keyboard.<br>
	 * Test if any of the other variables are not changed by this actions to.
	 */
	@Test
	public void moveUpVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_UP,' ');
		
		for(int x=0 ; x<501 ; x++){
			keyboard.keyReleased(event);
			assertFalse(keyboard.up());
			assertFalse(keyboard.down());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
			
			keyboard.keyPressed(event);
			assertTrue(keyboard.up());
			assertFalse(keyboard.down());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
		}
	}
	
	/**
	 * Test if the moveRight variable changes whenever the key right is pressed on the keyboard.<br>
	 * Test if any of the other variables are not changed by this actions to.
	 */
	@Test
	public void moveRightVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_RIGHT,' ');
		
		for(int x=0 ; x<501 ; x++){
			keyboard.keyReleased(event);
			assertFalse(keyboard.right());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
			
			keyboard.keyPressed(event);
			assertTrue(keyboard.right());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
		}
	}
	
	/**
	 * Test if the moveLeft variable changes whenever the key left is pressed on the keyboard.<br>
	 * Test if any of the other variables are not changed by this actions to.
	 */
	@Test
	public void moveLeftVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_LEFT,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertFalse(keyboard.left());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
			
			keyboard.keyPressed(event);
			assertTrue(keyboard.left());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.esc());
			assertFalse(keyboard.space());
		}
	}
	
	/**
	 * Test if the shoot variable changes whenever the space bar is pressed on the keyboard.<br>
	 * Test if any of the other variables are not changed by this actions to.
	 */
	@Test
	public void shootVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_SPACE,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertFalse(keyboard.space());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
			
			keyboard.keyPressed(event);
			assertTrue(keyboard.space());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.esc());
		}
	}
	
	/**
	 * Test if the esc variable changes whenever the escape key is pressed on the keyboard.<br>
	 * Test if any of the other variables are not changed by this actions to.
	 */
	@Test
	public void escVariable(){
		
		Keyboard keyboard = new Keyboard();
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_ESCAPE,' ');
		
		for(int x=0 ; x<1000 ; x++){
			keyboard.keyReleased(event);
			assertFalse(keyboard.esc());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.space());
			
			keyboard.keyPressed(event);
			assertTrue(keyboard.esc());
			assertFalse(keyboard.down());
			assertFalse(keyboard.up());
			assertFalse(keyboard.right());
			assertFalse(keyboard.left());
			assertFalse(keyboard.space());
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
		
		for(int x=0 ; x<256 ; x++){
			if(x!=KeyEvent.VK_ESCAPE&&x!=KeyEvent.VK_SPACE&&x!=KeyEvent.VK_UP&&x!=KeyEvent.VK_DOWN&&x!=KeyEvent.VK_RIGHT&&x!=KeyEvent.VK_LEFT){
				event.setKeyCode(x);
				
				keyboard.keyReleased(event);
				assertFalse(keyboard.esc());
				assertFalse(keyboard.space());
				assertFalse(keyboard.down());
				assertFalse(keyboard.up());
				assertFalse(keyboard.right());
				assertFalse(keyboard.left());
				
				keyboard.keyPressed(event);
				assertFalse(keyboard.esc());
				assertFalse(keyboard.space());
				assertFalse(keyboard.down());
				assertFalse(keyboard.up());
				assertFalse(keyboard.right());
				assertTrue(!keyboard.left());
				
				keyboard.keyTyped(event);
				assertFalse(keyboard.esc());
				assertFalse(keyboard.space());
				assertFalse(keyboard.down());
				assertFalse(keyboard.up());
				assertFalse(keyboard.right());
				assertFalse(keyboard.left());
			}
		}		
	}
}