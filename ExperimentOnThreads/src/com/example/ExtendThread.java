package com.example;

public class ExtendThread extends Thread {

	public static void main(String[] args) {
		ExtendThread extendThread = new ExtendThread();
		extendThread.setName("New Thread");
		extendThread.start();
		System.out.println(Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
