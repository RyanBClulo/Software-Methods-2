package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import window.MainWindow;

/**
 * Game state used to handle quit game option.
 * @author Eder Paz
 */
public class HandleQuitState extends GameState{
	
	/**
	 * Constructor of the state.
	 * @param game
	 */
	public HandleQuitState(MainWindow game) {
		super(game);
	}
	
	/**
	 * Evaluate the position where the mouse was clicked and change the state of the state of the game.
	 */
	@Override
	public void updateVariables() {
		if(game.getMouse().rightPressed){
			if(GameState.getChangeState()){
				if(game.getMouse().mouseX >= 325 && game.getMouse().mouseX <= 475){
					if(game.getMouse().mouseY >= 410 && game.getMouse().mouseY <= 460){
						if(GameState.getLastGameState()==game.startMenu())
							game.stop();
						else
							GameState.setGameStateTo(game.startMenu());
					}
					if(game.getMouse().mouseY >= 490 && game.getMouse().mouseY <= 540){
						GameState.backToLastState();
						GameState.setChangeState(false);
					}
				}
			}
		}else{
			GameState.setChangeState(true);
		}
	}
	
	/**
	 * Draw the buttons and the texts.
	 */
	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(font);
		
		if(GameState.getLastGameState()==game.pauseState())
			game.playingState().draw(graphics);
		
		graphics.setColor(Color.WHITE);
		
		graphics.drawString("Quit the game? Are you sure?",250,300);
		if(GameState.getLastGameState()==game.pauseState())
			graphics.drawString("Your current score will not be saved",215,350);
		
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2,150,50);
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2+(50+30),150,50);
		
		graphics.drawString("YES",380,445);
		graphics.drawString("NO",385,520);
	}
}