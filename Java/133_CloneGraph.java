/*************************************************************************
    > File Name: 133_CloneGraph.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 二 10/27 15:00:05 2015
 ************************************************************************/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        queue.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curnode = queue.poll();
            for (UndirectedGraphNode aneighbors : curnode.neighbors) {
                if (!hm.containsKey(aneighbors)) {
                    queue.add(aneighbors);
                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbors.label);
                    hm.put(aneighbors, newneighbor);
                }
                
                hm.get(curnode).neighbors.add(hm.get(aneighbors));
            }
        }
        
        return head;
    }
}
