package gameobjectLists;

import java.awt.Graphics;
import java.util.ArrayList;
import gameobjects.GameObjects;
import gameobjects.Laser;
import gameobjects.Shuriken;
import gameobjects.SuperNova;

public class SpecialLists {
	
	ArrayList<Shuriken> shurikens = new ArrayList<Shuriken>();
	ArrayList<SuperNova> superNovas = new ArrayList<SuperNova>();
	ArrayList<Laser> lasers = new ArrayList<Laser>();
	
	public void updateVariables(){
		
		for(int x=0 ; x<shurikens.size() ; x++){
			if(shurikens.get(x).getY() < -GameObjects.shurikenHeight){
				removeShuriken(shurikens.get(x));
			}else{
				shurikens.get(x).updateVariables();
			}
		}
		
		for(int x=0 ; x<superNovas.size() ; x++){
			if(superNovas.get(x).getY() < -GameObjects.superNovaHeight){
				removeSuperNova(superNovas.get(x));
			}else if(superNovas.get(x).getWidth() > 250){
				removeSuperNova(superNovas.get(x));
			}else{
				superNovas.get(x).updateVariables();
			}
		}
		
		for(int x=0 ; x<lasers.size() ; x++){
			if(lasers.get(x).getLength()<=0){
				removeLaser(lasers.get(x));
			}else{
				lasers.get(x).updateVariables();
			}
		}
	}
	
	public void draw(Graphics graphics){
		
		for(int x=0 ; x<shurikens.size() ; x++){
			shurikens.get(x).draw(graphics);;
		}
		
		for(int x=0 ; x<superNovas.size() ; x++){
			superNovas.get(x).draw(graphics);
		}
		
		for(int x=0 ; x<lasers.size() ; x++){
			lasers.get(x).draw(graphics);
		}
	}
	
	public void addShuriken(Shuriken shuriken){
		shurikens.add(shuriken);
	}
	
	public void addSuperNova(SuperNova superNova){
		superNovas.add(superNova);
	}
	
	public void addLaser(Laser laser){
		lasers.add(laser);
	}
	
	public void removeShuriken(Shuriken shuriken){
		shurikens.remove(shuriken);
	}
	
	public void removeSuperNova(SuperNova superNova){
		superNovas.remove(superNova);
	}
	
	public void removeLaser(Laser laser){
		lasers.remove(laser);
	}
	
	public void reset(){
		shurikens.clear();
		superNovas.clear();
		lasers.clear();
	}
	
	public ArrayList<Shuriken> getShurikenList(){
		return shurikens;
	}
	
	public ArrayList<SuperNova> getSuperNovaList(){
		return superNovas;
	}
	
	public ArrayList<Laser> getLaserList(){
		return lasers;
	}
}