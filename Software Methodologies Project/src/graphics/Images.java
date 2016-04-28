package graphics;

import java.awt.image.BufferedImage;

public class Images {
	
	public static BufferedImage[] playerShip = new BufferedImage[3];
	public static BufferedImage[][] projectile = new BufferedImage[6][6];
	public static BufferedImage[] enemyShip = new BufferedImage[4];
	public static BufferedImage[] shuriken = new BufferedImage[8];
	public static BufferedImage[] superNova = new BufferedImage[8];
	public static BufferedImage boss;
	
	public static void initiateImages(){
		
		SpriteSheet playerShips = new SpriteSheet(ImageLoader.loadImage("Playerships"));
		SpriteSheet projectiles  = new SpriteSheet(ImageLoader.loadImage("Projectiles"));
		SpriteSheet enemies = new SpriteSheet(ImageLoader.loadImage("Enemies"));
		SpriteSheet bosses = new SpriteSheet(ImageLoader.loadImage("Bosses"));
		SpriteSheet specialAttacks = new SpriteSheet(ImageLoader.loadImage("SpecialAttacks"));
		
		boss = bosses.crop(0,0,124,122);
		
		for(int x=0 ; x<8 ; x++){
			shuriken[x] = specialAttacks.crop(x*19,0,19,19);
			superNova[x] = specialAttacks.crop(x*31,19,31,31);
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
