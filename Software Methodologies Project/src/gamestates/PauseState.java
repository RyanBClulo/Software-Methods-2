package gamestates;

import java.awt.Color;
import java.awt.Graphics;

import main.MainWindow;

public class PauseState extends GameState{

	public PauseState(MainWindow game) {
		super(game);
	}

	@Override
	public void updateVariables() {
		if(game.getKeyboard().esc){
			if(GameState.getChangeState()){
				GameState.setGameStateTo(game.playingState());
				GameState.setChangeState(false);
			}
		}else if(game.getMouse().rightPressed){
			if(GameState.getChangeState()){
				if(game.getMouse().mouseX >= 325 && game.getMouse().mouseX <= 475){
					if(game.getMouse().mouseY >= 410 && game.getMouse().mouseY <= 460){
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
					}
					if(game.getMouse().mouseY >= 490 && game.getMouse().mouseY <= 540){
						GameState.setGameStateTo(game.handleQuitState());
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
		
		game.playingState().draw(graphics);
		
		graphics.setColor(Color.WHITE);
		graphics.setFont(font);
		
		graphics.drawString("THE GAME IS PAUSED",290,300);
		
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2,150,50);
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2+50+30,150,50);
		
		graphics.drawString("Resume",365,440);
		graphics.drawString("Quit",380,520);
		
	}
}