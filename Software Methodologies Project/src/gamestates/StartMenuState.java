package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import input.Sound;
import main.MainWindow;
import graphics.TextSettings;


/**
 * Game state that shows the start menu.
 * @author Eder Paz; @author Franco Reda
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
					
					if(game.getMouse().getMouseY() >= ((game.getHeight()/2)-37.5) && game.getMouse().getMouseY() <= ((game.getHeight()/2)+37.5)){
						GameState.setGameStateTo(game.shipSelectionState());
						b.play();
						GameState.setChangeState(false);
					}
					
					if(game.getMouse().getMouseY() >= ((2*game.getHeight()/3)-37.5) && game.getMouse().getMouseY() <= ((2*game.getHeight()/3)+37.5)){
						//Place for got to showScoreState
						b.play();
					}
					
					if(game.getMouse().getMouseY() >= ((5*game.getHeight()/6)-37.5) && game.getMouse().getMouseY() <= ((5*game.getHeight()/6)+37.5)){
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
		
		graphics.drawRect((game.getWidth()/2)-200,(int) ((game.getHeight()/2)-37.5),400,75);		//Box for Start
		graphics.drawRect((game.getWidth()/2)-200,(int) ((2*game.getHeight()/3)-37.5),400,75);		//Box For High scores
		graphics.drawRect((game.getWidth()/2)-200,(int) ((5*game.getHeight()/6)-37.5),400,75);		//Box for Quit
		
		graphics.setFont(TextSettings.titleFont);
		graphics.drawString("SMP - eXtreme", (game.getWidth()/2)-169,(game.getHeight()/4));
		
		graphics.setFont(TextSettings.menuFont);
		graphics.drawString("Start",		(game.getWidth()/2)-45,(game.getHeight()/2));
		graphics.drawString("High Scores",	(game.getWidth()/2)-105,(2*game.getHeight()/3));
		graphics.drawString("Quit",			(game.getWidth()/2)-37,(5*game.getHeight()/6));
	}
}