package basic.algorithms;

import basic.datastructures.*;
import java.util.Random;


public class LinkedListReversal {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		SinglyLinkedList ll = new SinglyLinkedList(rand.nextInt(64));
		
		
		for(int i = 0; i < 15; i++) {
			ll.insertNode(rand.nextInt(64));
		}

		ll.printList();
		
		/**
		 * Takes O(n) time and space to reverse a linked list.
		 *
		 */
		reverse(ll).printList();
		
		/*
		 * Takes O(1) space i.e. reusing the input space
		 */
		reverse(ll, ll.head).printList();

	}

	public static SinglyLinkedList reverse(SinglyLinkedList ll) {
		SinglyLinkedList sll = new SinglyLinkedList();
		LinkedListNode temp = reverse(ll.head, sll);
		
		sll.insertNode(temp.data);
		sll.last.link = null;
		
		return sll;
	}
	
	private static LinkedListNode reverse(LinkedListNode node, SinglyLinkedList clone) {
		
		if(node.link != null) {
			LinkedListNode temp = reverse(node.link, clone);
			clone.insertNode(temp.data);
		} 	
		return node;
	}

	
	private static LinkedListNode reverse(LinkedListNode current, LinkedListNode link, SinglyLinkedList ll) {
	
		if(link != null) {
			LinkedListNode temp = reverse(current.link, current.link.link, ll);
			temp.link = current;
		} else {
			ll.head = current;
		}
		return current;
	}
	
	private static SinglyLinkedList reverse(SinglyLinkedList ll, LinkedListNode head) {
		
		if(ll != null && head != null) {
			LinkedListNode tail = reverse(ll.head, ll.head.link, ll);
			tail.link = null; 
		}
		
		return ll;
	}
}
