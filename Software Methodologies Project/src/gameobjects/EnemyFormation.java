package gameobjects;

import java.util.ArrayList;
import java.util.Random;

import main.MainWindow;

public class EnemyFormation {
	
	//start formations
	public static final int LINE=0;
	public static final int DIAMOND=1;
	public static final int W=2;
	public static final int SQUARES2=3;
	public static final int RING=4;
	public static final int formationCount(){return 5;}
		
	public static void createFormation(int formation,MainWindow game,ArrayList<Enemy> enemy){
		formations(game,formation,enemy);
	}
	public static void createFormation(MainWindow game,ArrayList<Enemy> enemy){
		Random rnd =new Random();
		formations(game,rnd.nextInt(formationCount()),enemy);
	}
	private static void formations(MainWindow game,int formation,ArrayList<Enemy> enemy){
		switch (formation){
		case LINE: //done
			for(int x=0 ; x<8 ; x++){
				enemy.add(new Enemy(game,130+70*x,50,1));
			}
			break;
		case DIAMOND: //done
			enemy.add(new Enemy(game,250,200,1));
			enemy.add(new Enemy(game,375,100,1));
			enemy.add(new Enemy(game,375,300,1));
			enemy.add(new Enemy(game,500,200,1));
			break;
		case W:
			enemy.add(new Enemy(game,100,140,1));
			enemy.add(new Enemy(game,200,180,1));
			enemy.add(new Enemy(game,300,220,1));
			enemy.add(new Enemy(game,400,180,1));
			enemy.add(new Enemy(game,500,220,1));
			enemy.add(new Enemy(game,600,180,1));
			enemy.add(new Enemy(game,700,140,1));
			break;
		case SQUARES2:
			enemy.add(new Enemy(game,100,150,1));
			enemy.add(new Enemy(game,100,275,1));
			enemy.add(new Enemy(game,275,150,1));
			enemy.add(new Enemy(game,275,275,1));
			enemy.add(new Enemy(game,525,150,1));
			enemy.add(new Enemy(game,525,275,1));
			enemy.add(new Enemy(game,700,150,1));
			enemy.add(new Enemy(game,700,275,1));
			break;
		case RING:
			enemy.add(new Enemy(game,500,200,1));
			enemy.add(new Enemy(game,487,150,1));
			enemy.add(new Enemy(game,450,113,1));
			enemy.add(new Enemy(game,400,100,1));
			enemy.add(new Enemy(game,350,113,1));
			enemy.add(new Enemy(game,313,150,1));
			enemy.add(new Enemy(game,300,200,1));
			enemy.add(new Enemy(game,313,250,1));
			enemy.add(new Enemy(game,350,287,1));
			enemy.add(new Enemy(game,400,300,1));
			enemy.add(new Enemy(game,487,250,1));
			enemy.add(new Enemy(game,450,287,1));
			break;
		}			
	}
}