package window;

//This is a test comment Ryan saw the comment.

import java.awt.Point;
import java.util.Random;
import phisicsObjects.Enemy;

public class EnemyFormation {
	
	//start formations
	public static final int LINE=0;
	public static final int DIAMOND=1;
	public static final int W=2;
	public static final int SQUARES2=3;
	public static final int RING=4;
	public static final int formationCount(){return 5;}
		
	public static void createFormation(int formation){
		formations(formation);
	}
	public static void createFormation(){
		Random rnd =new Random();
		formations(rnd.nextInt(formationCount()));
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
		case RING:
			new Enemy(new Point(100,-25),new Point(500,200));
			new Enemy(new Point(100,-25),new Point(487,150));
			new Enemy(new Point(100,-25),new Point(450,113));
			new Enemy(new Point(100,-25),new Point(400,100));
			new Enemy(new Point(100,-25),new Point(350,113));
			new Enemy(new Point(100,-25),new Point(313,150));
			new Enemy(new Point(100,-25),new Point(300,200));
			new Enemy(new Point(100,-25),new Point(313,250));
			new Enemy(new Point(100,-25),new Point(350,287));
			new Enemy(new Point(100,-25),new Point(400,300));
			new Enemy(new Point(100,-25),new Point(487,250));
			new Enemy(new Point(100,-25),new Point(450,287));
			break;
		}			
	}

}
