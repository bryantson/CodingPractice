/**
 * 
 *  Given two sorted lists, remove duplicates so that:
 *      Only one copy  is left from either list
        Two lists are well-balanced as possible, which means they have closest number of element
        
 * @author Bryant Son
 * @since  07/23/2014
 * 
 */

package com.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.att.interview.RedistributeAlgorithm.BST.TreeNode;


public class RedistributeAlgorithm {
	// ENUM type that indicates whether the item comes from left or right of the lists:
	private enum ListType { LEFT, RIGHT };
	
	public static void main(String[] args) {
		int[] listA = new int[]{1, 2, 3};
		int[] listB = new int[]{0, 2, 4, 4, 5};
		
		System.out.println("=== INPUT VALUES === ");
		
		System.out.print("LIST A: ");
		for(int i=0, n = listA.length; i < n; ++ i) {
			System.out.print(listA[i] + " ");
		}
		
		System.out.println();
		System.out.print("LIST B: ");
		
		for(int i=0, n = listB.length; i < n; ++ i) {
			System.out.print(listB[i] + " ");
		}
		
		System.out.println("\n");
		
		RedistributeAlgorithm iq = new RedistributeAlgorithm();
		
		Map<Integer,List<Integer>> result = iq.getBalancedTwoListsFromTree(listA, listB);
		List<Integer> resultListA = result.get(0);
		
		System.out.println("=== OUTPUT VALUES === ");
		
		System.out.print("LIST A: ");
		for(Integer item: resultListA) {
			System.out.print(item + " ");
		}
		
		System.out.println();
		
		System.out.print("LIST B: ");
		
		List<Integer> resultListB = result.get(1);
		for(Integer item: resultListB) {
			System.out.print(item + " ");
		}
	
	}
	
	/**
	 * Given two sorted lists, removes the duplicates:
	 * 1. Only one copy is left from the lists, and
	 * 2. Two lists are well balanced as possible
	 * 
	 * Big-O: O(N log N), for O(N), which is to call removeDuplicates(),
	 *                        O(N log N), which is to traverse through the list (N) and call insert (= log N),
	 *                        O(N log N), which is to call sortListsFromTree().
	 *                        
	 * @param listA, which is the sorted list of items that might contain duplicates and overlapping items
	 * @param listB, which is the sorted list of items that might contain duplicates and overlapping items
	 * @return HashMap that will contain listA in index 0, listB in index 1
	 */
	public Map<Integer,List<Integer>> getBalancedTwoListsFromTree(int[] listA, int[] listB) {
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
		
		List<Integer> listAFiltered = removeDuplicates(listA);
		List<Integer> listBFiltered = removeDuplicates(listB);

		int lenListA = listAFiltered.size(); 
		int lenListB = listBFiltered.size();
		
		if(lenListA == 0 || lenListB == 0) {
			result.put(0, listAFiltered);
			result.put(1, listBFiltered);
			return result;
		}
		
		BST tree = new BST();
		
		for(int i = 0; i < lenListA; ++ i) {
			 tree.insert(listAFiltered.get(i), ListType.LEFT);
		}
		
		for(int i = 0; i < lenListB; ++ i) {
			 tree.insert(listBFiltered.get(i), ListType.RIGHT);
		}
		
		Map<Integer,List<Integer>> mapSortedLists = sortListsFromTree(tree);
		result.put(0, mapSortedLists.get(0));
		result.put(1, mapSortedLists.get(1));
		
		return result;
		
	}
	
