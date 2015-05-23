package com.example;

import java.util.Random;

public class InterruptingThreads {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Start");
		Thread thread = new Thread(new Runnable() {

			Random random = new Random();
			
			@Override
			public void run() {
				for(int i=0; i<1E8; i++){
					/*System.out.println(Thread.currentThread().isInterrupted());
					Math.sin(random.nextDouble());*/
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("Interrupted");
						break;
					}
				}
				
				
			}
		});
		thread.start();
		thread.sleep(500);
		thread.interrupt();
		thread.join();
		
		System.out.println("End");
	}

}
