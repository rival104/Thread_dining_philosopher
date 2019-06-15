
public class Assignment2 {
	public static void main(String[] args) {
		
		int totalPhilosophers = 5;
		DiningPhilosophers dp = new DiningPhilosophers();
		Philosopher ph[] = new Philosopher[totalPhilosophers];

		for(int i=0; i<totalPhilosophers; i++) {
			ph[i] = new Philosopher(i, dp);
			ph[i].setNumOfEating(3);
		}
		for(int i=0; i<totalPhilosophers; i++) {
			ph[i].start();
		}
	}
}
