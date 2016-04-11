package physicsObjects;

/**
 * @author Franco Reda
 * 
 * @version Created: April 11, 2016
 */

import java.awt.*;
import java.util.*;

public class Star {
	private float x;
	private float y;
	
	protected static ArrayList<Star> starArray =new ArrayList<Star>();
		
	public Star(float x,float y){
		
		this.x=x;
		this.y=y;
		
		starArray.add(this);
	}
	
	public void updateVariables(){
		y+=7.0f;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 3, 3);
	}
	
	public static double pointsPerMillisecond() {
		return 7.2;
	}
	
	public Point currentLocation() {
		return new Point((int)x,(int)y);
	}
	
	@SuppressWarnings("unchecked")
	public static Iterator<Star> StarIterator() {
		  return (Iterator<Star>) ((ArrayList<Star>) starArray.clone()).iterator();	
	}
	
	public boolean exists() {
		return true;
	}
	
	public void hit(){
		starArray.remove(this);
	}
}
