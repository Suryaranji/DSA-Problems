package Stack;

import java.util.Stack;

public class LargestAreaInHistogram {
    public  long getMaxArea(long hist[], long n)
    {
        long left[]=new long[(int) n];
        long right[]=new long[(int) n];
        Stack<Integer> stack=new Stack<>();
        //left smaller elements
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty()&&hist[i]<=hist[stack.peek()])stack.pop();
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        while(!stack.isEmpty())stack.pop();
        //System.out.println(Arrays.toString(left));
        //right smaller elements
        for(int i = (int) (n-1); i>=0; i--)
        {
            //
            while(!stack.isEmpty()&&hist[i]<=hist[stack.peek()])stack.pop();
            // System.out.println(stack.peek());
            right[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        //System.out.println(Arrays.toString(right));
        long max=0;
        //find width and height to area
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,hist[i]*(right[i]-left[i]-1));
        }
        return max;

    }
    public int maxArea(int M[][], int n, int m) {

        long arr[]=new long[m];
        for(int i=0;i<m;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                count+=M[j][i];
            }
            arr[i]=(long)count;
        }
        return (int) getMaxArea(arr,m);

    }
}
