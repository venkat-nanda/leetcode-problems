package com.problems.medium;
/*
 *   You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.



    Example 1:

    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: true

    Example 2:

    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: false



    Constraints:

        1 <= flowerbed.length <= 2 * 104
        flowerbed[i] is 0 or 1.
        There are no two adjacent flowers in flowerbed.
        0 <= n <= flowerbed.length

 */
public class PlantFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i= 0;
        while ( i < flowerbed.length - 1){
            boolean isPlanted = false;
            if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                //first element
                if (i ==0 ){
                    n--;
                    flowerbed[i] = 1;
                    isPlanted = true;
                } else if (i == flowerbed.length - 2) { //last element
                    n--;
                    flowerbed[i-1] = 1;
                    isPlanted = true;
                } else if (flowerbed[i - 1] != 1){ //previous element is not 1
                    n--;
                    flowerbed[i] = 1;
                    isPlanted = true;
                } else if ((i + 2 < flowerbed.length)&& flowerbed[i+2] != 1){// next element is not 1
                    n--;
                    flowerbed[i+1] = 1;
                    isPlanted = true;
                }
            }
            if(isPlanted && ((i+3) != flowerbed.length)){
                i = i+ 2;
            } else{
                i = i + 1;
            }
        }
        if ( flowerbed.length ==1 && flowerbed[i] == 0){
            n--;
        }
        return n <= 0;
    }
}
