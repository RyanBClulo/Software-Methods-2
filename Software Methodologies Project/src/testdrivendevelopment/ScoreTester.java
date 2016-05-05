package testdrivendevelopment;

import static org.junit.Assert.*;

import org.junit.Test;

import score.Score;
import score.Statistics;

public class ScoreTester {

	@Test
	public void testAddScore() {
		Score.addScore(25);
		assertEquals(Score.getCurrentScore(),0);
	}
	@Test
	public void testReset(){
		Score.resetScores();
		assertEquals(Score.getCurrentScore(),-25);
	}
	@Test
	public void testStats(){
		Statistics.addhit();
		Statistics.addShot();
		assertEquals((int)Statistics.getAccuracy(),1);
		assertEquals(Statistics.getHits(),1);
		Statistics.resetStats();
		assertEquals(Statistics.getHits(),0);
	}

}
