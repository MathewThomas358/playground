package basic.datastructures;

import java.util.*;

public class Stack {

	private Object[] array;
	private int count;
	private int size = 16;
	
	public Stack(Object element) {
		this.array = new Object[size];
		this.array[0] = element;
		count = 0;
	}
	
	public void push(Object data) {
		if(count < size - 1) {
			this.array[++count] = data;
		} else {
			System.out.println("Overflow. Increasing the size and pushing");
			size *= 2;
			Object[] temp = new Object[size];
			System.arraycopy(array, 0, temp, 0, array.length);
			array = temp;
			this.array[++count] = data;
		}
	}
	
	public Object pop(boolean printUnderflow) {
		if(count >= 0) {
			Object temp = array[count]; 
			array[count--] = null;
			return temp;
		} else {
			if(printUnderflow) System.out.println("Underflow");
			return null;
		}
	}
	
	public boolean isEmpty() {
		return count == -1;
	}
	
	//TODO: Add a type checker for numbers
	public void printStack() {
		int index = count;
		System.out.println("| top |");
		System.out.println("|_____|");
		while(index >= 0 && array[index] != null) {
			System.out.println(String.format("|%5d|", (int) array[index--])); // TODO
			System.out.println("|_____|");
		}
		System.out.println();
	}
	
	public void printStack(boolean isTopDown) {
		int index;
		if(isTopDown) {
			index = count;
			while(index >=0 && array[index] != null) {
				System.out.print(array[index--] + " ");
			}		
		} else {
			index = 0;
			while(index <= count && array[index] != null) {
				System.out.print(array[index++] + " ");
			}
		}
		System.out.println();
	}
 
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Stack stack = new Stack(rand.nextInt(64));
		for (int i = 0; i < 64; i++) {
			stack.push(rand.nextInt(64));
			
		}
		stack.printStack();
		stack.pop(true);
		stack.pop(true);
		stack.printStack();
	}
}
