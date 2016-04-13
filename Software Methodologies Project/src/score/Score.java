package score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {
	private static int currentScore=0;
	
	public static void readScores() throws FileNotFoundException{
		@SuppressWarnings("resource")
		Scanner inputScores =new Scanner(new File("scores.txt"));
	}
}