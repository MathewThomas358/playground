package basic.algorithms;

public interface AllSortsOfSortsApi {

	public int[] mergeSort(int[] input);
	
	public int[] quickSort(int[] input);
	
	public int[] bubbleSort(int[] input);
	
	public int[] selectionSort(int[] input);
	
	public int[] heapSort(int[] input);
	
	public int[] insertionSort(int[] input);
	
	public int[] countingSort(int[] input);
	
	public int[] radixSort(int[] input);
	
	public void timeTaken(long startTimeInNanos, long endTimeInNanos, int methodCount, boolean isValid, String sortType);
}
