package LinkedList;

class Node
{
    int data;
    Node  next;
    Node(int data)
    {
        this.data=data;
    }
}
public class SubtractTwoLinkedList {
  /*  //remove leading zeros
      reverse list
    //find greater linked list
       *if both are equal then move
       if some greater than make greater as that element
       if both are null at last indicates that same size then check greater element
       else send remaining elements list
    //subtracts
        * subtracts top with carry
        * if top data lesser than bottom data than
         then add 10 to that element make carry as 1;
        * if not then sub and make carry as 0
        * still elements left then check if it is lesser than carry than keep carry as it is make element as 9
        * else update carry as 0
     //reverse and remove any leading zeros
    */
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
    Node sub(Node head1,Node head2)
    {
        int tempcarry=0;
        Node newnode=new Node(-1);
        Node temp=newnode;

        while(head1!=null&&head2!=null)
        {
            //initially subtract with if any carry
            head1.data-=tempcarry;
            if(head1.data<head2.data)
            {
                //lesser than it should be subtracted with added 10
                int value=head1.data+10-head2.data;//11-2 then
                head1.data=value;
                tempcarry=1;

            }
            else
            {
                head1.data-=head2.data;
                tempcarry=0;
            }
            temp.next=head1;
            temp=head1;
            head1=head1.next;
            head2=head2.next;

        }
        //still there is any element left
        while(head1!=null)
        {
            //check if that head has 0 if so then keep carry as it is and subtract it with 10
            if(head1.data<tempcarry)
            {
                head1.data=10-tempcarry;
                tempcarry=1;
            }
            else
            {

                head1.data-=tempcarry;
                tempcarry=0;
            }
            temp.next=head1;
            temp=head1;
            head1=head1.next;

        }
        return newnode.next;
    }
    Node removeLeadingZeros(Node answer)
    {
        while(answer!=null&&answer.data==0)
        {
            answer=answer.next;
        }
        return answer;
    }
    public Node subLinkedList(Node head1, Node head2) {
        //remove leading zeros
        head1=removeLeadingZeros(head1);
        head1=reverse(head1);
        head2=removeLeadingZeros(head2);
        head2=reverse(head2);
        Node first=head1,second=head2;
        Node greater=null;
        //find greater linked list
        while(first!=null&&second!=null)
        {
            if(first.data==second.data)
            {
                first=first.next;
                second=second.next;
                continue;
            }
            else if(first.data<second.data)
            {
                greater=head2;
            }
            else
            {
                greater=head1;
            }
            first=first.next;
            second=second.next;
        }
        Node answer=null;
        //first not null then it should be greatest
        if(first!=null)
        {
            answer=sub(head1,head2);
        }
        else if(second!=null)
        {
            answer=sub(head2,head1);
        }
        else
        {
            if(greater==head1)answer=sub(head1,head2);
            else  answer=sub(head2,head1);
        }
        //reverse answer and remove leading zeros
        answer=reverse(answer);
        answer=removeLeadingZeros(answer);
        if(answer==null)
        {
            return new Node(0);
        }
        return answer;
    }
}
