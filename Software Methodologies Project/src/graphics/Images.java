package graphics;

import java.awt.image.BufferedImage;

public class Images {
	
	public static BufferedImage[] playerShip = new BufferedImage[3];
	public static BufferedImage[][] projectile = new BufferedImage[6][6];
	public static BufferedImage[] enemyShip = new BufferedImage[4];
	public static BufferedImage[] shuriken = new BufferedImage[8];
	public static BufferedImage[] superNova = new BufferedImage[17];
	public static BufferedImage[] laser = new BufferedImage[24];
	public static BufferedImage boss;
	
	public static void initiateImages(){
		
		SpriteSheet playerShips = new SpriteSheet(ImageLoader.loadImage("Playerships"));
		SpriteSheet projectiles  = new SpriteSheet(ImageLoader.loadImage("Projectiles"));
		SpriteSheet enemies = new SpriteSheet(ImageLoader.loadImage("Enemies"));
		SpriteSheet bosses = new SpriteSheet(ImageLoader.loadImage("Bosses"));
		SpriteSheet specialAttacks = new SpriteSheet(ImageLoader.loadImage("SpecialAttacks"));
		
		boss = bosses.crop(0,0,124,122);
		
		for(int x=0 ; x<17 ; x++){
			if(x<8){
				shuriken[x] = specialAttacks.crop(x*19,0,19,19);
				superNova[x] = specialAttacks.crop(x*31,19,31,31);
				laser[x] = specialAttacks.crop(x*16,77,16,7);
				laser[x+8] = specialAttacks.crop(x*16,73,16,3);
				laser[x+16] = specialAttacks.crop(x*16,66,16,7);
			}else{
				superNova[x] = specialAttacks.crop((x-8)*16,50,16,16);
			}
		}
		
		for(int x=0 ; x<4 ; x++){
			enemyShip[x] = enemies.crop(x*64,0,64,64);
		}
		
		for(int x=0 ; x<6 ; x++){
			for(int y=0 ; y<6 ; y++){
				projectile[y][x] = projectiles.crop(x*5,y*8,5,8);
			}
		}
		
		for(int x=0 ; x<3 ; x++){
			playerShip[x] = playerShips.crop(x*66,0,66,52);
		}
	}
}