	/**
	 * Returns two balances lists of integers after searching through the provided
	 * Binary Search Tree by PreOrderTraversal (O(N)). 
	 * 
	 * The algorithm works by first distributing non-overlapping
	 * items to listA and listB, accordingly, while separately storing overlapping items
	 * from listA and listB to another list of integers. Once non-overlapping items were
	 * all sorted, overlapping items will be distributed to listA and listB based on their size
	 * to maintain well-balanced order structure. Collections sort() (O(NlogN)) will be called to fix the
	 * sorting of overlapping items at the end of the list. 
	 * 
	 * Big-O: O(N log N) for O(N), which is to traverse the Binary Search Tree by PreOrder traversal, plus
	 *                       O(N log N), which is the average case to sort the items by Collections Sort.
	 * 
	 * @param tree, which is the binary search tree to sort the items to two lists
	 * @return two lists sorted in well-balanced size
	 */
	public Map<Integer,List<Integer>> sortListsFromTree(BST tree) {
		// Return value that will contain the result  to the caller
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
		
		// Stores the items to contain in listA:
		List<Integer> listA = new ArrayList<Integer>();
		// Stores the items to contain in listB:
		List<Integer> listB = new ArrayList<Integer>();
		// A temporary list to hold the items that contain in both listA and listB:
		List<Integer> listOverlap = new ArrayList<Integer>();
		
		// Stack to perform the PreOrder traversal:
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.add(null);
		TreeNode node = tree.getRoot();
		
		// Perform the Preorder traversal starting from the root, and it separates the
		// non-overlapping items from overlapping items:
		while (node != null) {
			if(node.getInLeft() && node.getInRight()) {
				listOverlap.add(node.getValue());
			}
			else if(node.getInLeft()) {
				listA.add(node.getValue());
			}
			else {
				listB.add(node.getValue());
			}
			if(node.getRight() != null) {
				s.push(node.getRight());
			}
			if(node.getLeft() != null) {
				s.push(node.getLeft());
			}
			node = s.pop();
		}
		
		// Redistribute overlapping items to either listA or listB based on their size, whichever
		// one is smallest at the moment:
		for(Integer item: listOverlap) {
			if(listA.size() <= listB.size()) {
				listA.add(item);
			}
			else {
				listB.add(item);
			}
		}
		
		// Resort the listA and listB, because the overlapping items added to the end of the lists:
		Collections.sort(listA);
		Collections.sort(listB);
		
		result.put(0, listA);
		result.put(1, listB);
		return result;
	}

