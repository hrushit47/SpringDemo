package com.junitproject;

public class MyMath {
	int sum=0;
	int sum(int[] numbers) {
		for (int i : numbers) {
			sum+=i;
		}
		return sum;
	}

}
