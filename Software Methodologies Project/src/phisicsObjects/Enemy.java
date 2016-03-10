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

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Enemy {
	public Point origin;
	public Point destination;
	public double launchTime = 0;
	public long delayTime = 0;
	public double percent;
	protected static ArrayList<Enemy> enemyArray =new ArrayList<Enemy>();
	public int patternState=0;
		
	public Enemy(){
		Random rnd =new Random();
		int x=rnd.nextInt(19)*40+25;
		origin=new Point(x,-25);
		//destination=new Point(x,rnd.nextInt(100)+100);
		destination=new Point(x,900);
		launchTime = System.currentTimeMillis();
		delayTime=(long) Math.round(Math.random() * 10);
		enemyArray.add(this);
	}
	/**
	 * Main constructor for the enemy class. If the argument is empty, it will create an enemy with a random x and y.
	 * @return
	 * @param
	 * Type awt.Point. Start represents the origin and end represents the destination.
	 */
	public Enemy(Point start, Point end){
		origin=start;
		destination=end;
		launchTime = System.currentTimeMillis();
		delayTime=(long) Math.round(Math.random() * 10);
		enemyArray.add(this);
	}

		/**
		 * Holds on to the speeds of the enemy. Can be expanded for different types of enemies.
		 * @return
		 */
		public double pointsPerMillisecond() {
			// Override this method if you want a different speed for subclass
			if(destination.y<400)	
				return .2;
			else
				return .1;
			
		}

		/**
		 * Tells how far has the missile traveled based on distance, elapsed time, and speed.
		 * @return
		 */
		public double percentageTraveled() {
			long currentTime= System.currentTimeMillis();
			double percentageTraveled =pointsPerMillisecond()*(currentTime-launchTime);

			return percentageTraveled/100;
			
		}
		
		/**
		* Based on elapsed time and speed in points per millisecond.
		* determine where the missile is at the current time
		* @return
		* The location of the object in the form awt.Point
		*/
		public  Point currentLocation() {
			percent = percentageTraveled();
			if (percent > 1.0){
				movement(destination);
				//return destination;
			}
			int currentX = (int) (origin.x + diffX() * percent);
			int currentY = (int) (origin.y + diffY() * percent);
			return new Point(currentX, currentY);	
		}
		private int diffX() {return destination.x - origin.x;}
		private int diffY() {return destination.y - origin.y;}
		private void movement(Point center){
			origin=center;
			if(patternState==0)
				destination=new Point(destination.x+1,destination.y);
			else if(patternState==1)
				destination=new Point(destination.x,destination.y+1);
			else if(patternState==2)
				destination=new Point(destination.x-1,destination.y);
			else if(patternState==3)
				destination=new Point(destination.x,destination.y-1);
			else if(patternState>3)
				patternState=0;
			patternState++;
		}
		
		public static Iterator<Enemy> enemyIterator() {
			//need to make a copy of the arraylist for public consumption 
			//otherwise you could get an error when another thread is concurrently adding or removing from
			//the arraylist while another is in a loops or iterator
			  return (Iterator<Enemy>) ((ArrayList<Enemy>) enemyArray.clone()).iterator();	
			}
		
		public boolean exists() {
			return launchTime != 0;
		}
		
		/**
		 * Simple method that immediately clears all objects of type enemies from the screen.
		 * For testing purposes.
		 * @return
		 */
		public static void clearEnemies(){
			enemyArray.clear();	
		}
		
		/**
		 * called when a ship is destroyed to remove that particular ship from the array thus wiping it from the screen.
		 * @return
		 */
		public void enemyDestroyed(){
			enemyArray.remove(this);
		}
		
		/**
		 * Used to check if the player projectile hits the enemy ship (whithin 25 of the origin of enemy)
		 * @return boolean (ship/projectile overlap)
		 * @param Point p (location of projectile or other attacking object)
		 */
		public boolean containsPoint(Point p){
			return (Math.sqrt(Math.pow((this.currentLocation().getX()-p.getX()-12),2)+Math.pow((this.currentLocation().getY()-p.getY()-12),2))<30);
		}	
	}



