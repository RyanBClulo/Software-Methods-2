package graphics;

import java.awt.image.BufferedImage;

public class Images {
	
	public static BufferedImage player_ship;
	
	public static void initiateImages(){
		
		SpriteSheet test =new SpriteSheet(ImageLoader.loadImage("/test.png"));
		
		player_ship = test.crop(0, 0, 100, 100);
		
	}
}
