package com.problems.medium;

/*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:

    Input: height = [1,1]
    Output: 1

 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = (height.length - 1) * Math.min(height[leftIndex],height[rightIndex]);
        for(int i=0; i < height.length; i++) {
            if(height[leftIndex] <= height[rightIndex]) {
                leftIndex++;

                int area = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex-leftIndex);
                if (area > maxArea) {
                    maxArea = area;
                }
            }else {
                int area = Math.min(height[leftIndex],height[rightIndex-1]) * (rightIndex-1-leftIndex);
                if (area > maxArea) {
                    maxArea = area;
                }
                rightIndex--;
            }

            if(rightIndex<=leftIndex) {
                break;
            }
        }
        return maxArea;

    }
}
