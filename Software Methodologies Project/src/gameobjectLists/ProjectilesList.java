package gameobjectLists;

import java.awt.Graphics;
import java.util.LinkedList;

import gameobjects.Projectile;
import main.MainWindow;

public class ProjectilesList {
	
	private MainWindow game;
	private LinkedList<Projectile> projectileList = new LinkedList<Projectile>();
	
	public ProjectilesList(MainWindow game){
		this.game=game;
	}
	
	public void updateVariables(){
		for( int i=0 ; i<projectileList.size() ; i++ ){
			if(projectileList.get(i)!=null){
				if(projectileList.get(i).getY()<-10 || projectileList.get(i).getY() > game.getHeight())
					removeProjectile(projectileList.get(i));
				else
					projectileList.get(i).updateVariables();
			}
		}
	}
	
	public void draw(Graphics g){
		for( int i=0 ; i<projectileList.size() ; i++ ){
			projectileList.get(i).draw(g);
		}
	}
	
	public void reset(){
		projectileList.clear();
	}
	
	public void addProjectile(Projectile projectile){
		projectileList.add(projectile);
	}
	
	public void removeProjectile(Projectile projectile){
		projectileList.remove(projectile);
	}
	
	public LinkedList<Projectile> getBulletList(){
		return projectileList;
	}
}