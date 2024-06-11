package Graphs.ShortestDistance;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {
    /*
   Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position coordinates of Knight have been given according to 1-base indexing.



Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
   */
    class Pair{
        int col,row;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        //use bfs to traverse allpossible paths

        int possible[][]={
                {-2,1},
                {-2,-1},
                {-1,-2},
                {-1,2},
                {1,-2},
                {2,-1},
                {1,2},
                {2,1}
        };
        //store initial pos and mark visited
        boolean [][]vis=new boolean[N+1][N+1];
        vis[KnightPos[0]][KnightPos[1]]=true;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(KnightPos[0],KnightPos[1]));
        int steps=0;//kepp track of steps
        while(!queue.isEmpty())
        {
            //remove all from current steps
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                Pair temp=queue.remove();
                int sx=temp.row;
                int sy=temp.col;
                //if target reached return steps
                if(temp.row==TargetPos[0]&&temp.col==TargetPos[1])
                {
                    //System.out.println("Target  "+sy+" "+sx);
                    return steps;
                }
                //add all possible paths
                for(int j=0;j<8;j++)
                {

                    int newx=sx+possible[j][0];
                    int newy=sy+possible[j][1];
                    if(newx>0&&newx<=N&&newy>0&&newy<=N&&vis[newx][newy]==false)
                    {
                        // System.out.println(newy+" "+newx);
                        vis[newx][newy]=true;
                        queue.add(new Pair(newx,newy));
                    }
                }
            }
            steps++;
        }
        return -1;

    }
}
