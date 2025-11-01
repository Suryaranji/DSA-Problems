package Graphs.ShortestDistance;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    class Solution {
        class IndexPair{
            int row,col,length;
            IndexPair(int r,int c,int l){
                row=r;
                col=c;
                length=l;
            }
            public String toString(){
                return "["+row+" "+col+" "+ length+"]";
            }
        }
        public int shortestPathBinaryMatrix(int[][] grid) {

            Queue<IndexPair> pairs=new LinkedList<>();
            if(grid[0][0]==0){
                pairs.add(new IndexPair(0,0,1));
            }
            int n=grid.length,m=grid[0].length;
            int [][]visited=new int[n][m];
            visited[0][0]=1;
            int arr[][]={{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
            int answer=-1;
            while(!pairs.isEmpty()){
                IndexPair temp=pairs.poll();
                if(temp.row==n-1&&temp.col==m-1){
                    answer=temp.length;
                    break;
                }
                for(int i=0;i<arr.length;i++){
                    int row=temp.row+arr[i][0];
                    int col=temp.col+arr[i][1];
                    if(row>=0&&row<n&&col>=0&&col<m&&visited[row][col]==0&&grid[row][col]==0){               pairs.add(new IndexPair(row,col,temp.length+1));
                        visited[row][col]=1;
                    }
                }
            }
            //0 0 0
            //1 0 0
            //1 1 0

            // 1
            // 2 2
            //2 3 3
            //3 3 3
            return answer;



        }
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix obj=new ShortestPathInBinaryMatrix();
        Solution sol=obj.new Solution();
        int grid[][]={{0,0,0},{1,0,0},{1,1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid));
    }
}
