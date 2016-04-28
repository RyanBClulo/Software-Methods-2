package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class SuperNova extends GameObjects{
	
	private int animation;

	public SuperNova(MainWindow game, float x, float y) {
		super(game,x,y,superNovaWidth,superNovaHeight);
	}

	@Override
	public void updateVariables() {
		y-=4.0f;
		counter++;
		if(counter==10){
			counter=0;
			if(anim<5)
				anim++;
			else{
				if(animation==0){
					anim++;
					if(anim==7)
						animation++;
				}else
					anim--;
					if(anim==5)
						animation--;
			}
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.superNova[anim],(int)x,(int)y,width,height,null);
	}
}