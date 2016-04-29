package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class Laser extends GameObjects{
	
	private int length;
	private int timer;
	
	public Laser(MainWindow game) {
		super(game,0,0,laserWidth,10);
		length=1;
	}

	@Override
	public void updateVariables() {
		
		if(game.getKeyboard().alt() && timer <= 60){
			timer++;
			length+=50;
			
			x=game.getPlayingState().getPlayerShip().getX()+(game.getPlayingState().getPlayerShip().getWidth()-laserWidth)/2;
			y=game.getPlayingState().getPlayerShip().getY()-10;
			
			counter++;
			if(counter==1){
				counter=0;
				if(anim!=7)anim++;
			}
		}else{
			if(length>=0)length-=50;
			counter++;
			if(counter==1){
				counter=0;
				if(anim!=0)anim--;
			}
			y-=15.0f;
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.laser[anim],(int)x,(int)y,width,height,null);
		graphics.drawImage(Images.laser[anim+8],(int)x,(int)y-length,width,length,null);
		graphics.drawImage(Images.laser[anim+16],(int)x,(int)y-(length+height),width,height,null);
	}
	
	public int getLength(){
		return length;
	}
}