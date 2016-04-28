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
				if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 525){
					if(game.getMouse().getMouseX() >= 200 && game.getMouse().getMouseX() <= 300){
						GameState.setGameStateTo(game.difficultyState());
						GameState.setChangeState(false);
						game.getPlayingState().getPlayerShip().setShip(0);
						game.getDifficultystate().resetChoice();
					}
					if(game.getMouse().getMouseX() >= 350 && game.getMouse().getMouseX() <= 450){
						GameState.setGameStateTo(game.difficultyState());
						GameState.setChangeState(false);
						game.getPlayingState().getPlayerShip().setShip(1);
						game.getDifficultystate().resetChoice();
					}
					if(game.getMouse().getMouseX() >= 500 && game.getMouse().getMouseX() <= 600){
						GameState.setGameStateTo(game.difficultyState());
						GameState.setChangeState(false);
						game.getPlayingState().getPlayerShip().setShip(2);
						game.getDifficultystate().resetChoice();
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
		
		for(int x=0 ; x<3 ; x++){
			graphics.drawImage(Images.playerShip[x],(game.getWidth()-400)/2+x*150,(game.getHeight()-100)/2,100,100,null);
		}
		
		if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 525){
			if(game.getMouse().getMouseX() >= 200 && game.getMouse().getMouseX() <= 300)
				graphics.drawString("Ship 1 Atributes",330,590);
			if(game.getMouse().getMouseX() >= 350 && game.getMouse().getMouseX() <= 450)
				graphics.drawString("Ship 2 Atributes",330,590);
			if(game.getMouse().getMouseX() >= 500 && game.getMouse().getMouseX() <= 600)
				graphics.drawString("Ship 3 Atributes",330,590);
				
		}
	}
}