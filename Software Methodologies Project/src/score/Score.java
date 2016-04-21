package score;

import graphics.Images;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {
	private static int currentScore=0;
	
	public static void readScores() throws FileNotFoundException{
		@SuppressWarnings("resource")
		Scanner inputScores =new Scanner(new File("scores.txt"));
	}
	public static void drawScore(Graphics g){
		String scoreString="Score: "+currentScore;
		g.setColor(Color.GREEN);
		g.setFont(new Font("Helvetica", Font.BOLD, 24)); 
		g.drawString(scoreString, 400-scoreString.length()*5, 30);
	}

}
