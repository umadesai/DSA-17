import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class LevelOrderTraversalTest {

    private TreeNode<Integer> n;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        n = new TreeNode<>(8);
        n.leftChild = new TreeNode<>(2);
        n.leftChild.rightChild = new TreeNode<>(3);
        n.leftChild.rightChild.leftChild = new TreeNode<>(8);
        n.leftChild.rightChild.rightChild = new TreeNode<>(10);


        n.rightChild = new TreeNode<>(6);
        n.rightChild.leftChild = new TreeNode<>(1);
        n.rightChild.leftChild.rightChild = new TreeNode<>(2);
    }


    /**
     * Test method for {@link LevelOrderTraversal#levelOrderTraversal(TreeNode)}.
     */
    @Test
    public void testLevelOrderTraversal() {
        List<Integer> traversal = LevelOrderTraversal.levelOrderTraversal(n);
        assertArrayEquals(traversal.toArray(), new Object[] {8, 2, 6, 3, 1, 8, 10, 2});
    }
}
