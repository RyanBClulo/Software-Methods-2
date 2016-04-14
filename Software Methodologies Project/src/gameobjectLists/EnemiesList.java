package gameobjectLists;

import java.awt.Graphics;
import java.util.LinkedList;

import gameobjects.Enemy;

public class EnemiesList {
	
	private LinkedList<Enemy> enemy1 = new LinkedList<Enemy>();
	
	public void updateVariables(){
		for(int x=0 ; x<enemy1.size() ; x++){
			if(enemy1.get(x)!=null){
				enemy1.get(x).updateVariables();
			}
		}
	}
	
	public void draw(Graphics graphics){
		for(int x=0 ; x<enemy1.size() ; x++){
			if(enemy1.get(x)!=null){
				enemy1.get(x).draw(graphics);
			}
		}
	}
	
	public void addEnemy1(Enemy enemy){
		enemy1.add(enemy);
	}
	
	public void removeEnemy1(Enemy enemy){
		enemy1.remove(enemy);
	}
	
	public LinkedList<Enemy> getEnemy1List(){
		return enemy1;
	}
}