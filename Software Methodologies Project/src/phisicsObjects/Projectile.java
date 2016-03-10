/**
 * This Class draws out the Enemy Plane object to shoot missiles.
 * 
 * References: In Class notes
 * 
 * @author Ryan Nelsen-Freund, Ryan Clulo, Mat M�gensen
 * 
 * @Version Created: 4/15/2015;
 */

package phisicsObjects;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Projectile {
	public Point origin;
	public Point destination;
	public double launchTime = 0;
	public long delayTime = 0;
	public double percent = percentageTraveled();
	protected static ArrayList<Projectile> projectileArray =new ArrayList<Projectile>();
		
	public Projectile(int x,int y){
		origin=new Point(x,y);
		destination=new Point(x,-10);
		launchTime = System.currentTimeMillis();
		delayTime=(long) Math.round(Math.random() * 10);
		projectileArray.add(this);
	}

		/**
		 * Based on distance, elapsed time, and speed, how far has the missile traveled 
		 * @return
		 */
		public  double percentageTraveled() {
			long currentTime= System.currentTimeMillis();
			double percentageTraveled =pointsPerMillisecond()*(currentTime-launchTime);
			return percentageTraveled/100;	
		}
		public static double pointsPerMillisecond() {
			return 7.2;
		}
		
		/**
		 * Based on elapsed time and speed in points per millisecond
		 * determine where the missile is at the current time
		 * @return
		 */
		public  Point currentLocation() {
			percent = percentageTraveled();			
			int currentY = (int) (origin.y+(destination.y* percent));
			if (currentY<0){
				projectileArray.remove(this);
			}
			return new Point(origin.x, currentY);
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








