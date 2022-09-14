/**
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself. 
  Ex:
  2 --> 4 --> 3
  5 --> 6 --> 4
  o/p:
  7 --> 0 --> 8

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead= new ListNode(0);
        ListNode curr = dummyhead;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int x=(l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next= new ListNode(sum%10);
            curr=curr.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        return dummyhead.next;
    }
}
