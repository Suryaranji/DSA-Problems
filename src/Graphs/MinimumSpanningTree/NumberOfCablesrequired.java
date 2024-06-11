package Graphs.MinimumSpanningTree;

public class NumberOfCablesrequired {

    public int findParent(int u,int []parent)
    {
        if(u==parent[u])return  u;

        return parent[u]=findParent(parent[u],parent);
    }
    public void connectByRank(int u,int v,int parent[],int rank[])
    {
        int pv=findParent(v,parent);
        int pu=findParent(u,parent);
        if(pv==pu)return ;
        if(rank[pv]>rank[pu])
        {
            parent[pu]=pv;
        }
        else if(rank[pv]<rank[pu])
        {
            parent[pv]=pu;
        }
        else
        {
            parent[pv]=pu;
            rank[pu]++;
        }

    }
    public int makeConnected(int n, int[][] connections) {
        int parent[]=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        int rank[]=new int [n];
        int cables=0;
        for(int[] con:connections)
        {
            //connect all components
            int u=con[0];
            int v=con[1];
            if(findParent(u,parent)!=findParent(v,parent))
            {
                connectByRank(u,v,parent,rank);
            }
            else
            {
                cables++;
            }
        }
        int components=0;
        //check number of components
        for(int i=0;i<parent.length;i++)
        {
            if(parent[i]==i)components++;
        }
        //if components less than cables  then it is possible
        if(components-1<=cables)
        {
            return components-1;
        }

        return -1;

    }

}
