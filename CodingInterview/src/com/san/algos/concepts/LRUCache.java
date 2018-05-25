package com.san.algos.concepts;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int k, int v){
            key = k;
            val = v;
        }
    }
    public int capacity;
    public Node priority;
    public Node end;
    public Map<Integer, Integer> data = new HashMap<Integer, Integer>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	int val = -1;
    	if(data.containsKey(key)){
            val = data.get(key);
            setPriority(key, val);    		
    	}
    	printNodes();
         return val;
    }
    
    public void printNodes(){
    	Node n = priority.next;
    	while(n != null){
    		System.out.print(n.val + " - ");
    		n = n.next;
    	}
    	System.out.println();
    }
    
    public void setPriority(int key, int val){
    	Node n = priority.next;
    	while(n != null && n != end){    		
    		if(n.key == key && n.val == val){
    			break;
    		}
    		n = n.next;
    	}
    	Node m = priority.next;
    	if(m != n){
    		priority.next = n;
    		n.prev = priority;
    		n.next = m;
    		m.prev = n;
    		m.next = end;
    		end.prev = m;
    	}
    	
    }
    
    public void put(int key, int value) 
    {
        Node n = new Node(key, value);
        if(priority == null){
            priority = new Node(-1, -1);
            end = new Node(-1,-1);
            priority.next = n;
            n.prev = priority;
            n.next = end;
            end.prev = n;
        }
        else{
        	Node next = priority.next;
            n.next = next;
            next.prev = n;
            priority.next = n;
            n.prev = priority;
        }
        data.put(key, value);        
        if(data.size() > capacity){
            Node m = end.prev;
            data.remove(m.key);
            
            if(m != null ){
                Node prev = m.prev;
                if(prev != null){
                    end.prev = prev;
                    prev.next = end;
                }
            }
            
        }
                
    }
    
    
    
    public static void main(String[] args)
    {
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(4));
    	//cache.get(1);       // returns -1 (not found)
    	//cache.get(3);       // returns 3
    	//cache.get(4);       // returns 4
    }
    
    
}

