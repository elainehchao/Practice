package com.prep.Recursion.coins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {

	public static void main(String[] args) {
//		List<List<Integer>> results = new ArrayList<>();
		int[] coinTypes = new int[]{25, 10, 5};
		long startTime1 = System.nanoTime();
		int results = makeChange(70, coinTypes, 0);
		long endTime1 = System.nanoTime();
		long duration1 = (endTime1 - startTime1);  //divide by 1000000 to get milliseconds.
		System.out.println(results);
		System.out.println("Non memoized took " + duration1 + "ms");
		
		long startTime2 = System.nanoTime();
		int results2 = makeChangeMemoize(70, coinTypes, 0, new HashMap<>());
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);  //divide by 1000000 to get milliseconds.
		System.out.println(results2);
		System.out.println("Memoized took " + duration2 + "ms");

//		long startTime1 = System.nanoTime();
//		coins(coinTypes, results, 30, null, 25);
//		long endTime1 = System.nanoTime();
//
//		long duration1 = (endTime1 - startTime1);  //divide by 1000000 to get milliseconds.
//
//		for (List<Integer> combo : results) {
//			System.out.println("Combo:");
//			for (Integer coin : combo) {
//				System.out.print(coin + ", ");
//			}
//			System.out.println();
//		}
//		System.out.println("Method took: " + duration1 + "ms");
//		
//		System.out.println();
//		System.out.println("MEMOIZEDDD");
//		long startTime2 = System.nanoTime();
//		List<List<Integer>> results2 = coinsMemoize(coinTypes, 30, 25, new HashMap<>());
//		long endTime2 = System.nanoTime();
//		long duration2 = (endTime2 - startTime2);
//		for (List<Integer> combo : results2) {
//			System.out.println("Combo:");
//			for (Integer coin : combo) {
//				System.out.print(coin + ", ");
//			}
//			System.out.println();
//		}
//		System.out.println("Method took: " + duration2 + "ms");
	}
	
	public static void coins(int[] coinTypes, List<List<Integer>> results, int target, List<Integer> current, int largestCoin) {
		if (target == 0) {
			List<Integer> result = new ArrayList<>();
			result.addAll(current);
			results.add(result);
		}
		
		if (current == null) {
			current = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < coinTypes.length; i++) {
			int coin = coinTypes[i];
			if (coin > largestCoin) {
				continue;
			}
			if (target >= coin) {
				current.add(coin);
				coins(coinTypes, results, target - coin, current, coin);
				current.remove(current.size() - 1);
			}
		}
	}
	
	public static List<List<Integer>> coinsMemoize(int[] coinTypes, int target, int largestCoin, 
			Map<Integer, List<List<Integer>>> cache) {
		List<List<Integer>> allResults = new ArrayList<>();
		if (target == 0) {
			return allResults;
		}

		if (target == 1) {
			List<Integer> result = new ArrayList<>();
			result.add(1);
			allResults.add(result);
			return allResults;
		}
		
		if (cache.get(target) != null) {
			return cache.get(target);
		}
		
		List<List<Integer>> tempResults;
		for (int i = 0; i < coinTypes.length; i++) {
			int coin = coinTypes[i];
			if (coin > largestCoin) {
				continue;
			}
			if (target >= coin) {
				tempResults = coinsMemoize(coinTypes, target - coin, coin, cache);
				tempResults.stream().forEach(result -> {
					List<Integer> r = new ArrayList<>();
					r.add(coin);
					r.addAll(result);
					allResults.add(r);
				});
			}
		}
		cache.put(target, new ArrayList<>(allResults));
		return allResults;
	}
	
//	public static int makeChange(int amount, int[] denoms, int index) {
//		if (index >= denoms.length - 1) {
//			return 1;
//		}
//		int denomAmount = denoms[index];
//		int ways = 0;
//		for (int i = 0; i*denomAmount <= amount; i++) {
//			int amountRemaining = amount - i * denomAmount;
//			ways += makeChange(amountRemaining, denoms, index+1);
//		}
//		return ways;
//	}
	
	public static int makeChange(int amount, int[] denoms, int index) {
		if (amount == 0) {
			return 1;
		}
		
		if (amount < 0) {
			return 0;
		}
		int ways = 0;
		for (int i = index; i < denoms.length; i++) {
			int coin = denoms[i];
			
			if (amount >= coin) {
				ways += makeChange(amount - coin, denoms, i);
			}
		}
		return ways;
	}

	public static int makeChangeMemoize(int amount, int[] denoms, int index, Map<Integer, Integer> cache) {
		if (amount == 0) {
			return 1;
		}
		
		if (amount < 0) {
			return 0;
		}
		
		if (cache.get(amount) != null) {
			return cache.get(amount);
		}
		
		int ways = 0;
		for (int i = index; i < denoms.length; i++) {
			int coin = denoms[i];
			
			if (amount >= coin) {
				ways += makeChange(amount - coin, denoms, i);
			}
		}
		cache.put(amount, ways);
		return ways;
	}
}
