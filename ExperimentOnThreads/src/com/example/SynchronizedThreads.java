package com.example;

public class SynchronizedThreads{

	private int count = 0;
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException{

		SynchronizedThreads synchronizedThreads = SynchronizedThreads.class.newInstance();
		synchronizedThreads.doWork();

	}

	public synchronized void increment(){
		count ++;
	}
	
	

	private void doWork() throws InterruptedException{

		Thread thread1 = new  Thread(new Runnable() {
			@Override
			public void run() {
				for(int counter=0; counter<10000; counter++){
					increment();
				}
			}
		});

		Thread thread2 = new  Thread(new Runnable() {
			@Override
			public void run() {
				for(int counter=0; counter<10000; counter++){
					increment();
				}
			}
		});

		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();

		System.out.println(count);
	}

}
