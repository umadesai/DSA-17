import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProblemsTest {

    private TreeNode<Integer> isomorphic1;
    private TreeNode<Integer> isomorphic2;
    private TreeNode<Integer> notisomorphic;

    @Before
    public void setUp() throws Exception {
        isomorphic1 = TreeUtils.generateTree(new Integer[]{10, 6, 5, 1, 2, 3, 9, null, null, null, null, null, null, 2, 1});
        isomorphic2 = TreeUtils.generateTree(new Integer[]{10, 5, 6, 3, 9, 2, 1, null, null, 1, 2, null, null, null, null});
        notisomorphic = TreeUtils.generateTree(new Integer[]{10, 9, 6, 3, 5, 2, 1, null, null, 1, 2, null, null, null, null});
    }

    @Test
    public void testMinimalHeight() {
        List<Integer> input = new ArrayList<>();
        populateInput(input, new Integer[]{10});
        BinarySearchTree<Integer> bst = Problems.minimalHeight(input);
        assertThat(TreeUtils.getMaxHeight(bst.root, 0), is(0));

        populateInput(input, new Integer[]{5,0,4,2,3,1});
        bst = Problems.minimalHeight(input);
        assertThat(TreeUtils.getMaxHeight(bst.root, 0), is(2));

        populateInput(input, new Integer[] {1,2,3,4,5,6,7,8,9,10});
        bst = Problems.minimalHeight(input);
        assertThat(TreeUtils.getMaxHeight(bst.root, 0), is(3));
    }

    @Test
    public void testIsomorphic() {
        assertTrue(Problems.isIsomorphic(isomorphic1, isomorphic2));
        assertTrue(Problems.isIsomorphic(isomorphic2, isomorphic1));
        assertFalse(Problems.isIsomorphic(isomorphic2, notisomorphic));
        assertFalse(Problems.isIsomorphic(notisomorphic, isomorphic1));
        assertFalse(Problems.isIsomorphic(isomorphic1, notisomorphic));
        assertFalse(Problems.isIsomorphic(notisomorphic, isomorphic2));
    }

    private void populateInput(List<Integer> A, Integer[] values) {
        A.clear();
        for (int i : values)
            A.add(i);
    }
}
