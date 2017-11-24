import java.util.ArrayList;

public class Node implements Comparable<Node>{
	
	private Node parent;
	private ArrayList<Node> children = new ArrayList<Node>();
	private Grid board;
	private int depth;
	private int fVal; 	//result of g(n) + h(n) (depth plus manhattan)
	private int manhatDist;
	
	//root node
	public Node(Grid start) {
		this.parent = null;
		board = start;
	}
	
	//node with depth
	public Node(Grid start, int height) {
		this.parent = null;
		board = start;
		depth = 0;
	}
	
	//node with depth and goal grid
	public Node(Grid start, int height, Grid goal) {
		this.parent = null;
		board = start;
		depth = 0;
		this.setFval(goal);
	}
	
	//node generated as a child (i.e. a parent is given)
	public Node(Node parent, Grid config) {
		this.parent = parent;
		board = config;
	}
	
	//returns all children
	public ArrayList<Node> getChildren(){
		return children;
	}
	
	//returns the parent node
	public Node getParent() {
		return parent;
	}
	
	//returns the grid for the node
	public Grid getGrid() {
		return board;
	}
	
	//returns the depth of the node in the search tree
	public int getDepth() {
		return depth;
	}
	
	//returns the minimum path (calculated usin heuristic)
	public int getFVal() {
		return fVal;
	}
	
	//returns the mnattan distance of the grid from the previously passed goal state
	public int getManhat() {
		return manhatDist;
	}
	
	//sets the layer of the node
	public void setDepth(int d) {
		depth = d;
	}
	
	//calculates the manhattan distance
	public void setManhattan(Grid goal) {
		int[] configPos = new int[2];
		int[] goalPos = new int[2];
		
		//calculates distance for A block between current and goal states
		configPos = board.getPos('A');
		goalPos = goal.getPos('A');		
		manhatDist = manhatDist +  Math.abs(goalPos[0]-configPos[0]) + Math.abs(goalPos[1]-configPos[1]);

		//calculates distance for B block between current and goal states
		configPos = board.getPos('B');
		goalPos = goal.getPos('B');		
		manhatDist = manhatDist +  Math.abs(goalPos[0]-configPos[0]) + Math.abs(goalPos[1]-configPos[1]);

		//calculates distance for C block between current and goal states
		configPos = board.getPos('C');
		goalPos = goal.getPos('C');		
		manhatDist = manhatDist +  Math.abs(goalPos[0]-configPos[0]) + Math.abs(goalPos[1]-configPos[1]);

	}
	
	//calculates the evaluation function and stores in fVal
	public void setFval(Grid goal) {
		setManhattan(goal);
		fVal = 2*this.manhatDist + this.depth/2;
	}
	
	//finds all children for node and stores in children arraylist
	public void setChildren() {
		
		Grid leftChild = new Grid(board);
		leftChild.goLeft();
		if(leftChild.getConfig()!= null) {
			children.add(new Node(this,leftChild));
		}
		
		Grid rightChild = new Grid(board);
		rightChild.goRight();
		if(rightChild.getConfig()!= null) {
			children.add(new Node(this,rightChild));
		}
		
		Grid upChild = new Grid(board);
		upChild.goUp();
		if(upChild.getConfig()!= null) {
			children.add(new Node(this,upChild));
		}
		
		Grid downChild = new Grid(board);
		downChild.goDown();
		if(downChild.getConfig()!= null) {
			children.add(new Node(this,downChild));
		}		
		
		
	}
	
	
	//compares two nodes to check which has the lesser value for the heuristic
	@Override
	public int compareTo(Node prev) {
		if(this.fVal > prev.getFVal()) {
			return 1;
		} else if(this.fVal< prev.getFVal()){
			return -1;
		} else {
			return 0;
		}
	}

}
