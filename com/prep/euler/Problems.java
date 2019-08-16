package com.prep.euler;

public class Problems {

	public static void main(String[] args) {
//		System.out.println(multiplesOf3And5(1000));
//		System.out.println(fib(5));
		System.out.println(evenFibSum(4000000));
	}
	
	public static int multiplesOf3And5(int n) {
		if (n < 3) {
			return 0;
		}
		
		if (n < 5) {
			return 3;
		}
		int sum = 0;
		int multiple = 3;
		while (multiple < n) {
			sum += multiple;
			multiple += 3;
		}
		
		multiple = 5;
		while (multiple < n) {
			if (multiple % 3 != 0) {
				sum += multiple;
			}
			multiple += 5;
		}
		return sum;
	}
	
	public static int fib(int num) {
		if (num <= 1) {
			return 1;
		}
		
		if (num == 2) {
			return 2;
		}
		return fib(num - 1) + fib(num - 2);
	}

	public static int evenFibSum(int max) {
		int first = 1;
		int second = 2;
		int sum = 2;
		int next = first + second;
		while (next < max) {
			if (next % 2 == 0) {
				sum += next;
			}
			next = first + second;
			first = second;
			second = next;
		}
		return sum;
	}
}
