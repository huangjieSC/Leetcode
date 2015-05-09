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
        if(node==null) return node;
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        
        map.put(node,head);
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            for(UndirectedGraphNode neighbor: n.neighbors){
                if(!map.containsKey(neighbor)){
                    queue.add(neighbor);
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,neighborCopy);
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return head;
    }
}
