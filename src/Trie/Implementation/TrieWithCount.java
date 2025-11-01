package Trie.Implementation;


class CountNode
{
    CountNode links[];
    boolean flag;
    int exactCount;
    int prefixCount;
    CountNode()
    {
        flag=false;
        links=new CountNode[26];
        exactCount=0;
        prefixCount=1;
    }
    boolean containsKey(char c)
    {
        return links[c-'a']!=null;
    }
    void put(char c, CountNode node)
    {
        links[c-'a']=node;
    }
    CountNode get(char c)
    {
        return links[c-'a'];
    }
    void setEnd()
    {
        flag=true;
        exactCount++;
    }


}
public class TrieWithCount {
    public CountNode root=new CountNode();
    public void insert(String s)
    {
        CountNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))
            {
                temp.put(c,new CountNode());
            }else{
                temp.get(c).prefixCount++;
            }
            temp=temp.get(c);
        }
        temp.setEnd();
    }
    public boolean isExist(String s)
    {
        CountNode temp=root;
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
        CountNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))return false;
            temp=temp.get(c);
        }
        return true;
    }
    public int countWordsEqualTo(String s)
    {
        CountNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))return 0;
            temp=temp.get(c);
        }
        return temp.exactCount;
    }
    public int countWordsStartingWith(String s){
        CountNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))return 0;
            temp=temp.get(c);
        }
        return temp.prefixCount;
    }
    public int erase(String s)
    {
        if(!isExist(s))return 0;
        CountNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!temp.containsKey(c))return 0;
            temp=temp.get(c);
            temp.prefixCount--;
        }
        temp.exactCount--;
        if(temp.exactCount==0)temp.flag=false;
        return 1;
    }

    public static void main(String[] args) {
        TrieWithCount obj=new TrieWithCount();
        obj.insert("apple");
        System.out.println(obj.isExist("apple"));
        System.out.println(obj.isExist("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.isExist("app"));
        obj.insert("apple");
        System.out.println(obj.countWordsEqualTo("apple"));
        obj.insert("apple");
        System.out.println(obj.countWordsStartingWith("app"));

        obj.erase("apple");
        System.out.println(obj.countWordsEqualTo("apple"));
    }

}
