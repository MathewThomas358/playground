package basic.datastructures.tests;

import java.util.Random;
import basic.datastructures.*;

public class QueueUsingStack {

	private Stack stackA;
	private Stack stackB;
	
	QueueUsingStack(Object data) {
		stackA = new Stack(data);
	}
	
	public void enqueue(Object data) {
		stackA.push(data);
	}
	
	public Object dequeue() {
		if(stackB == null || stackB.isEmpty()) {
			while(!stackA.isEmpty()) {
				if(stackB == null) {
					stackB = new Stack(stackA.pop());
				} else {
					stackB.push(stackA.pop());
				}
			}
			if(stackB != null) {
				return stackB.pop();
			} else {
				return null;
			}
		} else {
			return stackB.pop(); 
		}
	}
	
	public void printQueue() {
		
		if(stackB != null && !stackB.isEmpty()) {
			stackB.printStack(true);
		}
		if(!stackA.isEmpty()) {
			stackA.printStack(false);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		int initialElement = rand.nextInt(64);
		QueueUsingStack modQueue = new QueueUsingStack(initialElement);
		Queue normalQueue = new Queue(initialElement);
		
		modQueue.printQueue();
		normalQueue.printQueue();
		
		for(int i = 0; i < 15; i++) {
			int element = rand.nextInt(64);
			modQueue.enqueue(element);
			normalQueue.enqueue(element);
		}
		
		modQueue.printQueue();
		normalQueue.printQueue();
		
		for(int i = 0; i < rand.nextInt(16); i++) {
			modQueue.dequeue();
			normalQueue.dequeue();
		}
		
		modQueue.printQueue();
		normalQueue.printQueue();
		
		for(int i = 0; i < 15; i++) {
			int element = rand.nextInt(64);
			modQueue.enqueue(element); //TODO: stack overflow is causing some issues
			normalQueue.enqueue(element);
		}
		
		modQueue.printQueue();
		normalQueue.printQueue();
		
		for(int i = 0; i < rand.nextInt(32); i++) {
			modQueue.dequeue();
			normalQueue.dequeue();
		}
		
		modQueue.printQueue();
		normalQueue.printQueue();
	}
}
