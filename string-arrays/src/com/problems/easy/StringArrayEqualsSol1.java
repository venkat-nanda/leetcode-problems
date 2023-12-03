package com.problems.easy;
/*
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

    A string is represented by an array if the array elements concatenated in order forms the string.



    Example 1:

    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
    Output: true
    Explanation:
    word1 represents string "ab" + "c" -> "abc"
    word2 represents string "a" + "bc" -> "abc"
    The strings are the same, so return true.

    Example 2:

    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
    Output: false

    Example 3:

    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
    Output: true
 */
public class StringArrayEqualsSol1 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int wordPoitner2 = 0;
        int stringPointer = 0, stringPointer2 = 0;

        for (String s : word1) {
            stringPointer = 0;
            while (stringPointer < s.length()) {
                if (wordPoitner2 < word2.length) {
                    if (s.charAt(stringPointer) != word2[wordPoitner2].charAt(stringPointer2)) {
                        return false;
                    }
                    stringPointer++;
                    stringPointer2++;
                    if (stringPointer2 >= word2[wordPoitner2].length()) {
                        stringPointer2 = 0;
                        wordPoitner2++;
                    }
                } else {
                    return false;
                }
            }
        }
        return wordPoitner2 >= word2.length || stringPointer2 >= word2[wordPoitner2].length();
    }
}