	/**
	 * Removes the duplicated items from a provided list:
	 * 
	 * Big-O: O(N) to traverse through the list
	 * 
	 * @param list, which is the list of integers that might contain the duplicated items
	 * @return list of items that does not have any duplicate items
	 */
	public List<Integer> removeDuplicates(int[] list) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0, n = list.length; i < n; ++ i) {
			if(!result.contains(list[i])) {
				result.add(list[i]);
			}
		}
		return result;
		
	}
	
	/**
	 * A customize Binary Search Tree implementation that will store the fields that indicates
	 * that the item is contained in a left list , a right list, or both.
	 *
	 */
	class BST {
		// Root of the tree:
		private TreeNode root;
		
		
		public BST () {
			this.root = null;
		}
		
		/**
		 * Insert a new node to the Binary Search Tree at the current root node. Calls the helper
		 * method insert(TreeNode, int, ListType)
		 * Big-O: O(log N), which is the average time to insert by Binary Search Tree
		 * @param val, which is the value of the item to insert
		 * @param listType, which is the field that indicates whether the item is contained in which list
		 */
		public void insert(int val, ListType listType) {
			this.root = insert(root, val, listType);
		}
		
		/**
		 * Inserts a new node to the Binary Search tree by making a recursive call.
		 * 
		 * Big-O: O(log N), which is the average time to insert by Binary Search Tree
		 * 
		 * @param node, which is the node to recursively operate upon
		 * @param val, which is the value of the item to insert
		 * @param listType, which is the field that indicates whether the item is contained in wich list
		 * @return node, which is rebuilt after making a recursive call
		 */
		public TreeNode insert (TreeNode node, int val, ListType listType) {
			
			// If the end of a leaf of the tree has been reached:
			if (node == null) {
				// If the item belongs to the left list, attach a new node to the tree 
				// and turn on the flag that says it comes from left list:
				if(listType == ListType.LEFT) {
					return new TreeNode(val, true, false);
				}
				// If the item belongs to the right list, attach a new node to the tree 
				// and turn on the flag that says it comes from right list:
				return new TreeNode(val, false, true);
			}

			// If the value already exists:
			if(node.getValue() == val) {
				// If the item belongs to the left list, turn on the flag that says it comes from left list:
				if(listType == ListType.LEFT) {
					node.setInLeft(true);
				}
				// If the item belongs to the right list, turn on the flag that says it comes from right list:
				else {
					node.setInRight(true);
				}
				return node;
			}

			// Make a recursive call to left child of the tree if the inserted value is less than the current node:
			if (val < node.getValue()) {
				node.leftNode = insert(node.getLeft(), val, listType);
				return node;
			}
			// Make a recursive call to right child of the tree if the inserted value is equal or greater than the current node:
			else {
				node.rightNode = insert(node.getRight(), val, listType);
				return node;
			}
		}
		
		public TreeNode getRoot() {
			return this.root;
		}
		
		/**
		 * Prints the tree in level order for the root of the tree. Makes a call to the helper function
		 * printBreadthFirst(TreeNode)
		 */
		public void printBreadthFirst() {
			printBreadthFirst(this.root);
		}
		
		/**
		 * Prints the tree in level order by making the recursive call to the node. Iterative approach
		 * to Breath First Search algorithm is used in this method.
		 * 
		 * @param node, which is the current node to make a recursive call
		 */
		public void printBreadthFirst(TreeNode node) {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(node);
			while(!q.isEmpty()) {
				node = q.poll();
				System.out.println(node.getValue() + " " + node.getInLeft() + " " + node.getInRight());
				if(node.getLeft() != null) {
					q.add(node.getLeft());
					
				}
				if(node.getRight() != null) {
					q.add(node.getRight());
				}
			}
		}
		
		/**
		 * Represents the TreeNode component of a Binary Search Tree
		 *
		 */
		class TreeNode {
			// Value of the node:
			private int      val;
			// Left children of the current node:
			private TreeNode leftNode;
			// Right children of the current node:
			private TreeNode rightNode;
			// True if the node belongs to the left list. Default is false:
			private boolean  inLeftList;
			// True if the node belongs to the right list. Default is false:
			private boolean  inRightList;
	
			/**
			 * A constructor that instantiates a new TreeNode. This is the default constructor.
			 * Sets the left list indicator and right
			 * list indicator to false.
			 * 
			 * @param val, which is the value of the node
			 */
			public TreeNode (int val) {
				this.val = val;
				this.leftNode = null;
				this.rightNode = null;
				this.inLeftList = false;
				this.inRightList = false;
			}
	
			/**
			 * A constructor that instantiates a new TreeNode. Sets the left list indicator
			 * and right list indicator to the values provided by caller.
			 * 
			 * @param val, which is the value of the node
			 */
			public TreeNode (int val, boolean inLeftList, boolean inRightList) {
				this.val = val;
				this.leftNode = null;
				this.rightNode = null;
				this.inLeftList = inLeftList;
				this.inRightList = inRightList;
			}
	
	
			public int getValue() {
				return this.val;
			}
	
			public TreeNode getLeft() {
				return this.leftNode;
			}
	
			public void setLeft(TreeNode leftNode) {
				this.leftNode = leftNode;
			}
	
	
			public TreeNode getRight() {
				return this.rightNode;
			}
			
	
			public void setRight(TreeNode rightNode) {
				this.rightNode = rightNode;
				
			}
			
			public boolean getInLeft () {
				return this.inLeftList;
			}
	
	
			public void setInLeft (boolean inLeftList) {
				this.inLeftList = inLeftList;
			}
			
			public boolean getInRight () {
				return this.inRightList;
			}
	
			public void setInRight (boolean inRightList) {
				this.inRightList = inRightList;
			}
			
	
		}
	}
}
