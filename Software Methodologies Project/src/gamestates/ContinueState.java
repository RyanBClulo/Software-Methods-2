package gamestates;

import java.awt.Color;
import java.awt.Graphics;

import main.MainWindow;

public class ContinueState extends GameState{
	
	private int timer;
	
	public ContinueState(MainWindow game) {
		super(game);
	}
	
	public void resetTimer(){
		timer=10;
	}

	@Override
	public void updateVariables() {
		
		counter++;
		if(counter==60){
			counter=0;
			timer--;
		}
		
		if(game.getMouse().isRightPressed()){
			GameState.setGameStateTo(game.playingState());
			GameState.setChangeState(false);
			game.getPlayingState().useContinue();
			game.getPlayingState().faseStart();
		}else if(timer<=0){
			GameState.setGameStateTo(game.gameOverState());
			GameState.setChangeState(false);
		}else{
			GameState.setChangeState(true);
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(font);
		graphics.drawString("YOU SUCK",game.getWidth()/2,350);
		graphics.drawString(""+game.getPlayingState().getContinues(),100,100);
		graphics.drawString(""+timer,150,150);
	}
}