package leetcode;


/*
 * Use Doublely Linked List to store data. Why use doublely linked list?
 *  ans: it's very fast to add and delete nodes. O(1). 
 *  
 *  use HashMap to store key and associate data. 
 *  for linkedlist, we cannot random access the data, and the access of data is O(n), we can use HashMap to improve the access.
 *  
 *  
 */

import java.util.HashMap;

public class LRUCache {
    
    public class DoubleListNode{
        public int val;
        public int key;
        public DoubleListNode pre;
        public DoubleListNode next;
        
        public DoubleListNode(int key, int val){
            this.val = val;
            this.key = key;
            pre = null;
            next = null;
        }
    }
    
    HashMap<Integer, DoubleListNode> hash;
    DoubleListNode head;
    DoubleListNode end;
    int capacity;
    
    public LRUCache(int capacity) {
        hash = new HashMap<Integer, DoubleListNode>();
        head = end = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!hash.containsKey(key)) return -1;
        DoubleListNode node = hash.get(key);
        remove(node);
        set(key, node.val);
        return node.val;
    }
    
    public void set(int key, int value) {
        if(hash.containsKey(key)){
            DoubleListNode node = hash.get(key);
            remove(node);
        }
        DoubleListNode node = new DoubleListNode(key, value);
        if(head == null){
            head = end = node;
        }else{
            node.next = head;
            head.pre = node;
            head = node;
        }
        hash.put(key, node);
        clean();
    }
    
    public void clean(){
        if(hash.size() > capacity){
            DoubleListNode node = end;
            remove(node);
        }
    }
    
    public void remove(DoubleListNode node){
        if(node == head){
            if(head == end){
            	head = end = null;
            }else{
            	head = head.next;
            	head.pre = null;
            }
        }
           
        else if(node == end){
            end = node.pre;
            end.next = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        
        node.pre = node.next = null;
        hash.remove(node.key);
    }
}