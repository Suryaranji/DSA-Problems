package Heaps.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSheduling {

        public int usingPriorityQueue(char[] tasks, int n) {
            Map<Character,Integer> map=new HashMap<>();
            for(char c:tasks){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                    new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            maxHeap.addAll(map.entrySet());
            int time=0;
            while(!maxHeap.isEmpty()){
                Queue<Map.Entry<Character, Integer>> buffer = new LinkedList<>();
                int cycle = n + 1;
                int tasksDone = 0;

                // process up to n+1 tasks in this cycle
                for (int i = 0; i < cycle; i++) {
                    if (!maxHeap.isEmpty()) {
                        Map.Entry<Character, Integer> entry = maxHeap.poll();
                        if (entry.getValue() > 1) {
                            entry.setValue(entry.getValue() - 1);
                            buffer.add(entry);
                        }
                        tasksDone++;
                    }
                }

                // push remaining tasks back to heap
                maxHeap.addAll(buffer);

                // add time
                time += maxHeap.isEmpty() ? tasksDone : cycle;

            }
            return  time;

            //space complexity : o(26) for storing in map ~ O(1)
            //time complexity: O(task.length())

        }

        public int usingFrequencies(char tasks[],int n){

            int[] fMap=new int[26];
            for(char c:tasks){
                fMap[c-'A']++;
            }

            Arrays.sort(fMap);
            // if the last value is A and it repeated 3 and n=2
            //A _ _
            //A _ _
            //A _ _ In last we don't actually need this idle stat hence we need 4 which is multiplications of maxElement -1 and n

            int maxSlot=fMap[25]-1;
            int idleSlots=maxSlot*n;
            for(int i=24;i>=0;i--){
                idleSlots-=Math.min(fMap[i],maxSlot);
            }
            return idleSlots>0?idleSlots+tasks.length: tasks.length;
        }


    public static void main(String[] args) {
        TaskSheduling obj=new TaskSheduling();
       //char arr[]={'A','A','A','B','B','B','C','D','E','F','G','H','I','J','K'};
        char arr[]={'A','C','A','B','D','B'};
       // char arr[]={'A','A','A','B','B','B'};
        System.out.println(obj.usingPriorityQueue(arr,7));
        System.out.println(obj.usingFrequencies(arr,7));
    }

}
