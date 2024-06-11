package BinarySearch;

public class Shipping {
    public int shipWithinDays(int[] weights, int days) {
        int first=1;
        int last=0;
        for(int i:weights)
        {
            last+=i;
            if(first<i)first=i;
        }
        int answer=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            int sum=0;
            int day=0;
            for(int weight:weights)
            {
                sum+=weight;
                if(sum>mid)
                {
                    day++;
                    sum=0;
                }
                sum+=weight;
            }
            if(sum>0)day++;
            if(day<=days)
            {
                answer=mid;
                last=mid-1;
            }
            else
            {
                first=mid+1;
            }
        }
        return answer;

    }
}
