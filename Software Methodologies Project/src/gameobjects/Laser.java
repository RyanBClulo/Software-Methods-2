package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class Laser extends GameObjects{
	
	private int length;
	private int timer;
	private int yInTime;
	private int auxWidth;
	
	private boolean isHitting;
	
	public Laser(MainWindow game) {
		super(game,0,0,laserWidth,10);
		auxWidth=laserWidth;
		length=1;
		speed=50;
		bounds.x=3;
		bounds.y=0;
		bounds.width=laserWidth-bounds.x*2;
		damage=isHitting=false;
	}

	@Override
	public void updateVariables() {
		if(!isHitting){
			yInTime+=speed;
			y=game.getPlayingState().getPlayerShip().getY()-(10+2*height+yInTime);
			if(game.getKeyboard().alt() && timer <= 60){
				length=(int)(game.getPlayingState().getPlayerShip().getY()-(10+height)-(y+height));
				bounds.height=length+2*height;
				x=game.getPlayingState().getPlayerShip().getX()+(game.getPlayingState().getPlayerShip().getWidth()-laserWidth)/2;
			}
		}else{
			if(game.getKeyboard().alt() && timer <= 60){
				yInTime=length=(int)(game.getPlayingState().getPlayerShip().getY()-(10+2*height)-y);
				x=game.getPlayingState().getPlayerShip().getX()+(game.getPlayingState().getPlayerShip().getWidth()-laserWidth)/2;
			}
		}
		
		if(game.getKeyboard().alt() && timer <= 60){
			timer++;
			counter++;
			if(counter==1){
				counter=0;
				if(anim!=7){
					anim++;
				}
			}
		}else{
			bounds.height=length-=speed;
			counter++;
			if(counter==1){
				counter=0;
				if(anim!=0){
					anim--;
				}
			}
		}
		
		if(damage){
			damageTimer++;
			if(damageTimer==damageTime){
				damageTimer=0;
				damage=false;
			}
		}
		
		width=2*auxWidth+length;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.laser[anim+16],(int)x,(int)y,auxWidth,height,null);
		graphics.drawImage(Images.laser[anim+8],(int)x,(int)y+height,auxWidth,length,null);
		graphics.drawImage(Images.laser[anim],(int)x,(int)y+length+height,auxWidth,height,null);
	}
	
	public int getLength(){
		return length;
	}
	
	public void hit(float y){
		this.y=y;
		yInTime=length=(int)(game.getPlayingState().getPlayerShip().getY()-(10+2*height)-y);
		isHitting=true;
	}
	
	public void damage(){
		damage=true;
	}
	
	public boolean hasDoneDamage(){
		return damage;
	}
	
	public void release(){
		isHitting=false;
	}
}