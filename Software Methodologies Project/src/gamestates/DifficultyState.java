package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import input.Sound;
import gameobjects.GameObjects;
import graphics.Images;
import graphics.TextSettings;
import main.MainWindow;

public class DifficultyState extends GameState{
	
	private boolean prompt=false;
	private int difficulty;
	private Sound b;
	
	public DifficultyState(MainWindow game) {
		super(game);
		b = new Sound("click.wav");
	}

	@Override
	public void updateVariables() {
		if(game.getMouse().isRightPressed()){
			if(prompt){
				if(game.getMouse().getMouseY()>600 && game.getMouse().getMouseY()<628){
					if(game.getMouse().getMouseX()>(game.getWidth()/3)-30 && game.getMouse().getMouseX()<(game.getWidth()/3)+30){
						game.getPlayingState().gameStart(difficulty);
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
						b.play();
					}else if(game.getMouse().getMouseX()>(2*game.getWidth()/3)-30 && game.getMouse().getMouseX()<(2*game.getWidth()/3)+30){
						GameState.setGameStateTo(game.startMenu());
						GameState.setChangeState(false);
						b.play();
					}
				}
				
			}else{
				if(game.getMouse().getMouseY()>(2*game.getHeight()/3)-20 && game.getMouse().getMouseY()<(2*game.getHeight()/3)+20){
					if(game.getMouse().getMouseX()>((game.getWidth()/3)-60) && game.getMouse().getMouseX()<((game.getWidth()/3)+60)){
						difficulty=0;
						prompt=true;
						b.play();
					}else if(game.getMouse().getMouseX()>((game.getWidth()/2)-60) && game.getMouse().getMouseX()<((game.getWidth()/2)+60)){
						difficulty=1;
						prompt=true;
						b.play();
					}else if(game.getMouse().getMouseX()>((2*game.getWidth()/3)-60) && game.getMouse().getMouseX()<((2*game.getWidth()/3)+60)){
						difficulty=2;
						prompt=true;
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
		graphics.setColor(Color.WHITE);
		
		if(prompt){
			graphics.setFont(TextSettings.subMenuTitle2);
			graphics.drawString("Do you confirm your selection?",(game.getWidth()/2)-275,(game.getHeight()/4));
			
			graphics.setFont(TextSettings.subMenuFont);
			switch(difficulty){
			case 0:
				graphics.drawString("EASY",(game.getWidth()/2)-35,400);
				break;
			case 1:
				graphics.drawString("MEDIUM",(game.getWidth()/2)-52,400);
				break;
			case 2:
				graphics.drawString("HARD",(game.getWidth()/2)-38,400);
				break;
			}
			
			graphics.drawImage(Images.playerShip[game.getPlayingState().getPlayerShip().getShip()],
					(game.getWidth()-GameObjects.playerWidth)/2,450,GameObjects.playerWidth,GameObjects.playerHeight,null);
			graphics.drawString("YES",(game.getWidth()/3)-25,622);
			graphics.drawRect((game.getWidth()/3)-30,600,60,30);
			graphics.drawString("NO",(2*game.getWidth()/3)-20,622);
			graphics.drawRect((2*game.getWidth()/3)-30,600,60,30);
		}else{
			graphics.setFont(TextSettings.subMenuTitle);
			graphics.drawString("Select the Difficulty",(game.getWidth()/2)-250,(game.getHeight()/4));
			
			graphics.setFont(TextSettings.subMenuFont);
			graphics.setColor(Color.GREEN);
			graphics.drawString("EASY",(game.getWidth()/3)-35,(2*game.getHeight()/3)+10);
			graphics.drawRect((game.getWidth()/3)-60,(2*game.getHeight()/3)-20,120,40);
			
			graphics.setColor(Color.BLUE);
			graphics.drawString("MEDIUM",(game.getWidth()/2)-52,(2*game.getHeight()/3)+10);
			graphics.drawRect((game.getWidth()/2)-60,(2*game.getHeight()/3)-20,120,40);
			
			graphics.setColor(Color.RED);
			graphics.drawString("HARD",(2*game.getWidth()/3)-38,(2*game.getHeight()/3)+10);
			graphics.drawRect((2*game.getWidth()/3)-60,(2*game.getHeight()/3)-20,120,40);
			graphics.setColor(Color.WHITE);
		}
	}
	
	public void resetChoice(){
		prompt=false;
	}
}