#
# @lc app=leetcode id=238 lang=python3
#
# [238] Product of Array Except Self
#

# @lc code=start


class Solution:

    def prefix_calc(self, nums):

        prefix_mult = []
        for i in range(len(nums)):
            if i == 0:
                prefix_mult.append(nums[i])
            else:
                prefix_mult.append(nums[i] * prefix_mult[i-1])

        return prefix_mult

    def suffix_calc(self, nums):
        suffix_mult = [None]*len(nums)

        for i in range(len(nums)-1, -1, -1):
            if i == len(nums)-1:
                suffix_mult[i] = nums[i]
            else:
                suffix_mult[i] = nums[i] * suffix_mult[i+1]

        return suffix_mult

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = self.prefix_calc(nums)
        suffix = self.suffix_calc(nums)

        result_arr = []

        for i in range(len(nums)):
            if i == 0:

                result_arr.append(suffix[i+1])
            elif i == len(nums)-1:
                result_arr.append(prefix[i-1])
            else:
                result_arr.append(suffix[i+1] * prefix[i-1])

        return result_arr
# @lc code=end
