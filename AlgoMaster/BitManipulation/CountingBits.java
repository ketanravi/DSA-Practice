package AlgoMaster.BitManipulation;
/*
        Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



        Example 1:

        Input: n = 2
        Output: [0,1,1]
        Explanation:
        0 --> 0
        1 --> 1
        2 --> 10
        Example 2:

        Input: n = 5
        Output: [0,1,1,2,1,2]
        Explanation:
        0 --> 0
        1 --> 1
        2 --> 10
        3 --> 11
        4 --> 100
        5 --> 101


        Constraints:

        0 <= n <= 105


        Follow up:

        It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
        Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
public class CountingBits {
    public static void main(String[] args){
        int n=5;
        int res[] = countBits(n);
        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }

    }
    public static int[] countBits(int n){
        int res[] = new int[n+1];
        res[0] = 0;
        for(int i=1;i<=n;i++){
            res[i] = res[i>>1]+(i & 1);// this will count ones in the binary representation
        }
        return res;
    }
}
