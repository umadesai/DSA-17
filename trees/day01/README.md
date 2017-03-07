# HW 12 - AVL Trees
[Slides](https://docs.google.com/presentation/d/1rdhKS1TZVIi0tCMRjXQo8lzQs3qN9h_olgA3YkW3BoQ) - includes link to a very slick AVL tree visualization that you can play with (last slide).

## Due Date
Friday, March 10th, 5 PM (by the end of class). This is the last assigned homework before spring break.

## Code

### Changes

- We have already provided you a solution for the last hw in `BinarySearchTree.java`.
- We have created a new class called `AVLTree`, which extends our BST class.
- `TreeNode` now keeps track of the height of the node, but we have not written any code to modify that field; this should be done in `AVLTree`.
- You should not have to modify `BinarySearchTree`.
- Parent pointers in the `TreeNode` class has been removed. This is to reduce work for you when performing rotations (fewer pointers changes).

### The new `delete` method

Given that parent pointers are now gone, `BST.delete` can no longer rely on `findSuccessor` or `findPredecessor`. We fixed that by writing a new method, `deleteMin(n)`, in `BST`, that we use to replace n with its right child's minimum (aka successor). We provide you with both `BST` and `AVL` versions of `deleteMin`. 

**Note: when a method is overridden in the subclass, code in the superclass will call the subclass' method, instead of the superclass' method of the same name.** So in this case, when the `BST` class calls `deleteMin`, it will call the `AVL` version, instead of its own.

### Helper methods (we suggest you do these first)
 * `height(TreeNode<T> n)`
 * `rotateRight(TreeNode<T> n)`.
 * `rotateLeft(TreeNode<T> n)`.
 * `balanceFactor(TreeNode<T> n)` Return the balance factor of the node `n`. Recall its definition from lecture/slides.
 * `balance(TreeNode<T> n)` Balance the tree rooted at `n`. This function should be similar to the one discussed in lecture.

### Tested methods
 * `insert(TreeNode<T> n, T key)` Insert an element into the tree rooted at `n`, maintaining balance.
 * `delete(TreeNode<T> n, T key)` Delete an element from the tree rooted at `n`, maintaining balance.

Run corresponding tests in `AVLTreeTest.java` to make sure your implementations are correct.

**What is the worst case runtime of `insert` and `delete`?.**