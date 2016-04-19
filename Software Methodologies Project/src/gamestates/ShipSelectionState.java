package gamestates;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Images;
import main.MainWindow;

public class ShipSelectionState extends GameState{

	public ShipSelectionState(MainWindow game) {
		super(game);
	}

	@Override
	public void updateVariables() {
		if(game.getMouse().isRightPressed()){
			if(GameState.getChangeState()){
				if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 475){
					if(game.getMouse().getMouseX() >= 300 && game.getMouse().getMouseX() <= 350){
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
						game.getPlayingState().getPlayerShip().setShip(0);
					}
					if(game.getMouse().getMouseX() >= 450 && game.getMouse().getMouseX() <= 500){
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
		
		graphics.drawString("Select your Ship",330,350);
		graphics.drawImage(Images.playerShip[0],(game.getWidth()-200)/2,(game.getHeight()-100)/2,50,50,null);
		graphics.drawImage(Images.playerShip[1],(game.getWidth()-200)/2+100+50,(game.getHeight()-100)/2,50,50,null);
		
		if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 475){
			if(game.getMouse().getMouseX() >= 300 && game.getMouse().getMouseX() <= 350)
				graphics.drawString("Ship 1 Atributes",330,590);
			if(game.getMouse().getMouseX() >= 450 && game.getMouse().getMouseX() <= 500)
				graphics.drawString("Ship 2 Atributes",330,590);
				
		}
	}
}