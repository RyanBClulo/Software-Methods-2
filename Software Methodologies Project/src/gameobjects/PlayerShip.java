package gameobjects;

import java.awt.Graphics;
import gameobjectLists.ProjectilesList;
import gameobjectLists.SpecialLists;
import graphics.Images;
import input.Sound;
import main.MainWindow;
import score.Statistics;

public class PlayerShip extends GameObjects{
	
	private int shootSpam;
	private boolean specialSpam=true;
	private int ship;
	private int specialAmount;
	private int bulletPower;
	
	private ProjectilesList bullet = new ProjectilesList();
	private SpecialLists special = new SpecialLists();
	
	public PlayerShip(MainWindow game){
		super(game,0,0,playerWidth,playerHeight);
		this.x=(float)(game.getWidth()-width)/2;
		this.y=(float)(game.getHeight()-height)/1.2f;
	}
	
	//update the player position on the screen
	public void updateVariables(){
		
		bullet.updateVariables();
		special.updateVariables();
		
		counter++;
		if(counter>shootSpam){
			counter=0;
			if(game.getKeyboard().space()){
				if(ship!=1){
					bullet.addProjectile(new Projectile(game,(int)x+(width-bulletWidth)/2,(int)y+GameObjects.bulletHeight,-9.0f,ship));
				}
				else{
					bullet.addProjectile(new Projectile(game,(int)x+(width-bulletWidth)/2-15,(int)y+GameObjects.bulletHeight,-9.0f,ship));
					bullet.addProjectile(new Projectile(game,(int)x+(width-bulletWidth)/2+15,(int)y+GameObjects.bulletHeight,-9.0f,ship));
				}
				Statistics.addShot();
				Sound.playSound("Shot.wav");
			}
		}
		
		if(game.getKeyboard().alt() && specialAmount>0){
			if(specialSpam){
				specialAmount--;
				specialSpam=false;
				switch(ship){
				case 0:
					special.addLaser(new Laser(game));
					break;
				case 1:
					special.addSuperNova(new SuperNova(game,x+(playerWidth-superNovaWidth)/2,y));
					break;
				case 2:
					special.addShuriken(new Shuriken(game,x+(playerWidth-shurikenWidth)/2,y));
					break;
				}
			}
		}else{
			specialSpam=true;
		}
		
		if(	y	>	0	&&	game.getKeyboard().up())
    		y-=speed;
    	if(	y	<	game.getHeight()-height	&&	game.getKeyboard().down())
    		y+=speed;
    	if(	x	>	0	&&	game.getKeyboard().left())
    		x-=speed;
    	if(	x	<	game.getWidth()-width	&&	game.getKeyboard().right())
    		x+=speed;
	}
	
	//draws the player on the screen
	public void draw(Graphics graphics){
		
		bullet.draw(graphics);
		special.draw(graphics);
		graphics.drawImage(Images.playerShip[ship],(int)x,(int)y,width,height,null);
	}
	
	public void setShipLocation(float x,float y) {
		this.x=x;
		this.y=y;
	}
	
	public void playerDeath(){
		setShipLocation((float)(game.getWidth()-width)/2,(float)(game.getHeight()-height)/1.2f);
	}
	
	public ProjectilesList getBullets(){
		return bullet;
	}
	
	public int getShip(){
		return ship;
	}
	
	public int bulletpower(){
		return bulletPower;
	}
	
	public void setShip(int ship){
		this.ship=ship;
		if(ship==0){
			speed=4.0f;
			shootSpam=10;
			bounds.x=18;
			bounds.y=30;
			bounds.width=width-bounds.x*2;
			bounds.height=height-40;
			bulletPower=3;
			specialAmount=10;
		}else if(ship==1){
			speed=3.0f;
			shootSpam=15;
			bounds.x=20;
			bounds.y=20;
			bounds.width=width-2*bounds.x;
			bounds.height=height-25;
			bulletPower=2;
			specialAmount=5;
		}else if(ship==2){
			speed=5.0f;
			shootSpam=10;
			bounds.x=18;
			bounds.y=20;
			bounds.width=width-bounds.x*2;
			bounds.height=height-30;
			bulletPower=2;
			specialAmount=10;
		}
	}
	
	public void resetSpecials(){
		switch(ship){
		case 0:
			specialAmount=10;
			break;
		case 1:
			specialAmount=5;
			break;
		case 2:
			specialAmount=10;
		}
	}
	
	public SpecialLists getSpecials(){
		return special;
	}
}