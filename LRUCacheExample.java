package JavaProgs;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    class Node {
        int key, value;
        Node next, prv;
        
        public Node() {
            this.next = this.prv = null;
        }
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = this.prv = null;
        }
    }
    int totalCapacity;
    int currentCapacity;
    Node sentinalHead;
    Node sentinalTail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.totalCapacity = capacity;
        this.currentCapacity = 0;
        map = new HashMap<>();
        sentinalHead = new Node(-1, -1);
        sentinalTail = new Node(-1, -1);
        sentinalHead.next = sentinalTail;
        sentinalHead.prv = sentinalHead;
    }
    
    public int get(int key) {
        if (keyExistsInCache(key)) {
            Node curr = getNodeFromHashTable(key);
            moveToFront(curr);
            return curr.value;
        }
        else {
            return -1;    
        }
    }
    
    public void put(int key, int value) {
       if (keyExistsInCache(key)) {
            Node curr = getNodeFromHashTable(key);
            curr.value = value;
            moveToFront(curr);
       }
       else {
           Node curr = new Node(key, value);
           insertNode(key, curr);
           if (this.currentCapacity > this.totalCapacity) {
               removeLRUNode(); //Decrease currentCapacity & Remove Node from Map and HashTable
           }
       } 
    }
    
    private boolean keyExistsInCache(int key) {
        return map.containsKey(key);
    }
    
    private Node getNodeFromHashTable(int key) {
        return map.get(key);
    }
    
    private void moveToFront(Node curr) {
        curr.prv.next = curr.next;
        curr.next.prv = curr.prv;
        curr.prv = sentinalHead;
        sentinalHead.next.prv = curr;
        curr.next = sentinalHead.next;
        sentinalHead.next = curr;
    }
    
    private void insertNode(int key, Node curr) {
        sentinalHead.next.prv = curr;
        curr.next = sentinalHead.next;
        curr.prv = sentinalHead;
        sentinalHead.next = curr;
        map.put(key, curr); //Add to Map
        this.currentCapacity += 1; //Increase currentCapacity
    }
    
    private void removeLRUNode() {
        map.remove(sentinalTail.prv.key);
        sentinalTail.prv.prv.next = sentinalTail;
        sentinalTail.prv = sentinalTail.prv.prv;
        this.currentCapacity -= 1;
        
    }
}

public class LRUCacheExample {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(2, 2);
        obj.get(2);
        obj.put(1, 1);
        obj.put(4, 1);
        obj.get(2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
