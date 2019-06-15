
public class Philosopher extends Thread{
	
	private int id;
	private DiningPhilosophers dp;
	private int eatingTime = 0;
	
	Philosopher(int i, DiningPhilosophers dPhils){
		id = i;
		dp = dPhils;
	}
	
	public void setNumOfEating(int n) {
		eatingTime = n;
	}
	
	public void run(){
		for(int i=0; i<eatingTime; i++) {
			dp.takeChopsticks(id);
			SleepUtilities.eat(id);
			dp.returnChopsticks(id);
		}
	}

}
