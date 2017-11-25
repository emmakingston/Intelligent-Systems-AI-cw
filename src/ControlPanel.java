import java.util.ArrayList;

public class ControlPanel {

	public static void main(String[] args) {
		
		ArrayList<int[]> blocked = new ArrayList<int[]>();
		blocked.add(new int[] {1,2});
		
		Grid goal = new Grid(4,1);
		
		Grid depth2 = new Grid(4,new int[]{2,1},new int[]{2,0},new int[]{3,1},new int[]{1,1});
		Grid depth4 = new Grid(4,new int[]{2,1},new int[]{2,0},new int[]{3,1},new int[]{2,2});
		Grid depth8 = new Grid(4,new int[]{3,1},new int[]{2,1},new int[]{3,2},new int[]{2,0});
		Grid depth12 = new Grid(4,new int[]{3,0},new int[]{3,1},new int[]{3,2},new int[]{2,2});
		Grid depth14 = new Grid(4,new int[]{3,0},new int[]{3,1},new int[]{3,2},new int[]{3,3});
		
		//Grid unmovable14 = new Grid(4,new int[]{3,0},new int[]{3,1},new int[]{3,2},new int[]{3,3}, blocked);
		//Grid unmovable = new Grid(4,new int[]{2,1},new int[]{2,0},new int[]{3,1},new int[]{2,2}, blocked);
		
		Grid start = depth12;
	
		//BFS breadthFirst = new BFS(goal,start);

		//DFS depthFirst = new DFS(goal,start);

		//IDFS itDepthFirst = new IDFS(goal,start);
		
		AStar astarsearch= new AStar(goal,start);
	}
	
}

//try {
//Thread.sleep(1000);                 //1000 milliseconds is one second.
//} catch(InterruptedException ex) {
//Thread.currentThread().interrupt();
//}	