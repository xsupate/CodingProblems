package pg.com.java.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackerPoliceRace {
	public static final int MAX_PASSWORD = 2999;

	public static void main(String[] args) {
		 Random random = new Random();

	        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

	        List<Thread> threads = new ArrayList<>();

	        threads.add(new AscendingHackerThread(vault));
	        threads.add(new DescendingHackerThread(vault));
	        threads.add(new PoliceThread());

	        for (Thread thread : threads) {
	            thread.start();
	        }

	}

	private static class Vault {
		private int password;

		public Vault(int pwd) {
			this.password = pwd;
		}

		public boolean isPasswordGuessed(int guess) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
			return this.password == guess;
		}
	}

	private static abstract class HackerThread extends Thread {
		protected Vault vault;

		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}

		@Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
	}

	private static class AscendingHackerThread extends HackerThread {

		public AscendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int guess = 1; guess < MAX_PASSWORD; guess++) {
				if (this.vault.isPasswordGuessed(guess)) {
					System.out.println(this.getName() + " guessed the password " + guess);
					System.exit(0);
				}
			}
		}
	}

	private static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int guess = MAX_PASSWORD; guess > 0; guess--) {
				if (this.vault.isPasswordGuessed(guess)) {
					System.out.println(this.getName() + " guessed the password " + guess);
					System.exit(0);
				}
			}
		}
	}
	
	private static class PoliceThread extends Thread{
		
		@Override
		public void run() {
			for(int countDown = 10; countDown > 0; countDown--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(countDown);
			}
			
			System.out.println("Game over for you hackers");
            System.exit(0);
		}
	}
}
