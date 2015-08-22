/**
 * Problem 2.1:
 * 	Write code to remove duplicates from an unsorted linked list:
 * 
 * FOLLOW UP:
 * 	How would you solve this prolem if a temporary buffer is not allowed.
 * 	
 *
 * 	@author Bryant Son
 * 	@since  08/22/2015
 */

package com.bryantson.codingpractice.chapter2;

import java.util.HashMap;
import java.util.Map;

public class Problem2_1Practice {
		private Node head;
		private int  size;

		public Problem2_1Practice(int data) {
			this.head = new Node(data);
			this.size = 1;
		}
		
		public int size() {
			return this.size;
		}
		
		public Node getHead() {
			return this.head;
		}
		
		/**
		 * Prints out the Linked List in an human readable format
		 */
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
		
		/**
		 * Returns the node with duplicated nodes removed, if any, without using any memory buffer
		 * 
		 * @return head of a node with duplicated nodes removed
		 */
		public Node removeDuplicatesWithoutBuffer() {
			if (head.next == null) {
				return head;
			}
			
			Node curr = head;
			
			while (curr != null) {
				Node nextNode = curr;
				
				while (nextNode != null && nextNode.next != null) {
					if (nextNode.next.data == curr.data) {
						nextNode.next = nextNode.next.next;
						-- this.size;
					}
					nextNode = nextNode.next;
				}
				curr = curr.next;
			}
			
			return head;
		}

		/**
		 * Returns the node with duplicated nodes removed, if any, by using a memory buffer
		 * 
		 * @return head of a node with duplicated nodes removed
		 */
		public Node removeDuplicatesWithBuffer() {
			if (head.next == null) {
				return head;
			}
			
			Map<Integer, Boolean> mapAppearedNodes = new HashMap<Integer, Boolean>();

			Node curr = this.head;

			mapAppearedNodes.put(Integer.valueOf(this.head.data), Boolean.valueOf(true));

			while (curr.next != null) {
				
				if (mapAppearedNodes.containsKey(Integer.valueOf(curr.next.data))) {
					curr.next = curr.next.next;
					-- this.size;
				}
				else {
					mapAppearedNodes.put(Integer.valueOf(curr.next.data), Boolean.valueOf(true));
					curr = curr.next;				
				}
			}

			return head;
		}

		public Node append(int data) {
			if(head.next  == null) {
				head.next = new Node(data);
				++ this.size;
				return head;
			}

			Node curr = head;

			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = new Node(data);
			
			++ this.size;

			return head;
		}


		class Node {
			private int data;
			private Node next;
		
			public Node(int data) {
				this.next = null;
				this.data = data;
			}
		}

	
}


