# Graphs day03 - 8 puzzle

This homework is due **Thursday (April 6) at midnight**.

Create the necessary classes to implement an 8-puzzle solver.  If you need a reminder of the puzzle details or any of the solve methods that we talked about in class, refer back to the Graphs day03 powerpoint in the Drive.

A very basic set of tests has been provided, but it is up to you to create any other intermediary tests that may be necessary.  For example, it would be a good idea to confirm that your `neighbors()` method in `Board` generates a complete and valid set of neighbors. 

## Step 1:

Fill in the class `Board.java`.  An object of the Board class represents a state of the puzzle board.  It should have the following structure.  Some of these methods have been completed for you.

Constructor:
- `Board(int[][] b)`, creates an 8 Puzzle board state with the tiles 1-8 and a zero for the empty space from the 3x3 2D array input.  The board state is stored in an array named `tiles`.

Methods to Complete:
- `int size()`, returns the board side size, for the 8-puzzle this is 3
- `int manhattan()`, returns the sum of the Manhattan distances between the tiles and the goal, this is the estimated cost from the current state to the goal for A*, refer to the lecture notes if you need a reminder of how to calculate this
- `boolean isGoal()`, returns true if the board state is the solved puzzle
- `boolean equals(Board y)`, returns true if the board equals an input Board object
- `Iterable<Board> neighbors()`, generates and returns the neighbor boards in the tree
- `void printBoard()`, prints out the board state 2D array nicely for debugging
- `boolean solvable()`, returns true if the board is in a solvable configuration, there are several possible solutions here, you will need to research what conditions make a board unsolvable
- Plus: whatever helper methods you need to make your code readable

## Step 2:

Fill in the class `Solver.java`. that represents the state tree and game solver for the puzzle board.  It should have the following structure.  Some of these methods have been completed for you.

Constructor:
- `Solver(Board initState)`, finds a solution to an intial 8 puzzle board state using A Star

Nested Class `State`:
- State class makes the cost calculations and board attributes simple to store
- `public int compareTo(State s)`, returns the cost difference between self and a given state

Methods:
- `private State root(State state)`, returns the root state of a given state
- `boolean isSolvable()`, returns false if the board is determined to be unsolvable
- `Iterable<Board> solution()`, returns the sequence of boards in a shortest solution, returns null if unsolvable
- Plus: whatever helper methods you need to make your code readable

## Optional

As a challenge, you can add optional features to your solver such as a command line interaction for users to input game states that they want solutions for.  If you want to try other search algorithms, you could also implement a Dijkstra version of the Solver and compare the performance.
