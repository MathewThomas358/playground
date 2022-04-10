package basic.datastructures;

import java.util.*;

public class SinglyLinkedList {

	public LinkedListNode head;
	public LinkedListNode last;
	
	SinglyLinkedList(Object data) {
		this.head = new LinkedListNode(data);
		this.last = this.head;
	}
	
	public void insertNode(Object data) {
		LinkedListNode newNode = new LinkedListNode(data);
		this.last.link = newNode;
		this.last = newNode;
	}
	
	/**
	 * Deletes the last inserted node i.e. node at the tail.
	 */
	public void deleteNode() {
		LinkedListNode currentNode = head;
		while(currentNode.link.link != null) {
			currentNode = currentNode.link;
		}
		currentNode.link = null;
	}
	
	public void printList() {
		LinkedListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(" " + currentNode.data + " <-");
			currentNode = currentNode.link;
		}
		System.out.print("|");
		System.out.println();
	}
	
	public void findNode(Object data) {
		LinkedListNode currentNode = head;
		int count = 0;
		while(currentNode != null) {
			count++;
			if(currentNode.data == data) {
				System.out.println("Found data with value " + data + " at node " + count);
				return;
			}
			currentNode = currentNode.link;
		}
		System.out.println("Data not found");
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		SinglyLinkedList sll = new SinglyLinkedList(rand.nextInt(64));
		for (int i = 0; i < 16; i++) {
			sll.insertNode(rand.nextInt(64));
		}
		sll.printList();
		sll.deleteNode();
		sll.findNode(rand.nextInt(32));
	}
}
