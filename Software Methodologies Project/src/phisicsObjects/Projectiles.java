package phisicsObjects;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Projectiles {
	
	private ArrayList<Projectile> projectileList = new ArrayList<Projectile>();
	
	public Projectiles(){
		
	}
	
	public void updateVariables(){
		for( int i=0 ; i<projectileList.size() ; i++ ){
			if(projectileList.get(i)!=null){
				
				if(projectileList.get(i).currentLocation().getY()<-10)
					removeProjectile(projectileList.get(i));
				else
					projectileList.get(i).updateVariables();
			}
		}
	}
	
	public void draw(Graphics2D g){
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
}