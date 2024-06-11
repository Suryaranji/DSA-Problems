package Graphs.MinimumSpanningTree;

import java.util.Arrays;

public class DisjointSet {

    int parent[];
    int rank[];
    int size[];

    DisjointSet(int n)
    {
        parent=new int[n+1];
        for(int i=1;i<=n;i++)parent[i]=i;
        rank=new int[n+1];
        size=new int[n+1];
        Arrays.fill(size,1);
    }

    int findParent(int u)
    {
        //if the parent is same as the node which indicates that there  is no previous nodes hence it is top node
        if(u==parent[u])return u;
        //Doing Path compression means if there are any node which are going to  connect to component
        //then it ultimate parents is that node
        //eg 1-2-3 then 3 parent is 2 but ultimate parent is 1 hence  we assign that node as parent;
        return parent[u]=findParent(parent[u]);
    }
    public int connectByRank(int u,int v)
    {
        int parentu=findParent(u);
        int parentv=findParent(v);
        //find each parent if both of them having same parent then return parent node
        if(parentu==parentv)return parentu;
        //else connect smaller component to larger component
        if(rank[parentu]<rank[parentv])
        {
            parent[parentu]=parentv;
        }
        else if(rank[parentu]>rank[parentv])
        {
            parent[parentv]=parentu;
        }
        else
        {
            //if equal then increase parent rank by one
            parent[parentv]=parentu;
            rank[parentu]++;
        }
        return 0;
    }
    public boolean isConnect(int u,int v)
    {
        int parentu=findParent(u);
        int parentv=findParent(v);
        //find each parent if both of them having same parent then return parent node
        return parentu==parentv;
    }
    public int connectBySize(int u,int v)
    {
        int parentu=findParent(u);
        int parentv=findParent(v);
        //find each parent if both of them having same parent then return parent node
        if(parentu==parentv)return parentu;
        //else connect smaller component to larger component
        if(size[parentu]<size[parentv])
        {
            parent[parentu]=parentv;
            size[parentv]=+size[parentu];
        }
        else
        {
            //if equal then increase parent rank by one
            parent[parentv]=parentu;
            size[parentu]=+size[parentv];
        }
        return 0;
    }
    public void connectTwo(int u ,int v)
    {
        connectByRank(u,v);
        connectBySize(u,v);
    }

    public static void main(String[] args) {
        DisjointSet d=new DisjointSet(6);
        d.connectTwo(1,2);
        System.out.println(Arrays.toString(d.size));

        d.connectTwo(2,3);
        d.connectTwo(4,5);
        System.out.println(Arrays.toString(d.size));
        System.out.println(d.isConnect(4,1));
        d.connectTwo(5,6);
       d.connectTwo(6,1);
        System.out.println(Arrays.toString(d.size));

        System.out.println(d.isConnect(4,1));
        System.out.println(d.isConnect(2,5));
        System.out.println(d.isConnect(3,4));




    }

}
