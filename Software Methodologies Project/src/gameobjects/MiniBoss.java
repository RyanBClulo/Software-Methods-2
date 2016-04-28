package gameobjects;

import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class MiniBoss extends GameObjects {
	
	public MiniBoss(MainWindow game) {
		super(game,0,0,miniBossWidth,miniBossHeight);
	}

	@Override
	public void updateVariables() {
		
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Images.boss,(int)x,(int)y,width,height,null);
	}
}