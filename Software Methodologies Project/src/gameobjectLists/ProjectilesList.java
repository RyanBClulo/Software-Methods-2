package gameobjectLists;

import java.awt.Graphics;
import java.util.LinkedList;

import gameobjects.Projectile;

public class ProjectilesList {
	
	private LinkedList<Projectile> projectileList = new LinkedList<Projectile>();
	
	public void updateVariables(){
		for( int i=0 ; i<projectileList.size() ; i++ ){
			if(projectileList.get(i)!=null){
				if(projectileList.get(i).getY()<-10)
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