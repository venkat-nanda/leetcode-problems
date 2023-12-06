package com.problems.medium;

/*
    For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

    Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



    Example 1:

    Input: str1 = "ABCABC", str2 = "ABC"
    Output: "ABC"

    Example 2:

    Input: str1 = "ABABAB", str2 = "ABAB"
    Output: "AB"

    Example 3:

    Input: str1 = "LEET", str2 = "CODE"
    Output: ""



    Constraints:

        1 <= str1.length, str2.length <= 1000
        str1 and str2 consist of English uppercase letters.


 */

public class GCD {

    public String gcdOfStrings(String str1, String str2) {
        for (int i = str2.length(); i > 0; i--) {
            if (str1.contains(str2.subSequence(0, i))) {
               if (isDivisible(str1, str2.subSequence(0, i))
                        && isDivisible(str2, str2.subSequence(0, i))) {
                    return String.valueOf(str2.subSequence(0, i));
                }

            }
        }
        return "";
    }

    public boolean isDivisible(String mainString, CharSequence subSequence){
        if (mainString.contains(subSequence)) {
            int count = 1;
            StringBuilder sb = new StringBuilder(subSequence);
            while (count < (mainString.length() / subSequence.length())) {
                sb.append(subSequence);
                count++;
            }
            return sb.toString().equals(mainString);
        }
        return false;
    }
}
