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
	
	public DFS(Grid goalGrid, Grid startGrid) {
		
		nodesChecked = 0;
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
	
			 
//			 try {
//				    Thread.sleep(1000);                 //1000 milliseconds is one second.
//				} catch(InterruptedException ex) {
//				    Thread.currentThread().interrupt();
//				}
		}
		
		if(found) {
			System.out.println("Solution found after checking " + nodesChecked + "nodes.");
			System.out.println();
			current.getGrid().print();
			//getSolution();
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
