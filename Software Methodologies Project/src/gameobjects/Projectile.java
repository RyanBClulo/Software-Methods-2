/**
 * This Class draws out the Enemy Plane object to shoot missiles.
 * 
 * References: In Class notes
 * 
 * @author Ryan Nelsen-Freund, Ryan Clulo, Mat M�gensen
 * 
 * @Version Created: 4/15/2015;
 */

package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import main.MainWindow;

public class Projectile extends GameObjects{
		
	public Projectile(MainWindow game,float x,float y,float speed){
		super(game,x,y,bulletWidth,bulletHeight);
		this.speed=speed;
		bounds.x=4;
		bounds.y=4;
		bounds.width=width-2*bounds.x;
		bounds.height=height-2*bounds.y;
	}
	
	public void updateVariables(){
		y+=speed;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillOval((int)x,(int)y,width,height);
	}
}