import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class IDFS {

	private Stack<Node> toExpand = new Stack<Node>();
	private Boolean found;
	private Grid goal;
	private Node current;
	private int nodesChecked;
	private int depth; //returns depth of solution

	public IDFS(Grid goalGrid, Grid startGrid) {

		nodesChecked = 0;
		found = false;
		goal=goalGrid;

		for(int i=0;;i++) {
			toExpand.add(new Node(new Grid(startGrid),0));
			search(i);	

			if(found) {
				System.out.println("Solution found after checking total " + nodesChecked + " nodes at depth " + depth);
				System.out.println();
				current.getGrid().print();
				System.out.println("\nPath to solution");
				getSolution();
			} else {
				//System.out.println("Solution not found after checking total " + nodesChecked + " nodes");
			}
			if(found) {
				break;
			}
		}

	}

	public void search(int i) {

		//whilst there are nodes to expand, continues searching
		while(!toExpand.isEmpty() && !found) {
			
			current = toExpand.pop();
			depth = current.getDepth();
			nodesChecked++;

			//checks if current node is valid solution
			if(current.getGrid().compareTo(goal)) {
				found = true;
			}

			//if current node isnt solution, add nodes children to the stack
			if(!found && depth < i) {
				current.setChildren();

				for(Node n: current.getChildren()){
					n.setDepth(depth + 1);
					toExpand.push(n);

				}
			}

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
