package testdrivendevelopment;

import static org.junit.Assert.*;

import java.awt.Button;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import org.junit.Test;
import gameobjects.PlayerShip;
import main.MainWindow;

public class PlayerShipTester {
	
	/**
	 * Test if the player is initiated in the right position on the window,<br>
	 * With its size and life set up right.
	 */
	@Test
	public void initializzation() {
		
		for(float x=0 ; x<200 ; x++){
			for(float y=0 ; y<200 ; y++){
				
				MainWindow game = new MainWindow("",(int)x,(int)y);
				
				PlayerShip player = new PlayerShip(game);
				
				assertEquals((x-50)/2,player.getX(),0.0f);
				assertEquals((y-50)/1.2f,player.getY(),0.5f);
				assertEquals(50,player.getWidth());
				assertEquals(50,player.getHeight());
				assertEquals(5,player.getLife());
			}
		}		
	}
	
	/**
	 * Test if the player is moved to the correct position using the setShipLocation() method.<br>
	 * Test if the player gets back to the initial position using the playerDeath() method.
	 */
	@Test
	public void setShipLocationAndPlayerDeathFunctions(){
		
		MainWindow game = new MainWindow("",900,900);
		PlayerShip player = new PlayerShip(game);
		
		for(int x=0 ; x<200 ; x++){
			for(int y=0 ; y<200 ; y++){
				
				player.setShipLocation(x,y);
				assertEquals(x,player.getX(),0.0f);
				assertEquals(y,player.getY(),0.0f);
				
				player.playerDeath();
				assertEquals((900-50)/2,player.getX(),0.0f);
				assertEquals((900-50)/1.2f,player.getY(),0.0f);
			}
		}
	}
	
	/**
	 * Test if the player ship's speed and shoot spam are set up right when by the function set ship
	 * ship 1 should hold:	speed of 3.0f, shoot spam of 20
	 * ship 2 should hold:	speed of 4.0f, shoot spam of 30
	 */
	@Test
	public void setShipFunction(){
		
		int spam;
		int amountOfBullets;
		
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_SPACE,' ');
		
		MainWindow game = new MainWindow("",900,900);
		PlayerShip player = new PlayerShip(game);
		
		game.getKeyboard().keyPressed(event);
		
		player.setShip(0); //sets the player style
		
		for(int x=0 ; ; x++){ //keeps the space bar pressed and analysis how many updateVariable it takes for the player to shoot again 
			amountOfBullets = player.getBullets().getBulletList().size();
			player.updateVariables();
			if(amountOfBullets!=player.getBullets().getBulletList().size() && x!=0){
				spam= --x;
				break;
			}
		}
		
		assertEquals(3.0f,player.getSpeed(),0.0f);
		assertEquals(20,spam);
		
		game.getKeyboard().keyReleased(event);
		player.updateVariables();				//resets the spam counting
		game.getKeyboard().keyPressed(event);
		
		player.setShip(1); //changes the player style
		
		for(int x=0 ; ; x++){ //keeps the space bar pressed and analysis how many updateVariable it takes for the player to shoot again 
			amountOfBullets = player.getBullets().getBulletList().size();
			player.updateVariables();
			if(amountOfBullets!=player.getBullets().getBulletList().size() && x!=0){
				spam= --x;
				break;
			}
		}
		
