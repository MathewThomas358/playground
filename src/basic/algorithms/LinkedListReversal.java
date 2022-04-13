package basic.algorithms;

import basic.datastructures.*;
import java.util.Random;

/**
 * Takes O(n) time and space to reverse a linked list.
 *
 */
public class LinkedListReversal {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		SinglyLinkedList ll = new SinglyLinkedList(rand.nextInt(64));
		
		for(int i = 0; i < 15; i++) {
			ll.insertNode(rand.nextInt(64));
		}

		ll.printList();
		
		reverse(ll).printList();

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

}
