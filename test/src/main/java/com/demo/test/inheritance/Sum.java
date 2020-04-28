package com.demo.test.inheritance;

public class Sum {
	
	protected int a;
	protected int b;
	protected int s;
	
	
	public Sum() {
		a=5;
		b=6;
		s = this.call();
		
	}
	
	protected int call() {
		return a-b;
		
	}
	
	public int getSum() {
		return s;
		
	}
	

}
