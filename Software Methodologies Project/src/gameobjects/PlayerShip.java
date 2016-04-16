package gameobjects;

import java.awt.Graphics;
import gameobjectLists.ProjectilesList;
import graphics.Images;
import main.MainWindow;

public class PlayerShip extends GameObjects{
	
	private boolean shoot=true;
	
	private ProjectilesList bullet = new ProjectilesList();
	
	public PlayerShip(MainWindow game){
		super(game,0,0,playerWidth,playerHeight);
		this.x=(float)(game.getWidth()-width)/2;
		this.y=(float)(game.getHeight()-height)/1.2f;
		life=5;
		speed=4.0f;
		bounds.x=5;
		bounds.y=17;
		bounds.width=width-2*bounds.x;
		bounds.height=height-15;
	}
	
	//update the player position on the screen
	public void updateVariables(){
		
		bullet.updateVariables();
		
		//Controls player so only one bullet is shot by space press
		if(game.getKeyboard().space()){
			if(shoot){
				shoot=false;
				bullet.addProjectile(new Projectile(game,(int)x+(width-bulletWidth)/2,(int)y+(height)/2,-9.0f));
			}
		}else
			shoot=true;    		
		
		if(	y	>	0	&&	game.getKeyboard().up())
    		y-=speed;
    	if(	y	<	game.getHeight()-height	&&	game.getKeyboard().down())
    		y+=speed;
    	if(	x	>	0	&&	game.getKeyboard().right())
    		x-=speed;
    	if(	x	<	game.getWidth()-width	&&	game.getKeyboard().left())
    		x+=speed;
	}
	
	//draws the player on the screen
	public void draw(Graphics g){
		
		bullet.draw(g);
		
		g.drawImage(Images.player_ship,(int)x,(int)y,width,height,null);
	}
	
	public void setShipLocation(float x,float y) {
		this.x=x;
		this.y=y;
	}
	
	public void playerDeath(){
		setShipLocation((float)(game.getWidth()-width)/2,(float)(game.getHeight()-height)/1.2f);
	}
	
	public ProjectilesList getBullets(){
		return bullet;
	}
}