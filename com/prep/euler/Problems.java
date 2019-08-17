package com.prep.euler;

import java.util.ArrayList;
import java.util.List;

public class Problems {

	public static void main(String[] args) {
//		System.out.println(multiplesOf3And5(1000));
//		System.out.println(fib(5));
//		System.out.println(evenFibSum(4000000));
//		List<Integer> factors = getFactors(20);
//		factors.stream().forEach(factor -> System.out.println(factor));
		System.out.println(getSmallestMultipleBetween(1, 20));
	}
	
	public static int getSmallestMultipleBetween(int start, int end) {
		int multiple = start;
		for (int i = start + 1; i <= end; i++) {
			multiple = getLCM(multiple, i);
		}
		return multiple;
	}
	
	public static int getLCM(int a, int b) {
		if (a == b) {
			return a;
		}
	
		int smaller = a < b ? a : b;
		int larger = a < b ? b : a;
		if (larger % smaller == 0) {
			return larger;
		}
		
		int factor = larger;
		while (factor % smaller != 0) {
			factor += larger;
		}
		
		return factor;
	}
	
	public static int largestPalindromeNumber() {
		int maxProduct = 0;
		for (int num1 = 999; num1 >= 100; num1--) {
			for (int num2 = 999; num2 >= 100; num2--) {
				int product = num1 * num2;
				if (isPalindrome(product) && product > maxProduct) {
					maxProduct = product;
				}
			}
		}
		return maxProduct;
	}
	
	public static boolean isPalindrome(int n) {
		List<Integer> digits = new ArrayList<>();
		int factor = 10;
		while (n > 0) {
			digits.add(n % factor);
			n /= factor;
		}
		int start = 0;
		int end = digits.size() - 1;
		while (start <= end) {
			if (digits.get(start) != digits.get(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static long largestPrimeFactor(long n) {
		List<Long> factors = getFactors(n);
		return getMaxPrime(factors);
	}
	
	private static long getMaxPrime(List<Long> nums) {
		long max = 0;
		for (Long num : nums) {
			if (max < num && isPrime(num)) {
				max = num;
			}
		}
		return max;
	}
	
	public static List<Long> getFactors(long n) {
		List<Long> factors = new ArrayList<>();
		factors.add(1L);
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				factors.add(i);
				factors.add(n / i);
			}
		}
		return factors;
	}
	
	public static boolean isPrime(long n) {
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
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
