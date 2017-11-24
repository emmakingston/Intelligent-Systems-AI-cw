import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
	
	//R represents row, C represents column	
	private char[][] config;
	private int size;
	private int agentR;
	private int agentC;
	
	private int aR;			//these are used when creating a goal grid to notate positions ABC 
	private int aC;
	private int bR;
	private int bC;
	private int cR;
	private int cC;
	
	//creates goal grid with A B C in specified column, stacked from bottom of board
	//goal grids will have A,B,C defined
	public Grid(int gridSize, int blockCol) {
		
		size = gridSize;		
		config = new char[size][size];
		
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				config[i][j] = 'x';
				
			}			
		}
		
		config[size-3][blockCol] = 'A';
		config[size-2][blockCol] = 'B';
		config[size-1][blockCol] = 'C';
		
		
	}
	
	//creates initial grid
	//passes positions of A,B,C and agent blocks
	public Grid(int gridSize, int[] a, int[] b, int[] c, int[] agent) {
		
		size = gridSize;
		agentR = agent[0];
		agentC = agent[1];
		
		config = new char[size][size];
		
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				config[i][j] = 'x';
				
			}			
		}
		
		//sets position of blocks and agent
		config[a[0]][a[1]] = 'A';
		config[b[0]][b[1]] = 'B';
		config[c[0]][c[1]] = 'C';
		config[agentR][agentC] = 'N';		
		
	}
	
	//creates initial grid (with unmovables)
	//passes position of A,B,C and agent blocks
	//passes array of unmovable blocks
	public Grid(int gridSize, int[] a, int[] b, int[] c, int[] agent, ArrayList<int[]> unmovable) {
		
		size = gridSize;
		agentR = agent[0];
		agentC = agent[1];
		
		config = new char[size][size];
		
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				config[i][j] = 'x';
				
			}			
		}
		
		for(int[] n:unmovable) {
			config[n[0]][n[1]] = 'O';
		}
		
		//sets position of blocks and agent
		config[a[0]][a[1]] = 'A';
		config[b[0]][b[1]] = 'B';
		config[c[0]][c[1]] = 'C';
		config[agentR][agentC] = 'N';		
		
	}
	
	//creates a duplicate of the grid
	public Grid(Grid old) {
		
		size = old.getConfig().length;
		agentR = old.getR();
		agentC = old.getC();
		config = new char[size][size];
		
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				config[i][j] = old.getConfig()[i][j];
				
			}			
		}		
		
	}
	
	//outputs grid to console
	public void print() {
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				System.out.print(config[i][j]);
				
			}			
			System.out.println();
		}	
	}
	
	//compares grid to given grid (i.e. compare to goal)
	//converts the agent to 'x' (i.e. non block character)
	public Boolean compareTo(Grid goal) {
		
		config[agentR][agentC] = 'x';
		
		if(Arrays.deepEquals(goal.getConfig(), this.config)) {
			return true;
		} else {
			config[agentR][agentC] = 'N';
			return false;
		}
		
	}
		
	//gets the position of the character in the grid
	public int[] getPos(char find) {
		int[] pos = new int[2];
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(config[i][j]==find) {
					pos[0]=i;
					pos[1]=j;
					return pos;
				}
			}
		}
		return null;
	}
	
	
	//returns row of agent
	public int getR() {
		return agentR;
	}
	
	//returns column of agent
	public int getC() {
		return agentC;
	}
	
	//returns configuration of board
	public char[][] getConfig(){
		return config;
	}
	
	//moves agent left assuming its not in LH column
	public void goLeft() {
		if(agentC != 0) {
			char toSwap = config[agentR][agentC-1];
			config[agentR][agentC - 1] = 'N';
			config[agentR][agentC] = toSwap;
			
			agentC = agentC - 1;
		} else {
			config = null;
		}
	}
	
	//moves agent right, if not in RH column
	public void goRight() {
		if(agentC != size - 1) {
			char toSwap = config[agentR][agentC+1];
			config[agentR][agentC+1] = 'N';
			config[agentR][agentC] = toSwap;
			
			agentC = agentC+1;
		} else {
			config = null;
		}
	}
	
	//moves agent up, if not in top row
	public void goUp() {
		if(agentR != 0) {
			char toSwap = config[agentR-1][agentC];
			config[agentR-1][agentC] = 'N';
			config[agentR][agentC] = toSwap;
			
			agentR = agentR-1;
		} else {
			config = null;
		}
	}
	
	//moves agent down, if not in bottom row
	public void goDown() {
		if(agentR != size-1) {
			char toSwap = config[agentR+1][agentC];
			config[agentR+1][agentC] = 'N';
			config[agentR][agentC] = toSwap;
			
			agentR = agentR+1;
		} else {
			config = null;
		}
	}
	
}
