package score;

public class Statistics {
	private static double accuracy=1;
	private static int hits=0;
	private static int shots=0;
	
	public static void updateAccuracy(){
		if (shots==0)
			setAccuracy(1);
		else
		setAccuracy(((double)getHits())/shots);
	}

	public static double getAccuracy() {
		return accuracy;
	}

	public static void setAccuracy(double accuracy) {
		Statistics.accuracy = accuracy;
	}

	public static void addhit() {
		// TODO Auto-generated method stub
		setHits(getHits() + 1);
	}

	public static void addShot() {
		// TODO Auto-generated method stub
		shots++;
	}

	public static int getHits() {
		return hits;
	}

	public static void setHits(int hits) {
		Statistics.hits = hits;
	}

	public static void resetStats() {
		// TODO Auto-generated method stub
		accuracy=1;
		hits=0;
		shots=0;
	}
}
