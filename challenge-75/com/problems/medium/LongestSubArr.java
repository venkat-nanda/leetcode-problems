package com.problems.medium;

/*
    Given a binary array nums, you should delete one element from it.

    Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.



    Example 1:

    Input: nums = [1,1,0,1]
    Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

    Example 2:

    Input: nums = [0,1,1,1,0,1,1,0,1]
    Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

    Example 3:

    Input: nums = [1,1,1]
    Output: 2
    Explanation: You must delete one element.



    Constraints:

        1 <= nums.length <= 105
        nums[i] is either 0 or 1.


 */
public class LongestSubArr {

    public int longestSubarray(int[] nums) {
        int l= 0, m = 0, c = 0;

        for( int i =0 ;i < nums.length; i++){
            if(nums[i] == 0){
                c++;
            }

            while( c > 1){
                if(nums[l] == 0){
                    c --;
                }
                l++;
            }
            m = Math.max(m, i - l + 1);
        }

        return m - 1;
    }

}
