/**
 * This Class draws out the Enemy Plane object to shoot missiles.
 * 
 * References: In Class notes
 * 
 * @author Ryan Nelsen-Freund, Ryan Clulo, Mat Møgensen
 * 
 * @Version Created: 4/15/2015;
 */

package phisicsObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Projectile {
	
	private float x;
	private float y;
	
	protected static ArrayList<Projectile> projectileArray =new ArrayList<Projectile>();
		
	public Projectile(float x,float y){
		
		this.x=x;
		this.y=y;
		
		projectileArray.add(this);
	}
	
	public void updateVariables(){
		y-=9.0f;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillOval((int)x,(int)y,20,20);
	}
	
	public static double pointsPerMillisecond() {
		return 7.2;
	}
	
	public Point currentLocation() {
		return new Point((int)x,(int)y);
	}
	
	@SuppressWarnings("unchecked")
	public static Iterator<Projectile> ProjecileIterator() {
		  return (Iterator<Projectile>) ((ArrayList<Projectile>) projectileArray.clone()).iterator();	
	}
	
	public boolean exists() {
		return true;
	}
	
	public void hit(){
		projectileArray.remove(this);
	}
}