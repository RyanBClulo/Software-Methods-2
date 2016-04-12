package gamestates;

import java.awt.Color;
import java.awt.Graphics;

import main.MainWindow;

public class ShipSelectionState extends GameState{

	public ShipSelectionState(MainWindow game) {
		super(game);
	}

	@Override
	public void updateVariables() {
		if(game.getMouse().rightPressed){
			if(GameState.getChangeState()){
				if(game.getMouse().mouseY >= 425 && game.getMouse().mouseY <= 525){
					if(game.getMouse().mouseX >= 275 && game.getMouse().mouseX <= 375){
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
					}
					if(game.getMouse().mouseX >= 425 && game.getMouse().mouseX <= 525){
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
					}
				}
			}
		}else{
			GameState.setChangeState(true);
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(font);
		
		graphics.drawString("Select your Ship",330,380);
		graphics.drawRect((game.getWidth()-250)/2,(game.getHeight()-100)/2,100,100);
		graphics.drawRect((game.getWidth()-250)/2+100+50,(game.getHeight()-100)/2,100,100);
		
		if(game.getMouse().mouseY >= 425 && game.getMouse().mouseY <= 525){
			if(game.getMouse().mouseX >= 275 && game.getMouse().mouseX <= 375)
				graphics.drawString("Ship 1 Atributes",330,590);
			if(game.getMouse().mouseX >= 425 && game.getMouse().mouseX <= 525)
				graphics.drawString("Ship 2 Atributes",330,590);
				
		}
	}
}