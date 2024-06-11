package Queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Node
{
    int key,value;
    Node prev=null,next=null;
    int  frequency;
    Node(int key,int value)
    {
        frequency=1;
        this.key=key;
        this.value=value;
    }

}
public class LRUCache {

    /*
    @methods get(key),set(key,value)
    @returns value , set value
    @ capacity given
    Two cases to remember
    1) get returns either value or -1
    2) For set
        i) if map size equals capacity then just remove last node
        i) if map contains key already then jus remove that node
        then insert new node
     */


        //Constructor for initializing the cache capacity with the given value.
        static Node head,tail;
        static HashMap<Integer,Node> map;
        static  int capacity;
        LRUCache(int cap)
        {
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            map=new HashMap<>();
            tail.prev=head;
            capacity=cap;
        }

        public static void insert(Node node)
        {
            map.put(node.key,node);
            node.next=head.next;
            head.next=node;
            node.next.prev=node;
            node.prev=head;
        }
        public static void remove(Node node)
        {
            map.remove(node.key);
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        //Function to return value corresponding to the key.
        public static int get(int key)
        {
            if(map.containsKey(key))
            {
                Node node =map.get(key);
                remove(node);
                insert(node);
                return node.value;
            }
            return -1;

        }

        //Function for storing key-value pair.
        public static void set(int key, int value)
        {
            if(map.containsKey(key))
            {
                remove(map.get(key));


            }
            if(map.size()==capacity)
            {
                remove(tail.prev);
            }
            Node newnode=new Node(key,value);
            insert(newnode);
        }
    }

