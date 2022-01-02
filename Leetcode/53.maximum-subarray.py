#
# @lc app=leetcode id=53 lang=python3
#
# [53] Maximum Subarray
#

# @lc code=start


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        gmax = nums[0]
        lmax = nums[0]
        for i in range(1, len(nums)):
            lmax = max(nums[i], lmax + nums[i])
            gmax = max(gmax, lmax)
        return gmax
# @lc code=end
