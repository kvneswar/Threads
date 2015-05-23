package com.example;

public class ImplementRunnable implements Runnable {

	public static void main(String[] args) {
		ImplementRunnable implementRunnable = new ImplementRunnable();
		Thread thread = new Thread(implementRunnable);
		thread.setName("New Runnable implemented Thread");
		thread.start();
		System.out.println(Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
