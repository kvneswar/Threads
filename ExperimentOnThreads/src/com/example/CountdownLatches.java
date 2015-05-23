package com.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class CountProcessor implements Runnable{

	private CountDownLatch countDownLatch;
	
	public CountProcessor(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	
	
	@Override
	public void run() {
		System.out.println("Started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		countDownLatch.countDown();
	}
	
	
}


public class CountdownLatches {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countdownLatch = new CountDownLatch(2);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++){
			executorService.submit(new CountProcessor(countdownLatch));
		}
	
		countdownLatch.await();
		System.out.println(countdownLatch.getCount());
		System.out.println("Done");
	}

}
