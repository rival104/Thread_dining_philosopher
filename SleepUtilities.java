class SleepUtilities {
	private static final int NAP_TIME = 5;

	// Nap between zero and NAP_TIME seconds.
	public static void eat(int i) {
		System.out.println("Philosopher "+i+" is eating.");
		nap(NAP_TIME);
	}

	// Nap between zero and duration seconds.
	public static void nap(int duration) {
		int sleeptime = (int) (duration * Math.random());
		try {
			Thread.sleep(sleeptime * 1000);
		} catch (InterruptedException e) {
		}
	}
}