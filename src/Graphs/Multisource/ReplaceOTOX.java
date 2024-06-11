package Graphs.Multisource;

public class ReplaceOTOX {
    static void dfs(int row,int col,char a[][],int vis[][])
    {
        int dir[][]={
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        vis[row][col]=1;
        for(int i=0;i<dir.length;i++)
        {
            int newr=row+dir[i][0];
            int newc=col+dir[i][1];
            if(newr<0||newc<0||newr>=a.length||newc>=a[0].length)
            {
                continue;
            }
            if(vis[newr][newc]==0&&a[newr][newc]=='-')
            {
                dfs(newr,newc,a,vis);
            }
        }
        a[row][col]='O';


    }
    static char[][] fill(int n, int m, char a[][])
    {
        //modification of flood fill algorithm
        //here any 'o' which is on boundary and its followees are never gonna be x hence we convert them to O using dfs
        int vis[][]=new int[n][m];
        //initially convert all O to -
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='O')
                {
                    a[i][j]='-';
                }
            }
        }
        //traverse all boundarys and make - to O using dfs
        //row
        for(int i=0;i<m;i++)
        {
            if(a[0][i]=='-')dfs(0,i,a,vis);
            if(a[n-1][i]=='-')dfs(n-1,i,a,vis);

        }
        //col
        for(int i=0;i<n;i++)
        {
            if(a[i][0]=='-')dfs(i,0,a,vis);
            if(a[i][m-1]=='-')dfs(i,m-1,a,vis);

        }
        //inner - are always sorrounded by  x hence change to X
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='-')
                {
                    a[i][j]='X';
                }
            }
        }
        return a;

    }
}
