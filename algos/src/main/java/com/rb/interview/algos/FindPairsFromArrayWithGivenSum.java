package com.rb.interview.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: Given an array and a sum value, find all possible pairs 
 * whose sum matches the given sum value. 
 * 
 * @author Rikki Bindra
 */

public class FindPairsFromArrayWithGivenSum {

	public static void main(String[] args) {
		
		Integer [] a = {-9,19,0,3,4,5,-1,7,8,1,2,0,8,9,10,11,12,13,14,15,16,-2,-3,-4,-5,-6};
		int sum = 10;
		findPairs(a, sum);
		findPairsO(a, sum);

	}
	/**
	 * Optimized Algo
	 * @param a
	 * @param sum
	 */
	public static void findPairsO(Integer [] a, int sum) {
		
		StringBuffer sbResult = new StringBuffer();
		sbResult.append("Algo 2 - Optimized Way\n");
		long startAt = System.currentTimeMillis();
		Map<Object, Integer> numberFreq = new HashMap<>();
		Set<Integer> set = new HashSet<>(Arrays.asList(a));
		for (Integer value : set) {
			Integer freq = numberFreq.get(value);
			numberFreq.put(value, (freq == null ? 1 : ++freq));
			int requiredNumber = sum - value;
			numberFreq.put("P_" + value, requiredNumber);
			Integer requiredNumberfreq = numberFreq.get(requiredNumber);
			numberFreq.put(requiredNumber, (requiredNumberfreq == null ? -1 : ++requiredNumberfreq));
		}
		for (Integer value : set) {
			
			Integer requiredNumber = numberFreq.get("P_" + value);
			int freqOfReqdNumber = numberFreq.get(requiredNumber);
			if (freqOfReqdNumber == 0) {
				sbResult.append(String.format("(%s,%s)\n", value, requiredNumber));
			}
		}
		long endAt = System.currentTimeMillis();
		long timeTaken = endAt - startAt;
		
		sbResult.append("Time taken by Algo 2 is " + timeTaken + " milliseconds.\n******");
		System.out.println(sbResult);
	}
	
	/**
	 * Not optimized way 
	 * @param a
	 * @param sum
	 */
	public static void findPairs(Integer [] a, int sum) {
		
		StringBuffer sbResult = new StringBuffer();
		sbResult.append("Algo 1 - Not Optimized Way\n");
		long startAt = System.currentTimeMillis();
		int actualSum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1 ; j < a.length; j++) {
				actualSum = a[i] + a[j];
				if (actualSum == sum) {
					sbResult.append(String.format("(%s,%s)\n", a[i], a[j]));
				}
			}
			
		}
		long endAt = System.currentTimeMillis();
		long timeTaken = endAt - startAt;
		sbResult.append("Time taken by Algo 1 is " + timeTaken + " milliseconds.\n******");
		System.out.println(sbResult);
	}

}
