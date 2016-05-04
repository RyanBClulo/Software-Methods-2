package gamestates;

import java.awt.Color;
import java.awt.Graphics;

import graphics.TextSettings;
import input.Sound;
import main.MainWindow;

public class GameOverState extends GameState{

	public GameOverState(MainWindow game) {
		super(game);
		
	}

	@Override
	public void updateVariables() {
		counter++;
		if(counter==600){
			GameState.setGameStateTo(game.startMenu());
			GameState.setChangeState(false);
		}else{
			GameState.setChangeState(true);
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(TextSettings.menuFont);
		graphics.drawString("GAME OVER",game.getWidth()/2,350);
		graphics.drawString(""+counter,50,50);
	}
}