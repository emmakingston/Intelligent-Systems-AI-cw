import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
	
	private Stack<Node> toExpand = new Stack<Node>();
	private Boolean found;
	private Grid goal;
	private Node current;
	private int nodesChecked;
	private int maxSpace;
	
	public DFS(Grid goalGrid, Grid startGrid) {
		
		nodesChecked = 0;
		maxSpace = 0;		
		found = false;
		goal=goalGrid;
		
		//adds the root node to the stack
		toExpand.add(new Node(null,startGrid));
		
		search();	
	
	}
	
	
	public void search() {
		
		//whilst there are nodes to expand, continues searching
		while(!toExpand.isEmpty() && !found) {
			
			 current = toExpand.pop();
			 nodesChecked++;
			 
			 //checks if current node is valid solution
			 if(current.getGrid().compareTo(goal)) {
				 found = true;
			 }
			 
			 //if current node isnt solution, add nodes children to the stack
			 if(!found) {
				 current.setChildren();
				 
				 ArrayList<Node> children = current.getChildren();
				 Collections.shuffle(children);
				 
				 for(Node n: children){
					 toExpand.push(n);
					 
				 }
			 }	
			 
			 //checks if the number of nodes in the fringe is greatest number yet 
			 if(toExpand.size() > maxSpace) {
				 maxSpace = toExpand.size();
			 }
	
		}
		
		//if solution is found output space and time complexity and solution
		if(found) {
			System.out.println("Solution found after checking " + nodesChecked + "nodes.");
			System.out.println("Maximum space complexity reached:" + maxSpace);
			getSolution();
		} else {
			System.out.println("Solution not found after checking " + nodesChecked + "nodes.");
		}
	}
	
	public void getSolution() {
		LinkedList<Node> solution = new LinkedList<Node>();
		while(current.getParent() != null) {
			solution.addFirst(current);
			current = current.getParent();
		}
		
		for(Node n: solution) {
			System.out.println();
			n.getGrid().print();
		}
	}

}
//
//int total = 0;
//int totalSpace = 0;
//
//for(int i=0;i<50;i++) {
//	System.out.println(i);
//	nodesChecked = 0;
//	maxSpace = 0;
//	found = false;
//	goal=goalGrid;
//	
//	//adds the root node to the stack
//	toExpand.add(new Node(null,new Grid(startGrid)));
//	
//	search();	
//	total = total +nodesChecked;
//	totalSpace = totalSpace + maxSpace;
//}
//System.out.println("Average time complexity" + total/50);
//System.out.println("Average space complexity" + totalSpace/50);
