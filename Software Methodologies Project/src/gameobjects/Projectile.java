package gameobjects;

import java.awt.Graphics;
import graphics.Images;
import main.MainWindow;

/**
 * This Class draws out the Enemy Plane object to shoot missiles.
 * 
 * References: In Class notes
 * 
 * @author Ryan Nelsen-Freund, Ryan Clulo, Mat M�gensen
 * 
 * @Version Created: 4/15/2015;
 */
public class Projectile extends GameObjects{
		
	private int projectile;
	
	public Projectile(MainWindow game,float x,float y,float speed,int projectile){
		super(game,x,y,bulletWidth,bulletHeight);
		this.speed=speed;
		bounds.x=4;
		bounds.y=4;
		bounds.width=width-2*bounds.x;
		bounds.height=height-2*bounds.y;
		this.projectile=projectile;
	}
	
	public void updateVariables(){
		y+=speed;
		counter++;
		if(counter==5){
			counter=0;
			anim++;
			if(anim==6)
				anim=0;
		}
	}
	
	public void draw(Graphics graphics){
		graphics.drawImage(Images.projectile[anim][projectile],(int)x,(int)y,width,height,null);
	}
}