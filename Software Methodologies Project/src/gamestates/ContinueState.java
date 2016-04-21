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
			if(game.getMouse().getMouseY()>430 && game.getMouse().getMouseY()<458){
				if(game.getMouse().getMouseX()>330 && game.getMouse().getMouseX()<380){
					GameState.setGameStateTo(game.playingState());
					GameState.setChangeState(false);
					game.getPlayingState().useContinue();
					game.getPlayingState().faseStart();
				}
				if(game.getMouse().getMouseX()>420 && game.getMouse().getMouseX()<470){
					GameState.setGameStateTo(game.handleQuitState());
					GameState.setChangeState(false);
				}
			}
		}else if(timer<0){
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
		graphics.drawString("YOU'VE LOST!",330,250);
		graphics.drawString("Wanna Continue?",315,400);
		graphics.drawString("YES",335,452);
		graphics.drawRect((game.getWidth()-140)/2,430,50,28);
		graphics.drawString("NO",430,452);
		graphics.drawRect((game.getWidth()-140)/2+90,430,50,28);
		graphics.drawString(game.getPlayingState().getContinues()+" continues left",30,30);
		graphics.setFont(timerfont);
		if(timer>6){
			graphics.setColor(Color.GREEN);
		}else if(timer>3){
			graphics.setColor(Color.YELLOW);
		}else{
			graphics.setColor(Color.RED);
		}
		graphics.drawString(""+timer,370,350);
	}
}