package gamestates;

import java.awt.Color;
import java.awt.Graphics;

import gameobjects.GameObjects;
import graphics.Images;
import main.MainWindow;

public class DifficultyState extends GameState{
	
	private boolean prompt=false;
	private int difficulty;

	public DifficultyState(MainWindow game) {
		super(game);
	}

	@Override
	public void updateVariables() {
		if(game.getMouse().isRightPressed()){
			if(prompt){
				if(game.getMouse().getMouseY()>600 && game.getMouse().getMouseY()<628){
					if(game.getMouse().getMouseX()>330 && game.getMouse().getMouseX()<380){
						game.getPlayingState().gameStart(difficulty);
						GameState.setGameStateTo(game.playingState());
						GameState.setChangeState(false);
					}else if(game.getMouse().getMouseX()>420 && game.getMouse().getMouseX()<470){
						GameState.setGameStateTo(game.startMenu());
						GameState.setChangeState(false);
					}
				}
				
			}else{
				if(game.getMouse().getMouseY()>400 && game.getMouse().getMouseY()<428){
					if(game.getMouse().getMouseX()>210 && game.getMouse().getMouseX()<310){
						difficulty=0;
						prompt=true;
					}else if(game.getMouse().getMouseX()>350 && game.getMouse().getMouseX()<450){
						difficulty=1;
						prompt=true;
					}else if(game.getMouse().getMouseX()>490 && game.getMouse().getMouseX()<590){
						difficulty=2;
						prompt=true;
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
		graphics.setFont(font);
		if(prompt){
			graphics.drawString("Do you confirm your selection?",255,350);
			
			switch(difficulty){
			case 0:
				graphics.drawString("EASY",375,400);
				break;
			case 1:
				graphics.drawString("MEDIUM",360,400);
				break;
			case 2:
				graphics.drawString("HARD",372,400);
				break;
			}
			
			graphics.drawImage(Images.playerShip[game.getPlayingState().getPlayerShip().getShip()],
					(game.getWidth()-GameObjects.playerWidth)/2,450,GameObjects.playerWidth,GameObjects.playerHeight,null);
			graphics.drawString("YES",335,622);
			graphics.drawRect((game.getWidth()-140)/2,600,50,28);
			graphics.drawString("NO",430,622);
			graphics.drawRect((game.getWidth()-140)/2+90,600,50,28);
		}else{
			graphics.drawString("Select the Difficulty",310,350);
			graphics.drawString("EASY",235,422);
			graphics.drawRect((game.getWidth()-380)/2,400,100,28);
			graphics.drawString("MEDIUM",360,422);
			graphics.drawRect((game.getWidth()-380)/2+140,400,100,28);
			graphics.drawString("HARD",512,422);
			graphics.drawRect((game.getWidth()-380)/2+280,400,100,28);
		}
	}
	
	public void resetChoice(){
		prompt=false;
	}
}