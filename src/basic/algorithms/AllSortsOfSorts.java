package basic.algorithms;

import java.util.*;
import basic.datastructures.*;
import basic.datastructures.BinarySearchTree.InvalidBinarySearchKeyTypeException;

public class AllSortsOfSorts implements AllSortsOfSortsApi {

	private static final Random RANDOM = new Random();
	
	public static void main(String[] args) {
		
		System.out.println("Initialized");
		
		AllSortsOfSorts sorter = new AllSortsOfSorts();
		
		List<Integer> array = new ArrayList<>();
		new BinarySearchWithRandomArray().randomArrayGenerator(array, Size.LARGE.getValue(), RANDOM, Max.LARGE.getValue()); 
		
		int[] integerArray = sorter.convertListToArray(array);
		
		long startTimeInNanos;
		long endTimeInNanos;
		int methodCount = 0;
		
		System.out.println("Starting AllSortsOfSorts");
		
		/**
		 * Tim Sort. 
		 * 
		 * Creating a reference array. Collections inbuilt sort() method uses
		 * TimSort.
		 */	
		List<Integer> arrayCopy = new ArrayList<>(array);
		startTimeInNanos = System.nanoTime();
		arrayCopy.sort(null);	
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, methodCount, true, "timSort");
		int[] tim = sorter.convertListToArray(arrayCopy);
				
