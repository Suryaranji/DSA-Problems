package Graphs.ShortestDistance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    class Solution {
        class Pair{
            int row, col;
            Pair(int r, int col){
                this.row=r;
                this.col=col;
            }
        }
        public void nearest(int row,int col,int mat[][],int dp[][]){
            Queue<Pair> queue=new LinkedList<>();
            fillQueue(queue,row,col,mat,dp,1);
            int dist=1;
            while(!queue.isEmpty()){
                int size=queue.size();
                while(size>0){
                    Pair pair=queue.poll();
                    fillQueue(queue,pair.row,pair.col,mat,dp,dist+1);

                    size--;
                }
                dist++;
            }
        }
        public void fillQueue(Queue<Pair> queue,int row,int col,int mat[][],int dp[][],int dist){
            //left
            if(col-1>=0&&mat[row][col-1]==1&&dp[row][col-1]>dist){
                queue.offer(new Pair(row,col-1));
                dp[row][col-1]=dist;
            }
            //right
            if(col+1<mat[0].length&&mat[row][col+1]==1&&dp[row][col+1]>dist){
                queue.offer(new Pair(row,col+1));
                dp[row][col+1]=dist;
            }
            //down
            if(row+1<mat.length&&mat[row+1][col]==1&&dp[row+1][col]>dist){
                queue.offer(new Pair(row+1,col));
                dp[row+1][col]=dist;
            }
            //up
            if(row-1>=0&&mat[row-1][col]==1&&dp[row-1][col]>dist){
                queue.offer(new Pair(row-1,col));
                dp[row-1][col]=dist;
            }


        }
        public int[][] updateMatrix(int[][] mat) {
            int n=mat.length;
            int m=mat[0].length;
            int dp[][]=new int[n][m];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],Integer.MAX_VALUE);
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(mat[i][j]==0){
                        dp[i][j]=0;
                        nearest(i,j,mat,dp);
                    }
                }
            }
            return dp;
            //  System.out.println(Arrays.deepToString(dp));
            // [[1,0,1,1,0,0,1,0,0,1],
            // [0,1,1,0,1,0,1,0,1,1],
            // [0,0,1,0,1,0,0,1,0,0],
            // [1,0,1,0,1,1,1,1,1,1],
            // [0,1,0,1,1,0,0,0,0,1],
            // [0,0,1,0,1,1,1,0,1,0],
            // [0,1,0,1,0,1,0,0,1,1],
            // [1,0,0,0,1,1,1,1,0,1],
            // [1,1,1,1,1,1,1,0,1,0],
            // [1,1,1,1,0,1,0,0,1,1]]

            //answer
            // [4,3,2,1,0,1,0,0,1,1]

        }
        class NewPair{
            int row,col,dist;
            NewPair(int r,int c,int d){
                this.row=r;
                this.col=c;
                this.dist=d;
            }
        }
        public int [][] optimized(int mat[][]){
            int dp[][]=new int[mat.length][mat[0].length];
            for(int i=0;i<mat.length;i++){
                Arrays.fill(dp[i],Integer.MAX_VALUE);
            }
            Queue<NewPair> queue=new LinkedList<>();
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(mat[i][j]==0){
                        dp[i][j]=0;
                        queue.offer(new NewPair(i,j,0));
                    }
                }
            }
            while(!queue.isEmpty()){
                NewPair pair=queue.poll();
                int row=pair.row;
                int col=pair.col;
                int dist=pair.dist;
                //left
                if(col-1>=0&&mat[row][col-1]==1&&dp[row][col-1]>dist+1){
                    queue.offer(new NewPair(row,col-1,dist+1));
                    dp[row][col-1]=dist+1;
                }
                //right
                if(col+1<mat[0].length&&mat[row][col+1]==1&&dp[row][col+1]>dist+1){
                    queue.offer(new NewPair(row,col+1,dist+1));
                    dp[row][col+1]=dist+1;
                }
                //down
                if(row+1<mat.length&&mat[row+1][col]==1&&dp[row+1][col]>dist+1){
                    queue.offer(new NewPair(row+1,col,dist+1));
                    dp[row+1][col]=dist+1;
                }
                //up
                if(row-1>=0&&mat[row-1][col]==1&&dp[row-1][col]>dist+1){
                    queue.offer(new NewPair(row-1,col,dist+1));
                    dp[row-1][col]=dist+1;
                }
            }
            return dp;
        }

    }



    public static void main(String[] args) {
        Matrix01 obj=new Matrix01();
        int mat[][]={{0,0,0},{0,1,0},{1,1,1}};
      //  int ans[][]=obj.new Solution().updateMatrix(mat);
        int ans[][]=obj.new Solution().optimized(mat);
        System.out.println(Arrays.deepToString(ans));
    }
}
