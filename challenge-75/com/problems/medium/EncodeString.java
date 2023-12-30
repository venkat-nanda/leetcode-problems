package com.problems.medium;

import java.util.Stack;

public class EncodeString {
    public String decodeString(String input) {
        char[] charArray = input.toCharArray();
        Stack<Character> charStack = new Stack<>();

        for (char currentChar : charArray) {
            if (currentChar != ']') {
                charStack.push(currentChar);
            } else {
                processStack(charStack);
            }
        }

        char[] reversedArray = new char[charStack.size()];

        for (int j = charStack.size() - 1; j >= 0; j--) {
            reversedArray[j] = charStack.pop();
        }

        return String.valueOf(reversedArray);
    }

    void processStack(Stack<Character> charStack) {
        char currentChar = charStack.pop();
        StringBuilder charSequence = new StringBuilder();

        while (currentChar != '[') {
            charSequence.append(currentChar);
            currentChar = charStack.pop();
        }

        StringBuilder digitSequence = new StringBuilder();

        while (!charStack.isEmpty() && Character.isDigit(charStack.peek())) {
            digitSequence.append(charStack.pop());
        }

        int repeatCount = Integer.parseInt(digitSequence.reverse().toString());
        StringBuilder result = new StringBuilder();

        result.append(String.valueOf(charSequence).repeat(Math.max(0, repeatCount)));

        for (char reversedChar : result.reverse().toString().toCharArray()) {
            charStack.push(reversedChar);
        }
    }
}
