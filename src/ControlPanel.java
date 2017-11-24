
public class ControlPanel {

	public static void main(String[] args) {
//		Grid testGrid = new Grid(4, 0, 1, 2, 3, 3);
//		Grid testGoal = new Grid(4,1);
//		Grid compareGoal = new Grid(4,1);
		
		Grid goal = new Grid(4,1);
		Grid start = new Grid(4,3,3,3,0,1,2,3,3);
		
		Grid depth14 = new Grid(4,3,3,3,0,1,2,3,3);
		Grid depth12 = new Grid(4,3,3,3,0,1,2,2,2);
		Grid depth8 = new Grid(4,3,2,3,1,1,2,2,0);
		Grid depth4 = new Grid(4,2,2,3,1,0,1,2,2);
		Grid depth2 = new Grid(4,2,2,3,1,0,1,1,1);
		
		start.print();
		
		Node temp = new Node(start,0);
		temp.setFval(goal);
		System.out.println(temp.getManhat());
		
		//Grid start =  new Grid(4,3,3,3,0,1,2,0,2);
		
		//BFS breadthFirst = new BFS(goal,start);

		//DFS depthFirst = new DFS(goal,start);

		//IDFS itDepthFirst = new IDFS(goal,start);
		
		AStar astarsearch= new AStar(goal,start);
	}
	
}
