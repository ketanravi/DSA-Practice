package AlgoMaster.TwoPointers;
/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int l=0,r=0;
        int zeroes = 0;
        int len = nums.length;
        int maxm=0, currLen=0;
        while(r<len){
            if(nums[r]==0)
                zeroes++;
            while(zeroes>k){
                if(nums[l]==0)
                    zeroes--;
                l++;
            }
            maxm = Math.max(r-l+1,maxm);
            r++;


        }
        return maxm;
    }
    // optimized
    public int longestOnesOptimized(int[] nums, int k) {
        int l=0,r=0;
        int zeroes = 0;
        int len = nums.length;
        int maxm=0, currLen=0;
        while(r<len){
            if(nums[r]==0)
                zeroes++;
            if(zeroes>k){
                if(nums[l]==0)
                    zeroes--;
                l++;
            }
            if(zeroes<=k){
                maxm = Math.max(r-l+1,maxm);
            }
            r++;


        }
        return maxm;
    }
    public static void main(String[] args){
        int[] nums = {1,1,0,1,1,1};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
}
