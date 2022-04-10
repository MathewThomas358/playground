package basic.datastructures;

import java.util.*;

public class Queue {
	
	public LinkedListNode head;
	public LinkedListNode tail;
	
	public Queue(Object data) {
		this.head = new LinkedListNode(data);
		this.tail = this.head;
	}
	
	public void enqueue(Object data) {
		
		this.tail.link = new LinkedListNode(data);
		this.tail = this.tail.link;
		
	}
	
	public Object dequeue() {
		
		Object data = this.head.data;
		this.head = this.head.link;
		
		return data;
		
	} 
	
	public void printQueue() {
		
		LinkedListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.link;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Queue queue = new Queue(rand.nextInt(32));
		
		for(int i = 0; i < 15; i++) {
			queue.enqueue(rand.nextInt(32));
		}
		
		queue.printQueue();
		queue.dequeue();
		queue.enqueue(100);
		queue.printQueue();
	}
}
