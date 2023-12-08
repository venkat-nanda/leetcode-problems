package com.problems.easy;

import java.util.ArrayList;
import java.util.List;

/*
   Given a string s, reverse only all the vowels in the string and return it.

    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.



    Example 1:

    Input: s = "hello"
    Output: "holle"

    Example 2:

    Input: s = "leetcode"
    Output: "leotcede"



    Constraints:

        1 <= s.length <= 3 * 105
        s consist of printable ASCII characters.


 */
public class ReverseVowels {
    char[] vowels = new char[]{'a','e','i','o','u', 'A','E','I','O','U'};
    public String reverseVowels(String s) {
        List<Integer> vowelsIndex = new ArrayList<>();
        char[] strChars = s.toCharArray();
        for(int i=0; i< s.length() ; i++){
            if (isVowel(strChars[i])){
                vowelsIndex.add(i);
            }
        }
        int[] vArr = vowelsIndex.stream().mapToInt(i->i).toArray();
        reverseVowelsArr(vArr, strChars);
        return String.valueOf(strChars);
    }

    void reverseVowelsArr(int[] vowelsIndex, char[] strChars){
        int pointer1 = 0;
        int pointer2 = vowelsIndex.length - 1;

        while (pointer1 < pointer2){
            char tmp = strChars[vowelsIndex[pointer2]];
            strChars[vowelsIndex[pointer2]] = strChars[vowelsIndex[pointer1]];
            strChars[vowelsIndex[pointer1]] = tmp;
            pointer1++;
            pointer2--;
        }
    }

    boolean isVowel(char c){
        for (char vowel : vowels) {
            if (vowel == c) {
                return true;
            }
        }
        return false;
    }
}