		assertEquals(4.0f,player.getSpeed(),0.0f);
		assertEquals(30,spam);
	}
	
	/**
	 * Test if the player moves up according o its speed when the key up is pressed.<br>
	 * Test if the player stops moving when gets to the higher limit of the screen (y position 0).
	 */
	@Test
	public void movingUp(){
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_UP,' ');
		
		MainWindow game = new MainWindow("",900,900);
		PlayerShip player = new PlayerShip(game);
		
		player.setShip(0); //set player's speed, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getY()>0){
				assertEquals((900-50)/1.2f-x*3.0f,player.getY(),0.0f);
			}else{
				assertEquals(0.0f,player.getY(),3.0f);
			}
			player.updateVariables(); //move the player
		}
		
		player.playerDeath(); //gets the player to the initial position, check setShipLocationAndPlayerDeathFunctions() method
		player.setShip(1); //set player's speed, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getY()>0){
				assertEquals((900-50)/1.2f-x*4.0f,player.getY(),0.0f);
			}else{
				assertEquals(0.0f,player.getY(),4.0f);
			}
			player.updateVariables();
		}	
	}
	
	/**
	 * Test if the player moves down according o its speed when the key down is pressed.<br>
	 * Test if the player stops moving when gets to the lower limit of the screen (y position height of the screen minus 50).
	 */
	@Test
	public void movingDown(){
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_DOWN,' ');
		
		MainWindow game = new MainWindow("",900,900);
		PlayerShip player = new PlayerShip(game);
		
		player.setShip(0); //set player's speed to zero, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getY()<850){
				assertEquals((900-50)/1.2f+x*3.0f,player.getY(),0.0f);
			}else{
				assertEquals(850,player.getY(),3.0f);
			}
			player.updateVariables();
		}
		
		player.playerDeath(); //gets the player to the initial position, check setShipLocationAndPlayerDeathFunctions() method
		player.setShip(1); //set player's speed to zero, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getY()<850){
				assertEquals((900-50)/1.2f+x*4.0f,player.getY(),0.0f);
			}else{
				assertEquals(850,player.getY(),4.0f);
			}
			player.updateVariables();
		}	
	}
	
	/**
	 * Test if the player moves left according o its speed when the key left is pressed.<br>
	 * Test if the player stops moving when gets to the right limit of the screen (x position 0).
	 */
	@Test
	public void movingLeft(){
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_LEFT,' ');
		
		MainWindow game = new MainWindow("",900,900);
		PlayerShip player = new PlayerShip(game);
		
		player.setShip(0); //set player's speed to zero, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getX()>0){
				assertEquals((900-50)/2-x*3.0f,player.getX(),0.0f);
			}else{
				assertEquals(0.0f,player.getX(),3.0f);
			}
			player.updateVariables();
		}
		
		player.playerDeath(); //gets the player to the initial position, check setShipLocationAndPlayerDeathFunctions() method
		player.setShip(1); //set player's speed to zero, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getX()>0){
				assertEquals((900-50)/2f-x*4.0f,player.getX(),0.0f);
			}else{
				assertEquals(0.0f,player.getX(),4.0f);
			}
			player.updateVariables();
		}	
	}
	
	/**
	 * Test if the player moves right according to its speed when the key right is pressed.<br>
	 * Test if the player stops moving when gets to the left limit of the screen (x position width of the screen minus 50).
	 */
	@Test
	public void movingRight(){
		Button button = new Button("");
		KeyEvent event = new KeyEvent(button,1,20,1,KeyEvent.VK_RIGHT,' ');
		
		MainWindow game = new MainWindow("",900,900);
		PlayerShip player = new PlayerShip(game);
		
		player.setShip(0); //set player's speed to zero, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getX()<850){
				assertEquals((900-50)/2f+x*3.0f,player.getX(),0.0f);
			}else{
				assertEquals(850,player.getX(),3.0f);
			}
			player.updateVariables();
		}
		
		player.playerDeath(); //gets the player to the initial position, check setShipLocationAndPlayerDeathFunctions() method
		player.setShip(1); //set player's speed to zero, check setShipFunction() method
		
		game.getKeyboard().keyPressed(event);
		
		for(int x=0 ; x<1000 ; x++){
			if(player.getX()<850){
				assertEquals((900-50)/2f+x*4.0f,player.getX(),0.0f);
			}else{
				assertEquals(850,player.getX(),4.0f);
			}
			player.updateVariables();
		}	
	}
	
	/**
	 * Test if the hit box used for collision detection is created right
	 */
	@Test
	public void HitBox(){
		
		for(int x=0 ; x<200 ; x++){
			for(int y=0 ; y<200 ; y++){
				MainWindow game = new MainWindow("",x,y);
				PlayerShip player = new PlayerShip(game);
				/*
				 * The hit box of the player should always be a rectangle located 5 pixels to the right of its x position
				 * and 17 pixels below its y position.
				 * It also should hold the size of 40 x 35 pixels;
				 */
				Rectangle hitBox = new Rectangle((int)player.getX()+5,(int)player.getY()+17,40,35);
				assertEquals(hitBox,player.getBounds());				
			}
		}
	}
	
	/**
	 * Test if the player hit box moves together with the player
	 */
	@Test
	public void HitBoxPosition(){
		
		Button button =  new Button("");
		KeyEvent upEvent = new KeyEvent(button,1,20,1,KeyEvent.VK_UP,' ');
		KeyEvent downEvent = new KeyEvent(button,1,20,1,KeyEvent.VK_DOWN,' ');
		KeyEvent rightEvent = new KeyEvent(button,1,20,1,KeyEvent.VK_RIGHT,' ');
		KeyEvent leftEvent = new KeyEvent(button,1,20,1,KeyEvent.VK_LEFT,' ');
		
		MainWindow game = new MainWindow("",900,900);
		PlayerShip player = new PlayerShip(game);
		
		//moving up and right
		game.getKeyboard().keyPressed(upEvent);
		game.getKeyboard().keyPressed(rightEvent);
		for(int x=0 ; x<100 ; x++){
			//creating a rectangle that "moves" with the player
			Rectangle hitBox = new Rectangle((int)player.getX()+5,(int)player.getY()+17,40,35);
			assertEquals(hitBox,player.getBounds());
			player.updateVariables(); //move the player
		}
		
		//moving up and left
		game.getKeyboard().keyReleased(rightEvent);
		game.getKeyboard().keyPressed(leftEvent);
		for(int x=0 ; x<100 ; x++){
			//creating a rectangle that "moves" with the player
			Rectangle hitBox = new Rectangle((int)player.getX()+5,(int)player.getY()+17,40,35);
			assertEquals(hitBox,player.getBounds());
			player.updateVariables(); //move the player
		}
		
		//moving down and right
		game.getKeyboard().keyReleased(upEvent);
		game.getKeyboard().keyPressed(downEvent);
		game.getKeyboard().keyReleased(leftEvent);
		game.getKeyboard().keyPressed(rightEvent);
		for(int x=0 ; x<100 ; x++){
			//creating a rectangle that "moves" with the player
			Rectangle hitBox = new Rectangle((int)player.getX()+5,(int)player.getY()+17,40,35);
			assertEquals(hitBox,player.getBounds());
			player.updateVariables(); //move the player
		}
		
		//moving down and left
		game.getKeyboard().keyReleased(rightEvent);
		game.getKeyboard().keyPressed(leftEvent);
		for(int x=0 ; x<100 ; x++){
			//creating a rectangle that "moves" with the player
			Rectangle hitBox = new Rectangle((int)player.getX()+5,(int)player.getY()+17,40,35);
			assertEquals(hitBox,player.getBounds());
			player.updateVariables(); //move the player
		}		
	}
}