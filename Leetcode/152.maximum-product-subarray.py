#
# @lc app=leetcode id=152 lang=python
#
# [152] Maximum Product Subarray
#

# @lc code=start


class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        currMax, currMin = 1, 1
        result = nums[0]

        for val in nums:
            vals = (val, val*currMax, val * currMin)
            currMax, currMin = max(vals), min(vals)

            result = max(result, currMax)

        return result

# @lc code=end
