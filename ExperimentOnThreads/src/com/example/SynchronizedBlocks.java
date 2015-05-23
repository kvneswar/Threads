package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * What is intrinsic lock ?
 * 
 * If we use synchronized on any method then a thread will acquire the lock on the class object. 
 * So no other threads will not be able access the other resources.
 * 
 * If we use synchronized block then it will acquire a lock on a specific object. So that other threads can access other resources.
 * 
*/


public class SynchronizedBlocks {
	
	Random random = new Random();
	Object object1 = new Object();
	Object object2 = new Object();
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	
	/*public synchronized void incrementList1() throws InterruptedException{
		Thread.sleep(1);
		list1.add(random.nextInt(1000));
	}
	
	public synchronized void incrementList2() throws InterruptedException{
		Thread.sleep(1);
		list2.add(random.nextInt(1000));
	}*/
	
	public void incrementList1() throws InterruptedException{
		synchronized (object1) {
			Thread.sleep(1);
			list1.add(random.nextInt(1000));
		}
	}
	
	public void incrementList2() throws InterruptedException{
		synchronized (object2) {
			Thread.sleep(1);
			list2.add(random.nextInt(1000));	
		}
		
	}
	
	public void performWork() throws InterruptedException{
		for(int i=0; i<1000;i++){
			incrementList1();
			incrementList2();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		final SynchronizedBlocks synchronizedBlocks = new SynchronizedBlocks();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					synchronizedBlocks.performWork();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronizedBlocks.performWork();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});	
		
		long currTime = System.currentTimeMillis();
		t1.start();
		t2.start();
		synchronizedBlocks.performWork();
		
		t1.join();
		t2.join();
		
		System.out.println(System.currentTimeMillis() - currTime);
		
	}

}
