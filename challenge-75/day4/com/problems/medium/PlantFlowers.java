package com.problems.medium;

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
