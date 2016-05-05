package gameobjects;

import java.awt.Graphics;
import graphics.Images;
import main.MainWindow;

/**
 * This Class draws out the Enemy Plane object to shoot missiles.
 * 
 * References: In Class notes
 * 
 * @author Ryan Nelsen-Freund, Ryan Clulo, Mat M�gensen
 * 
 * @Version Created: 4/15/2015;
 */
public class Projectile extends GameObjects{
		
	private int projectile;
	private float speedX;
	private float initialX;
	private float initialXSpeed;
	private int moving;
	
	public Projectile(MainWindow game,float x,float y,float speedY,float speedX,int projectile){
		super(game,x,y,bulletWidth,bulletHeight);
		this.speed=speedY;
		this.initialXSpeed=this.speedX=speedX;
		this.initialX=x;
		bounds.x=4;
		bounds.y=4;
		bounds.width=width-2*bounds.x;
		bounds.height=height-2*bounds.y;
		this.projectile=projectile;
	}
	
	public void updateVariables(){
		y+=speed;
		
		if(projectile==2){
			switch(moving){
			case 0:
				x+=speedX;
				speedX*=((float)70/(float)100);
				if(Math.abs(speedX)<1){
					if(initialXSpeed>0)speedX=1.0f;
					else speedX=-1.0f;
				}
				if(Math.abs(initialX-x)>25){
					speedX*=-1;
					initialX=x;
					moving++;
				}
				break;
			case 1:
				x+=speedX;
				speedX*=((float)100/(float)70);
				if(Math.abs(speedX)>9){
					if(initialXSpeed>0)speedX=-9.0f;
					else speedX=9.0f;
				}
				if(Math.abs(initialX-x)>25){
					initialX=x;
					moving++;
				}
				break;
			case 2:
				x+=speedX;
				speedX*=((float)70/(float)100);
				if(Math.abs(speedX)<1){
					if(initialXSpeed>0)speedX=-1.0f;
					else speedX=1.0f;
				}
				if(Math.abs(initialX-x)>25){
					speedX*=-1;
					initialX=x;
					moving++;
				}
				break;
			case 3:
				x+=speedX;
				speedX*=((float)100/(float)70);
				if(Math.abs(speedX)>9){
					if(initialXSpeed>0)speedX=9.0f;
					else speedX=-9.0f;
				}
				if(Math.abs(initialX-x)>25){
					initialX=x;
					moving=0;
				}
				break;
			}
		}
		
		counter++;
		if(counter==5){
			counter=0;
			anim++;
			if(anim==6)
				anim=0;
		}
	}
	
	public void draw(Graphics graphics){
		graphics.drawImage(Images.projectile[anim][projectile],(int)x,(int)y,width,height,null);
	}
}