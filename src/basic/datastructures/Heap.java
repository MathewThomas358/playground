package basic.datastructures;

public class Heap {
	
	int[] input;
	int length;
	
	public Heap(int[] input) {
		this.input = input;
		this.length = input.length;
		buildHeap();
	}
	
	private void buildHeap() {
		for(int i = length / 2 - 1; i >= 0; i--) {
			maxHeapify(i);
		}		
	}
	
	private void maxHeapify(int nodeIndex) {
		while(nodeIndex < length / 2 && nodeIndex >= 0) {
			int leftChild = 2 * nodeIndex + 1;
			int rightChild = 2 * nodeIndex + 2;
			
			if(leftChild >= length || rightChild >= length) {
				if(leftChild < length && input[nodeIndex] < input[leftChild]) {
					swap(input, nodeIndex, leftChild);
				} else if(rightChild < length && input[nodeIndex] < input[rightChild]) {
					swap(input, nodeIndex, rightChild);
				}
				break;
			}
			int swapIndex = findMaxAmongChildren(nodeIndex, leftChild, rightChild);
			if(nodeIndex == swapIndex) return;
			swap(input, nodeIndex, swapIndex);
			if(swapIndex != 0) {
				nodeIndex = swapIndex;
			}
		}
	}
	
	public int deleteMax() {			
		int min = input[0];
		swap(input, 0, length - 1);
		length--;		
		maxHeapify(0);
		
		return min;
	}
	
	private int findMaxAmongChildren(int nodeIndex, int leftChild, int rightChild) {
		int swapIndex = nodeIndex;
		if(input[nodeIndex] < input[leftChild]) {
			swapIndex = leftChild;
			if(input[leftChild] < input[rightChild]) {
				swapIndex = rightChild;
			}
		} else if(input[nodeIndex] < input[rightChild]) {
			swapIndex = rightChild;
		}
		return swapIndex;
	}
	
	private void swap(int[] in, int i, int j) {
		int temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}
}
