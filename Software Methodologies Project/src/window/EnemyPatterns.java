package window;

import java.awt.Point;
import java.util.Random;

import physicsObjects.Enemy;

public class EnemyPatterns {
	
	//movement patterns
	public static final int STATIONARY=0;
	public static final int SQUARE=1;
	public static final int FIGURE8=2;	
	public static final int patternCount(){return 3;}
	
	public static void moveFormation(Enemy ship,int pattern){
		patterns(ship,pattern);
	}
	
	private static void patterns(Enemy ship,int pattern){
		switch(pattern){
		case STATIONARY:
			break;
		case SQUARE:
			switch(ship.formationStatus){
			case 0 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()+75),(int)(ship.destination.getY())),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 1 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()),(int)(ship.destination.getY()+75)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 2 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()-75),(int)(ship.destination.getY())),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 3 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()-75),(int)(ship.destination.getY())),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 4 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()),(int)(ship.destination.getY()-75)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 5 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()+75),(int)(ship.destination.getY())),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 6 : ship.formationStatus=0;break;	
			}break;
		case FIGURE8:
			switch(ship.formationStatus){
			case 0 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()+50),(int)(ship.destination.getY()+50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 1 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()),(int)(ship.destination.getY()-50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 2 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()),(int)(ship.destination.getY()-50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 3 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()-50),(int)(ship.destination.getY()+50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 4 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()-50),(int)(ship.destination.getY()+50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 5 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()),(int)(ship.destination.getY()-50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 6 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()),(int)(ship.destination.getY()-50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 7 : new Enemy(ship.destination,new Point((int)(ship.destination.getX()+50),(int)(ship.destination.getY()+50)),ship.formationStatus+1);ship.enemyDestroyed();break;
			case 8 : ship.formationStatus=0;break;	
			}break;
		}
		
	}
}
