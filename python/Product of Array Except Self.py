# Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

# Solve it without division and in O(n).

# For example, given [1,2,3,4], return [24,12,8,6].

# Follow up:
# Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

# ouput[i] = left[i] * right[i]

# left[i] = a[0] * ... * a[i-1] , right[i] = a[i+1] * ... * a[n-1]

class Solution(object):
    def productExceptSelf(self, nums):
		if(nums == None):
			return ;
		size = len(nums);

		leftProduction = 1;

   		output = [1] * size;


	   	# left[i] , start with 1 , end with n-2
	   	for i in range(size - 1):
	   		print i
			leftProduction *= nums[i]; #leftProduction is the production of nums[i]
			output[i+1] *= leftProduction;

		print output

		rightProduction = 1;
		# right[i] , start with n-1 , end with 1
		for i in range(size - 1 , 0 , -1):
   			rightProduction *= nums[i]; 
   			output[i-1] *= rightProduction;

		return output;

s = Solution();
nums = [1,2,3,4];
print s.productExceptSelf(nums);
