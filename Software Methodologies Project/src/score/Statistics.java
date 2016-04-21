package score;

public class Statistics {
	private static double accuracy=1;
	private static int hits=0;
	private static int shots=0;
	
	public static void updateAccuracy(){
		if (shots==0)
			setAccuracy(1);
		else
		setAccuracy(((double)hits)/shots);
	}

	public static double getAccuracy() {
		return accuracy;
	}

	public static void setAccuracy(double accuracy) {
		Statistics.accuracy = accuracy;
	}

	public static void addhit() {
		// TODO Auto-generated method stub
		hits++;
	}

	public static void addShot() {
		// TODO Auto-generated method stub
		shots++;
	}
}
