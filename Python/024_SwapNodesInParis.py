# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        cur = dummy
        
        try:
            while True:
                pre, cur, nxt = cur, cur.next, cur.next.next
                pre.next, cur.next, nxt.next = nxt, nxt.next, cur
        except:
            return dummy.next