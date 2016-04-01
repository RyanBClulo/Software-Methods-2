package phisicsObjects;

import java.awt.Graphics2D;
import java.awt.Point;

import graphics.Images;
import window.MainWindow;

public class PlayerShip {
	
	private float shipX;
	private float shipY;
	private float speed;
	
	public PlayerShip(){
		this.shipX=(float)(MainWindow.aspectRatio.getX()/2);
		this.shipY=(float)(MainWindow.aspectRatio.getY()/1.2);
		this.speed=2.1f;
	}
	
	//update the player position on the screen
	public void updateVariables(Point aspectRatio){
		
		if(	shipY	>	50	&&	MainWindow.getKeyboard().moveUp)
    		moveShipY(-speed);
    	if(	shipY	<	aspectRatio.getY()-35	&&	MainWindow.getKeyboard().moveDown)
    		moveShipY(speed);
    	if(	shipX	>	25	&&	MainWindow.getKeyboard().moveLeft)
    		moveShipX(-speed);
    	if(	shipX	<	aspectRatio.getX()-25	&&	MainWindow.getKeyboard().moveRight)
    		moveShipX(speed);
	}
	
	//draws the player on the screen
	public void draw(Graphics2D g){
		g.drawImage(Images.player_ship, (int)(shipX-50),(int)(shipY-50),null);
	}
	
	public float getShipX(){
		return shipX;
	}
	
	public float getShipY(){
		return shipY;
	}
	
	public void moveShipX(double x){
		shipX+=x;
	}
	
	public void moveShipY(double y){
		shipY+=y;
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

