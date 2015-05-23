package com.example;

import java.util.Scanner;

public class WaitAndNotify {

	public void Producer() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producer is running .....");
			wait(); // Wait must be inside of synchronized block 
			System.out.println("Resumed ...");
		}
	}
	
	public void Receiver() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for the return key ..");
			scanner.nextLine();
			System.out.println("Return key pressed ..");
			notify();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {

		final WaitAndNotify waitAndNotify = new WaitAndNotify();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					waitAndNotify.Producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					waitAndNotify.Receiver();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}

}
