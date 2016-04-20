package gameobjects;

/**
 * @author Franco Reda
 * @author Eder Paz
 * 
 * @version Created: April 11, 2016
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import gamestates.GameState;
import main.MainWindow;

public class Star extends GameObjects{
	
	private int animation;
	private int time;
	private float x;
	private float y;
		
	public Star(MainWindow game,float x,float y){
	super(game,x,x,3,3);	
		this.x=x;
		this.y=y;
		Random r = new Random();
		time = r.nextInt(20)+5;
	}
	
	public void updateVariables(){
		
		if(GameState.getCurrentGameState()!=game.pauseState())y+=7.0f;		
		
		counter++;
		if(counter==time){
			counter=0;
			if(animation==0){
				width--;
				height--;
				if(width==0)
					animation=1;
			}else{
				width++;
				height++;
				if(width==3)
					animation=0;
			}
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y,width,height);
	}
}
