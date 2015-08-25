/**
 * Problem 2.3:
 * 	Implement an algorithm to delete a node in the middle of a singly linked list, given
 *  only access to that node.
 *  
 *  EXAMPLE:
 *  	Input : the node c from the linked list a -> b -> c -> d -> e
 *    Result: nothing is returned, but the new linked list look like a -> b -> d -> e
 *
 * 	@author Bryant Son
 * 	@since  08/24/2015
 */


package com.bryantson.codingpractice.chapter2;

public class Problem2_3Practice extends Node {
	
	public Problem2_3Practice(int data) {
		super(data);
	}
	
	/**
	 * Returns the Node at the Kth position from the head
	 * @param k is the position from the head
	 * @return the node that is Kth position from the head
	 */
	public Node getKthNode(int k) {
		Node curr = this;
		
		int counter = 0;
		while (curr != null && counter < k) {
			curr = curr.next;
			++ counter;
		}
		return curr;
	}

	/**
	 * Removes the middle element of the list. If there is only one node, don't change.
	 * 
	 */
	public void removeMiddleOfList() {
		Node curr = this;
		
		if (this.next == null) {
			return;
		}
		
		int n = curr.size() / 2;
		for (int i=1; i < n; ++ i) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
	}
}
