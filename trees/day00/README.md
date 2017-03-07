# HW 11 - Intro to Binary Search Trees

[Slides](https://docs.google.com/presentation/d/1oxx5K3J5ce0-ATQeH3Chetf9JKwT8XGGj1MgDo5Adu0/edit?usp=sharing) (super recommended) for review and problem hints.

## Code

1. Implement the following methods in `BinarySearchTree.java`:
  * `public List<T> inOrderTraversal()` Performs an in-order traversal of the tree
  * `public T findSuccessor(T key)` Finds the node immediately following `n` in the in-order traversal of the entire tree
  * `public T findPredecessor(T key)` Finds the node immediately preceding `n` in the in-order traversal of the entire tree
  Run corresponding tests in `BinarySearchTreeTest.java` to make sure your implementations are correct.

1. What is the worst case runtime of `inOrderTraversal`, `findSuccessor` and `findPredecessor`? (think carefully)

1. Handle the third case of the `delete` function. If you remember from lecture, there are 3 cases:

- Node has no children
- Node has one child
- Node has two children

## Visualization

1. Draw the binary search tree resulted from inserting the keys [20,10,15,12,18,11,14,16,19,13,17].

1. Explain to your NINJA the step by step process (by drawing) of these operations on your tree above, noting down all pointer changes at each step:
  * `delete(15)` then
  * `delete(10)` then
  * `delete(19)`

## Problems

6. Given an unsorted array, create a binary search tree with minimal height. Implement this in `Problems.minimalHeight`.

7. Two trees T1 and T2 are isomorphic if T1 can be transformed to T2 by swapping left and right children of (some of) the nodes in T1. Write a function that determines if two trees are isomorphic. You are given their root nodes. Implement this in `Problems.isIsomorphic`.
