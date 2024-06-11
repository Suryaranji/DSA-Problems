package BitManipulations;

public class Bitmanipulation {


    public static int[] bitManipulation(int num, int i){


        /*
        Problem :
        * get ith bit.
        * set ith bit.
        * clear ith bit.
          32 bit signed num
          the ith bit may be over the number bits
          for eg: num=1 then set bit 24

          Approach:
          1) to get the bit right shift the num to i-1 bits then the ith bit reaches LSB then just & with 1 to get ith bit

          eg :

          11-1011-> right shift i-1 (i=2) then and with 1 which get 6

          2) set the ith bit
          right shift 1 by i-1 then | with num

          3) cleat ith bit
           right shift 1 by i-1 then ^ with result 2

           Time Complexity:O(1)
           Space Complexity:O(1)
         */
        int arr[]=new int[3];
        arr[0]=num>>(i-1)&1;
        arr[1]=1<<(i-1)|num;
        arr[2]=1<<(i-1)^arr[1];
        return arr;

    }
}
