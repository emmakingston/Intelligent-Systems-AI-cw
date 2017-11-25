import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	private Queue<Node> queued = new LinkedList<Node>();
	private Boolean found;
	private Grid goal;
	private Node current;
	private int nodesChecked;
	
	public BFS(Grid goalGrid, Grid startGrid) {
		
		nodesChecked = 0;
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
			 		 
		}
		
		if(found) {
			System.out.println("Solution found after checking: " + nodesChecked + "nodes.");
			current.getGrid().print();
			//getSolution();
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
