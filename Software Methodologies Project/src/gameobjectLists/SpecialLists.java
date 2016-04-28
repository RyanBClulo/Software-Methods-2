package gameobjectLists;

import java.awt.Graphics;
import java.util.ArrayList;

import gameobjects.GameObjects;
import gameobjects.Shuriken;

public class SpecialLists {
	
	ArrayList<Shuriken> shurikens = new ArrayList<Shuriken>();
	
	public void updateVariables(){
		for(int x=0 ; x<shurikens.size() ; x++){
			if(shurikens.get(x).getY() < -GameObjects.shurikenHeight){
				removeShuriken(shurikens.get(x));
			}else{
				shurikens.get(x).updateVariables();
			}
		}
	}
	
	public void draw(Graphics graphics){
		for(int x=0 ; x<shurikens.size() ; x++){
			shurikens.get(x).draw(graphics);;
		}
	}
	
	public void addShuriken(Shuriken shuriken){
		shurikens.add(shuriken);
	}
	
	public void removeShuriken(Shuriken shuriken){
		shurikens.remove(shuriken);
	}
	
	public void reset(){
		shurikens.clear();
	}
	
	public ArrayList<Shuriken> getShurikenList(){
		return shurikens;
	}
}