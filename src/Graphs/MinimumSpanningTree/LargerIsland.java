package Graphs.MinimumSpanningTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargerIsland {
    public static boolean isValid(int r,int c,int n,int m)

    {
        return r<0||c<0||r>=n||c>=m;
    }
    static int findParent(int u,int parent[])
    {
        if(u==parent[u])return u;
        return parent[u]=findParent(parent[u],parent);
    }
    public static  int connectBySize(int u,int v,int parent[],int size[])
    {
        int parentu=findParent(u,parent);
        int parentv=findParent(v,parent);
        if(parentu==parentv)return parentu;
        if(size[parentu]<size[parentv])
        {
            parent[parentu]=parentv;
            size[parentv]+=size[parentu];
        }
        else
        {
            parent[parentv]=parentu;
            size[parentu]+=size[parentv];
        }
        return 0;
    }
    public int largestIsland(int[][] grid) {

        int n=grid.length,m=grid[0].length;
        int parent[]=new int[n*m];
        int size[]=new int[n*m];
        Arrays.fill(size,1);
        for(int i=0;i<n*m;i++)parent[i]=i;
        int dir[][]={
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //connect all 1 component
                if(grid[i][j]==1)
                {
                    for(int k=0;k<4;k++)
                    {
                        int adjr=i+dir[k][0];
                        int adjc=j+dir[k][1];
                        if(isValid(adjr,adjc,n,m))continue;
                        if(grid[adjr][adjc]==1)
                        {
                            int u=i*m+j;
                            int v=adjr*m+adjc;
                            connectBySize(u,v,parent,size);
                        }
                    }
                }
            }
        }
        boolean flag=true;
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //check for zero and try to  find nearest 1 components and try to form larger component
                // set is used to detect same parent
                if(grid[i][j]==0)
                {
                    flag=false;
                    Set<Integer> set=new HashSet<>();
                    for(int k=0;k<4;k++)
                    {
                        int adjr=i+dir[k][0];
                        int adjc=j+dir[k][1];
                        if(isValid(adjr,adjc,n,m))continue;
                        if(grid[adjr][adjc]==1)
                        {
                            int v=adjr*m+adjc;
                            set.add(findParent(v,parent));
                        }
                    }
                    int temp=0;
                    for(int z:set)
                    {
                        temp+=size[z];
                    }
                    max=Math.max(max,temp+1);

                }
            }
        }
        if(flag)return n*m;
        return max;

    }
}
