/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * http://cuisuqiang.iteye.com/blog/2019157 priorityQueue用法
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length,
                    new Comparator<ListNode>(){
                        public int compare(ListNode a, ListNode b) {
                            if (a.val > b.val) {
                                return 1;
                            } else if (a.val == b.val) {
                                return 0;
                            } else {
                                return -1;
                            }
                        }
                    }); 
        for (ListNode list : lists) {
            if (list != null) {
                q.add(list);
            }
        }  
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        while (q.size() > 0) {
            ListNode temp = q.poll();
            p.next = temp;
            if (temp.next != null) {
                q.add(temp.next);
            }
            p = p.next;
        }
        
        return head.next;
    }
}
