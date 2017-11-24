# AI coursework
24/11/17 Emma Kingston

Coursework to explore various search methods (breadth first, depth first, iterative deepening, A*).
Task to move 'goal blocks' (A,B,C) with an agent (N) from some start configuration to a goal configuration.

Grid class- stores the board configuration and provides methods to move the agent around the board.
Node class- stores the reference to the grid, the parent and child nodes and calculates the heuristic for A* search.
Search classes- each class provides the necessary data structures and methods to perform each search. 