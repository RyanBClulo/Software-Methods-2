package score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScore {
	private static int ship1Easy;
	private static int ship1Medium;
	private static int ship1Hard;
	private static int ship2Easy;
	private static int ship2Medium;
	private static int ship2Hard;
	

	public static void readScores() throws FileNotFoundException{
		@SuppressWarnings("resource")
		Scanner inputScores =new Scanner(new File("HighScores.txt"));
		ship1Easy=inputScores.nextInt();
		ship1Medium=inputScores.nextInt();
		ship1Hard=inputScores.nextInt();
		ship2Easy=inputScores.nextInt();
		ship2Medium=inputScores.nextInt();
		ship2Hard=inputScores.nextInt();
	}
	public static void writeScores() throws FileNotFoundException{
		PrintWriter outFile =new PrintWriter("HighScores.txt"); 
		outFile.println(ship1Easy);
		outFile.println(ship1Medium);
		outFile.println(ship1Hard);
		outFile.println(ship2Easy);
		outFile.println(ship2Medium);
		outFile.println(ship2Hard);
		outFile.close();
	}
	public static void updateHighScores(){
		
	}
}















