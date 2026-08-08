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
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node newHead = new Node(head.val);

        Node oldTemp = head.next;
        Node newTemp = newHead;

        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);

        while(oldTemp != null){
            Node newNode = new Node(oldTemp.val);
            newTemp.next = newNode;

            map.put(oldTemp, newNode);
            
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        oldTemp = head;
        newTemp = newHead;

        while(oldTemp != null){
            if(oldTemp.random != null){
                newTemp.random = map.get(oldTemp.random);
            }
            else{
                newTemp.random = null;
            }

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}
