package physicsObjects;

import java.awt.Graphics;

import graphics.Images;
import window.MainWindow;

public class PlayerShip {
	
	private MainWindow game;
	
	private float shipX,shipY,speed;
	private boolean shoot=true;
	
	private Projectiles bullet = new Projectiles();
	
	public PlayerShip(MainWindow game){
		this.game=game;
		this.shipX=(float)(game.getWidth()/2);
		this.shipY=(float)(game.getHeight()/1.2);
		this.speed=4.0f;
	}
	
	//update the player position on the screen
	public void updateVariables(){
		
		//bullet.updateVariables(); //comment this line to work with the last project
		
		//Controls player so only one bullet is shot by space press
		if(game.getKeyboard().shoot){
			if(shoot){
				shoot=false;
				bullet.addProjectile(new Projectile((int)shipX-10,(int)shipY-10));
			}
		}else
			shoot=true;    		
		
		if(	shipY	>	50	&&	game.getKeyboard().moveUp)
			shipY-=speed;
		if(	shipY	<	game.getHeight()-35	&&	game.getKeyboard().moveDown)
			shipY+=speed;
		if(	shipX	>	25	&&	game.getKeyboard().moveLeft)
			shipX-=speed;
		if(	shipX	<	game.getWidth()-25	&&	game.getKeyboard().moveRight)
			shipX+=speed;
	}
	
	//draws the player on the screen
	public void draw(Graphics g){
		
		//bullet.draw((Graphics2D) g); //comment this line to work with the last project
		
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
		setShipLocation((float)game.getWidth()/2,(float)game.getHeight()/1.2f);
	}
	
	public float getShipSpeed(){
		return speed;
	}
}