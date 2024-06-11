package LinkedList;

public class ReorderList {
    Node reverse(Node head)
    {
        Node pre=null;
        while(head!=null)
        {
            Node temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }
    void reorderlist(Node head) {
        if(head==null||head.next==null)return;
        Node slow=head,fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        Node temp=slow.next;
        slow.next=null;
        Node second=reverse(temp);
        Node first=head;
        Node newnode=new Node(-1);
        temp=newnode;
        while(first!=null&&second!=null)
        {
            newnode.next=first;
            first=first.next;
            newnode=newnode.next;
            newnode.next=second;
            second=second.next;
            newnode=newnode.next;
        }
        if(second!=null)
        {
            first=second;
        }
        while(first!=null)
        {
            newnode.next=first;
            first=first.next;
        }

        head=newnode.next;
    }
}
