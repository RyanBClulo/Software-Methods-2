package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import window.MainWindow;

/**
 * Game state that shows the start menu.
 * @author Eder Paz
 */
public class StartMenuState extends GameState{
	
	/**
	 * Constructor of the state.
	 * @param game
	 */
	public StartMenuState(MainWindow game) {
		super(game);
	}
	
	/**
	 * Evaluate the position where the mouse was clicked and change the state of the game.
	 */
	@Override
	public void updateVariables() {
		if(game.getMouse().rightPressed){
			if(GameState.getChangeState()){
				if(game.getMouse().mouseX >= 200 && game.getMouse().mouseX <= 600){
					if(game.getMouse().mouseY >= 332 && game.getMouse().mouseY <= 407){
						GameState.setGameStateTo(game.shipSelectionState());
						GameState.setChangeState(false);
					}
					if(game.getMouse().mouseY >= 437 && game.getMouse().mouseY <= 512){
						//Place for got to showScoreState
					}
					if(game.getMouse().mouseY >= 542 && game.getMouse().mouseY <= 617){
						GameState.setGameStateTo(game.handleQuitState());
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
		
		graphics.drawRect((game.getWidth()-400)/2,(game.getHeight()-285)/2,400,75);
		graphics.drawRect((game.getWidth()-400)/2,(game.getHeight()-285)/2+75+30,400,75);
		graphics.drawRect((game.getWidth()-400)/2,(game.getHeight()-285)/2+2*(75+30),400,75);
		
		graphics.drawString("SMP - eXtreme",330,200);
		graphics.drawString("Temporary Start",325,375);
		graphics.drawString("Temporary High Scores",290,480);
		graphics.drawString("Temporary Exit",330,585);
	}
}