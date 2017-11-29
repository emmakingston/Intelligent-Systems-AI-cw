import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {
	
	private PriorityQueue<Node> queued = new PriorityQueue<Node>();
	private Boolean found;
	private Grid goal;
	private Node current;
	private int nodesChecked;
	private int maxSpace;
	
	public AStar(Grid goalGrid, Grid startGrid) {
		
		nodesChecked = 0;
		maxSpace = 0;
		found = false;
		goal=goalGrid;
		
		//adds the root node to the queue with depth 0
		queued.add(new Node(startGrid,0,goal));
		
		search();		
		
	}
	
	public void search() {
		
		//whilst there are nodes to expand, continues searching
		while(!queued.isEmpty() && !found) {
			
			 current = queued.poll();
			 nodesChecked++;
			 
			 //checks if current node is valid solution
			 if(current.getGrid().compareTo(goal)) {
				 found = true;
			 }
			 
			 //if current node isnt solution, add nodes children to the queue
			 if(!found) {
				 current.setChildren();
				 
				 for(Node n:current.getChildren()) {
					 n.setDepth(current.getDepth()+1);
					 n.setFval(goal);					 
					 queued.add(n);
				 }
			 }	
			 
			 //calculates space complexity
			 if(queued.size() > maxSpace) {
				 maxSpace = queued.size();
			 }
			
		}
		
		//prints time and space complexity and path when solution found
		if(found) {
			System.out.println("Solution found after checking: " + nodesChecked + " nodes at height " + current.getDepth());
			System.out.println("Space complexity: " +maxSpace);
			current.getGrid().print();
			getSolution();
		} else {
			System.out.println("Solution not found after checking: " + nodesChecked + "nodes.");
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
