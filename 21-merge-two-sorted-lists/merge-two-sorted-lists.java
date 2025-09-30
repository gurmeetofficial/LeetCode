/**
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode res, itr1, itr2;
        if(list1.val<list2.val) {
            res=list1;
            itr1=list1;
            itr2=list2;
        } else {
            res = list2;
            itr1 = list2;
            itr2 = list1;
        }
        while(itr2!=null) {
            if(itr1.next==null) {
                itr1.next=itr2;
                break;
            }
            if(itr1.next.val<=itr2.val) {
                itr1 = itr1.next;
            } else {
                ListNode temp = itr1.next;
                itr1.next=itr2;
                itr2=temp;
                itr1=itr1.next;
            }
        }
        return res;
    }
}