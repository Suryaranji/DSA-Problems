package ArraysProblem;

import java.util.Arrays;

public class DiagonalPattern {
    public static int[] matrixDiagonally(int[][] mat) {
        int top=0,left=0;
        int row=mat.length,col=mat[0].length;
        int count=0;
        int []answer=new int[row*col];
        boolean up=true;
        while(top<mat.length&&left<mat[0].length)
        {
            //upper
            if(up)
            {

                while(top>0&&left<col-1)
                {
                    answer[count++]=mat[top][left];
                    top--;
                    left++;
                }
                answer[count++]=mat[top][left];
                if(left<col-1)
                {
                    left++;
                }
                else
                {
                    top++;
                }
                up=false;
            }
            else
            {
                while(top<row-1&&left>0)
                {
                    answer[count++]=mat[top][left];
                    top++;
                    left--;
                }
                answer[count++]=mat[top][left];
                if(top<row-1)
                {
                    top++;
                }
                else
                {
                    left++;
                }
                up=true;
            }

        }
        return answer;

    }
    public static void main(String[] args) {
        int[][]mat={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

    }
}
