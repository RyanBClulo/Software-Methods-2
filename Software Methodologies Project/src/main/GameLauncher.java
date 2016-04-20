package main;

import main.MainWindow;

/**
 * This is the main class for the SMP-X game.
 * 
 * @author Ryan Clulo
 * @author Blake Golliday
 * @author Alex Luczak
 * @author Charles Manchester
 * @author Eder Paz
 * @author Franco Reda
 */
public class GameLauncher {
	
	public static void main(String[] args){
		MainWindow game = new MainWindow("SMP-eXtreme",800,950);
		game.start();
	}
}