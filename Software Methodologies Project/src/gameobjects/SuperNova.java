package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class SuperNova extends GameObjects{
	
	private int animation;
	private boolean explode;

	public SuperNova(MainWindow game, float x, float y) {
		super(game,x,y,superNovaWidth,superNovaHeight);
		explode=false;
		bounds.x=10;
		bounds.y=10;
		bounds.width=width-bounds.x*2;
		bounds.height=height-bounds.y*2;
	}

	@Override
	public void updateVariables() {
		if(explode){
			if(anim!=16)
				anim++;
			x-=10;
			y-=10;
			width+=20;
			height+=20;
			bounds.width+=20;
			bounds.height+=20;
		}else{
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
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.superNova[anim],(int)x,(int)y,width,height,null);
	}
	
	public void explode(){
		anim=8;
		explode=true;
	}
	
	public boolean isExploded(){
		return explode;
	}
}