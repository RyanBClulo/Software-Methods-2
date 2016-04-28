package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class MiniBoss extends GameObjects {
	
	public MiniBoss(MainWindow game) {
		super(game,(game.getWidth()-miniBossWidth)/2,-(miniBossHeight+500),miniBossWidth,miniBossHeight);
	}

	@Override
	public void updateVariables() {
		if(y<100){
			y+=2.0f;
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.boss,(int)x,(int)y,width,height,null);
	}
}