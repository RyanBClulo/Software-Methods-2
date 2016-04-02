package graphics;

import java.awt.image.BufferedImage;

public class Images {
	
	public static BufferedImage player_ship,enemy_ship;
	
	public static void initiateImages(){
		
		SpriteSheet test = new SpriteSheet(ImageLoader.loadImage("/test.png"));
		SpriteSheet galagaSprites = new SpriteSheet(ImageLoader.loadImage("/Galaga_Sprite_Sheet.png"));
		
		player_ship = test.crop(0, 0, 100, 100);
		enemy_ship = galagaSprites.crop(249,219,13,10);
		
	}
}
