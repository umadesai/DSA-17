# Introduction to Dynamic Programming

If you want a refresher on today's lecture, check out this [MIT lecture](https://www.youtube.com/watch?v=OQ5jsbhAv_M) and accompanying [notes](https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec19.pdf), which also goes over a brief introduction to dynamic programming. Additionally, we highly recommend [this](https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/) dynammic programming tutorial.

For this homework, we have included the general DP template, but do not feel compelled to use if you would rather not.

*Note: It is not guaranteed that all of these problems' optimal solutions require Dynamic Programming. It is up to you to determine if you should use DP in your solution(s)*

## Bills

We want to make change for `N` dollars. GIven the denominations of all dollar bills, what is the least number of bills you need to make `N` dollars? For example, if you want to make 49 dollars using 1, 15, and 25 dollar bills, the answer is 7 (15, 15, 15, 1, 1, 1, 1).

## Splitting coins

Katie has a stack of coins and would like to split them up as evenly as possible with David. She is given a set of `N` coins. Each of these coins has a given value. She must place each of these coins in one of two piles. Output the smallest possible difference between the total values of these two piles. 

You are given
* `coins`, an array of all the coins Katie must split

You will be filling out the function `public int splitCoins(int[] coins)` in `Coins.java` and run tests in `CoinsTest.java`

For example, if she had the coins `{3,1,1,2,5,7}`, she can try to split them up into `{3,5}` and `{1,1,2,7}` and the difference between these two piles would be `3`, (note that this is not the best possible splitting; the best answer is `1`).

## Making Profit

The Abrahams Merry Milk Makers company is interested in making money by investing in the milk stock exchange. You are given the price of the milk stock as a list of integers in an array. Each element in the array represents the price of the stock for that day. You must buy the stock exactly once and sell the stock (after buying it) exactly once. What is the maximum profit you can make?

You are given

* `prices`, an array of the prices of the stock per day.

You will be filling out the function `public int maxProfit(int[] prices)` in `Stocks.java` and run tests in `StocksTest.java`

For example, you are given the array of prices `[5,8,1,2,6,8,7]`. If you bought on day 0 (for 5 dollars) and sold on day 4 (for 6 dollars), you would make a profit of 1 dollar. The optimal solution here is to buy on day 2 and sell on day 5 for a profit of 7 dollars.

You can buy and then sell a stock on the same day, so your function should never return a negative number.

### Optional Extension - Making Profit 2

How would you modify your algorithm in the previous problem if you are allowed to make `k` total transactions? (You cannot hold onto more than one of the stock and you cannot buy more than one stock at a time). Buying and then selling a stock counts as 1 transaction.

You will be filling out the function `public int maxProfitWithK(int[] prices, int k)` in `Stocks.java` and run tests in `StocksTest.java`

For example, you are given the array of prices `[5,8,1,2,6,8,7]` and `k=2`. You can buy on day 0 and sell on day 1 for a profit of 3, and then buy on day 2 and sell on day 5 for a profit of 7, yielding an overall profit of 10.
