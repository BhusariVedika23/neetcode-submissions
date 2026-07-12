/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> hashMap = new HashMap<>();
    public Node copyRandomList(Node headnode) {
        if(headnode == null){
            return null;
        }
        if(hashMap.containsKey(headnode)){
            return hashMap.get(headnode);
        }
        Node copy = new Node(headnode.val);
        hashMap.put(headnode, copy);
        copy.next = copyRandomList(headnode.next);
        copy.random = hashMap.get(headnode.random);
        return copy;
    }
}
