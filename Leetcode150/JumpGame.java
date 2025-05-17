package Leetcode150;
/*
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.



    Example 1:

    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:

    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


    Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 105
 */
public class JumpGame {
    public static void main(String[] args){
        int nums[] = {2,1,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums)
    {
        int maxJump = 0;
        for(int i=0;i<nums.length;i++){
            if(maxJump>nums.length)
                return true;
            if(i>maxJump)// if we reached last in loop and still maxJump is less than i, then we can't reach last index
                return false;
            maxJump = Math.max(maxJump,i+nums[i]); // max we can jump from current index
        }
        return true;
    }
}
