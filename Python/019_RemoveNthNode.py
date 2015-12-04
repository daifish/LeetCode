# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        p, q = dummy, dummy
        
        for i in range(n):
            q = q.next
            
        while q.next:
            q = q.next
            p = p.next
        
        rec = p.next
        p.next = rec.next
        del rec
        return dummy.next