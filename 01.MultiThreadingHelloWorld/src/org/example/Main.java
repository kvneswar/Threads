package org.example;

public class Main {

	public static void main(String[] args) {
		SampleThread sampleThread1 = new SampleThread();
		sampleThread1.start();
		
		SampleThread sampleThread2 = new SampleThread();
		sampleThread2.start();
		
		Thread sampleThread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("New Thread got launched successfully !!!");
			}
		});
		sampleThread3.start();
	}

}
