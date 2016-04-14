package gameobjects;

import java.util.LinkedList;
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
		
	public static void createFormation(int formation,MainWindow game,LinkedList<Enemy> enemy){
		formations(game,formation,enemy);
	}
	public static void createFormation(MainWindow game,LinkedList<Enemy> enemy){
		Random rnd =new Random();
		formations(game,rnd.nextInt(formationCount()),enemy);
	}
	private static void formations(MainWindow game,int formation,LinkedList<Enemy> enemy){
		switch (formation){
		case LINE: //done
			for(int x=0 ; x<8 ; x++){
				enemy.add(new Enemy(game,130+70*x,-350,1));
			}
			break;
		case DIAMOND: //done
			enemy.add(new Enemy(game,250,-200,1));
			enemy.add(new Enemy(game,375,-300,1));
			enemy.add(new Enemy(game,375,-100,1));
			enemy.add(new Enemy(game,500,-200,1));
			break;
		case W: //done
			enemy.add(new Enemy(game,135,-260,1));
			enemy.add(new Enemy(game,215,180-400,1));
			enemy.add(new Enemy(game,295,220-400,1));
			enemy.add(new Enemy(game,375,180-400,1));
			enemy.add(new Enemy(game,455,220-400,1));
			enemy.add(new Enemy(game,535,180-400,1));
			enemy.add(new Enemy(game,615,140-400,1));
			break;
		case SQUARES2: //done
			enemy.add(new Enemy(game,125,150-400,1));
			enemy.add(new Enemy(game,125,275-400,1));
			enemy.add(new Enemy(game,250,150-400,1));
			enemy.add(new Enemy(game,250,275-400,1));
			enemy.add(new Enemy(game,500,150-400,1));
			enemy.add(new Enemy(game,500,275-400,1));
			enemy.add(new Enemy(game,625,150-400,1));
			enemy.add(new Enemy(game,625,275-400,1));
			break;
		case RING: //done
			enemy.add(new Enemy(game,475,200-400,1));
			enemy.add(new Enemy(game,462,150-400,1));
			enemy.add(new Enemy(game,425,113-400,1));
			enemy.add(new Enemy(game,375,100-400,1));
			enemy.add(new Enemy(game,325,113-400,1));
			enemy.add(new Enemy(game,288,150-400,1));
			enemy.add(new Enemy(game,275,200-400,1));
			enemy.add(new Enemy(game,288,250-400,1));
			enemy.add(new Enemy(game,325,287-400,1));
			enemy.add(new Enemy(game,375,300-400,1));
			enemy.add(new Enemy(game,462,250-400,1));
			enemy.add(new Enemy(game,425,287-400,1));
			break;
		}			
	}
}