package org.example;

public class SampleThread extends Thread{
	
	@Override
	public void run(){
		System.out.println(getName() + "got launched Successflly !!!");
	}
	
}
