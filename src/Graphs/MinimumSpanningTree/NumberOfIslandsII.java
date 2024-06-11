package Graphs.MinimumSpanningTree;

import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {

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

    static int  findParent(int u,int []parent)
    {
        if(u==parent[u])return u;
        return parent[u]=findParent(parent[u],parent);
    }
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {

        int parent[]=new int[n*m];
        int size[]=new int[n*m];
        //initialize parent as itseelf at start
        Arrays.fill(size,1);
        for(int i=0;i<n*m;i++)parent[i]=i;

        int island=0;
        int []answer=new int[q];
        //crerate visited to store already visited points
        int visited[][]=new int[n][m];
        for(int i=0;i<q;i++)
        {
            int dir[][]={
                    {1,0},
                    {-1,0},
                    {0,1},
                    {0,-1}
            };
            int row=queries[i][0],col=queries[i][1];
            int current=(row)*m+col;
            if(visited[row][col]==1)
            {
                answer[i]=island;
                continue;
            }
            visited[row][col]=1;
            island++;
            //search in all four directons
            for(int j=0;j<4;j++)
            {

                int adjr=queries[i][0]+dir[j][0],adjc=queries[i][1]+dir[j][1];
                int number=(adjr)*m+adjc;
                if(adjr<0||adjc<0||adjr>=n||adjc>=m)continue;
                //if any found check parents if both have same parent then leave else connect as single component
                if(visited[adjr][adjc]==1)
                {

                    if(findParent(current,parent)!=findParent(number, parent))
                    {
                        island--;
                        connectBySize(current, number, parent, size);

                    }

                }
            }
            answer [i]=island;
        }


        return answer;
    }

    public static void main(String[] args) {
        int n = 8, m = 6;
        int[][] operators = {  {6, 3},
                {5, 0},
                {3, 5},
                {5, 1},
                {3, 1},
                {6, 2},
                {1, 0},
                {2, 4},
                {1, 2},
                {3, 3},
                {7, 2},
                {2, 0},
                {0, 1},
                {4, 5},
                {2, 5},
                {1, 1},
                {4, 2},
                {0, 0},
                {6, 4},
                {5, 5},
                {7, 5},
                {0, 2},
                {4, 1},
                {2, 1},
                {6, 0},
                {4, 3},
                {3, 2}
        };


        int[] ans = numberOfIslandII(n, m, operators, operators.length);
        System.out.println("");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }
}