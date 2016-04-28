package score;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	private static int currentScore=-25;
	private static Font font = new Font("SansSerif", Font.BOLD, 24);

	public static void drawScore(Graphics g){
		String scoreString="Score: "+getCurrentScore();
		String accuracyString="Accuracy: "+(int)(Statistics.getAccuracy()*100)+"%";
		g.setColor(Color.MAGENTA);
		g.setFont(font); 
		g.drawString(scoreString, 400-scoreString.length()*5, 30);
		g.drawString(accuracyString, 365-scoreString.length()*3, 50);
	}
	
	public static void addScore(int ammount){
		setCurrentScore(getCurrentScore() + ammount);
	}
	public static void hitScore(){
		if(Statistics.getHits()==0)setCurrentScore(getCurrentScore() + 5);
		else setCurrentScore((int)(getCurrentScore() + Math.round(10*Statistics.getAccuracy())));
	}
	public static void resetScores(){
		setCurrentScore(-25);
		Statistics.resetStats();
	}

	public static int getCurrentScore() {
		return currentScore;
	}

	public static void setCurrentScore(int currentScore) {
		Score.currentScore = currentScore;
	}

}
