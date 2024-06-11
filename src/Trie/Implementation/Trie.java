package Trie.Implementation;


class Node
{
    Node links[];
    boolean flag;
    Node ()
    {
        flag=false;
        links=new Node[26];
    }
    boolean containsKey(char c)
    {
        return links[c-'a']!=null;
    }
    void put(char c,Node node)
    {
        links[c-'a']=node;
    }
    Node get(char c)
    {
        return links[c-'a'];
    }
    void setEnd()
    {
        flag=true;
    }

}
public class Trie {
    public Node root=new Node();
    public void insert(String s)
    {
        Node temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))
            {
                temp.put(c,new Node());
            }
            temp=temp.get(c);
        }
        temp.setEnd();
    }
    public boolean isExist(String s)
    {
        Node temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))return false;
            temp=temp.get(c);
        }
        return temp.flag;
    }
    public boolean startsWith(String s)
    {
        Node temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))return false;
            temp=temp.get(c);
        }
        return true;
    }

}
