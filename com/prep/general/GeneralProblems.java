package com.prep.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneralProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Country> countries = new ArrayList<>();
		Country a = new Country(20, "continent");
		Country b = new Country(74, "continent");
		Country c = new Country(730, "continent2");
		countries.add(a);
		countries.add(b);
		countries.add(c);
		System.out.println(getPopulation(countries, "continent"));
		System.out.println();
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(4);
		List<Integer> subset = getRandomSubset(list);
		for (Integer num : subset) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		int[] test = new int[] {0, 5, 3, 7, 2, 1, 1, 2, 7, 3, 3};
		int[] sorted = countSort(test, 0, 7);
		System.out.println("Sorted array: " + Arrays.toString(sorted));
	}

	private static int getPopulation(List<Country> countries, String continent) {
//		List<Country> matched = countries.stream()
//				.filter(country -> country.continent.contentEquals(continent))
//				.collect(Collectors.toList());
		int population = countries.stream().filter(country -> country.continent.contentEquals(continent)).map(country -> country.population).reduce((Integer c1, Integer c2) -> c1 + c2).get();
		return population;
	}
	
	private static List<Integer> getRandomSubset(List<Integer> list) {
		Random random = new Random();
		List<Integer> chosen = list.stream().map(num -> random.nextInt(2)).collect(Collectors.toList());
		List<Integer> subset = list.stream().filter(num -> chosen.stream().anyMatch(chose -> chose == 1)).collect(Collectors.toList());
		return subset;
	}
	
	// use counting sort to sort an array of integers with numbers 
	// in a range from low to high
	private static int[] countSort(int[] arr, int low, int high) {
		int[] count = new int[high - low + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		int sum = 0;
		for (int i = 0; i < count.length; i++) {
			int temp = count[i];
			sum += temp;
			count[i] = sum;
		}
		
		int prev = count[0];
		for (int i = 1; i < count.length; i++) {
			int temp = count[i];
			count[i] = prev;
			prev = temp;
		}
		
		int[] sorted = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int index = count[arr[i]];
			sorted[index] = arr[i];
			count[arr[i]] += 1;
		}
		return sorted;
	}
}
