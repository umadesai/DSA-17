# Graphs Day 02 - Recursive Backtracking

This homework is due on **Thursday (March 30) at midnight**.

## Permutations

Given a `List` of *unique* integers `A`, return all possible permutations of that list. For example, given `[1, 2, 3]`, return:

- [1, 2, 3]
- [1, 3, 2]
- [2, 1, 3]
- [2, 3, 1]
- [3, 1, 2]
- [3, 2, 1]

## N-Queens

Write a program that determines all possible configurations of N queens on an NxN chessboard such that no two of them attack each other. This means that no two queens can share a row, column, or diagonal. If you are confused regarding the rules of chess or how a queen can move, check out [this](https://www.chessusa.com/chess-rules.html) tutorial.

For example, here is one of the two 4-queens solutions:

![](https://developers.google.com/optimization/images/queens/sol_4x4_b.png)

Write your code in the `NQueens` class. Note that for the tests to pass, you will need to represent the chess-board as a `char[n][n]` - an NxN 2-D `char` array. Represent blank squares with a period: `'.'`, and queens with a capital `'Q'`.

## Coins on a Clock

You have a bag of coins, and you can place them on each hour on a clock. For each coin you put down, you advance its own value clockwise before placing the next coin. So if you place nickel on 12 o'clock, and you want to put down a penny, you place it on 5 o'clock. The game is won if you find a sequence of coin placements, starting at the top of the clock, that results in each hour being covered.

Write a program that, given a number of pennies, nickels, and dimes, as well as the number of hours in a day (you could have a clock with `10` at the top of the clock, and `1`-`9` around it), outputs all solutions to the coins on a clock puzzle. You can assume the total number of coins and hours in a day are equal.

Represent a solved clock using a `char[]`, where `'p', 'n', 'd'` are the coins. The top of the clock is at index `0` in the array.

For example, given 4 pennies, 4 nickles, and 4 dimes, and 12 hours in a day, one solution is:

`[p, d, n, p, p, n, d, p, d, n, n, d]`

- You first place a penny at 12 o'clock.
- You must put a coin at 1 o'clock, so you place a dime.
- You now must place a coin at 11 o'clock. You place another dime. (Note how placing a penny would cause you to lose, as there is already a coin at 12 o'clock)
- You are now at 9 o'clock. You place a nickel.
- At 2 o'clock, you place another nickel.
- Etc.
