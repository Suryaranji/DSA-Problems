package ArraysProblem;

import java.util.ArrayList;

public class SeiveOfEratosthenes {
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        ArrayList<Integer> answer=new ArrayList<>();
        int arr[]=new int[N+1];
        /*
        Array to store prime numbers
        mark 1 for all element multiples
        */
        for(int i=2;i<=N;i++)
        {
            if(arr[i]==0)
            {
                answer.add(i);
                for(int j=i*i;j<=N;j+=i)/* starts with i^2 because the element lesser them are composite
                before hence they were already marked*/
                {
                    arr[j]=1;
                }
            }

        }
        return answer;
    }
}
