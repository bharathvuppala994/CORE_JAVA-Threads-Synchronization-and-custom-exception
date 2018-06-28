package com.siri.thread;

public class Tester {

	public static void main(String[] args) {

		// Creating two threads

		Thread hare = new Thread(new Race(), "hare");
		Thread tortoise = new Thread(new Race(), "tortoise");

		// Starting two threads

		hare.start();
		tortoise.start();

	}

}