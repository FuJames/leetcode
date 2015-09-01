# Say you have an array for which the ith element is the price of a given stock on day i.

# Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


class Solution(object):
    def maxProfit(self, prices):
		if(prices == None or len(prices) == 0):
			return 0
		temp = 0
		profit = 0
		for i in range(0,len(prices) - 1):
			if(prices[i+1] > prices[i]):
				temp += prices[i+1] - prices[i]
			elif(prices[i+1] < prices[i]):
				profit += temp
				temp = 0
		profit += temp
		return profit



s = Solution()
list1 = [1,9,1,9,1,9,1]
print s.maxProfit(list1)