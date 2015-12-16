# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        cur = head
        number = 0
        
        while cur and number != k:
            cur = cur.next
            number += 1
        
        if number == k:
            cur = self.reverseKGroup(cur, k)
            
            while number >= 1:
                tmp = head.next
                head.next = cur
                cur = head
                head = tmp
                number -= 1
            
            head = cur
            
        return head;