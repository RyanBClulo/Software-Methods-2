package gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.MainWindow;

public abstract class GameObjects {
	
	public static final int playerWidth=50;
	public static final int playerHeight=50;
	public static final int enemyWidth=50;
	public static final int enemyHeight=50;
	public static final int bulletWidth=20;
	public static final int bulletHeight=20;

	protected MainWindow game;
	protected float x,y;
	protected int width, height;
	protected float speed= 1.0f;
	protected int health;
	protected int counter;
	protected Rectangle bounds;
	
	public GameObjects(MainWindow game,float x, float y, int width, int height){
		this.game=game;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height = height;
		bounds = new Rectangle();
	}
	
	public abstract void updateVariables();
	
	public abstract void draw(Graphics graphics);

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public int getCounter(){
		return counter;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(bounds.x+(int)x,bounds.y+(int)y,bounds.width,bounds.height);
	}
}