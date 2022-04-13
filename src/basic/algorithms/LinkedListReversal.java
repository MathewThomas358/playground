package basic.algorithms;

import basic.datastructures.*;
import java.util.Random;

/**
 * Takes O(n) time and space to reverse a linked list.
 *
 */
public class LinkedListReversal {
	
	private static SinglyLinkedList sll;
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		SinglyLinkedList ll = new SinglyLinkedList(rand.nextInt(64));
		
		for(int i = 0; i < 15; i++) {
			ll.insertNode(rand.nextInt(64));
		}
		
		reverse(ll);
		
		ll.printList();
		sll.printList();
	}

	public static void reverse(SinglyLinkedList ll) {
		LinkedListNode temp = reverse(ll.head);
		if(sll != null) {
			sll.insertNode(temp.data);
		} else {
			sll = new SinglyLinkedList(temp.data);
		}
		sll.last.link = null;
	}
	
	private static LinkedListNode reverse(LinkedListNode node) {
		
		if(node.link != null) {
			LinkedListNode temp = reverse(node.link);
			if(sll == null) {
				sll = new SinglyLinkedList(temp.data);
			} else {
				sll.insertNode(temp.data);
			}
		} 	
		return node;
	}

}
