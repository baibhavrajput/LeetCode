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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int loops = 0;
        ListNode curr = head;
        
        while(curr != null){
            loops++;
            curr = curr.next;
        }
        
        loops = loops/k;
        
        ListNode prevFirst = null;
        boolean isFirstPass = true;
        curr = head;
        int loopCount = 0;
        
        while(curr != null && loopCount < loops){
            
            ListNode prev = null;
            ListNode first = curr;
            int count = 0;
            
            while(curr != null && count < k){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            
            if(isFirstPass){
                isFirstPass = false;
                head = prev;
            }
            else{
                prevFirst.next = prev;
            }
            prevFirst = first;
            loopCount++;
        }
        prevFirst.next = curr;
        return head;
    }
}