package basic.algorithms;

import java.util.*;

public class BinarySearch {
	
	public static void main(String[] args) {
		
		List<Integer> array = new ArrayList<>();
		
		System.out.println("Enter the elements");
		Scanner stdin = new Scanner(System.in);
		String s = stdin.nextLine();
		
		for(int i = 0; i < s.split(" ").length; i++) {
			array.add(Integer.parseInt(s.split(" ")[i]));
		}
		
		System.out.println("Enter the key to be searched");
		int key = stdin.nextInt();
		stdin.close();
		
		BinarySearch bin = new BinarySearch();
		Result r = bin.binarySearch(array, key);
		
		if(r.resultStatement == ResultStatement.NOT_FOUND) {
			System.out.println(r.resultStatement.getResultStatement());
		} else {
			System.out.println(r.resultStatement.getResultStatement() + " at " + r.position + " after iteration number " + r.numberOfIterations);
		}
	}
	
	protected Result binarySearch(List<Integer> inputArray, long key) {
		int end = inputArray.size() - 1;
		int start = 0;
		inputArray.sort(null);		
		
		int currentIndex = (start + end) / 2;
		int iterations = 0;
		
		System.out.println(currentIndex);
		System.out.println(end + " " + start);
		
		while(start <= end) {
			
			iterations++;
			int currentValue = inputArray.get(currentIndex);
			
			System.out.println(iterations + " " + currentIndex + " " + currentValue + " " + end + " " + start);
			
			if(currentValue == key) {
				return new Result(currentIndex, iterations, ResultStatement.FOUND);
			} else if(key < currentValue) {
				end = currentIndex - 1;
			} else {
				start = currentIndex + 1;
			}
			currentIndex = (start + end) / 2;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		return new Result(ResultStatement.NOT_FOUND);
	}
	
	class Result {
		
		ResultStatement resultStatement;
		int position;
		int numberOfIterations;
		
		Result(int position, int numberOfIterations, ResultStatement resultStatement) {
			this.resultStatement = resultStatement;
			this.position = position;
			this.numberOfIterations = numberOfIterations;
		}
		
		Result(ResultStatement resultStatement) {
			this.position = -1;
			this.numberOfIterations = -1;
			this.resultStatement = resultStatement;
		}
	}
	
	enum ResultStatement {
		FOUND("Element has been found"),
		NOT_FOUND("Element not found");
		
		private final String s;
		private ResultStatement(String s) {
			this.s = s;
		}
		
		protected String getResultStatement() {
			return s;
		}
	}
}
