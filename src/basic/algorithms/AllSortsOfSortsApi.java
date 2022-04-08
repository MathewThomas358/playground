package basic.algorithms;

public interface AllSortsOfSortsApi {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] mergeSort(int[] input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] quickSort(int[] input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] bubbleSort(int[] input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] selectionSort(int[] input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] heapSort(int[] input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] insertionSort(int[] input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] countingSort(int[] input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] radixSort(int[] input);
	
	/**
	 * 
	 * @param startTimeInNanos
	 * @param endTimeInNanos
	 * @param methodCount
	 * @param isValid
	 * @param sortType
	 */
	public void timeTaken(long startTimeInNanos, long endTimeInNanos, int methodCount, boolean isValid, String sortType);
}
