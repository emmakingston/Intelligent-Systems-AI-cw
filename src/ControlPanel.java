import java.util.ArrayList;

public class ControlPanel {

	public static void main(String[] args) {		
		//array list to store the immovable blocks
		ArrayList<int[]> blocked = new ArrayList<int[]>();	
		
		//default goal state
		Grid goal = new Grid(4,1);
		
		//grid configurations at varied depths
		Grid depth2 = new Grid(4,new int[]{2,1},new int[]{2,0},new int[]{3,1},new int[]{1,1});
		Grid depth4 = new Grid(4,new int[]{2,1},new int[]{2,0},new int[]{3,1},new int[]{2,2});
		Grid depth6 = new Grid(4,new int[]{2,1},new int[]{2,0},new int[]{3,2},new int[]{3,1});
		Grid depth8 = new Grid(4,new int[]{3,1},new int[]{2,1},new int[]{3,2},new int[]{2,0});
		Grid depth10 = new Grid(4,new int[]{3,0},new int[]{2,1},new int[]{3,2},new int[]{3,1});
		Grid depth12 = new Grid(4,new int[]{3,0},new int[]{3,1},new int[]{3,2},new int[]{2,2});
		Grid depth14 = new Grid(4,new int[]{3,0},new int[]{3,1},new int[]{3,2},new int[]{3,3});
		Grid depth15 = new Grid(4,new int[]{3,0},new int[]{3,1},new int[]{3,2},new int[]{0,3});
		
		//grid with immovable block
		blocked.add(new int[] {1,3});
		Grid unmovable14 = new Grid(4,new int[]{3,0},new int[]{3,1},new int[]{3,2},new int[]{3,3}, blocked);
		
		//sets the grid to be tested in this run
		Grid start = depth14;
	
		System.out.println("Start state:");
		start.print();
		System.out.println();
		
		System.out.println("Goal state");
		goal.print();
		System.out.println();
		
		System.out.println("Breadth first search: ");
		BFS breadthFirst = new BFS(goal,start);
		
		System.out.println("Depth-first search: ");
		DFS depthFirst = new DFS(goal,start);
		
		System.out.println("Iterative deepening search: ");
		IDFS itDepthFirst = new IDFS(goal,start);	
		
		System.out.println("A* search");
		AStar astarsearch= new AStar(goal,start);
	} 
	
}

//try {
//Thread.sleep(1000);                 //1000 milliseconds is one second.
//} catch(InterruptedException ex) {
//Thread.currentThread().interrupt();
//}	