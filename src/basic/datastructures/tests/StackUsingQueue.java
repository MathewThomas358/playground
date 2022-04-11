package basic.datastructures.tests;

import java.util.Random;
import basic.datastructures.*;

public class StackUsingQueue {
	
	private Queue queue;
	
	StackUsingQueue(Object data) {
		this.queue = new Queue(data);
	}
	
	private void push(Object data) {
		queue.enqueue(data);
	}
	
	private Object pop() {
		
		LinkedListNode currentNode = queue.head;
		LinkedListNode lastNode = queue.tail;
		
		while(currentNode != null && currentNode != lastNode) {
			queue.enqueue(queue.dequeue());
			currentNode = queue.head;
		}
		
		return queue.dequeue();
	}
	
	private void printStack() {
		LinkedListNode currentNode = queue.head;
		LinkedListNode lastNode = queue.tail;
		StringBuilder result = new StringBuilder();
		while(currentNode != null && currentNode != lastNode) {
			Object element = queue.dequeue();
			queue.enqueue(element);
			result.insert(0, " " + element);
			currentNode =  currentNode.link;
		}
		Object element = queue.dequeue();
		queue.enqueue(element);
		result.insert(0, element);
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		
		Random rand = new Random();
		int element = rand.nextInt(16);
		StackUsingQueue modStack = new StackUsingQueue(element);
		Stack originalStack = new Stack(element);
		
		for (int i = 0; i < 15; i++) {
			
			element = rand.nextInt(64);
			modStack.push(element);	
			originalStack.push(element);
		}
		
		modStack.printStack();
		originalStack.printStack(true);
		
		for (int i = 0; i < rand.nextInt(15); i++) {
			modStack.pop();
			originalStack.pop(false);
		}

		modStack.printStack();
		originalStack.printStack(true);
	}
}
