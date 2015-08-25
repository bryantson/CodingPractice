/**
 * Problem 2.2:
 * 	Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * 	@author Bryant Son
 * 	@since  08/24/2015
 */

package com.bryantson.codingpractice.chapter2;

public class Problem2_2Practice {
	
	/**
	 * Returns the size of the linked list
	 * @param head is the head of the linked list
	 * @return the size of the linked list
	 */
	public int size(Node head) {
		Node curr = head;
		int size = 0;
		
		while (curr != null) {
			++ size;
			curr = curr.next;
		}
		return size;
	}
	
	/**
	 * Returns the Kth to end value of the given linked list by finding the (n - k + 1) position
	 * @param k is the position from the end
	 * @param head is the head of the linked list
	 * @return the node that is at Kth to end position
	 */
	public Node getKthFromLastWithLength(int k, Node head) {
		if (k < 1) {
			return head;
		}
		int n = size(head) - k + 1;
		
		Node curr = head;
		
		for (int i=1; i < n; ++ i) {
			curr = curr.next;
		}
		return curr;
	}
	
	/**
	 * Returns the Kth to end value of the given linked list by using two pointers. First pointer starts moving
	 * by Kth position from the head. Then, second pointer starts at the head and first pointer iterates where it 
	 * left to the end of the linked list. Thus, second pointer will be at the position where (n - k + 1)
	 * @param k is position from the end
	 * @param head is the head of the linked list
	 * @return the node that is at Kth to end position
	 */
	public Node getKthFromLastWithPointer(int k, Node head) {
		if (k == 0) {
			return head;
		}
		
		Node nodeRunner = head;
		
		int counter = 0;
		while (nodeRunner != null && counter < k) {
			nodeRunner = nodeRunner.next;
			++ counter;
		}
		
		if (nodeRunner == null) {
			return head;
		}
		
		Node nodeKthToEnd = head;
		
		while (nodeRunner != null) {
			nodeKthToEnd = nodeKthToEnd.next;
			nodeRunner = nodeRunner.next;
		}
		
		return nodeKthToEnd;
		
	}
}
