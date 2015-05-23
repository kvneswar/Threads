package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{

	private int id;
	
	public Processor(int id){
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting id" + id);
		
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed id" + id);
	}
	
}


public class ThreadPool {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++){
			executorService.submit(new Processor(i));
		}
		executorService.shutdown();
	}

}
