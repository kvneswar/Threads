package com.example;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumer {

	private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) throws InterruptedException {
		final ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producerAndConsumer.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producerAndConsumer.consumer();
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

	private void producer() throws InterruptedException{
		Random random = new Random();
		while(true){
			blockingQueue.put(random.nextInt(100));
		}
	}


	private void consumer() throws InterruptedException{
		Random random = new Random();
		while(true){
			Integer integer = blockingQueue.take();
			System.out.println(integer);
		}
			
	}


}
