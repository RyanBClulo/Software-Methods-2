package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class MiniBoss extends GameObjects {
	
	public MiniBoss(MainWindow game) {
		super(game,(game.getWidth()-miniBossWidth)/2,-(miniBossHeight+500),miniBossWidth,miniBossHeight);
		speed=1.5f;
	}

	@Override
	public void updateVariables() {
		if(y<100){
			y+=2.0f;
		}else{
			x+=speed;
		}
		
		if(x<10 || x>(game.getWidth()-miniBossWidth-10))speed*=-1;
		
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.boss,(int)x,(int)y,width,height,null);
	}
	
	public void backToInitialPosition(){
		x=(game.getWidth()-miniBossWidth)/2;
		y=-(miniBossHeight+500);
	}
}