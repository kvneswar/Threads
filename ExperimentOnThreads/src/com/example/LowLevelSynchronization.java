package com.example;

import java.util.LinkedList;
import java.util.Random;

public class LowLevelSynchronization {

	public static void main(String[] args) throws InterruptedException {

		final LowLevelSynchronization lowLevelSynchronization = new LowLevelSynchronization();

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lowLevelSynchronization.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lowLevelSynchronization.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

	}

	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	final int LIMIT = 10;
	Object object = new Object();

	public void producer() throws InterruptedException{
		int value=0;
		while(true){
			synchronized (object) {
				while (linkedList.size() == LIMIT) {
					object.wait();
				}
				linkedList.add(value++);
			}
		}
	}

	public void consumer() throws InterruptedException{
		while(true){
			synchronized (object) {
			
				System.out.print("List size is: "+ linkedList.size());
				int value = linkedList.removeFirst();
				System.out.println("; Value: "+value);
				object.notify();
			}
			
			Thread.sleep(new Random().nextInt(1000));
		}
	}

}
