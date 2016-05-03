package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import input.Sound;
import main.MainWindow;

public class PauseState extends GameState{

	public PauseState(MainWindow game) {
		super(game);
	}

	@Override
	public void updateVariables() {
		Sound b = new Sound("click.wav");
		if(game.getKeyboard().esc()){
			if(GameState.getChangeState()){
				GameState.setGameStateTo(game.playingState());
				GameState.setChangeState(false);
				b.play();
			}
		}else if(game.getMouse().isRightPressed()){
			if(GameState.getChangeState()){
				if(game.getMouse().getMouseX() >= 325 && game.getMouse().getMouseX() <= 475){
					if(game.getMouse().getMouseY() >= 410 && game.getMouse().getMouseY() <= 460){
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
						b.play();
					}
					if(game.getMouse().getMouseY() >= 490 && game.getMouse().getMouseY() <= 540){
						GameState.setGameStateTo(game.handleQuitState());
						GameState.setChangeState(false);
						b.play();
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