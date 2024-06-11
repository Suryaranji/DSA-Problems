package Graphs.MinimumSpanningTree;

import java.util.Arrays;

public class NumberOfPairs {
    /*
  The director of your college is planning to send 2 people to the ICPC regionals. He wants them to be from different branches. You will be given a list of pairs of student ids. Each pair is made of students from the same branch. Determine how many pairs of students from different branches they can choose from.

Example 1:
Input:
N=5
P=3
pairs[]={{0,1},
       {2,3},
       {0,4}}
Output:
6
Explanation:
Their are total five studets 0,1,2,3,4.
Students [0,1,4] are from same bracnh while
[2,3] are from a different one.So we can choose
different pairs like: [0,2],[0,3],[1,2],[1,3],
[4,2],[4,3]


Example 2:
Input:
N=4
P=1
pairs[]={{0,2}}
Output:
5
Explanation:
[0,1],[0,3],[2,1],[2,3] and [1,3] are all possible
pairs because [0,2],[1] and [3] all belongs to
different branches.
  */
    static int findParent(int u,int parent[])
    {
        //if the parent is same as the node which indicates that there  is no previous nodes hence it is top node
        if(u==parent[u])return u;
        //Doing Path compression means if there are any node which are going to  connect to component
        //then it ultimate parents is that node
        //eg 1-2-3 then 3 parent is 2 but ultimate parent is 1 hence  we assign that node as parent;
        return parent[u]=findParent(parent[u],parent);
    }
    public static  int connectBySize(int u,int v,int parent[],int size[])
    {
        int parentu=findParent(u,parent);
        int parentv=findParent(v,parent);
        //find each parent if both of them having same parent then return parent node
        if(parentu==parentv)return parentu;
        //else connect smaller component to larger component
        if(size[parentu]<size[parentv])
        {
            parent[parentu]=parentv;
            size[parentv]+=size[parentu];
        }
        else
        {
            //if equal then increase parent rank by one
            parent[parentv]=parentu;
            size[parentu]+=size[parentv];
        }
        return 0;
    }

    public static long numberOfPairs(int n, int P, int[][]g) {
        int parent[]=new int[n+1];
        for(int i=1;i<=n;i++)parent[i]=i;
        int []size=new int[n+1];
        Arrays.fill(size,1);
        //merge all connections
        for(int []con:g)
        {

            connectBySize(con[0],con[1],parent,size);
        }
        //find possible pairs
        long  ans = 0, total = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] ==i){
                ans += total*size[i];
                total += size[i];
            }
        }
        return ans;

    }
}
