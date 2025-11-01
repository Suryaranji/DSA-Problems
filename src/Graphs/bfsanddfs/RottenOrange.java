package Graphs.bfsanddfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    class Solution {
        class Pair{
            int row,col;
            Pair(int r,int c){
                this.row=r;
                this.col=c;
            }
        }
        public int orangesRotting(int[][] grid) {

            Queue<Pair> queue=new LinkedList<>();
            int n=grid.length;
            int m=grid[0].length;
            int [][]visited=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==2){
                        visited[i][j]=1;
                        queue.add(new Pair(i,j));
                    }
                }
            }

            int totalRotten=0;
            int minimumTime=0;
            int arr[][]={{1,0},{0,1},{-1,0},{0,-1}};
            while(!queue.isEmpty()){
                int size=queue.size();
                while(size>0){
                    size--;
                    Pair pair=queue.poll();
                    for(int[] i:arr){
                        int row=pair.row+i[0];
                        int col=pair.col+i[1];
                        if(row>=0&&col>=0&&row<n&&col<m&&visited[row][col]==0&&grid[row][col]==1){              visited[row][col]=1;
                            queue.add(new Pair(row,col));
                        }
                    }
                }
                if(!queue.isEmpty())    minimumTime++;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==0&&grid[i][j]==1){
                        return -1;
                    }
                }
            }
            return minimumTime;


        }
    }

    public static void main(String[] args) {
        RottenOrange obj=new RottenOrange();
        int grid[][]={{2,1,1},{1,1,0},{0,1,1}};
        Solution solution=obj.new Solution();
        int ans=solution.orangesRotting(grid);
        System.out.print(ans);
    }
}
