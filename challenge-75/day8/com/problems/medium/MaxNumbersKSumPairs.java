package com.problems.medium;

import java.util.HashMap;
import java.util.Map;

/*
     You are given an integer array nums and an integer k.

    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

    Return the maximum number of operations you can perform on the array.



    Example 1:

    Input: nums = [1,2,3,4], k = 5
    Output: 2
    Explanation: Starting with nums = [1,2,3,4]:
    - Remove numbers 1 and 4, then nums = [2,3]
    - Remove numbers 2 and 3, then nums = []
    There are no more pairs that sum up to 5, hence a total of 2 operations.

    Example 2:

    Input: nums = [3,1,3,4,3], k = 6
    Output: 1
    Explanation: Starting with nums = [3,1,3,4,3]:
    - Remove the first two 3's, then nums = [1,4,3]
    There are no more pairs that sum up to 6, hence a total of 1 operation.



    Constraints:

        1 <= nums.length <= 105
        1 <= nums[i] <= 109
        1 <= k <= 109


 */
public class MaxNumbersKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> repetitionCount = new HashMap<>();
        for (int num : nums) {
            if (repetitionCount.containsKey(num)) {
                int count = repetitionCount.get(num);
                count += 1;
                repetitionCount.put(num, count);
            } else {
                repetitionCount.put(num, 1);
            }
        }

        int operationsCount = 0;
        for (int num : nums) {
            int keyToCheck = k - num;
            int keyToCheckCount = repetitionCount.getOrDefault(keyToCheck, 0);
            int numsCount = repetitionCount.getOrDefault(num, 0);

            if (keyToCheck == num) {
                if (keyToCheckCount > 1) {
                    operationsCount++;
                    repetitionCount.put(num, repetitionCount.get(num) - 1);
                    repetitionCount.put(keyToCheck, repetitionCount.get(keyToCheck) - 1);
                }
            } else {
                if (keyToCheckCount != 0 && numsCount != 0) {
                    operationsCount++;
                    repetitionCount.put(num, --numsCount);
                    repetitionCount.put(keyToCheck, repetitionCount.get(keyToCheck) - 1);
                }
            }
        }
        return operationsCount;
    }
}
