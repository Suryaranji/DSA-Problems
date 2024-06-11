package Slidingwindow;

public class FruitsINTOBASKETS {
    /*
    *Input: fruits = [1,2,3,2,2]
    Output: 4
    Explanation: We can pick from trees [2,3,2,2].
    If we had started at the first tree, we would only pick from trees [1,2].
    Approach:
    .check if current element equals any of two  previous elements
     if equal increase currmax
     else set currenttmax equals to previous count+1(to current element)
     if current element equals previous last element then increment last count
     if not then update lastelement count=1;
     make swap elements secondlast->last->current

     */
    public int totalFruit(int[] fruits) {


        int last=-1;
        int secondLast=-1,currmax=0,lastcount=0;

        int maxFruits=0;
        for(int i:fruits)
        {
            //check if current element equals any of two  previous elements
            if(i==last||i==secondLast)
            {
                // if equal increase currmax
                currmax++;
            }
            else
            {
                //else set currenttmax equals to previous count+1(to current element)
                currmax=lastcount+1;
            }
            if(last==i)lastcount++;//if current element equals previous last element then increment last count
            else
            {
                //if not then update lastelement count=1;
                //make swap elements secondlast->last->current
                lastcount=1;
                secondLast=last;
                last=i;
            }
            maxFruits=Math.max(maxFruits,currmax);
        }




        return maxFruits;

    }
}