		/**
		 * Merge Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] merge = sorter.mergeSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(merge, tim), "mergeSort");
		
		/**
		 * Quick Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] quick = sorter.quickSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(quick, tim), "quickSort");
		
		/**
		 * Heap Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] heap = sorter.heapSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(heap, tim), "heapSort");
				
		/**
		 * Counting Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] counting = sorter.countingSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(counting, tim), "countingSort");
		
		/**
		 * Radix Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] radix = sorter.radixSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(radix, tim), "radixSort");
		
		/**
		 * BinarySearchTree Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] bst = sorter.bstSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(bst, tim), "bstSort");
		
		/**
		 * Insertion Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] insertion = sorter.insertionSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(insertion, tim), "insertionSort");
		
		/**
		 * Selection Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] selection = sorter.selectionSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(selection, tim), "selectionSort");

		/**
		 * Bubble Sort
		 */
		startTimeInNanos = System.nanoTime();
		int[] bubble = sorter.bubbleSort(integerArray.clone());
		endTimeInNanos = System.nanoTime();
		sorter.timeTaken(startTimeInNanos, endTimeInNanos, ++methodCount, Arrays.equals(bubble, tim), "bubbleSort");

	}
	
	private int[] bstSort(int[] input) {
		
		BinarySearchTree bst = new BinarySearchTree(input[0]);

		for(int i = 1; i < input.length; i++) {
			try {
				bst.insertNode(new BinaryNode(input[i]));
			} catch (InvalidBinarySearchKeyTypeException e) {
				// Nothing
			}
		}
		
		return bst.inOrder(input.length);
	}

	private int[] convertListToArray(List<Integer> input) {
		
		int[] output = new int[input.size()];
		int i = 0;
		for(Integer element: input) {
			output[i++] = element;
		}
		
		return output;
	}
	
	@Override
	public int[] mergeSort(int[] input) {
		
		int length = input.length;
		if(length == 1) {
			return input;
		}
		
		int[] former = mergeSort(Arrays.copyOfRange(input, 0, length / 2));
		int[] latter = mergeSort(Arrays.copyOfRange(input, length / 2, length));
		
		return merge(former, latter);
	}
	
	private int[] merge(int[] former, int[] latter) {
		
		int[] merged = new int[former.length + latter.length];
		
		for(int i = 0, j = 0; i < former.length || j < latter.length;) { //NOSONAR
			if(former[i] < latter[j]) {
				merged[i+j] = former[i];
				i++; // NOSONAR
			} else {
				merged[i+j] = latter[j];
				j++; // NOSONAR
			}
			if(j == latter.length) {
				System.arraycopy(former, i, merged, i+j, former.length - i);
				break;
			} else if(i == former.length) {
				System.arraycopy(latter, j, merged, i+j, latter.length - j);
				break;
			}
		}
		
		return merged;
	}

	@Override
	public int[] quickSort(int[] input) {
		
		quickSort(input, 0, input.length - 1);
		return input;
		
	}
	
	private void quickSort(int[] in, int i, int j) {
		
		if(i >= j || i < 0) return;
		
		int pivotIndex = RANDOM.nextInt(j - i + 1) + i;
		swap(in, i, pivotIndex);
		
		int part = partition(in, i, j);
		quickSort(in, i, part - 1);
		quickSort(in, part + 1, j);
	}
	
	private int partition(int[] in, int lower, int upper) {
		
		int pivot = in[lower];
		
		int i = lower + 1;
		int j = upper;
		
		while(i <= j) {
			while(i <= j && in[i] <= pivot) i++;
			while(i <= j && in[j] > pivot) j--;
			
			if(i <= j) {
				swap(in, i, j);
				i++;
				j--;
			}
		}
		swap(in, lower, j);
		
		return j;
	}
	
	private void swap(int[] in, int i, int j) {
		int temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}

	@Override
	public int[] bubbleSort(int[] input) {
		
		boolean swap = false;
		
		for(int i = 0; i < input.length; i++) {
			swap = false;		
			for(int j = 0; j < input.length - i; j++) {
				if(j < input.length - 1 && input[j] > input[j + 1]) {
					swap(input, j, j+1);
					swap = true;
				}				
			}
			
			if(!swap) break;
		}
		
		return input;
	}

	@Override
	public int[] selectionSort(int[] input) {
		int length = input.length;
		for(int pass = 0; pass < input.length; pass++, length--) {
			int max = input[0];
			int maxIndex =  0;
			for(int i = 1; i < length; i++) {
				if(input[i] > max) {
					max = input[i];
					maxIndex = i;
				}
			}
			swap(input, maxIndex, length - 1);
		}
		return input;
	}

	@Override
	public int[] heapSort(int[] input) {

		Heap heap = new Heap(input);
		for(int i = 0; i < input.length; i++) {
			heap.deleteMax();
		}
		return input;
	} 
	
	
	
	@Override
	public int[] insertionSort(int[] input) {
		
		for(int i = 1; i < input.length; i++) {
			int key = input[i];
			int j = i - 1;
			for(; j >= 0 && input[j] > key; j--) {
				input[j+1] = input[j];
			}
			input[j+1] = key;
		}
		return input;
	}
	
	@Override
	public int[] countingSort(int[] input) {

		/*
		 * Based on our inputs, this value can be as big as 1G i.e the
		 * below array can get as big as 4GB.
		 */
		int max = Arrays.stream(input).max().getAsInt();
		
		if(max > Max.LARGE.getValue()) { // 128 * 4 MB -> 512 MB
			System.err.println("Input has values that may exceed allowed heap space");
			return input;
		}
		
		int[] count = new int[max + 1];
		int[] result = new int[input.length];
		
		for(int i = 0; i < input.length; i++) {
			count[input[i]]++;
		}
		
		for(int i = 1; i <= max; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = input.length - 1; i >= 0; i--) {
			count[input[i]]--;
			result[count[input[i]]] = input[i]; 
		}
		
		return result;
		
	}

	@Override
	public int[] radixSort(int[] input) {
		
		return input;
	}

	@Override
	public void timeTaken(long start, long end, int methodCount, boolean isValid, String sortType) {
		String unit = "milliseconds";
		float time = (end - start)/1000000f; // Time in millis
		if(time / 60000f > 1) {
			unit = "minutes";
			time /= 60000f;
		} else if (time / 1000 > 1) {
			unit =  "seconds";
			time /= 1000;
		}
		System.out.println("Time taken for executing method with ID " + methodCount + " is " + time + " "+ unit +  " for " + sortType + " with validity " + isValid);
		
	}
	
	
	@SuppressWarnings("unused")
	private void printArray(int[] array, String meta) { // NOSONAR
		System.out.println(Arrays.toString(array) + " " + meta);
	}
	
	
	enum Size {
		TEST(8), 
		SMALL(512 * 32),
		NOMINAL(512 * 128), 
		NORMAL(512 * 512),
		VARIABLE(512 * 512 * 2),
		MEDIUM(512 * 512 * 32), 
		LARGE(512 * 512 * 128), 
		EXTREME(512 * 512 * 512);
		
		private final int value;
		
		Size(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	
	enum Max {
		TEST(64), 
		NORMAL(1024 * 1024), 
		MEDIUM(1024 * 1024 * 32),
		LARGE(1024 * 1024 * 128),
		EXTREME(1024 * 1024 * 1024);
		
		private final int value;
		
		Max(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
}
