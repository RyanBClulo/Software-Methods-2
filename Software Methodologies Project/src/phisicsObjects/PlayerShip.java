package phisicsObjects;

import java.awt.Graphics2D;
import java.awt.Point;

import graphics.Images;
import window.MainWindow;

public class PlayerShip {
	
	private float shipX;
	private float shipY;
	private float speed;
	
	public Projectiles bullet = new Projectiles();
	
	public PlayerShip(){
		this.shipX=(float)(MainWindow.aspectRatio.getX()/2);
		this.shipY=(float)(MainWindow.aspectRatio.getY()/1.2);
		this.speed=2.1f;
	}
	
	//update the player position on the screen
	public void updateVariables(Point aspectRatio){
		
		bullet.updateVariables(); //comment this line to work with the last project
		
		if(	shipY	>	50	&&	MainWindow.getKeyboard().moveUp)
    		shipY-=speed;
    	if(	shipY	<	aspectRatio.getY()-35	&&	MainWindow.getKeyboard().moveDown)
    		shipY+=speed;
    	if(	shipX	>	25	&&	MainWindow.getKeyboard().moveLeft)
    		shipX-=speed;
    	if(	shipX	<	aspectRatio.getX()-25	&&	MainWindow.getKeyboard().moveRight)
    		shipX+=speed;
	}
	
	//draws the player on the screen
	public void draw(Graphics2D g){
		
		bullet.draw(g); //comment this line to work with the last project
		
		g.drawImage(Images.player_ship, (int)(shipX-50),(int)(shipY-50),null);
	}
	
	public float getShipX(){
		return shipX;
	}
	
	public float getShipY(){
		return shipY;
	}
	
	public void setShipLocation(float x,float y) {
		shipX=x;
		shipY=y;
	}
	
	public void playerDeath(){
		setShipLocation((float)MainWindow.aspectRatio.getX()/2,(float)MainWindow.aspectRatio.getY()/1.2f);
	}
	
	public float getShipSpeed(){
		return speed;
	}
}