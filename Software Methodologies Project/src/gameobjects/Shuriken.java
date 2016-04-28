package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class Shuriken extends GameObjects{

	public Shuriken(MainWindow game,float x,float y) {
		super(game, x, y,shurikenWidth,shurikenHeight);
		speed=8.0f;
		bounds.x=7;
		bounds.y=7;
		bounds.width=width-bounds.x*2;
		bounds.height=height-bounds.y*2;
	}

	@Override
	public void updateVariables() {
		y-=speed;
		
		if(game.getKeyboard().right()){
			x+=1.5f;
		}else if(game.getKeyboard().left()){
			x-=1.5f;
		}
		
		counter++;
		if(counter==2){
			counter=0;
			anim++;
			if(anim==8)
				anim=0;
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.shuriken[anim],(int)x,(int)y,width,height,null);
	}
}