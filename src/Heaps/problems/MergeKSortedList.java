package Heaps.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        ListNode l3=new ListNode(2);
        l3.next=new ListNode(6);

        ListNode[] lists={l1,l2,l3};
        ListNode mergedList=mergeKLists(lists);
        while(mergedList!=null){
            System.out.print(mergedList.val+" ");
            mergedList=mergedList.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode list:lists){
            if(list!=null){
                minHeap.add(list);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;
        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();
            current.next=node;
            current=current.next;
            if(node.next!=null){
                minHeap.add(node.next);
            }
        }
        return dummy.next;

    }
}
