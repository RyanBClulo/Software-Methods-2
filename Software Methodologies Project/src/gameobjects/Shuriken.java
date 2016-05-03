package gameobjects;

import java.awt.Graphics;
import input.Sound;
import graphics.Images;
import main.MainWindow;

public class Shuriken extends GameObjects{
	
	private int timer;
	
	public Shuriken(MainWindow game,float x,float y) {
		super(game, x, y,shurikenWidth,shurikenHeight);
		Sound b = new Sound("Saucer.wav");
		b.play();
		speed=8.0f;
		bounds.x=7;
		bounds.y=7;
		bounds.width=width-bounds.x*2;
		bounds.height=height-bounds.y*2;
	}

	@Override
	public void updateVariables() {
		
		timer++;
		if(timer<=60){
			y-=5f;
		}else if(timer<=180){
			if(game.getKeyboard().right()){
				x+=10f;
			}else if(game.getKeyboard().left()){
				x-=10f;
			}
			
			if(game.getKeyboard().up()){
				y-=10f;
			}else if(game.getKeyboard().down()){
				y+=10f;
			}
		}else{
			y-=10f;
		}
		
		counter++;
		if(counter==2){
			counter=0;
			anim++;
			if(anim==8)
				anim=0;
		}
		
		if(damage){
			damageTimer++;
			if(damageTimer==damageTime){
				damageTimer=0;
				damage=false;
			}
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.shuriken[anim],(int)x,(int)y,width,height,null);
	}
	
	public void damage(){
		damage=true;
	}
	
	public boolean hasDoneDamage(){
		return damage;
	}
}