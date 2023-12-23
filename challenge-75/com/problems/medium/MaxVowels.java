package com.problems.medium;

/*
    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

    Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



    Example 1:

    Input: s = "abciiidef", k = 3
    Output: 3
    Explanation: The substring "iii" contains 3 vowel letters.

    Example 2:

    Input: s = "aeiou", k = 2
    Output: 2
    Explanation: Any substring of length 2 contains 2 vowels.

    Example 3:

    Input: s = "leetcode", k = 3
    Output: 2
    Explanation: "lee", "eet" and "ode" contain 2 vowels.



    Constraints:

        1 <= s.length <= 105
        s consists of lowercase English letters.
        1 <= k <= s.length


 */
public class MaxVowels {

    int isVowel(char c){
        return c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }

    public int maxVowels(String s, int k) {

        int max_count = 0;
        char[] charArr = s.toCharArray();

        for (int i=0; i< k ; i++){
            max_count += isVowel(charArr[i]);
        }

        int window_count = max_count;

        for(int i =k ; i< charArr.length; i++){
            window_count = window_count - isVowel(charArr[i-k]) + isVowel(charArr[i]);
            max_count = Math.max(window_count, max_count);
        }

        return max_count;
    }

}
