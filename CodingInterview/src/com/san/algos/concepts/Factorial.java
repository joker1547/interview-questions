package com.san.algos.concepts;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Long>{

	public long factor ;
	public Factorial(long num){
		factor = num;
	}
	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		return factorial();
	}
	
	public Long factorial() throws InterruptedException{
		int index = 1;
		Long result = new Long(1);
		while(index <= factor){
			result = result * index;
			index++;
			Thread.sleep(1);
		}
		return result;
	}
}
