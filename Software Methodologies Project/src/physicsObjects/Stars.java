package physicsObjects;

/**
 * @author Franco Reda
 * 
 * @version Created: April 11, 2016
 */

import java.awt.Graphics2D;
import java.util.ArrayList;

import main.GameLauncher;

public class Stars {
	
	private ArrayList<Star> starList;
	
	public Stars(){
		starList = new ArrayList<Star>();
	}
	
	public void updateVariables(){
		for( int i=0 ; i<starList.size() ; i++ ){
			if(starList.get(i)!=null){
				if(starList.get(i).currentLocation().getY()>(GameLauncher.gameHeight+10))
					removeStar(starList.get(i));
				else
					starList.get(i).updateVariables();
			}
		}
	}
	
	public void draw(Graphics2D g){
		for( int i=0 ; i<starList.size() ; i++ ){
			starList.get(i).draw(g);
		}
	}
	
	public void addStar(Star star){
		starList.add(star);
	}
	
	public void removeStar(Star star){
		starList.remove(star);
	}
}
