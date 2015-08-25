/**
 * Sample Node to be used through out the Chapter 2 problems
 * 
 * @author Bryant J. Son
 * @since  08/24/2015
 */
package com.bryantson.codingpractice.chapter2;

public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public void print() {
		Node curr = this;
		
		while (curr != null) {
			System.out.print(curr.data);
			System.out.print(" => ");
			curr = curr.next;
		}
		System.out.println(" null");
	}
	
	public int size() {
		Node curr = this;
		
		int size = 0;
		while (curr != null) {
			curr = curr.next;
			++ size;
		}
		return size;
	}
	
	public void append(int data) {
		Node curr = this;

		while (curr.next != null) {
			curr = curr.next;
		}	
		curr.next = new Node(data);	
	}	
	
	public void removeNode(int data) {
		Node head = this;
		if (data == head.data) {
			head = head.next;
			return;
		}
		
		Node curr = head;

		while(curr.next != null) {
			if(curr.next.data == data) {
				curr.next = curr.next.next;
				return;
			}
			curr = curr.next;
		}
		return;
	}
	
}
