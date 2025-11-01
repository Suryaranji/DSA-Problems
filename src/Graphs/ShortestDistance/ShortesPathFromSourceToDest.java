package Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortesPathFromSourceToDest {

    class State {
        int dest, time;

        State(int d, int t) {
            dest = d;
            time = t;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int[] mat : roads) {
            int src = mat[0];
            int dest = mat[1];
            int time = mat[2];
            dist[src][dest] = time;
            dist[dest][src] = time;
        }
        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        int distance = Integer.MAX_VALUE;
        int best[] = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[0] = 0;
        queue.add(new State(0, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.time < best[state.dest]) {
                best[state.dest] = state.time;
            }
            if (state.dest == n - 1) {
                if (distance > state.time) {
                    distance = state.time;
                    count = 0;
                }
                if (distance == state.time) {
                    count = (count + 1) % (10 ^ 9 + 7);
                }

            }
            for (int i = 0; i < n; i++) {
                int time = dist[state.dest][i] + state.time;
                if (dist[state.dest][i] != Integer.MAX_VALUE && time <= best[i]) {
                    queue.offer(new State(i, time));
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
        return count;

    }

    public int numberOfWaysToReachADestination(int n, int[][] roads) {

        //this approach fail for this case
        //[[0,1,5],[0,2,1],[1,3,1],[1,5,1],[2,3,2],[2,4,1],[3,4,1]]
        //expected 2 but got 4?
        //the reason is we are not updating the ways array when we find a better path to a node later
        //so changing lines to use Dijkstra's algorithm properly
        // the lines are one after calculating newDist in both if conditions are changed to update ways array properly
        //like ways[dest]=ways[src]; and ways[src]=ways[dest];
        int mod = (int) (1e9 + 7);
        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        queue.offer(new State(0, 0));
        while (!queue.isEmpty()) {
            State state = queue.poll();
            for (int[] road : roads) {
                int src = road[0];
                int dest = road[1];
                int time = road[2];
                if (src == state.dest) {
                    long newDist = dist[src] + time;
                    if (newDist < dist[dest]) {
                        dist[dest] = newDist;
                        ways[dest] = ways[src];
                        queue.offer(new State(dest, (int) newDist));
                    } else if (newDist == dist[dest]) {
                        ways[dest] = (ways[dest] + ways[src]) % mod;
                    }
                } else if (dest == state.dest) {
                    long newDist = dist[dest] + time;
                    if (newDist < dist[src]) {
                        dist[src] = newDist;
                        ways[src] = ways[dest];
                        queue.offer(new State(src, (int) newDist));
                    } else if (newDist == dist[src]) {
                        ways[src] = (ways[src] + ways[dest]) % mod;
                    }
                }
            }
        }
        return (int) (ways[n - 1] % mod);
    }
    public int modifiedApproach(int n, int[][] roads) {

        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads){
            int src=road[0];
            int dest=road[1];
            int time=road[2];
            adj.get(src).add(new int[]{dest,time});
            adj.get(dest).add(new int[]{src,time});
        }


        int mod = (int) (1e9 + 7);
        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        queue.offer(new State(0, 0));
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.time > dist[state.dest]) continue;
            for(int[] neighbor:adj.get(state.dest)){
                int dest=neighbor[0];
                int time=neighbor[1];
                long newDist = dist[state.dest] + time;
                if (newDist < dist[dest]) {
                    dist[dest] = newDist;
                    ways[dest] = ways[state.dest];
                    queue.offer(new State(dest, (int) newDist));
                } else if (newDist == dist[dest]) {
                    ways[dest] = (ways[dest] + ways[state.dest]) % mod;
                }
            }

        }
        return (int) (ways[n - 1] % mod);
    }

    public static void main(String[] args) {
        ShortesPathFromSourceToDest obj = new ShortesPathFromSourceToDest();
        int n = 7;
      //  int roads[][] = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
               // { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        // int ans=obj.countPaths(n,roads);
        //[[0,1,5],[0,2,1],[1,3,1],[1,5,1],[2,3,2],[2,4,1],[3,4,1]]
        int roads[][]={{0,1,5},{0,2,1},{1,3,1},{1,5,1},{2,3,2},{2,4,1},{3,4,1}};
        int ans = obj.modifiedApproach(6, roads);

        System.out.println(ans);
    }
}
