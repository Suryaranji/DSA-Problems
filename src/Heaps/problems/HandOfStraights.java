package Heaps.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i:hand){
            queue.offer(i);
        }
        if(hand.length%groupSize!=0){
            return false;
        }
        int groups=0;
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int gSize=0;
            int previous=-1;
            while(gSize<groupSize&&!queue.isEmpty()){
                int current=queue.poll();
                if(previous==current){
                    temp.add(previous);
                    continue;
                }
                if(previous!=-1&&current-previous>1){
                    return false;
                }
                previous=current;
                gSize++;
            }
            if(gSize==groupSize){
                groups++;
            }
            queue.addAll(temp);
        }
        return groups==hand.length/groupSize;
    }
    /*public int withourPriority(int []hand,int groupSize){
        int startOffset=0;
        Arrays.sort(hand);
        if(hand.length%groupSize!=0){
            return false;
        }
        while(startOffset<hand.length()){
            int gSize=0;
            int previous=-1;
            while(gSize<groupSize&&!){
                int current=queue.poll();
                if(previous==current){
                    temp.add(previous);
                    continue;
                }
                if(previous!=-1&&current-previous>1){
                    return false;
                }
                previous=current;
                gSize++;
            }
            if(gSize==groupSize){
                groups++;
            }

        }*//*
    }*/
    public static void main(String[] args) {


    }
}
