package AlgoMaster.PrefixSum;
/*
        Given an integer array nums, handle multiple queries of the following type:

        Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
        Implement the NumArray class:

        NumArray(int[] nums) Initializes the object with the integer array nums.
        int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


        Example 1:

        Input
        ["NumArray", "sumRange", "sumRange", "sumRange"]
        [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
        Output
        [null, 1, -1, -3]

        Explanation
        NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
        numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
        numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
        numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3


        Constraints:

        1 <= nums.length <= 104
        -105 <= nums[i] <= 105
        0 <= left <= right < nums.length
        At most 104 calls will be made to sumRange.
 */
public class RangeSumQuery {
    int prefixSumArray[] ;
    public RangeSumQuery(int[] nums) {
        prefixSumArray = new int[nums.length];
        prefixSumArray[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSumArray[i]=prefixSumArray[i-1]+nums[i];
        }
    }
    public static void main(String[] args){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery rangeSumQuery = new RangeSumQuery(nums);
        System.out.println(rangeSumQuery.sumRange(0,2));
        System.out.println(rangeSumQuery.sumRange(2,5));
        System.out.println(rangeSumQuery.sumRange(0,5));
    }

    public int sumRange(int left, int right) {
        if(left<=0)
            return prefixSumArray[right];
        return prefixSumArray[right]-prefixSumArray[left-1];
    }
}
