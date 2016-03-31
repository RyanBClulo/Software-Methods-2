package phisicsObjects;

import java.awt.Point;

import window.MainWindow;

public class PlayerShip {
	private static Point location=new Point((int)(MainWindow.aspectRatio.getX()/2),(int)(MainWindow.aspectRatio.getY()/1.2));
	private static double shipX=getShipX();
	private static double shipY=getShipY();
	
	public static int getShipX(){
		return (int) location.getX();
	}
	public static int getShipY(){
		return (int) location.getY();
	}
	public static void moveShipX(double x){
		shipX+=x;
		setShipLocation(new Point((int)(Math.round(shipX)),(int)(Math.round(shipY))));
	}
	public static void moveShipY(double y){
		shipY+=y;
		setShipLocation(new Point((int)(Math.round(shipX)),(int)(Math.round(shipY))));
	}
	public static void setShipLocation(Point p) {
		// TODO Auto-generated method stub
		location=p;
	}
	public static void updateXY(){
		shipX=getShipX();
		shipY=getShipY();
	}
	public static void playerDeath(){
		setShipLocation(new Point((int)(MainWindow.aspectRatio.getX()/2),(int)(MainWindow.aspectRatio.getY()/1.2)));
		updateXY();
	}
	public static double getShipSpeed(){
		//update once we have more information on the different ships. for now returns 1.6
		return 2.1;
	}
}

