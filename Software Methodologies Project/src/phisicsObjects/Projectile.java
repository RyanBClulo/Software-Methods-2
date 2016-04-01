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
	
	public Point origin;
	public Point destination;
	public double launchTime = 0;
	public double percent = percentageTraveled();
	protected static ArrayList<Projectile> projectileArray =new ArrayList<Projectile>();
		
	public Projectile(float x,float y){
		
		this.x=x;
		this.y=y;
		
		origin=new Point((int)x,(int)y);
		destination=new Point((int)x,-10);
		launchTime = System.currentTimeMillis();
		projectileArray.add(this);
	}
	
	public void updateVariables(){
		y-=4.0f;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillOval((int)x,(int)y,20,20);
	}

	public double percentageTraveled() {
		long currentTime= System.currentTimeMillis();
		double percentageTraveled =pointsPerMillisecond()*(currentTime-launchTime);
		return percentageTraveled/100;	
	}
	
	public static double pointsPerMillisecond() {
		return 7.2;
	}
	
	public Point currentLocation() {
		percent = percentageTraveled();			
		if (y<=-10){
			projectileArray.remove(this);
		}
		return new Point((int)x,(int)y);
	}
	
	public static Iterator<Projectile> ProjecileIterator() {
		//need to make a copy of the arraylist for public consumption 
		//otherwise you could get an error when another thread is concurrently adding or removing from
		//the arraylist while another is in a loops or iterator
		  return (Iterator<Projectile>) ((ArrayList<Projectile>) projectileArray.clone()).iterator();	
		}
	
	public boolean exists() {
		return launchTime != 0;
	}
	
	public void hit(){
		projectileArray.remove(this);
	}
}