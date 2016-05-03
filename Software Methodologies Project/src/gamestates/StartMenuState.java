package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import input.Sound;

import main.MainWindow;

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
		Sound a = new Sound("load.wav");
		
		a.play();
	}
	
	/**
	 * Evaluate the position where the mouse was clicked and change the state of the game.
	 */
	@Override
	public void updateVariables() {
		Sound b = new Sound("click.wav");
		
		if(game.getMouse().isRightPressed()){
			if(GameState.getChangeState()){
				if(game.getMouse().getMouseX() >= 200 && game.getMouse().getMouseX() <= 600){
					if(game.getMouse().getMouseY() >= 332 && game.getMouse().getMouseY() <= 407){
						GameState.setGameStateTo(game.shipSelectionState());
						b.play();
						GameState.setChangeState(false);
					}
					
					if(game.getMouse().getMouseY() >= 437 && game.getMouse().getMouseY() <= 512){
						//Place for got to showScoreState
						b.play();
					}
					
					if(game.getMouse().getMouseY() >= 542 && game.getMouse().getMouseY() <= 617){
						GameState.setGameStateTo(game.handleQuitState());
						b.play();
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
	//	graphics.drawString("Temporary Start",325,375);
		graphics.drawString("Start",(game.getWidth()/2)-30,(2*game.getHeight()/5));
		graphics.drawString("Temporary High Scores",290,480);
		graphics.drawString("Temporary Exit",330,585);
	}
}