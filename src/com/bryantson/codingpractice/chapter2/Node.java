package com.bryantson.codingpractice.chapter2;

public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
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
