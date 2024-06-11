package Graphs.MinimumSpanningTree;

import java.util.Arrays;

public class KruskalsAlgorithm {
    static int connectByRank(int u,int v,int rank[],int parent[])
    {
        int parentu=findParent(u,parent);
        int parentv=findParent(v,parent);
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

    static int  findParent(int u,int []parent)
    {
        if(u==parent[u])return u;
        return parent[u]=findParent(parent[u],parent);
    }

    static int spanningTree(int V, int E, int edges[][]){
        //sort edges according to weight
        Arrays.sort(edges,(a, b)->a[2]-b[2]);
        int parent[]=new int[V];
        int rank[]=new int[V];
        //initialize parent as itseelf at start
        for(int i=0;i<V;i++)parent[i]=i;
        int sum=0;
        for(int i=0;i<E;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            //if both does not have same parent then it suggest that it does not belong to same component
            if(findParent(u,parent)!=findParent(v,parent))
            {
                //then add weight
                sum+=edges[i][2];
                //connect those two edges
                connectByRank(u,v,rank,parent);
            }
        }
        return sum;

    }
}
