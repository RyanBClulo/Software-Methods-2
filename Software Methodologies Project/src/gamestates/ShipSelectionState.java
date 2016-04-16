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
		if(game.getMouse().isRightPressed()){
			if(GameState.getChangeState()){
				if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 525){
					if(game.getMouse().getMouseX() >= 275 && game.getMouse().getMouseX() <= 375){
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
						game.getPlayingState().getPlayerShip().setShip(0);
					}
					if(game.getMouse().getMouseX() >= 425 && game.getMouse().getMouseX() <= 525){
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
						game.getPlayingState().getPlayerShip().setShip(1);
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
		
		if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 525){
			if(game.getMouse().getMouseX() >= 275 && game.getMouse().getMouseX() <= 375)
				graphics.drawString("Ship 1 Atributes",330,590);
			if(game.getMouse().getMouseX() >= 425 && game.getMouse().getMouseX() <= 525)
				graphics.drawString("Ship 2 Atributes",330,590);
				
		}
	}
}