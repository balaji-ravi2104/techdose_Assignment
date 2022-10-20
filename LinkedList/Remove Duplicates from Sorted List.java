class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null|| head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode itr=dummy;
        while(itr.next!=null && itr.next.next!=null)
        {
            if(itr.next.val==itr.next.next.val)
            {
                int var=itr.next.val;
                itr.next=itr.next.next;
            }
            else
            {
                itr=itr.next;
            }
        }
        return dummy.next;
        
    }
}
