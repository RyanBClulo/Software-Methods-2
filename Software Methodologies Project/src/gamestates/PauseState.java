package gamestates;

import java.awt.Color;
import java.awt.Graphics;

import graphics.TextSettings;
import input.Sound;
import main.MainWindow;

public class PauseState extends GameState{

	private Sound b;
	public PauseState(MainWindow game) {
		super(game);
		b = new Sound("click.wav");
	}

	@Override
	public void updateVariables() {
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
		graphics.setFont(TextSettings.menuFont);
		
		graphics.drawString("THE GAME IS PAUSED",(game.getWidth()/2)-197,300);
		
		graphics.setFont(TextSettings.subMenuFont);
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2,150,50);
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2+50+30,150,50);
		
		graphics.drawString("Resume",(game.getWidth()/2)-50,440);
		graphics.drawString("Quit",(game.getWidth()/2)-25,520);
		
	}
}