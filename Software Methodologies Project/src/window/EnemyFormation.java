package window;

import java.awt.Point;
import java.util.Random;
import phisicsObjects.Enemy;

public class EnemyFormation {
	
	public final static int LINE=0;
	public final static int DIAMOND=1;
	public final static int W=2;
	public final static int SQUARES2=3;
	
	public static void createFormation(int formation){
		formations(formation);
	}
	public static void createFormation(){
		Random rnd =new Random();
		formations(rnd.nextInt(4));
	}
	private static void formations(int formation){
		switch (formation){
		case LINE:
			new Enemy(new Point(0,-25),new Point(100,200));
			new Enemy(new Point(100,-25),new Point(200,200));
			new Enemy(new Point(250,-25),new Point(300,200));
			new Enemy(new Point(400,-25),new Point(400,200));
			new Enemy(new Point(500,-25),new Point(500,200));
			new Enemy(new Point(650,-25),new Point(600,200));
			new Enemy(new Point(800,-25),new Point(700,200));
			break;
		case DIAMOND:
			new Enemy(new Point(300,-25),new Point(300,200));
			new Enemy(new Point(400,-25),new Point(400,100));
			new Enemy(new Point(400,-25),new Point(400,300));
			new Enemy(new Point(500,-25),new Point(500,200));
			break;
		case W:
			new Enemy(new Point(100,-25),new Point(100,140));
			new Enemy(new Point(-25,180),new Point(200,180));
			new Enemy(new Point(300,-25),new Point(300,220));
			new Enemy(new Point(400,-25),new Point(400,180));
			new Enemy(new Point(500,-25),new Point(500,220));
			new Enemy(new Point(825,180),new Point(600,180));
			new Enemy(new Point(700,-25),new Point(700,140));
			break;
		case SQUARES2:
			new Enemy(new Point(100,-25),new Point(100,150));
			new Enemy(new Point(100,-25),new Point(100,275));
			new Enemy(new Point(275,-25),new Point(275,150));
			new Enemy(new Point(275,-25),new Point(275,275));
			new Enemy(new Point(525,-25),new Point(525,150));
			new Enemy(new Point(525,-25),new Point(525,275));
			new Enemy(new Point(700,-25),new Point(700,150));
			new Enemy(new Point(700,-25),new Point(700,275));
			break;
		}
	}
}
