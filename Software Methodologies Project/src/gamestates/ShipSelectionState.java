package gamestates;

import input.Sound;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Images;
import graphics.TextSettings;
import main.MainWindow;

public class ShipSelectionState extends GameState{

	private Sound b;
	
	public ShipSelectionState(MainWindow game) {
		super(game);
		b = new Sound("click.wav");
	}

	@Override
	public void updateVariables() {
		if(game.getMouse().isRightPressed()){
			if(GameState.getChangeState()){
				if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 525){
					if(game.getMouse().getMouseX() >= 200 && game.getMouse().getMouseX() <= 300){
						GameState.setGameStateTo(game.difficultyState());
						GameState.setChangeState(false);
						b.play();
						game.getPlayingState().getPlayerShip().setShip(0);
						game.getDifficultystate().resetChoice();
					}
					if(game.getMouse().getMouseX() >= 350 && game.getMouse().getMouseX() <= 450){
						GameState.setGameStateTo(game.difficultyState());
						GameState.setChangeState(false);
						b.play();
						game.getPlayingState().getPlayerShip().setShip(1);
						game.getDifficultystate().resetChoice();
					}
					if(game.getMouse().getMouseX() >= 500 && game.getMouse().getMouseX() <= 600){
						GameState.setGameStateTo(game.difficultyState());
						GameState.setChangeState(false);
						b.play();
						game.getPlayingState().getPlayerShip().setShip(2);
						game.getDifficultystate().resetChoice();
					}
				}
			}
		}else{
			GameState.setChangeState(true);
		}
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(TextSettings.subMenuTitle);
		
		graphics.drawString("Select your Ship",(game.getWidth()/2)-190,(game.getHeight()/4));
		
		for(int x=0 ; x<3 ; x++){
			graphics.drawImage(Images.playerShip[x],(game.getWidth()-400)/2+x*150,(game.getHeight()-100)/2,100,100,null);
		}
		
		
		if(game.getMouse().getMouseY() >= 425 && game.getMouse().getMouseY() <= 525){
			if(game.getMouse().getMouseX() >= 200 && game.getMouse().getMouseX() <= 300){	
				graphics.setFont(TextSettings.subMenuFont);
				graphics.drawString("Durandal",(game.getWidth()/2)-55,580);
				
				graphics.setFont(TextSettings.subMenuFont2);
				graphics.drawString("Special: Laser",(game.getWidth()/2)-130,650);
				graphics.drawString("Shot Type: Fast Shot",(game.getWidth()/2)-130,620);
			}
			if(game.getMouse().getMouseX() >= 350 && game.getMouse().getMouseX() <= 450){
				graphics.setFont(TextSettings.subMenuFont);
				graphics.drawString("Joyeuse",(game.getWidth()/2)-52,580);
				
				graphics.setFont(TextSettings.subMenuFont2);
				graphics.drawString("Special: Bomb",(game.getWidth()/2)-130,650);
				graphics.drawString("Shot Type: Double Shot",(game.getWidth()/2)-130,620);
			}
			if(game.getMouse().getMouseX() >= 500 && game.getMouse().getMouseX() <= 600){
				graphics.setFont(TextSettings.subMenuFont);
				graphics.drawString("Tizona",(game.getWidth()/2)-41,580);
				
				graphics.setFont(TextSettings.subMenuFont2);
				graphics.drawString("Special: Shuriken",(game.getWidth()/2)-130,650);
				graphics.drawString("Shot Type: Double Twist Shot",(game.getWidth()/2)-130,620);
			}				
		}
	}
}