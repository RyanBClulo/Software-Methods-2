package graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String path){
		try{
			return ImageIO.read(ImageLoader.class.getResource("/"+path+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e){
			System.out.println("NEED TO CHANGE!!!!!");
			Color color = new Color(255,255,255);
			BufferedImage image = new BufferedImage(1000,1000, BufferedImage.TYPE_INT_RGB);
			for(int x=0 ; x<image.getWidth() ; x++){
				for(int y=0 ; y<image.getHeight() ; y++){
					image.setRGB(x, y,color.getRGB());
				}
			}
			return image;
		}
	}
	
}