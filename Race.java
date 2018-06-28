package com.siri.thread;

public class Race implements Runnable {
	private String exceptionMessage;
	Myexception bharath = new Myexception();

	public void Myexception(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
		printException(exceptionMessage);
	}

	public void printException(String execptionMessage) {
		System.out.println("This is My Exception " + exceptionMessage);
	}

	public void run() {
		try {
			runningrace();
		} catch (Myexception | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void runningrace() throws Myexception, InterruptedException {

		// Hare running from distance "1" to "5"

		if (Thread.currentThread().getName().equalsIgnoreCase("hare")) {
			try {
				for (int distance = 1; distance <= 5; distance++)
					System.out.println(Thread.currentThread().getName() + " is at " + distance);

			} finally {
				System.out.println("hare slept");
			}

			try {

				// Hare slept for 5 secs

				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				System.out.println("hare interrupted");
			}

			// Hare started running again from "6" to "10" and sleeps for every km

			for (int distance = 6; distance <= 10; distance++) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " is at " + distance);
			}

		} else

			// Tortoise running from "1" to "10" without a break

			for (int distancet = 1; distancet <= 10; distancet++) {
				System.out.println(Thread.currentThread().getName() + " is at " + distancet);

			}
		System.out.println("Winner of the Race is :" + Thread.currentThread().getName());

		// Tortoise won the Race

	}
}
