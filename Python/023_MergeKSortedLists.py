# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if len(lists) == 0:
            return None
            
        if len(lists) == 1:
            return lists[0]
            
        mid = len(lists) // 2
        left = self.mergeKLists(lists[:mid])
        right = self.mergeKLists(lists[mid:])
        #merge left and right
        dummy = ListNode(0)
        cur = dummy
        while left or right:
            if right == None or (left and left.val < right.val):
                cur.next = left
                left = left.next
            else:
                cur.next = right
                right = right.next
            cur = cur.next
            
        return dummy.next