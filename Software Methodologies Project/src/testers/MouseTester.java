package testers;

import static org.junit.Assert.*;
import java.awt.Button;
import java.awt.event.MouseEvent;
import org.junit.Test;
import input.Mouse;

public class MouseTester {
	
	/**
	 * Test if all the boolean variables are initialized right<br>
	 * The boolean variable should be false, while the int variables should be zero.
	 */
	@Test
	public void initialization() {
		
		Mouse mouse = new Mouse();
		
		assertFalse(mouse.isRightPressed());
		assertFalse(mouse.isLeftPressed());
		assertEquals(mouse.getMouseX(),0);
		assertEquals(mouse.getMouseY(),0);
	}
	
	/**
	 * Test if the right pressed variable changes its value when a click is made on the right button of the mouse.<br>
	 * Test if other variables are not changed for it to.
	 */
	@Test
	public void rightPressedVariable(){
		Mouse mouse = new Mouse();
		
		Button button = new Button("");
		MouseEvent event = new MouseEvent(button,0,0,0,0,0,0,false,MouseEvent.BUTTON1);
		
		for(int x=0 ; x<1001 ; x++){
			
			mouse.mouseReleased(event);
			assertFalse(mouse.isRightPressed());
			assertFalse(mouse.isLeftPressed());
			assertEquals(mouse.getMouseX(),0);
			assertEquals(mouse.getMouseY(),0);
			
			mouse.mousePressed(event);
			assertTrue(mouse.isRightPressed());
			assertFalse(mouse.isLeftPressed());
			assertEquals(mouse.getMouseX(),0);
			assertEquals(mouse.getMouseY(),0);
		}
	}
	
	/**
	 * Test if the left pressed variable changes its value when a click is made on the right button of the mouse.<br>
	 * Test if other variables are not changed for it to.
	 */
	@Test
	public void leftPressedVariable(){
		Mouse mouse = new Mouse();
		
		Button button = new Button();
		MouseEvent event = new MouseEvent(button,0,0,0,3,3,0,false,MouseEvent.BUTTON2);
		
		for(int x=0 ; x<1001 ; x++){
			
			mouse.mouseReleased(event);
			assertFalse(mouse.isLeftPressed());
			assertFalse(mouse.isRightPressed());
			assertEquals(mouse.getMouseX(),0);
			assertEquals(mouse.getMouseY(),0);
			
			mouse.mousePressed(event);
			assertTrue(mouse.isLeftPressed());
			assertFalse(mouse.isRightPressed());
			assertEquals(mouse.getMouseX(),0);
			assertEquals(mouse.getMouseY(),0);
		}
	}
	
	/**
	 * Test if the variables mouseX and mouseY really store the position of the mouse every time it moves on the screen.<br>
	 * Test if other variables are not changed for it to.
	 */
	@Test
	public void mouseMoving(){
		Mouse mouse = new Mouse();
		
		Button button = new Button("");
		
		for(int x=0 ; x<501 ; x++){
			for(int y=0 ; y<501 ; y++){
				MouseEvent event = new MouseEvent(button,0,0,0,x,y,0,false);
				
				mouse.mouseMoved(event);
				assertFalse(mouse.isRightPressed());
				assertFalse(mouse.isLeftPressed());
				assertEquals(mouse.getMouseX(),x);
				assertEquals(mouse.getMouseY(),y);
			}
		}
	}
	
	/**
	 * Test if actions on the third button of the mouse does not change the instance variables
	 */
	@Test
	public void otherMouseButtonActions(){
		Mouse mouse = new Mouse();
		
		Button button = new Button("");
		MouseEvent event = new MouseEvent(button,0,0,0,3,3,0,false,MouseEvent.BUTTON3);
		
		for(int x=0 ; x<501 ; x++){
			
			mouse.mouseReleased(event);
			assertFalse(mouse.isRightPressed());
			assertFalse(mouse.isLeftPressed());
			assertEquals(mouse.getMouseX(),0);
			assertEquals(mouse.getMouseY(),0);
			
			mouse.mousePressed(event);
			assertFalse(mouse.isRightPressed());
			assertFalse(mouse.isLeftPressed());
			assertEquals(mouse.getMouseX(),0);
			assertEquals(mouse.getMouseY(),0);
		}		
	}
	
	/**
	 * Test if any other possible mouse event with any of the mouse buttons change the instance variables.
	 */
	@Test
	public void otheMouseActions(){
		Mouse mouse = new Mouse();
		
		Button button = new Button("");
		
		for(int x=0 ; x<501 ; x++){
			for(int y=1 ; y<=3 ; y++){
				MouseEvent event = new MouseEvent(button,0,0,0,5,5,0,false,y);
				
				mouse.mouseClicked(event);
				assertFalse(mouse.isRightPressed());
				assertFalse(mouse.isLeftPressed());
				assertEquals(mouse.getMouseX(),0);
				assertEquals(mouse.getMouseY(),0);
				
				mouse.mouseDragged(event);
				assertFalse(mouse.isRightPressed());
				assertFalse(mouse.isLeftPressed());
				assertEquals(mouse.getMouseX(),0);
				assertEquals(mouse.getMouseY(),0);
				
				mouse.mouseEntered(event);
				assertFalse(mouse.isRightPressed());
				assertFalse(mouse.isLeftPressed());
				assertEquals(mouse.getMouseX(),0);
				assertEquals(mouse.getMouseY(),0);
				
				mouse.mouseExited(event);
				assertFalse(mouse.isRightPressed());
				assertFalse(mouse.isLeftPressed());
				assertEquals(mouse.getMouseX(),0);
				assertEquals(mouse.getMouseY(),0);
			}
		}
	}
}