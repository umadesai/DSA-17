
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NQueensTest {
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5 and
     * you call checkDiagonal(board, 3, 1), the positions checked for an existing queen are:
     *
     * ....x
     * ...x.
     * x.x..
     * .....
     * .....
     *
     * Returns true if a Queen is found.
     */
    private static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }

    private void assertValidSolutions(List<char[][]> solutions, int expectedLength) {
        // check that all solutions are unique
        assertThat((new HashSet<>(solutions)).size(), is(solutions.size()));
        assertThat(solutions.size(), is(expectedLength));
        for (char[][] board : solutions)
            assertTrue(validBoard(board));
    }

    private boolean validBoard(char[][] board) {
        boolean[] usedRows = new boolean[board.length];
        boolean[] usedColumns = new boolean[board[0].length];
        int queens = Math.min(usedColumns.length, usedRows.length);
        for (int j = 0; j < usedRows.length; j++) {
            for (int i = 0; i < usedColumns.length; i++) {
                switch (board[j][i]) {
                    case '.':
                        break;
                    case 'Q':
                        queens--;
                        if (usedRows[j]) return false;
                        if (usedColumns[i]) return false;
                        if (checkDiagonal(board, j, i)) return false;
                        usedRows[j] = usedColumns[i] = true;
                        break;
                    default:
                        return false;
                }
            }
        }
        return queens == 0;
    }

    /**
     * Test method for {@link NQueensTest#validBoard(char[][])}.
     */
    @Test
    public void testValidBoard() {
        char[][] board = {{'.', 'Q', '.', '.'}, {'.', '.', '.', 'Q'}, {'Q', '.', '.', '.'}, {'.', '.', 'Q', '.'}};
        assertTrue(validBoard(board));
        board = new char[][]{{'.', '.', 'Q', '.'}, {'Q', '.', '.', '.'}, {'.', '.', '.', 'Q'}, {'.', 'Q', '.', '.'}};
        assertTrue(validBoard(board));
        board = new char[][]{{'.', '.', 'Q', '.'}, {'.', 'Q', '.', '.'}, {'.', '.', '.', 'Q'}, {'.', 'Q', '.', '.'}};
        assertFalse(validBoard(board));
        board = new char[][]{{'.', '.', 'Q', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', 'Q'}, {'.', 'Q', '.', '.'}};
        assertFalse(validBoard(board));
        board = new char[][]{{'.', '.', 'Q', '.'}, {'.', 'Q', '.', '.'}, {'Q', '.', '.', '.'}, {'.', '.', '.', 'Q'}};
        assertFalse(validBoard(board));
    }

    /**
     * Test method for {@link NQueens#checkDiagonal(char[][], int, int)}.
     */
    @Test
    public void testCheckDiagonal() {
        char[][] board = {{'Q', '.', '.', '.'}, {'.', '.', 'Q', '.'}, {'.', '.', '.', 'Q'}, {'.', 'Q', '.', '.'}};
        assertTrue(checkDiagonal(board, 2, 3));
    }


    /**
     * Test method for {@link NQueens#nQueensSolutions(int)}.
     */
    @Test
    public void testNQueensSolution() {
        assertValidSolutions(NQueens.nQueensSolutions(4), 2);
        assertValidSolutions(NQueens.nQueensSolutions(8), 92);
        assertValidSolutions(NQueens.nQueensSolutions(12), 14200);
    }


}