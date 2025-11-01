package Graphs.ConnectedComponents;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveStones {
    class DisJointSet{
        int parent[];
        int rank[];
        int size[];
        DisJointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }
        public int findUPar(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUPar(parent[node]);
        }
        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }


    public int removeStones(int[][] stones) {

        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisJointSet ds = new DisJointSet(maxRow + maxCol + 2);
        Map<Integer, Integer> parent = new HashMap<>();

        for (int stone[] : stones) {
            ds.unionBySize(stone[0], stone[1] + maxRow + 1);
            parent.put(stone[0], 1);
            parent.put(stone[1] + maxRow + 1, 1);

        }

        int components = 0;
        for (Map.Entry<Integer,Integer> entry : parent.entrySet()) {
            if(ds.findUPar(entry.getKey())==entry.getKey()){
                components++;
            }
        }
        return stones.length-components;
    }

    public static void main(String[] args) {
        RemoveStones obj=new RemoveStones();
        int stones[][]={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(obj.removeStones(stones));

        //we can use no of components to find the answer
        //to find no of components we can use dsu or dfs or bfs
        //ans=total stones-no of components
        //DSU approach
        //First we will create a parent array for rows and columns
        //Then we will iterate through the stones and for each stone we will find its parent in row and column
        //If both parents are null then we will create a new component
        //If one parent is null then we will assign the other parent to it
        //If both parents are not null then we will do nothing
        //Finally we will count the number of components by checking how many stones are their own parent
    }
}
