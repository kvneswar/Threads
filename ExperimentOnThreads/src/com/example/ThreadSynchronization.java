package com.example;

import java.util.Scanner;

/*
 * Multiple threads can access same variable. Based on the value, 
 * it will impact the behavior of the other thread.
 * 
 * What is volatile.
*/

public class ThreadSynchronization extends Thread{

	public boolean isRunning = true;
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Press return to Start");
		scanner.nextLine();
		ThreadSynchronization newThread = new ThreadSynchronization();
		newThread.start();
		System.out.println("Press return to Stop");
		scanner.nextLine();
		newThread.isRunning = false;
	}

	@Override
	public void run() {
		while(isRunning){
			System.out.println("Yes, it is running");
		}
	}
}
