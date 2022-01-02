#
# @lc app=leetcode id=217 lang=python3
#
# [217] Contains Duplicate
#

# @lc code=start


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # duplicate = {}
        # for num in nums:
        #     if num not in duplicate:
        #         duplicate[num] = 1
        #     else:
        #         return True
        # return False
        return len(nums) != len(set(nums))
# @lc code=end
