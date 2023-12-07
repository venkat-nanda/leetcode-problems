package com.problems.medium;


import java.math.BigInteger;
import java.util.Stack;


    public class AddTwoNumbersBrute {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> sl1 = new Stack();
            Stack<Integer> sl2 = new Stack();

            ListNode currentNode = l1;
            while (currentNode != null) {
                sl1.push(currentNode.val);
                currentNode = currentNode.next;
            }

            ListNode currentNode1 = l2;
            while (currentNode1 != null) {
                sl2.push(currentNode1.val);
                currentNode1 = currentNode1.next;
            }

            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();


            while (!sl1.empty()) {
                sb.append(sl1.pop());
            }

            while (!sl2.empty()) {
                sb1.append(sl2.pop());
            }

            BigInteger sum = new BigInteger(sb.toString()).add(new BigInteger(sb1.toString()));
            StringBuilder sbR = new StringBuilder();
            sbR.append(sum);
            String revValue = sbR.reverse().toString();
            System.out.println("reverse string is " + revValue);


            ListNode currentNodeX = new ListNode();
            ListNode firstNode = currentNodeX;
            for (int i = 0; i < revValue.length(); i++) {
                char currentChar = revValue.charAt(i);
                int digitValue = Character.getNumericValue(currentChar);
                currentNodeX.next = new ListNode(digitValue);
                currentNodeX = currentNodeX.next;
            }
            return firstNode.next;
        }
    }

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
