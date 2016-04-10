package window;
/**
 * This is the main class for the SMP-X game.
 * 
 * @author Ryan Clulo
 * @author Blake Golliday
 * @author Alex Luczak
 * @author Charles Manchester
 * @author Eder Paz
 * @author Franco Reda
 * 
 */
public class GameLauncher {
	
	public static int gameWidth		= 800;
	public static int gameHeight	= 950;
	
	public static void main(String[] args){
		MainWindow game = new MainWindow("SMP-eXtreme",gameWidth,gameHeight);
		game.start();
	}
}