package Graphs.bfsanddfs;

public class FloodFill {
    class Solution {

        public void dfs(int [][]image,int sr,int sc,int color,int prev){
            if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=prev){
                return ;
            }
            image[sr][sc]=color;
            int arr[][]={{0,1},{0,-1},{-1,0},{1,0}};
            for(int []i:arr){
                dfs(image,sr+i[0],sc+i[1],color,prev);
            }

        }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            dfs(image,sr,sc,color,image[sr][sc]);
            return image;

        }
    }

    public static void main(String[] args) {
        FloodFill f=new FloodFill();
        Solution s=f.new Solution();
        int image[][]={{1,1,1},{1,1,0},{1,0,1}};
        int sr=1;
        int sc=1;
        int color=2;
        int ans[][]=s.floodFill(image,sr,sc,color);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
