/**
 * Warm up Practice for Chapter 2:
 * 	Defines the LinkedList structure with append node function and remove node function
 * 	
 *
 * 	@author Bryant Son
 * 	@since  08/22/2015
 */
package com.bryantson.codingpractice.chapter2;

public class SampleLinkedList {
	private Node head;
  private int  size;

	public SampleLinkedList(int data) {
		this.head = new Node(data);
		this.size = 1;
	}

	public Node getHead() {
		return this.head;
	}
	
	public int size() {
		return this.size;
	}

	public void print() {
		
		Node curr = this.head;

		while (curr != null) {
			System.out.print(curr.data);
			
			System.out.print(" => "); 
			
			curr = curr.next;
		}

		System.out.print(" null");
		System.out.println();

	}

	public Node append(int data) {
		Node curr = this.head;

		while (curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = new Node(data);	

		++ this.size;
		return head;
	}	

	public Node removeNode(int data) {
		if (data == this.head.data) {
			this.head = this.head.next;
			return this.head;
		}
		
		Node curr = this.head;

		while(curr.next != null) {
			if(curr.next.data == data) {
				curr.next = curr.next.next;
				-- this.size;
				return this.head;
			}
			
			curr = curr.next;

		}
		return this.head;
	}

}

class Node {
	public int data;
	public Node next;

	public Node(int data){ 
		this.data = data;
		this.next = null;
	}
}
