package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;

import score.HighScore;
import main.MainWindow;

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
		if(game.getMouse().isRightPressed()){
			if(GameState.getChangeState()){
				if(game.getMouse().getMouseX() >= 325 && game.getMouse().getMouseX() <= 475){
					if(game.getMouse().getMouseY() >= 410 && game.getMouse().getMouseY() <= 460){
						if(GameState.getLastGameState()==game.startMenu()){
							try {
								HighScore.writeScores();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							game.stop();
						}else if(GameState.getLastGameState()==game.pauseState()){
							GameState.setGameStateTo(game.startMenu());
							GameState.setChangeState(false);
						}else if(GameState.getLastGameState()==game.continueState()){
							GameState.setGameStateTo(game.gameOverState());
							GameState.setChangeState(false);
						}
					}
					if(game.getMouse().getMouseY() >= 490 && game.getMouse().getMouseY() <= 540){
						if(GameState.getLastGameState() == game.continueState())
							game.getContinueState().resetTimer();
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
		
		graphics.drawString("Quit the game? Are you sure?",260,300);
		if(GameState.getLastGameState()==game.pauseState())
			graphics.drawString("Your current score will not be saved",215,350);
		
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2,150,50);
		graphics.drawRect((game.getWidth()-150)/2,(game.getHeight()-130)/2+(50+30),150,50);
		
		graphics.drawString("YES",380,445);
		graphics.drawString("NO",385,520);
	}
}