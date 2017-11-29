import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	private Queue<Node> queued = new LinkedList<Node>();
	private Boolean found;
	private Grid goal;
	private Node current;
	private int nodesChecked;
	private int maxSpace;
	
	public BFS(Grid goalGrid, Grid startGrid) {
		
		nodesChecked = 0;
		maxSpace = 0;
		found = false;
		goal=goalGrid;
		
		//adds the root node to the queue
		queued.add(new Node(null,startGrid));
		
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
					queued.add(n);
				 }
			 }	
			 
			 //checks if the number of nodes in the fringe is greatest number yet 
			 if(queued.size() > maxSpace) {
				 maxSpace = queued.size();
			 }
			 		 
		}
		
		//if a solution is found output time and space complexity and cal method to print path
		if(found) {
			System.out.println("Solution found after checking: " + nodesChecked + "nodes.");
			System.out.println("Maximum space complexity reached:" + maxSpace);
			current.getGrid().print();
			getSolution();
		} else {
			System.out.println("Solution not found after checking: " + nodesChecked + "nodes.");
		}
	}
	
	//colects the path and outputs it to stdoutput
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
