package Recursion;

public class LargestNumberinKswaps {
    static String maxString="";
    public static  void getMax(char array[],int k,int index)
    {
        if(new String(array).compareTo(maxString)>0)
        {
            maxString=new String(array);

        }

        if(k==0)return ;

        for(int i=index;i<array.length-1;i++)
        {


            for(int j=i+1;j<array.length;j++)
            {
                //swap with greater on right hand side
                if(array[i]<array[j])
                {
                    char c=array[i];
                    array[i]=array[j];
                    array[j]=c;

                    getMax(array,k-1,i+1);
                    c=array[i];
                    array[i]=array[j];
                    array[j]=c;

                }

            }

        }

    }
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        char array[]=str.toCharArray();
        getMax(array,k,0);
        String answer=maxString;
        maxString="";
        return answer;
    }
}
