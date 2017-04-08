/**
 * Test for 8 Puzzle functionality
 */

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class PuzzleTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        int[][] initState = {{1, 2, 3}, {4, 6, 0}, {7, 5, 8}};
        board = new Board(initState);
    }

    // Test board methods

    /**
     * Test method for void manhattan().
     */
    @Test
    public void testManhattan() {
        assertThat(board.manhattan(), is(3));
    }

    /**
     * Test method for boolean isGoal().
     */
    @Test
    public void testGoal() {
        assertThat(board.isGoal(), is(false));
    }

    // Test solver with several initial board states

    /**
     * Test method for Solver - Unsolvable puzzle
     */
    @Test
    public void testSolverUnsolvable() {
        // Unsolvable puzzle
        int[][] initState = {{1, 0, 3}, {2, 4, 5}, {6, 7, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(false));
        solver = new Solver(new Board(new int[][]{{1, 8, 2},{0,4,3},{7,6,5}}));
        assertThat(solver.isSolvable(), is(true));
        solver = new Solver(new Board(new int[][]{{8, 1, 2},{0,4,3},{7,6,5}}));
        assertThat(solver.isSolvable(), is(false));
    }

    /**
     * Test method for Solver - Easy puzzle
     */
    @Test
    public void testSolverEasy() {
        // Easy solve puzzle
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Create solution boards list
        int solns[][][] = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}},
                {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}}};
        //Compare to output
        int i = 0;
        for (Board board : solver.solution()) {
            assertThat(board.tiles, is(solns[i]));
            i++;
        }
    }

    @Test
    public void testSolverMeh() {

        // Hard solve puzzle
        int[][] initState = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Check number of moves
        assertThat(solver.minMoves, is(4));
    }


    @Test
    public void testSolverMedium() {

        // Hard solve puzzle
        int[][] initState = {{2, 3, 6}, {1, 5, 0}, {4, 7, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Check number of moves
        assertThat(solver.minMoves, is(7));
    }

    @Test
    public void testSolverHard() {

        // Hard solve puzzle
        int[][] initState = {{0, 3, 5}, {2, 1, 8}, {4, 7, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Check number of moves
        assertThat(solver.minMoves, is(12));
    }

    @Test
    public void testSolverReallyHard() {

        // Hard solve puzzle
        int[][] initState = {{3, 5, 6}, {1, 2, 8}, {0, 4, 7}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Check number of moves
        assertThat(solver.minMoves, is(16));
    }


    @Test
    public void testSolverSuperDuperHard() {

        // Hard solve puzzle
        int[][] initState = {{3, 5, 2}, {6, 0, 1}, {7, 8, 4}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Check number of moves
        assertThat(solver.minMoves, is(22));
    }

    /**
     * Test method for Solver - Hard puzzle
     */
    @Test
    public void testSolverInsane() {

        // Hard solve puzzle
        int[][] initState = {{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Check number of moves
        assertThat(solver.minMoves, is(31));
    }

}
