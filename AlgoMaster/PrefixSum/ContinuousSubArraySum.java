package AlgoMaster.PrefixSum;

import java.util.HashMap;

/*
    Leetcode - 523. Continuous Subarray Sum

    Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

    A good subarray is a subarray where:

    its length is at least two, and
    the sum of the elements of the subarray is a multiple of k.
    Note that:

    A subarray is a contiguous part of the array.
    An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.


    Example 1:

    Input: nums = [23,2,4,6,7], k = 6
    Output: true
    Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
    Example 2:

    Input: nums = [23,2,6,4,7], k = 6
    Output: true
    Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
    42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
    Example 3:

    Input: nums = [23,2,6,4,7], k = 13
    Output: false


    Constraints:

    1 <= nums.length <= 105
    0 <= nums[i] <= 109
    0 <= sum(nums[i]) <= 231 - 1
    1 <= k <= 231 - 1
 */
public class ContinuousSubArraySum {
    public static void main(String[] args){
        int[] arr;
        arr = new int[]{0,0};
        int k = 7;
        System.out.println(isContinuousSubarraySumMultipleKExist(arr,k));
    }

    private static boolean isContinuousSubarraySumMultipleKExist(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int prefixSum=0;
        hmap.put(0,-1);// sum 0 with negative index for edge case |Initial heuristic to handle edge case
        for(int i=0; i< nums.length;i++){
            prefixSum+=nums[i];// Update the prefix sum with the current number
            // Compute remainder of the current cumulative sum
            int rem = prefixSum%k;

            // Handle negative remainders by converting them into a positive range [0,K-1]
            if(rem<0)
                rem+=k;

            // If we have seen this remainder before, then there exist sum divisble by k and also if size of subarray is greater than equal to 2 return true
            if(hmap.containsKey(rem)) {
               if((i-hmap.get(rem))>=2)
                   return true;
            }
            else
                hmap.put(rem,i); // first time encounter put it to map
        }
        return false;
    }
}
