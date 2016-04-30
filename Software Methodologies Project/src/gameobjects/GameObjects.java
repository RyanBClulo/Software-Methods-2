package gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.MainWindow;

public abstract class GameObjects {
	
	public static final int playerWidth=70;
	public static final int playerHeight=70;
	public static final int enemyWidth=50;
	public static final int enemyHeight=50;
	public static final int bulletWidth=14;
	public static final int bulletHeight=20;
	public static final int miniBossWidth=150;
	public static final int miniBossHeight=130;
	public static final int shurikenWidth=45;
	public static final int shurikenHeight=45;
	public static final int superNovaWidth=40;
	public static final int superNovaHeight=40;
	public static final int laserWidth=20;
	
	public static final int laserPower=4;
	public static final int shurikenPower=5;
	
	public static final int damageTime=10;

	protected MainWindow game;
	protected float x,y;
	protected int width, height;
	protected float speed= 1.0f;
	protected int life;
	protected int counter;
	protected int anim;
	protected int damageTimer;
	protected boolean damage;
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
	
	public int getLife(){
		return life;
	}
	
	public void setLife(int life){
		this.life=life;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(bounds.x+(int)x,bounds.y+(int)y,bounds.width,bounds.height);
	}
}