package Graphs.OtherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Bridges {

    private static int t=0;
    //Function to find if the given edge is a bridge in graph.
    static boolean dfs(int []time, int low[], ArrayList<ArrayList<Integer>> adj, int c, int d, int parent, int index)
    {
        time[index]=t;
        low[index]=t;
        t++;
        boolean flag=false;
        for(int i:adj.get(index))
        {
            //if parent discontinue
            if(i==parent)continue;
            //already visited upadate low of index
            if(time[i]!=-1)
            {

                low[index]=Math.min(low[index],time[i]);
            }
            else
            {
                //do dfs
                if(dfs(time,low,adj,c,d,index,i))return true;
                //update low
                low[index]=Math.min(low[index],low[i]);


            }
            if((index==c||index==d)&&(i==c||i==d)&&(low[i]>time[index]))
            {
                flag=true;
                break;
            }

        }
        return flag;
    }
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        int time[]=new int[V];
        Arrays.fill(time,-1);
        int low[]=new int[V];

        Arrays.fill(low,Integer.MAX_VALUE);
        for(int i=0;i<V;i++)
        {
            if(time[i]==-1)
            {
                if(dfs(time,low,adj,c,d,i,i))return 1;
            }
        }
        t=0;
        return 0;
    }
}
