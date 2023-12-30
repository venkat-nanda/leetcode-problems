package com.problems.medium;
/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.



Example 1:

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:

Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]



Constraints:

    The number of nodes in the linked list is in the range [0, 104].
    -106 <= Node.val <= 106


 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        ListNode evenNodeHead = new ListNode();
        ListNode oddNodeHead = new ListNode();
        ListNode currentEvenNode = new ListNode();
        ListNode currentOddNode = new ListNode();
        evenNodeHead.next = currentEvenNode;
        oddNodeHead.next = currentOddNode;
        ListNode currentNode = head;
        int counter = 0;
        while(currentNode != null){
            if(counter == 0){
                currentEvenNode.next = currentNode;
                currentEvenNode = currentNode;
            } else if ( counter == 1){
                currentOddNode.next = currentNode;
                currentOddNode = currentNode;
            }
            else if (counter % 2 == 0){
                currentEvenNode.next = currentNode;
                currentEvenNode = currentNode;
            } else {
                currentOddNode.next = currentNode;
                currentOddNode = currentNode;
            }
            counter ++;
            currentNode = currentNode.next;
        }
        if(counter % 2 !=0){
            currentOddNode.next = null;
        }
        currentEvenNode.next = oddNodeHead.next.next;
        return evenNodeHead.next.next;
    }
}
