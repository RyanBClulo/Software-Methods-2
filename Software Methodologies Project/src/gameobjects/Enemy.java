/**
 * This Class draws out the Enemy Plane object to shoot missiles.
 * 
 * References: In Class notes
 * 
 * @author Ryan Nelsen-Freund, Ryan Clulo, Mat M�gensen
 * 
 * @Version Created: 4/15/2015;
 */

package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import graphics.Images;
import main.MainWindow;

public class Enemy extends GameObjects{
	
	private int movingPattern;
	private int movingStage;
	private final int distance=100;
	private float xINI,yINI;
	
	public Enemy(MainWindow game,int x,int y,int movingPattern){
		super(game,x,y,enemyWidth,enemyHeight);
		this.movingPattern = movingPattern;
		xINI=x;
		yINI=y;
		bounds.x=5;
		bounds.y=5;
		bounds.width=width-2*bounds.x;
		bounds.height=height-2*bounds.y;
	}
	
	public void updateVariables(){
		switch(movingPattern){
		case 0:
			x+=speed;
			if(Math.abs(xINI-x)>distance){
				speed*=-1;
			}
			break;
		case 1:
			switch(movingStage){
			case 0:
				if(Math.abs(xINI-x)<distance){
					x+=speed;
				}else if (Math.abs(yINI-y)<distance){
					y+=speed;
					if(Math.abs(yINI-y)==distance){
						movingStage++;
						speed*=-1;
					}
				}
				break;
			case 1:
				if(Math.abs(xINI-x)>0){
					x+=speed;
				}else if (Math.abs(yINI-y)>0){
					y+=speed;
					if(Math.abs(yINI-y)==0){
						movingStage++;
						speed*=-1;
					}
				}
				break;
			case 2:
				if(Math.abs(xINI-x)<distance){
					x-=speed;
				}else if (Math.abs(yINI-y)<distance){
					y+=speed;
					if(Math.abs(yINI-y)==distance){
						movingStage++;
						speed*=-1;
					}
				}
				break;
			case 3:
				if(Math.abs(xINI-x)>0){
					x-=speed;
				}else if (Math.abs(yINI-y)>0){
					y+=speed;
					if(Math.abs(yINI-y)==0){
						movingStage=0;
						speed*=-1;
					}
				}
				break;
			}
		}
	}
	
	public void draw(Graphics g){
		g.drawImage(Images.enemy_ship,(int)x,(int)y,width,height,null);
		g.setColor(Color.BLUE);
		g.fillRect(bounds.x+(int)x,bounds.y+(int)y,bounds.width,bounds.height);
	}	
}