import java.util.concurrent.locks.*;

public class DiningPhilosophers implements DiningServer {
	enum State {
		THINKING, HUNGRY, EATING
	};

	State[] states = new State[5];
	Condition[] self = new Condition[5];
	final Lock lock = new ReentrantLock();;

	public DiningPhilosophers() {
		for (int i = 0; i < 5; i++) {
			states[i] = State.THINKING;
			self[i] = lock.newCondition();
		}
	}

	public void takeChopsticks(int i) {
		lock.lock();
		try {
			states[i] = State.HUNGRY;
			test(i);
			if (states[i] != State.EATING) {
				print("Philosopher "+ i + " is thinking.");
				self[i].await();
			}
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}
	}

	public void returnChopsticks(int i) {
		lock.lock();
		try {
			print("Philosopher " + i + " released its left and right chopsticks.");
			states[i] = State.THINKING;
			// test left and right neighbors
			test((i + 4) % 5);
			test((i + 1) % 5);
		}finally {
			lock.unlock();
		}

	}

	private void test(int i) {
		if ((states[(i + 4) % 5] != State.EATING) && (states[i] == State.HUNGRY)
				&& (states[(i + 1) % 5] != State.EATING)) {
			states[i] = State.EATING;
			self[i].signal();
			print("Philosopher "+i+" acquired its left and right chopsticks.");
		}
	}
	
	private void print(Object o) {
		System.out.println(o);
	}
}
