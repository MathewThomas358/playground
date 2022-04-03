package basic.algorithms;

import java.util.*;

import basic.algorithms.BinarySearch.Result;
import basic.algorithms.BinarySearch.ResultStatement;

public class BinarySearchWithRandomArray {
	
	private static final int MAX = 1024 * 1024 * 1024; 
	
	public static void main(String[] args) throws ExtremelyStupidException {
		
		Random random = new Random();
		List<Integer> array = new ArrayList<>();
		
		new BinarySearchWithRandomArray().randomArrayGenerator(array, 512*512, random);
		
		char choice = 'Y';
		try(Scanner stdin = new Scanner(System.in);) {
			
			while(choice == 'Y' || choice == 'y') {
				System.out.println("Enter the key to be searched");
				int key = stdin.nextInt();
						
				if(key > MAX) {
					throw new ExtremelyStupidException();
				}
				
				BinarySearch binarySearch = new BinarySearch();
				Result r = binarySearch.binarySearch(array, key);
				
				if(r.resultStatement == ResultStatement.NOT_FOUND) {
					System.out.println(r.resultStatement.getResultStatement());
				} else {
					System.out.println(r.resultStatement.getResultStatement() + " at " + r.position + " after iteration number " + r.numberOfIterations);
				}	
				System.out.println("Press Y to continue");
				stdin.nextLine();
				choice = stdin.nextLine().charAt(0);
			}
		}
	}
	
	static class ExtremelyStupidException extends Exception {
		
		private static final long serialVersionUID = 5745071243816519743L;

		ExtremelyStupidException() {
			System.out.println("This is an extremely stupid exception because your input is greater than " + MAX);
		}
	}
	
	public void randomArrayGenerator(List<Integer> array, int size, Random random) {
		for(int i = 0; i < size; i++) {
			array.add(random.nextInt(MAX));
		}
	}
	
	public void randomArrayGenerator(List<Integer> array, int size, Random random, int max) {
		for(int i = 0; i < size; i++) {
			array.add(random.nextInt(max));
		}
	}
}
