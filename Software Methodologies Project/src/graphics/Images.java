package graphics;

import java.awt.image.BufferedImage;

public class Images {
	
	public static BufferedImage[] playerShip = new BufferedImage[2];
	public static BufferedImage[] enemyShip = new BufferedImage[4];
	
	public static void initiateImages(){
		
		SpriteSheet test = new SpriteSheet(ImageLoader.loadImage("/test.png"));
		SpriteSheet galagaSprites = new SpriteSheet(ImageLoader.loadImage("/Galaga_Sprite_Sheet.png"));
		SpriteSheet test1 = new SpriteSheet(ImageLoader.loadImage("/test1.png"));
		
		playerShip[0] = test.crop(27,25,48,52);
		playerShip[1] = test1.crop(27,25,48,52);
		
		enemyShip[0] = galagaSprites.crop(249,219, 13,10);
		enemyShip[1] = galagaSprites.crop(250, 146, 13, 10);
		enemyShip[2] = galagaSprites.crop(250, 171, 13, 10);
		enemyShip[3] = galagaSprites.crop(249, 195, 13, 10);		
	}
}
